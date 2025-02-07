package com.korit.springboot_study.entity.study;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Major {
    private int majorId;
    private String majorName;
}
