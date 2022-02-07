/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
class DBconnections {

    private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String user = "Sup";
    private static final String password = "1234";

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

}