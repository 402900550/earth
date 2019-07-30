package com.fly.demo2.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *  
 *    
 *  @author liaoqinghui  
 *  @time 2019.07.05 14:50  
 */
public class ThreadLocalDemo {

    // list 不是线程安全的，所以每个线程都要有自己独立的副本
    private static ThreadLocal<List> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {

    System.out.println(lengthOfLongestSubstring("asjrgapa"));

    }

//    @Override
//    public void run() {
//        List<String> list = new ArrayList<>();
//        list.add(Thread.currentThread().getName());
//        threadLocal.set(list);
//        //System.out.println(Thread.currentThread().getName() + ":" + threadLocal.get());
//        list.add(Thread.currentThread().getName());
//        System.out.println(Thread.currentThread().getName() + ":" + threadLocal.get());
//    }


    public static int lengthOfLongestSubstring(String s) {
        if (s == null||"".equals(s)) {
            return 0;
        }
        String str = s;
        List<Character> list = new ArrayList<>();
        List<Integer> len = new ArrayList<>();
        for (int k = 0; k < str.length(); k++) {
            for (int i = str.length()-(str.length()-k); i < str.length(); i++) {
                Character c = str.charAt(i);
                if (!list.contains(c)) {
                    list.add(c);
                    if (i + 1 == str.length()) {
                        len.add(list.size());
                        list.clear();
                    }
                } else {
                    len.add(list.size());
                    list.clear();
                    list.add(c);
                }
            }
        }
        len.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println(len);
        return len.get(0);
    }

}
