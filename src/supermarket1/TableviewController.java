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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class TableviewController implements Initializable {

    @FXML
    private TableView<Table> TableView;

    @FXML
    private TableColumn<Table, Integer> col_proid;

    @FXML
    private TableColumn<Table, String> col_name;

    @FXML
    private TableColumn<Table, String> col_category;

    @FXML
    private TableColumn<Table, String> col_quantity;

    @FXML
    private TableColumn<Table, String> col_price;

   @FXML
    void Back(ActionEvent event) throws IOException {
  FXMLLoader fxmlLoader = new FXMLLoader(AdminController.class.getResource("Admin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();

    }


    ObservableList<Table> listM = FXCollections.observableArrayList();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DBconnections db = new DBconnections();
     try{
        Connection con = db.connMethod();
        ResultSet rs = con.createStatement().executeQuery("select * from PRODUCT");

while (rs.next()){
             listM.add(new Table(Integer.parseInt(rs.getString("PRODUCT_ID")),rs.getString("NAME") , rs.getString("CATEGORY"), rs.getString("QUANTITY") , rs.getString("PRICE")));
                }

      } catch (SQLException ex){
            Logger.getLogger(TableviewController.class.getName()).log(Level.SEVERE, null, ex);
}       catch (ClassNotFoundException ex) {
            Logger.getLogger(TableviewController.class.getName()).log(Level.SEVERE, null, ex);
        }





        col_proid.setCellValueFactory(new PropertyValueFactory<Table, Integer>("PRODUCT_ID"));
        col_name.setCellValueFactory(new PropertyValueFactory<Table, String>("NAME"));
        col_category.setCellValueFactory(new PropertyValueFactory<Table, String>("CATEGORY"));
        col_quantity.setCellValueFactory(new PropertyValueFactory<Table, String>("QUANTITY"));
        col_price.setCellValueFactory(new PropertyValueFactory<Table, String>("PRICE"));

          TableView.setItems(listM);

    }

}
