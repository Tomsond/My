package com.dh.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Test2 {
    public static void main(String[] args) {
        ApplicationContext ac=new FileSystemXmlApplicationContext("web/WEB-INF/applicationContext.xml");
        TestSpring ts= (TestSpring) ac.getBean("testSpring");
        ts.hello();
    }
}
