package com.assignment.finalproject.dao.custom.Impl.mainMOdel;

import com.assignment.finalproject.dao.CrudUtil;
import com.assignment.finalproject.dao.custom.AddMarkDAO;
import com.assignment.finalproject.dto.main.AddMarkDTO;
import com.assignment.finalproject.dto.sub.*;
import com.assignment.finalproject.dto.tm.GetStudentNameIdTM;
import com.assignment.finalproject.entity.main.AddExamList;
import com.assignment.finalproject.entity.main.AddMark;
import com.assignment.finalproject.entity.main.StudentManage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AddMarkDAOImpl implements AddMarkDAO {

    @Override
    public ArrayList<StudentManage> getStudentNameId(AddMark mark) throws SQLException {
        System.out.println(mark.getClassId() + " " + mark.getGrade());
        ResultSet rst = CrudUtil.execute(
                "SELECT * FROM student WHERE   class = ? AND s_grade = ? AND status = 'Active'",

                mark.getClassId(),
                mark.getGrade()
        );
        ArrayList<StudentManage> studentManages = new ArrayList<>();

        while (rst.next()) {
            StudentManage getStudentNameId = new StudentManage(
                    rst.getString(1),
                    rst.getString(2)
            );
            studentManages.add(getStudentNameId);
        }
        return studentManages;
    }

    public ArrayList<ExamNameDTO> getExamList(String grade) throws SQLException {

      ResultSet rst = CrudUtil.execute("SELECT e_name FROM exam WHERE grade = ?",
              grade
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

    @Override
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


    @Override
    public boolean save(AddMark dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<AddMark> getAll() throws SQLException {
        return null;
    }

    @Override
    public ArrayList<AddMark> search() {
        return null;
    }

    @Override
    public String getID() throws SQLException {
        return "";
    }

    @Override
    public boolean upDate(AddMark dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String parentId) throws SQLException {
        return false;
    }
}
