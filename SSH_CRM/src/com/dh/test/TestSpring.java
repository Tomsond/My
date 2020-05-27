package com.dh.test;

/**
 * 测试spring
 */
public class TestSpring {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void hello(){
        System.out.println("hello "+getName());
    }
}
