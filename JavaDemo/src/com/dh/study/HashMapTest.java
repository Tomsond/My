package com.dh.study;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * HashMap的遍历方式之：Map.Entry<K,V>
 * 其他方式：keySet、iterator
 */
public class HashMapTest {
    public static void main(String[] args) {
        Map<String,Integer> m=new HashMap<>();
        m.put("张三",1);
        m.put("李四",2);
        m.put("王五",3);
        //Set<Map.Entry<String,Integer>> entrySet=m.entrySet(); //entry对象放到Set集合
        for (Map.Entry<String,Integer> entry: m.entrySet()) { //m.entrySet()
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }
}
