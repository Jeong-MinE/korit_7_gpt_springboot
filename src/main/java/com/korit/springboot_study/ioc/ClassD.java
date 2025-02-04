package com.korit.springboot_study.ioc;

import org.springframework.context.annotation.Configuration;

@Configuration
public class ClassD {

    public void classDCall() {
        System.out.println("ClassD");
    }
}
