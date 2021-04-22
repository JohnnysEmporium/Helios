package com.helios.GUI.Listeners;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import com.helios.GUI.CustomInterfaceItems.TextField;
/*
DocumentListener custom class
Prevents entering value higher than 255 in text fields
Changes the color of rgbColorLabel to match given rgb values
 */
public class RGB255Listener implements DocumentListener {
    TextField textField_;
    JLabel rgbColorLabel_;

    public RGB255Listener(TextField textField, JLabel rgbColorLabel){
        textField_ = textField;
        rgbColorLabel_ = rgbColorLabel;
    }

    //Change label color depending on which text field got changed
    void changeLabelColor(){
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
        textField_.push(temp.getRed(), temp.getGreen(), temp.getBlue());
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
