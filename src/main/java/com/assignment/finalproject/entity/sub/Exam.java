package com.assignment.finalproject.entity.sub;

import com.assignment.finalproject.dto.sub.ExamDTO;
import com.assignment.finalproject.dto.sub.ExamScheduleDTO;
import com.assignment.finalproject.dto.sub.ExamSubjectIdDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Exam {
    private String examId;
    private String examName;
    private String grade;

    public Exam(ArrayList<ExamDTO> examDTOList, ArrayList<ExamScheduleDTO> examScheduleDTOList, ArrayList<ExamSubjectIdDTO> examSubjectIdDTOList) {
        this.examId = examDTOList.get(0).getExamId();
        this.examName = examDTOList.get(0).getExamName();
        this.grade = examDTOList.get(0).getGrade();
    }
}
