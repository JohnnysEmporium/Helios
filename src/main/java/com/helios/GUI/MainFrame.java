package com.helios.GUI;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class MainFrame extends JPanel {
    JPanel panel = new JPanel(new MigLayout("wrap 1"));

    public MainFrame(){
        JRadioButton radio = new JRadioButton("23424536456451");
        panel.add(radio);
    }
}
