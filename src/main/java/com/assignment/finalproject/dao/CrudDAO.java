package com.assignment.finalproject.dao;


import com.assignment.finalproject.dto.sub.ExamNameDTO;
import com.assignment.finalproject.dto.tm.GetStudentNameIdTM;
import com.assignment.finalproject.entity.main.AddExamList;
import com.assignment.finalproject.entity.main.AddMark;
import com.assignment.finalproject.entity.main.AddParent;
import com.assignment.finalproject.entity.main.StudentManage;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO<T> extends SuperDAO {
    boolean save(T dto) throws SQLException,ClassNotFoundException;
    ArrayList<T> getAll() throws SQLException,ClassNotFoundException;
    ArrayList<T> search()throws SQLException,ClassNotFoundException;
    String getID() throws SQLException,ClassNotFoundException;
    boolean upDate(T dto) throws SQLException,ClassNotFoundException;
    boolean delete(String id) throws SQLException,ClassNotFoundException;

}
