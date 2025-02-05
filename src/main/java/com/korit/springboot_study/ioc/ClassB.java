package com.korit.springboot_study.ioc;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ClassB {

    @Qualifier(value = "c1")
    @Autowired
    private ClassC c1;

    @Qualifier(value = "c2")
    @Autowired
    private ClassC c2;

//    @Qualifier(value = "classC2") // 주입할 빈 지정(= 여러 타입 빈이 있으면 Autowired로 자동 주입 어려움)
//    @Autowired // 타입에 맞는 빈을 찾아 자동 주입
//    private ClassC c;

    public void classCallB() {
        System.out.println("ClassB 메소드 호출");
    }
}
