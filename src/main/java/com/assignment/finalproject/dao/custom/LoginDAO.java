package com.assignment.finalproject.dao.custom;

import com.assignment.finalproject.dao.CrudDAO;
import com.assignment.finalproject.dto.main.LoginDTO;

import java.sql.SQLException;

public interface LoginDAO extends CrudDAO<LoginDTO> {

    int chekid(LoginDTO loginDto) throws SQLException, ClassNotFoundException;
}
