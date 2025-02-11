package com.assignment.finalproject.bo.custom;

import com.assignment.finalproject.bo.SuperBO;
import com.assignment.finalproject.dto.main.AddExamListDTO;
import com.assignment.finalproject.dto.sub.ExamScheduleDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ExamShedulBO extends SuperBO {

     String getShedulID() throws SQLException;
     boolean upDateShedul(AddExamListDTO addExamListDTO) throws SQLException;
     boolean saveShedul(ExamScheduleDTO examSchedule) throws SQLException;
     ArrayList<ExamScheduleDTO> getAllShedul() throws SQLException;
     ArrayList<ExamScheduleDTO> search() ;
     boolean deleteShedul(String examShedulID) throws SQLException ;
}
