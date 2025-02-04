package com.assignment.finalproject.bo.custom.impl.MainBOImpl;

import com.assignment.finalproject.bo.custom.AddParentBO;
import com.assignment.finalproject.dao.CrudUtil;
import com.assignment.finalproject.dao.DAOFactory;
import com.assignment.finalproject.dao.custom.Impl.mainMOdel.AddMarkDAOImpl;
import com.assignment.finalproject.dao.custom.Impl.mainMOdel.AddParentDAOImpl;
import com.assignment.finalproject.dto.main.AddParentDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

public class AddPararentBOImpl implements AddParentBO {

    AddParentDAOImpl addParentDAO = (AddParentDAOImpl) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ADDPARENT);

    @Override
    public boolean saveParent(AddParentDTO addParentDTO) throws SQLException {
        return addParentDAO.save(addParentDTO);
    }

    @Override
    public ArrayList<AddParentDTO> getAllParent() throws SQLException {
        return addParentDAO.getAll();
    }

    @Override
    public ArrayList<AddParentDTO> searchPerent()  {

        return null;
    }

    @Override
    public String getPerentID() throws SQLException {
        return addParentDAO.getID();
    }

    @Override
    public boolean upDatePerent(AddParentDTO addParentDTO) throws SQLException {
        return addParentDAO.upDate(addParentDTO);
    }

    @Override
    public boolean deletePerent(String parentId) throws SQLException {
        return addParentDAO.delete(parentId);
    }
}
