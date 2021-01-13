package com.helios.GUI.Listeners;

import com.helios.connection.YeelightAPI;

import javax.swing.*;
import java.awt.event.*;

public class SliderListener implements MouseListener {
    YeelightAPI.Bright bright;
    YeelightAPI.ColorTemp colorTemp;
    Action arrowLeft;
    Action arrowRight;
    JSlider slider_;
    JLabel label_;
    KeyStroke ksLeft;
    KeyStroke ksRight;
    InputMap im;

    public SliderListener(JSlider slider, JLabel label){
        slider_ = slider;
        label_ = label;
        bright = new YeelightAPI.Bright();
        colorTemp = new YeelightAPI.ColorTemp();
        arrowKeysAlteration();
    }
    public SliderListener(JSlider slider){
        slider_ = slider;
        bright = new YeelightAPI.Bright();
        colorTemp = new YeelightAPI.ColorTemp();
        arrowKeysAlteration();
    }

    //TODO: move arrow keys alteration outta here, it runs multiple times unnecessairly
    private void arrowKeysAlteration(){
        ksLeft = KeyStroke.getKeyStroke("LEFT");
        ksRight = KeyStroke.getKeyStroke("RIGHT");
        im = slider_.getInputMap();
        arrowLeft = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                subtraction();
            }
        };
        arrowRight = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addition();
            }
        };

        slider_.getActionMap().put(im.get(ksLeft), arrowLeft);
        slider_.getActionMap().put(im.get(ksRight), arrowRight);
    }

    private void subtraction(){
        if(slider_.getName().equals("brightness")) {
            slider_.setValue(slider_.getValue() - 1);
            label_.setText(slider_.getValue() + "%");
            bright.setBright(slider_.getValue(), "sudden", 0);
        } else if(slider_.getName().equals("ct")) {
            colorTemp.setColorTemp(slider_.getValue(), "sudden", 0);
        }
    }

    private void addition(){
        if(slider_.getName().equals("brightness")) {
            slider_.setValue(slider_.getValue() + 1);
            label_.setText(slider_.getValue() + "%");
            bright.setBright(slider_.getValue(), "sudden", 0);
        } else if(slider_.getName().equals("ct")) {
            colorTemp.setColorTemp(slider_.getValue(), "sudden", 0);
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(slider_.getName().equals("brightness")) {
            label_.setText(slider_.getValue() + "%");
            bright.setBright(slider_.getValue(), "sudden", 0);
        } else if(slider_.getName().equals("ct")) {
            colorTemp.setColorTemp(slider_.getValue(), "sudden", 0);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
