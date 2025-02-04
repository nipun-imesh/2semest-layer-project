package com.assignment.finalproject.bo.custom;

import com.assignment.finalproject.bo.SuperBO;
import com.assignment.finalproject.dto.sub.ExamScheduleDTO;
import com.assignment.finalproject.dto.sub.ExamSubjectIdDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ExamSubjectBO extends SuperBO {

    boolean saveExamSubject(ExamSubjectIdDTO subjectIdDTO) throws SQLException;
    boolean upDateExamSubject(ExamScheduleDTO examScheduleDTO) throws SQLException;
    boolean deleteExamSubect(String examID) throws SQLException;
    ArrayList<ExamSubjectIdDTO> getAllExamSubject() throws SQLException;
    ArrayList<ExamSubjectIdDTO> searchExamSubject();
    String getExamSublectID() throws SQLException;

}