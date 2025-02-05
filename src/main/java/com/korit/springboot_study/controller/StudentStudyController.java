package com.korit.springboot_study.controller;

import com.korit.springboot_study.dto.entity.study.Instructor;
import com.korit.springboot_study.dto.entity.study.Major;
import com.korit.springboot_study.dto.request.study.ReqAddInstructorDto;
import com.korit.springboot_study.dto.request.study.ReqAddMajorDto;
import com.korit.springboot_study.dto.response.common.NotFoundResponseDto;
import com.korit.springboot_study.dto.response.common.ResponseDto;
import com.korit.springboot_study.dto.response.common.SuccessResponseDto;
import com.korit.springboot_study.mapper.StudentStudyMapper;
import com.korit.springboot_study.service.StudentStudyService;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.Getter;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentStudyController {

    @Autowired
    private StudentStudyService studentStudyService;

    @GetMapping("/api/study/majors")
    @ApiOperation(value = "학과 전체 조회")
    public ResponseEntity<SuccessResponseDto<List<Major>>> getMajors() throws NotFoundException {

        return ResponseEntity.ok().body(studentStudyService.getMajorsAll());
    }

    @GetMapping("/api/study/Instructors")
    public ResponseEntity<SuccessResponseDto<List<Instructor>>> getInstructor() throws NotFoundException {

        return ResponseEntity.ok().body(studentStudyService.getInstructorsAll());
    }

    @PostMapping("/api/study/major")
    public ResponseEntity<SuccessResponseDto<?>> addMajor(@RequestBody ReqAddMajorDto reqAddMajorDto) {
        System.out.println(reqAddMajorDto);
        return ResponseEntity.ok().body(studentStudyService.addMajor(reqAddMajorDto));
    }

    @PostMapping("/api/study/Instructor")
    public ResponseEntity<SuccessResponseDto<?>> addInstructor(@RequestBody ReqAddInstructorDto reqAddInstructorDto) {
        System.out.println(reqAddInstructorDto);
        return ResponseEntity.ok().body(null);
    }
}