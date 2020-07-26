package com.lgt.netsocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSender {
    public static void main(String[] args) throws IOException {
        sender();
    }

    private static void sender() throws IOException {
        DatagramSocket ds = new DatagramSocket();
        String s = "hello World";
        byte[] bytes = s.getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("192.168.1.103"), 8101);
        ds.send(datagramPacket);
        ds.close();
    }
}
