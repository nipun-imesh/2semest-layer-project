package com.assignment.finalproject.dao.custom;

import com.assignment.finalproject.dao.CrudDAO;
import com.assignment.finalproject.dto.main.AddExamListDTO;
import com.assignment.finalproject.dto.tm.ManageExamTM;
import com.assignment.finalproject.entity.main.AddExamList;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ManageExamDAO extends CrudDAO<AddExamList> {
    public boolean delete(AddExamListDTO addExamListDTO)  throws SQLException;
}
