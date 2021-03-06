package com.lgt.netsocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPReceiver {
    public static void main(String[] args) throws IOException {
        receiver();
    }

    private static void receiver() throws IOException {
        DatagramSocket ds = new DatagramSocket(8101);
        byte[] bys = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bys, bys.length);
        ds.receive(dp);//阻塞
        //解析数据
        //InetAddress getAddress() : 获取发送端的IP对象
        InetAddress address = dp.getAddress();
        //byte[] getData()  ：获取接收到的数据，也可以直接使用创建包对象时的数组
        byte[] data = dp.getData();
        //int getLength()  ：获取具体收到数据的长度
        int length = dp.getLength();
        //输出数据
        System.out.println("sender ---> " + address.getHostAddress());
        //System.out.println(new String(data,0,length));
        System.out.println(new String(bys, 0, length));
        //释放资源
        ds.close();
    }
}
