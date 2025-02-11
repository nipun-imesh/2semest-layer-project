package com.assignment.finalproject.dao.custom.Impl.mainMOdel;

import com.assignment.finalproject.dao.CrudUtil;
import com.assignment.finalproject.dao.custom.SendMailDAO;
import com.assignment.finalproject.dto.sub.GetParentIdDTO;
import com.assignment.finalproject.entity.main.AddExamList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SendMailDAOImpl implements SendMailDAO {

    @Override
    public ObservableList<GetParentIdDTO> getAllParentID() throws SQLException {

        ResultSet rst = CrudUtil.execute("select parent_id from parent where status = 'Active'");

        ObservableList<GetParentIdDTO> getParentIdDTOS = FXCollections.observableArrayList();
        while (rst.next()){
            GetParentIdDTO getParentIdDTO = new GetParentIdDTO(
                    rst.getString(1)
            );
            getParentIdDTOS.add(getParentIdDTO);
        }
        return getParentIdDTOS;
    }

    @Override
    public String getParentName(String parentId) throws SQLException {
        ResultSet resultSet = CrudUtil.execute("SELECT parent_name FROM parent WHERE parent_id = ?", parentId);

        if (resultSet.next()) {
            return resultSet.getString("parent_name");
        }
        return null;
    }

    @Override
    public String getParentEmail(String parentId) throws SQLException {
        ResultSet resultSet = CrudUtil.execute("SELECT e_mail FROM parent WHERE parent_id = ?", parentId);

        if(resultSet.next()){
            return resultSet.getString("e_mail");
        }
        return null;
    }

    @Override
    public boolean save(String dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<String> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<String> search() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String getID() throws SQLException, ClassNotFoundException {
        return "";
    }

    @Override
    public boolean upDate(String dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }
}