import java.awt.*;
import javax.swing.*;
import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Fri Jan 08 17:16:12 CET 2021
 */



/**
 * @author unknown
 */
public class HeliosInterface extends JPanel {
    public HeliosInterface() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        panel3 = new JPanel();
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
        ctGradient = new JLabel();
        brightnessPanel = new JPanel();
        brightnessLabel = new JLabel();
        brightnessSlider = new JSlider();
        brightnessPercentageLabel = new JLabel();
        actionPanel = new JPanel();
        saveButton = new JButton();
        discardButton = new JButton();
        cancelButton = new JButton();

        //======== this ========
        setMaximumSize(new Dimension(230, 340));
        setMinimumSize(new Dimension(260, 450));
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder(
        0, 0, 0, 0) , "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e", javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder
        . BOTTOM, new java .awt .Font ("Dialo\u0067" ,java .awt .Font .BOLD ,12 ), java. awt. Color.
        red) , getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .
        beans .PropertyChangeEvent e) {if ("borde\u0072" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );
        setLayout(new MigLayout(
            "fill,novisualpadding,align center center",
            // columns
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //======== panel3 ========
        {
            panel3.setLayout(new MigLayout(
                "fill,hidemode 3,align center center",
                // columns
                "[fill]",
                // rows
                "[]" +
                "[]"));

            //---- offCheckBox ----
            offCheckBox.setText("Turn off together with PC");
            panel3.add(offCheckBox, "cell 0 0");

            //---- rainbowCheckBox ----
            rainbowCheckBox.setText("Rainbow effect on start");
            panel3.add(rainbowCheckBox, "cell 0 1");
        }
        add(panel3, "cell 0 0");

        //======== rgbPanel ========
        {
            rgbPanel.setLayout(new MigLayout(
                "fillx,hidemode 3,align center center",
                // columns
                "[fill]" +
                "[fill]" +
                "[fill]",
                // rows
                "[]" +
                "[]" +
                "[]"));

            //---- rLabel ----
            rLabel.setText("R");
            rgbPanel.add(rLabel, "cell 0 0,align center center,grow 0 0");

            //---- gLabel ----
            gLabel.setText("G");
            rgbPanel.add(gLabel, "cell 1 0,align center center,grow 0 0");

            //---- bLabel ----
            bLabel.setText("B");
            rgbPanel.add(bLabel, "cell 2 0,align center center,grow 0 0");
            rgbPanel.add(rTextField, "cell 0 1,align center center,grow 0 0");
            rgbPanel.add(gTextField, "cell 1 1,align center center,grow 0 0");
            rgbPanel.add(bTextField, "cell 2 1,align center center,grow 0 0");

            //---- rgbColorLabel ----
            rgbColorLabel.setMinimumSize(new Dimension(50, 20));
            rgbColorLabel.setBackground(Color.red);
            rgbPanel.add(rgbColorLabel, "cell 0 2 3 1,align center center,growx");
        }
        add(rgbPanel, "cell 0 1");

        //======== ctPanel ========
        {
            ctPanel.setLayout(new MigLayout(
                "hidemode 3,align center center",
                // columns
                "[fill]",
                // rows
                "[]" +
                "[]" +
                "[]" +
                "[]"));

            //---- ctLabel ----
            ctLabel.setText("Color Temperature");
            ctPanel.add(ctLabel, "cell 0 0,align center center,grow 0 0");
            ctPanel.add(ctSlider, "cell 0 1,align center center,grow 0 0");

            //---- ctGradient ----
            ctGradient.setText("GRADIENT");
            ctPanel.add(ctGradient, "cell 0 2,align center center,grow 0 0");
        }
        add(ctPanel, "cell 0 2");

        //======== brightnessPanel ========
        {
            brightnessPanel.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[fill]",
                // rows
                "[]" +
                "[]" +
                "[]" +
                "[]"));

            //---- brightnessLabel ----
            brightnessLabel.setText("Brightness");
            brightnessPanel.add(brightnessLabel, "cell 0 0,align center center,grow 0 0");
            brightnessPanel.add(brightnessSlider, "cell 0 1,align center center,grow 0 0");

            //---- brightnessPercentageLabel ----
            brightnessPercentageLabel.setText("PERCENTAGE");
            brightnessPanel.add(brightnessPercentageLabel, "cell 0 2,align center center,grow 0 0");
        }
        add(brightnessPanel, "cell 0 3,align center center,grow 0 0");

        //======== actionPanel ========
        {
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
            actionPanel.add(saveButton, "cell 0 0,align center center,grow 0 0");

            //---- discardButton ----
            discardButton.setText("Discard");
            actionPanel.add(discardButton, "cell 1 0");

            //---- cancelButton ----
            cancelButton.setText("Cancel");
            actionPanel.add(cancelButton, "cell 2 0");
        }
        add(actionPanel, "cell 0 4");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel panel3;
    private JCheckBox offCheckBox;
    private JCheckBox rainbowCheckBox;
    private JPanel rgbPanel;
    private JLabel rLabel;
    private JLabel gLabel;
    private JLabel bLabel;
    private JTextField rTextField;
    private JTextField gTextField;
    private JTextField bTextField;
    private JLabel rgbColorLabel;
    private JPanel ctPanel;
    private JLabel ctLabel;
    private JSlider ctSlider;
    private JLabel ctGradient;
    private JPanel brightnessPanel;
    private JLabel brightnessLabel;
    private JSlider brightnessSlider;
    private JLabel brightnessPercentageLabel;
    private JPanel actionPanel;
    private JButton saveButton;
    private JButton discardButton;
    private JButton cancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
