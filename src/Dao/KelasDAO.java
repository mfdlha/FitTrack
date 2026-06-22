/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Model.Kelas;
/**
 *
 * @author fadil
 */
public interface KelasDAO{
    boolean insert(Kelas kelas);
    boolean update(Kelas kelas);
    boolean delete(int idKelas);
    List<Kelas> getAll(String keyword);
}
