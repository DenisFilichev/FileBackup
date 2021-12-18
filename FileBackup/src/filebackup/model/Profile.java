/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filebackup.model;

import java.io.*;
import java.util.*;

/**
 *
 * @author denis
 */
public class Profile implements Serializable{
    private static File file;
    private String name;
    private int id;
    private String origPath;
    private String copyPath;
    private static ArrayList<Profile> listProfile = new ArrayList<>();
    
    static{
        file = new File("profile.prop");
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {}
        }
        System.out.println(file.getAbsolutePath());
        if(file.canRead()){
            try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));){
                Object temp = objectInputStream.readObject();
                if (temp!=null && (temp instanceof ArrayList))
                    listProfile = (ArrayList)temp;
            }   catch (IOException | ClassNotFoundException ex) {}
        }
    }
    
    public Profile (){
        setId();
        listProfile.add(this);
        writeListProfile();
    }
    
    public Profile (String name){
        this();
        this.name = name;
    }
    
    public Profile(String name, String origPath, String copyPath) {
        this();
        this.origPath = origPath;
        this.copyPath = copyPath;
    }
    
    public void deleteProfile(){
        listProfile.remove(this);
        writeListProfile();
    }
    
    public void addProfile(){
        listProfile.add(this);
        writeListProfile();
    }
    
    public void updateProfile(){
        writeListProfile();
    }
    
    private void writeListProfile(){
        if (file.canWrite()){
            try(FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(fos)){
                oos.writeObject(listProfile);
                oos.flush();
            }catch (IOException io){}
        }
    }
    
    public static List<Profile> getListProfile(){
        return (List)listProfile.clone();
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    private void setId() {
        int id = new Random().nextInt(100000);
        if(listProfile!=null && !listProfile.isEmpty()){
            for(Profile profile : listProfile){
                if(profile.getId()==id)setId();
            }
        }
        this.id = id;
    }

    public String getOrigPath() {
        return origPath;
    }

    public void setOrigPath(String origPath) {
        this.origPath = origPath;
    }

    public String getCopyPath() {
        return copyPath;
    }

    public void setCopyPath(String copyPath) {
        this.copyPath = copyPath;
    }

    @Override
    public String toString() {
        return "Profile{" + "name=" + name + ", id=" + id + ", origPath=" + origPath + ", copyPath=" + copyPath + '}';
    }
    
    
}
