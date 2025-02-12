package com.assignment.finalproject.bo.custom.impl.subBOImpl;

import com.assignment.finalproject.bo.custom.ClassBO;
import com.assignment.finalproject.dao.DAOFactory;
import com.assignment.finalproject.dao.custom.ClassDAO;
import com.assignment.finalproject.dao.custom.Impl.subModel.ClassDAOImpl;
import com.assignment.finalproject.dto.sub.ClassDTO;
import com.assignment.finalproject.entity.sub.Classes;


import java.sql.SQLException;
import java.util.ArrayList;

public class ClassBOImpl implements ClassBO {

    ClassDAO classDAO = (ClassDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CLASS);

    @Override
    public boolean save(ClassDTO dto) throws SQLException {
        return false;
    }

    @Override
    public ArrayList<ClassDTO> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<ClassDTO> classDTOS = new ArrayList<>();

        for (Classes cls : classDAO.getAll()) {
            classDTOS.add(new ClassDTO(cls.getClassId(), cls.getGrade()));
        }
        return classDTOS;

    }

    @Override
    public ArrayList<ClassDTO> search() {
        return null;
    }

    @Override
    public String getID() throws SQLException, ClassNotFoundException {
        return classDAO.getID();
    }

    @Override
    public boolean upDate(ClassDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return classDAO.delete(id);
    }

    @Override
    public ClassDTO findByclass(String selectedClassId) {
        return classDAO.findByclass(selectedClassId);
    }
}
