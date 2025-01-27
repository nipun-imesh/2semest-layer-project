package com.assignment.finalproject.model.mainModel;

import com.assignment.finalproject.Cradutil.CrudUtil;
import com.assignment.finalproject.dto.main.AddMarkDTO;
import com.assignment.finalproject.dto.sub.*;
import com.assignment.finalproject.dto.tm.GetStudentNameIdTM;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AddMarkModel {

    public ArrayList<GetStudentNameIdTM> getStudentNameId(AddMarkDTO markDTO) throws SQLException {
        System.out.println(markDTO.getClassId() + " " + markDTO.getGrade());
        ResultSet rst = CrudUtil.execute(
                "SELECT * FROM student WHERE   class = ? AND s_grade = ? AND status = 'Active'",

                markDTO.getClassId(),
                markDTO.getGrade()
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

    public ArrayList<ExamNameDTO> getExamList(String classNumber) throws SQLException {

      ResultSet rst = CrudUtil.execute("SELECT e_name FROM exam WHERE grade = ?",
              classNumber
      );
      ArrayList<ExamNameDTO> examNameDTOS = new ArrayList<>();

      while (rst.next()) {
          ExamNameDTO examNameDTO = new ExamNameDTO(
                  rst.getString(1)
          );
          examNameDTOS.add(examNameDTO);
      }
      return examNameDTOS;
    }

    public String fineExamId(String examName) throws SQLException {
        ResultSet resultSet = CrudUtil.execute("SELECT ex_id FROM exam WHERE e_name = ?", examName);

        if (resultSet.next()) {
            return resultSet.getString("ex_id");
        }
        return null;
    }

    public boolean palesAllMark(ArrayList<PlaysStudentAllMarkDTO> playsStudentAllMarkDTOS) throws SQLException {

        for(PlaysStudentAllMarkDTO playsStudentAllMarkDTO : playsStudentAllMarkDTOS) {

           boolean isSaved = CrudUtil.execute("INSERT INTO marks VALUES (?,?,?,?)",
                    playsStudentAllMarkDTO.getMark(),
                    playsStudentAllMarkDTO.getSubjectId(),
                    playsStudentAllMarkDTO.getStudentId(),
                    playsStudentAllMarkDTO.getExamId());
        }
        return true;
    }

    public boolean checkStudentExamSubject(ExamSubjectIdDTO examSubjectIdDTO) throws SQLException {
        ResultSet rst = CrudUtil.execute("SELECT * FROM marks WHERE stu_id = ? AND ex_id = ? AND sub_id = ?",
                examSubjectIdDTO.getStudentId(),
                examSubjectIdDTO.getExamId(),
                examSubjectIdDTO.getSubjectId());

        return rst.next();
    }

}
