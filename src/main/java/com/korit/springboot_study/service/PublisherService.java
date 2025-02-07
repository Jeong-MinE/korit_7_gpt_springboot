package com.korit.springboot_study.service;

import com.korit.springboot_study.dto.request.ReqAddPublisherDto;
import com.korit.springboot_study.dto.response.common.SuccessResponseDto;
import com.korit.springboot_study.entity.Publisher;
import com.korit.springboot_study.repository.PublisherRepository;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;
    private ReqAddPublisherDto publisher;

    public SuccessResponseDto<List<Publisher>> getPublishersAll() throws NotFoundException {

        List<Publisher> foundPublisher = publisherRepository.findPublisherAll()
                .orElseThrow(() -> new NotFoundException(""));

        return new SuccessResponseDto<>(foundPublisher);
    }

}
