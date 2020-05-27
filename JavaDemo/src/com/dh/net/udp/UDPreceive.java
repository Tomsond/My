package com.dh.net.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * UDP接收(先开)
 * 1.码头
 * 2.集装箱
 * 3.集装箱接收
 */
public class UDPreceive {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket=new DatagramSocket(6666);
        DatagramPacket packet=new DatagramPacket(new byte[1024],1024); //字节数组接收
        while(true){
            socket.receive(packet);
            byte[] b=packet.getData(); //字节数组接收的数据
            int len=packet.getLength(); //获取有效长度
            System.out.println("接收:"+new String(b,0,len));
        }
    }
}
