package com.korit.springboot_study.ioc;

import org.springframework.asm.ByteVector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigA {

    @Bean(value = "aaa")
    public ClassD call() { // 메소드명이 컴포넌트명이 된다.

        System.out.println("ConfigA call");
        // ClassD에 바로 컴포넌트를 사용하지 않은 이유
        // 1. 생성자를 통해 매개변수를 다르게 줘야할 때, 2. 라이브러리에 들어있는 객체를 생성해서 Bean으로 등록해야할 때
        return new ClassD();
    }

    @Bean
    public ByteVector byteVector() {
        return new ByteVector();
    }
}
