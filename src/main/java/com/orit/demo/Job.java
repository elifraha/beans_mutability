package com.orit.demo;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


public class Job {

    protected int count = 0;

    void counter() {
        this.count++;
    }

    public int getCount() {
        return count;
    }
}
