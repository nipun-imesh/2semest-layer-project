package com.assignment.finalproject.bo.custom.impl.MainBOImpl;

import com.assignment.finalproject.bo.custom.StudendManageBO;
import com.assignment.finalproject.dao.DAOFactory;
import com.assignment.finalproject.dao.custom.Impl.mainMOdel.StudentManageDAOImpl;
import com.assignment.finalproject.dto.main.StudentManageDTO;
import com.assignment.finalproject.entity.main.StudentManage;

import java.sql.SQLException;
import java.util.ArrayList;

public class StudentMnagrBOImpl implements StudendManageBO {

    StudentManageDAOImpl studentManageDAO = (StudentManageDAOImpl) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.STUDENTMANAGE);
    StudentManage studentManage = new StudentManage();

    public  boolean save(StudentManageDTO studto) {
        return studentManageDAO.save(new StudentManage( studto.getStudentId(),
                                                        studto.getStudentName(),
                                                        studto.getAge(),
                                                        studto.getDateofBarth()
                                                        ,studto.getGrade(),
                                                        studto.getS_class(),
                                                        studto.getParentId(),
                                                        studto.getStatus()));
                                                 }

    @Override
    public ArrayList<StudentManage> geStudentAll() throws SQLException {
        return  studentManageDAO.getAll();
    }

    @Override
    public ArrayList<StudentManageDTO> search() {
        return null;
    }

    @Override
    public String getID() throws SQLException {
        return studentManageDAO.getID();
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return studentManageDAO.delete(id);
    }

    @Override
    public boolean upDate(StudentManageDTO studentManageDTO) {
        return studentManageDAO.upDate(new StudentManage(studentManageDTO.getStudentName(),
                studentManageDTO.getAge(),
                studentManageDTO.getDateofBarth(),
                studentManageDTO.getGrade(),
                studentManageDTO.getS_class(),
                studentManageDTO.getParentId(),
                studentManageDTO.getStudentId()));
    }
}
