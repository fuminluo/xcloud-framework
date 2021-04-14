package com.xcloud.framework.demo.starter;

import org.springframework.beans.factory.annotation.Autowired;

public class XxTemplate {

    @Autowired
    XxProperties xxProperties;


    public String get(String str) {
        return xxProperties.getName() + str;
    }
}
