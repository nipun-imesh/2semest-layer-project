package com.assignment.finalproject.controller;

import com.assignment.finalproject.dto.main.AddParentDTO;
import com.assignment.finalproject.dto.tm.AddParentTM;
import com.assignment.finalproject.model.mainModel.AddParentCModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AddParentToStudentPageControler implements Initializable {

    AddParentCModel addParentCModel = new AddParentCModel();

    private StudentManagePageControler studentMC;

    @FXML
    private AnchorPane ANKaddStuPErent;

    @FXML
    private Button BUTPerentSelect;

    @FXML
    private Button BUTReset;

    @FXML
    private Button BUTSave;

    @FXML
    private Button BUTSearch;

    @FXML
    private TableColumn<AddParentTM, String> COLParentId;

    @FXML
    private TableColumn<AddParentTM, String> COLParentMail;

    @FXML
    private TableColumn<AddParentTM, String> COLParentName;

    @FXML
    private Label LBPerentID;

    @FXML
    private TableView<AddParentTM> TABParent;

    @FXML
    private TextField TXTParentMail;

    @FXML
    private TextField TXTParentName;

    @FXML
    private VBox Vbox;

    @FXML
    private VBox Vbox1;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        COLParentId.setCellValueFactory(new PropertyValueFactory<>("parentId"));
        COLParentName.setCellValueFactory(new PropertyValueFactory<>("parentName"));
        COLParentMail.setCellValueFactory(new PropertyValueFactory<>("parentEmail"));
        loadNextParentID();
        loadAllParent();
        BUTPerentSelect.setDisable(true);
    }

    public void setPatentController(StudentManagePageControler studentMC) {
        this.studentMC = studentMC;
    }

    private void loadAllParent() {
        ArrayList<AddParentDTO> addParentDTOS = null;
        try {
            addParentDTOS = AddParentCModel.getAllParent();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        ObservableList<AddParentTM> addParentTMS = FXCollections.observableArrayList();
        for (AddParentDTO addParentDTO : addParentDTOS) {
            AddParentTM addParentTM = new AddParentTM(
                    addParentDTO.getParentId(),
                    addParentDTO.getParentName(),
                    addParentDTO.getParentEmail()
            );
            addParentTMS.add(addParentTM);
        }

        TABParent.setItems(addParentTMS);
    }

    @FXML
    void parentSelectOnAction(ActionEvent event) {
        studentMC.setTXTStuParentId().setText(LBPerentID.getText());
        studentMC.setTXTStuParentName().setText(TXTParentName.getText());

        Stage Stage = (Stage) ANKaddStuPErent.getScene().getWindow();
        Stage.close();
    }

    @FXML
    void resetOnAction(ActionEvent event) {
        TXTParentName.setText("");
        TXTParentMail.setText("");
        BUTPerentSelect.setDisable(true);
        BUTSave.setDisable(false);
        loadNextParentID();
    }

    @FXML
    void saveOnAction(ActionEvent event) {

        String namePattern = "^[A-Za-z ]+$";
        String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

        if (TXTParentName.getText().isEmpty() || !TXTParentName.getText().matches(namePattern)) {
            new Alert(Alert.AlertType.ERROR, "Please enter a valid name (only letters and spaces)").show();
            return;
        }
        if (TXTParentMail.getText().isEmpty() || !TXTParentMail.getText().matches(emailPattern)) {
            new Alert(Alert.AlertType.ERROR, "Please enter a valid email address").show();
            return;

        }

        if (LBPerentID.getText().isEmpty() || TXTParentName.getText().isEmpty() || TXTParentMail.getText().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Please enter all fields").show();
        } else {
            String parentID = LBPerentID.getText();
            String parentName = TXTParentName.getText();
            String parentMail = TXTParentMail.getText();

            AddParentDTO addParentDTO = new AddParentDTO(
                    parentID,
                    parentName,
                    parentMail,
                    "Active"
            );
            try {
                if (AddParentCModel.saveParent(addParentDTO)) {
                    loadAllParent();
                    loadNextParentID();
                }
            } catch (SQLException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                throw new RuntimeException(e);
            }
        }
        reset();
    }

    @FXML
    void tabSelectOnaction(MouseEvent event) {
        BUTPerentSelect.setDisable(false);
        BUTSave.setDisable(true);

        AddParentTM addParentTM = TABParent.getSelectionModel().getSelectedItem();
        if (addParentTM != null) {
            LBPerentID.setText(addParentTM.getParentId());
            TXTParentName.setText(addParentTM.getParentName());
            TXTParentMail.setText(addParentTM.getParentEmail());
        }
    }

    public void loadNextParentID() {
        String nextParantID = null;
        try {
            nextParantID = addParentCModel.getParentID();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        LBPerentID.setText(nextParantID);
    }

    public void reset() {
        TXTParentName.setText("");
        TXTParentMail.setText("");
        BUTSave.setDisable(false);
    }
}
