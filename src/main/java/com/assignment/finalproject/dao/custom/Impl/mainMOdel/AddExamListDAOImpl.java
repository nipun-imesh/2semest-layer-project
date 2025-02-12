package com.assignment.finalproject.dao.custom.Impl.mainMOdel;

import com.assignment.finalproject.dao.CrudUtil;
import com.assignment.finalproject.dao.DAOFactory;
import com.assignment.finalproject.dao.custom.AddExamListDAO;
import com.assignment.finalproject.dao.custom.ExamShedulDAO;
import com.assignment.finalproject.dao.custom.ExamSubjectDAO;
import com.assignment.finalproject.db.DBConnection;
import com.assignment.finalproject.dto.sub.ExamDTO;
import com.assignment.finalproject.dto.sub.ExamScheduleDTO;
import com.assignment.finalproject.dto.sub.ExamSubjectIdDTO;
import com.assignment.finalproject.entity.main.AddExamList;
import com.assignment.finalproject.entity.sub.Exam;
import com.assignment.finalproject.entity.sub.ExamSchedule;
import com.assignment.finalproject.entity.sub.ExamSubject;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

public class AddExamListDAOImpl implements AddExamListDAO {

//    ExamShedulDAOImpl examShedulModel = new ExamShedulDAOImpl();
    ExamSubjectDAO examSubjectModel = (ExamSubjectDAO)DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.EXAMSUBJECT);
    ExamShedulDAO examShedulModel = (ExamShedulDAO)DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.EXAMSCHEDULE);

    public String getExamShedulID() {
        String uniqueID = UUID.randomUUID().toString().substring(0, 7);
        return "SH0" + "" + uniqueID;
    }

    @Override
    public String getID() throws SQLException, ClassNotFoundException {
        String uniqueID = UUID.randomUUID().toString().substring(0, 7);
        return "EX0" + "" + uniqueID;
    }

    public boolean save(
            ArrayList<Exam> examDTOList,
            ArrayList<ExamSchedule> examScheduleDTOList,
            ArrayList<ExamSubject> examSubjectIdDTOList) throws SQLException {

        Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false); // Begin transaction

        try {

            for (Exam examDTO : examDTOList) {
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

            for (ExamSchedule scheduleDTO : examScheduleDTOList) {
                boolean isScheduleSaved = examShedulModel.save(new ExamSchedule(scheduleDTO.getSubjectID(), scheduleDTO.getExamId()));
                if (!isScheduleSaved) {
                    connection.rollback();
                    return false;
                }
            }

            for (ExamSubject subjectIdDTO : examSubjectIdDTOList) {
                boolean isSubjectSaved = examSubjectModel.save(new ExamSubject(subjectIdDTO.getExamId(),subjectIdDTO.getSubjectId()));
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

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            connection.setAutoCommit(true);
        }
    }


    @Override
    public boolean upDate(Exam dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean save(Exam dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<Exam> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Exam> search() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }
}

