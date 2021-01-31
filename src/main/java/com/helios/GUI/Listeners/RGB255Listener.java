package com.helios.GUI.Listeners;

import com.helios.connection.YeelightAPI;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

//DocumentListener custom class
//Prevents entering value higher than 255 in text fields
//Changes the color of rgbColorLabel to match given rgb values
//Put into inner class to avoid code repetition
public class RGB255Listener implements DocumentListener {
    YeelightAPI.RGB rgb_;
    JTextField textField_;
    JLabel rgbColorLabel_;

    public RGB255Listener(JTextField textField, JLabel rgbColorLabel){
        rgb_ = new YeelightAPI.RGB();
        textField_ = textField;
        rgbColorLabel_ = rgbColorLabel;
    }

    //Change label color depending on which text field got changed
    private void changeLabelColor(){
        Color temp = rgbColorLabel_.getBackground();
        String name = textField_.getName();
        if(name.equals("r")){
            rgbColorLabel_.setBackground(new Color(Integer.parseInt(textField_.getText()), temp.getGreen(), temp.getBlue()));
        } else if(name.equals("g")){
            rgbColorLabel_.setBackground(new Color(temp.getRed(), Integer.parseInt(textField_.getText()), temp.getBlue()));
        } else if(name.equals("b")){
            rgbColorLabel_.setBackground(new Color(temp.getRed(), temp.getGreen(), Integer.parseInt(textField_.getText())));
        }
        temp = rgbColorLabel_.getBackground();
        rgb_.setRGB(temp.getRed(), temp.getGreen(), temp.getBlue(), "sudden", 0);
    }

    //Check if value inside the field is over 255, if is, insert 255
    //Additionally change label color each time value is inserted
    @Override
    public void insertUpdate(DocumentEvent e) {
        if (Integer.parseInt(textField_.getText()) > 255) {
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    textField_.setText("255");
                    changeLabelColor();
                }
            };
            SwingUtilities.invokeLater(r);
        } else {
            changeLabelColor();
        }

    }
    @Override
    public void removeUpdate(DocumentEvent e) {
        //changeLabelColor();
    }
    @Override
    public void changedUpdate(DocumentEvent e) {

    }
}
