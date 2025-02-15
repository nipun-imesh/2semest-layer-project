package com.assignment.finalproject.dao.custom;

import com.assignment.finalproject.dao.CrudDAO;
import com.assignment.finalproject.dto.sub.SabjectDTO;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface SubjectDAO extends CrudDAO {

     ObservableList<SabjectDTO> get6TO9Subject() throws SQLException;
     ObservableList<SabjectDTO> get10TO11Subject() throws SQLException;
     String getSubjectName(String subjectID) throws SQLException;
}
