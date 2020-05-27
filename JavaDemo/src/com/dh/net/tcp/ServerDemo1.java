package com.dh.net.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 练习倒序，服务器端
 */
public class ServerDemo1 {
    public static void main(String[] args) throws IOException {
        ServerSocket server=new ServerSocket(54321);
        System.out.println("服务器已启动。。。");
        //多线程
        while(true) {
            Socket socket = server.accept();
            new Thread(){
                @Override
                public void run() {
                    try {
                        BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintStream ps=new PrintStream(socket.getOutputStream());
                        String line=br.readLine();//读取到客户端的字符串
                        line=new StringBuilder(line).reverse().toString(); //倒序字符串
                        ps.println(line);   //响应给客户端
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }
}
