package com.helios.GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.helios.GUI.CustomInterfaceItems.GradientLabel;
import com.helios.GUI.CustomInterfaceItems.JTextFieldLimit;
import com.helios.GUI.Listeners.SliderListener;
import com.helios.GUI.Listeners.ButtonsListener;
import com.helios.GUI.Listeners.RGBListener;
import com.helios.connection.YeelightAPI;
import net.miginfocom.swing.*;

/**
 * @author unknown
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

        //Initizlize GUI components
        checkBoxPanel = new JPanel();
        offCheckBox = new JCheckBox();
        rainbowCheckBox = new JCheckBox();
        rgbPanel = new JPanel();
        rLabel = new JLabel();
        gLabel = new JLabel();
        bLabel = new JLabel();
        rTextField = new JTextField();
        gTextField = new JTextField();
        bTextField = new JTextField();
        rgbColorLabel = new JLabel();
        ctPanel = new JPanel();
        ctLabel = new JLabel();
        ctSlider = new JSlider(1700,6500);
        ctGradient = new GradientLabel();
        brightnessPanel = new JPanel();
        brightnessLabel = new JLabel();
        brightnessSlider = new JSlider(1,100);
        brightnessPercentageLabel = new JLabel();
        actionPanel = new JPanel();
        saveButton = new JButton();
        discardButton = new JButton();
        cancelButton = new JButton();
        mainBackgroundColor = new Color(60, 63, 66);
        mainForegroundColor = new Color(188, 188, 188);
        buttonReleaseColor = new Color(35,35,35);

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
            rTextField.setBackground(mainBackgroundColor);
            rTextField.setForeground(mainForegroundColor);
            rTextField.setDocument(new JTextFieldLimit(3));
            rTextField.setText("0");
            rTextField.setName("r");
            rTextField.getDocument().addDocumentListener(new RGBListener(rTextField, rgbColorLabel));
            rTextField.setHorizontalAlignment(SwingConstants.CENTER);
            rgbPanel.add(rTextField, "cell 0 1,align center center,growx");

            //---- gTextField ----
            gTextField.setBackground(mainBackgroundColor);
            gTextField.setForeground(mainForegroundColor);
            gTextField.setDocument(new JTextFieldLimit(3));
            gTextField.setText("0");
            gTextField.setName("g");
            gTextField.getDocument().addDocumentListener(new RGBListener(gTextField, rgbColorLabel));
            gTextField.setHorizontalAlignment(SwingConstants.CENTER);
            rgbPanel.add(gTextField, "cell 1 1,align center center,growx");

            //---- bTextField ----
            bTextField.setText("0");
            bTextField.setBackground(mainBackgroundColor);
            bTextField.setForeground(mainForegroundColor);
            bTextField.setDocument(new JTextFieldLimit(3));
            bTextField.setText("0");
            bTextField.setName("b");
            bTextField.getDocument().addDocumentListener(new RGBListener(bTextField, rgbColorLabel));
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
            ctSlider.setBackground(mainBackgroundColor);
            ctSlider.setForeground(mainForegroundColor);
            ctSlider.setName("ct");
            ctSlider.setInverted(true);
            ctSlider.addMouseListener(new SliderListener(ctSlider));
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
            brightnessSlider.setBackground(mainBackgroundColor);
            brightnessSlider.setForeground(mainForegroundColor);
            brightnessSlider.setName("brightness");
            brightnessSlider.addMouseListener(new SliderListener(brightnessSlider, brightnessPercentageLabel));
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
            saveButton.addMouseListener(new ButtonsListener(saveButton, mainForegroundColor, buttonReleaseColor));
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

            //---- discardButton ----
            discardButton.setText("Discard");
            discardButton.setBackground(mainBackgroundColor);
            discardButton.setForeground(mainForegroundColor);
            discardButton.setContentAreaFilled(false);
            discardButton.addMouseListener(new ButtonsListener(discardButton, mainForegroundColor, buttonReleaseColor));
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


            //---- cancelButton ----
            cancelButton.setText("Cancel");
            cancelButton.setBackground(mainBackgroundColor);
            cancelButton.setForeground(mainForegroundColor);
            cancelButton.setContentAreaFilled(false);
            cancelButton.addMouseListener(new ButtonsListener(cancelButton, mainForegroundColor, buttonReleaseColor));
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
    JTextField rTextField;
    JTextField gTextField;
    JTextField bTextField;
    JLabel rgbColorLabel;
    JPanel ctPanel;
    JLabel ctLabel;
    JSlider ctSlider;
    GradientLabel ctGradient;
    JPanel brightnessPanel;
    JLabel brightnessLabel;
    JSlider brightnessSlider;
    JLabel brightnessPercentageLabel;
    JPanel actionPanel;
    JButton saveButton;
    JButton discardButton;
    JButton cancelButton;
    Color mainBackgroundColor;
    Color mainForegroundColor;
    Color buttonReleaseColor;
}
