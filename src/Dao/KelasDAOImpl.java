/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;
import koneksi.koneksi;
import Model.Kelas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author fadil
 */
public class KelasDAOImpl implements KelasDAO {
    @Override
    public boolean insert(Kelas kelas) {
        String sql = "INSERT INTO kelas (nama_kelas, instruktur, hari, jam_mulai, jam_selesai, kapasitas) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = koneksi.getConnection(); 
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setString(1, kelas.getNamaKelas());
            pst.setString(2, kelas.getInstruktur());
            pst.setString(3, kelas.getHari());
            pst.setString(4, kelas.getJamMulai());
            pst.setString(5, kelas.getJamSelesai());
            pst.setInt(6, kelas.getKapasitas());
            
            int rows = pst.executeUpdate();
            return rows > 0;
        } catch (Exception e) {
            System.err.println("Error Insert: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(Kelas kelas) {
        String sql = "UPDATE kelas SET nama_kelas=?, instruktur=?, hari=?, jam_mulai=?, jam_selesai=?, kapasitas=? WHERE id_kelas=?";
        try (Connection conn = koneksi.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setString(1, kelas.getNamaKelas());
            pst.setString(2, kelas.getInstruktur());
            pst.setString(3, kelas.getHari());
            pst.setString(4, kelas.getJamMulai());
            pst.setString(5, kelas.getJamSelesai());
            pst.setInt(6, kelas.getKapasitas());
            pst.setInt(7, kelas.getIdKelas());
            
            int rows = pst.executeUpdate();
            return rows > 0;
        } catch (Exception e) {
            System.err.println("Error Update: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(int idKelas) {
        String sql = "DELETE FROM kelas WHERE id_kelas=?";
        try (Connection conn = koneksi.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setInt(1, idKelas);
            int rows = pst.executeUpdate();
            return rows > 0;
        } catch (Exception e) {
            System.err.println("Error Delete: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Kelas> getAll(String keyword) {
        List<Kelas> listKelas = new ArrayList<>();
        String sql;
        
        if (keyword == null || keyword.trim().isEmpty()) {
            sql = "SELECT * FROM kelas ORDER BY id_kelas DESC";
        } else {
            sql = "SELECT * FROM kelas WHERE nama_kelas LIKE ? OR instruktur LIKE ? ORDER BY id_kelas DESC";
        }
        
        try (Connection conn = koneksi.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            if (keyword != null && !keyword.trim().isEmpty()) {
                pst.setString(1, "%" + keyword + "%");
                pst.setString(2, "%" + keyword + "%");
            }
            
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Kelas kelas = new Kelas(
                    rs.getInt("id_kelas"),
                    rs.getString("nama_kelas"),
                    rs.getString("instruktur"),
                    rs.getString("hari"),
                    rs.getString("jam_mulai"),
                    rs.getString("jam_selesai"),
                    rs.getInt("kapasitas")
                );
                listKelas.add(kelas);
            }
        } catch (Exception e) {
            System.err.println("Error Get Data: " + e.getMessage());
        }
        return listKelas;
    }
    
}
