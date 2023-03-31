/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.skytracex.refugechien.DAO;

import be.skytracex.refugechien.Constructeur.Chien;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Pc
 */
public abstract class DAO <T,K> {
    
        public Connection conn = DAOFactory.GetConnection(); 
    // INITIALISER PLUS TARD DANS DAOFACTORY 
    
    
    //CREATE , UPDATE 
    //DELETE , DELETEBYID 
    //FINDBYNAME , FINDALL 
    
    
//REQUETTE DE TABLE
    public abstract T Create(T obj)throws SQLException;
    public abstract T Update(T obj)throws SQLException;
    public abstract T UpdateSANSdateSortie(T obj)throws SQLException;
    public abstract T FindByID(Integer id)throws SQLException; 
    public abstract T FindByName(String Name)throws SQLException;
    public abstract T[] FindALL()throws SQLException;
    public abstract ResultSet FindAllRs()throws SQLException;//AFFICHAGE DANS LE JTABLE
    public abstract T RsToObj(ResultSet rs)throws SQLException; // TRANSFORME EN OBJ   
    public abstract ResultSet InnerJoin()throws SQLException;
    public abstract ResultSet InnerJoin2()throws SQLException;
    
    public abstract T PROPRIO_Name(ResultSet Name2)throws SQLException;
    public abstract T Refuge_Name(ResultSet Name)throws SQLException;
    
    
    public abstract List<T> findByName(String name) throws SQLException;
    public abstract List<T> findByRace(String Race) throws SQLException;
    public abstract List<T> findByName_Refuge(String name) throws SQLException;
    public abstract List<T> findByName_Proprio(String name) throws SQLException;
    public abstract List<T> findByAdresse_Refuge(String adresse) throws SQLException;
    public abstract List<T> findByAdresse_Proprio(String adresse) throws SQLException;
    public abstract T[] Find_Refuge_Name()throws SQLException;
    public abstract T[] Find_Proprio_Name()throws SQLException;
}
