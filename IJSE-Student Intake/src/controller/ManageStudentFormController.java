package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import controller.CrudController.StudentCrudController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Student;
import util.CrudUtil;

import java.io.IOException;
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
    public JFXButton btnBack;

    public void addBtnOnAction(ActionEvent actionEvent) {
        Student student = new Student(txtId.getText(), txtName.getText(), txtMail.getText(),txtContact.getText(), txtAddress.getText(),txtNic.getText());

        try {
            if (CrudUtil.execute("INSERT INTO student VALUES (?,?,?,?,?,?)",student.getId(), student.getName(), student.getMail(), student.getContact(), student.getAddress(), student.getNic())){
                new Alert(Alert.AlertType.CONFIRMATION, "Student Saved Successfully...!").show();
            }
        } catch (ClassNotFoundException | SQLException  e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Try Again....!").show();
        }
    }

    public void updateBtnOnAction(ActionEvent actionEvent) {
        Student s=new Student(txtId.getText(), txtName.getText(), txtMail.getText(),txtContact.getText(), txtAddress.getText(),txtNic.getText());

        try{
            if(CrudUtil.execute("UPDATE student SET student_Name=?,email=?,contact=?, address=?, nic=?  WHERE student_Id=?",s.getName(), s.getMail(), s.getContact(), s.getAddress(), s.getNic(), s.getId())){
                new Alert(Alert.AlertType.CONFIRMATION, "Student Updated Successfully...!").show();
            }
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Try Again....!").show();
        }
    }

    public void deleteBtnOnAction(ActionEvent actionEvent) {
        try{
            if (CrudUtil.execute("DELETE FROM student WHERE student_Id=?",txtId.getText())){
                new Alert(Alert.AlertType.CONFIRMATION, "Student Deleted Successfully...!").show();
            }else{
                new Alert(Alert.AlertType.ERROR, "Try Again....!").show();
            }
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Try Again....!"+e).show();
        }
    }

    public void listBtnOnAction(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("../view/StudentListForm.fxml"));
        Stage stage2 = new Stage();
        stage2.setScene(new Scene(parent));
        stage2.setResizable(false);
        stage2.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       setStudentIds();
    }

    private void setStudentIds() {
        try {

            ObservableList<String> ObList = FXCollections.observableArrayList(
                    StudentCrudController.getAllIds()
            );
            cmbStudentID.setItems(ObList);


            cmbStudentID.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                String id= (String) newValue;

                ResultSet result = null;
                try {
                    result = CrudUtil.execute("SELECT * FROM student WHERE student_Id=?",id);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                try {
                    if (result.next()) {
                        txtId.setText(result.getString(1));
                        txtName.setText(result.getString(2));
                        txtMail.setText(result.getString(3));
                        txtContact.setText(result.getString(4));
                        txtAddress.setText(result.getString(5));
                        txtNic.setText(result.getString(6));
                    } else {
                        new Alert(Alert.AlertType.WARNING, "Empty Result").show();
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            });
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void backBtnOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.close();

        Parent parent = FXMLLoader.load(getClass().getResource("../view/DashBoardForm.fxml"));
        Stage stage2 = new Stage();
        stage2.setScene(new Scene(parent));
        stage2.setResizable(false);
        stage2.show();
    }
}
