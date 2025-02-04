package com.assignment.finalproject.bo.custom;

import com.assignment.finalproject.bo.SuperBO;
import com.assignment.finalproject.dto.sub.GetParentIdDTO;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SendMailBO extends SuperBO {
     ObservableList<GetParentIdDTO> getAllParentID() throws SQLException ;
     String getParentName(String parentId) throws SQLException ;
     String getParentEmail(String parentId) throws SQLException;
     boolean save(String dto) throws SQLException, ClassNotFoundException;
     ArrayList<String> getAll() throws SQLException, ClassNotFoundException;
     ArrayList<String> search() throws SQLException, ClassNotFoundException ;
     String getID() throws SQLException, ClassNotFoundException;
     boolean upDate(String dto) throws SQLException, ClassNotFoundException;
     boolean delete(String id) throws SQLException, ClassNotFoundException;
}
