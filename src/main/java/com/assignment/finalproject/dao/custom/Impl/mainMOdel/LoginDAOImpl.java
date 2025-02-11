package com.assignment.finalproject.dao.custom.Impl.mainMOdel;

import com.assignment.finalproject.dao.custom.LoginDAO;
import com.assignment.finalproject.db.DBConnection;
import com.assignment.finalproject.dto.main.LoginDTO;
import com.assignment.finalproject.entity.main.AddExamList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoginDAOImpl implements LoginDAO {

    public int chekid(LoginDTO loginDto) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "select * from user where User_name = ? and User_password = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, loginDto.getUsername());
        preparedStatement.setString(2, loginDto.getPassword());
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            if(resultSet != null){
                return 1;
            }
        }
        return 0;
    }

    @Override
    public boolean save(LoginDTO dto) throws SQLException {
        return false;
    }

    @Override
    public ArrayList<LoginDTO> getAll() throws SQLException {
        return null;
    }

    @Override
    public ArrayList<LoginDTO> search() {
        return null;
    }

    @Override
    public String getID() throws SQLException {
        return "";
    }

    @Override
    public boolean upDate(LoginDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String parentId) throws SQLException {
        return false;
    }
}
