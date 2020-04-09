/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.app.npm451;

import com.app.npm451.model.Dokter;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author WORKGROUP
 */
public class Main {
    private DokterDataSource dataSource;
    
    public Main(){
        dataSource = new DokterDataSource();
    }
    
    public static void main(String[] args){
        new Main().testGetByID();
    }
    
    public void testGetAll(){
        List<Dokter> list = dataSource.getAll();
        for(Dokter dtr : list){
            System.out.println("Nama Dokter: " + dtr.getNama() + "Spesialis: "+dtr.getSpesialis());
        }
    }
    
    public void testGetByID(){
        Dokter dokter = dataSource.getByID("D00002");
        if(dokter != null){
            System.out.println("Nama Dokter: " + dokter.getNama() + "Spesialis: "+dokter.getSpesialis());
        }
    }
    
    public void testInsert(){
        Dokter dokter = new Dokter("D00004", "Aldi Kurnia", "DokterGigi", 
                "Cawang, Jakarta", "26");
        boolean hasil = dataSource.insert(dokter);
            System.out.println("Insert data Berhasil");
        }
}
