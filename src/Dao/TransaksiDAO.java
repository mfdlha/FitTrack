/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;
import Model.Transaksi;
import java.util.List;

/**
 *
 * @author fadil
 */
public interface TransaksiDAO {
    void insert(Transaksi t);
    void update(Transaksi t);
    void updateStatus(int id, String status);
    void delete(int id);
    List<Transaksi> getAll();
    List<Model.Transaksi> cari(String keyword);
    List<Transaksi> getByKeyword(String keyword);
}
