/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package supermarket1.TBL;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import supermarket1.AdminController;
import supermarket1.SellerTbl;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class ManageSellerController implements Initializable {

    @FXML
    private Button add_btn;

    @FXML
    private Button back_btn;

    @FXML
    private Button clear_btn;

    @FXML
    private TableView<SellerTbl> CshierTable;

    @FXML
    private TableColumn<SellerTbl, String> col_sell;

    @FXML
    private TableColumn<SellerTbl, String> col_name;

    @FXML
    private TableColumn<SellerTbl, Integer> col_pass;

    @FXML
    private TableColumn<SellerTbl, String> col_sex;

    @FXML
    private TableColumn<SellerTbl, String> col_salary;

    @FXML
    private Button delete_btn;

    @FXML
    private Button edit_btn;

    @FXML
    private TextField pass_txt;

    @FXML
    private TextField salary_txt;

    @FXML
    private TextField sell_txt;

    @FXML
    private TextField sex_txt;

    @FXML
    private TextField name_txt;

  // int index = -1;

    @FXML
    void Add(ActionEvent event) {
//        DBconnections db = new DBconnections();
//        String sellerid = sell_txt.getText();
//        String name = name_txt.getText();
//        String password = pass_txt.getText();
//        String gender = sex_txt.getText();
//        String salary = salary_txt.getText();
//        if (sellerid.equals("") && name.equals("") && password.equals("") && gender.equals("") && salary.equals("")) {
//
//            JOptionPane.showMessageDialog(null, "Please Insert!");
//
//        } else {
//            try {
//
//                con = db.connMethod();
//                String sql = "insert into CASHIER (SELLERID,NAME,PASSWORD,GENDER,SALARY)values(?,?,?,?,?)";
//                pst = con.prepareStatement(sql);
//                pst.setString(1, sellerid);
//                pst.setString(2, name);
//                pst.setString(3, password);
//                pst.setString(4, gender);
//                pst.setString(5, salary);
//                pst.execute();
//
//                JOptionPane.showMessageDialog(null, "Inserted!");
//            } catch (Exception ex) {
//                JOptionPane.showMessageDialog(null, ex);
//
//            }
//
//        }

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
    void Clear(ActionEvent event) {
//        pass_txt.setText(null);
//        sex_txt.setText(null);
//        sell_txt.setText(null);
//        salary_txt.setText(null);
//        name_txt.setText(null);

    }

    @FXML
    void Delete(ActionEvent event) {

    }

    @FXML
    void Edit(ActionEvent event) {

    }

     @FXML
    void getSelected(MouseEvent event) {

//        index = CshierTable.getSelectionModel().getSelectedIndex();
//        if (index <= -1) {
//
//            return;
//        }
//
//
//        sell_txt.setText(col_sell.getCellData(index).toString());
//        name_txt.setText(col_name.getCellData(index).toString());
//        pass_txt.setText(col_pass.getCellData(index).toString());
//        sex_txt.setText(col_sex.getCellData(index).toString());
//        salary_txt.setText(col_salary.getCellData(index).toString());

    }

//  public ObservableList<SellerTbl> getTableList() {
//        ObservableList<SellerTbl> listM = FXCollections.observableArrayList();
//        DBconnections db = new DBconnections();
//        ResultSet rs;
//
//        try {
//            Statement st;
//            Connection con = db.connMethod();
//            String query = "select * from CASHIER";
//            rs = con.createStatement().executeQuery(query);
//
//            //Table
//            while (rs.next()) {
//               listM.add(new SellerTbl(Integer.parseInt(rs.getString("SELLERID")), rs.getString("NAME"), rs.getString("PASSWORD"), rs.getString("GENDER"), rs.getString("SALARY")));
//                //listM.add(Table3);
//            }
//
//        } catch (Exception ex) {
//            //ex.printStackTrace();
//        }
//        return listM;
//    }


//
//    ObservableList<SellerTbl> list = FXCollections.observableArrayList();
//    Connection con;
//    PreparedStatement pst;
//    ResultSet rs;

//   public void showTable() {
//        ObservableList<SellerTbl> list = getTableList();
//
//        col_sell.setCellValueFactory(new PropertyValueFactory<SellerTbl, String>("SELLERID"));
//       col_name.setCellValueFactory(new PropertyValueFactory<SellerTbl, String>("NAME"));
//      col_pass.setCellValueFactory(new PropertyValueFactory<SellerTbl, Integer>("PASSWORD"));
//       col_sex.setCellValueFactory(new PropertyValueFactory<SellerTbl, String>("GENDER"));
//       col_salary.setCellValueFactory(new PropertyValueFactory<SellerTbl, String>("SALARY"));
//
//        CshierTable.setItems(list);
//    }







    @Override
    public void initialize(URL url, ResourceBundle rb) {
                //showTable();
}

}




//        DBconnections db = new DBconnections();
//        try {
//            Connection con = db.connMethod();
//            ResultSet rs = con.createStatement().executeQuery("select * from CASHIER");
//
//            while (rs.next()) {
//                list.add(new SellerTbl(Integer.parseInt(rs.getString("SELLERID")), rs.getString("NAME"), rs.getString("PASSWORD"), rs.getString("GENDER"), rs.getString("SALARY")));
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(ManageSellerController.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(ManageSellerController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        col_sell.setCellValueFactory(new PropertyValueFactory<SellerTbl, String>("SELLERID"));
//        col_name.setCellValueFactory(new PropertyValueFactory<SellerTbl, String>("NAME"));
//        col_pass.setCellValueFactory(new PropertyValueFactory<SellerTbl, Integer>("PASSWORD"));
//        col_sex.setCellValueFactory(new PropertyValueFactory<SellerTbl, String>("GENDER"));
//        col_salary.setCellValueFactory(new PropertyValueFactory<SellerTbl, String>("SALARY"));
//
//        CshierTable.setItems(list);
    


