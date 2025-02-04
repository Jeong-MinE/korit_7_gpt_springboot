package com.korit.springboot_study.dto.request.study;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data // DTO 생성 시 Data 어노테이션 필수(getter, setter 때문)
// 필수적인 필드를 초기화하는 생성자를 자동으로 생성해주는 역할을 한다. 주로 final 필드나 **@NonNull**로 지정된 필드들에 대해 생성자를 만들어준다.
@RequiredArgsConstructor
// 클래스에 선언된 모든 필드에 대한 생성자를 생성, 생성자 주입 시 사용
@AllArgsConstructor
@ApiModel(description = "학생정보 조회 학습 DTO")
public class ReqStudentDto {
    // getter, setter 필요(캡슐화:객체의 상태(즉, 필드나 데이터)는 외부에서 직접 접근하지 못하고 메소드를 통해 접근하도록 제한하는 것)
    // getter : 필드 값 읽는 메소드, setter : 필드 값 수정 메소드
    // 데이터 접근 제어
    @ApiModelProperty(value = "학생 이름", example = "차정민", required = true)
    private String name;

    @ApiModelProperty(value = "학생 나이", example = "28", required = true)
    private int age;
    ReqStudentDto reqStudentDto;
}
