/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filebackup.views;

import filebackup.controlers.*;
import filebackup.model.Profile;
import java.awt.*;
import java.awt.event.*;
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
        
        setJMenuBar(menubar());
    }
    
    private JMenuBar menubar(){
        JMenuBar bar = new JMenuBar();
        add(bar);
        JMenu menu = new JMenu("Tools");
        bar.add(menu);
        JMenuItem item1 = new JMenuItem("set origDir");
        menu.add(item1);
        item1.addActionListener(new SelectDir(this, null, SelectDir.origDir));
        JMenuItem item2 = new JMenuItem("set copyDir");
        menu.add(item2);
        item2.addActionListener(new SelectDir(this, null, SelectDir.copyDir));
        return bar;
    }
}
