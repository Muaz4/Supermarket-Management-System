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
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    private Label l_date;

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
        } else {
            boolean availble = true;
            availble = Remove();
            if (availble == true) {
                i++;
                prodTot = Double.valueOf(price_txt.getText()) * Double.valueOf(quantity_txt.getText());
                GrdTotal = GrdTotal + prodTot;

                if (i == 1) {
                    txtArea.setText(txtArea.getText() + "===========AL-MAYA  SUPERMARKET===========\n\n" + "NUM     PRODUCT     PRICE     QUANTITY     TOTAL\n" + i + "       "
                            + "            " + name_txt.getText() + "            " + price_txt.getText() + "            " + quantity_txt.getText() + "            " + prodTot + "\n");
                } else {

                    txtArea.setText(txtArea.getText() + i + "          " + name_txt.getText() + "            " + price_txt.getText() + "            " + quantity_txt.getText() + "            " + prodTot + "\n");

                }
                total_lbl.setText("Total = " + GrdTotal);
            } else {
                JOptionPane.showMessageDialog(null, "insufficient resource");
            }
        }

    }

    @FXML
    void Exit_btn(ActionEvent event) {
        Stage stage = (Stage) exit_btn.getScene().getWindow();
        stage.close();
    }

    @FXML
    void Print_btn(ActionEvent event) {
          DBconnections db = new DBconnections();
        String name = name_txt.getText();
        String quantity = quantity_txt.getText();
        String price = price_txt.getText();
        String date = l_date.getText();
        if (name.equals("") && quantity.equals("") && price.equals("") && date.equals("")) {

            JOptionPane.showMessageDialog(null, "Please Insert!");

        }else {
            try {

                con = db.connMethod();
                String sql = "insert into REPORT (NAME,QUANTITY,PRICE,DAY)values(?,?,?,?)";
                pst = con.prepareStatement(sql);
                pst.setString(1, name);
                pst.setString(2, quantity);
                pst.setString(3, price);
                pst.setString(4, date);
                pst.execute();

                JOptionPane.showMessageDialog(null, "Reported!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);

            }
    }}



    boolean Remove() {
        DBconnections db = new DBconnections();
        boolean result = false;
        float quantity = Float.parseFloat(quantity_txt.getText());
        String name = name_txt.getText();

        try {
            Connection con = db.connMethod();
            String sql = "select * from PRODUCT where NAME ='" + name + "'";

            ResultSet rs = con.createStatement().executeQuery(sql);
            float availableQuan = 1;
            if (rs.next()) {
                availableQuan = Float.parseFloat(rs.getString("QUANTITY"));

            }
            if (availableQuan >= quantity) {
                availableQuan = availableQuan - quantity;
                String sql1 = "update PRODUCT set QUANTITY='" + availableQuan + "' where NAME ='" + name + "' ";
                Statement st = con.createStatement();
                st.executeUpdate(sql1);
                result = true;
            } else {
                result = false;
            }
        } catch (Exception ex) {
        }
        return result;
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


public void date(){

   Date d = new Date();
 
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    String dd = sdf.format(d);  
   
   l_date.setText(dd);

}

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
   date();
 }

}
