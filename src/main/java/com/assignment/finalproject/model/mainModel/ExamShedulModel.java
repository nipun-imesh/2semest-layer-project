package com.assignment.finalproject.model.mainModel;

import com.assignment.finalproject.Cradutil.CrudUtil;
import com.assignment.finalproject.dto.main.AddExamListDTO;
import com.assignment.finalproject.dto.sub.ExamScheduleDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ExamShedulModel {

    public boolean updateExamSchedule(AddExamListDTO addExamListDTO) throws SQLException {

        return CrudUtil.execute(
                "UPDATE exam_schedule SET exam_id = ?, hall_id = ?, time = ?, date = ? WHERE exam_schedule_id = ?",

                addExamListDTO.getExamID(),
                addExamListDTO.getHallName(),
                addExamListDTO.getExamTime(),
                addExamListDTO.getExamDate(),
                addExamListDTO.getExamShedulID()
        );
    }

    public boolean saveExamSchedule(ExamScheduleDTO examSchedule) throws SQLException {
        return CrudUtil.execute(
                "INSERT INTO exam_schedule (exam_schedule_id, exam_id, hall_id, time, date) VALUES (?, ?, ?, ?, ?)",
                examSchedule.getExamScheduleId(),
                examSchedule.getExamId(),
                examSchedule.getHallId(),
                examSchedule.getExamTime(),
                examSchedule.getExamDate()
        );
    }

    public boolean deleteExamSchedule(String examShedulID) throws SQLException {
        System.out.println(examShedulID + " nipun");
        return CrudUtil.execute("DELETE FROM exam_schedule WHERE exam_schedule_id = ?", examShedulID);
    }

}
