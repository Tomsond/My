package com.dh.study;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *输入多个整数，quit时结束，并倒序输出整数
 */
public class SortTest1 {
    public static void main(String[] args) {
        //输入
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入整数：");
        //HashSet存储并倒序
        TreeSet<Integer> ts=new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int num=o2.compareTo(o1);
                return num == 0 ? 1 : num;
            }
        });

        //将输入的数放入集合
        while(true) {
            String line = sc.nextLine();
            if("quit".equals(line)){break;}
            Integer i=Integer.parseInt(line); //输入的字符串转数字
            ts.add(i);
        }
        //遍历集合
        for (Integer s: ts) {
            System.out.println(s);
        }
    }
}
