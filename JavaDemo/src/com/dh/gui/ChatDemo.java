package com.dh.gui;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 窗口聊天
 * 1.一个窗口中新建三个panel，上面显示聊天记录、中间显示发送消息、下面显示ip和按钮
 */
public class ChatDemo extends Frame {

    public  ChatDemo(){
        init();
        southPanel();
        centerPanel();
    }

    //初始化窗口
    public void init(){
        this.setSize(600,800);
        this.setLocation(700,100);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.setVisible(true);
    }

    //南边的按钮panel
    public void southPanel(){
        Panel south=new Panel();
        TextField tf=new TextField(30); //文本框
        Button send=new Button("Send");
        Button log=new Button("Record");
        Button clear=new Button("Clear");
        Button shake=new Button("Shake");
        south.add(tf);              //按钮添加到panel
        south.add(send);
        south.add(log);
        south.add(clear);
        south.add(shake);
        this.add(south,BorderLayout.SOUTH);  //south添加到窗口南边
    }

    //中间panel
    public void centerPanel(){
        Panel center=new Panel();
        TextArea view=new TextArea();
        TextArea send=new TextArea(5,1);
        center.setLayout(new BorderLayout()); //设置为边界布局
        center.add(send,BorderLayout.SOUTH);
        center.add(view,BorderLayout.CENTER);
        view.setEditable(false);
        send.setFont(new Font("xxx",Font.PLAIN,15));
        this.add(center,BorderLayout.CENTER); //Panel添加到窗口
    }

    public static void main(String[] args) {
        new ChatDemo();
    }
}
