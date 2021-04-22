package com.helios.connection;

import java.io.IOException;

/*
    HOW TO USE YeelightAPI
    First, initialize YeelightAPI class, this will make a connection to the bulb's socket
    Then, use the nested classes to change the bulb parameters
 */


public class YeelightAPI extends SocketConnector{

    public YeelightAPI(int index) {
        super(index);
        System.out.println("called YeelightAPI super()");
    }

    private static class Methods {
        protected int id = 1;
    }

    //TODO: Descriptions of bulb methods
    /*
    status      - on, off
    mode        - sudden, smooth
    duration    - int
     */
    public static class Power extends Methods {
        private String method = "set_power";
        private Object[] params = new Object[3];

        public void setPower(String status, String mode, int duration) {
            params[0] = status;
            params[1] = mode;
            params[2] = duration;
            YeelightAPI.sendMessage(this);
        }
    }

    /*
    status      - on, off
    mode        - sudden, smooth
    duration    - int
     */
    public static class RGB extends Methods {
        private String method = "set_rgb";
        private Object[] params = new Object[3];

        public void setRGB(int r, int g, int b, String mode, int duration) {
            int rgb = (r*65536)+(g*256)+b;
            params[0] = rgb;
            params[1] = mode;
            params[2] = duration;
            YeelightAPI.sendMessage(this);
        }
    }

    /*
    status      - on, off
    mode        - sudden, smooth
    duration    - int
     */
    public static class Bright extends Methods {
        private String method = "set_bright";
        private Object[] params = new Object[3];

        public void setBright(int intensity, String mode, int duration) {
            params[0] = intensity;
            params[1] = mode;
            params[2] = duration;
            YeelightAPI.sendMessage(this);
        }
    }

    public static class Flow extends Methods {
        private String method = "start_cf";
        private Object[] params = new Object[3];

        /* args are:
        DURATION - in ms
        MODE - 1 -> color, 2 -> color temperature, 7 -> sleep
        VALUE - RGB value when mode is 1, CT when mode is 2
        BRIGHTNESS - -1 or 1 - 100. Ignored when mode is 7
         */
        public void colorFlow(int count, int action, String... args) {
            params[0] = count;
            params[1] = action;
            String sequence = "";
            for(String arg : args){
                sequence += arg;
            }
            params[2] = sequence;
            YeelightAPI.sendMessage(this);
        }
    }

    /*
    status      - on, off
    mode        - sudden, smooth
    duration    - int
     */
    public static class ColorTemp extends Methods {
        private String method = "set_ct_abx";
        private Object[] params = new Object[3];

        public void setColorTemp(int temp, String mode, int duration) {
            params[0] = temp;
            params[1] = mode;
            params[2] = duration;
            YeelightAPI.sendMessage(this);
        }

    }

    public static void main(String[] args){
        YeelightAPI y;
        y = new YeelightAPI(0);
        System.out.println("y set");
        new YeelightAPI.Power().setPower("on", "sudden", 0);
    }

}
