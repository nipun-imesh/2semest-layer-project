package com.assignment.finalproject.controller;

import com.assignment.finalproject.bo.BOFactory;
import com.assignment.finalproject.bo.custom.AddExamListBO;
import com.assignment.finalproject.bo.custom.HallBO;
import com.assignment.finalproject.bo.custom.SubjectBO;
import com.assignment.finalproject.dto.sub.*;
import com.assignment.finalproject.dto.tm.ExamCartTM;
import com.assignment.finalproject.dao.custom.Impl.mainMOdel.AddExamListDAOImpl;
import com.assignment.finalproject.dao.custom.Impl.subModel.HallDAOImpl;
import com.assignment.finalproject.dao.custom.Impl.subModel.SubjectDAOImpl;
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
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AddExamListPageControler implements Initializable {


    @FXML
    private AnchorPane ANKAddExampan;

    @FXML
    private Button BUTDelete;

    @FXML
    private Button BUTReset;

    @FXML
    private Button BUTSave;

    @FXML
    private Button BUTUpdate;

    @FXML
    private Button BUTAddAll;

    @FXML
    private ComboBox<String> COBSelectHall;

    @FXML
    private ComboBox<String> COBGrade;

    @FXML
    private ComboBox<String> COMSubjectID;

    @FXML
    private TableColumn<ExamCartTM, String> COLExamID;

    @FXML
    private TableColumn<ExamCartTM, String> COLExamName;

    @FXML
    private TableColumn<ExamCartTM, String> COLGrade;

    @FXML
    private TableColumn<ExamCartTM, String> COLHallName;

    @FXML
    private TableColumn<ExamCartTM, Button> COLDelete;

    @FXML
    private TableColumn<ExamCartTM, Time> COLTime;

    @FXML
    private TableColumn<ExamCartTM, Date> COLDate;

    @FXML
    private TableColumn<ExamCartTM, String> COlEcamShedulID;

    @FXML
    private TableColumn<ExamCartTM, String> COLSubjectID;

    @FXML
    private TableView<ExamCartTM> TBLplasMark;

    @FXML
    private DatePicker DTPDate;

    @FXML
    private Label LBExamID;

    @FXML
    private Label LBExamShedulID;

    @FXML
    private TextField TXTExamName;

    @FXML
    private TextField TXTTime;

    @FXML
    private Label LBTableLabel;

    @FXML
    private Label LBSbjectName;

//    AddExamListDAOImpl addExamListModel = new AddExamListDAOImpl();
//    HallDAOImpl hallModel = new HallDAOImpl();
//    SubjectDAOImpl subjectModel = new SubjectDAOImpl();

    private final ObservableList<ExamCartTM> examCartTMS = FXCollections.observableArrayList();

    AddExamListBO addExamListBO = (AddExamListBO) BOFactory.getInstance().getBO(BOFactory.BOType.ADDEXAMLIST);
    HallBO hallBO = (HallBO) BOFactory.getInstance().getBO(BOFactory.BOType.HALL);
    SubjectBO subjectBO = (SubjectBO) BOFactory.getInstance().getBO(BOFactory.BOType.SUBJECT);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        COBGrade.setPromptText("Grade");
        COBSelectHall.setPromptText("Hall Name");
        COMSubjectID.setPromptText("Subject ID");

        setCellValues();

        try {
            getExamID();
            getExamShedulID();
            loadExamHall();
            loadGrade((ComboBox<String>) COBGrade);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        COMSubjectID.setValue("");
        COBSelectHall.setValue("");
        COBGrade.setValue("");
    }

    private void setCellValues() {

        COlEcamShedulID.setCellValueFactory(new PropertyValueFactory<>("ExamShedulID"));
        COLExamID.setCellValueFactory(new PropertyValueFactory<>("ExamID"));
        COLHallName.setCellValueFactory(new PropertyValueFactory<>("HallName"));
        COLExamName.setCellValueFactory(new PropertyValueFactory<>("ExamName"));
        COLGrade.setCellValueFactory(new PropertyValueFactory<>("Grade"));
        COLDate.setCellValueFactory(new PropertyValueFactory<>("examDate"));
        COLTime.setCellValueFactory(new PropertyValueFactory<>("examTime"));
        COLSubjectID.setCellValueFactory(new PropertyValueFactory<>("SubjectID"));
        COLDelete.setCellValueFactory(new PropertyValueFactory<>("Delete"));

        TBLplasMark.setItems(examCartTMS);
    }

    @FXML
    void resetOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {

        resetAddset();
        getExamShedulID();
        getExamID();
    }

    @FXML
    void AddOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {

        String examshedulID = LBExamShedulID.getText();
        String examID = LBExamID.getText();
        String examName = TXTExamName.getText();
        String grade = COBGrade.getValue() != null ? String.valueOf(COBGrade.getValue()) : "";
        String date = DTPDate.getValue() != null ? DTPDate.getValue().toString() : "";
        String time = TXTTime.getText();
        String hallName = COBSelectHall.getValue() != null ? String.valueOf(COBSelectHall.getValue()) : "";
        String subjectID = COMSubjectID.getValue() != null ? String.valueOf(COMSubjectID.getValue()) : "";
        String SubjectName = LBSbjectName.getText();

        // Input validation
        if (examName.isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Please Enter Exam Name").show();
            return;
        }
        if (grade.isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Please Select Grade").show();
            return;
        }
        if (date.isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Please Select Date").show();
            return;
        }
        if (time.isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Please Enter Time").show();
            return;
        }
        if (hallName.isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Please Select Hall Name").show();
            return;
        }
        if (subjectID.isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Please Select Subject ID").show();
            return;
        }

        // Create a "Remove" button for the table
        Button btn = new Button("Remove");

        ExamCartTM examCartTM = new ExamCartTM(
                examshedulID,
                examID,
                examName,
                grade,
                date,
                time,
                hallName,
                subjectID,
                SubjectName,
                btn
        );

        // Set action for the "Remove" button
        btn.setOnAction(actionEvent -> {
            examCartTMS.remove(examCartTM);
            TBLplasMark.refresh();
        });

        // Reset fields after adding the exam
        resetAddset();

        examCartTMS.add(examCartTM);
        getExamShedulID();
        getExamID();
    }

    @FXML
    void tableClickOnAtion(MouseEvent event) {
        ExamCartTM markCatTM = TBLplasMark.getSelectionModel().getSelectedItem();
        if (markCatTM != null) {
            LBExamShedulID.setText(markCatTM.getExamShedulID());
            LBExamID.setText(markCatTM.getExamID());
            COBSelectHall.setValue(String.valueOf(markCatTM.getHallName()));
            TXTExamName.setText(markCatTM.getExamName());
            COBGrade.setValue(markCatTM.getGrade());
            DTPDate.setValue(LocalDate.parse(markCatTM.getExamDate()));
            TXTTime.setText(markCatTM.getExamTime());
            COMSubjectID.setValue(markCatTM.getSubjectID());
        }
    }

    @FXML
    void addAllOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {

        ArrayList<ExamDTO> examDTOS = new ArrayList<>();
        ArrayList<ExamScheduleDTO> examScheduleDTOS = new ArrayList<>();
        ArrayList<ExamSubjectIdDTO> examSubjectIdDTOS = new ArrayList<>();

        for (ExamCartTM markCatTM : examCartTMS) {
            ExamDTO examDTO = new ExamDTO(
                    markCatTM.getExamID(),
                    markCatTM.getExamName(),
                    markCatTM.getGrade()
            );
            examDTOS.add(examDTO);
            System.out.println(examDTOS);
        }

        for (ExamCartTM examCartTM : examCartTMS) {
            ExamScheduleDTO examScheduleDTO = new ExamScheduleDTO(
                    examCartTM.getExamShedulID(),
                    examCartTM.getExamID(),
                    examCartTM.getHallName(),
                    examCartTM.getExamTime(),
                    examCartTM.getExamDate()
            );
            examScheduleDTOS.add(examScheduleDTO);
            System.out.println(examScheduleDTOS);
        }

        for (ExamCartTM examCartTM : examCartTMS) {
            ExamSubjectIdDTO examSubjectIdDTO = new ExamSubjectIdDTO(
                    examCartTM.getExamID(),
                    examCartTM.getSubjectID()
            );
            examSubjectIdDTOS.add(examSubjectIdDTO);
            System.out.println(examSubjectIdDTOS);
        }

        boolean isSaved = addExamListBO.saveExamList(examDTOS, examScheduleDTOS, examSubjectIdDTOS);

        if (isSaved) {
            new Alert(Alert.AlertType.INFORMATION, "Saved...!").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Fail to save...!").show();
        }

        TBLplasMark.getItems().clear();
    }

    @FXML
    void selectGradeOnAction(ActionEvent event) throws SQLException {

        COMSubjectID.getItems().clear();

        if (getComboboxValues().equals("6") || getComboboxValues().equals("7") || getComboboxValues().equals("8") || getComboboxValues().equals("9")) {
            ObservableList<String> observableList = FXCollections.observableArrayList();
            ObservableList<SabjectDTO> sabjectDTOS = subjectBO.get6TO9Subject();
            for (SabjectDTO sabjectDTO : sabjectDTOS) {
                observableList.add(sabjectDTO.getSubjectId());
            }
            COMSubjectID.setItems(observableList);

        } else if (getComboboxValues().equals("10") || getComboboxValues().equals("11")) {
            ObservableList<String> observableList = FXCollections.observableArrayList();
            ObservableList<SabjectDTO> sabjectDTOS = subjectBO.get10TO11Subject();
            for (SabjectDTO sabjectDTO : sabjectDTOS) {
                observableList.add(sabjectDTO.getSubjectId());
            }
            COMSubjectID.setItems(observableList);
        }
    }

    @FXML
    void selectSubjectOnAction(ActionEvent event) {

        String subjectID = String.valueOf(COMSubjectID.getValue());
        try {
            LBSbjectName.setText(subjectBO.getSubjectName(subjectID));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void getExamShedulID() throws SQLException, ClassNotFoundException {
        String nextExamShedulID = addExamListBO.getExamShedulID();
        LBExamShedulID.setText(nextExamShedulID);
    }

    public void getExamID() throws SQLException, ClassNotFoundException {
        String nextExamID = addExamListBO.getExamID();
        LBExamID.setText(nextExamID);
    }

    private void loadExamHall() throws SQLException {
        ObservableList<String> observableList = FXCollections.observableArrayList();
        ObservableList<HallDTO> hallDTOS =  hallBO.getAllHall();
        for (HallDTO hallDTO : hallDTOS) {
            observableList.add(hallDTO.getHallId());
        }
        COBSelectHall.setItems(observableList);
    }

    private void loadGrade(ComboBox<String> comboBox) throws SQLException {

        comboBox.setItems(FXCollections.observableArrayList(ClassLevel.getAllLabels()));
    }

    private String getComboboxValues() {
        String Grade = String.valueOf(COBGrade.getValue());

        return Grade;
    }

    public void resetAddset() {
        LBExamShedulID.setText("");
        LBExamID.setText("");
        COBSelectHall.setValue("");
        TXTExamName.setText("");
        COBGrade.setValue("");
        DTPDate.setValue(null);
        TXTTime.setText("");
        COMSubjectID.setValue("");
        LBSbjectName.setText("");
    }
}
