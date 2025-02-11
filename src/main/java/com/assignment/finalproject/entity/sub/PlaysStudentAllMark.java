package com.assignment.finalproject.entity.sub;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class PlaysStudentAllMark {

    private String studentId;
    private String subjectId;
    private String examId;
    private String mark;
}
