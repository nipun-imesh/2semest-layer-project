package com.assignment.finalproject.model.mainModel;

import com.assignment.finalproject.Cradutil.CrudUtil;
import com.assignment.finalproject.db.DBConnection;
import com.assignment.finalproject.dto.main.AddExamListDTO;
import com.assignment.finalproject.dto.sub.ExamScheduleDTO;
import com.assignment.finalproject.dto.sub.ExamSubjectIdDTO;
import com.assignment.finalproject.dto.tm.ManageExamTM;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManageExamModel {

    ExamShedulModel examShedulModel = new ExamShedulModel();
    ExamSubjectModel examSubjectModel = new ExamSubjectModel();

    public ArrayList<ManageExamTM> getSelectExam(String grade) throws SQLException {
        String sql = "SELECT " +
                "es.exam_schedule_id AS examShedulID, " +
                "es.exam_id AS examID, " +
                "es.hall_id AS hallID, " +
                "e.e_name AS examName, " +
                "e.grade AS grade, " +
                "es.date AS date, " +
                "es.time AS time, " +
                "sed.sub_id AS subjectID " +
                "FROM exam e " +
                "JOIN exam_schedule es ON e.ex_id = es.exam_id " +
                "LEFT JOIN sub_exam_detail sed ON e.ex_id = sed.exa_id " +
                "WHERE e.grade = ?";

        ResultSet rst = CrudUtil.execute(sql, grade);

        ArrayList<ManageExamTM> manageExamTMS = new ArrayList<>();

        while (rst.next()) {
            ManageExamTM manageExamTM = new ManageExamTM();
            manageExamTM.setExamShedulID(rst.getString("examShedulID"));
            manageExamTM.setExamID(rst.getString("examID"));
            manageExamTM.setHallID(rst.getString("hallID"));
            manageExamTM.setExamName(rst.getString("examName"));
            manageExamTM.setGrade(rst.getString("grade"));
            manageExamTM.setDate(rst.getString("date"));
            manageExamTM.setTime(rst.getString("time"));
            manageExamTM.setSubjectID(rst.getString("subjectID"));
            manageExamTMS.add(manageExamTM);
        }
        return manageExamTMS;
    }

    public boolean updateExamAndSchedule(AddExamListDTO addExamListDTO) throws SQLException {
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


            boolean isScheduleUpdated = examShedulModel.updateExamSchedule(new AddExamListDTO(
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

            boolean isExamSubjectIdUpdate = examSubjectModel.updateExamSubjectId(new ExamScheduleDTO(
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
        } finally {
            connection.setAutoCommit(true);
        }
    }

    public boolean deleteExam(AddExamListDTO addExamListDTO)  throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);

        try {
            boolean isSubjectDeleted = examSubjectModel.deleteSubject(addExamListDTO.getExamID());
            if (!isSubjectDeleted) {
                connection.rollback();
                return false;
            }

            boolean isScheduleDeleted = examShedulModel.deleteExamSchedule(addExamListDTO.getExamShedulID());
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
}







