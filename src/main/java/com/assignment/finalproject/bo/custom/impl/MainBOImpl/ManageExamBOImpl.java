package com.assignment.finalproject.bo.custom.impl.MainBOImpl;

import com.assignment.finalproject.dao.CrudUtil;
import com.assignment.finalproject.dao.DAOFactory;
import com.assignment.finalproject.dao.custom.Impl.mainMOdel.ExamShedulDAOImpl;
import com.assignment.finalproject.dao.custom.Impl.mainMOdel.ExamSubjectDAOImpl;
import com.assignment.finalproject.dao.custom.Impl.mainMOdel.ManageExamDAOImpl;
import com.assignment.finalproject.db.DBConnection;
import com.assignment.finalproject.dto.main.AddExamListDTO;
import com.assignment.finalproject.dto.sub.ExamScheduleDTO;
import com.assignment.finalproject.entity.main.AddExamList;
import com.assignment.finalproject.entity.sub.ExamSchedule;
import com.assignment.finalproject.bo.custom.ManageExamBO;
import com.assignment.finalproject.entity.sub.ExamSubject;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManageExamBOImpl implements ManageExamBO {

    ManageExamDAOImpl manageExamDAO = (ManageExamDAOImpl) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.MANAGEEXAM);
    ExamShedulDAOImpl examShedulDAO = (ExamShedulDAOImpl) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.EXAMSCHEDULE);
    ExamSubjectDAOImpl examSubjectDAO = (ExamSubjectDAOImpl) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.EXAMSUBJECT);

    public boolean upDateExam(AddExamListDTO addExamListDTO) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);

        try {

            boolean isExamUpdated = CrudUtil.execute(
                    "UPDATE exam SET e_name = ?, grade = ? WHERE ex_id = ?",
                    addExamListDTO.getExamName(),
                    addExamListDTO.getGrade(),
                    addExamListDTO.getExamID()
            );

            if (!isExamUpdated) {
                connection.rollback();
                return false;
            }


            boolean isScheduleUpdated = examShedulDAO.upDate(new ExamSchedule(
                    addExamListDTO.getExamID(),
                    addExamListDTO.getHallName(),
                    addExamListDTO.getExamTime(),
                    addExamListDTO.getExamDate(),
                    addExamListDTO.getExamShedulID()
            ));

            if (!isScheduleUpdated) {
                connection.rollback();
                return false;
            }

            boolean isExamSubjectIdUpdate = examSubjectDAO.upDate(new ExamSubject(
                    addExamListDTO.getSubjectID(),
                    addExamListDTO.getExamID()

            ));

            if (!isExamSubjectIdUpdate) {
                connection.rollback();
                return false;
            }

            connection.commit();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();
            return false;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            connection.setAutoCommit(true);
        }
    }

    @Override
    public boolean deleteExam(AddExamListDTO addExamListDTO)  throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);

        try {
            boolean isSubjectDeleted = examSubjectDAO.delete(addExamListDTO.getExamID());
            if (!isSubjectDeleted) {
                connection.rollback();
                return false;
            }

            boolean isScheduleDeleted = examShedulDAO.delete(addExamListDTO.getExamShedulID());
            if (!isScheduleDeleted) {
                connection.rollback();
                return false;
            }

            boolean isExamDeleted = CrudUtil.execute("DELETE FROM exam WHERE ex_id = ?", addExamListDTO.getExamID());
            if (!isExamDeleted) {
                connection.rollback();
                return false;
            }

            connection.commit();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();
            return false;
        } finally {
            connection.setAutoCommit(true);
        }
    }

    @Override
    public boolean saveExam(AddExamListDTO dto) throws SQLException {
        return false;
    }

    @Override
    public ArrayList<AddExamListDTO> getAllExam() throws SQLException {
        return null;
    }

    @Override
    public ArrayList<AddExamList> searchExam() {
        return null;
    }

    @Override
    public String getExamID() throws SQLException {
        return manageExamDAO.getID();
    }
}
