package com.korit.springboot_study.controller;

import com.korit.springboot_study.dto.request.ReqAddBookDto;
import com.korit.springboot_study.dto.request.ReqSearchBookDto;
import com.korit.springboot_study.entity.Book;
import com.korit.springboot_study.dto.response.common.SuccessResponseDto;
import com.korit.springboot_study.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Api(tags = "카테고리 API")
public class BookController {

    @Autowired
    private BookService bookService;

    @ApiOperation(value = "도서명 추가")
    @PostMapping("/api/book")
    public ResponseEntity<SuccessResponseDto<Book>> addBook(@Valid @RequestBody ReqAddBookDto reqAddBookDto) {
        return ResponseEntity.ok(new SuccessResponseDto<>(bookService.addBook(reqAddBookDto)));
    }
    @ApiOperation(value = "도서명 검색")
    @GetMapping("/api/book")
    public ResponseEntity<SuccessResponseDto<List<Book>>> searchCategory(@ModelAttribute ReqSearchBookDto searchbookDto) throws Exception {
        return ResponseEntity.ok().body(new SuccessResponseDto<>(bookService.getBooks(searchbookDto)));
    }
}
