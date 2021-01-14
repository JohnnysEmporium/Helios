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
    int top;
    int left;
    int bottom;
    int right;
    int thicknessReleased;
    public ButtonsListener(JButton b, Color mousePressedColor, Color mouseReleasedColor){
        btn = b;
        mousePressedColor_ = mousePressedColor;
        mouseReleasedColor_ = mouseReleasedColor;
        top = 5;
        left = 10;
        bottom = 5;
        right = 10;
        thicknessReleased = 5;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        btn.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(mousePressedColor_, 5),
                BorderFactory.createEmptyBorder(
                        top - thicknessReleased,
                        left - thicknessReleased,
                        bottom - thicknessReleased,
                        right - thicknessReleased
                )));
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
        btn.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(mouseReleasedColor_, 1),
                BorderFactory.createEmptyBorder(top, left, bottom, right)));
    }
}
