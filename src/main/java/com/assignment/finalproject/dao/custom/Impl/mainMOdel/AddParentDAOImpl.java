package com.assignment.finalproject.dao.custom.Impl.mainMOdel;

import com.assignment.finalproject.dao.CrudUtil;
import com.assignment.finalproject.dao.custom.AddParentDAO;
import com.assignment.finalproject.entity.main.AddExamList;
import com.assignment.finalproject.entity.main.AddParent;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

public class AddParentDAOImpl implements AddParentDAO{

    @Override
    public boolean save(AddParent addParentDTO) throws SQLException {
        return CrudUtil.execute(
                "insert into parent values (?,?,?,?)",
                addParentDTO.getParentId(),
                addParentDTO.getParentName(),
                addParentDTO.getParentEmail(),
                addParentDTO.getStatus()
        );
    }

    @Override
    public ArrayList<AddParent> getAll() throws SQLException {
        ResultSet rst = CrudUtil.execute("select * from parent where status = 'Active'");

        ArrayList<AddParent> addParentDTOS = new ArrayList<>();

        while (rst.next()) {
            AddParent addParent = new AddParent(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4)

            );
            addParentDTOS.add(addParent);
        }
        return addParentDTOS;
    }

    @Override
    public ArrayList<AddParent> search()  {

        return null;
    }

    @Override
    public String getID() throws SQLException {
      //  ResultSet rst = CrudUtil.execute("select parent_id from parent order by parent_id desc limit 1");

        String uniqueID = UUID.randomUUID().toString().substring(0, 7);
        return "P" + uniqueID;
    }


    @Override
    public boolean upDate(AddParent addParentDTO) throws SQLException {

        return CrudUtil.execute(
                "update parent set parent_name=?,e_mail=?,status=? where parent_id=?",
                addParentDTO.getParentName(),
                addParentDTO.getParentEmail(),
                addParentDTO.getStatus(),
                addParentDTO.getParentId()
        );
    }

    @Override
    public boolean delete(String parentId) throws SQLException {

        return CrudUtil.execute( "update parent set status = 'Deactive' where parent_id = ?",parentId);
    }
}
