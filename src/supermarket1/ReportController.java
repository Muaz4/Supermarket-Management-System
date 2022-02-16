/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
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
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class ReportController implements Initializable {

    @FXML
    private TableView<Report> ReportTbl;

    @FXML
    private Button back_btn;

    @FXML
    private TableColumn<Report, String> col_day;

    @FXML
    private TableColumn<Report, String> col_name;

    @FXML
    private TableColumn<Report, String> col_price;

    @FXML
    private TableColumn<Report, String> col_quantity;

    @FXML
    void Back(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TableviewController.class.getResource("Admin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();

    }

    public ObservableList<Report> getTableList() {
        ObservableList<Report> listM = FXCollections.observableArrayList();
        DBconnections db = new DBconnections();
        ResultSet rs;

        try {
            Statement st;
            Connection con = db.connMethod();
            String query = "select * from REPORT";
            rs = con.createStatement().executeQuery(query);
            while (rs.next()) {
                listM.add(new Report((rs.getString("NAME")), rs.getString("QUANTITY"), rs.getString("PRICE"), rs.getString("DAY")));

            }

        } catch (Exception ex) {
        }
        return listM;
    }


public void showTable() {
        ObservableList<Report> list = getTableList();

        col_name.setCellValueFactory(new PropertyValueFactory<Report, String>("NAME"));
        col_quantity.setCellValueFactory(new PropertyValueFactory<Report, String>("QUANTITY"));
        col_price.setCellValueFactory(new PropertyValueFactory<Report, String>("PRICE"));
        col_day.setCellValueFactory(new PropertyValueFactory<Report, String>("DAY"));

        ReportTbl.setItems(list);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    showTable();
}

}
