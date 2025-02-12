package com.assignment.finalproject.dao.custom.Impl.mainMOdel;

import com.assignment.finalproject.dao.CrudUtil;
//import com.assignment.finalproject.dao.custom.ManageExamDAO;
import com.assignment.finalproject.dao.DAOFactory;
import com.assignment.finalproject.dao.custom.ExamShedulDAO;
import com.assignment.finalproject.dao.custom.ExamSubjectDAO;
import com.assignment.finalproject.dao.custom.ManageExamDAO;
import com.assignment.finalproject.db.DBConnection;
import com.assignment.finalproject.dto.main.AddExamListDTO;
import com.assignment.finalproject.dto.sub.ExamScheduleDTO;
import com.assignment.finalproject.entity.main.AddExamList;
import com.assignment.finalproject.entity.sub.ExamSchedule;
import com.assignment.finalproject.entity.sub.ExamSubject;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManageExamDAOImpl implements ManageExamDAO {

//    ExamShedulDAOImpl examShedulModel = new ExamShedulDAOImpl();
//    ExamSubjectDAOImpl examSubjectModel = new ExamSubjectDAOImpl();

    ExamSubjectDAO examSubjectModel = (ExamSubjectDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.EXAMSUBJECT);
    ExamShedulDAO examShedulModel = (ExamShedulDAO)DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.EXAMSCHEDULE);

    @Override
    public boolean upDate(AddExamList addExamList) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);

        try {

            boolean isExamUpdated = CrudUtil.execute(
                    "UPDATE exam SET e_name = ?, grade = ? WHERE ex_id = ?",
                    addExamList.getExamName(),
                    addExamList.getGrade(),
                    addExamList.getExamID()
            );

            if (!isExamUpdated) {
                connection.rollback();
                return false;
            }


            boolean isScheduleUpdated = examShedulModel.upDate(new ExamSchedule(
                    addExamList.getExamID(),
                    addExamList.getHallName(),
                    addExamList.getExamTime(),
                    addExamList.getExamDate(),
                    addExamList.getExamShedulID()
                    ));

            if (!isScheduleUpdated) {
                connection.rollback();
                return false;
            }

            boolean isExamSubjectIdUpdate = examSubjectModel.upDate(new ExamSubject(
                    addExamList.getSubjectID(),
                    addExamList.getExamID()

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
    public boolean delete(String parentId) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(AddExamListDTO addExamListDTO)  throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);

        try {
            boolean isSubjectDeleted = examSubjectModel.delete(addExamListDTO.getExamID());
            if (!isSubjectDeleted) {
                connection.rollback();
                return false;
            }

            boolean isScheduleDeleted = examShedulModel.delete(addExamListDTO.getExamShedulID());
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

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            connection.rollback();
            return false;
        } finally {
            connection.setAutoCommit(true);
        }
    }


    @Override
    public boolean save(AddExamList dto) throws SQLException {
        return false;
    }

    @Override
    public ArrayList<AddExamList> getAll() throws SQLException {
        return null;
    }

    @Override
    public ArrayList<AddExamList> search() {
        return null;
    }

    @Override
    public String getID() throws SQLException {
        return "";
    }


}







