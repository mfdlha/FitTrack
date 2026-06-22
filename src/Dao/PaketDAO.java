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
        public void insert(Paket paket) throws Exception;
        public void update(Paket paket) throws Exception;
        public void delete(int id) throws Exception;
        public List<Paket> getAll() throws Exception;
        public List<Paket> getByName(String nama) throws Exception;
}
