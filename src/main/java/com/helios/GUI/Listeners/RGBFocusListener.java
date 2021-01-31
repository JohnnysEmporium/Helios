package com.helios.GUI.Listeners;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class RGBFocusListener implements FocusListener {
    private JTextField textField_;

    public RGBFocusListener(JTextField textField){
        textField_ = textField;
    }

    @Override
    public void focusGained(FocusEvent e) {

    }

    @Override
    public void focusLost(FocusEvent e) {
        if(textField_.getText().equals("")){
            textField_.setText("0");
        }
    }
}
