package com.helios.connection;


import java.io.IOException;
import java.util.ArrayList;

public class Bulbs {
    public ArrayList<String> bulbs;
    private SocketConnector sc;
    private int i;

    public Bulbs(int index) throws IOException {
        bulbs = SSDPCommunication.getIP();
        sc = new SocketConnector(bulbs.get(index), 55443);
        i = index;
    }

    public String sendMessage(String message) throws IOException {
        sc.sendMessage(message);
        System.out.println(sc.response);
        return "";
    }

    public void restartConnection() throws IOException {
        sc = new SocketConnector(bulbs.get(i), 55443);
    }

    public void closeConnection() throws IOException {
        sc.close();
    }
}
