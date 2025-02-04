package com.assignment.finalproject.bo.custom;

import com.assignment.finalproject.bo.SuperBO;
import com.assignment.finalproject.dto.sub.ClassDTO;
import com.assignment.finalproject.dto.sub.ExamSubjectIdDTO;
import com.assignment.finalproject.dto.tm.GetStudentNameIdTM;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ManageMarkBO extends SuperBO {

    public ArrayList<GetStudentNameIdTM> getStudentDetail(ClassDTO classDTO) throws SQLException ;
    public boolean upDateMark(ExamSubjectIdDTO examSubjectIdDTO) throws SQLException;
    public boolean delete(String id) throws SQLException;
    public boolean deleteMark(ExamSubjectIdDTO examSubjectIdDTO) throws SQLException ;
    public boolean saveMark(ExamSubjectIdDTO dto) throws SQLException;
    public ArrayList<ExamSubjectIdDTO> getAllSubject() throws SQLException;
    public ArrayList<ExamSubjectIdDTO> search() ;
    public String getSubjectD() throws SQLException;
}
