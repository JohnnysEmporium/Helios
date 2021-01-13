package com.helios.GUI.Listeners;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//MouseAdapter custom class
//Changes button border when clicked, then back to default when released
//Gives buttons the "push" look
public class ButtonsListener extends MouseAdapter {
    JButton btn;
    Color mousePressedColor_;
    Color mouseReleasedColor_;
    public ButtonsListener(JButton b, Color mousePressedColor, Color mouseReleasedColor){
        btn = b;
        mousePressedColor_ = mousePressedColor;
        mouseReleasedColor_ = mouseReleasedColor;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        btn.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(mousePressedColor_, 5),
                BorderFactory.createEmptyBorder(1, 6, 1, 6)));
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
        btn.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(mouseReleasedColor_, 1),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)));
    }
}
