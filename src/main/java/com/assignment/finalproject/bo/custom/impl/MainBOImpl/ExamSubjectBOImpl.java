package com.assignment.finalproject.bo.custom.impl.MainBOImpl;

import com.assignment.finalproject.bo.custom.ExamSubjectBO;
import com.assignment.finalproject.dao.DAOFactory;
import com.assignment.finalproject.dao.custom.Impl.mainMOdel.ExamSubjectDAOImpl;
import com.assignment.finalproject.dto.sub.ExamScheduleDTO;
import com.assignment.finalproject.dto.sub.ExamSubjectIdDTO;
import com.assignment.finalproject.entity.sub.ExamSubject;

import java.sql.SQLException;
import java.util.ArrayList;

public class ExamSubjectBOImpl implements ExamSubjectBO {

    ExamSubjectDAOImpl examSubjectDAO = (ExamSubjectDAOImpl) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.EXAMSUBJECT);

    @Override
    public boolean saveExamSubject(ExamSubjectIdDTO subjectIdDTO) throws SQLException {
        return examSubjectDAO.save(new ExamSubject(subjectIdDTO.getExamId(),subjectIdDTO.getSubjectId()));
    }

    @Override
    public boolean upDateExamSubject(ExamScheduleDTO examScheduleDTO) throws SQLException, ClassNotFoundException {
        return examSubjectDAO.upDate(new ExamSubject(examScheduleDTO.getSubjectID(),examScheduleDTO.getExamId()));
    }


    @Override
    public boolean deleteExamSubect(String examID) throws SQLException {
        return examSubjectDAO.delete(examID);
    }

    @Override
    public ArrayList<ExamSubject> getAllExamSubject() throws SQLException, ClassNotFoundException {
        return examSubjectDAO.getAll();
    }

    @Override
    public ArrayList<ExamSubject> searchExamSubject() throws SQLException, ClassNotFoundException {
        return examSubjectDAO.search();
    }

    @Override
    public String getExamSublectID() throws SQLException {
        return examSubjectDAO.getID();
    }
}
