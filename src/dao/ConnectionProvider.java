/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.*;

/**
 *
 * @author TxmMinh
 */
public class ConnectionProvider {
    public static Connection getCon() {
        try {
            String url = "jdbc:mysql://localhost:3306/cafe_management?useSLL=false";
            String user = "root";
            String password = "password1234"; 
            Connection conn = DriverManager.getConnection(url, user, password);
            return conn;
        } catch(Exception e) {
            return null;
        }
    }
}
