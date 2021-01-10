package com.helios.GUI;

import java.util.prefs.Preferences;

public class SaveUserPrefs {
    private static Preferences p = Preferences.userRoot().node("com/helios/userPrefs");

    private static void s(String k, int v){
        p.putInt(k,v);
    }
    private static void s(String k, boolean v){
        p.putBoolean(k,v);
    }
    private static void s(String k, String v){
        p.put(k,v);
    }

    public static void save(HeliosInterface app){
        s("offCheckBox",app.offCheckBox.isSelected());
        s("rainbowCheckBox",app.rainbowCheckBox.isSelected());
        s("rTextField",app.rTextField.getText());
        s("gTextField",app.gTextField.getText());
        s("bTextField",app.bTextField.getText());
        s("ctSlider",app.ctSlider.getValue());
        s("brightnessSlider",app.brightnessSlider.getValue());

    }

}
