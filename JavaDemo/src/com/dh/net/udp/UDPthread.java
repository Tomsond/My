package com.dh.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 *  UDP通信加入多线程：在一个窗口显示接收与发生
 *  思路：
 *      1.接收与发送对象继承thread
 *      2.线程体中放入两边代码
 */
public class UDPthread {
    public static void main(String[] args) {
        new Send().start();
        new Receive().start();
    }
}

//send()
class Send extends Thread{
    @Override
    public void run() {
        //注意要try catch起来，不能抛出
        try {
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

//receive()
class Receive extends Thread{
    @Override
    public void run() {
        try{
            DatagramSocket socket = new DatagramSocket(6666);
            DatagramPacket packet = new DatagramPacket(new byte[1024],1024); //字节数组接收
            while (true) {
                socket.receive(packet);
                byte[] b = packet.getData(); //定义字节数组接收数据
                int len = packet.getLength(); //接收的有效长度
                System.out.println("接收：" + new String(b, 0, len));
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}