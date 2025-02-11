package com.assignment.finalproject.dao.custom.Impl.mainMOdel;

import com.assignment.finalproject.dao.CrudUtil;
import com.assignment.finalproject.dao.custom.ExamSubjectDAO;
import com.assignment.finalproject.dto.sub.ExamScheduleDTO;
import com.assignment.finalproject.entity.sub.ExamSchedule;
import com.assignment.finalproject.entity.sub.ExamSubject;

import java.sql.SQLException;
import java.util.ArrayList;

public class ExamSubjectDAOImpl implements ExamSubjectDAO {

    @Override
    public boolean save(ExamSubject subjectId) throws SQLException {
        return CrudUtil.execute(
                "INSERT INTO sub_exam_detail (exa_id, sub_id) VALUES (?, ?)",
                subjectId.getExamId(),
                subjectId.getSubjectId()
        );
    }

    @Override
    public ArrayList<ExamSubject> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<ExamSubject> search() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean delete(String examID) throws SQLException {
        return CrudUtil.execute("DELETE FROM sub_exam_detail WHERE exa_id = ?", examID);
    }

    @Override
    public String getID() throws SQLException {
        return "";
    }

    @Override
    public boolean upDate(ExamSubject dto) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute(
                "UPDATE sub_exam_detail SET sub_id = ? WHERE exa_id = ?",
                dto.getSubjectId(),
                dto.getExamId()
        );
    }

}



