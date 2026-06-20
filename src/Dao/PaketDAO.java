/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;
import Model.Paket;
import java.util.List;

/**
 *
 * @author fadil
 */
public interface PaketDAO {
        // 1. Fungsi untuk MENYIMPAN data baru (Create)
        public void insert(Paket paket) throws Exception;

        // 2. Fungsi untuk MENGUBAH data yang sudah ada (Update)
        public void update(Paket paket) throws Exception;

        // 3. Fungsi untuk MENGHAPUS data berdasarkan ID (Delete)
        public void delete(int id) throws Exception;

        // 4. Fungsi untuk MENGAMBIL SEMUA DATA dari database untuk tabel UI (Read)
        public List<Paket> getAll() throws Exception;

        // 5. (Opsional) Fungsi untuk MENCARI data berdasarkan nama paket
        public List<Paket> getByName(String nama) throws Exception;
}
