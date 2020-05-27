package com.dh.net.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 3.创建服务器(多线程)
 * 4.读取文件，判断文件存在与否，结果发回客户端
 * 7.接收后，FileOutputStream传到服务端存储
 */
public class ServerDemo2 {
    public static void main(String[] args) throws IOException {
        ServerSocket server=new ServerSocket(4567);
        System.out.println("服务器已启动。。。");
        while(true){
            Socket socket = server.accept();
            new Thread(){
                @Override
                public void run() {
                    try {
                        InputStream is=socket.getInputStream();
                        BufferedReader br=new BufferedReader(new InputStreamReader(is));
                        PrintStream ps=new PrintStream(socket.getOutputStream());
                        String fileName=br.readLine();//接收客户端传来的文件
                        File dir=new File("upload");//创建文件夹存储
                        dir.mkdir();
                        File file=new File(dir,fileName); //客户端文件传到upload
                        if(file.exists()){
                            ps.println("存在");
                            socket.close();             //若存在，结束，返回客户端
                            return;
                        }else{
                            ps.println("不存在");
                        }
                        //7.接收,要用字节流读取
                        FileOutputStream fos=new FileOutputStream(file);
                        byte[] b=new byte[1024];
                        int len;
                        while((len=is.read(b)) != -1){
                            fos.write(b,0,len);
                        }
                        fos.close();
                        socket.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }
}
