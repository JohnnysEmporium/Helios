package com.helios.GUI.Listeners;

import com.helios.GUI.CustomInterfaceItems.TextField;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/*
Custom FocusListener class
 */

public class RGBFocusListener extends RGB255Listener implements FocusListener {

    public RGBFocusListener(TextField textField, JLabel rgbColorLabel){
        super(textField, rgbColorLabel);
    }

    @Override
    public void focusGained(FocusEvent e) {

    }

    //On focusLost event, check if text field is empty and change label color
    @Override
    public void focusLost(FocusEvent e) {
        if(super.textField_.getText().equals("")){
            super.textField_.setText("0");
        }
        changeLabelColor();
    }
}
