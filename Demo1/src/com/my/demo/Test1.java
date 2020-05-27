package com.my.demo;

/**
 * Author：Jiang
 * Date：2019/9/28 20:47
 */
public class Test1 {
    public static void main(String[] args) {
        System.out.println("又来了");
        String a = "醉了醉了";
        System.out.println(a);
        for (int i = 0; i <10 ; i++) {
            System.out.println("咋了"+i);
        }

        test();
        System.out.println("结束了");
    }

    /**
     * test方法debug
     */
    public static void test(){
        System.out.println("我是test方法！");
    }
}
