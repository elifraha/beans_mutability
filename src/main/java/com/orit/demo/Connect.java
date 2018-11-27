package com.orit.demo;

public class Connect {
    private int counter = 0;
    private int limitCounter = 30;
    private long count = 0;

    private void resetCounter() {
        counter = 0;
    }

    public long send() {
        if (counter > limitCounter) {
            resetCounter();
        }
        count++;
        System.out.println("########################## Just sent something");
        return count;
    }
}
