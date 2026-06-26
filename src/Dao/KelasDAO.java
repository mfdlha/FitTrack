/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;
import Model.Kelas;
import java.util.List;
/**
 *
 * @author fadil
 */
public interface KelasDAO {
    public boolean insert(Kelas kelas);
    public boolean update(Kelas kelas);
    public boolean delete(int idKelas);
    public List<Kelas> getAll(String keyword);
}
