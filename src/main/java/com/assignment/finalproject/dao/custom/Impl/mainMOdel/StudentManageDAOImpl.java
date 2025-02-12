package com.assignment.finalproject.dao.custom.Impl.mainMOdel;

import com.assignment.finalproject.dao.CrudUtil;
import com.assignment.finalproject.dao.custom.StudentManageDAO;
import com.assignment.finalproject.dto.main.StudentManageDTO;
import com.assignment.finalproject.entity.main.StudentManage;
import javafx.scene.control.Alert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

public class StudentManageDAOImpl implements StudentManageDAO {

    @Override
    public  boolean save(StudentManage studto) {
        System.out.println(studto.getStudentId());
        try {
            return CrudUtil.execute(
                    "insert into student values (?,?,?,?,?,?,?,?)",
                    studto.getStudentId(),
                    studto.getStudentName(),
                    studto.getAge(),
                    studto.getDateofBarth(),
                    studto.getGrade(),
                    studto.getS_class(),
                    studto.getParentId(),
                    studto.getStatus()
            );
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,"Duplicate ID").show();
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<StudentManage> getAll() throws SQLException {
        ResultSet rst = CrudUtil.execute("SELECT * FROM student WHERE status = 'Active'");

        ArrayList<StudentManage> studentManageDTOS = new ArrayList<>();

        while (rst.next()) {
            StudentManage studentManage = new StudentManage(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getInt(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8)
            );
            studentManageDTOS.add(studentManage);
        }
        return studentManageDTOS;
    }

    @Override
    public ArrayList<StudentManage> search() {
        return null;
    }

    @Override
    public String getID() throws SQLException {

        String uniqueID = UUID.randomUUID().toString().substring(0, 8);
        return "S0" +"" + uniqueID;
    }


    @Override
    public boolean delete(String id) throws SQLException {
        return CrudUtil.execute("update student set status = 'Deactive' where stu_id = ?",id);
    }

    @Override
    public boolean upDate(StudentManage studentManage) {
        try {
            return CrudUtil.execute(
                    "update student set stu_name = ?,age = ?,DOB = ?,s_grade = ?,class = ?,parent_id = ? where stu_id = ?",
                    studentManage.getStudentName(),
                    studentManage.getAge(),
                    studentManage.getDateofBarth(),
                    studentManage.getGrade(),
                    studentManage.getS_class(),
                    studentManage.getParentId(),
                    studentManage.getStudentId()
            );
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,"Duplicate ID").show();
            throw new RuntimeException(e);
        }
    }
}
