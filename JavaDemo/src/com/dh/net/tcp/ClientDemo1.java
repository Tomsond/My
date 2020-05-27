package com.dh.net.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * 键盘录入字符串，服务器倒序输出过来
 */
public class ClientDemo1 {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("127.0.0.1",54321);
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream ps=new PrintStream(socket.getOutputStream());
        ps.println(sc.nextLine()); //向服务器发生字符串，等待服务器倒序字符串
        System.out.println(br.readLine()); //接收并读取到服务器倒序后的字符串
    }
}
