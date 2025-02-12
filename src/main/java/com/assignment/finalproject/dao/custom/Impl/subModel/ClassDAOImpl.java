package com.assignment.finalproject.dao.custom.Impl.subModel;

import com.assignment.finalproject.dao.CrudUtil;
import com.assignment.finalproject.dao.custom.ClassDAO;
import com.assignment.finalproject.dto.sub.ClassDTO;
import com.assignment.finalproject.entity.sub.Classes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClassDAOImpl implements ClassDAO {

    @Override
    public boolean save(Classes dto) throws SQLException {
        return false;
    }

    public ArrayList<Classes> getAll() throws SQLException {
        ResultSet rst = CrudUtil.execute("select class_id from class");

        ArrayList<Classes> classDTOS = new ArrayList<>();
        while (rst.next()) {
            Classes classDTO = new Classes(
                    rst.getString(1)  // Customer ID
            );
            classDTOS.add(classDTO);
        }
        return classDTOS;

    }

    @Override
    public ArrayList<Classes> search() {
        return null;
    }

    @Override
    public String getID() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean upDate(Classes dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return false;
    }


    public ClassDTO findByclass(String selectedClassId) {
        return null;
    }

}
