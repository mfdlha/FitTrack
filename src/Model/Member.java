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
    private int idMember;
    private String nama;
    private String noHp;
    private String alamat;
    private String tglDaftar;
    private String status;

    public int getIdMember() { return idMember; }
    public void setIdMember(int idMember) { this.idMember = idMember; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getNoHp() { return noHp; }
    public void setNoHp(String noHp) { this.noHp = noHp; }

    public String getAlamat() { return alamat; }
    public void setAlamat(String alamat) { this.alamat = alamat; }

    public String getTglDaftar() { return tglDaftar; }
    public void setTglDaftar(String tglDaftar) { this.tglDaftar = tglDaftar; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}