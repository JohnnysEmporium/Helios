package com.helios.connection;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SSDPCommunication {

    //Sends a prepareted data packet to multicast address in order to receive the information about UPnP devices in the network
    //In this case it's wifi_bulb
    private static String findDevices() throws IOException {
        /* create byte arrays to hold our send and response data */
        byte[] sendData;
        byte[] receiveData = new byte[1024];

        /* our M-SEARCH data as a byte array */
        String MSEARCH = "M-SEARCH * HTTP/1.1\r\n" +
                "Host: 239.255.255.250:1982\r\n" +
                "Man: \"ssdp:discover\"\r\n" +
                "ST: wifi_bulb\r\n";
        sendData = MSEARCH.getBytes();

        /* create a packet from our data destined for 239.255.255.250:1982 */
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, InetAddress.getByName("239.255.255.250"), 1982);

        /* send packet to the socket we're creating */
        DatagramSocket clientSocket = new DatagramSocket();
        clientSocket.send(sendPacket);

        /* recieve response and store in our receivePacket */
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);

        /* get the response as a string */
        String response = new String(receivePacket.getData());

        /* close the socket */
        clientSocket.close();

        return response;
    }

    //Returns IP in a String from the response in findDevice()
    public static ArrayList<String> getIP() throws IOException {
        ArrayList<String> ret = new ArrayList<String>();
        String deviceInfo = findDevices();
        Pattern p = Pattern.compile("([0-9]*\\.[0-9]*\\.[0-9]*\\.[0-9]*)");
        Matcher m = p.matcher(deviceInfo);
        while(m.find()){
            ret.add(m.group(1));
        }
        return ret;
    }
}
