package com.assignment.finalproject.entity.sub;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Classes {
    private String classId;
    private int grade;

    public Classes(String classId, String grade) {
        this.classId = classId;
        this.grade = Integer.parseInt(grade);
    }

    public Classes(String string) {
        this.classId = string;
    }
}
