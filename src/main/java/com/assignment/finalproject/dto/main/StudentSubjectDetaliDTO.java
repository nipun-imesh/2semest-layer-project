package com.assignment.finalproject.dto.main;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString

public class StudentSubjectDetaliDTO {
    private String studentId;
    private String examname;
    private String classId;
    private String grade;


}
