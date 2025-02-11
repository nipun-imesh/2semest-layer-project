package com.assignment.finalproject.dao.custom;

import com.assignment.finalproject.dao.CrudDAO;
import com.assignment.finalproject.dto.sub.ExamDTO;
import com.assignment.finalproject.dto.sub.ExamScheduleDTO;
import com.assignment.finalproject.dto.sub.ExamSubjectIdDTO;
import com.assignment.finalproject.entity.sub.Exam;
import com.assignment.finalproject.entity.sub.ExamSchedule;
import com.assignment.finalproject.entity.sub.ExamSubject;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AddExamListDAO extends CrudDAO<Exam> {
     boolean save(
            ArrayList<Exam> examDTOList,
            ArrayList<ExamSchedule> examScheduleDTOList,
            ArrayList<ExamSubject> examSubjectIdDTOList) throws SQLException;
}
