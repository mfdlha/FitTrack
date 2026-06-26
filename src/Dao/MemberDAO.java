/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;
import Model.Member;
import java.util.List;

/**
 *
 * @author fadil
 */
public interface MemberDAO {
    public void insert(Member member) throws Exception;
    public void update(Member member) throws Exception;
    public void delete(int id) throws Exception;
    public List<Member> getAll() throws Exception;
    public List<Member> getByName(String nama) throws Exception;
    public List<Member> getNonActiveMember(String nama) throws Exception;
}

