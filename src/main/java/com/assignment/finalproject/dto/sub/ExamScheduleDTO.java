package com.assignment.finalproject.dto.sub;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString

public class ExamScheduleDTO {
    private String examScheduleId;
    private String examId;
    private String hallId;
    private String examTime;
    private String examDate;
    private String subjectID;


    public ExamScheduleDTO(String subjectID, String examID) {
        this.examId = examID;
        this.subjectID = subjectID;
    }

    public ExamScheduleDTO(String examShedulID, String examID, String hallName, String examTime, String examDate) {
        this.examScheduleId = examShedulID;
        this.examId = examID;
        this.hallId = hallName;
        this.examTime = examTime;
        this.examDate = examDate;
    }
}
