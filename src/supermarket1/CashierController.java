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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class CashierController implements Initializable {

    @FXML
    private Button addtobill_btn;

    @FXML
    private Label total_lbl;


    @FXML
    private Button clear_btn;

    @FXML
    private Button select_btn;

    @FXML
    private Button back_btn;

    @FXML
    private Button exit_btn;

    @FXML
    private TextField name_txt;

    @FXML
    private TextField price_txt;

    @FXML
    private Button print_btn;

    @FXML
    private TextField quantity_txt;

    @FXML
    private TextArea txtArea;
    int i = 0;
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    Double prodTot = 0.0, GrdTotal = 0.0;
    //int AvailQty; 

    @FXML
    void AddBill(ActionEvent event) {
        String name = name_txt.getText();
        String price = price_txt.getText();
        String quantity = quantity_txt.getText();
        if (name.equals("") && price.equals("") && quantity.equals("")) {
            JOptionPane.showMessageDialog(null, "Missing Information!");
        }
     else {
            i++;
            prodTot = Double.valueOf(price_txt.getText()) * Double.valueOf(quantity_txt.getText());
            GrdTotal = GrdTotal + prodTot; 

            if (i == 1) {
                txtArea.setText(txtArea.getText() + "===========AL-MAYA  SUPERMARKET===========\n\n" + "NUM     PRODUCT     PRICE     QUANTITY     TOTAL\n" + i + "       "
                        + "            " + name_txt.getText() + "            " + price_txt.getText() + "            " + quantity_txt.getText() + "            " + prodTot + "\n");
            } else {

                txtArea.setText(txtArea.getText() + i + "          " + name_txt.getText() + "            " + price_txt.getText() + "            " + quantity_txt.getText() + "            " + prodTot + "\n");

            }
        total_lbl.setText("Total = "+GrdTotal);
        }

    }

    @FXML
    void Exit_btn(ActionEvent event) {
        Stage stage = (Stage) exit_btn.getScene().getWindow();
        stage.close();
    }

    @FXML
    void Print_btn(ActionEvent event) {
        try {
            //txtArea.Print();
        } catch (Exception ex) {
        }
    }

    @FXML
    void Select(ActionEvent event) throws ClassNotFoundException {

        DBconnections db = new DBconnections();
        String name = name_txt.getText();

        try {
            Connection con = db.connMethod();
            String sql = "select * from PRODUCT where NAME ='" + name + "' ";
            ResultSet rs = con.createStatement().executeQuery(sql);

            if (rs.next()) {
                price_txt.setText(rs.getString("PRICE"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(CashierController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void Clear(ActionEvent event) {

        name_txt.setText(null);
        quantity_txt.setText(null);
        price_txt.setText(null);

    }

    @FXML
    void Back(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AdminController.class.getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
