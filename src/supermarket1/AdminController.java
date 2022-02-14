/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package supermarket1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    void AddProduct(ActionEvent event) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(AdminController.class.getResource("AddProduct.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(), 840, 520);
                    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    window.setScene(scene);
                    window.show(); 

    }

    @FXML
    void Exit(ActionEvent event) {
   Stage stage = (Stage) exit_btn.getScene().getWindow();
        stage.close();

    }

    @FXML
    void ManageSeller(ActionEvent event) throws IOException {
 FXMLLoader fxmlLoader = new FXMLLoader(AdminController.class.getResource("ManageSeller.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(), 840, 520);
                    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    window.setScene(scene);
                    window.show(); 

    }

    @FXML
    void ViewItem(ActionEvent event) throws IOException {

 FXMLLoader fxmlLoader = new FXMLLoader(AdminController.class.getResource("Tableview.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(), 840, 520);
                    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    window.setScene(scene);
                    window.show(); 


    }

    @FXML
    void Back(ActionEvent event) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(AdminController.class.getResource("FXMLDocument.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(), 840, 520);
                    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    window.setScene(scene);
                    window.show(); 

    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
