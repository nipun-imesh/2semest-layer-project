package com.assignment.finalproject.bo.custom;

import com.assignment.finalproject.bo.SuperBO;
import com.assignment.finalproject.dto.main.StudentManageDTO;
import com.assignment.finalproject.entity.main.StudentManage;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StudendManageBO extends SuperBO {
      boolean save(StudentManageDTO studto);
     ArrayList<StudentManage> geStudentAll() throws SQLException;
     ArrayList<StudentManageDTO> search();
     String getID() throws SQLException;
     boolean delete(String id) throws SQLException;
     boolean upDate(StudentManageDTO studentManageDTO);
}
