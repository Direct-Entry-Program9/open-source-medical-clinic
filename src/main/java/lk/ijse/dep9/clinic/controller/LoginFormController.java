package lk.ijse.dep9.clinic.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import lk.ijse.dep9.clinic.security.SecurityContextHolder;
import lk.ijse.dep9.clinic.security.User;
import lk.ijse.dep9.clinic.security.UserRole;

import java.io.IOException;
import java.sql.*;

public class LoginFormController {
    public JFXTextField txtUserName;
    public JFXPasswordField txtPassword;
    public JFXButton btnLogin;

    public void initialize(){
        btnLogin.setDefaultButton(true);
    }

    public void btnLoginOnAction(ActionEvent actionEvent) throws ClassNotFoundException, IOException {
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

        if (!username.matches("^[A-Za-z0-9]+$")){
            new Alert(Alert.AlertType.ERROR,"Invalid login credential").show();
            txtUserName.requestFocus();
            txtUserName.selectAll();
            return;
        }

        Class.forName("com.mysql.cj.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_clinic", "root", "Kasuni@1234")){
            /*String sql = "SELECT role FROM User WHERE username='%s' AND password='%s'";
            sql= String.format(sql,username,password);

            Statement stm = connection.createStatement();
            ResultSet rst = stm.executeQuery(sql);*/

            String sql = "SELECT role FROM User WHERE username=? AND password=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1,username);
            stm.setString(2,password);
            ResultSet rst = stm.executeQuery();

            if (rst.next()){
                String role = rst.getString("role");
                SecurityContextHolder.setPrincipal(new User(username,role));
                Scene scene;
                switch (role){
                    case "Admin":
                        scene = new Scene(FXMLLoader.load(this.getClass().getResource("/view/AdminDashboardForm.fxml")));
                        break;
                    case "Doctor":
                        scene = new Scene(FXMLLoader.load(this.getClass().getResource("/view/DoctorDashboardForm.fxml")));
                        break;
                    default:
                        scene = new Scene(FXMLLoader.load(this.getClass().getResource("/view/ReceptionistDashboardForm.fxml")));
                }

                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
                stage.centerOnScreen();
                System.out.println(SecurityContextHolder.getPrincipal().toString());

            }else {
                new Alert(Alert.AlertType.ERROR,"Invalid login credential").show();
                txtUserName.requestFocus();
                txtUserName.selectAll();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,"Failed to connect with the database, Try Again").show();
        }

    }
}
