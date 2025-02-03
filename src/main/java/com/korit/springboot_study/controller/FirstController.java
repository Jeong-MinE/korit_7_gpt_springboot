package com.korit.springboot_study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // 어노테이션 필수 작성
public class FirstController {

    @GetMapping("/mvc/hello") // mvc 프리픽스, hello 서브픽스
    public String hello(Model model) {
        model.addAttribute("name", "차정민");
        System.out.println("hello 메소드 호출");
        return "/resources/templates/hello.html";
    }
}
