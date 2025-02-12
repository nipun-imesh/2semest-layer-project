package com.assignment.finalproject.bo.custom;

import com.assignment.finalproject.bo.SuperBO;
import com.assignment.finalproject.dto.sub.ClassDTO;
import com.assignment.finalproject.dto.sub.ExamSubjectIdDTO;
import com.assignment.finalproject.dto.tm.GetStudentNameIdTM;
import com.assignment.finalproject.entity.sub.ExamSubject;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ManageMarkBO extends SuperBO {

    public ArrayList<GetStudentNameIdTM> getStudentDetail(ClassDTO classDTO) throws SQLException ;
    public boolean upDateMark(ExamSubjectIdDTO examSubjectIdDTO) throws SQLException, ClassNotFoundException;
    public boolean deleteMark(ExamSubjectIdDTO examSubjectIdDTO) throws SQLException, ClassNotFoundException;
    public boolean saveMark(ExamSubjectIdDTO dto) throws SQLException, ClassNotFoundException;
    public ArrayList<ExamSubject> getAllSubject() throws SQLException, ClassNotFoundException;
    public ArrayList<ExamSubject> search() throws SQLException, ClassNotFoundException;
    public String getSubjectD() throws SQLException, ClassNotFoundException;
}
