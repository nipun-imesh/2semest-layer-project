package com.assignment.finalproject.dao.custom;

import com.assignment.finalproject.dao.CrudDAO;
import com.assignment.finalproject.dto.sub.ClassDTO;
import com.assignment.finalproject.dto.sub.ExamSubjectIdDTO;
import com.assignment.finalproject.dto.tm.GetStudentNameIdTM;
import com.assignment.finalproject.entity.sub.ExamSubject;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ManageMarkDAO extends CrudDAO<ExamSubject> {
    public ArrayList<GetStudentNameIdTM> getStudentDetail(ClassDTO classDTO) throws SQLException;

}
