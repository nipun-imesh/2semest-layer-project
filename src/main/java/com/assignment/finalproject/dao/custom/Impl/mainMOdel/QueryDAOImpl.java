package com.assignment.finalproject.dao.custom.Impl.mainMOdel;

import com.assignment.finalproject.dao.CrudUtil;
import com.assignment.finalproject.dao.custom.QueryDAO;
import com.assignment.finalproject.dto.main.StudentSubjectDetaliDTO;
import com.assignment.finalproject.dto.tm.GetResaltTM;
import com.assignment.finalproject.dto.tm.ManageExamMarkTM;
import com.assignment.finalproject.dto.tm.ManageExamTM;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QueryDAOImpl implements QueryDAO {

    @Override
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

    @Override
    public ArrayList<ManageExamMarkTM> getStudentMarkDetail(String studentId) throws SQLException {
        ResultSet rst = CrudUtil.execute("SELECT \n" +
                "    e.ex_id AS examID, \n" +
                "    m.sub_id AS subjectID, \n" +
                "    e.e_name AS examName, \n" +
                "    m.mark, \n" +
                "    es.date, \n" +
                "    m.stu_id AS studentID\n" +
                "FROM \n" +
                "    exam e\n" +
                "JOIN \n" +
                "    marks m ON e.ex_id = m.ex_id\n" +
                "JOIN \n" +
                "    exam_schedule es ON e.ex_id = es.exam_id\n" +
                "WHERE \n" +
                "    m.stu_id = ?", studentId);

        ArrayList<ManageExamMarkTM> manageExamMarkTMS = new ArrayList<>();

        while (rst.next()) {
            ManageExamMarkTM manageExamMarkTM = new ManageExamMarkTM(
                    rst.getString("examID"),
                    rst.getString("subjectID"),
                    rst.getString("studentID"),  // Now this will correctly retrieve the studentID
                    rst.getString("mark"),
                    rst.getString("date")
            );
            manageExamMarkTMS.add(manageExamMarkTM);
        }
        return manageExamMarkTMS;
    }

    public ArrayList<GetResaltTM> search(StudentSubjectDetaliDTO studentSubjectDetaliDTO) throws SQLException {

        ResultSet sql = CrudUtil.execute(
                "SELECT s_name ,mark FROM student" +
                        " s INNER JOIN marks m ON s.stu_id = m.stu_id " +
                        "INNER JOIN subject subj ON m.sub_id = subj.sub_id" +
                        " INNER JOIN exam e ON m.ex_id = e.ex_id WHERE " +
                        " s.class = ? AND  e.e_name = ? AND s.s_grade = ? AND s.stu_id = ?",

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
