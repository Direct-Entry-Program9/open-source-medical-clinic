package lk.ijse.dep9.clinic.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

public class LoginFormController {
    public JFXTextField txtUserName;
    public JFXPasswordField txtPassword;
    public JFXButton btnLogin;

    public void initialize(){
        btnLogin.setDefaultButton(true);
    }

    public void btnLoginOnAction(ActionEvent actionEvent) {
        String username = txtUserName.getText();
        String password = txtPassword.getText();

        if (username.isBlank()){
            new Alert(Alert.AlertType.ERROR,"Username cannot be empty").show();
            txtUserName.requestFocus();
            txtUserName.selectAll();
            return;
        } else if (password.isBlank()) {
            new Alert(Alert.AlertType.ERROR,"Password cannot be empty").show();
            txtPassword.requestFocus();
            txtPassword.selectAll();
            return;
        }

        if (username.matches("^[A-Za-z0-9]+$")){
            new Alert(Alert.AlertType.ERROR,"Invalid login credential").show();
            txtUserName.requestFocus();
            txtUserName.selectAll();
            return;
        }

    }
}
