/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package supermarket1;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class AddProductController implements Initializable {

    @FXML
    private Button add_btn;

    @FXML
    private Button back_btn;

    @FXML
    private TextField category_txt;

    @FXML
    private Button delete_btn;

    @FXML
    private Button exit_btn;

    @FXML
    private TextField name_txt;

    @FXML
    private TextField price_txt;

    @FXML
    private TextField produtid_txt;

    @FXML
    private TextField quantity_txt;

    @FXML
    private Button update_btn;
    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    @FXML
    void AddBtn(ActionEvent event) throws ClassNotFoundException, SQLException {
        DBconnections db = new DBconnections();
        String productid = produtid_txt.getText();
        String name = name_txt.getText();
        String category = category_txt.getText();
        String quantity = quantity_txt.getText();
        String price = price_txt.getText();
        if (productid.equals("") && name.equals("") && category.equals("") && quantity.equals("") && price.equals("")) {

            JOptionPane.showMessageDialog(null, "Please Insert a products");

        } else {
            try {

                con = db.connMethod();
                String sql = "insert into PRODUCT (PRODUCT_ID,NAME,CATEGORY,QUANTITY,PRICE)values(?,?,?,?,?)";
                pst = con.prepareStatement(sql);
                pst.setString(1, productid);
                pst.setString(2, name);
                pst.setString(3, category);
                pst.setString(4, quantity);
                pst.setString(5, price);
                pst.execute();

                JOptionPane.showMessageDialog(null, "Product Inserted!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);

            }

        }

    }

    @FXML
    void Clear(ActionEvent event) {

        produtid_txt.setText(null);
        name_txt.setText(null);
        category_txt.setText(null);
        quantity_txt.setText(null);
        price_txt.setText(null);
    }

    @FXML
    void Back(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AdminController.class.getResource("Admin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();

    }

    @FXML
   void Delete(ActionEvent event) {
        DBconnections db = new DBconnections();
   String name = name_txt.getText();
       try {

            con = db.connMethod();
            String sql = "delete * from PRODUCT where NAME = '"+name+"'";

            pst = con.prepareStatement(sql);
            pst.setString(2, name_txt.getText());
            pst.execute();

            JOptionPane.showMessageDialog(null, "Deleted!");
       } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
       }

    }

    @FXML
    void Exit(ActionEvent event) {

        Stage stage = (Stage) exit_btn.getScene().getWindow();
        stage.close();
    }

    @FXML
    void Update(ActionEvent event) {
        DBconnections db = new DBconnections();
        try {
            Connection con = db.connMethod();
            String value1 = produtid_txt.getText();
            String value2 = name_txt.getText();
            String value3 = category_txt.getText();
            String value4 = quantity_txt.getText();
            String value5 = price_txt.getText();

            String sql = "update product set PRODUCT_ID = '" + value1 + "', NAME = '" + value2 + "', CATEGORY = '" + value3 + "', QUANTITY = '" + value4 + "', PRICE = '" + value5 + "' where NAME = '" + value2 + "' ";
            pst = con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Updated!");

        } catch (Exception ex) {
          JOptionPane.showMessageDialog(null, ex);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
