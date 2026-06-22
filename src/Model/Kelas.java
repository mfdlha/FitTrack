/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author fadil
 */
public class Kelas {
    private int idKelas;
    private String namaKelas;
    private String instruktur;
    private String hari;
    private String jamMulai;   
    private String jamSelesai;
    private int kapasitas;

    public Kelas() {
    }

    public Kelas(String namaKelas, String instruktur, String hari, String jamMulai, String jamSelesai, int kapasitas) {
        this.namaKelas = namaKelas;
        this.instruktur = instruktur;
        this.hari = hari;
        this.jamMulai = jamMulai;
        this.jamSelesai = jamSelesai;
        this.kapasitas = kapasitas;
    }

    public Kelas(int idKelas, String namaKelas, String instruktur, String hari, String jamMulai, String jamSelesai, int kapasitas) {
        this.idKelas = idKelas;
        this.namaKelas = namaKelas;
        this.instruktur = instruktur;
        this.hari = hari;
        this.jamMulai = jamMulai;
        this.jamSelesai = jamSelesai;
        this.kapasitas = kapasitas;
    }

    public int getIdKelas() { return idKelas; }
    public void setIdKelas(int idKelas) { this.idKelas = idKelas; }

    public String getNamaKelas() { return namaKelas; }
    public void setNamaKelas(String namaKelas) { this.namaKelas = namaKelas; }

    public String getInstruktur() { return instruktur; }
    public void setInstruktur(String instruktur) { this.instruktur = instruktur; }

    public String getHari() { return hari; }
    public void setHari(String hari) { this.hari = hari; }

    public String getJamMulai() { return jamMulai; }
    public void setJamMulai(String jamMulai) { this.jamMulai = jamMulai; }

    public String getJamSelesai() { return jamSelesai; }
    public void setJamSelesai(String jamSelesai) { this.jamSelesai = jamSelesai; }

    public int getKapasitas() { return kapasitas; }
    public void setKapasitas(int kapasitas) { this.kapasitas = kapasitas; }
}

