package com.assignment.finalproject.bo.custom.impl.subBOImpl;

import com.assignment.finalproject.bo.custom.ClassBO;
import com.assignment.finalproject.dao.CrudUtil;
import com.assignment.finalproject.dao.DAOFactory;
import com.assignment.finalproject.dao.custom.Impl.subModel.ClassDAOImpl;
import com.assignment.finalproject.dto.sub.ClassDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClassBOImpl implements ClassBO {

    ClassDAOImpl classDAO = (ClassDAOImpl) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CLASS);

    @Override
    public boolean save(ClassDTO dto) throws SQLException {
        return classDAO.save(dto);
    }

    @Override
    public ArrayList<ClassDTO> getAll() throws SQLException {
        return classDAO.getAll();
    }

    @Override
    public ArrayList<ClassDTO> search() {
        return classDAO.search();
    }

    @Override
    public String getID() throws SQLException {
        return classDAO.getID();
    }

    @Override
    public boolean upDate(ClassDTO dto) throws SQLException {
        return classDAO.upDate(dto);
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return classDAO.delete(id);
    }

    @Override
    public ClassDTO findByclass(String selectedClassId) {
        return classDAO.findByclass(selectedClassId);
    }
}
