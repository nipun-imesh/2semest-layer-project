package com.assignment.finalproject.controller;

import com.assignment.finalproject.bo.BOFactory;
import com.assignment.finalproject.bo.custom.ClassBO;
import com.assignment.finalproject.bo.custom.ManageMarkBO;
import com.assignment.finalproject.bo.custom.QueryBO;
import com.assignment.finalproject.dao.custom.Impl.mainMOdel.QueryDAOImpl;
import com.assignment.finalproject.dto.sub.ExamSubjectIdDTO;
import com.assignment.finalproject.dto.tm.ManageExamMarkTM;
import com.assignment.finalproject.dto.sub.ClassDTO;
import com.assignment.finalproject.dto.tm.GetStudentNameIdTM;
import com.assignment.finalproject.dao.custom.Impl.mainMOdel.ManageMarkDAOImpl;
import com.assignment.finalproject.dao.custom.Impl.subModel.ClassDAOImpl;
import com.assignment.finalproject.entity.main.AddExamList;
import com.assignment.finalproject.util.ClassLevel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ManageMarkControler implements Initializable {

    @FXML
    private AnchorPane ANKMarkManage;

    @FXML
    private Button BUTDelete;

    @FXML
    private Button BUTUpdate;

    @FXML
    private TableColumn<ManageExamMarkTM, String> COLSubjctID;

    @FXML
    private TableColumn<ManageExamMarkTM, String> COLDate;

    @FXML
    private TableColumn<ManageExamMarkTM, String> COLExamID;

    @FXML
    private TableColumn<ManageExamMarkTM, String> COLExamName;

    @FXML
    private TableColumn<ManageExamMarkTM, String> COLMark;

    @FXML
    private TableColumn<GetStudentNameIdTM, String> COLStudentID;

    @FXML
    private TableColumn<GetStudentNameIdTM, String> COLStudentName;

    @FXML
    private ComboBox<String> COMSelectClass;

    @FXML
    private ComboBox<String> COMSelectGarde;

    @FXML
    private Label LBOldMark;

    @FXML
    private Label LBExamID;

    @FXML
    private Label LBSubjectID;

    @FXML
    private Label LBStudentId;

    @FXML
    private Label LBStudentName;

    @FXML
    private TableView<ManageExamMarkTM> TBLSelectMark;

    @FXML
    private TableView<GetStudentNameIdTM> TBLSelectStudent;

    @FXML
    private TextField TXTNewMark;

    @FXML
    private Label LBcoretDate;

//    ClassDAOImpl classModel = new ClassDAOImpl();
//    ManageMarkDAOImpl manageMarkModel = new ManageMarkDAOImpl();
//    QueryDAOImpl query = new QueryDAOImpl();

    ClassBO classBO = (ClassBO) BOFactory.getInstance().getBO(BOFactory.BOType.CLASS);
    ManageMarkBO manageMarkBO = (ManageMarkBO) BOFactory.getInstance().getBO(BOFactory.BOType.MANAGEMARK);
    QueryBO queryBO = (QueryBO) BOFactory.getInstance().getBO(BOFactory.BOType.QUERY);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        BUTDelete.setDisable(true);
        BUTUpdate.setDisable(true);

        loadClass((ComboBox<String>) COMSelectClass);
        COMSelectGarde.setDisable(true);
        try {
            loadGrade();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private void setMArkValues() {
       COLStudentID.setCellValueFactory(new PropertyValueFactory<>("studentId"));
       COLStudentName.setCellValueFactory(new PropertyValueFactory<>("studentName"));
       COLDate.setCellValueFactory(new PropertyValueFactory<>("date"));
       COLExamID.setCellValueFactory(new PropertyValueFactory<>("examID"));
       COLExamName.setCellValueFactory(new PropertyValueFactory<>("examName"));
       COLSubjctID.setCellValueFactory(new PropertyValueFactory<>("subjectID"));
       COLMark.setCellValueFactory(new PropertyValueFactory<>("mark"));

    }
    @FXML
    void delectDataOnAction(ActionEvent event) {

        ManageExamMarkTM manageExamMarkTM = TBLSelectMark.getSelectionModel().getSelectedItem();
        if (manageExamMarkTM != null) {
            try {
                boolean isDeleted = manageMarkBO.deleteMark(new ExamSubjectIdDTO(manageExamMarkTM.getExamID(), manageExamMarkTM.getSubjectID()));
            if(isDeleted){
                new Alert(Alert.AlertType.CONFIRMATION, "Mark deleted successfully").show();
            }else {
                new Alert(Alert.AlertType.ERROR, "Mark not deleted").show();
            }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        setStudent();
        LBExamID.setText("");
        LBOldMark.setText("");
        LBSubjectID.setText("");

        TBLSelectMark.refresh();
    }

    @FXML
    void selectMarkonAction(MouseEvent event) {
        if(TBLSelectMark.getSelectionModel().getSelectedItem() != null){
            BUTUpdate.setDisable(false);
            BUTDelete.setDisable(false);
        }

        ManageExamMarkTM manageExamMarkTM = TBLSelectMark.getSelectionModel().getSelectedItem();
        if (manageExamMarkTM != null) {
            LBOldMark.setText(manageExamMarkTM.getMark());
            LBExamID.setText(manageExamMarkTM.getExamID());
            LBSubjectID.setText(manageExamMarkTM.getSubjectID());
        }
    }

    @FXML
    void selectStudentOnAction(MouseEvent event) {
        setStudent();
    }

    @FXML
    void updateMarkOnAction(ActionEvent event) {
        String getMark = (TXTNewMark.getText());

        if( getMark.isEmpty()){
            return;
        }
        double mark = Double.parseDouble(getMark);
        String studentId = LBStudentId.getText();
        String subjectId = LBSubjectID.getText();
        String examId = LBExamID.getText();


        try {
            boolean isUpdated = manageMarkBO.upDateMark(new ExamSubjectIdDTO(mark, studentId, subjectId, examId));
            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "Mark updated successfully").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Mark not updated").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        TXTNewMark.clear();
        LBExamID.setText("");
        LBOldMark.setText("");
        LBSubjectID.setText("");
        setStudent();
        TBLSelectMark.refresh();
    }

    @FXML
    void isSelectClassOnAction(ActionEvent event) {

        COMSelectGarde.setDisable(false);
        String classId = (String) COMSelectClass.getValue();
        String grade = (String) COMSelectGarde.getValue();
        ArrayList<GetStudentNameIdTM> getStudentNameIdDTOS = null;
        try {
            getStudentNameIdDTOS = manageMarkBO.getStudentDetail(new ClassDTO( grade,classId));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        TBLSelectStudent.setItems(FXCollections.observableArrayList(getStudentNameIdDTOS));
        setMArkValues();
    }

    @FXML
    void isSelectGradeOnAction(ActionEvent event) {

        String classId = (String) COMSelectClass.getValue();
        String grade = (String) COMSelectGarde.getValue();
        if (grade.isEmpty() && classId.isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Please enter all fields").show();
        } else {

            ArrayList<GetStudentNameIdTM> getStudentNameIdDTOS = null;
            try {
                getStudentNameIdDTOS = manageMarkBO.getStudentDetail(new ClassDTO( grade,classId));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            TBLSelectStudent.setItems(FXCollections.observableArrayList(getStudentNameIdDTOS));
            setMArkValues();
        }
    }

    private void loadClass(ComboBox<String> comboBox) {

        comboBox.setItems(FXCollections.observableArrayList(ClassLevel.getAllLabels()));
    }

    private void loadGrade() throws SQLException, ClassNotFoundException {
        ObservableList<String> observableList = FXCollections.observableArrayList();
        ArrayList<ClassDTO> classDTOS =  classBO.getAll();

        for (ClassDTO classDTO : classDTOS) {
            observableList.add(classDTO.getClassId());
        }
        COMSelectGarde.setItems(observableList);
    }

    private void setStudent() {
        GetStudentNameIdTM getStudentNameIdTM = TBLSelectStudent.getSelectionModel().getSelectedItem();

        if (getStudentNameIdTM != null) {
            LBStudentId.setText(getStudentNameIdTM.getStudentId());
            LBStudentName.setText(getStudentNameIdTM.getStudentName());
        }
        String studentId = LBStudentId.getText();

        ArrayList<ManageExamMarkTM> manageExamMarkTMS = null;
        try {
            manageExamMarkTMS = queryBO.getStudentMarkDetail(studentId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        TBLSelectMark.setItems(FXCollections.observableArrayList(manageExamMarkTMS));
    }
}
