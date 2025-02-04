package com.assignment.finalproject.bo.custom.impl.MainBOImpl;

import com.assignment.finalproject.bo.custom.StudendManageBO;
import com.assignment.finalproject.dao.CrudUtil;
import com.assignment.finalproject.dao.DAOFactory;
import com.assignment.finalproject.dao.custom.Impl.mainMOdel.SendMailDAOImpl;
import com.assignment.finalproject.dao.custom.Impl.mainMOdel.StudentManageDAOImpl;
import com.assignment.finalproject.dto.main.StudentManageDTO;
import javafx.scene.control.Alert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

public class StudentMnagrBOImpl implements StudendManageBO {

    StudentManageDAOImpl studentManageDAO = (StudentManageDAOImpl) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.STUDENTMANAGE);

    public  boolean save(StudentManageDTO studto) {
        return studentManageDAO.save(studto);
    }

    @Override
    public ArrayList<StudentManageDTO> getAll() throws SQLException {
        return studentManageDAO.getAll();
    }

    @Override
    public ArrayList<StudentManageDTO> search() {
        return studentManageDAO.search();
    }

    @Override
    public String getID() throws SQLException {
        return studentManageDAO.getID();
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return studentManageDAO.delete(id);
    }

    @Override
    public boolean upDate(StudentManageDTO studentManageDTO) {
        return studentManageDAO.upDate(studentManageDTO);
    }
}
