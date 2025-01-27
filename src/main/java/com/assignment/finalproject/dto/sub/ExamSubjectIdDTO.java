package com.assignment.finalproject.dto.sub;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class ExamSubjectIdDTO {
    private String examId;
    private String subjectId;
    private String studentId;
    private double mark;


    public ExamSubjectIdDTO(double mark, String studentId, String subjectId, String examId) {
        this.mark = mark;
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.examId = examId;
    }

    public ExamSubjectIdDTO(String studentID, String examID, String subjectID) {
        this.studentId = studentID;
        this.examId = examID;
        this.subjectId = subjectID;
    }

    public ExamSubjectIdDTO(String examID, String subjectID) {
        this.examId = examID;
        this.subjectId = subjectID;
    }
}
