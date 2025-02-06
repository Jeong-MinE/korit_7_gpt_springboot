package com.korit.springboot_study.mapper;

import com.korit.springboot_study.dto.entity.study.Instructor;
import com.korit.springboot_study.dto.entity.study.Major;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper// Mapper 컴포넌트 생성
public interface StudentStudyMapper {

    List<Major> selectMajorsAll();
    List<Instructor> selectInstructorsAll();
    int insertMajor(Major major);
    int insertInstructor(Instructor instructor);
    int updateMajorName(Major major);


}