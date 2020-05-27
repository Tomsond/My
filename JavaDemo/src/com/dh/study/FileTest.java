package com.dh.study;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * IO流
 */
public class FileTest {
    public static void main(String[] args) throws IOException {
        //createFile();
        //readFile();
        //writeFile();
        //copyFile();
        //copyFileChar();
        //bufferedReader();
        reverseTxt();
    }

    //创建文件
    public static void createFile() throws IOException{
        File f=new File("a.txt");
        System.out.println(f.createNewFile());
    }

    //读取文件
    public static void readFile() throws IOException {
        InputStream fis=new FileInputStream("a.txt");
        byte[] b=new byte[10];
        int len; //接收读到的长度
        while((len=fis.read(b))!=-1){
            System.out.println(new String(b,0,len));
        }
        fis.close();
    }

    //写出文件
    public static void writeFile() throws  IOException{
        OutputStream os=new FileOutputStream("a.txt",true); //原有追加true
        String str="d";
        byte[] b=str.getBytes();
        os.write(b);
        os.flush();
        os.close();
    }

    //拷贝文件
    public static void copyFile() throws  IOException{
        InputStream is=new FileInputStream("d:/a.txt");
        OutputStream os=new FileOutputStream("d:/a/b.txt");
        byte[] b=new byte[10];
        int len;
        while((len=is.read(b)) != -1){
            os.write(b,0,len);
        }
        os.flush();
        is.close();
    }

    //字符流
    public static void copyFileChar() throws  IOException{
        Reader r=new FileReader("d:/a.txt");
        Writer w=new FileWriter("d:/a/b.txt");
        char[] c=new char[1024];
        int len;
        while((len=r.read(c)) != -1){
            w.write(c,0,len);
        }
        w.flush();
        w.close();
        r.close();
    }

    //缓冲字符流
    public static void bufferedReader() throws IOException{
        File f=new File("d:/a.txt");
        //转换流解决中文乱码
        BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(f),"gbk"));
        //BufferedWriter bw=new BufferedWriter(new FileWriter("d:/a/b.txt"));
        String line;
        while((line=br.readLine()) != null){
          //  bw.write(line);
            //bw.newLine();
            System.out.println(line);
        }
        //bw.flush();
        //bw.close();
        br.close();
    }

    //反转输出a.txt内容
    public static  void reverseTxt() throws  IOException{
        File f1=new File("d:/a.txt");
        File f2=new File("d:/a/b.txt");
        //转换流解决中文乱码，读的编码与文件编码一致
        BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(f1),"utf-8"));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f2),"utf-8"));
        //创建集合存储line,反序遍历
        List<String> list=new ArrayList<>();
        String line;
        while((line=br.readLine()) != null){
            list.add(line);
        }
        for(int i=list.size()-1;i>=0;i--){
            bw.write(list.get(i));
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
