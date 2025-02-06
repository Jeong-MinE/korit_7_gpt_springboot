package com.korit.springboot_study.controller;

import com.korit.springboot_study.dto.entity.Author;
import com.korit.springboot_study.dto.response.common.SuccessResponseDto;
import com.korit.springboot_study.service.AuthorService;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Validated
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/api/study/Authors")
    @ApiOperation(value = "저저 전체 조회")
    public ResponseEntity<SuccessResponseDto<List<Author>>> getAuthors() throws NotFoundException {

        return ResponseEntity.ok().body(authorService.getAuthorAll());
    }
}
