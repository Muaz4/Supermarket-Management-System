/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author admin
 */
public class LoginController implements Initializable {

    @FXML
    private ComboBox combox;

    @FXML
    private Label lbl_fs;

    @FXML
    private Label lbl_lg;

    @FXML
    private Label lbl_pd;

    @FXML
    private Label lbl_sr;

    @FXML
    private Label lbl_un;

    @FXML
    private Label login_lbl;

    @FXML
    private Button sign_inbtn;

    @FXML
    private Button sign_upbtn;

    @FXML
    private PasswordField txt_pass;

    @FXML
    private TextField txt_user;

    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    @FXML
    void Sign_in(ActionEvent event) throws IOException {

        DBconnections db = new DBconnections();

        String uname = txt_user.getText();
        String pass = txt_pass.getText();

        if (uname.equals("") && pass.equals("")) {

            login_lbl.setText("Please Insert Username or Password");

        } else {
            try {
                con = db.connMethod();
                String sql = "select * from LOGIN where username = ? and password = ? and type = ?";

                pst = con.prepareStatement(sql);

                pst.setString(1, uname);
                pst.setString(2, pass);
                pst.setString(3, combox.getValue().toString());

                rs = pst.executeQuery();
                if (rs.next()) {

                    FXMLLoader fxmlLoader = new FXMLLoader(AdminController.class.getResource("Admin.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(), 800, 500);
                    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    window.setScene(scene);
                    window.show();
                } else 

                    login_lbl.setText("Wrong Username or Password");
                

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @FXML
    void Sign_up(ActionEvent event) {
        Stage stage = (Stage) sign_upbtn.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb
    ) {
        combox.getItems().addAll("Admin", "Cashier");
    }

}
