package com.assignment.finalproject.dao.custom;


import com.assignment.finalproject.dao.CrudDAO;
import com.assignment.finalproject.dto.main.AddMarkDTO;
import com.assignment.finalproject.dto.sub.ExamNameDTO;
import com.assignment.finalproject.dto.sub.ExamSubjectIdDTO;
import com.assignment.finalproject.dto.sub.PlaysStudentAllMarkDTO;
import com.assignment.finalproject.dto.tm.GetStudentNameIdTM;
import com.assignment.finalproject.entity.main.AddMark;
import com.assignment.finalproject.entity.main.StudentManage;


import java.sql.SQLException;
import java.util.ArrayList;

public interface AddMarkDAO extends CrudDAO<AddMark> {

    String fineExamId(String examName) throws SQLException;
    boolean palesAllMark(ArrayList<PlaysStudentAllMarkDTO> playsStudentAllMarkDTOS) throws SQLException;
    boolean checkStudentExamSubject(ExamSubjectIdDTO examSubjectIdDTO) throws SQLException;
    ArrayList<StudentManage> getStudentNameId(AddMark mark) throws SQLException;
    ArrayList<ExamNameDTO> getExamList(String grade) throws SQLException;

}