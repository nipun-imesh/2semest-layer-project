package com.assignment.finalproject.bo.custom.impl.MainBOImpl;

import com.assignment.finalproject.bo.custom.LoginBO;
import com.assignment.finalproject.dao.DAOFactory;
import com.assignment.finalproject.dao.custom.Impl.mainMOdel.LoginDAOImpl;
import com.assignment.finalproject.dao.custom.LoginDAO;
import com.assignment.finalproject.dto.main.LoginDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class LoginBOImpl implements LoginBO {

    LoginDAO loginDAO = (LoginDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.LOGIN);

    public int chekid(LoginDTO loginDto) throws SQLException, ClassNotFoundException {
       loginDto.setUsername("admin");
       loginDto.setPassword("admin");
        return loginDAO.chekid(loginDto);
    }

    @Override
    public boolean save(LoginDTO dto) throws SQLException, ClassNotFoundException {
        return loginDAO.save(dto);
    }

    @Override
    public ArrayList<LoginDTO> getAll() throws SQLException, ClassNotFoundException {
        return loginDAO.getAll();
    }

    @Override
    public ArrayList<LoginDTO> search() throws SQLException, ClassNotFoundException {
        return loginDAO.search();
    }

    @Override
    public String getID() throws SQLException, ClassNotFoundException {
        return loginDAO.getID();
    }

    @Override
    public boolean upDate(LoginDTO dto) throws SQLException, ClassNotFoundException {
        return loginDAO.upDate(dto);
    }
}
