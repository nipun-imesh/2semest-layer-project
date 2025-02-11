package com.assignment.finalproject.entity.main;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class StudentManage {
    private String studentId;
    private String studentName;
    private int age;
    private String dateofBarth;
    private String grade;
    private String S_class;
    private String parentId;
    private String status = "Active";


    public StudentManage(String studentName, int age, String dateofBarth, String grade, String sClass, String parentId, String studentId) {
        this.studentName = studentName;
        this.age = age;
        this.dateofBarth = dateofBarth;
        this.grade = grade;
        S_class = sClass;
        this.parentId = parentId;
        this.studentId = studentId;
    }
}
