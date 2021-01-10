package com.helios.GUI;

import java.util.prefs.Preferences;

public class LoadUserPrefs {
    private static Preferences p = Preferences.userRoot().node("com/helios/userPrefs");

    private static int li(String k){
        return p.getInt(k, 0);
    }
    private static boolean lb(String k){
        return p.getBoolean(k, false);
    }
    private static String ls(String k){
        return p.get(k, "");
    }

    public static void load(HeliosInterface app){
        app.offCheckBox.setSelected(lb("offCheckBox"));
        app.rainbowCheckBox.setSelected(lb("rainbowCheckBox"));
        app.rTextField.setText(ls("rTextField"));
        app.gTextField.setText(ls("gTextField"));
        app.bTextField.setText(ls("bTextField"));
        app.ctSlider.setValue(li("ctSlider"));
        app.brightnessSlider.setValue(li("brightnessSlider"));
    }
}
