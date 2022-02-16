/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket1;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import supermarket1.DBconnections;

/**
 *
 * @author admin
 */
/**
 * FXML Controller class
 *
 * @author admin
 */
public class TableviewController implements Initializable {

    @FXML
    private javafx.scene.control.TableView<Table3> TableView;

    @FXML
    private TableColumn<Table3, Integer> col_proid;

    @FXML
    private TableColumn<Table3, String> col_name;

    @FXML
    private TableColumn<Table3, String> col_category;

    @FXML
    private TableColumn<Table3, String> col_quantity;

    @FXML
    private TableColumn<Table3, String> col_price;

    @FXML
    void Back(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TableviewController.class.getResource("Admin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();

    }


    public ObservableList<Table3> getTableList() {
        ObservableList<Table3> listM = FXCollections.observableArrayList();
        DBconnections db = new DBconnections();
        ResultSet rs;

        try {
            Statement st;
            Connection con = db.connMethod();
            String query = "select * from PRODUCT";
            rs = con.createStatement().executeQuery(query);

            while (rs.next()) {
                listM.add ( new Table3(Integer.parseInt(rs.getString("PRODUCT_ID")),rs.getString("NAME") , rs.getString("CATEGORY"), rs.getString("QUANTITY") , rs.getString("PRICE")));
            }

        } catch (Exception ex) {

        }
        return listM;
    }

    public void showTable() {
        ObservableList<Table3> list = getTableList();

        col_proid.setCellValueFactory(new PropertyValueFactory<Table3, Integer>("PRODUCT_ID"));
        col_name.setCellValueFactory(new PropertyValueFactory<Table3, String>("NAME"));
        col_category.setCellValueFactory(new PropertyValueFactory<Table3, String>("CATEGORY"));
        col_quantity.setCellValueFactory(new PropertyValueFactory<Table3, String>("QUANTITY"));
        col_price.setCellValueFactory(new PropertyValueFactory<Table3, String>("PRICE"));

        TableView.setItems(list);
    }


@Override
        public void initialize(URL url, ResourceBundle rb) {

        showTable();

 }

    }


