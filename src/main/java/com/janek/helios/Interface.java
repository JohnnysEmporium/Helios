package com.janek.helios;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.UIManager;

public class Interface extends JFrame{
    static TrayIcon trayIcon;
    static SystemTray tray;
    static PopupMenu popup;


    Interface(String title){
        super(title);
        System.out.println("creating instance");
        try{
            System.out.println("setting look and feel");
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch(Exception e){
            System.out.println("Unable to set LookAndFeel");
        }
        if(SystemTray.isSupported()){
            System.out.println("system tray supported");
            tray=SystemTray.getSystemTray();

            //Perform actions on exit
            ActionListener exitListener=new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Exiting....");
                    System.exit(0);
                }
            };

            //Create Menu
            popup=new PopupMenu();

            //Create items in the menu
            MenuItem defaultItem=new MenuItem("Exit");
            defaultItem.addActionListener(exitListener);
            popup.add(defaultItem);

            defaultItem=new MenuItem("Open");
            defaultItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    setVisible(true);
                    setExtendedState(JFrame.NORMAL);
                }
            });
            popup.add(defaultItem);

        }else{
            System.out.println("system tray not supported");
        }
        addWindowStateListener(new WindowStateListener() {
            public void windowStateChanged(WindowEvent e) {
                if(e.getNewState()==ICONIFIED){
                    try {
                        tray.add(trayIcon);
                        setVisible(false);
                        System.out.println("added to SystemTray");
                    } catch (AWTException ex) {
                        System.out.println("unable to add to tray");
                    }
                }
                if(e.getNewState()==7){
                    try{
                        tray.add(trayIcon);
                        setVisible(false);
                        System.out.println("added to SystemTray");
                    }catch(AWTException ex){
                        System.out.println("unable to add to system tray");
                    }
                }
                if(e.getNewState()==MAXIMIZED_BOTH){
                    tray.remove(trayIcon);
                    setVisible(true);
                    System.out.println("Tray icon removed");
                }
                if(e.getNewState()==NORMAL){
                    tray.remove(trayIcon);
                    setVisible(true);
                    System.out.println("Tray icon removed");
                }
            }
        });
        setIconImage(Toolkit.getDefaultToolkit().getImage("Duke256.png"));

        setVisible(true);
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private static void setTrayIcon(String filepath){
        tray=SystemTray.getSystemTray();
        Image image=Toolkit.getDefaultToolkit().getImage(filepath);
        trayIcon=new TrayIcon(image, "SystemTray Demo", popup);
        trayIcon.setImageAutoSize(true);
    }

    private void setInterfaceItems(){
        MenuItem mi;

        System.out.println("creating instance");
        try {
            System.out.println("setting look and feel");
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("Unable to set LookAndFeel");
        }
        if (SystemTray.isSupported()) {
            System.out.println("system tray supported");
            popup = new PopupMenu();
        }

        //Exit instantly on click
        mi = new MenuItem("Exit");
        mi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Exiting....");
                System.exit(0);
            }
        });
        popup.add(mi);

        mi=new MenuItem("Open");
        mi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(true);
                setExtendedState(JFrame.NORMAL);
            }
        });
        popup.add(mi);





    }

    public static void main(String[] args){
        new Interface("Helios v0.1");
    }
}