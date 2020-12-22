package com.example.demo.test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class JdbcConn {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mariadb://localhost:3306/mariadb",
                    "root", "root");
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT *  FROM users");
            String name = "";
            while(rs.next()) {
                name = rs.getString("name");
            }
            System.out.println("회원의 이름:  "+name);
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
