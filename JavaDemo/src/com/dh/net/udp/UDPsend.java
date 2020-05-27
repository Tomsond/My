package com.dh.net.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

/**
 * UDP连接
 * 1.创建码头
 * 2.创建集装箱
 * 3.码头上的集装箱发送出去
 */
public class UDPsend {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        DatagramSocket socket=new DatagramSocket(); //码头
        System.out.println("请输入要发送的消息：");
        while(true) {
            String line=sc.nextLine();
            if("quit".equals(line)) break;
            DatagramPacket packet = new DatagramPacket(line.getBytes(),line.getBytes().length,
                    InetAddress.getByName("127.0.0.1"),6666); //集装箱 (byte[],length,address,port)
            socket.send(packet);
        }
        socket.close();
    }
}
