package com.assignment.finalproject.dao.custom;


import com.assignment.finalproject.dao.CrudDAO;
import com.assignment.finalproject.dto.main.AddMarkDTO;
import com.assignment.finalproject.dto.sub.ExamNameDTO;
import com.assignment.finalproject.dto.sub.ExamSubjectIdDTO;
import com.assignment.finalproject.dto.sub.PlaysStudentAllMarkDTO;
import com.assignment.finalproject.dto.tm.GetStudentNameIdTM;


import java.sql.SQLException;
import java.util.ArrayList;

public interface AddMarkDAO extends CrudDAO<AddMarkDTO> {

    ArrayList<GetStudentNameIdTM> getStudentNameId(AddMarkDTO markDTO) throws SQLException;
    String fineExamId(String examName) throws SQLException;
    boolean palesAllMark(ArrayList<PlaysStudentAllMarkDTO> playsStudentAllMarkDTOS) throws SQLException;
    boolean checkStudentExamSubject(ExamSubjectIdDTO examSubjectIdDTO) throws SQLException;

}