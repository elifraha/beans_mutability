package com.orit.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class Runner1 {

    private Logger Log = LoggerFactory.getLogger(this.getClass().getName());
    @Autowired
    private Job job;

    @Scheduled(fixedDelay = 1000)
    void count() {
        this.job.counter();
        //Log.info("### RunnerOne: count: " + this.job.getCount());
    }

}
