package com.fly.demo.controller;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

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

    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
//        ExecutorService service= ExecutorSingleton.getInstance().excutors();
//        ThreadLocalDemo obj = new ThreadLocalDemo();
//        for (int i = 0; i < 10; i++) {
//            service.execute(new Thread(obj,"thread"+i));
//        }
        //1 2的0次方
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] digest = md5.digest("44444444444asdasdasd".getBytes());

        Base64.Encoder encoder = Base64.getEncoder();

        System.out.println(encoder.encodeToString(digest));
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
