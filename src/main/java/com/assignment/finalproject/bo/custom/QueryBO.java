package com.assignment.finalproject.bo.custom;

import com.assignment.finalproject.bo.SuperBO;
import com.assignment.finalproject.dto.main.StudentSubjectDetaliDTO;
import com.assignment.finalproject.dto.tm.GetResaltTM;
import com.assignment.finalproject.dto.tm.ManageExamMarkTM;
import com.assignment.finalproject.dto.tm.ManageExamTM;

import java.sql.SQLException;
import java.util.ArrayList;

public interface QueryBO extends SuperBO {
     ArrayList<ManageExamTM> getSelectExam(String grade) throws SQLException;
     ArrayList<ManageExamMarkTM> getStudentMarkDetail(String studentId) throws SQLException;
     ArrayList<GetResaltTM> search(StudentSubjectDetaliDTO studentSubjectDetaliDTO) throws SQLException;
}
