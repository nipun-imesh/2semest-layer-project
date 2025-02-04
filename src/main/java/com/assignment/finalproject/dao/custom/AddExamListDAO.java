package com.assignment.finalproject.dao.custom;

import com.assignment.finalproject.dao.CrudDAO;
import com.assignment.finalproject.dto.sub.ExamDTO;
import com.assignment.finalproject.dto.sub.ExamScheduleDTO;
import com.assignment.finalproject.dto.sub.ExamSubjectIdDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AddExamListDAO extends CrudDAO<ExamDTO> {
     boolean save(
            ArrayList<ExamDTO> examDTOList,
            ArrayList<ExamScheduleDTO> examScheduleDTOList,
            ArrayList<ExamSubjectIdDTO> examSubjectIdDTOList) throws SQLException;
}
