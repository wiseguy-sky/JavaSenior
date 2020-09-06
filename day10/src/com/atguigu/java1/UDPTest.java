package com.atguigu.java1;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDPd协议的网络编程
 * @author shkstart
 * @create 2019 下午 4:34
 */
public class UDPTest {

    //发送端
    @Test
    public void sender() throws IOException {

        DatagramSocket socket = new DatagramSocket();



//        String str = "我是UDP方式发送的导弹";
        String str = "巴蜀，历来有天府之国的美誉，其中，最有名的门派莫过于唐门。\n" +
                "　　唐门所在是一个神秘的地方，许多人只知道，那是一个半山腰，而唐门所在这座山的山顶有一个令人胆颤心惊的名字，——鬼见愁。\n" +
                "　　从鬼见愁悬崖上扔出一块石头，要足足数上十九下才会听到石落山底的回声，可见其高，也正是因为这十九秒，尚超过十八层地狱一筹，故而得名。\n" +
                "　　一名身穿灰衣的青年正站在鬼见愁顶峰，凛冽的山风不能令他的身体有丝毫移动，从他胸口处那斗大的唐字就可以认出，他来自唐门，灰衣代表的，是唐门外门弟子。\n" +
                "　　他今年二十九岁，因出生不久就进入唐门，在外门弟子的辈分中排名第三，因此外门弟子称他一声三少。当然，到了内门弟子口中，就变成了唐三。\n" +
                "　　唐门从建立时开始就分为内外两门，外门都是外姓或被授予唐姓的弟子，而内门，则是唐门直系所属，家族传承。";
        byte[] data = str.getBytes();

        InetAddress inet = InetAddress.getLocalHost();
        DatagramPacket packet = new DatagramPacket(data,0,data.length,inet,9090);

        socket.send(packet);

        socket.close();

    }
    @Test
    public void sender1() throws IOException {

        DatagramSocket socket = new DatagramSocket();



//        String str = "我是UDP方式发送的导弹";
        String str = "巴蜀，历来有天府之国的美誉，其中，最有名的门派莫过于唐门。\n" +
                "　　唐门所在是一个神秘的地方，许多人只知道，那是一个半山腰，而唐门所在这座山的山顶有一个令人胆颤心惊的名字，——鬼见愁。\n" +
                "　　从鬼见愁悬崖上扔出一块石头，要足足数上十九下才会听到石落山底的回声，可见其高，也正是因为这十九秒，尚超过十八层地狱一筹，故而得名。\n" +
                "　　一名身穿灰衣的青年正站在鬼见愁顶峰，凛冽的山风不能令他的身体有丝毫移动，从他胸口处那斗大的唐字就可以认出，他来自唐门，灰衣代表的，是唐门外门弟子。\n" +
                "　　他今年二十九岁，因出生不久就进入唐门，在外门弟子的辈分中排名第三，因此外门弟子称他一声三少。当然，到了内门弟子口中，就变成了唐三。\n" +
                "　　唐门从建立时开始就分为内外两门，外门都是外姓或被授予唐姓的弟子，而内门，则是唐门直系所属，家族传承。";
        byte[] data = str.getBytes();

        InetAddress inet = InetAddress.getLocalHost();
        DatagramPacket packet = new DatagramPacket(data,0,data.length,inet,9090);

        socket.send(packet);

        socket.close();

    }
    //接收端
    @Test
    public void receiver() throws IOException {

        DatagramSocket socket = new DatagramSocket(9090);

        byte[] buffer = new byte[100];
        /*DatagramPacket packet = null;

        while (true) {
            packet = new DatagramPacket(buffer, 0, buffer.length);

            socket.receive(packet);
            System.out.println(packet.getLength());
            if (packet.getLength()<=0)break;

            System.out.println(new String(packet.getData(), 0, packet.getLength()));
        }*/
        DatagramPacket packet = new DatagramPacket(buffer,0,buffer.length);

        socket.receive(packet);

        System.out.println(new String(packet.getData(),0,packet.getLength()));


            socket.close();

    }
}
