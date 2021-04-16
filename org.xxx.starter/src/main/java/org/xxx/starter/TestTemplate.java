package org.xxx.starter;

import org.springframework.beans.factory.annotation.Autowired;


public class TestTemplate {

    @Autowired
    MyProperties myProperties;


    public String get(String str) {
        return myProperties.getPrefix() + str;
    }
}
