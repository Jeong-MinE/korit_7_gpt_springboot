package com.korit.springboot_study.service;

import com.korit.springboot_study.dto.entity.study.Instructor;
import com.korit.springboot_study.dto.entity.study.Major;
import com.korit.springboot_study.dto.request.study.ReqAddInstructorDto;
import com.korit.springboot_study.dto.request.study.ReqAddMajorDto;
import com.korit.springboot_study.dto.request.study.ReqUpdateMajorDto;
import com.korit.springboot_study.dto.response.common.SuccessResponseDto;
import com.korit.springboot_study.repository.StudentStudyRepository;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.concurrent.SuccessCallback;

import java.util.List;

@Service    // Service 컴포넌트 생성
public class StudentStudyService {

    @Autowired
    private StudentStudyRepository studentStudyRepository;
    private ReqAddMajorDto major;

    public SuccessResponseDto<List<Major>> getMajorAll() throws NotFoundException {

        List<Major> foundMajor = studentStudyRepository.findMajorAll()
                .orElseThrow(() -> new NotFoundException("학과 데이터가 존재하지 않습니다."));

        return new SuccessResponseDto<>(foundMajor);
    }

    private ReqAddInstructorDto instructor;
    public SuccessResponseDto<List<Instructor>> getInstructorsAll() throws NotFoundException {

        List<Instructor> foundInstructors =
                studentStudyRepository
                        .findInstructorAll()
                        .orElseThrow(() -> new NotFoundException("교수 데이터가 존재하지 않습니다."));

        return new SuccessResponseDto<>(foundInstructors);
    }

    @Transactional(rollbackFor = Exception.class)
    public SuccessResponseDto<Major> addMajor(ReqAddMajorDto reqAddMajorDto) throws DuplicateKeyException {
        return new SuccessResponseDto<>(
                studentStudyRepository
                        .saveMajor(new Major(0, reqAddMajorDto.getMajorName()))
                        .get()
        );
    }

    @Transactional(rollbackFor = Exception.class)
    public SuccessResponseDto<Instructor> addInstructor(ReqAddInstructorDto reqAddInstructorDto) throws DuplicateKeyException {
        return new SuccessResponseDto<>(
                studentStudyRepository
                        .saveInstructor(new Instructor(0, reqAddInstructorDto.getInstructorName()))
                        .get()
        );
    }

    @Transactional(rollbackFor = Exception.class) // insert, update, delete 롤백 적용 필수
    public SuccessResponseDto<Major> updateMajor(int majorId, ReqUpdateMajorDto reqUpdateMajorDto) throws DuplicateKeyException, NotFoundException { //modifyMajor()
               Major updateMajor = studentStudyRepository.
                       updateMajor(new Major(majorId, reqUpdateMajorDto.getMajorName()))
                       .orElseThrow(() -> new NotFoundException("해당 학과 ID는 존재하지 않습니다.")); // modifiedMajor() 가능
        return new SuccessResponseDto<>(updateMajor);

    }
}