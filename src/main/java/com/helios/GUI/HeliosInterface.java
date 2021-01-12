package com.helios.GUI;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.helios.JsonTranslator;
import com.helios.YeelightAPI;
import com.helios.connection.Bulbs;
import net.miginfocom.swing.*;

/**
 * @author unknown
 */
public class HeliosInterface extends JPanel {
    public HeliosInterface() {
        initComponents();
    }

    Bulbs b;

    private void initComponents() {
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
        ctSlider = new JSlider();
        ctGradient = new GradientLabel();
        brightnessPanel = new JPanel();
        brightnessLabel = new JLabel();
        brightnessSlider = new JSlider();
        brightnessPercentageLabel = new JLabel();
        actionPanel = new JPanel();
        saveButton = new JButton();
        discardButton = new JButton();
        cancelButton = new JButton();
        mainBackgroundColor = new Color(60, 63, 66);
        mainForegroundColor = new Color(188, 188, 188);
        try {
            b = new Bulbs(0);
        } catch (Exception e) {
            System.out.println(e);
        }

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
            rTextField.getDocument().addDocumentListener(new DocListener(rTextField));
            rTextField.setHorizontalAlignment(SwingConstants.CENTER);
            rgbPanel.add(rTextField, "cell 0 1,align center center,growx");

            //---- gTextField ----
            gTextField.setBackground(mainBackgroundColor);
            gTextField.setForeground(mainForegroundColor);
            gTextField.setDocument(new JTextFieldLimit(3));
            gTextField.setText("0");
            gTextField.getDocument().addDocumentListener(new DocListener(gTextField));
            gTextField.setHorizontalAlignment(SwingConstants.CENTER);
            rgbPanel.add(gTextField, "cell 1 1,align center center,growx");

            //---- bTextField ----
            bTextField.setText("0");
            bTextField.setBackground(mainBackgroundColor);
            bTextField.setForeground(mainForegroundColor);
            bTextField.setDocument(new JTextFieldLimit(3));
            bTextField.setText("0");
            bTextField.getDocument().addDocumentListener(new DocListener(bTextField));
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
            brightnessSlider.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    brightnessPercentageLabel.setText(brightnessSlider.getValue() + "%");
                    YeelightAPI y = new YeelightAPI();
                    y.SetBright(brightnessSlider.getValue(), "smooth", 10);

                         //   b1 = YeelightAPI.SetBright(brightnessSlider.getValue(), "smooth", 10);
                    String t1 = JsonTranslator.translate(b1);
                    try {

                        b.sendMessage(t1);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            });
            brightnessSlider.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {

                }

                @Override
                public void focusLost(FocusEvent e) {

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
            saveButton.addMouseListener(new buttonMouseHold(saveButton));
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
            saveButton.addMouseListener(new buttonMouseHold(saveButton));
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
            saveButton.addMouseListener(new buttonMouseHold(saveButton));
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


    //DocumentListener custom class
    //Prevents entering value higher than 255 in text fields
    //Changes the color of rgbColorLabel to match given rgb values
    //Put into inner class to avoid code repetition
    class DocListener implements DocumentListener {
        JTextField tf;
        DocListener(JTextField textField){
            tf = textField;
        }

        private void changeLabelColor(){
            Color c = new Color(Integer.parseInt(rTextField.getText()), Integer.parseInt(gTextField.getText()), Integer.parseInt(bTextField.getText()));
            rgbColorLabel.setBackground(c);
            c = null;
        }

        //Then check if value inside the field is over 255, if is, insert 255
        //Additionally change label color each time value is inserted
        @Override
        public void insertUpdate(DocumentEvent e) {
            if (Integer.parseInt(tf.getText()) > 255) {
                Runnable r = new Runnable() {
                    @Override
                    public void run() {
                        tf.setText("255");
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
        public void changedUpdate(DocumentEvent e) {System.out.println("change");}
    }

    //MouseAdapter custom class
    //Changes button border when clicked, then back to default when released
    //Gives buttons the "push" look
    class buttonMouseHold extends MouseAdapter {
        JButton btn;
        buttonMouseHold(JButton b){
            btn = b;
        }

        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
            btn.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(35,35,35), 5),
                    BorderFactory.createEmptyBorder(1, 6, 1, 6)));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            super.mouseReleased(e);
            btn.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(mainForegroundColor, 1),
                    BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        }
    }

    private void save(){
        SaveUserPrefs.save(this);
    }
    private void load(){
        LoadUserPrefs.load(this);
    }

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

}
