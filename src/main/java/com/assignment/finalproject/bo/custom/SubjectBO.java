package com.assignment.finalproject.bo.custom;

import com.assignment.finalproject.bo.SuperBO;
import com.assignment.finalproject.dto.sub.SabjectDTO;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SubjectBO extends SuperBO {
    public ObservableList<SabjectDTO> get6TO9Subject() throws SQLException;
    public ObservableList<SabjectDTO> get10TO11Subject() throws SQLException;
    public String getSubjectName(String subjectID) throws SQLException;
    public boolean save(Object dto) throws SQLException, ClassNotFoundException;
    public ArrayList getAll() throws SQLException, ClassNotFoundException;
    public ArrayList search() throws SQLException, ClassNotFoundException;
    public String getID() throws SQLException, ClassNotFoundException;
    public boolean upDate(Object dto) throws SQLException, ClassNotFoundException;
    public boolean delete(String id) throws SQLException, ClassNotFoundException;
}
