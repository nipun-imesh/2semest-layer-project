package com.assignment.finalproject.controller;

import com.assignment.finalproject.bo.BOFactory;
import com.assignment.finalproject.bo.custom.AddMarkBO;
import com.assignment.finalproject.bo.custom.ClassBO;
import com.assignment.finalproject.bo.custom.SubjectBO;
import com.assignment.finalproject.dto.main.AddMarkDTO;
import com.assignment.finalproject.dto.sub.*;
import com.assignment.finalproject.dto.tm.AddMarkCartTM;
import com.assignment.finalproject.dto.tm.GetStudentNameIdTM;
import com.assignment.finalproject.dao.custom.Impl.mainMOdel.AddMarkDAOImpl;
import com.assignment.finalproject.dao.custom.Impl.subModel.ClassDAOImpl;
import com.assignment.finalproject.dao.custom.Impl.subModel.SubjectDAOImpl;
import com.assignment.finalproject.entity.sub.Classes;
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

public class AddMarkPageControler implements Initializable {

    @FXML
    private AnchorPane ANKMaksManege;

    @FXML
    private Button BUTAddMark;

    @FXML
    private Button BUTSearch;

    @FXML
    private Button BUTpalesallMark;

    @FXML
    private ComboBox<String> COBExamNAme;

    @FXML
    private TableColumn<AddMarkCartTM, Button> COLDelete;

    @FXML
    private TableColumn<AddMarkCartTM, String> COLExamID;

    @FXML
    private TableColumn<AddMarkCartTM, String> COLGrade;

    @FXML
    private TableColumn<AddMarkCartTM, Double> COLMark;

    @FXML
    private TableColumn<AddMarkCartTM, String> COLMarkID;

    @FXML
    private TableColumn<AddMarkCartTM, String> COLStudenID;

    @FXML
    private TableColumn<AddMarkCartTM, String> COLStudent;

    @FXML
    private TableColumn<AddMarkCartTM, String> COLSubjectID;

    @FXML
    private TableColumn<GetStudentNameIdTM, String> COLsetStudeName;

    @FXML
    private TableColumn<GetStudentNameIdTM, String> COLsetStudentID;

    @FXML
    private ComboBox<String> COMGrade;

    @FXML
    private ComboBox<String> COMSetClass;

    @FXML
    private Label LBExamId;

    @FXML
    private Label LBMarkId;

    @FXML
    private Label LBStudentId;

    @FXML
    private Label LBStudentName;

    @FXML
    private ComboBox<String> COMSubjectID;

    @FXML
    private Label LBSubjectName;

    @FXML
    private TableView<GetStudentNameIdTM> TBLStudent;

    @FXML
    private TableView<AddMarkCartTM> TBLMarkTable;

    @FXML
    private TextField TXTMark;

  //    ClassDAOImpl classModel = new ClassDAOImpl();
//    AddMarkDAOImpl addMarkModel = new AddMarkDAOImpl();
//    SubjectDAOImpl subjectModel = new SubjectDAOImpl();

    ClassBO classBO = (ClassBO) BOFactory.getInstance().getBO(BOFactory.BOType.CLASS);
    AddMarkBO addMarkBO = (AddMarkBO) BOFactory.getInstance().getBO(BOFactory.BOType.ADDMARK);
    SubjectBO subjectBO = (SubjectBO) BOFactory.getInstance().getBO(BOFactory.BOType.SUBJECT);

    private final ObservableList<AddMarkCartTM> addMarkCartTMS = FXCollections.observableArrayList();
    private final ObservableList<GetStudentNameIdTM> getStudentNameIdTMS = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            loadGrade();
            loadClass((ComboBox<String>) COMSetClass);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        BUTAddMark.setDisable(true);
    }

    @FXML
    void palesAllMarkAction(ActionEvent event) {

        if(addMarkCartTMS.isEmpty()) {
            return;
        }

        ArrayList<PlaysStudentAllMarkDTO> playsStudentAllMarkDTOS = new ArrayList<>();

        for(AddMarkCartTM addMarkCartTM : addMarkCartTMS){
            PlaysStudentAllMarkDTO playsStudentAllMarkDTO = new PlaysStudentAllMarkDTO(
                    addMarkCartTM.getStudentID(),
                    addMarkCartTM.getSubject(),
                    addMarkCartTM.getExamID(),
                    String.valueOf(addMarkCartTM.getMark())
            );
            playsStudentAllMarkDTOS.add(playsStudentAllMarkDTO);
        }

        try {
          boolean  isSaved = addMarkBO.palesAllMark(playsStudentAllMarkDTOS);

            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "Saved...").show();
            }else {
                new Alert(Alert.AlertType.ERROR, "Failed...").show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        TBLMarkTable.getItems().clear();
    }

    @FXML
    void searchOnAction(ActionEvent event) throws SQLException {
        if( COMSetClass.getValue() == null ||  COMGrade.getValue() == null) {
           return;
        }else{
            BUTAddMark.setDisable(false);
        }

        String classId = (String) COMSetClass.getValue();
        String grade = String.valueOf(COMGrade.getValue());

        if (grade.isEmpty() || classId.isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Please enter all fields").show();
        } else {

            ArrayList<GetStudentNameIdTM> getStudentNameIdDTOS = addMarkBO.getStudentNameId(new AddMarkDTO(classId, grade));

            TBLStudent.setItems(FXCollections.observableArrayList(getStudentNameIdDTOS));
            setCellValues();
        }
    }

    private void setMArkValues() {
        COLStudenID.setCellValueFactory(new PropertyValueFactory<>("studentID"));
        COLStudent.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        COLGrade.setCellValueFactory(new PropertyValueFactory<>("S_class"));
        COLExamID.setCellValueFactory(new PropertyValueFactory<>("examID"));
        COLSubjectID.setCellValueFactory(new PropertyValueFactory<>("subject"));
        COLMarkID.setCellValueFactory(new PropertyValueFactory<>("markId"));
        COLMark.setCellValueFactory(new PropertyValueFactory<>("mark"));
        COLDelete.setCellValueFactory(new PropertyValueFactory<>("Delete"));
    }

    private void setCellValues() {
        COLsetStudentID.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        COLsetStudeName.setCellValueFactory(new PropertyValueFactory<>("studentName"));
    }

    @FXML
    void selectClassOnAction(ActionEvent event) throws SQLException {

        //reSet();
        TBLStudent.getItems().clear();
        COBExamNAme.getItems().clear();

        String classNumber = String.valueOf(COMSetClass.getValue());
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
        COBExamNAme.setItems(observableList);
        TBLMarkTable.getItems().clear();
        loadSubject();
    }

    @FXML
    void selectGradeOnaction(ActionEvent event) {
        TBLMarkTable.getItems().clear();
    }

    @FXML
    void selectSubjectOnAction(ActionEvent event) {
        String subject = COMSubjectID.getValue();
        try {
            LBSubjectName.setText(subjectBO.getSubjectName(subject));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void selectExamNameOnAction(ActionEvent event) {
        String examName = String.valueOf(COBExamNAme.getValue());

        try {
            String examID = addMarkBO.fineExamId(examName);
            LBExamId.setText(examID);
        } catch (SQLException e) {
           new Alert(Alert.AlertType.ERROR, "Exam not found").show();
        }
        TBLMarkTable.getItems().clear();
    }

    @FXML
    void setMArkOnTableAction(ActionEvent event) throws SQLException {
        String studentID = LBStudentId.getText();
        String studentName = LBStudentName.getText();
        String S_class = (String) COMSetClass.getValue();
        String examID = LBExamId.getText();
        String subject = COMSubjectID.getValue();
        String markIDs = ("");
        String mark = TXTMark.getText();
        String subjectID = COMSubjectID.getValue();

        String marksPattern = "^([1-9][0-9]?|100|0)$";

        if (studentID.isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Select Student ID").show();
            return;
        }
        if (examID.isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Select Exam Name").show();
            return;
        }
        if (subject == null || subject.isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Select Subject ID").show();
            return;
        }
        if (mark.isEmpty() || !mark.matches(marksPattern)) {
            new Alert(Alert.AlertType.ERROR, "Invalid Mark. Enter a value between 0 and 100.").show();
            TXTMark.setStyle("-fx-border-color: #ff4800;");
            return;
        } else {
            TXTMark.setStyle("");
        }

        boolean subjectExist = addMarkBO.checkStudentExamSubject(new ExamSubjectIdDTO(studentID, examID, subjectID));
        if (subjectExist) {
            new Alert(Alert.AlertType.ERROR, "Subject already exists for this student").show();
            return;
        }

        try {
            double markValue = Double.parseDouble(mark);

            Button btn = new Button("Remove");
            btn.setOnAction(actionEvent -> {
                addMarkCartTMS.removeIf(tm -> tm.getSubject().equals(subjectID));
                TBLMarkTable.refresh();
            });

            AddMarkCartTM addMarkCartTM = new AddMarkCartTM(
                    studentID,
                    studentName,
                    S_class,
                    examID,
                    subject,
                    markIDs,
                    markValue,
                    btn
            );

            addMarkCartTMS.add(addMarkCartTM);
            setMArkValues();
            TBLMarkTable.setItems(addMarkCartTMS);

        } catch (NumberFormatException e) {
            new Alert(Alert.AlertType.ERROR, "Please enter a valid numeric mark").show();
        }
        TXTMark.setStyle("-fx-border-color: #000000;");
        TXTMark.clear();
    }

    @FXML
    void setStudentTBL(MouseEvent event) {
        GetStudentNameIdTM getStudentNameIdTM = TBLStudent.getSelectionModel().getSelectedItem();

        if (getStudentNameIdTM != null) {
            LBStudentId.setText(getStudentNameIdTM.getStudentId());
            LBStudentName.setText(getStudentNameIdTM.getStudentName());
        }
        TBLMarkTable.getItems().clear();
    }

    private void loadGrade() throws SQLException, ClassNotFoundException {
        ObservableList<String> observableList = FXCollections.observableArrayList();
        ArrayList<ClassDTO> classDTOS =  classBO.getAll();

        for (ClassDTO classDTO : classDTOS) {
            observableList.add(classDTO.getClassId());
        }
        COMGrade.setItems(observableList);
    }

    private void loadClass(ComboBox<String> comboBox) throws SQLException {

        comboBox.setItems(FXCollections.observableArrayList(ClassLevel.getAllLabels()));
    }

    private void loadSubject() throws SQLException {

        String classNumber = String.valueOf(COMSetClass.getValue());

        if (classNumber.equals("6") || classNumber.equals("7") || classNumber.equals("8") || classNumber.equals("9")) {
            ObservableList<String> observableList = FXCollections.observableArrayList();
            ObservableList<SabjectDTO> sabjectDTOS = subjectBO.get6TO9Subject();
            for (SabjectDTO sabjectDTO : sabjectDTOS) {
                observableList.add(sabjectDTO.getSubjectId());
            }
            COMSubjectID.setItems(observableList);

        } else if (classNumber.equals("10") || classNumber.equals("11")) {
            ObservableList<String> observableList = FXCollections.observableArrayList();
            ObservableList<SabjectDTO> sabjectDTOS = subjectBO.get10TO11Subject();
            for (SabjectDTO sabjectDTO : sabjectDTOS) {
                observableList.add(sabjectDTO.getSubjectId());
            }
            COMSubjectID.setItems(observableList);
        }
    }

    private void reSet(){
        LBStudentId.setText("");
        LBStudentName.setText("");
        LBMarkId.setText("");
        LBExamId.setText("");
        LBSubjectName.setText("");
        TXTMark.setText("");
    }
}


