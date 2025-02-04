package com.assignment.finalproject.bo.custom;

import com.assignment.finalproject.bo.SuperBO;
import com.assignment.finalproject.dto.main.AddParentDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AddParentBO extends SuperBO {
     boolean saveParent(AddParentDTO addParentDTO) throws SQLException;
     ArrayList<AddParentDTO> getAllParent() throws SQLException;
     ArrayList<AddParentDTO> searchPerent();
     String getPerentID() throws SQLException;
     boolean upDatePerent(AddParentDTO addParentDTO) throws SQLException;
     boolean deletePerent(String parentId) throws SQLException;
}
