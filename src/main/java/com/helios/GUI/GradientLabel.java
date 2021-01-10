package com.helios.GUI;

import javax.swing.*;
import java.awt.*;

public class GradientLabel extends JLabel {

    public GradientLabel(){
        setForeground(Color.WHITE);
        setHorizontalAlignment(CENTER);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        LinearGradientPaint lgp = new LinearGradientPaint(
                new Point(0, 0),
                new Point(getWidth(), 0),
                new float[]{0f, 1f},
                new Color[]{Color.WHITE, Color.ORANGE});
        g2d.setPaint(lgp);
        g2d.fill(new Rectangle(0, 0, getWidth(), getHeight()));
        g2d.dispose();
        super.paintComponent(g);
    }
}
