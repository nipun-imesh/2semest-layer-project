package com.assignment.finalproject.bo.custom.impl.MainBOImpl;

import com.assignment.finalproject.bo.custom.ExamShedulBO;
import com.assignment.finalproject.bo.custom.ExamSubjectBO;
import com.assignment.finalproject.dao.CrudUtil;
import com.assignment.finalproject.dao.DAOFactory;
import com.assignment.finalproject.dao.custom.Impl.mainMOdel.ExamShedulDAOImpl;
import com.assignment.finalproject.dao.custom.Impl.mainMOdel.ExamSubjectDAOImpl;
import com.assignment.finalproject.dto.sub.ExamScheduleDTO;
import com.assignment.finalproject.dto.sub.ExamSubjectIdDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ExamSubjectBOImpl implements ExamSubjectBO {

    ExamSubjectDAOImpl examSubjectDAO = (ExamSubjectDAOImpl) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.EXAMSUBJECT);

    @Override
    public boolean saveExamSubject(ExamSubjectIdDTO subjectIdDTO) throws SQLException {
        return examSubjectDAO.save(subjectIdDTO);
    }

    @Override
    public boolean upDateExamSubject(ExamScheduleDTO examScheduleDTO) throws SQLException {
        return examSubjectDAO.upDate(examScheduleDTO);
    }


    @Override
    public boolean deleteExamSubect(String examID) throws SQLException {
        return examSubjectDAO.delete(examID);
    }

    @Override
    public ArrayList<ExamSubjectIdDTO> getAllExamSubject() throws SQLException {
        return examSubjectDAO.getAll();
    }

    @Override
    public ArrayList<ExamSubjectIdDTO> searchExamSubject() {
        return examSubjectDAO.search();
    }

    @Override
    public String getExamSublectID() throws SQLException {
        return examSubjectDAO.getID();
    }
}
