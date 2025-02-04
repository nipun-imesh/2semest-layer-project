package com.assignment.finalproject.bo.custom;

import com.assignment.finalproject.bo.SuperBO;
import com.assignment.finalproject.dto.sub.ClassDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ClassBO extends SuperBO {
     boolean save(ClassDTO dto) throws SQLException;
     ArrayList<ClassDTO> getAll() throws SQLException;
     ArrayList<ClassDTO> search();
     String getID() throws SQLException;
     boolean upDate(ClassDTO dto) throws SQLException;
     boolean delete(String id) throws SQLException;
     ClassDTO findByclass(String selectedClassId);
}
