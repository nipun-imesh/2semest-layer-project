package com.assignment.finalproject.bo.custom.impl.MainBOImpl;

import com.assignment.finalproject.bo.custom.AddExamListBO;
import com.assignment.finalproject.dao.CrudUtil;
import com.assignment.finalproject.dao.DAOFactory;
import com.assignment.finalproject.dao.custom.AddExamListDAO;
import com.assignment.finalproject.dao.custom.ExamShedulDAO;
import com.assignment.finalproject.dao.custom.ExamSubjectDAO;
import com.assignment.finalproject.dao.custom.Impl.mainMOdel.ExamShedulDAOImpl;
import com.assignment.finalproject.db.DBConnection;
import com.assignment.finalproject.dto.sub.ExamDTO;
import com.assignment.finalproject.dto.sub.ExamScheduleDTO;
import com.assignment.finalproject.dto.sub.ExamSubjectIdDTO;
import com.assignment.finalproject.dao.custom.Impl.mainMOdel.AddExamListDAOImpl;
import com.assignment.finalproject.entity.sub.Exam;
import com.assignment.finalproject.entity.sub.ExamSchedule;
import com.assignment.finalproject.entity.sub.ExamSubject;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class AddExamListBOImpl implements AddExamListBO {

    AddExamListDAO addExamListDAO = (AddExamListDAOImpl) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ADDEXAMLIST);

    ExamShedulDAO examShedulDAO = (ExamShedulDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.EXAMSCHEDULE);
    ExamSubjectDAO examSubjectDAO = (ExamSubjectDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.EXAMSUBJECT);

    public String getExamShedulID() throws SQLException, ClassNotFoundException {
        return addExamListDAO.getID();
    }

    public boolean saveExamList(
            ArrayList<ExamDTO> examDTOList,
            ArrayList<ExamScheduleDTO> examScheduleDTOList,
            ArrayList<ExamSubjectIdDTO> examSubjectIdDTOList) throws SQLException, ClassNotFoundException {

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
                boolean isScheduleSaved = examShedulDAO.save(new ExamSchedule(scheduleDTO.getExamScheduleId(), scheduleDTO.getExamId(), scheduleDTO.getHallId(), scheduleDTO.getExamTime(), scheduleDTO.getExamDate()));
                if (!isScheduleSaved) {
                    connection.rollback();
                    return false;
                }
            }

            for (ExamSubjectIdDTO subjectIdDTO : examSubjectIdDTOList) {
                boolean isSubjectSaved = examSubjectDAO.save(new ExamSubject(subjectIdDTO.getSubjectId(), subjectIdDTO.getExamId(), subjectIdDTO.getStudentId()));
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
