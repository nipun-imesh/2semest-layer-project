package com.assignment.finalproject.bo.custom.impl.MainBOImpl;

import com.assignment.finalproject.bo.custom.ExamShedulBO;
import com.assignment.finalproject.dao.CrudUtil;
import com.assignment.finalproject.dao.DAOFactory;
import com.assignment.finalproject.dao.custom.Impl.mainMOdel.ExamShedulDAOImpl;
import com.assignment.finalproject.dto.main.AddExamListDTO;
import com.assignment.finalproject.dto.sub.ExamScheduleDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ExamShedulBOImpl implements ExamShedulBO {

    ExamShedulDAOImpl examShedulDAO = (ExamShedulDAOImpl) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.EXAMSCHEDULE);


    public String getShedulID() throws SQLException {
        return examShedulDAO.getID();
    }

    public boolean upDateShedul(AddExamListDTO addExamListDTO) throws SQLException {
        return examShedulDAO.upDate(addExamListDTO);
    }

    public boolean saveShedul(ExamScheduleDTO examSchedule) throws SQLException {
        return examShedulDAO.save(examSchedule);
    }

    public ArrayList<ExamScheduleDTO> getAllShedul() throws SQLException {
        return examShedulDAO.getAll();
    }

    public ArrayList<ExamScheduleDTO> search() {
        return examShedulDAO.search();
    }

    public boolean deleteShedul(String examShedulID) throws SQLException {
        return examShedulDAO.delete(examShedulID);
    }
}
