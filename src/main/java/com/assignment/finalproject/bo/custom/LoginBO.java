package com.assignment.finalproject.bo.custom;

import com.assignment.finalproject.bo.SuperBO;
import com.assignment.finalproject.dto.main.LoginDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface LoginBO extends SuperBO {

     int chekid(LoginDTO loginDto) throws SQLException, ClassNotFoundException;
     boolean save(LoginDTO dto) throws SQLException, ClassNotFoundException;
     ArrayList<LoginDTO> getAll() throws SQLException, ClassNotFoundException;
     ArrayList<LoginDTO> search() throws SQLException, ClassNotFoundException;
     String getID() throws SQLException, ClassNotFoundException;
     boolean upDate(LoginDTO dto) throws SQLException, ClassNotFoundException;
}
