package com.sailfish.cache.redis;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * @author XIAXINYU3
 * @date 2021/3/22
 */
public class TimestampTest {

    @Test
    public void test() {
        Date date = new Date();
        long t1 = date.getTime();
        System.out.println("t1 = " + t1);


        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        calendar.add(Calendar.DAY_OF_MONTH, 1);
        long t2 = calendar.getTime().getTime();
        System.out.println("t2 = " + t2);

        calendar.add(Calendar.DAY_OF_MONTH, 1);
        long t3 = calendar.getTime().getTime();
        System.out.println("t3 = " + t3);

        calendar.add(Calendar.DAY_OF_MONTH, 1);
        long t4 = calendar.getTime().getTime();
        System.out.println("t4 = " + t4);

        calendar.add(Calendar.DAY_OF_MONTH, 1);
        long t5 = calendar.getTime().getTime();
        System.out.println("t5 = " + t5);

        calendar.add(Calendar.DAY_OF_MONTH, 1);
        long t6 = calendar.getTime().getTime();
        System.out.println("t6 = " + t6);

        System.out.println("gap = " + (t6 - t1) / 1000 / 24 / 5);
    }

    @Test
    public void test2() {
        Date date = new Date();
        long t1 = date.getTime();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR, -1);
        long before = calendar.getTime().getTime();

        System.out.println("before = " + before);
        System.out.println("now = " + t1);

        System.out.println("gap = " + (before - t1) / 1000);
    }

    @Test
    public void test3(){
        Date date = new Date();
        long end = date.getTime();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR, -1);
        long start = calendar.getTime().getTime();

        System.out.println(date);
        System.out.println(new Date(start));

        System.out.println(start);
        System.out.println(end);
    }

    @Test
    public void test4(){
        long start = 1617160628910l;
        long end = 1617162205177l;

        System.out.println(new Date(start));
        System.out.println(new Date(end));
    }
}
