package com.assignment.finalproject.bo.custom.impl.subBOImpl;

import com.assignment.finalproject.bo.custom.HallBO;
import com.assignment.finalproject.dao.CrudUtil;
import com.assignment.finalproject.dao.DAOFactory;
import com.assignment.finalproject.dao.custom.Impl.subModel.HallDAOImpl;
import com.assignment.finalproject.dto.sub.HallDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HAllBOImpl implements HallBO {

    HallDAOImpl hallDAO = (HallDAOImpl) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.HALL);

    @Override
    public ObservableList<HallDTO> getAllHall() throws SQLException {
        return hallDAO.getAllHall();
    }

    @Override
    public boolean save(HallDTO dto) throws SQLException {
        return hallDAO.save(dto);
    }

    @Override
    public ArrayList<HallDTO> getAll() throws SQLException {
        return hallDAO.getAll();
    }

    @Override
    public ArrayList<HallDTO> search() {
        return hallDAO.search();
    }

    @Override
    public String getID() throws SQLException {
        return hallDAO.getID();
    }

    @Override
    public boolean upDate(HallDTO dto) throws SQLException {
        return hallDAO.upDate(dto);
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return hallDAO.delete(id);
    }
}

