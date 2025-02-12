package com.assignment.finalproject.bo.custom;

import com.assignment.finalproject.bo.SuperBO;
import com.assignment.finalproject.dto.main.AddParentDTO;
import com.assignment.finalproject.entity.main.AddParent;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AddParentBO extends SuperBO {
     boolean saveParent(AddParentDTO addParentDTO) throws SQLException, ClassNotFoundException;
     ArrayList<AddParent> getAllParent() throws SQLException, ClassNotFoundException;
     ArrayList<AddParentDTO> searchPerent();
     String getPerentID() throws SQLException, ClassNotFoundException;
     boolean upDatePerent(AddParentDTO addParentDTO) throws SQLException, ClassNotFoundException;
     boolean deletePerent(String parentId) throws SQLException, ClassNotFoundException;
}
