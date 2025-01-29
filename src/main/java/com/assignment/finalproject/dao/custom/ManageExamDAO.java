package com.assignment.finalproject.dao.custom;

import com.assignment.finalproject.dao.CrudDAO;
import com.assignment.finalproject.dto.main.AddExamListDTO;
import com.assignment.finalproject.dto.tm.ManageExamTM;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ManageExamDAO extends CrudDAO<AddExamListDTO> {
    public boolean delete(AddExamListDTO addExamListDTO)  throws SQLException;
}
