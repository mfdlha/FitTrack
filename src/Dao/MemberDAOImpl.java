/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;
import Model.Member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author fadil
 */
public class MemberDAOImpl implements MemberDAO {
    @Override
    public void insert(Member member) throws Exception {
        String sql = "INSERT INTO member (nama, no_hp, alamat, tgl_daftar, status) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = koneksi.koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, member.getNama());
            ps.setString(2, member.getNoHp());
            ps.setString(3, member.getAlamat());
            ps.setString(4, member.getTglDaftar());
            ps.setString(5, member.getStatus());
            ps.executeUpdate();
        }
    }

    @Override
    public void update(Member member) throws Exception {
        String sql = "UPDATE member SET nama=?, no_hp=?, alamat=?, tgl_daftar=?, status=? WHERE id_member=?";
        try (Connection conn = koneksi.koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, member.getNama());
            ps.setString(2, member.getNoHp());
            ps.setString(3, member.getAlamat());
            ps.setString(4, member.getTglDaftar());
            ps.setString(5, member.getStatus());
            ps.setInt(6, member.getIdMember());
            ps.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "DELETE FROM member WHERE id_member=?";
        try (Connection conn = koneksi.koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    @Override
    public List<Member> getAll() throws Exception {
        List<Member> list = new ArrayList<>();
        String sql = "SELECT * FROM member";
        try (Connection conn = koneksi.koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Member m = new Member();
                m.setIdMember(rs.getInt("id_member"));
                m.setNama(rs.getString("nama"));
                m.setNoHp(rs.getString("no_hp"));
                m.setAlamat(rs.getString("alamat"));
                m.setTglDaftar(rs.getString("tgl_daftar"));
                m.setStatus(rs.getString("status"));
                list.add(m);
            }
        }
        return list;
    }
    
    @Override
    public List<Member> getNonActiveMember(String nama) throws Exception {
        List<Member> list = new ArrayList<>();
        
        // PERHATIKAN: Harus ada tanda tanya (?) setelah kata LIKE
        String sql = "SELECT * FROM member WHERE nama LIKE ? AND status = 'TIDAK_AKTIF'";
        
        try (Connection conn = koneksi.koneksi.getConnection(); // Sesuaikan jika beda
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            // Baris ini akan mengisi tanda tanya (?) di atas dengan keyword dari form
            ps.setString(1, "%" + nama + "%");
            
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Member m = new Member();
                    m.setIdMember(rs.getInt("id_member"));
                    m.setNama(rs.getString("nama"));
                    m.setNoHp(rs.getString("no_hp"));
                    m.setAlamat(rs.getString("alamat"));
                    m.setTglDaftar(rs.getString("tgl_daftar"));
                    m.setStatus(rs.getString("status"));
                    list.add(m);
                }
            }
        }
        return list;
    }

    @Override
    public List<Member> getByName(String nama) throws Exception {
        List<Member> list = new ArrayList<>();
        String sql = "SELECT * FROM member WHERE nama LIKE ?";
        try (Connection conn = koneksi.koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + nama + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Member m = new Member();
                    m.setIdMember(rs.getInt("id_member"));
                    m.setNama(rs.getString("nama"));
                    m.setNoHp(rs.getString("no_hp"));
                    m.setAlamat(rs.getString("alamat"));
                    m.setTglDaftar(rs.getString("tgl_daftar"));
                    m.setStatus(rs.getString("status"));
                    list.add(m);
                }
            }
        }
        return list;
    }
    
}
