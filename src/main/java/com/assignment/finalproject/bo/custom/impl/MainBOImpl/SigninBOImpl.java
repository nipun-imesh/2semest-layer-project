package com.assignment.finalproject.bo.custom.impl.MainBOImpl;

import com.assignment.finalproject.bo.custom.SignInBO;
import com.assignment.finalproject.dao.DAOFactory;
import com.assignment.finalproject.dao.custom.Impl.mainMOdel.SigninDAOImpl;
import com.assignment.finalproject.dto.main.SigninDTO;
import com.assignment.finalproject.entity.main.Signin;

import java.sql.SQLException;
import java.util.ArrayList;

public class SigninBOImpl implements SignInBO {

    SigninDAOImpl signinDAO = (SigninDAOImpl) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.SIGNIN);

    public String getID() throws SQLException {
        return signinDAO.getID();
    }

    @Override
    public boolean upDate(SigninDTO dto) throws SQLException, ClassNotFoundException {

        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return signinDAO.delete(id);
    }

    @Override
    public boolean save(SigninDTO signinDto) throws SQLException {

        return signinDAO.save(new Signin(signinDto.getUserid(),signinDto.getUsername(),signinDto.getPassword()));
    }

    @Override
    public ArrayList<Signin> getAll() throws SQLException, ClassNotFoundException {
        return signinDAO.getAll();
    }

    @Override
    public ArrayList<Signin> search() throws SQLException, ClassNotFoundException {
        return signinDAO.search();
    }
}
