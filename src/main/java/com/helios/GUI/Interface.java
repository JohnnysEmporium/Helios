package com.helios.GUI;


import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.UIManager;

//TO DO: DIVIDE CLASSES BETWEEN POPUPMENU AND JFRAME

public class Interface extends JFrame{
    static TrayIcon trayIcon;
    static SystemTray tray;
    static PopupMenu popup;


    Interface(String title){
        super(title);
        MainFrame panel = new MainFrame();
        setInterfaceItems();
        setWindowListeners();
        setTrayIcon("images/bulb.gif");
        add(panel);
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
        }else{
            System.out.println("system tray not supported");
        }

        //Exit instantly on Exit button
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

    private void setWindowListeners(){
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
    }

    public static void main(String[] args){
        new Interface("Helios v0.1");
    }
}