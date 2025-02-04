package com.assignment.finalproject.bo.custom.impl.MainBOImpl;

import com.assignment.finalproject.bo.custom.SignInBO;
import com.assignment.finalproject.dao.CrudUtil;
import com.assignment.finalproject.dao.DAOFactory;
import com.assignment.finalproject.dao.custom.Impl.mainMOdel.SigninDAOImpl;
import com.assignment.finalproject.dto.main.SigninDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SigninBOImpl implements SignInBO {

    SigninDAOImpl signinDAO = (SigninDAOImpl) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.SIGNIN);

    public String getID() throws SQLException {
        return signinDAO.getID();
    }

    @Override
    public boolean upDate(SigninDTO dto) throws SQLException, ClassNotFoundException {
        return signinDAO.upDate(dto);
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return signinDAO.delete(id);
    }

    @Override
    public boolean save(SigninDTO signinDto) throws SQLException {
        return signinDAO.save(signinDto);
    }

    @Override
    public ArrayList<SigninDTO> getAll() throws SQLException, ClassNotFoundException {
        return signinDAO.getAll();
    }

    @Override
    public ArrayList<SigninDTO> search() throws SQLException, ClassNotFoundException {
        return signinDAO.search();
    }
}
