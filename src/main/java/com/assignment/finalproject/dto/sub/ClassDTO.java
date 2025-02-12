package com.assignment.finalproject.dto.sub;

import com.assignment.finalproject.entity.sub.Classes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;

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

    public ClassDTO(String classId) {
        this.classId = classId;
    }
}
