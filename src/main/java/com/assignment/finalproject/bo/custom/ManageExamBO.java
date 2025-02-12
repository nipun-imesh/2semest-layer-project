package com.assignment.finalproject.bo.custom;

import com.assignment.finalproject.bo.SuperBO;
import com.assignment.finalproject.dao.CrudUtil;
import com.assignment.finalproject.db.DBConnection;
import com.assignment.finalproject.dto.main.AddExamListDTO;
import com.assignment.finalproject.dto.sub.ExamScheduleDTO;
import com.assignment.finalproject.entity.main.AddExamList;
import com.assignment.finalproject.entity.sub.ExamSchedule;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ManageExamBO extends SuperBO {

     boolean upDateExam(AddExamListDTO addExamListDTO) throws SQLException;
     boolean deleteExam(AddExamListDTO addExamListDTO)  throws SQLException;
     boolean saveExam(AddExamListDTO dto) throws SQLException;
     ArrayList<AddExamListDTO> getAllExam() throws SQLException;
     ArrayList<AddExamList> searchExam();
     String getExamID() throws SQLException, ClassNotFoundException;
}
