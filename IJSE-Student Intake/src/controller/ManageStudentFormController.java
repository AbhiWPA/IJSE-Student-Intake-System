package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import model.Student;

public class ManageStudentFormController {
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
        Student student = new Student(txtId.getText(), txtName.getText(), txtMail.getText(),txtContact.getText(), txtAddress.getText(),txtNic.getText());

//        try {
//            if (CrudUtil.execute("INSERT INTO items VALUES (?,?,?,?)",items.getItemCode(), items.getDescription(), items.getQty(), items.getPrice())){
//                nfc.upperConfirmMessage("Saved...!","New Vegetable Item Saved Successfully...!");
//            }
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//            nfc.upperErrorMessage("Saving Error...!","New Vegetable Item Saved Unsuccessfully...!"+e.getMessage());
//        }
    }

    public void updateBtnOnAction(ActionEvent actionEvent) {
    }

    public void deleteBtnOnAction(ActionEvent actionEvent) {
    }

    public void listBtnOnAction(ActionEvent actionEvent) {
    }
}
