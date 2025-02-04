package com.assignment.finalproject.bo.custom;

import com.assignment.finalproject.dto.main.LoginDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface LoginBO {

     int chekid(LoginDTO loginDto) throws SQLException, ClassNotFoundException;
     boolean save(LoginDTO dto) throws SQLException;
     ArrayList<LoginDTO> getAll() throws SQLException ;
     ArrayList<LoginDTO> search();
     String getID() throws SQLException;
     boolean upDate(LoginDTO dto) throws SQLException;
}
