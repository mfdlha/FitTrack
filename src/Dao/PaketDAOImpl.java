/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import koneksi.koneksi; 
import Model.Paket;
/**
 *
 * @author fadil
 */
public class PaketDAOImpl implements PaketDAO {

    @Override
    public void update(Paket paket) throws Exception {
        String sql = "UPDATE paket SET nama_paket=?, masa_aktif=?, harga=?, deskripsi=? WHERE id_paket=?";

        try (Connection conn = koneksi.getConnection(); 
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setString(1, paket.getNamaPaket());
            pst.setInt(2, paket.getMasaAktif());
            pst.setDouble(3, paket.getHarga());
            pst.setString(4, paket.getDeskripsi());
            pst.setInt(5, paket.getIdPaket()); 
            
            pst.executeUpdate();
        } 
    }

    @Override
    public void insert(Paket paket) throws Exception {
        String sql = "INSERT INTO paket (nama_paket, masa_aktif, harga, deskripsi) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = koneksi.getConnection(); 
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setString(1, paket.getNamaPaket());
            pst.setInt(2, paket.getMasaAktif());
            pst.setDouble(3, paket.getHarga());
            pst.setString(4, paket.getDeskripsi());
            
            pst.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "DELETE FROM paket WHERE id_paket=?";
        
        try (Connection conn = koneksi.getConnection(); 
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setInt(1, id);
            pst.executeUpdate();
        }
    }

    @Override
    public List<Paket> getAll() throws Exception {
        List<Paket> list = new ArrayList<>();
        String sql = "SELECT * FROM paket";
        
        try (Connection conn = koneksi.getConnection(); 
             Statement st = conn.createStatement(); 
             ResultSet rs = st.executeQuery(sql)) {
            
            while (rs.next()) {
                Paket p = new Paket();
                p.setIdPaket(rs.getInt("id_paket"));
                p.setNamaPaket(rs.getString("nama_paket"));
                p.setMasaAktif(rs.getInt("masa_aktif"));
                p.setHarga(rs.getDouble("harga"));
                p.setDeskripsi(rs.getString("deskripsi"));
                list.add(p);
            }
        }
        return list;
    }

    @Override
    public List<Paket> getByName(String nama) throws Exception {
        List<Paket> list = new ArrayList<>();
        String sql = "SELECT * FROM paket WHERE nama_paket LIKE ?";
        
        try (Connection conn = koneksi.getConnection(); 
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setString(1, "%" + nama + "%");
            
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    Paket p = new Paket();
                    p.setIdPaket(rs.getInt("id_paket"));
                    p.setNamaPaket(rs.getString("nama_paket"));
                    p.setMasaAktif(rs.getInt("masa_aktif"));
                    p.setHarga(rs.getDouble("harga"));
                    p.setDeskripsi(rs.getString("deskripsi"));
                    list.add(p);
                }
            }
        }
        return list;
    }
}
