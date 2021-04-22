package com.helios.GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.helios.GUI.CustomInterfaceItems.GradientLabel;
import com.helios.GUI.CustomInterfaceItems.TextField;
import com.helios.GUI.CustomInterfaceItems.Slider;
import com.helios.GUI.Listeners.RGBFocusListener;
import com.helios.GUI.Listeners.ButtonsListener;
import com.helios.GUI.Listeners.RGB255Listener;
import com.helios.connection.YeelightAPI;
import net.miginfocom.swing.*;

/**
 * @author unknown
 */
/*
IMPORTANT
It's crucial for all items that have names set to have names set.
Names are being referred to later on in Listeners.
 */

public class HeliosInterface extends JPanel {
    public HeliosInterface() {
        initComponents();
    }

    private void initComponents() {

        //Initialize Yeelight API components
        yAPI = new YeelightAPI(0);
        power = new YeelightAPI.Power();
        colorTemp = new YeelightAPI.ColorTemp();
        flow = new YeelightAPI.Flow();
        System.out.println("YeelightAPI components initiated");

        //Initizlize GUI components
        checkBoxPanel = new JPanel();
        offCheckBox = new JCheckBox();
        rainbowCheckBox = new JCheckBox();
        rgbPanel = new JPanel();
        rLabel = new JLabel();
        gLabel = new JLabel();
        bLabel = new JLabel();
        rTextField = new TextField("r", mainForegroundColor, mainBackgroundColor);
        gTextField = new TextField("g", mainForegroundColor, mainBackgroundColor);
        bTextField = new TextField("b", mainForegroundColor, mainBackgroundColor);
        rgbColorLabel = new JLabel();
        ctPanel = new JPanel();
        ctLabel = new JLabel();
        ctSlider = new Slider(1700,6500, "ct", mainForegroundColor, mainBackgroundColor);
        ctGradient = new GradientLabel();
        brightnessPanel = new JPanel();
        brightnessLabel = new JLabel();
        brightnessSlider = new Slider(1,100, "bright", mainForegroundColor, mainBackgroundColor);
        brightnessPercentageLabel = new JLabel();
        actionPanel = new JPanel();
        saveButton = new JButton();
        discardButton = new JButton();
        cancelButton = new JButton();
        mainBackgroundColor = new Color(60, 63, 66);
        mainForegroundColor = new Color(188, 188, 188);
        buttonPressedColor = new Color(35,35,35);
        System.out.println("HeliosInterface components initiated");

        //======== this ========
        setMaximumSize(new Dimension(360, 550));
        setMinimumSize(new Dimension(260, 450));
        setBackground(mainBackgroundColor);
        setForeground(mainForegroundColor);
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing.
                border. EmptyBorder( 0, 0, 0, 0) , "", javax. swing. border. TitledBorder. CENTER
                , javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("D\u0069al\u006fg" ,java .awt .Font
                .BOLD ,12 ), java. awt. Color. red) , getBorder( )) );  addPropertyChangeListener (
                new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062or\u0064er"
                        .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );
        setLayout(new MigLayout(
                "fill,novisualpadding,align center center",
                // columns
                "[fill]",
                // rows
                "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]"));

        //======== checkBoxPanel ========
        {
            checkBoxPanel.setBackground(mainBackgroundColor);
            checkBoxPanel.setForeground(mainForegroundColor);
            checkBoxPanel.setLayout(new MigLayout(
                    "fill,hidemode 3,align center center",
                    // columns
                    "[fill]",
                    // rows
                    "[]" +
                            "[]"));

            //---- offCheckBox ----
            offCheckBox.setText("Turn off together with PC");
            offCheckBox.setOpaque(true);
            offCheckBox.setBackground(mainBackgroundColor);
            offCheckBox.setForeground(mainForegroundColor);
            checkBoxPanel.add(offCheckBox, "cell 0 0");

            //---- rainbowCheckBox ----
            rainbowCheckBox.setText("Rainbow effect on start");
            rainbowCheckBox.setOpaque(true);
            rainbowCheckBox.setBackground(mainBackgroundColor);
            rainbowCheckBox.setForeground(mainForegroundColor);
            checkBoxPanel.add(rainbowCheckBox, "cell 0 1");
        }
        add(checkBoxPanel, "cell 0 0");
        System.out.println("checkBoxPanel ready");

        //======== rgbPanel ========
        {
            rgbPanel.setBackground(mainBackgroundColor);
            rgbPanel.setForeground(mainForegroundColor);
            rgbPanel.setLayout(new MigLayout(
                    "fillx,hidemode 3,align center center",
                    // columns
                    "[fill]" +
                            "[fill]" +
                            "[fill]",
                    // rows
                    "[fill]" +
                            "[fill]" +
                            "[fill]"));

            //---- rLabel ----
            rLabel.setText("R");
            rLabel.setBackground(mainBackgroundColor);
            rLabel.setForeground(mainForegroundColor);
            rgbPanel.add(rLabel, "cell 0 0,align center center,grow 0 0");

            //---- gLabel ----
            gLabel.setText("G");
            gLabel.setBackground(mainBackgroundColor);
            gLabel.setForeground(mainForegroundColor);
            rgbPanel.add(gLabel, "cell 1 0,align center center,grow 0 0");

            //---- bLabel ----
            bLabel.setText("B");
            bLabel.setBackground(mainBackgroundColor);
            bLabel.setForeground(mainForegroundColor);
            rgbPanel.add(bLabel, "cell 2 0,align center center,grow 0 0");

            //---- rTextField ----
            rTextField.getDocument().addDocumentListener(new RGB255Listener(rTextField, rgbColorLabel));
            rTextField.addFocusListener(new RGBFocusListener(rTextField, rgbColorLabel));
            rTextField.setHorizontalAlignment(SwingConstants.CENTER);
            rgbPanel.add(rTextField, "cell 0 1,align center center,growx");

            //---- gTextField ----
            gTextField.getDocument().addDocumentListener(new RGB255Listener(gTextField, rgbColorLabel));
            gTextField.addFocusListener(new RGBFocusListener(gTextField, rgbColorLabel));
            gTextField.setHorizontalAlignment(SwingConstants.CENTER);
            rgbPanel.add(gTextField, "cell 1 1,align center center,growx");

            //---- bTextField ----
            bTextField.getDocument().addDocumentListener(new RGB255Listener(bTextField, rgbColorLabel));
            bTextField.addFocusListener(new RGBFocusListener(bTextField, rgbColorLabel));
            bTextField.setHorizontalAlignment(SwingConstants.CENTER);
            rgbPanel.add(bTextField, "cell 2 1,align center center,growx");

            //---- rgbColorLabel ----
            rgbColorLabel.setMinimumSize(new Dimension(50, 20));
            rgbColorLabel.setOpaque(true);
            rgbColorLabel.setForeground(mainForegroundColor);
            rgbPanel.add(rgbColorLabel, "cell 0 2 3 1,align center center,growx");
        }
        add(rgbPanel, "cell 0 1");
        System.out.println("rgbPanel ready");

        //======== ctPanel ========
        {
            ctPanel.setBackground(mainBackgroundColor);
            ctPanel.setForeground(mainForegroundColor);
            ctPanel.setLayout(new MigLayout(
                    "fill,hidemode 3,align center center",
                    // columns
                    "[fill]",
                    // rows
                    "[]" +
                            "[]" +
                            "[]"));

            //---- ctLabel ----
            ctLabel.setText("Color Temperature");
            ctLabel.setBackground(mainBackgroundColor);
            ctLabel.setForeground(mainForegroundColor);
            ctPanel.add(ctLabel, "cell 0 0,align center center,grow 0 0");

            //---- ctSlider ----
            ctSlider.setInverted(true);
            ctPanel.add(ctSlider, "cell 0 1,align center center,growx");

            //---- ctGradient ----
            ctGradient.setMinimumSize(new Dimension(0,15));
            ctPanel.add(ctGradient, "cell 0 2,align center center,growx,growy");
        }
        add(ctPanel, "cell 0 2,align center center,growx");
        System.out.println("ctPanel ready");

        //======== brightnessPanel ========
        {
            brightnessPanel.setBackground(mainBackgroundColor);
            brightnessPanel.setForeground(mainForegroundColor);
            brightnessPanel.setLayout(new MigLayout(
                    "fill,hidemode 3,align center center",
                    // columns
                    "[fill]",
                    // rows
                    "[]" +
                            "[]" +
                            "[]"));

            //---- brightnessLabel ----
            brightnessLabel.setText("Brightness");
            brightnessLabel.setBackground(mainBackgroundColor);
            brightnessLabel.setForeground(mainForegroundColor);
            brightnessPanel.add(brightnessLabel, "cell 0 0,align center center,grow 0 0");

            //---- brightnessSlider ----
            //When value of the slider changes, change also the value of the label
            brightnessSlider.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    brightnessPercentageLabel.setText(String.valueOf(brightnessSlider.getValue()) + "%");
                }
            });
            brightnessPanel.add(brightnessSlider, "cell 0 1,align center center,growx");

            //---- brightnessPercentageLabel ----
            brightnessPercentageLabel.setText(brightnessSlider.getValue() + "%");
            brightnessPercentageLabel.setBackground(mainBackgroundColor);
            brightnessPercentageLabel.setForeground(mainForegroundColor);
            brightnessPanel.add(brightnessPercentageLabel, "cell 0 2,align center center,grow 0 0");
        }
        add(brightnessPanel, "cell 0 3,align center center,growx");
        System.out.println("brightnessPanel ready");

        //======== actionPanel ========
        {
            actionPanel.setBackground(mainBackgroundColor);
            actionPanel.setForeground(mainForegroundColor);
            actionPanel.setLayout(new MigLayout(
                    "fill,hidemode 3",
                    // columns
                    "[]" +
                            "[]" +
                            "[]",
                    // rows
                    "[]"));

            //---- saveButton ----
            saveButton.setText("Save");
            saveButton.setBackground(mainBackgroundColor);
            saveButton.setForeground(mainForegroundColor);
            saveButton.setContentAreaFilled(false);
            saveButton.addMouseListener(new ButtonsListener(saveButton, buttonPressedColor, mainForegroundColor));
            saveButton.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(mainForegroundColor, 1),
                    BorderFactory.createEmptyBorder(5, 10, 5, 10)));
            saveButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    save();
                }
            });
            actionPanel.add(saveButton, "cell 0 0,align center center,grow 0 0");

            //TODO: tidy the borders, setBorder can be used in listener class
            //---- discardButton ----
            discardButton.setText("Discard");
            discardButton.setBackground(mainBackgroundColor);
            discardButton.setForeground(mainForegroundColor);
            discardButton.setContentAreaFilled(false);
            discardButton.addMouseListener(new ButtonsListener(discardButton, buttonPressedColor, mainForegroundColor));
            discardButton.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(mainForegroundColor, 1),
                    BorderFactory.createEmptyBorder(5, 10, 5, 10)));
            discardButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    load();
                }
            });
            actionPanel.add(discardButton, "cell 1 0,align center center,grow 0 0");

            //TODO: Create custom class for buttons, to not be so repetitive
            //---- cancelButton ----
            cancelButton.setText("Cancel");
            cancelButton.setBackground(mainBackgroundColor);
            cancelButton.setForeground(mainForegroundColor);
            cancelButton.setContentAreaFilled(false);
            cancelButton.addMouseListener(new ButtonsListener(cancelButton, buttonPressedColor, mainForegroundColor));
            cancelButton.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(mainForegroundColor, 1),
                    BorderFactory.createEmptyBorder(5, 10, 5, 10)));
            cancelButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                }
            });
            actionPanel.add(cancelButton, "cell 2 0,align center center,grow 0 0");
        }
        add(actionPanel, "cell 0 4");
        System.out.println("actionPanel ready");
        load();
    }


    private void save(){
        SaveUserPrefs.save(this);
    }
    private void load(){
        LoadUserPrefs.load(this);

    }

    //Bulb Controls
    YeelightAPI yAPI;
    YeelightAPI.Power power;
    YeelightAPI.ColorTemp colorTemp;
    YeelightAPI.Flow flow;

    JPanel checkBoxPanel;
    JCheckBox offCheckBox;
    JCheckBox rainbowCheckBox;
    JPanel rgbPanel;
    JLabel rLabel;
    JLabel gLabel;
    JLabel bLabel;
    TextField rTextField;
    TextField gTextField;
    TextField bTextField;
    JLabel rgbColorLabel;
    JPanel ctPanel;
    JLabel ctLabel;
    Slider ctSlider;
    GradientLabel ctGradient;
    JPanel brightnessPanel;
    JLabel brightnessLabel;
    Slider brightnessSlider;
    JLabel brightnessPercentageLabel;
    JPanel actionPanel;
    JButton saveButton;
    JButton discardButton;
    JButton cancelButton;
    Color mainBackgroundColor;
    Color mainForegroundColor;
    Color buttonPressedColor;
}
