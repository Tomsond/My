package com.dh.net.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器端
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server=new ServerSocket(12345);

        //加入多线程
        while(true) {
            final Socket socket = server.accept(); //接收客户端消息
            new Thread(){
                @Override
                public void run() {
                    try {
                        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintStream ps = new PrintStream(socket.getOutputStream());

                        ps.println("我是服务器1，你问啥？");  //写到客户端
                        System.out.println(br.readLine()); //读取客户端发来的消息
                        socket.close();                     //关闭socket套接字，自动会关闭get的Input/OutputStream
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }
}
