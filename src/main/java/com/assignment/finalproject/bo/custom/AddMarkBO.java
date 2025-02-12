package com.assignment.finalproject.bo.custom;

import com.assignment.finalproject.bo.SuperBO;
import com.assignment.finalproject.dto.main.AddMarkDTO;
import com.assignment.finalproject.dto.sub.ExamNameDTO;
import com.assignment.finalproject.dto.sub.ExamSubjectIdDTO;
import com.assignment.finalproject.dto.sub.PlaysStudentAllMarkDTO;
import com.assignment.finalproject.dto.tm.GetStudentNameIdTM;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AddMarkBO extends SuperBO {

     ArrayList<GetStudentNameIdTM> getStudentNameId(AddMarkDTO markDTO) throws SQLException;
     ArrayList<ExamNameDTO> getExamList(String classNumber) throws SQLException;
     String fineExamId(String examName) throws SQLException;
     boolean palesAllMark(ArrayList<PlaysStudentAllMarkDTO> playsStudentAllMarkDTOS) throws SQLException;
     boolean checkStudentExamSubject(ExamSubjectIdDTO examSubjectIdDTO) throws SQLException;
     boolean save(AddMarkDTO dto) throws SQLException;
     ArrayList<AddMarkDTO> getAll() throws SQLException, ClassNotFoundException;
     ArrayList<AddMarkDTO> search();
     String getID() throws SQLException;
     boolean upDate(AddMarkDTO dto) throws SQLException;
     boolean delete(String parentId) throws SQLException;
}
