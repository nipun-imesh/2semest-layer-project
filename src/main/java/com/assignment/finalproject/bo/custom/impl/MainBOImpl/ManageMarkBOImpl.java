package com.assignment.finalproject.bo.custom.impl.MainBOImpl;

import com.assignment.finalproject.bo.custom.ManageMarkBO;
import com.assignment.finalproject.dao.CrudUtil;
import com.assignment.finalproject.dao.DAOFactory;
import com.assignment.finalproject.dao.custom.Impl.mainMOdel.ManageMarkDAOImpl;
import com.assignment.finalproject.dto.sub.ClassDTO;
import com.assignment.finalproject.dto.sub.ExamSubjectIdDTO;
import com.assignment.finalproject.dto.tm.GetStudentNameIdTM;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManageMarkBOImpl implements ManageMarkBO {

    ManageMarkDAOImpl manageMarkDAO = (ManageMarkDAOImpl) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.MANAGEMARK);

    @Override
    public ArrayList<GetStudentNameIdTM> getStudentDetail(ClassDTO classDTO) throws SQLException {
       return manageMarkDAO.getStudentDetail(classDTO);
    }

    @Override
    public boolean upDateMark(ExamSubjectIdDTO examSubjectIdDTO) throws SQLException {
       return manageMarkDAO.upDate(examSubjectIdDTO);
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return manageMarkDAO.delete(id);
    }

    public boolean deleteMark(ExamSubjectIdDTO examSubjectIdDTO) throws SQLException {

        return manageMarkDAO.delete(examSubjectIdDTO);
    }

    @Override
    public boolean saveMark(ExamSubjectIdDTO dto) throws SQLException {
        return manageMarkDAO.save(dto);
    }

    @Override
    public ArrayList<ExamSubjectIdDTO> getAllSubject() throws SQLException {
        return manageMarkDAO.getAll();
    }

    @Override
    public ArrayList<ExamSubjectIdDTO> search() {
        return manageMarkDAO.search();
    }

    @Override
    public String getSubjectD() throws SQLException {
        return manageMarkDAO.getID();
    }
}
