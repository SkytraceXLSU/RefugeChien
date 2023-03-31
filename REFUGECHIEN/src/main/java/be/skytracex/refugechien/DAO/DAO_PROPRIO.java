/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.skytracex.refugechien.DAO;

import be.skytracex.refugechien.Constructeur.Proprio;
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
public class DAO_PROPRIO extends DAO<Proprio,Integer>{

    @Override
    public Proprio Create(Proprio obj) throws SQLException {
        ResultSet rs;
        int pk;
        String query = "INSERT INTO PROPRIO(Nom_Proprio, Adresse_Proprio)"
                     + "VALUES (?,?)";
        PreparedStatement ps = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

        ps.setString(1, obj.getNomProprio());
        ps.setString(2, (obj.getAdresseProprio()));

        
        try {
            ps.executeUpdate();
        } catch (SQLException sQLException) {
            sQLException.printStackTrace();
        }
        rs = ps.getGeneratedKeys();
        rs.next();
        pk = rs.getInt(1);
        JOptionPane.showMessageDialog(null,
        "Proprio à été créé avec succès : \n " +obj);
        return FindByID(pk); 
    }

    @Override
    public Proprio Update(Proprio obj) throws SQLException {
        String strSQL = "UPDATE PROPRIO "
                       +"SET Nom_Proprio = ?,"
                       +"Adresse_Proprio = ? " 
                       +"WHERE ID_Proprio = ?;" ;
        
        PreparedStatement ps = null;
        ps=conn.prepareStatement(strSQL);
        
        ps.setString(1, obj.getNomProprio());
        ps.setString(2, obj.getAdresseProprio());
        ps.setInt(3, obj.getIdProprio());
        
        ps.executeUpdate();
        
        return FindByID(obj.getIdProprio());
        
    }



    @Override
    public Proprio FindByID(Integer id) throws SQLException {
        String req = "SELECT * FROM PROPRIO WHERE ID_Proprio = ?;";
        ResultSet rs;

        PreparedStatement ps = conn.prepareStatement (req);
        ps.setInt(1, id);
          
        rs = ps.executeQuery();
        rs.next();
        return RsToObj(rs);
    }

    @Override
    public Proprio FindByName(String Name) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Proprio[] FindALL() throws SQLException {
        String strSQL  = "SELECT * FROM PROPRIO ;";
        ResultSet rs = null;
        ArrayList<Proprio> listeProprio = new ArrayList<>();


            PreparedStatement ps = conn.prepareStatement(strSQL);
            rs = ps.executeQuery();
            while(rs.next()) {
                listeProprio.add(RsToObj(rs));
            }


        return listeProprio.toArray(Proprio[]::new); 
    }

    @Override
    public ResultSet FindAllRs() throws SQLException {
        String strSQL = "SELECT * FROM PROPRIO ;";
        ResultSet rs = null;
        PreparedStatement ps = null ;

        ps = conn.prepareStatement(strSQL);
        rs = ps.executeQuery();
        

       return rs;
    }

    @Override
    public Proprio RsToObj(ResultSet rs) throws SQLException {
                Proprio pr = null;
            
             pr = new Proprio(rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3));
             
        return pr;
    }

    @Override
    public ResultSet InnerJoin() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Proprio[] Find_Refuge_Name() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Proprio[] Find_Proprio_Name() throws SQLException {
            String strSQL  = "SELECT Nom_Proprio FROM PROPRIO; ";
        ResultSet rs = null;
        ArrayList<Proprio> listeProprioName = new ArrayList<>();


            PreparedStatement ps = conn.prepareStatement(strSQL);
            rs = ps.executeQuery();
            while(rs.next()) {
                listeProprioName.add(PROPRIO_Name(rs));
            }


        return listeProprioName.toArray(Proprio[]::new);
    }

    @Override
    public Proprio PROPRIO_Name(ResultSet Name2) throws SQLException {
                Proprio pro = null;
            
             pro = new Proprio(Name2.getString(1));
             
        return pro; 
    }

    @Override
    public Proprio Refuge_Name(ResultSet Name) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Proprio> findByName(String name) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Proprio> findByRace(String Race) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ResultSet InnerJoin2() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public Proprio UpdateSANSdateSortie(Proprio obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Proprio> findByName_Refuge(String name) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Proprio> findByName_Proprio(String name) throws SQLException {
        List<Proprio> proprios = new ArrayList<>();
        String sql = "SELECT * FROM PROPRIO WHERE Nom_Proprio LIKE ?;";
        
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, "%" + name + "%");
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()){
            Proprio proprio = new Proprio(rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3));
            proprios.add(proprio);
        }
        return proprios;
    }

    @Override
    public List<Proprio> findByAdresse_Refuge(String adresse) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Proprio> findByAdresse_Proprio(String adresse) throws SQLException {
        List<Proprio> proprios = new ArrayList<>();
        String sql = "SELECT * FROM PROPRIO WHERE Adresse_Proprio LIKE ?;";
        
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, "%" + adresse + "%");
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()){
            Proprio proprio = new Proprio(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3));
            proprios.add(proprio);
        }
        return proprios;
    }
    
}
