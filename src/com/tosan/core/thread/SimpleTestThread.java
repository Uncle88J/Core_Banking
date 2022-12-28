package com.tosan.core.thread;

public class SimpleTestThread extends Thread {

    private int startNo;

    public SimpleTestThread(int startNo) {
        this.startNo = startNo;
    }


    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(getName() + " _ is Working");
                sleep(1_000);
            } catch (InterruptedException e) {
                System.out.println(getName() + " _ End execution");
                break;
            }
        }
    }
}
