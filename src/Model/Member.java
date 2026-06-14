/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author fadil
 */
public class Member {
    private int id_member;
    private String nama;
    private String no_hp;
    private String password;
    private String alamat;
    private String tgl_daftar;
    private String status;

    public Member() {}

    public Member(int id_member, String nama, String no_hp, String password,
                  String alamat, String tgl_daftar, String status) {
        this.id_member = id_member;
        this.nama = nama;
        this.no_hp = no_hp;
        this.password = password;
        this.alamat = alamat;
        this.tgl_daftar = tgl_daftar;
        this.status = status;
    }

    public int getId_member()     { return id_member; }
    public String getNama()       { return nama; }
    public String getNo_hp()      { return no_hp; }
    public String getPassword()   { return password; }
    public String getAlamat()     { return alamat; }
    public String getTgl_daftar() { return tgl_daftar; }
    public String getStatus()     { return status; }

    public void setId_member(int id_member)       { this.id_member = id_member; }
    public void setNama(String nama)               { this.nama = nama; }
    public void setNo_hp(String no_hp)             { this.no_hp = no_hp; }
    public void setPassword(String password)       { this.password = password; }
    public void setAlamat(String alamat)           { this.alamat = alamat; }
    public void setTgl_daftar(String tgl_daftar)   { this.tgl_daftar = tgl_daftar; }
    public void setStatus(String status)           { this.status = status; }
}