package com.assignment.finalproject.dao.custom.Impl.mainMOdel;

import com.assignment.finalproject.dao.CrudUtil;
import com.assignment.finalproject.dao.custom.ManageMarkDAO;
import com.assignment.finalproject.dto.sub.ClassDTO;
import com.assignment.finalproject.dto.sub.ExamSubjectIdDTO;
import com.assignment.finalproject.dto.tm.GetStudentNameIdTM;
import com.assignment.finalproject.entity.main.AddExamList;
import com.assignment.finalproject.entity.sub.ExamSubject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManageMarkDAOImpl implements ManageMarkDAO {

    @Override
    public ArrayList<GetStudentNameIdTM> getStudentDetail(ClassDTO classDTO) throws SQLException {
        ResultSet rst = CrudUtil.execute(
                "SELECT * FROM student WHERE   class = ? AND s_grade = ? AND status = 'Active'",
                classDTO.getClassId(),
                classDTO.getGrade()
        );
        ArrayList<GetStudentNameIdTM> getStudentNameIdTMS = new ArrayList<>();

        while (rst.next()) {
            GetStudentNameIdTM getStudentNameIdTM = new GetStudentNameIdTM(
                    rst.getString(1),
                    rst.getString(2)
            );
            getStudentNameIdTMS.add(getStudentNameIdTM);
        }
        return getStudentNameIdTMS;
    }

    @Override
    public boolean upDate(ExamSubject dto) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE marks SET mark = ? WHERE ex_id = ? AND stu_id = ? AND sub_id = ?",
                dto.getMark(),
                dto.getExamId(),
                dto.getStudentId(),
                dto.getSubjectId());
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(ExamSubjectIdDTO examSubjectIdDTO) throws SQLException {

        return CrudUtil.execute("DELETE FROM marks WHERE ex_id = ? AND sub_id = ?",
                examSubjectIdDTO.getExamId(),
                examSubjectIdDTO.getSubjectId());
    }

    @Override
    public boolean save(ExamSubject dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<ExamSubject> getAll() throws SQLException {
        return null;
    }

    @Override
    public ArrayList<ExamSubject> search() {
        return null;
    }

    @Override
    public String getID() throws SQLException {
        return "";
    }

}

