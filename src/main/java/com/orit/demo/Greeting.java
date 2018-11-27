package com.orit.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Random;


public class Greeting {
    private int id;

    public Greeting() {
        this.id = new Random().nextInt();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
      return "=== ID: " + this.id;
    }
}
