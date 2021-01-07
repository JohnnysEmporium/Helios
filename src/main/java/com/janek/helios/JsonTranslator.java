package com.janek.helios;

import com.google.gson.Gson;
import com.janek.helios.connection.SocketConnector;
import com.janek.helios.YeelightAPI.*;

import java.io.*;


public class JsonTranslator {


    public static String translate(Object c){
        Gson g = new Gson();
        return g.toJson(c);
    }

    public static void main(String args[]) throws IOException {
        ColorFlow c = new ColorFlow(4,0,"1000, 2, 2700, 100, 500, 1, 255, 10,5000, 7, 0,0,500, 2, 5000, 1");
        SetRGB s = new SetRGB(255,0,0, "smooth",5000);
        SetColorTemp ct = new SetColorTemp(0, "smooth", 500);
        SetBright b1 = new SetBright(1, "smooth", 10);
        SetBright b2 = new SetBright(100, "smooth", 50);
        SetPower p = new SetPower("on", "smooth", 500);
        String t1 = translate(ct);
        SocketConnector sc = new SocketConnector("192.168.0.129", 55443);
        sc.sendMessage(t1);
        System.out.println(sc.response);
        sc.close();


    }


}