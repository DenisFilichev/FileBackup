/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filebackup.views;

import filebackup.controlers.*;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

/**
 *
 * @author denis
 */
public class MainFrame extends JFrame{
    AppProperties appProperties;
    
    public MainFrame(){
         super("File backup");
         
         appProperties = AppProperties.getAppProperties();
         
         initFrame();
         
         
        
         setVisible(true);
    }
    
    private void initFrame(){
        int width = Integer.parseInt(appProperties.getValue("width", "800"));
        int height = Integer.parseInt(appProperties.getValue("height", "600"));
        setSize(width, height);
        int locationX = Integer.parseInt(appProperties.getValue("locationX", "50"));
        int locationY = Integer.parseInt(appProperties.getValue("locationY", "50"));
        setLocation(locationX, locationY);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                appProperties.setProperty("width", Integer.toString(getWidth()));
                appProperties.setProperty("height", Integer.toString(getHeight()));
                appProperties.setProperty("locationX", Integer.toString(getX()));
                appProperties.setProperty("locationY", Integer.toString(getY()));
                dispose();
            }
        });
    }
}
