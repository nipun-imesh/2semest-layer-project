package com.assignment.finalproject.bo.custom;

import com.assignment.finalproject.bo.SuperBO;
import com.assignment.finalproject.dto.main.AddExamListDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ManageExamBO extends SuperBO {

     boolean upDateExam(AddExamListDTO addExamListDTO) throws SQLException;
     boolean deleteExam(AddExamListDTO addExamListDTO)  throws SQLException;
     boolean saveExam(AddExamListDTO dto) throws SQLException;
     ArrayList<AddExamListDTO> getAllExam() throws SQLException ;
     ArrayList<AddExamListDTO> searchExam();
     String getExamID() throws SQLException;
}
