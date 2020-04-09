/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.app.npm451;

import com.app.npm451.model.Dokter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.app.npm451.utility.DatabaseUtility;

/**
 *
 * @author WORKGROUP
 */
public class DokterDataSource {
    private Connection connection;
    private Dokter dokter;
    
    public DokterDataSource(){
        connection = DatabaseUtility.getConnection();
    }
    
    public List<Dokter> getAll(){
        List<Dokter> list = new ArrayList<>();
        String sql = "SELECT * FROM Dokter";
        try{
            PreparedStatement statment = connection.prepareStatement(sql);
            ResultSet rs = statment.executeQuery();
            Dokter dokter;
            while(rs.next()){
                dokter = new Dokter();
                dokter.setIdDokter(rs.getString("iddokter"));
                dokter.setNama(rs.getString("nama"));
                dokter.setSpesialis(rs.getString("spesialis"));
                dokter.setAlamat(rs.getString("alamat"));
                dokter.setUmur(rs.getString("umur"));
                list.add(dokter);
            }
        } catch (Exception e){            
        }
        
        return list;
    }
    
    public Dokter getByID(String id){
        Dokter dokter = null;
        String sql = "SELECT * FROM dokter WHERE iddokter=?";
        try{
            PreparedStatement statment = connection.prepareStatement(sql);
            statment.setString(1, id);
            ResultSet rs = statment.executeQuery();
            if(rs.next()){
                dokter = new Dokter();
                dokter.setIdDokter(rs.getString("iddokter"));
                dokter.setNama(rs.getString("nama"));
                dokter.setSpesialis(rs.getString("spesialis"));
                dokter.setAlamat(rs.getString("alamat"));
                dokter.setUmur(rs.getString("umur"));
            }
        } catch (Exception e){            
        }
        
        return dokter;
    }
    
    public boolean insert(Dokter dokter){
        String sql = "INSERT INTO Dokter VALUES (?,?,?,?,?)";
        try{
            PreparedStatement statment = connection.prepareStatement(sql);
            statment.setString(1, dokter.getIdDokter());
            statment.setString(2, dokter.getNama());
            statment.setString(3, dokter.getSpesialis());
            statment.setString(4, dokter.getAlamat());
            statment.setString(5, dokter.getUmur());
            int result = statment.executeUpdate();
            return result > 0;
        } catch (Exception e){
              System.out.println("Error: " + e.getMessage());
        }
        return false;
    }
    
    public boolean update(Dokter dokter){
        String sql = "UPDATE Dokter SET nama=?,alamat=?,spesialis=?,umur=? "
                + "WHERE iddokter=?";
        try{
            PreparedStatement statment = connection.prepareStatement(sql);
            statment.setString(1, dokter.getNama());
            statment.setString(2, dokter.getAlamat());
            statment.setString(3, dokter.getSpesialis());
            statment.setString(4, dokter.getUmur());
            statment.setString(5, dokter.getIdDokter());
            int result = statment.executeUpdate();
            return result > 0;
        } catch (Exception e){
              System.out.println("Error: " + e.getMessage());
        }
        return false;
    }
    
    public boolean delete(String id){
        String sql = "DELETE FROM Dokter WHERE iddokter=?";
        try{
            PreparedStatement statment = connection.prepareStatement(sql);
            statment.setString(1, id);
            int result = statment.executeUpdate();
            return result > 0;
        } catch (Exception e){
              System.out.println("Error: " + e.getMessage());
        }
        return false;
    }
}
