package com.assignment.finalproject.bo.custom;

import com.assignment.finalproject.bo.SuperBO;
import com.assignment.finalproject.dto.sub.ExamDTO;
import com.assignment.finalproject.dto.sub.ExamScheduleDTO;
import com.assignment.finalproject.dto.sub.ExamSubjectIdDTO;
import com.assignment.finalproject.entity.sub.Exam;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AddExamListBO extends SuperBO {

      String getExamShedulID( ) throws SQLException, ClassNotFoundException;
      boolean saveExamList(ArrayList<ExamDTO> examDTOList, ArrayList<ExamScheduleDTO> examScheduleDTOList, ArrayList<ExamSubjectIdDTO> examSubjectIdDTOList) throws SQLException, ClassNotFoundException;
      ArrayList<Exam> getAllExamList() throws SQLException, ClassNotFoundException;
      ArrayList<ExamDTO> searcheExamLis() throws SQLException, ClassNotFoundException ;
      String getExamID() throws SQLException, ClassNotFoundException;
      boolean upDate(ExamDTO dto) throws SQLException, ClassNotFoundException;
      boolean delete(String id) throws SQLException, ClassNotFoundException ;

}
