package com.assignment.finalproject.bo.custom;

import com.assignment.finalproject.bo.SuperBO;
import com.assignment.finalproject.dto.main.AddExamListDTO;
import com.assignment.finalproject.dto.sub.ExamScheduleDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ExamShedulBO extends SuperBO {

     String getShedulID() throws SQLException, ClassNotFoundException;
     boolean upDateShedul(AddExamListDTO addExamListDTO) throws SQLException, ClassNotFoundException;
     boolean saveShedul(ExamScheduleDTO examSchedule) throws SQLException, ClassNotFoundException;
     ArrayList<ExamScheduleDTO> getAllShedul() throws SQLException;
     ArrayList<ExamScheduleDTO> search() ;
     boolean deleteShedul(String examShedulID) throws SQLException, ClassNotFoundException;
}
