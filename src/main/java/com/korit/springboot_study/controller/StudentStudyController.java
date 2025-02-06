package com.korit.springboot_study.controller;

import com.korit.springboot_study.dto.entity.study.Instructor;
import com.korit.springboot_study.dto.entity.study.Major;
import com.korit.springboot_study.dto.request.study.ReqAddInstructorDto;
import com.korit.springboot_study.dto.request.study.ReqAddMajorDto;
import com.korit.springboot_study.dto.request.study.ReqUpdateMajorDto;
import com.korit.springboot_study.dto.response.common.SuccessResponseDto;
import com.korit.springboot_study.service.StudentStudyService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.regex.Pattern;

@RestController
@Validated
public class StudentStudyController {

    @Autowired
    private StudentStudyService studentStudyService;

    @GetMapping("/api/study/majors")
    @ApiOperation(value = "학과 전체 조회")
    public ResponseEntity<SuccessResponseDto<List<Major>>> getMajors() throws NotFoundException {

        return ResponseEntity.ok().body(studentStudyService.getMajorAll());
    }

    @GetMapping("/api/study/Instructors")
    public ResponseEntity<SuccessResponseDto<List<Instructor>>> getInstructor() throws NotFoundException {

        return ResponseEntity.ok().body(studentStudyService.getInstructorsAll());
    }

    @PostMapping("/api/study/major")
    public ResponseEntity<SuccessResponseDto<Major>> addMajor(
            // @Valid 유효성 검사
            @Valid @RequestBody ReqAddMajorDto reqAddMajorDto)
            throws MethodArgumentNotValidException {
        System.out.println(reqAddMajorDto);
        boolean isNull = reqAddMajorDto == null;
        boolean isBrank = reqAddMajorDto.getMajorName().isBlank();
        boolean isKor = Pattern.matches("^[ㄱ-ㅎ|가-힣]*$", reqAddMajorDto.getMajorName());

        if (isNull || isBrank || isKor) {
            BindingResult bindingResult = new BeanPropertyBindingResult(null, "major");

            throw new MethodArgumentNotValidException(null, bindingResult);
        }

        return ResponseEntity.ok().body(studentStudyService.addMajor(reqAddMajorDto));
    }

    @PostMapping("/api/study/Instructor")
    public ResponseEntity<SuccessResponseDto<Instructor>> addInstructor(@RequestBody ReqAddInstructorDto reqAddInstructorDto) {
        System.out.println(reqAddInstructorDto);
        return ResponseEntity.ok().body(studentStudyService.addInstructor(reqAddInstructorDto));
    }

    @PutMapping("/api/study/Major/{majorId}")
    public ResponseEntity<SuccessResponseDto<Major>> updateMajor(
            @ApiParam(value = "학과 ID", example = "1", required = true)
            @PathVariable @Min(value = 1, message = "학과 ID는 1 이상의 정수여야합니다.") int majorId,
            @Valid @RequestBody ReqUpdateMajorDto reqUpdateMajorDto) throws MethodArgumentNotValidException, NotFoundException {

        return ResponseEntity.ok().body(studentStudyService.updateMajor(majorId,reqUpdateMajorDto));

    }
}