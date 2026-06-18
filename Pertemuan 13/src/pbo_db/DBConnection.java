package pbo_db;

import java.sql.*;

public class DBConnection {
    public Connection getConnection() {
        Connection con = null;
        try {
            // Driver khusus untuk Connector versi 8.0/9.0 ke atas
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            String url = "jdbc:mysql://localhost:3306/pbo?serverTimezone=UTC";
            con = DriverManager.getConnection(url, "root", "");
            return con;
        } catch (Exception ex) {
            System.err.println("Koneksi Gagal: " + ex.getMessage());
            return null;
        }
    }
}