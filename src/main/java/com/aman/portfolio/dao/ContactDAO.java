package com.aman.portfolio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.aman.portfolio.util.DBConnection;

public class ContactDAO {

    public boolean saveMessage(String name, String email, String message) {
        String sql = "INSERT INTO contact_messages(name, email, message) VALUES (?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, message);

            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
