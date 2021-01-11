package com.helios.connection;

import org.json.JSONObject;

import java.io.*;
import java.net.Socket;


public class SocketConnector {

    private Socket sck;
    private DataInputStream is;
    private DataOutputStream os;
    private BufferedReader in;
    private PrintWriter pw;
    public String response;


    public SocketConnector(String ip, int port) throws IOException {
        sck = new Socket(ip, port);
        is = new DataInputStream(sck.getInputStream());
        os = new DataOutputStream(sck.getOutputStream());
        pw = new PrintWriter(os);
        in = new BufferedReader(new InputStreamReader(is));
    }

    public void sendMessage(String message) throws IOException {
        char[] c = new char[5];
        pw.println(message);
        pw.flush();
        in.read(c, 0 ,5);
        System.out.println(c);
        //response = new JSONObject(in.readLine()).toString();
    }

    public void close() throws IOException {
        is.close();
        os.close();
        sck.close();
    }
}
