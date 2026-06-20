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
    // Menyesuaikan tipe data dengan skema MySQL Anda
    private int idPaket;        // int(11) AUTO_INCREMENT
    private String namaPaket;   // varchar(10)
    private int durasi;        // date
    private double harga;       // double
    private String deskripsi;   // text

    // Constructor Kosong
    public Paket() {
    }

    // Constructor dengan Parameter
    public Paket(int idPaket, String namaPaket, int durasi, double harga, String deskripsi) {
        this.idPaket = idPaket;
        this.namaPaket = namaPaket;
        this.durasi = durasi;
        this.harga = harga;
        this.deskripsi = deskripsi;
    }

    // Getter dan Setter
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

    public int getDurasi() {
        return durasi;
    }

    public void setDurasi(int durasi) {
        this.durasi = durasi;
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