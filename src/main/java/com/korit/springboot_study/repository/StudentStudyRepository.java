package com.korit.springboot_study.repository;

import com.korit.springboot_study.dto.entity.study.Instructor;
import com.korit.springboot_study.dto.entity.study.Major;
import com.korit.springboot_study.exception.CustomDuplicateKeyException;
import com.korit.springboot_study.mapper.StudentStudyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository // Repository 컴포넌트 생성
public class StudentStudyRepository {

    @Autowired
    private StudentStudyMapper studentStudyMapper;

    public Optional<List<Major>> findMajorAll() {
        List<Major> foundMajors = studentStudyMapper.selectMajorsAll();

            if (foundMajors.isEmpty()) {
                return Optional.empty();
            }

//            return foundMajors.isEmpty()
//                    ? Optional.empty() 삼항연산자를 사용하여
//                    : Optional.ofNullable(foundMajors)

        return Optional.ofNullable(foundMajors); // Null일 수 없는 경우 of 사용
    }

    public Optional<List<Instructor>> findInstructorAll() {
        List<Instructor> foundInstructors = studentStudyMapper.selectInstructorsAll();

        if (foundInstructors.isEmpty()) {
            return Optional.empty();
        }

        return foundInstructors.isEmpty()
                ?Optional.empty()
                :Optional.ofNullable(foundInstructors);
    }

    public Optional<Major> saveMajor(Major major) {
        try {
            studentStudyMapper.insertMajor(major);
        } catch (DuplicateKeyException e) {

            throw new CustomDuplicateKeyException(
                    e.getMessage(),
                    Map.of("majorName", "이미 존재하는 학과명 입니다.")
            );
        }

        studentStudyMapper.insertMajor(major);

        return Optional.ofNullable(new Major(major.getMajorId(), major.getMajorName()));
    }

    public Optional<Instructor> saveInstructor(Instructor instructor) {

        try {
            studentStudyMapper.insertInstructor(instructor);
        } catch (DuplicateKeyException e) {

            throw new CustomDuplicateKeyException(
                    e.getMessage(),
                    Map.of("instructorName", "이미 존재하는 교수명 입니다.")
            );
        }

        return Optional.ofNullable(new Instructor(instructor.getInstructorId(), instructor.getInstructorName()));
    }
}