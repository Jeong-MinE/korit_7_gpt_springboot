package com.korit.springboot_study.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ReqAddBookDto {

    @ApiModelProperty(value = "도서명", example = "미술관 건축여행", required = true)
    private String bookName;

}
