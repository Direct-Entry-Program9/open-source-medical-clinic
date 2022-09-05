package lk.ijse.dep9.clinic.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class SettingsFormController {
    public JFXButton btnManageProfile;
    public JFXButton btnAddDiscount;
    public JFXButton btnAddField;
    public JFXButton btnChangePassword;
    public JFXButton btnAbout;
    public AnchorPane pneSettings;

    public void btnAboutOnAction(ActionEvent actionEvent) {
    }

    public void btnManageProfileOnAction(ActionEvent actionEvent) {
    }

    public void btnAddDiscountOnAction(ActionEvent actionEvent) {
    }

    public void btnAddFieldOnAction(ActionEvent actionEvent) throws IOException {
        pneSettings.getChildren().clear();
        Parent parent = FXMLLoader.load(this.getClass().getResource("/view/ManageFieldForm.fxml"));
        pneSettings.getChildren().add(parent);

        AnchorPane.setTopAnchor(parent,0.0);
        AnchorPane.setRightAnchor(parent,0.0);
        AnchorPane.setLeftAnchor(parent,0.0);
        AnchorPane.setBottomAnchor(parent,0.0);
    }

    public void btnChangePasswordOnAction(ActionEvent actionEvent) {
    }
}
