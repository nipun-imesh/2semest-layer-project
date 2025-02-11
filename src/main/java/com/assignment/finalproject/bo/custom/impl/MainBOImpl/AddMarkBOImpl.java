package com.assignment.finalproject.bo.custom.impl.MainBOImpl;

import com.assignment.finalproject.bo.custom.AddMarkBO;
import com.assignment.finalproject.dao.CrudUtil;
import com.assignment.finalproject.dao.DAOFactory;
import com.assignment.finalproject.dao.custom.Impl.mainMOdel.AddExamListDAOImpl;
import com.assignment.finalproject.dao.custom.Impl.mainMOdel.AddMarkDAOImpl;
import com.assignment.finalproject.dto.main.AddMarkDTO;
import com.assignment.finalproject.dto.sub.ExamNameDTO;
import com.assignment.finalproject.dto.sub.ExamSubjectIdDTO;
import com.assignment.finalproject.dto.sub.PlaysStudentAllMarkDTO;
import com.assignment.finalproject.dto.tm.GetStudentNameIdTM;
import com.assignment.finalproject.entity.main.AddMark;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AddMarkBOImpl implements AddMarkBO {

    AddMarkDAOImpl addMarkDAO = (AddMarkDAOImpl) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ADDMARK);

    public ArrayList<GetStudentNameIdTM> getStudentNameId(AddMarkDTO markDTO) throws SQLException {
       return addMarkDAO.getStudentNameId(markDTO);
    }

    public ArrayList<ExamNameDTO> getExamList(String classNumber) throws SQLException {
        return addMarkDAO.getExamList(classNumber);
    }

    public String fineExamId(String examName) throws SQLException {
       return addMarkDAO.fineExamId(examName);
    }

    public boolean palesAllMark(ArrayList<PlaysStudentAllMarkDTO> playsStudentAllMarkDTOS) throws SQLException {
        return addMarkDAO.palesAllMark(playsStudentAllMarkDTOS);
    }

    public boolean checkStudentExamSubject(ExamSubjectIdDTO examSubjectIdDTO) throws SQLException {
        return addMarkDAO.checkStudentExamSubject(examSubjectIdDTO);
    }

    @Override
    public boolean save(AddMarkDTO dto) throws SQLException {
        return false;
    }

    @Override
    public ArrayList<AddMarkDTO> getAll() throws SQLException {
        ArrayList<AddMark> addMarks = addMarkDAO.getAll();
        ArrayList<AddMarkDTO> addMarkDTOS = new ArrayList<>();
        for (AddMark addMark : addMarks) {
            addMarkDTOS.add(new AddMarkDTO(addMark.getGrade()));
        }
        return addMarkDTOS;
    }

    @Override
    public ArrayList<AddMarkDTO> search() {
        return null;
    }

    @Override
    public String getID() throws SQLException {
        return "";
    }

    @Override
    public boolean upDate(AddMarkDTO dto) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String parentId) throws SQLException {
        return false;
    }
}
