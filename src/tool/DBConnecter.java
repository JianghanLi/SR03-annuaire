/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luxin
 */
public class DBConnecter {

    private String url = "jdbc:mysql://tuxa.sme.utc:3306/sr03p021";  
    private String driver = "com.mysql.jdbc.Driver";
    private String user ="sr03p021";
    private String password = "nYl3DhBh";

    private Connection conn;
//    private PreparedStatement pst = null;
    private Statement statement;

    public DBConnecter() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            statement = conn.createStatement();
            //pst = conn.prepareStatement(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Statement getStatement() {
        return this.statement;
    }
    
    public Connection getConnection() {
        return this.conn;
    }

    public void close() {
        try {
            statement.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnecter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
