package com.helios.GUI;

import javax.swing.text.PlainDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;

public class JTextFieldLimit extends PlainDocument {
    private int limit;

    JTextFieldLimit(int limit) {
        super();
        this.limit = limit;
    }

    public void insertString( int offset, String  str, AttributeSet attr ) throws BadLocationException {
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