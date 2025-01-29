package com.assignment.finalproject.dao.custom;

import com.assignment.finalproject.dao.CrudDAO;
import com.assignment.finalproject.dto.sub.ExamScheduleDTO;
import com.assignment.finalproject.dto.sub.ExamSubjectIdDTO;

import java.sql.SQLException;

public interface ExamSubjectDAO extends CrudDAO<ExamSubjectIdDTO> {
    public boolean upDate(ExamScheduleDTO examScheduleDTO) throws SQLException;
}
