/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filebackup;

import filebackup.views.MainFrame;
import filebackup.model.*;
import java.util.List;

/**
 *
 * @author denis
 */
public class FileBackup {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        
        List<Profile> list = Profile.getListProfile();
        //Profile profile = new Profile();
        //System.out.println(profile);
        //profile.addProfile();
        list = Profile.getListProfile();
        System.out.println("List = " + list);
    }
    
}
