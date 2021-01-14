package com.helios.connection;

import com.google.gson.Gson;
import org.json.JSONObject;

import java.io.*;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


class SocketConnector {

    private static Gson g = new Gson();
    private static Socket sck;
    private static DataInputStream is;
    private static DataOutputStream os;
    private static BufferedReader in;
    private static PrintWriter pw;
    //Bulb index passed to ArrayList<String> bulbs to get correct bulb IP
    private static int i;
    public static ArrayList<String> bulbs;
    public static String response;
    public static JSONObject jo;

    private static String translate(Object c){
        return g.toJson(c);
    }

    protected SocketConnector(int index){
        i = index;
        try {
            bulbs = SSDPCommunication.getIP();
            sck = new Socket(bulbs.get(index), 55443);
            System.out.println(bulbs.get(index));
            is = new DataInputStream(sck.getInputStream());
            os = new DataOutputStream(sck.getOutputStream());
            pw = new PrintWriter(os);
            in = new BufferedReader(new InputStreamReader(is));
            System.out.println("Socket Connector Initialized");
        } catch (SocketTimeoutException e) {
            //If there's no answer from the socket after 1s, restart the connection and try again
            //Change the timeout duration in SSDPCommunication.java
            new SocketConnector(0);
        } catch (Exception e){
            System.out.println(e);
        }
    }

    protected static void sendMessage(Object object) {
        pw.println(translate(object));
        pw.flush();
        try {
            String s = in.readLine();
            s = s.substring(s.lastIndexOf(':') + 1);
            response = s;
            System.out.println(s);
            if(s.equals("\"client quota exceeded\"}}")) {
                System.out.println("Connection restarting");
                restartConnection();
                System.out.println("Connection restarted");
            }
        } catch (Exception e){
            System.out.println(e);
        }

    }

    //Yeelight software unfortunatelly has limitation on API calls - 60 per minute.
    //Here's a little workaround that will bypass this limitation and increase it to around 150 calls per minute.
    //I'm pretty proud of this one, got to say. I feel like mr. Robot xD
    protected static void restartConnection() throws IOException, InterruptedException {
        closeConnection();
        TimeUnit.SECONDS.sleep(1);
        new SocketConnector(0);
    }
    protected static void closeConnection() throws IOException {
        is.close();
        os.close();
        sck.close();
    }
}
