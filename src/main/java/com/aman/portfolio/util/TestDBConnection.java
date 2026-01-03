package com.aman.portfolio.util;
import java.sql.Connection;
import com.aman.portfolio.util.DBConnection;

public class TestDBConnection {
    public static void main(String[] args) {
        try {
            Connection con = DBConnection.getConnection();
            System.out.println("Database connected successfully!");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
