package com.assignment.finalproject.bo.custom.impl.MainBOImpl;

import com.assignment.finalproject.bo.custom.AddExamListBO;
import com.assignment.finalproject.dao.CrudUtil;
import com.assignment.finalproject.dao.DAOFactory;
import com.assignment.finalproject.db.DBConnection;
import com.assignment.finalproject.dto.sub.ExamDTO;
import com.assignment.finalproject.dto.sub.ExamScheduleDTO;
import com.assignment.finalproject.dto.sub.ExamSubjectIdDTO;
import com.assignment.finalproject.dao.custom.Impl.mainMOdel.AddExamListDAOImpl;
import com.assignment.finalproject.entity.sub.Exam;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class AddExamListBOImpl implements AddExamListBO {

    AddExamListDAOImpl addExamListDAO = (AddExamListDAOImpl) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ADDEXAMLIST);

    ExamShedulBOImpl examShedulDAO = (ExamShedulBOImpl) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.EXAMSCHEDULE);
    ExamSubjectBOImpl examSubjectDAO = (ExamSubjectBOImpl) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.EXAMSUBJECT);

    public String getExamShedulID() {
        return addExamListDAO.getExamShedulID();
    }

    public boolean saveExamList(
            ArrayList<ExamDTO> examDTOList,
            ArrayList<ExamScheduleDTO> examScheduleDTOList,
            ArrayList<ExamSubjectIdDTO> examSubjectIdDTOList) throws SQLException {

        Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false); // Begin transaction

        try {

            for (ExamDTO examDTO : examDTOList) {
                boolean isExamSaved = CrudUtil.execute(
                        "INSERT INTO exam (ex_id, e_name, grade) VALUES (?, ?, ?)",
                        examDTO.getExamId(),
                        examDTO.getExamName(),
                        examDTO.getGrade()
                );
                if (!isExamSaved) {
                    connection.rollback();
                    return false;
                }
            }

            for (ExamScheduleDTO scheduleDTO : examScheduleDTOList) {
                boolean isScheduleSaved = examShedulDAO.saveShedul(scheduleDTO);
                if (!isScheduleSaved) {
                    connection.rollback();
                    return false;
                }
            }

            for (ExamSubjectIdDTO subjectIdDTO : examSubjectIdDTOList) {
                boolean isSubjectSaved = examSubjectDAO.saveExamSubject(subjectIdDTO);
                if (!isSubjectSaved) {
                    connection.rollback();
                    return false;
                }
            }

            connection.commit();
            return true;

        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
            return false;

        } finally {
            connection.setAutoCommit(true);
        }
    }

    @Override
    public ArrayList<Exam> getAllExamList() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<ExamDTO> searcheExamLis() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String getExamID() throws SQLException, ClassNotFoundException {
         return addExamListDAO.getID();
    }

    @Override
    public boolean upDate(ExamDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return addExamListDAO.delete(id);
    }
}
