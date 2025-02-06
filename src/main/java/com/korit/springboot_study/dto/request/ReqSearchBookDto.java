package com.korit.springboot_study.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ReqSearchBookDto {

    @ApiModelProperty(value = "도서명")
    private String bookName;
}
