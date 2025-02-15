package com.assignment.finalproject.controller;

import com.assignment.finalproject.bo.BOFactory;
import com.assignment.finalproject.bo.custom.AddMarkBO;
import com.assignment.finalproject.bo.custom.ClassBO;
import com.assignment.finalproject.bo.custom.QueryBO;
import com.assignment.finalproject.dao.custom.Impl.mainMOdel.QueryDAOImpl;
import com.assignment.finalproject.db.DBConnection;
import com.assignment.finalproject.dto.main.StudentSubjectDetaliDTO;
import com.assignment.finalproject.dto.sub.ClassDTO;
import com.assignment.finalproject.dto.sub.ExamNameDTO;
import com.assignment.finalproject.dto.tm.GetResaltTM;
import com.assignment.finalproject.dao.custom.Impl.mainMOdel.AddMarkDAOImpl;
import com.assignment.finalproject.dao.custom.Impl.subModel.ClassDAOImpl;
import com.assignment.finalproject.entity.sub.Classes;
import com.assignment.finalproject.util.ClassLevel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class StudentResaltViewPageCointroler implements Initializable {

    @FXML
    private Button BUTBack;

    @FXML
    private Button BUTSearch;

    @FXML
    private TableColumn<GetResaltTM, Double> COLSubjectMaek;

    @FXML
    private TableColumn<GetResaltTM, String> COLSubjectName;

    @FXML
    private ComboBox<String> COMClass;

    @FXML
    private ComboBox<String> COMExam;

    @FXML
    private ComboBox<String> COMGrade;

    @FXML
    private TextField TXTStudentID;

    @FXML
    private Button BUTReport;

    @FXML
    private AnchorPane ANKViewResalt;

    @FXML
    private TableView<GetResaltTM> TBLResalt;

    ClassDAOImpl classModel = new ClassDAOImpl();
//    AddMarkDAOImpl addMarkModel = new AddMarkDAOImpl();
//    QueryDAOImpl query = new QueryDAOImpl();

    ClassBO classBO = (ClassBO) BOFactory.getInstance().getBO(BOFactory.BOType.CLASS);
    AddMarkBO addMarkBO = (AddMarkBO) BOFactory.getInstance().getBO(BOFactory.BOType.ADDMARK);
    QueryBO queryBO = (QueryBO) BOFactory.getInstance().getBO(BOFactory.BOType.QUERY);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        loadClass(COMClass);
        try {
            loadGrade();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void setCellValues() {

        COLSubjectMaek.setCellValueFactory(new PropertyValueFactory<>("mark"));
        COLSubjectName.setCellValueFactory(new PropertyValueFactory<>("subjectName"));
    }

    @FXML
    void goLoginPageOnAction(ActionEvent event) {
        ANKViewResalt.getChildren().clear();
        AnchorPane load = null;
        try {
            load = FXMLLoader.load(getClass().getResource("/view/LoginPage.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ANKViewResalt.getChildren().add(load);
    }

    @FXML
    void searchResaltOnaction(ActionEvent event) {
        String studentId = TXTStudentID.getText();
        String classId = String.valueOf(COMClass.getValue());
        String grade = String.valueOf(COMGrade.getValue());
        String examName = String.valueOf(COMExam.getValue());

        System.out.println("UI Inputs:");
        System.out.println("studentId: " + studentId);
        System.out.println("classId: " + classId);
        System.out.println("grade: " + grade);
        System.out.println("examName: " + examName);

        try {
            ArrayList<GetResaltTM> getResaltTMS = queryBO.search(new StudentSubjectDetaliDTO(studentId, classId, grade, examName));
            if (getResaltTMS.isEmpty()) {
                System.out.println("No results found.");
            }
            TBLResalt.setItems(FXCollections.observableArrayList(getResaltTMS));
            setCellValues();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @FXML
    void selectClassOnAction(ActionEvent event) {
            COMExam.setValue("");
            COMGrade.setValue("");
            TXTStudentID.clear();

    }

    @FXML
    void selectExamOnAaction(ActionEvent event) {

    }

    @FXML
    void selectGradeOnAction(ActionEvent event) {
        String classNumber = String.valueOf(COMClass.getValue());
        int grade = Integer.parseInt(classNumber);

        ArrayList<ExamNameDTO> examNameDTOS = null;
        try {
            examNameDTOS = addMarkBO.getExamList(classNumber);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        ObservableList<String> observableList = FXCollections.observableArrayList();
        for (ExamNameDTO examNameDTO : examNameDTOS) {
            observableList.add(examNameDTO.getExamName());
        }
        COMExam.setItems(observableList);
    }

    private void loadClass(ComboBox<String> comboBox) {

        comboBox.setItems(FXCollections.observableArrayList(ClassLevel.getAllLabels()));
    }

    private void loadGrade() throws SQLException {
//        ObservableList<String> observableList = FXCollections.observableArrayList();
//        ObservableList<ClassDTO> classDTOS = classModel.getAllClass();

        ArrayList<Classes> classDTOS = classModel.getAll();
        ObservableList<String> observableList = FXCollections.observableArrayList();
        for (Classes classDTO : classDTOS) {
            observableList.add(classDTO.getClassId());
        }
        COMGrade.setItems(observableList);
    }

    @FXML
    void generateReportOnAction(ActionEvent event) {

        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(
                    getClass()
                            .getResourceAsStream("/Report/StudentResaltReport.jrxml")
                            );

            Connection connection = DBConnection.getInstance().getConnection();

           Map<String, Object> parameters = new HashMap<>();
//
//            System.out.println(COMClass.getValue());
//            System.out.println(COMExam.getValue());
//            System.out.println(COMGrade.getValue());
//
//            parameters.put("ClassId",COMClass.getValue());
//            parameters.put("ExamName",COMExam.getValue());
//            parameters.put("Grade",COMGrade.getValue());
//            parameters.put("StudentID",TXTStudentID.getText());


            JasperPrint jasperPrint = JasperFillManager.fillReport(
                    jasperReport,
                    parameters,
                    connection
            );

            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException e) {
            new Alert(Alert.AlertType.ERROR, "Fail to generate report...!").show();
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "DB error...!").show();
        }
    }
}