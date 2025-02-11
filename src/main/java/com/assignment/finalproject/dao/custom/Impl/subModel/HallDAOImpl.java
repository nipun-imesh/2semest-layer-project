package com.assignment.finalproject.dao.custom.Impl.subModel;

import com.assignment.finalproject.dao.CrudUtil;
import com.assignment.finalproject.dao.custom.HallDAO;
import com.assignment.finalproject.dto.sub.HallDTO;
import com.assignment.finalproject.entity.main.AddExamList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HallDAOImpl implements HallDAO {

    public ObservableList<HallDTO> getAllHall() throws SQLException {
        ResultSet rst = CrudUtil.execute("select * from hall");

        ObservableList<HallDTO> hallDTOS = FXCollections.observableArrayList();
        while (rst.next()) {
            HallDTO hallDTO = new HallDTO(
                    rst.getString(1),
                    rst.getString(2)
            );
            hallDTOS.add(hallDTO);
        }
        return hallDTOS;
    }

    @Override
    public boolean save(HallDTO dto) throws SQLException {
        return false;
    }

    @Override
    public ArrayList<HallDTO> getAll() throws SQLException {
        return null;
    }

    @Override
    public ArrayList<HallDTO> search() {
        return null;
    }

    @Override
    public String getID() throws SQLException {
        return "";
    }

    @Override
    public boolean upDate(HallDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return false;
    }
}