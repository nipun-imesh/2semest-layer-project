package com.assignment.finalproject.bo.custom.impl.MainBOImpl;

import com.assignment.finalproject.bo.custom.QueryBO;
import com.assignment.finalproject.dao.CrudUtil;
import com.assignment.finalproject.dao.DAOFactory;
import com.assignment.finalproject.dao.custom.Impl.mainMOdel.QueryDAOImpl;
import com.assignment.finalproject.dto.main.StudentSubjectDetaliDTO;
import com.assignment.finalproject.dto.tm.GetResaltTM;
import com.assignment.finalproject.dto.tm.ManageExamMarkTM;
import com.assignment.finalproject.dto.tm.ManageExamTM;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QueryBOImpl implements QueryBO {

    QueryDAOImpl queryDAO = (QueryDAOImpl) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.QUERY);

    @Override
    public ArrayList<ManageExamTM> getSelectExam(String grade) throws SQLException {
        return queryDAO.getSelectExam(grade);
    }

    @Override
    public ArrayList<ManageExamMarkTM> getStudentMarkDetail(String studentId) throws SQLException {
        return queryDAO.getStudentMarkDetail(studentId);
    }

    @Override
    public ArrayList<GetResaltTM> search(StudentSubjectDetaliDTO studentSubjectDetaliDTO) throws SQLException {
        return queryDAO.search(studentSubjectDetaliDTO);
    }
}
