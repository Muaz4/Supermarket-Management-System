/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package supermarket1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author admin
 */
public class AdminController implements Initializable {


    @FXML
    private Button add_btn;

    @FXML
    private Button catagorie_btn;

    @FXML
    private Button exit_btn;

    @FXML
    private Button seller_btn;

    @FXML
    private Button view_btn;

    @FXML
    void AddCatagories(ActionEvent event) {

    }

    @FXML
    void AddProduct(ActionEvent event) {

    }

    @FXML
    void Exit(ActionEvent event) {
   Stage stage = (Stage) exit_btn.getScene().getWindow();
        stage.close();

    }

    @FXML
    void ManageSeller(ActionEvent event) {

    }

    @FXML
    void ViewItem(ActionEvent event) {

    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
