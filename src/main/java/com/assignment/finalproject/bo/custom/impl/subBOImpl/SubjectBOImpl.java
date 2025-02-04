package com.assignment.finalproject.bo.custom.impl.subBOImpl;

import com.assignment.finalproject.bo.custom.SubjectBO;
import com.assignment.finalproject.dao.DAOFactory;
import com.assignment.finalproject.dao.custom.Impl.subModel.SubjectDAOImpl;
import com.assignment.finalproject.dto.sub.SabjectDTO;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.ArrayList;

public class SubjectBOImpl implements SubjectBO {

    SubjectDAOImpl subjectDAO = (SubjectDAOImpl) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.SUBJECT);

    @Override
    public ObservableList<SabjectDTO> get6TO9Subject() throws SQLException {
        return subjectDAO.get6TO9Subject();
    }

    @Override
    public ObservableList<SabjectDTO> get10TO11Subject() throws SQLException {
        return subjectDAO.get10TO11Subject();
    }

    @Override
    public String getSubjectName(String subjectID) throws SQLException {
        return subjectDAO.getSubjectName(subjectID);
    }

    @Override
    public boolean save(Object dto) throws SQLException, ClassNotFoundException {
        return subjectDAO.save(dto);
    }

    @Override
    public ArrayList getAll() throws SQLException, ClassNotFoundException {
        return subjectDAO.getAll();
    }

    @Override
    public ArrayList search() throws SQLException, ClassNotFoundException {
        return subjectDAO.search();
    }

    @Override
    public String getID() throws SQLException, ClassNotFoundException {
        return subjectDAO.getID();
    }

    @Override
    public boolean upDate(Object dto) throws SQLException, ClassNotFoundException {
        return subjectDAO.upDate(dto);
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return subjectDAO.delete(id);
    }
}
