package com.helios;

import com.google.gson.Gson;
import com.helios.connection.Bulbs;
import com.helios.connection.SSDPCommunication;
import com.helios.connection.SocketConnector;

import java.io.IOException;


public class JsonTranslator {


    public static String translate(Object c){
        Gson g = new Gson();
        return g.toJson(c);
    }

    public static void main(String args[]) throws IOException {
        YeelightAPI.ColorFlow c = new YeelightAPI.ColorFlow(4,0,"1000, 2, 2700, 100, 500, 1, 255, 10,5000, 7, 0,0,500, 2, 5000, 1");
        YeelightAPI.SetRGB s = new YeelightAPI.SetRGB(255,0,0, "smooth",5000);
        YeelightAPI.SetColorTemp ct = new YeelightAPI.SetColorTemp(6000, "smooth", 500);
        YeelightAPI.SetBright b1 = new YeelightAPI.SetBright(1, "smooth", 10);
        YeelightAPI.SetBright b2 = new YeelightAPI.SetBright(100, "smooth", 50);
        YeelightAPI.SetPower p = new YeelightAPI.SetPower("on", "smooth", 500);
        String t1 = translate(b2);
        Bulbs b = new Bulbs(0);
        b.sendMessage(t1);
        b.closeConnection();

        //SocketConnector sc = new SocketConnector(SSDPCommunication.getIP(), 55443);
        ////sc.sendMessage(t1);
        //System.out.println(sc.response);
        //sc.close();


    }


}