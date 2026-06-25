/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author fadil
 */
public class Transaksi {
    private int idTransaksi;
    private int idMember;
    private int idPaket;
    private String namaMember;
    private String namaPaket;
    private String tglBayar;
    private String tglExp;
    private double totalBayar;
    private String statusBayar;

    public int getIdTransaksi() { return idTransaksi; }
    public void setIdTransaksi(int idTransaksi) { this.idTransaksi = idTransaksi; }
    public int getIdMember() { return idMember; }
    public void setIdMember(int idMember) { this.idMember = idMember; }
    public int getIdPaket() { return idPaket; }
    public void setIdPaket(int idPaket) { this.idPaket = idPaket; }
    public String getNamaMember() { return namaMember; }
    public void setNamaMember(String namaMember) { this.namaMember = namaMember; }
    public String getNamaPaket() { return namaPaket; }
    public void setNamaPaket(String namaPaket) { this.namaPaket = namaPaket; }
    public String getTglBayar() { return tglBayar; }
    public void setTglBayar(String tglBayar) { this.tglBayar = tglBayar; }
    public String getTglExp() { return tglExp; }
    public void setTglExp(String tglExp) { this.tglExp = tglExp; }
    public double getTotalBayar() { return totalBayar; }
    public void setTotalBayar(double totalBayar) { this.totalBayar = totalBayar; }
    public String getStatusBayar() { return statusBayar; }
    public void setStatusBayar(String statusBayar) { this.statusBayar = statusBayar; }
}
