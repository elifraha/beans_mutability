package com.orit.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Runner {

    private Logger Log = LoggerFactory.getLogger(this.getClass().getName());
    @Autowired
    private Job job;

    @Scheduled(fixedDelay = 1500)
    void count() {
        this.job.counter();
       // Log.info("### Runner: count: " + this.job.getCount());
    }
}
