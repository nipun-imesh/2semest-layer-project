package com.assignment.finalproject.dto.main;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class AddExamListDTO {
    private String examShedulID;
    private String examID;
    private String examName;
    private String grade;
    private String examDate;
    private String examTime;
    private String hallName;
    private String subjectID;
    private String classID;



    public AddExamListDTO(String examID, String examShedulID) {
      this.examID = examID;
      this.examShedulID = examShedulID;
    }


    public AddExamListDTO(String examID, String examName, String grade, String hallName, String examTime, String examDate, String examShedulID, String subjectID) {
        this.examID = examID;
        this.examName = examName;
        this.grade = grade;
        this.hallName = hallName;
        this.examTime = examTime;
        this.examDate = examDate;
        this.examShedulID = examShedulID;
        this.subjectID = subjectID;
    }

    public AddExamListDTO(String examID, String hallName, String examTime, String examDate, String examShedulID) {
        this.examID = examID;
        this.hallName = hallName;
        this.examTime = examTime;
        this.examDate = examDate;
        this.examShedulID = examShedulID;
    }
}
