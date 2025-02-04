package com.assignment.finalproject.bo.custom.impl.MainBOImpl;

import com.assignment.finalproject.bo.custom.SendMailBO;
import com.assignment.finalproject.dao.CrudUtil;
import com.assignment.finalproject.dao.DAOFactory;
import com.assignment.finalproject.dao.custom.Impl.mainMOdel.SendMailDAOImpl;
import com.assignment.finalproject.dto.sub.GetParentIdDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SendMailBOImpl implements SendMailBO {

    SendMailDAOImpl sendMailDAO = (SendMailDAOImpl) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.SENDMAIL);

    @Override
    public ObservableList<GetParentIdDTO> getAllParentID() throws SQLException {
       return sendMailDAO.getAllParentID();
    }

    @Override
    public String getParentName(String parentId) throws SQLException {
        return sendMailDAO.getParentName(parentId);
    }

    @Override
    public String getParentEmail(String parentId) throws SQLException {
        return sendMailDAO.getParentEmail(parentId);
    }

    @Override
    public boolean save(String dto) throws SQLException, ClassNotFoundException {
        return sendMailDAO.save(dto);
    }

    @Override
    public ArrayList<String> getAll() throws SQLException, ClassNotFoundException {
        return sendMailDAO.getAll();
    }

    @Override
    public ArrayList<String> search() throws SQLException, ClassNotFoundException {
        return sendMailDAO.search();
    }

    @Override
    public String getID() throws SQLException, ClassNotFoundException {
        return sendMailDAO.getID();
    }

    @Override
    public boolean upDate(String dto) throws SQLException, ClassNotFoundException {
        return sendMailDAO.upDate(dto);
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return sendMailDAO.delete(id);
    }
}
