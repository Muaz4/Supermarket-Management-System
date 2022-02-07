/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author admin
 */
public class SplashController implements Initializable {
   int i = 100;
    @FXML
    private ProgressBar Myprogress;

    @FXML
    private Label Percentage;

    @FXML
    private AnchorPane start;
    @FXML
    private AnchorPane start_btn;


public void IncreaseProgress(ActionEvent event) throws IOException{


    while (i <= 4000) {
            Myprogress.setProgress(i);
            i = i + 200;
            try {
                Thread.sleep(250);
            } catch (Exception e) {
            }
       
        FXMLLoader fxmlLoader = new FXMLLoader(AdminController.class.getResource("FXMLDocument.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(), 840, 520);
                    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    window.setScene(scene);
                    window.show(); 
 }

    }
    
 

  @Override
    public void initialize(URL url, ResourceBundle rb) {
   Myprogress.setStyle("-fx-accent: gray");
  
}





}

