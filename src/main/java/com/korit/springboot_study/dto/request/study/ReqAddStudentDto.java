package com.korit.springboot_study.dto.request.study;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "학생 정보 추가 요청 DTO")
public class ReqAddStudentDto {
    @ApiModelProperty(value = "학생 이름", example = "차정민", required = true)
    private String name;
    @ApiModelProperty(value = "학생 나이", example = "28", required = true)
    private Integer age;
}
