package com.assignment.finalproject.controller.login;

import com.assignment.finalproject.bo.BOFactory;
import com.assignment.finalproject.bo.custom.SignInBO;
import com.assignment.finalproject.dto.main.SigninDTO;
import com.assignment.finalproject.dao.custom.Impl.mainMOdel.SigninDAOImpl;
import com.assignment.finalproject.entity.main.Signin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.SQLException;

public class SignupPageControler {

    @FXML
    private AnchorPane ANKSignin;

    @FXML
    private Button BUTBack;

    @FXML
    private Button BUTCreate;

    @FXML
    private Label LBUserid;

    @FXML
    private TextField TXTPassword;

    @FXML
    private TextField TXTRePassword;

    @FXML
    private TextField TXTUsername;

//    SigninDAOImpl sininModel = new SigninDAOImpl();

    SignInBO signinbo = (SignInBO) BOFactory.getInstance().getBO(BOFactory.BOType.SIGNIN);

    public void initialize() throws SQLException, ClassNotFoundException {
        TXTUsername.setOnAction(event -> TXTPassword.requestFocus());
        TXTPassword.setOnAction(event -> TXTRePassword.requestFocus());
        TXTRePassword.setOnAction(event -> BUTCreate.fire());
        loadNextCustomerId();
    }

    @FXML
    void accontCreateAction(ActionEvent event) {
        String userid = LBUserid.getText();
        String username = TXTUsername.getText();
        String password = TXTPassword.getText();
        String rePassword = TXTRePassword.getText();

        try {
            if (TXTUsername.getText().isEmpty() || TXTPassword.getText().isEmpty() || TXTRePassword.getText().isEmpty()) {
                new Alert(Alert.AlertType.ERROR, "Please enter all fields").show();
            }else if(!password.equals(rePassword)){
                new Alert(Alert.AlertType.ERROR, "Password does not match").show();
            }else{
                SigninDTO signinDto = new SigninDTO(userid, username, password);
                boolean isSaved = signinbo.save(new SigninDTO(signinDto.getUserid(),signinDto.getUsername(),signinDto.getPassword()));
                if (isSaved) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Account created successfully").show();
                }

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void backAction(ActionEvent event) throws IOException {
        ANKSignin.getChildren().clear();
        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/LoginPage.fxml"));
        ANKSignin.getChildren().add(load);
    }

    public void loadNextCustomerId() throws SQLException, ClassNotFoundException {
       String nextCustomerId = signinbo.getID();
       LBUserid.setText(nextCustomerId);
    }
}
