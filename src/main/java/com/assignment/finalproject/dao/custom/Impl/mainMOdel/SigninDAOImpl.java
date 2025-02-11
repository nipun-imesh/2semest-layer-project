package com.assignment.finalproject.dao.custom.Impl.mainMOdel;

import com.assignment.finalproject.dao.CrudUtil;
import com.assignment.finalproject.dao.custom.SignInDAO;
import com.assignment.finalproject.dto.main.SigninDTO;
import com.assignment.finalproject.entity.main.AddExamList;
import com.assignment.finalproject.entity.main.Signin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SigninDAOImpl implements SignInDAO {

    @Override
    public String getID() throws SQLException {
        ResultSet rst = CrudUtil.execute("select User_id from user order by User_id desc limit 1");

        if (rst.next()) {
            String lastId = rst.getString(1); // Last customer ID
            String substring = lastId.substring(1); // Extract the numeric part
            int i = Integer.parseInt(substring); // Convert the numeric part to integer
            int newIdIndex = i + 1; // Increment the number by 1
            return String.format("A%03d", newIdIndex); // Return the new customer ID in format Cnnn
        }
        return "A001"; // Return the default customer ID if no data is found
    }

    @Override
    public boolean upDate(Signin dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean save(Signin signinDto) throws SQLException {

            return CrudUtil.execute("insert into user(User_id,User_name,User_password) values(?,?,?)",
                    signinDto.getUserid(),
                    signinDto.getUsername(),
                    signinDto.getPassword());

    }

    @Override
    public ArrayList<Signin> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Signin> search() throws SQLException, ClassNotFoundException {
        return null;
    }
}
