package com.assignment.finalproject.dao.custom;

import com.assignment.finalproject.dao.SuperDAO;
import com.assignment.finalproject.dto.main.StudentSubjectDetaliDTO;
import com.assignment.finalproject.dto.tm.GetResaltTM;
import com.assignment.finalproject.dto.tm.ManageExamMarkTM;
import com.assignment.finalproject.dto.tm.ManageExamTM;

import java.sql.SQLException;
import java.util.ArrayList;

public interface QueryDAO extends SuperDAO {

     ArrayList<ManageExamMarkTM> getStudentMarkDetail(String studentId) throws SQLException;
     public ArrayList<ManageExamTM> getSelectExam(String grade) throws SQLException;
     public ArrayList<GetResaltTM> search(StudentSubjectDetaliDTO studentSubjectDetaliDTO) throws SQLException;
}
