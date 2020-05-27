package com.dh.net.tcp;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * 客户端输入文件，上传到服务器(这就放在本地上)
 * 1.创建文件对象，加以判断
 * 2.创建客户端，发送文件名到服务器
 * 5.存在返回不能重复上传
 * 6.不存在，用FileInputStream读取文件，并写出到网络
 */
public class ClientDemo2 {
    public static void main(String[] args) throws IOException {
        File file=getFile();
        //2.创建客户端
        Socket socket=new Socket("127.0.0.1",4567);
        BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream ps=new PrintStream(socket.getOutputStream());
        ps.println(file.getName()); //发送文件名到服务器
        //5.接收服务器传来的结果
        String result=br.readLine();
        if("存在".equals(result)){
            System.out.println("您上传的文件已存在，不要重复上传");
            socket.close();
            return;
        }
        //6.不存在
        FileInputStream fis=new FileInputStream(file);
        byte[] b=new byte[1024];
        int len;
        while((len=fis.read(b)) != -1){
            ps.write(b,0,len);
        }
        fis.close();
        socket.close();
    }

    //拿到文件
    public static File getFile(){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入一个路径：");
        while(true) {
            String line = sc.nextLine();
            File file=new File(line);
            if(!file.exists()){
                System.out.println("您输入的文件不存在");
            }else if(file.isDirectory()){
                System.out.println("您输入的是一个文件夹");
            }else{
                return file;
            }
        }
    }

}
