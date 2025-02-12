package com.assignment.finalproject.dao.custom;

import com.assignment.finalproject.dao.CrudDAO;
import com.assignment.finalproject.dto.main.StudentManageDTO;
import com.assignment.finalproject.entity.main.StudentManage;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StudentManageDAO extends CrudDAO<StudentManage> {
      boolean save(StudentManage studto);
     ArrayList<StudentManage> getAll() throws SQLException;
     ArrayList<StudentManage> search();
     String getID() throws SQLException ;
     boolean delete(String id) throws SQLException ;
     boolean upDate(StudentManage studentManage);
}
