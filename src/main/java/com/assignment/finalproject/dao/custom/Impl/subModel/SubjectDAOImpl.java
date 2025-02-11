package com.assignment.finalproject.dao.custom.Impl.subModel;

import com.assignment.finalproject.dao.CrudUtil;
import com.assignment.finalproject.dao.custom.SubjectDAO;
import com.assignment.finalproject.dto.sub.SabjectDTO;
import com.assignment.finalproject.entity.main.AddExamList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SubjectDAOImpl implements SubjectDAO {

    @Override
    public ObservableList<SabjectDTO> get6TO9Subject() throws SQLException {
        ResultSet rst = CrudUtil.execute("select * from subject ORDER BY sub_id asc limit 8");

        ObservableList<SabjectDTO> sabjectDTOS = FXCollections.observableArrayList();
        while (rst.next()) {
            SabjectDTO sabjectDTO = new SabjectDTO(
                    rst.getString(1),
                    rst.getString(2)
            );
            sabjectDTOS.add(sabjectDTO);
        }
        return sabjectDTOS;
    }

    @Override
    public ObservableList<SabjectDTO> get10TO11Subject() throws SQLException {
        ResultSet rst = CrudUtil.execute("select * from subject ORDER BY sub_id desc limit 9");

        ObservableList<SabjectDTO> sabjectDTOS = FXCollections.observableArrayList();
        while (rst.next()) {
            SabjectDTO sabjectDTO = new SabjectDTO(
                    rst.getString(1),
                    rst.getString(2)
            );
            sabjectDTOS.add(sabjectDTO);
        }
        return sabjectDTOS;
    }

    @Override
    public String getSubjectName(String subjectID) throws SQLException {
        ResultSet resultSet = CrudUtil.execute("select s_name from subject where sub_id = ?",subjectID);
        System.out.println(subjectID);

        if (resultSet.next()) { // Ensure there is a result
            return resultSet.getString("s_name"); // Fetch and return the s_name as a String
        } else {
            return null; // Return null if no result is found (optional, handle as needed)
        }
    }

    @Override
    public boolean save(Object dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList search() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String getID() throws SQLException, ClassNotFoundException {
        return "";
    }

    @Override
    public boolean upDate(Object dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }
}
