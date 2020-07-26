package com.lgt.netsocket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TCPSender {
    public static void main(String[] args) throws IOException {
        sender();
        return;
    }

    private static void sender() throws IOException {
        Socket socket = new Socket(InetAddress.getByName("192.168.1.103"), 8101);
        OutputStream os = socket.getOutputStream();
        String s = "hello, world!";
        os.write(s.getBytes());
        os.close();
        socket.close();
    }
}
