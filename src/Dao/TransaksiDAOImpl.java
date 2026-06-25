/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;
import Model.Transaksi;
import koneksi.koneksi;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fadil
 */
public class TransaksiDAOImpl implements TransaksiDAO {
    Connection con = koneksi.getConnection();

    @Override
    public void insert(Transaksi t) {
        String sql = "INSERT INTO transaksi (id_member, id_paket, tgl_bayar, tgl_exp, total_bayar, status_bayar) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, t.getIdMember());
            st.setInt(2, t.getIdPaket());
            st.setString(3, t.getTglBayar());
            st.setString(4, t.getTglExp());
            st.setDouble(5, t.getTotalBayar());
            st.setString(6, t.getStatusBayar());
            st.executeUpdate();
        } catch (SQLException e) {
        }
    }
    
    @Override
    public List<Model.Transaksi> getAll() {
        List<Model.Transaksi> list = new ArrayList<>();
        String sql = "SELECT t.*, m.nama, p.nama_paket " +
                     "FROM transaksi t " +
                     "JOIN member m ON t.id_member = m.id_member " +
                     "JOIN paket p ON t.id_paket = p.id_paket";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Model.Transaksi t = new Model.Transaksi();
                t.setIdTransaksi(rs.getInt("id_transaksi"));
                t.setIdMember(rs.getInt("id_member"));
                t.setIdPaket(rs.getInt("id_paket"));
                t.setNamaMember(rs.getString("nama"));     
                t.setNamaPaket(rs.getString("nama_paket"));
                t.setTotalBayar(rs.getDouble("total_bayar"));
                t.setStatusBayar(rs.getString("status_bayar"));
                t.setTglBayar(rs.getString("tgl_bayar"));
                t.setTglExp(rs.getString("tgl_exp"));
                list.add(t);
            }
        } catch (SQLException e) {}
        return list;
    }
    
    @Override
    public void update(Transaksi t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public void updateStatus(int id, String status) {
        String sql = "UPDATE transaksi SET status_bayar=? WHERE id_transaksi=?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, status);
            st.setInt(2, id);
            st.executeUpdate();
        } catch (SQLException e) {}
    }
    
    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public List<Model.Transaksi> cari(String keyword) {
        List<Model.Transaksi> list = new ArrayList<>();
        String sql = "SELECT t.*, m.nama, p.nama_paket " +
                     "FROM transaksi t " +
                     "JOIN member m ON t.id_member = m.id_member " +
                     "JOIN paket p ON t.id_paket = p.id_paket " +
                     "WHERE m.nama LIKE ? OR p.nama_paket LIKE ?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, "%" + keyword + "%");
            st.setString(2, "%" + keyword + "%");

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Model.Transaksi t = new Model.Transaksi();
                t.setIdTransaksi(rs.getInt("id_transaksi"));
                t.setIdMember(rs.getInt("id_member"));
                t.setIdPaket(rs.getInt("id_paket"));
                t.setNamaMember(rs.getString("nama"));
                t.setNamaPaket(rs.getString("nama_paket"));
                t.setTotalBayar(rs.getDouble("total_bayar"));
                t.setStatusBayar(rs.getString("status_bayar"));
                t.setTglBayar(rs.getString("tgl_bayar"));
                t.setTglExp(rs.getString("tgl_exp"));
                list.add(t);
            }
        } catch (SQLException e) {}
        return list;
    }
    
    @Override
    public List<Model.Transaksi> getByKeyword(String keyword) {
        List<Model.Transaksi> list = new ArrayList<>();
        String sql = "SELECT * FROM transaksi WHERE id_member LIKE ? OR id_paket LIKE ?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, "%" + keyword + "%");
            st.setString(2, "%" + keyword + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Model.Transaksi t = new Model.Transaksi();
                t.setIdTransaksi(rs.getInt("id_transaksi"));
                t.setIdMember(rs.getInt("id_member"));
                t.setIdPaket(rs.getInt("id_paket"));
                t.setTglBayar(rs.getString("tgl_bayar"));
                t.setTglExp(rs.getString("tgl_exp"));
                t.setTotalBayar(rs.getDouble("total_bayar"));
                list.add(t);
            }
        } catch (SQLException e) {}
        return list;
    }
}
