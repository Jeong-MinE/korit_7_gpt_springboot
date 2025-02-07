package com.korit.springboot_study.dto.request;

import com.korit.springboot_study.entity.Book;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Pattern;

@Data
public class ReqAddBookDto {

    @ApiModelProperty(value = "도서명", example = "미술관 건축여행", required = true)
    @Pattern(regexp = "^(?=.*[가-힣])[\\d가-힣]+$", message = "입력값은 최소한 한 글자 이상의 한글을 포함해야 하며, 숫자는 한글이 포함된 경우에만 사용할 수 있습니다.")
    private String bookName;

    public Book toBook() {
        return Book.builder()
                .bookName(bookName)
                .build();
    }

}
