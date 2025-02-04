package com.assignment.finalproject.bo.custom.impl.MainBOImpl;

import com.assignment.finalproject.bo.custom.LoginBO;
import com.assignment.finalproject.dao.DAOFactory;
import com.assignment.finalproject.dao.custom.Impl.mainMOdel.LoginDAOImpl;
import com.assignment.finalproject.dto.main.LoginDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class LoginBOImpl implements LoginBO {

    LoginDAOImpl loginDAO = (LoginDAOImpl) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.LOGIN);

    public int chekid(LoginDTO loginDto) throws SQLException, ClassNotFoundException {
       loginDto.setUsername("admin");
       loginDto.setPassword("admin");
        return loginDAO.chekid(loginDto);
    }

    @Override
    public boolean save(LoginDTO dto) throws SQLException {
        return loginDAO.save(dto);
    }

    @Override
    public ArrayList<LoginDTO> getAll() throws SQLException {
        return loginDAO.getAll();
    }

    @Override
    public ArrayList<LoginDTO> search() {
        return loginDAO.search();
    }

    @Override
    public String getID() throws SQLException {
        return loginDAO.getID();
    }

    @Override
    public boolean upDate(LoginDTO dto) throws SQLException {
        return loginDAO.upDate(dto);
    }
}
