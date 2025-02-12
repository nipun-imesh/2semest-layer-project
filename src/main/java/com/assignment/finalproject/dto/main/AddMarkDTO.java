package com.assignment.finalproject.dto.main;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@NoArgsConstructor
@Data
@ToString
public class AddMarkDTO {
    private String grade;
    private String classId;

    public AddMarkDTO(String grade , String classId) {
        this.classId = classId;
        this.grade = grade;
    }

    public AddMarkDTO(String grade) {
        this.grade = grade;
    }
}
