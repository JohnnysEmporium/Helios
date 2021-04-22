package com.helios.GUI.CustomInterfaceItems;

import com.helios.connection.YeelightAPI;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


//TODO: Refactor other classes that make change to the bulb (interfaceitems in HeliosInterface)
public class Slider extends JSlider {

    YeelightAPI.Bright bright;
    YeelightAPI.ColorTemp colorTemp;

    public Slider(int minVal, int maxVal, String name, Color foreground, Color background){
        super(minVal, maxVal);
        setName(name);
        setBackground(background);
        setForeground(foreground);
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {push();}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });

        bright = new YeelightAPI.Bright();
        colorTemp = new YeelightAPI.ColorTemp();
    }

    public void push(){
        int val = this.getValue();
        if(val > 100){
            colorTemp.setColorTemp(val, "sudden", 0);
        } else {
            bright.setBright(val, "sudden", 0);
        }
    }



}
