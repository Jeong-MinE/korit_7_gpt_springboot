package com.korit.springboot_study.service;

import com.korit.springboot_study.entity.Author;
import com.korit.springboot_study.dto.request.ReqAddAuthorDto;
import com.korit.springboot_study.dto.response.common.SuccessResponseDto;
import com.korit.springboot_study.repository.AuthorRepository;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;
    private ReqAddAuthorDto author;

    public SuccessResponseDto<List<Author>> getAuthorAll() throws NotFoundException {

     List<Author> foundAuthor = authorRepository.findAuthorAll()
            .orElseThrow(() -> new NotFoundException("저자가 존재하지 않습니다."));

    return new SuccessResponseDto<>(foundAuthor);
    }
}
