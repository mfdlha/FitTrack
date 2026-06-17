/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author fadil
 */
public class koneksi {
    private static final String URL = "jdbc:mysql://localhost:3306/db_fitness";
    private static final String USER = "root";
    private static final String PASSWORD = "12345";
    
    public static Connection getConnection(){
        try{
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Koneksi db berhasil!");
            return conn;
        } catch(SQLException e){
            System.out.println("Koneksi database gagal!");
            System.out.println(e.getMessage());
            
            return null;
        }
    }
}
