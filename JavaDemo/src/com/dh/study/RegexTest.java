package com.dh.study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式
 */
public class RegexTest {
    public static void main(String[] args) {
        //Pattern、matches
        Pattern p = Pattern.compile("a*b");
        Matcher m=p.matcher("aaab");
        System.out.println(m.matches());
        p1();

    }

    /*
        m.find()和m.group()
     */
    public static void p1(){
        String s="我手机号15212124512,他手机号13212544562";
        String regex="1[358]\\d{9}";
        Pattern p=Pattern.compile(regex);
        Matcher m=p.matcher(s);
        while(m.find()){                    //m.find()查找是否存在->m.group()显示出来
            System.out.println(m.group());
        }
    }
}

