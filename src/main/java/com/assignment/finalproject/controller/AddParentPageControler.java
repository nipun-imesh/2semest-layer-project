package com.assignment.finalproject.controller;

import com.assignment.finalproject.bo.BOFactory;
import com.assignment.finalproject.bo.custom.AddParentBO;
import com.assignment.finalproject.dto.main.AddParentDTO;
import com.assignment.finalproject.dto.tm.AddParentTM;
import com.assignment.finalproject.dao.custom.Impl.mainMOdel.AddParentDAOImpl;
import com.assignment.finalproject.entity.main.AddParent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AddParentPageControler implements Initializable {

    @FXML
    private Button BUtSave;

    @FXML
    private Label LBParentId;

    @FXML
    private Button BUTUpdate;

    @FXML
    private TableColumn<AddParentTM, String> TBCParentId;

    @FXML
    private TableColumn<AddParentTM, String> TBCParentMail;

    @FXML
    private TableColumn<AddParentTM,String> TBCParentName;

    @FXML
    private TableView<AddParentTM> TBParentTabke;

    @FXML
    private TextField TXTParentMail;

    @FXML
    private TextField TXTParentName;

    @FXML
    private VBox Vbox;

    @FXML
    private VBox Vbox1;

    @FXML
    private Button btnDelete;

    AddParentTM addParentTM = new AddParentTM();
  //  AddParentDAOImpl addParentCModel = new AddParentDAOImpl();
    AddParentBO addParentBO = (AddParentBO) BOFactory.getInstance().getBO(BOFactory.BOType.ADDPARENT);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TBCParentId.setCellValueFactory(new PropertyValueFactory<>("parentId"));
        TBCParentName.setCellValueFactory(new PropertyValueFactory<>("parentName"));
        TBCParentMail.setCellValueFactory(new PropertyValueFactory<>("parentEmail"));
        try {
            loadNextParentID();
            loadAllParent();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        BUTUpdate.setDisable(true);
        btnDelete.setDisable(true);
    }

    @FXML
    void BUTResetOnAction(ActionEvent event) {

        BUTUpdate.setDisable(true);
        btnDelete.setDisable(true);

        TXTParentName.setText("");
        TXTParentMail.setText("");
        try {
            loadNextParentID();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void BUTSaveObAction(ActionEvent event) {

        String namePattern = "^[A-Za-z ]+$";
        String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

        if( TXTParentName.getText().isEmpty() || !TXTParentName.getText().matches(namePattern)) {
            new Alert(Alert.AlertType.ERROR, "Please enter a valid name (only letters and spaces)").show();
            return;
        }
        if( TXTParentMail.getText().isEmpty() || !TXTParentMail.getText().matches(emailPattern)) {
            new Alert(Alert.AlertType.ERROR, "Please enter a valid email address").show();
            return;

        }

        if(LBParentId.getText().isEmpty() || TXTParentName.getText().isEmpty() || TXTParentMail.getText().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Please enter all fields").show();
        }
        else {
            String parentID = LBParentId.getText();
            String parentName = TXTParentName.getText();
            String parentMail = TXTParentMail.getText();

            AddParent addParentDTO = new AddParent(
                    parentID,
                    parentName,
                    parentMail,
                    "Active"
            );
            try {
                if (addParentBO.saveParent(new AddParentDTO(addParentDTO.getParentId(),addParentDTO.getParentName(),addParentDTO.getParentEmail()))) {
                    new Alert(Alert.AlertType.INFORMATION, "Parent saved...!").show();
                    loadAllParent();
                    loadNextParentID();
                    reset();
                }
            } catch (SQLException e) {
               new Alert(Alert.AlertType.ERROR, "Parent not saved...!").show();
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @FXML
    void BUTUpdateOnAction(ActionEvent event) {

        String namePattern = "^[A-Za-z ]+$";
        String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

        if( TXTParentName.getText().isEmpty() || !TXTParentName.getText().matches(namePattern)) {
            new Alert(Alert.AlertType.ERROR, "Please enter a valid name (only letters and spaces)").show();
            return;
        }
        if( TXTParentMail.getText().isEmpty() || !TXTParentMail.getText().matches(emailPattern)) {
            new Alert(Alert.AlertType.ERROR, "Please enter a valid email address").show();
            return;

        }

        String parentID = LBParentId.getText();
        String parentName = TXTParentName.getText();
        String parentMail = TXTParentMail.getText();

        AddParent addParentDTO = new AddParent(
                parentID,
                parentName,
                parentMail,
                "Active"
        );
        try {
            if (addParentBO.upDatePerent(new AddParentDTO(addParentDTO.getParentId(),addParentDTO.getParentName(),addParentDTO.getParentEmail()))) {
                new Alert(Alert.AlertType.INFORMATION, "Parent updated...!").show();
                loadAllParent();
                loadNextParentID();
            }
        } catch (SQLException | ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, "Parent not updated...!").show();
            throw new RuntimeException(e);
        }
    }

    @FXML
    void BUTDeletOnAction(ActionEvent event) {
        String parentID = LBParentId.getText();
        try {
            if (addParentBO.deletePerent(parentID)) {
                new Alert(Alert.AlertType.INFORMATION, "Parent deleted...!").show();
                loadAllParent();
                loadNextParentID();
            }
        } catch (SQLException | ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, "Parent not deleted...!").show();
            throw new RuntimeException(e);
        }
    }

    @FXML
    void TBTableClickOnAction(MouseEvent event) {
        BUTUpdate.setDisable(false);
        btnDelete.setDisable(false);
        BUtSave.setDisable(true);

        AddParentTM addParentTM = TBParentTabke.getSelectionModel().getSelectedItem();
        if (addParentTM != null) {
            LBParentId.setText(addParentTM.getParentId());
            TXTParentName.setText(addParentTM.getParentName());
            TXTParentMail.setText(addParentTM.getParentEmail());

        }
    }

    public void loadNextParentID() throws SQLException, ClassNotFoundException {
        String nextParantID = addParentBO.getPerentID();
        LBParentId.setText(nextParantID);
    }

    private void loadAllParent() throws SQLException, ClassNotFoundException {
        ArrayList<AddParent> addParentDTOS = addParentBO.getAllParent();

        ObservableList<AddParentTM> addParentTMS = FXCollections.observableArrayList();
        for (AddParent addParentDTO : addParentDTOS) {
            AddParentTM addParentTM = new AddParentTM(
                    addParentDTO.getParentId(),
                    addParentDTO.getParentName(),
                    addParentDTO.getParentEmail()

            );
            addParentTMS.add(addParentTM);
        }

        TBParentTabke.setItems(addParentTMS);
    }

    public void reset(){
        TXTParentName.setText("");
        TXTParentMail.setText("");
    }
}
