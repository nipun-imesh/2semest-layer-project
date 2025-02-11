package com.assignment.finalproject.bo.custom;

import com.assignment.finalproject.bo.SuperBO;
import com.assignment.finalproject.dto.sub.ExamScheduleDTO;
import com.assignment.finalproject.dto.sub.ExamSubjectIdDTO;
import com.assignment.finalproject.entity.sub.ExamSubject;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ExamSubjectBO extends SuperBO {

    boolean saveExamSubject(ExamSubjectIdDTO subjectIdDTO) throws SQLException;
    boolean upDateExamSubject(ExamScheduleDTO examScheduleDTO) throws SQLException, ClassNotFoundException;
    boolean deleteExamSubect(String examID) throws SQLException;
    ArrayList<ExamSubject> getAllExamSubject() throws SQLException, ClassNotFoundException;
    ArrayList<ExamSubject> searchExamSubject() throws SQLException, ClassNotFoundException;
    String getExamSublectID() throws SQLException;

}