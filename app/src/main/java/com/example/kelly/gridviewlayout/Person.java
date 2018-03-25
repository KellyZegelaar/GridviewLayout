package com.example.kelly.gridviewlayout;

import java.io.Serializable;

/**
 * Created by kelly on 23-3-2018.
 */

public class Person implements Serializable {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
