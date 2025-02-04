package com.korit.springboot_study.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor // final or NonNull일 때만 사용 가능
public class IocController {



    @GetMapping("/api/ioc")
    public ResponseEntity<?> call() {

        return ResponseEntity.ok(null);
    }
}
