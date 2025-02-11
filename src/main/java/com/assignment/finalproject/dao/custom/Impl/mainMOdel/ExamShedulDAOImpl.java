package com.assignment.finalproject.dao.custom.Impl.mainMOdel;

import com.assignment.finalproject.dao.CrudUtil;
import com.assignment.finalproject.dao.custom.ExamShedulDAO;
import com.assignment.finalproject.entity.sub.ExamSchedule;

import java.sql.SQLException;
import java.util.ArrayList;

public class ExamShedulDAOImpl implements ExamShedulDAO {

    public String getID() throws SQLException {
        return "";
    }



    @Override
    public boolean upDate(ExamSchedule addExamList) throws SQLException {

        return CrudUtil.execute(
                "UPDATE exam_schedule SET exam_id = ?, hall_id = ?, time = ?, date = ? WHERE exam_schedule_id = ?",

                addExamList.getExamId(),
                addExamList.getHallName(),
                addExamList.getExamTime(),
                addExamList.getExamDate(),
                addExamList.getExamScheduleId()
        );
    }

    public boolean save(ExamSchedule examSchedule) throws SQLException {
        return CrudUtil.execute(
                "INSERT INTO exam_schedule (exam_schedule_id, exam_id, hall_id, time, date) VALUES (?, ?, ?, ?, ?)",
                examSchedule.getExamScheduleId(),
                examSchedule.getExamId(),
                examSchedule.getHallId(),
                examSchedule.getExamTime(),
                examSchedule.getExamDate()
        );
    }

    public ArrayList<ExamSchedule> getAll() throws SQLException {
        return null;
    }

    public ArrayList<ExamSchedule> search() {
        return null;
    }

    public boolean delete(String examShedulID) throws SQLException {
        System.out.println(examShedulID + " nipun");
        return CrudUtil.execute("DELETE FROM exam_schedule WHERE exam_schedule_id = ?", examShedulID);
    }

}
