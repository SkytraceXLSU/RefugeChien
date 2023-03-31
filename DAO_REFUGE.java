/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.skytracex.refugechien.DAO;

import be.skytracex.refugechien.Constructeur.Refuge;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Pc
 */
public class DAO_REFUGE extends DAO<Refuge,Integer>{

    @Override
    public Refuge Create(Refuge obj) throws SQLException {
        ResultSet rs;
        int pk;
        String query = "INSERT INTO REFUGE(Nom_Refuge, Adresse_Refuge, Num_Tel_Refuge)"
                     + "VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

        ps.setString(1, obj.getNom());
        ps.setString(2, (obj.getAdresse()));
        ps.setString(3, obj.getNumTel());
        
        try {
            ps.executeUpdate();
        } catch (SQLException sQLException) {
            sQLException.printStackTrace();
        }
        rs = ps.getGeneratedKeys();
        rs.next();
        pk = rs.getInt(1);
        System.out.println("Nouvelle clé : " + pk);
        JOptionPane.showMessageDialog(null,
                "Refuge créé avec succès\n  ID_Refuge : " + pk + obj);
        return FindByID(pk);
    }
////////////////////////////////////////    
////////         UPDATE       //////////
//////////////////////////////////////// 
    @Override
    public Refuge Update(Refuge obj) throws SQLException {
        String strSQL = "UPDATE REFUGE "
                + "SET Nom_Refuge = ?,"
                + "Adresse_Refuge = ?,"
                + "Num_Tel_Refuge = ? "
                + "WHERE ID_Refuge = ? ;";

        PreparedStatement ps = null;

        ps = conn.prepareStatement(strSQL);

        ps.setString(1, obj.getNom());
        ps.setString(2, obj.getAdresse());
        ps.setString(3, obj.getNumTel());
        ps.setInt(4, (obj.getId()));

        try {
            ps.executeUpdate();
        } catch (SQLException sQLException) {
            sQLException.getMessage();
            sQLException.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, "Le Refuge à été mis à jour avec succès \n  " + obj);
        return FindByID(obj.getId());
    }

    @Override
    public Refuge FindByID(Integer id) throws SQLException {
        String req = "SELECT * FROM REFUGE WHERE ID_Refuge = ?;";
        ResultSet rs;

        PreparedStatement ps = conn.prepareStatement (req);
        ps.setInt(1, id);
          
        rs = ps.executeQuery();
        rs.next();
        return RsToObj(rs);
    }

    @Override
    public Refuge[] FindALL() throws SQLException {
        String strSQL  = "SELECT * FROM REFUGE ;";
        ResultSet rs = null;
        ArrayList<Refuge> listeRefuge = new ArrayList<>();

            PreparedStatement ps = conn.prepareStatement(strSQL);
            rs = ps.executeQuery();
            while(rs.next()) {
                listeRefuge.add(RsToObj(rs));
            }
            
        return listeRefuge.toArray(Refuge[]::new);
    }

    @Override
    public ResultSet FindAllRs() throws SQLException {
        String strSQL = "SELECT * FROM REFUGE ;";
        ResultSet rs = null;
        PreparedStatement ps = null ;

        ps = conn.prepareStatement(strSQL);
        rs = ps.executeQuery();
        

       return rs; 
    }

    @Override
    public Refuge RsToObj(ResultSet rs) throws SQLException {

                Refuge re = null;
            
             re = new Refuge(rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4));
             
        return re; 
    }


   
/////////////////////////////////////////////////////////////    
/////////////////////////////////////////////////////////////  
/////////             NOT USE            //////////////////// 
/////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////    
    @Override
    public Refuge UpdateSANSdateSortie(Refuge obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ResultSet InnerJoin() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public Refuge FindByName(String Name) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Refuge[] Find_Refuge_Name() throws SQLException {
            String strSQL  = "SELECT Nom_Refuge FROM REFUGE ;";
        ResultSet rs = null;
        ArrayList<Refuge> listeRefugeName = new ArrayList<>();


            PreparedStatement ps = conn.prepareStatement(strSQL);
            rs = ps.executeQuery();
            while(rs.next()) {
                listeRefugeName.add(Refuge_Name(rs));
            }


        return listeRefugeName.toArray(Refuge[]::new);    }

    @Override
    public Refuge[] Find_Proprio_Name() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Refuge PROPRIO_Name(ResultSet Name2) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Refuge Refuge_Name(ResultSet Name) throws SQLException {
                Refuge re = null;
            
             re = new Refuge(Name.getString(1));
             
        return re;  
    }

    @Override
    public List<Refuge> findByName(String name) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Refuge> findByRace(String Race) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ResultSet InnerJoin2() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Refuge> findByName_Refuge(String name) throws SQLException {
        List<Refuge> refuges = new ArrayList<>();
        String sql = "SELECT * FROM REFUGE WHERE Nom_Refuge LIKE ?;";
        
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, "%" + name + "%");
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()){
            Refuge refuge = new Refuge(rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4));
            refuges.add(refuge);
        }
        return refuges;
    }

    @Override
    public List<Refuge> findByName_Proprio(String name) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Refuge> findByAdresse_Refuge(String adresse) throws SQLException {
        List<Refuge> refuges = new ArrayList<>();
        String sql = "SELECT * FROM REFUGE WHERE Adresse_Refuge LIKE ?;";
        
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, "%" + adresse + "%");
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()){
            Refuge refuge = new Refuge(rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4));
            refuges.add(refuge);
        }
        return refuges;
    }

    @Override
    public List<Refuge> findByAdresse_Proprio(String adresse) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
