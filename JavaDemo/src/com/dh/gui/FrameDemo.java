package com.dh.gui;

import java.awt.*;
import java.awt.event.*;

/**
 * GUI图形界面·
 */
public class FrameDemo {
    public static void main(String[] args) {
        Frame f=new Frame("我的第一个窗口");
        f.setSize(600,800);  //窗口大小
        f.setLocation(700,100);        //窗口位置

        Button b=new Button("ok");
        f.add(b);
        f.setLayout(new FlowLayout());    //流式布局管理器(从左到右顺序) Panel默认
                                          //BorderLayout 边界布局管理器(东南西北中) Frame默认

        //窗口监听
        f.addWindowListener(new WindowAdapter() {   //WindowAdapter的匿名类，重写windowClosing()
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        /*
            鼠标监听：同样实现退出
        */
        b.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                System.exit(0);
            }
        });

        /*
            键盘监听：实现退出
         */
        b.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_SPACE) { //按空格键退出
                    System.exit(0);
                }
            }
        });

        /*
            动作监听：addActionListener(new ActionListener(){重写actionPerformed(ActionEvent e)});
         */

        f.setVisible(true);               //窗口可见
    }
}
