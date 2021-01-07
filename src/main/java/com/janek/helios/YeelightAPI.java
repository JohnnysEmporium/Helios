package com.janek.helios;

public class YeelightAPI {

    static class Methods {
        protected int id = 1;
    }

    static class SetPower extends Methods {
        private String method = "set_power";
        private Object[] params = new Object[3];

        SetPower(String status, String mode, int duration) {
            params[0] = status;
            params[1] = mode;
            params[2] = duration;
        }
    }

    static class SetRGB extends Methods {
        private String method = "set_rgb";
        private Object[] params = new Object[3];

        SetRGB(int r, int g, int b, String mode, int duration){
            int rgb = (r*65536)+(g*256)+b;
            params[0] = rgb;
            params[1] = mode;
            params[2] = duration;
        }
    }

    static class SetBright extends Methods {
        private String method = "set_bright";
        private Object[] params = new Object[3];

        SetBright(int intensity, String mode, int duration){
            params[0] = intensity;
            params[1] = mode;
            params[2] = duration;

        }
    }

    static class ColorFlow extends Methods {
        private String method = "start_cf";
        private Object[] params = new Object[3];

        /* args are:
        DURATION - in ms
        MODE - 1 -> color, 2 -> color temperature, 7 -> sleep
        VALUE - RGB value when mode is 1, CT when mode is 2
        BRIGHTNESS - -1 or 1 - 100. Ignored when mode is 7
         */
        ColorFlow(int count, int action, String... args){
            params[0] = count;
            params[1] = action;
            String sequence = "";
            for(String arg : args){
                sequence += arg;
            }
            params[2] = sequence;

        }
    }

    static class SetColorTemp extends Methods {
        String method = "set_ct_abx";
        Object[] params = new Object[3];

        SetColorTemp(int temp, String mode, int duration){
            params[0] = temp;
            params[1] = mode;
            params[2] = duration;
        }

    }


}
