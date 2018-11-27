package com.orit.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import javax.jms.QueueBrowser;
import javax.print.attribute.standard.QueuedJobCount;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

@Service
//@Scope("prototype")
public class GreetingExc  {
    private Logger LOG = LoggerFactory.getLogger(this.getClass().getName());

    private int ID;

    @Autowired
    private TestBean testBean;

    public GreetingExc() {
        this.ID = new Random().nextInt();
    }
    @JmsListener(destination = "greetings", concurrency = "3")
    public void postCustomerSettlement(Greeting greeting) throws InterruptedException {


        LOG.info("++++ Executor: " + Thread.currentThread().getId() + " Greeting: " + greeting.toString() + " testBean: " + testBean.counter(Thread.currentThread().getId() ));

        Thread.sleep(1000);

        LOG.info("++++ Executor: " + Thread.currentThread().getId() + " Greeting: " + greeting.toString() + " End ++++++");
    }


}
