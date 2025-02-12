package com.assignment.finalproject.bo.custom.impl.MainBOImpl;

import com.assignment.finalproject.bo.custom.AddParentBO;
import com.assignment.finalproject.dao.DAOFactory;
import com.assignment.finalproject.dao.custom.AddParentDAO;
import com.assignment.finalproject.dao.custom.Impl.mainMOdel.AddParentDAOImpl;
import com.assignment.finalproject.dto.main.AddParentDTO;
import com.assignment.finalproject.entity.main.AddParent;

import java.sql.SQLException;
import java.util.ArrayList;

public class AddPararentBOImpl implements AddParentBO {

    AddParentDAO addParentDAO = (AddParentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ADDPARENT);

    @Override
    public boolean saveParent(AddParentDTO addParentDTO) throws SQLException, ClassNotFoundException {
        return addParentDAO.save(new AddParent(addParentDTO.getParentId(),addParentDTO.getParentName(),addParentDTO.getParentEmail()));
    }

    @Override
    public ArrayList<AddParent> getAllParent() throws SQLException, ClassNotFoundException {
        return addParentDAO.getAll();
    }

    @Override
    public ArrayList<AddParentDTO> searchPerent()  {

        return null;
    }

    @Override
    public String getPerentID() throws SQLException, ClassNotFoundException {
        return addParentDAO.getID();
    }

    @Override
    public boolean upDatePerent(AddParentDTO addParentDTO) throws SQLException, ClassNotFoundException {
        return addParentDAO.upDate(new AddParent(addParentDTO.getParentName(),addParentDTO.getParentEmail(),addParentDTO.getStatus(),addParentDTO.getParentId()));
    }

    @Override
    public boolean deletePerent(String parentId) throws SQLException, ClassNotFoundException {
        return addParentDAO.delete(parentId);
    }
}
