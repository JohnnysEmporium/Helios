package com.helios;

import com.google.gson.Gson;
import com.helios.connection.YeelightAPI;

import java.io.IOException;


public class JsonTranslator {


    public static String translate(Object c){
        Gson g = new Gson();
        return g.toJson(c);
    }

    public static void main(String args[]) throws IOException {
        YeelightAPI.Power p = new YeelightAPI.Power();
        YeelightAPI.Bright br = new YeelightAPI.Bright();
        YeelightAPI.ColorTemp c = new YeelightAPI.ColorTemp();
        //c.setColorTemp();
        //p.SetPower("on", "smooth", 1);
        //br.SetBright(100,"sudden",1);
        //Bulbs b = new Bulbs(0);
        //b.sendMessage(p);
        //b.closeConnection();

        //SocketConnector sc = new SocketConnector(SSDPCommunication.getIP(), 55443);
        ////sc.sendMessage(t1);
        //System.out.println(sc.response);
        //sc.close();


    }


}