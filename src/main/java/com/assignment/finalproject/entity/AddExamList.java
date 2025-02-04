package com.assignment.finalproject.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class AddExamList {
    private String examShedulID;
    private String examID;
    private String examName;
    private String grade;
    private String examDate;
    private String examTime;
    private String hallName;
    private String subjectID;
    private String classID;

}
