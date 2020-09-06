package com.atguigu.java1;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author wy  wiseguy_sky@outlook.com
 * @create 2020-08-22 18:16
 */
public class MyTest {

    @Test
    public void post() throws IOException {

        InetAddress localHost = InetAddress.getLocalHost();
        DatagramSocket datagramSocket = new DatagramSocket();

        String string = new String("我是UDP的发送端发送的数据");
        byte[] bytes = string.getBytes();


        DatagramPacket datagramPacket = new DatagramPacket(bytes,0,bytes.length,localHost,8888);
        datagramSocket.send(datagramPacket);
        datagramSocket.close();

    }
    @Test
    public void get() throws IOException {

        DatagramSocket datagramSocket = new DatagramSocket(8888);

        byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length);
        datagramSocket.receive(datagramPacket);

        System.out.println(new String(datagramPacket.getData(), 0, datagramPacket.getLength()));


    }
}
