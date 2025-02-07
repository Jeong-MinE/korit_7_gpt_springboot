package com.korit.springboot_study.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReqSearchBookDto {

    @ApiModelProperty(value = "도서명", example = "미술관 건축여행", required = false)
    private String keyword = "";
}
