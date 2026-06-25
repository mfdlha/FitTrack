/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package koneksi;

import java.io.FileInputStream;
import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author fadil
 */
public class koneksi {
    
    public static Connection getConnection() {
        try {
            Properties props = new Properties();

            try (FileInputStream fis = new FileInputStream("config.properties")) {
                props.load(fis);
            } catch (Exception e) {
                System.out.println("File config.properties tidak ditemukan atau gagal dibaca!");
                return null;
            }

            String host = props.getProperty("db.host");
            String port = props.getProperty("db.port");
            String database = props.getProperty("db.name");
            String user = props.getProperty("db.user");
            String pass = props.getProperty("db.pass");

            String url = "jdbc:mysql://" + host + ":" + port + "/" + database + "?useSSL=false&allowPublicKeyRetrieval=true";

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                Class.forName("com.mysql.jdbc.Driver"); 
            }

            Connection conn = DriverManager.getConnection(url, user, pass);
            System.out.println("Koneksi database AWS RDS berhasil!");
            return conn;
            
        } catch (Exception e) {
            System.out.println("Koneksi database gagal!");
            System.out.println(e.getMessage());
            return null;
        }
    }
}
