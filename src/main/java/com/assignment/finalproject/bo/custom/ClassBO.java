package com.assignment.finalproject.bo.custom;

import com.assignment.finalproject.bo.SuperBO;
import com.assignment.finalproject.dto.sub.ClassDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ClassBO extends SuperBO {
     boolean save(ClassDTO dto) throws SQLException;
     ArrayList<ClassDTO> getAll() throws SQLException, ClassNotFoundException;
     ArrayList<ClassDTO> search();
     String getID() throws SQLException, ClassNotFoundException;
     boolean upDate(ClassDTO dto) throws SQLException, ClassNotFoundException;
     boolean delete(String id) throws SQLException, ClassNotFoundException;
     ClassDTO findByclass(String selectedClassId);
}
