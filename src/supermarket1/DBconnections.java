/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
class DBconnections {

    private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String user = "Sup";
    private static final String password = "1234";
//    Connection con;
//   PreparedStatement pst;
//    ResultSet rs;

    public Connection connMethod() throws ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = null;

        try {
            con = DriverManager.getConnection(url, user, password);
            
          // JOptionPane.showMessageDialog(null, "connected");

        } catch (SQLException ex) {
           
        }
        return con;
    }
       
/*public static ObservableList<Table> getDataTable() throws ClassNotFoundException{
         
         Connection con;
         DBconnections db = new DBconnections();
         con = db.connMethod();
       ObservableList<Table> list = FXCollections.observableArrayList();
     try{
           PreparedStatement pst = con.PrepareStatement("Select * from PRODUCT");  
          ResultSet rs = pst.executeQuery();
        
      while (rs.next()){
             list.add(new Table(Integer.parseInt(rs.getString("PRODUCT_ID")),rs.getString("NAME") , rs.getString("CATEGORY"), rs.getString("QUANTITY") , rs.getString("PRICE")));
                }
          } catch (Exception ex) {    
}
   return list;
}
}*/
}