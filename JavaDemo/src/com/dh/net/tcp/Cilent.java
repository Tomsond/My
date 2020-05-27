package com.dh.net.tcp;

import java.io.*;
import java.net.Socket;

/**
 * TCP连接
 * 客户端
 */
public class Cilent {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("127.0.0.1",12345);
        BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream ps=new PrintStream(socket.getOutputStream());
        System.out.println(br.readLine()); //读取服务器的内容
        ps.println("我是客户端1，我没啥问的。"); //字符串写到服务器
    }
}
