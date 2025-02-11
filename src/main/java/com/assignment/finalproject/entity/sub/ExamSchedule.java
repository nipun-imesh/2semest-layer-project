package com.assignment.finalproject.entity.sub;


import com.assignment.finalproject.dto.sub.ExamScheduleDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString

public class ExamSchedule {
    private String examScheduleId;
    private String examId;
    private String hallId;
    private String examTime;
    private String examDate;
    private String subjectID;
    private String hallName;


    public ExamSchedule(String subjectID, String examID) {
        this.examId = examID;
        this.subjectID = subjectID;
    }

    public ExamSchedule(String examShedulID, String examID, String hallName, String examTime, String examDate) {
        this.examScheduleId = examShedulID;
        this.examId = examID;
        this.hallId = hallName;
        this.examTime = examTime;
        this.examDate = examDate;
    }

    public ExamSchedule(String examId, String hallId, String examTime, String examDate) {
        this.examId = examId;
        this.hallId = hallId;
        this.examTime = examTime;
        this.examDate = examDate;
    }

    public ExamSchedule(ExamScheduleDTO scheduleDTO) {
        this.examScheduleId = scheduleDTO.getExamScheduleId();
        this.examId = scheduleDTO.getExamId();
        this.hallId = scheduleDTO.getHallId();
        this.examTime = scheduleDTO.getExamTime();
        this.examDate = scheduleDTO.getExamDate();
    }
}
