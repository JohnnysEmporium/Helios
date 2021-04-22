package com.helios.GUI.CustomInterfaceItems;

import com.helios.connection.YeelightAPI;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;

public class TextField extends JTextField {
    YeelightAPI.RGB rgb;

    public TextField(String name, Color foreground, Color background){
        setName(name);
        setForeground(foreground);
        setBackground(background);
        setDocument(new TextFieldLimit());

        rgb = new YeelightAPI.RGB();
    }

    public void push(int r, int g, int b){
        rgb.setRGB(r, g, b,"sudden", 0);
    }

    //Limits the number of characters that can fit in textField
    private class TextFieldLimit extends PlainDocument{
        @Override
        public void insertString( int offset, String  str, AttributeSet attr ) throws BadLocationException {
            int limit = 3;

            if (str == null) return;

            //Accept only ints
            try{
                Integer.parseInt(str);
            } catch (Exception e){
                super.remove(offset, 1);
            }

            //Only 3 characters long
            if((getLength() + str.length()) <= limit) {
                super.insertString(offset, str, attr);
            }

        }
    }

}
