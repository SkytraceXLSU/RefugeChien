/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.skytracex.refugechien.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pc
 */
public class DAOFactory {
        private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/TEP_WAM";
    //nom de la base de donnée
    private static final String user = "root";
    private static final String pwd = "";
    private static Connection conn = null;
    
    private DAOFactory() {
    }    
        public static Connection GetConnection(){
            if(conn == null) {
                try {
                    Class.forName(driver);
                    conn = DriverManager.getConnection(url, user, pwd);
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(DAOFactory.class.getName()).log(Level.SEVERE, null, ex);
                }    
            }
        return conn;
        }
        
}
