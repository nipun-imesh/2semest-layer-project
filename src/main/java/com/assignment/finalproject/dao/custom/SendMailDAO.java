package com.assignment.finalproject.dao.custom;

import com.assignment.finalproject.dao.CrudDAO;
import com.assignment.finalproject.dto.sub.GetParentIdDTO;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface SendMailDAO extends CrudDAO<String> {

     String getParentEmail(String parentId) throws SQLException;
     String getParentName(String parentId) throws SQLException;
     ObservableList<GetParentIdDTO> getAllParentID() throws SQLException;
}
