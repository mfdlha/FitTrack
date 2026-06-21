/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author fadil
 */
public class Paket {
    private int idPaket;        
    private String namaPaket;  
    private int masaAktif;        
    private double harga;       
    private String deskripsi;  

    public Paket() {
    }

    public Paket(int idPaket, String namaPaket, int masaAktif, double harga, String deskripsi) {
        this.idPaket = idPaket;
        this.namaPaket = namaPaket;
        this.masaAktif = masaAktif;
        this.harga = harga;
        this.deskripsi = deskripsi;
    }

    public int getIdPaket() {
        return idPaket;
    }

    public void setIdPaket(int idPaket) {
        this.idPaket = idPaket;
    }

    public String getNamaPaket() {
        return namaPaket;
    }

    public void setNamaPaket(String namaPaket) {
        this.namaPaket = namaPaket;
    }

    public int getMasaAktif() {
        return masaAktif;
    }

    public void setMasaAktif(int masaAktif) {
        this.masaAktif = masaAktif;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
}