package com.orit.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Scope("prototype")
public class TestBean {
    private long count = 0;

    private ConcurrentHashMap<Long, Connect> connects = new ConcurrentHashMap<>();

    public long counter(long id) {
        Connect connect = connects.get(id);
        if (connect == null) {
            connect = new Connect();
            connects.put(id, connect);
        }
       return connect.send();
    }
}
