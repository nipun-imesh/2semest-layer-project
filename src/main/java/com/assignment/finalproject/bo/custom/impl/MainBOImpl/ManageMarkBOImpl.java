package com.assignment.finalproject.bo.custom.impl.MainBOImpl;

import com.assignment.finalproject.bo.custom.ManageMarkBO;
import com.assignment.finalproject.dao.DAOFactory;
import com.assignment.finalproject.dao.custom.Impl.mainMOdel.ManageMarkDAOImpl;
import com.assignment.finalproject.dao.custom.ManageMarkDAO;
import com.assignment.finalproject.dto.sub.ClassDTO;
import com.assignment.finalproject.dto.sub.ExamSubjectIdDTO;
import com.assignment.finalproject.dto.tm.GetStudentNameIdTM;
import com.assignment.finalproject.entity.sub.ExamSubject;

import java.sql.SQLException;
import java.util.ArrayList;

public class ManageMarkBOImpl implements ManageMarkBO {

    ManageMarkDAO manageMarkDAO = (ManageMarkDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.MANAGEMARK);

    @Override
    public ArrayList<GetStudentNameIdTM> getStudentDetail(ClassDTO classDTO) throws SQLException {
       return manageMarkDAO.getStudentDetail(classDTO);
    }

    @Override
    public boolean upDateMark(ExamSubjectIdDTO examSubjectIdDTO) throws SQLException, ClassNotFoundException {
       return manageMarkDAO.upDate( new ExamSubject(examSubjectIdDTO.getMark(),examSubjectIdDTO.getExamId(),examSubjectIdDTO.getStudentId(),examSubjectIdDTO.getSubjectId()));
    }

    public boolean deleteMark(ExamSubjectIdDTO examSubjectIdDTO) throws SQLException, ClassNotFoundException {

        return manageMarkDAO.delete(examSubjectIdDTO);
    }

    @Override
    public boolean saveMark(ExamSubjectIdDTO dto) throws SQLException, ClassNotFoundException {
        return manageMarkDAO.save(new ExamSubject(dto.getMark(),dto.getExamId(),dto.getStudentId(),dto.getSubjectId()));
    }

    @Override
    public ArrayList<ExamSubject> getAllSubject() throws SQLException, ClassNotFoundException {
        return manageMarkDAO.getAll();
    }

    @Override
    public ArrayList<ExamSubject> search() throws SQLException, ClassNotFoundException {
        return manageMarkDAO.search();
    }

    @Override
    public String getSubjectD() throws SQLException, ClassNotFoundException {
        return manageMarkDAO.getID();
    }
}
