package com.assignment.finalproject.bo.custom;

import com.assignment.finalproject.bo.SuperBO;
import com.assignment.finalproject.dto.main.SigninDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SignInBO extends SuperBO {
     String getID() throws SQLException;
     boolean upDate(SigninDTO dto) throws SQLException, ClassNotFoundException;
     boolean delete(String id) throws SQLException, ClassNotFoundException;
     boolean save(SigninDTO signinDto) throws SQLException;
     ArrayList<SigninDTO> getAll() throws SQLException, ClassNotFoundException;
     ArrayList<SigninDTO> search() throws SQLException, ClassNotFoundException;
}
