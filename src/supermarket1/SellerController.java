/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket1;

/**
 *
 * @author admin
 */
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class SellerController {

    @FXML
    private TableView<SellerTbl> CshierTable;

    @FXML
    private Button add_btn;

    @FXML
    private Button back_btn;
    
    @FXML
    private Button delete_btn;
   
    @FXML
    private Button clear_btn;

    @FXML
    private TableColumn<SellerTbl, String> col_name;

    @FXML
    private TableColumn<SellerTbl, String> col_pass;

    @FXML
    private TableColumn<SellerTbl, String> col_sell;

    @FXML
    private TableColumn<SellerTbl, String> col_sex;
    
    @FXML
    private TableColumn<SellerTbl, Integer> col_salary;
   
    @FXML
    private Button view_btn;

    @FXML
    private Button edit_btn;

    @FXML
    private TextField name_txt;

    @FXML
    private TextField pass_txt;

    @FXML
    private TextField salary_txt;

    @FXML
    private TextField sell_txt;

    @FXML
    private TextField sex_txt;


    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    int index = -1;
    @FXML
    void Add(ActionEvent event) {
    DBconnections db = new DBconnections();
       String sellerid = sell_txt.getText();
        String name = name_txt.getText();
        String password = pass_txt.getText();
        String gender = sex_txt.getText();
        String salary = salary_txt.getText();
        if (sellerid.equals("") && name.equals("") && password.equals("") && gender.equals("") && salary.equals("")) {

          JOptionPane.showMessageDialog(null, "Please Insert!");

       } else {
           try {

                con = db.connMethod();
                String sql = "insert into CASHIER (SELLERID,NAME,PASSWORD,GENDER,SALARY)values(?,?,?,?,?)";
                pst = con.prepareStatement(sql);
                pst.setString(1, sellerid);
                pst.setString(2, name);
                pst.setString(3, password);
                pst.setString(4, gender);
                pst.setString(5, salary);
                pst.execute();

                JOptionPane.showMessageDialog(null, "Inserted!");
           } catch (Exception ex) {
              JOptionPane.showMessageDialog(null, ex);

          }
        }

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
    void Delete(ActionEvent event) {
      DBconnections db = new DBconnections();
     // String name = name_txt.getText();
       try {

            con = db.connMethod();
            String sql = "delete from CASHIER where NAME = ? ";

            pst = con.prepareStatement(sql);
            pst.setString(1, name_txt.getText());
            pst.execute();

            JOptionPane.showMessageDialog(null, "Deleted!");
       } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
       }
    }


    @FXML
    void Clear(ActionEvent event) {
        pass_txt.setText(null);
       sex_txt.setText(null);
       sell_txt.setText(null);
       salary_txt.setText(null);
       name_txt.setText(null);
    }






    @FXML
    void View (ActionEvent event) {
         showTable();
    }





    @FXML
    void Edit(ActionEvent event) {
  DBconnections db = new DBconnections();
        try {
            Connection con = db.connMethod();
            String value1 = sell_txt.getText();
            String value2 = name_txt.getText();
            String value3 = pass_txt.getText();
            String value4 = sex_txt.getText();
            String value5 = salary_txt.getText();

            String sql = "update CASHIER set SELLERID = '" + value1 + "', NAME = '" + value2 + "', PASSWORD = '" + value3 + "', GENDER = '" + value4 + "', SALARY = '" + value5 + "' where NAME = '" + value2 + "' ";
            pst = con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Updated!");

        } catch (Exception ex) {
          JOptionPane.showMessageDialog(null, ex);
        }
    }






    @FXML
    void getSelected(MouseEvent event) {
        index = CshierTable.getSelectionModel().getSelectedIndex();
        if (index <= -1) {

            return;
        }


        sell_txt.setText(col_sell.getCellData(index).toString());
        name_txt.setText(col_name.getCellData(index).toString());
        pass_txt.setText(col_pass.getCellData(index).toString());
        sex_txt.setText(col_sex.getCellData(index).toString());
        salary_txt.setText(col_salary.getCellData(index).toString());
    }

  public ObservableList<SellerTbl> getTableList() {
        ObservableList<SellerTbl> listM = FXCollections.observableArrayList();
        DBconnections db = new DBconnections();
        ResultSet rs;

        try {
            Statement st;
            Connection con = db.connMethod();
            String query = "select * from CASHIER";
            rs = con.createStatement().executeQuery(query);

            //Table
            while (rs.next()) {
               listM.add(new SellerTbl(Integer.parseInt(rs.getString("SELLERID")), rs.getString("NAME"), rs.getString("PASSWORD"), rs.getString("GENDER"), rs.getString("SALARY")));
                //listM.add(Table3);
            }

        } catch (Exception ex) {
            //ex.printStackTrace();
        }
        return listM;
    }




 ObservableList<SellerTbl> list = FXCollections.observableArrayList();

   public void showTable() {
        ObservableList<SellerTbl> list = getTableList();

        col_sell.setCellValueFactory(new PropertyValueFactory<SellerTbl, String>("SELLERID"));
       col_name.setCellValueFactory(new PropertyValueFactory<SellerTbl, String>("NAME"));
      col_pass.setCellValueFactory(new PropertyValueFactory<SellerTbl, String>("PASSWORD"));
       col_sex.setCellValueFactory(new PropertyValueFactory<SellerTbl, String>("GENDER"));
       col_salary.setCellValueFactory(new PropertyValueFactory<SellerTbl, Integer>("SALARY"));

        CshierTable.setItems(list);
    }

    public void initialize(URL url, ResourceBundle rb) {
        // TODO
     showTable();

       }
}