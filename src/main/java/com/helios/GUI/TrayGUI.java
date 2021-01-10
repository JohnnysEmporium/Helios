package com.helios.GUI;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//TO DO: DIVIDE CLASSES BETWEEN POPUPMENU AND JFRAME

public class TrayGUI extends JFrame {
    Rectangle screen = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
    TrayIcon trayIcon;
    SystemTray tray;
    int width = 260;
    int height = 450;
    HeliosInterface gui;
    PopupMenu popup;

    public TrayGUI(){
        super("Helios v0.1");
        MenuItem mi;

        //SET JFRAME ICON
        setIconImage(new ImageIcon("images/ico.jpg").getImage());


        //SET LOOK AND FEEL, CREATE TRAY IF SUPPORTED
        try {
            System.out.println("setting look and feel");
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            System.out.println("Unable to set LookAndFeel");
        }
        if (SystemTray.isSupported()) {
            //SET TRAY AND TRAY ICON
            System.out.println("system tray supported");
            popup = new PopupMenu();
            tray=SystemTray.getSystemTray();
            Image image=Toolkit.getDefaultToolkit().getImage("images/ico.jpg");
            trayIcon=new TrayIcon(image, "SystemTray Demo", popup);
            trayIcon.setImageAutoSize(true);
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

        //Open GUI
        mi=new MenuItem("Open");
        mi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(true);
                setExtendedState(JFrame.NORMAL);
            }
        });
        popup.add(mi);

        //SET TRAY LISTENERS
        {
            trayIcon.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getButton() == MouseEvent.BUTTON1) {
                        openFromTray();
                    }
                }
            });
        }


        //SET WINDOW STATE LISTENERS
        {
            addWindowStateListener(new WindowStateListener() {
                //TRAY LISTENERS
                @Override
                public void windowStateChanged(WindowEvent e) {
                    if (e.getNewState() == ICONIFIED) {
                        hideToTray();
                    }
                    if (e.getNewState() == 7) {
                        hideToTray();
                    }
                    if (e.getNewState() == MAXIMIZED_BOTH) {
                        openFromTray();
                    }
                    if (e.getNewState() == NORMAL) {
                        openFromTray();
                    }
                }
            });

            //ALTER DEFAULT CLOSE OPERATION - HIDE TO TRAY
            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    hideToTray();
                }
            });
        }


        //SIZE AND LOCATION
        setMaximumSize(new Dimension(width, height));
        setMinimumSize(new Dimension(width, height));
        setLocation(screen.width - width + 8, screen.height - height + 8);


        //SHOW THE FRAME
        gui = new HeliosInterface();
        add(gui, BorderLayout.CENTER);
        setVisible(true);
        setState(ICONIFIED);
     }


    private void hideToTray(){
        try {
            setAlwaysOnTop(false);
            tray.add(trayIcon);
            setVisible(false);
            System.out.println("added to SystemTray");
        } catch (AWTException ex) {
            System.out.println("unable to add to tray");
        }
    }

    private void openFromTray(){
        tray.remove(trayIcon);
        setVisible(true);
        setExtendedState(NORMAL);
        setAlwaysOnTop(true);
        System.out.println("Tray icon removed");
    }

    public static void main(String[] args){
        TrayGUI t = new TrayGUI();
    }

}