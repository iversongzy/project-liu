package com.lgt.netsocket;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getByName("192.168.1.103");
        System.out.println(inetAddress.getHostName());
        System.out.println(inetAddress.getAddress());
        System.out.println(inetAddress.getHostAddress());
    }
}
