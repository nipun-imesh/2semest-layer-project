package com.assignment.finalproject.model.mainModel;

import com.assignment.finalproject.Cradutil.CrudUtil;
import com.assignment.finalproject.dto.main.StudentSubjectDetaliDTO;
import com.assignment.finalproject.dto.tm.GetResaltTM;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentResaliViewModel {

    public ArrayList<GetResaltTM> searchResalt(StudentSubjectDetaliDTO studentSubjectDetaliDTO) throws SQLException {

        ResultSet sql = CrudUtil.execute(
                "SELECT s_name ,mark FROM student s INNER JOIN marks m ON s.stu_id = m.stu_id INNER JOIN subject subj ON m.sub_id = subj.sub_id INNER JOIN exam e ON m.ex_id = e.ex_id WHERE  s.class = ? AND  e.e_name = ? AND s.s_grade = ? AND s.stu_id = ?",

                studentSubjectDetaliDTO.getClassId(),
                studentSubjectDetaliDTO.getExamname(),
                studentSubjectDetaliDTO.getGrade(),
                studentSubjectDetaliDTO.getStudentId()
        );

        ArrayList<GetResaltTM> getResaltTMS = new ArrayList<>();
        while (sql.next()) {
            GetResaltTM getResaltTM = new GetResaltTM(
                    sql.getString(1),
                    sql.getDouble(2)
            );
            getResaltTMS.add(getResaltTM);
        }
        return getResaltTMS;
    }
}