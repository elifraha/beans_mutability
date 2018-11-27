package com.orit.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.BrowserCallback;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.SessionCallback;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.jms.*;
import java.util.Enumeration;
import java.util.concurrent.*;

@Service
public class Fetcher {

    private JmsTemplate jmsTemplate;
    private Logger LOG = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private GreetingExc greetingExc;

//    @Autowired
//    private GreetingExc greetingExc1;
//
//    @Autowired
//    private GreetingExc greetingExc2;
//
//    @Autowired
//    private GreetingExc greetingExc3;
//
//    @Autowired
//    private GreetingExc greetingExc4;
//
//    @Autowired
//    private GreetingExc greetingExc5;

    private Integer count;

    public Fetcher(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;


    }

    @Scheduled(fixedDelay = 100)
    void makeGreeting() throws InterruptedException {
        this.count = (Integer) this.jmsTemplate.browse("greetings", new BrowserCallback<Integer>() {
            @Override
            public Integer doInJms(Session session, QueueBrowser browser)  throws JMSException {
                Enumeration<Message> messageEnumeration = browser.getEnumeration();

                int count = 0;
                while (messageEnumeration.hasMoreElements()) {
                    count ++;
                    messageEnumeration.nextElement();
                }
                return new Integer(count);
            }
        });

        if (count > 10) {
           // LOG.info("********** Queue Busy *******");
        } else {
            jmsTemplate.convertAndSend("greetings", new Greeting());
            //LOG.info("********** Added new Greeting Message Count: " + count);
        }



      //  LOG.info("********** Message Count: " + count);
    }
}
