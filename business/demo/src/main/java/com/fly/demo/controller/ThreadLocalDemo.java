package com.fly.demo.controller;

import com.fly.demo.thread.ExecutorSingleton;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 *  
 *    
 *  @author liaoqinghui  
 *  @time 2019.07.05 14:50  
 */
public class ThreadLocalDemo implements Runnable{

    /**
     * list 不是线程安全的，所以每个线程都要有自己独立的副本
     */
    private static ThreadLocal<List> threadLocal = new ThreadLocal<>();

    public static void main(String[] args)  {
        ExecutorService service= ExecutorSingleton.getInstance().excutors();
        ThreadLocalDemo obj = new ThreadLocalDemo();
        for (int i = 0; i < 10; i++) {
            service.execute(new Thread(obj,"thread"+i));
        }
        System.out.println("asdasd");
    }

    @Override
    public void run() {
        List<String> list = new ArrayList<>();
        list.add(Thread.currentThread().getName());
        threadLocal.set(list);
        list.add(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getName() + ":" + threadLocal.get());
    }


}
