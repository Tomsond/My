package com.dh.study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 斗地主游戏
 * Collections.shuffle()
 * 思路：
 * 1.牌面字和花色存于集合中
 * 2.洗牌
 * 3.发牌
 * 4.看牌
 */
public class PokerTest {
    public static void main(String[] args) {
        //1.定义牌面数字和花色
        String[] num = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] color = {"黑桃", "梅花", "红桃", "方片"};
        //2.定义集合,存于集合
        List<String> list = new ArrayList<>();
        for (String s1 : color) {
            for (String s2 : num) {
                list.add(s1.concat(s2));
            }
        }
        list.add("大王");
        list.add("小王");
//        System.out.println(list);
        //3.洗牌
        Collections.shuffle(list);
        //4.发牌   发三个人，三个集合
        List<String> Tom=new ArrayList<>();
        List<String> Jack=new ArrayList<>();
        List<String> Rose=new ArrayList<>();
        List<String> Floor=new ArrayList<>();//底牌
        for (int i=0;i<list.size();i++){
            if(i >= list.size()-3){ //底牌
                Floor.add(list.get(i));
            }else if(i % 3 == 0){ //Tom  0.3.6....
                Tom.add(list.get(i));
            } else if(i % 3 == 1){ //Jack 2.4.7...
                Jack.add(list.get(i));
            }else{  //Rose    1.5.8...
                Rose.add(list.get(i));
            }
        }
        //4.看牌
        System.out.println("Tom的牌："+Tom);
        System.out.println("Jack的牌："+Jack);
        System.out.println("Rose的牌："+Rose);
        System.out.println("底牌："+Floor);
    }
}
