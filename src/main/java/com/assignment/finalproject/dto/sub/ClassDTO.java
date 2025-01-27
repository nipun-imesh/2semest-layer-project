package com.assignment.finalproject.dto.sub;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ClassDTO {
    private String classId;
    private int grade;

    public ClassDTO(String classId, String grade) {
        this.classId = classId;
        this.grade = Integer.parseInt(grade);
    }

    public ClassDTO(String string) {
        this.classId = string;
    }
}
