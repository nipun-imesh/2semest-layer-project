package com.assignment.finalproject.bo.custom;

import com.assignment.finalproject.dto.main.StudentManageDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StudendManageBO {
      boolean save(StudentManageDTO studto);
     ArrayList<StudentManageDTO> getAll() throws SQLException;
     ArrayList<StudentManageDTO> search();
     String getID() throws SQLException;
     boolean delete(String id) throws SQLException;
     boolean upDate(StudentManageDTO studentManageDTO);
}
