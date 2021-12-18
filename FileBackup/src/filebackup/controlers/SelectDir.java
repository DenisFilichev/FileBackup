/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filebackup.controlers;

import filebackup.model.Profile;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;

/**
 *
 * @author denis
 */
public class SelectDir implements ActionListener{
    private Profile profile;
    JFrame frame;
    public static final String origDir = "origDir";
    public static final String copyDir = "copyDir";
    String typeDir;
    
    public SelectDir(JFrame frame, Profile profile, String typeDir){
        this.profile = profile;
        this.typeDir = typeDir;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        profile = new Profile("Denis");
        File file;
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int res = fileChooser.showDialog(frame, "Select");
        if(res == JFileChooser.APPROVE_OPTION){
            file = fileChooser.getSelectedFile();
            switch (typeDir){
                case copyDir: profile.setCopyPath(file.getAbsolutePath());
                break;
                case origDir: profile.setOrigPath(file.getAbsolutePath());
                break;
            }
            profile.updateProfile();
        }
        for(Profile p : Profile.getListProfile()){
            System.out.println(p);
        }
    }
}
