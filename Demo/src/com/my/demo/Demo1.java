package com.my.demo;

import org.apache.log4j.Logger;

/**
 * Author：Jiang
 * Date：2019/10/3 15:43
 */
public class Demo1 {

        private final static Logger logger = Logger.getLogger(Demo1.class);

        public static void main(String[] args) {
            logger.info("我是第一个日志信息哦~");
            System.out.println("xx");
            test("啥");
        }

        /*
         *param:
         *return:
         *author:
         *date: 
         */
        private static void test(String name){
            System.out.println("测试方法注释");
        }
}
