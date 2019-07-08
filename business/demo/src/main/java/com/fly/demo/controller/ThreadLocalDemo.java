package com.fly.demo.controller;

import java.util.ArrayList;
import java.util.List;

/**
 *  
 *    
 *  @author liaoqinghui  
 *  @time 2019.07.05 14:50  
 */
public class ThreadLocalDemo implements Runnable{

    // list 不是线程安全的，所以每个线程都要有自己独立的副本
    private static ThreadLocal<List> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalDemo obj = new ThreadLocalDemo();
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(obj, "thread" + i);
            //Thread.sleep(1000);
            t.start();
        }
        System.out.println("asdasd");
    }

    @Override
    public void run() {
        List<String> list = new ArrayList<>();
        list.add(Thread.currentThread().getName());
        threadLocal.set(list);
        //System.out.println(Thread.currentThread().getName() + ":" + threadLocal.get());
        list.add(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getName() + ":" + threadLocal.get());
    }


}
