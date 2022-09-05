package lk.ijse.dep9.clinic.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminDashboardFormController {
    public JFXButton btnProfileManage;
    public JFXButton btnViewRecords;
    public JFXButton btnSettings;
    public JFXButton btnLogout;

    public void btnProfileManageOnAction(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(this.getClass().getResource("/view/ProfileManagementForm.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.show();
        stage.centerOnScreen();
    }

    public void btnViewRecordsOnAction(ActionEvent actionEvent) {
    }

    public void btnSettingsOnAction(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(this.getClass().getResource("/view/SettingsForm.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.show();
        stage.centerOnScreen();
    }

    public void btnLogoutOnAction(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(this.getClass().getResource("/view/LoginForm.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.show();
        stage.centerOnScreen();
    }
}
