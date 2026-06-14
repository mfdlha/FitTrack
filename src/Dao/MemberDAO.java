/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Member;
import config.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fadil
 */


public class MemberDAO {

    // Login member
    public Member login(String no_hp, String password) {
        String sql = "SELECT * FROM member WHERE no_hp = ? AND password = ?";
        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, no_hp);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Member(
                    rs.getInt("id_member"),
                    rs.getString("nama"),
                    rs.getString("no_hp"),
                    rs.getString("password"),
                    rs.getString("alamat"),
                    rs.getString("tgl_daftar"),
                    rs.getString("status")
                );
            }
        } catch (Exception e) {
            System.out.println("Login error: " + e.getMessage());
        }
        return null;
    }

    // Ambil semua member
    public List<Member> getAllMember() {
        List<Member> list = new ArrayList<>();
        String sql = "SELECT * FROM member";
        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Member m = new Member(
                    rs.getInt("id_member"),
                    rs.getString("nama"),
                    rs.getString("no_hp"),
                    rs.getString("password"),
                    rs.getString("alamat"),
                    rs.getString("tgl_daftar"),
                    rs.getString("status")
                );
                list.add(m);
            }
        } catch (Exception e) {
            System.out.println("getAllMember error: " + e.getMessage());
        }
        return list;
    }

    public boolean tambahMember(Member m) {
        String sql = "INSERT INTO member (nama, no_hp, password, alamat, tgl_daftar, status) "
                   + "VALUES (?, ?, ?, ?, NOW(), 'AKTIF')";
        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, m.getNama());
            ps.setString(2, m.getNo_hp());
            ps.setString(3, m.getPassword());
            ps.setString(4, m.getAlamat());
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (Exception e) {
            System.out.println("tambahMember error: " + e.getMessage());
        }
        return false;
    }

    public int countMember() {
        String sql = "SELECT COUNT(*) FROM member";
        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return rs.getInt(1);
        } catch (Exception e) {
            System.out.println("countMember error: " + e.getMessage());
        }
        return 0;
    }
}