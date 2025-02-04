package com.assignment.finalproject.bo.custom;

import com.assignment.finalproject.bo.SuperBO;
import com.assignment.finalproject.dto.sub.HallDTO;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.ArrayList;

public interface HallBO extends SuperBO {
     ObservableList<HallDTO> getAllHall() throws SQLException ;
     boolean save(HallDTO dto) throws SQLException;
     ArrayList<HallDTO> getAll() throws SQLException;
     ArrayList<HallDTO> search();
     String getID() throws SQLException;
     boolean upDate(HallDTO dto) throws SQLException;
     boolean delete(String id) throws SQLException;
}
