package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import controller.CrudController.StudentCrudController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import model.Student;
import util.CrudUtil;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ManageStudentFormController implements Initializable{
    public AnchorPane context;
    public JFXComboBox cmbStudentID;
    public JFXTextField txtId;
    public JFXTextField txtName;
    public JFXTextField txtMail;
    public JFXTextField txtContact;
    public JFXTextField txtAddress;
    public JFXTextField txtNic;
    public JFXButton btnAdd;
    public JFXButton btnUpdate;
    public JFXButton btnDelete;
    public JFXButton btnList;

    public void addBtnOnAction(ActionEvent actionEvent) {
//        Student student = new Student(txtId.getText(), txtName.getText(), txtMail.getText(),txtContact.getText(), txtAddress.getText(),txtNic.getText());
//
//        try {
//            if (CrudUtil.execute("INSERT INTO student VALUES (?,?,?,?,?,?)",student.getId(), student.getName(), student.getMail(), student.getContact(), student.getAddress(), student.getNic())){
//                new Alert(Alert.AlertType.CONFIRMATION, "Student Saved Successfully...!");
//            }
//        } catch (ClassNotFoundException | SQLException  e) {
//            e.printStackTrace();
//            new Alert(Alert.AlertType.ERROR, "Try Again....!");
//        }
    }

    public void updateBtnOnAction(ActionEvent actionEvent) {
    }

    public void deleteBtnOnAction(ActionEvent actionEvent) {
    }

    public void listBtnOnAction(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       // setStudentIds();
    }

    private void setStudentIds() {
//        try {
//
//            ObservableList<String> ObList = FXCollections.observableArrayList(
//                    StudentCrudController.getAllIds()
//            );
//            cmbStudentID.setItems(ObList);
//
//
//            cmbStudentID.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
//                String id= (String) newValue;
//
//                ResultSet result = null;
//                try {
//                    result = CrudUtil.execute("SELECT * FROM student WHERE student_Id=?",id);
//                } catch (SQLException throwables) {
//                    throwables.printStackTrace();
//                } catch (ClassNotFoundException e) {
//                    e.printStackTrace();
//                }
//                try {
//                    if (result.next()) {
//                        txtId.setText(result.getString(1));
//                        txtName.setText(result.getString(2));
//                        txtMail.setText(result.getString(3));
//                        txtContact.setText(result.getString(4));
//                        txtAddress.setText(result.getString(5));
//                        txtNic.setText(result.getString(6));
//                    } else {
//                        new Alert(Alert.AlertType.WARNING, "Empty Result").show();
//                    }
//                } catch (SQLException throwables) {
//                    throwables.printStackTrace();
//                }
//
//            });
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
    }
}
