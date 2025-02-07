package com.korit.springboot_study.controller;

import com.korit.springboot_study.dto.response.common.SuccessResponseDto;
import com.korit.springboot_study.entity.Author;
import com.korit.springboot_study.entity.Publisher;
import com.korit.springboot_study.service.AuthorService;
import com.korit.springboot_study.service.PublisherService;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Validated
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @GetMapping("/api/study/Authors")
    @ApiOperation(value = "저자 전체 조회")
    public ResponseEntity<SuccessResponseDto<List<Publisher>>> getPublishers() throws NotFoundException {

        return ResponseEntity.ok().body(publisherService.getPublishersAll());
    }
}
