package com.fly.demo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *  
 *    
 *  @author liaoqinghui  
 *  @time 2019.08.01 16:16  
 */
public class ExecutorSingleton {

    private ExecutorService executorService;


    private ExecutorSingleton() {

        executorService = new ThreadPoolExecutor(10, 20, 60,
                TimeUnit.MINUTES, new LinkedBlockingDeque<>());

    }

    public static ExecutorSingleton getInstance() {
        return Executor.e;
    }


    private static class Executor {
        private static final ExecutorSingleton e = new ExecutorSingleton();
    }

    public ExecutorService excutors(){
        return executorService;
    }
}
