package com.dh.study;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Calendar类
 */
public class CalendarTest {
    public static void main(String[] args) {
        Calendar c=Calendar.getInstance(); //new GregorianCalendar();
//        c.add(Calendar.YEAR,-1);   回退一年
//        c.set(Calendar.MONTH,7);   设置指定年份
//        c.set(2010,8,2);           设置日期，注意：9月才设置8
        System.out.println(c.get(Calendar.YEAR));
        System.out.println(c.get(Calendar.MONDAY));
        System.out.println(c.get(Calendar.DAY_OF_MONTH));
        System.out.println(c.get(Calendar.DAY_OF_WEEK)); //1代表星期日
        System.out.println(c.get(Calendar.YEAR)+"年"+(c.get(Calendar.MONTH)+1)+"月"+c.get(Calendar.DAY_OF_MONTH)
        +"日"+getWeek(c.get(Calendar.DAY_OF_WEEK)));
    }

    public static String getWeek(int week){
        String[] arr={"","星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
        return arr[week];
    }
}
