package com.tosan.core;

import com.tosan.core.thread.SimpleTestThread;

public class Test2 {

    public static void main(String[] args) {
        SimpleTestThread simpleTestThread = new SimpleTestThread(100);
        simpleTestThread.start();


        StringBuilder builder = new StringBuilder();
        StringBuffer stringBuffer = new StringBuffer();


        Thread stopper = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5_000);
                    System.out.println(Thread.currentThread().getName() + "_ ending execution of thread " + simpleTestThread.getName());
                    simpleTestThread.interrupt();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        stopper.start();
    }


}
