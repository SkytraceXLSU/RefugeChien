/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.skytracex.refugechien.DAO;

import be.skytracex.refugechien.Constructeur.Chien;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Pc
 */
public class DAO_CHIEN extends DAO<Chien, Integer> {
////////////////////////////////////////    
////////         CREATE       //////////
////////////////////////////////////////     

    @Override
    public Chien Create(Chien obj) throws SQLException {
        ResultSet rs;
        int pk;
        String query = "INSERT INTO CHIEN(Nom_Chien, Date_Chien, Sex_Chien, "
                + "Race_Chien, Steril_Chien, Date_Entre_Chien, "
                + "ID_Proprio_Chien, ID_Refuge_Chien) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

        ps.setString(1, obj.getNom_Chien());
        ps.setDate(2, (Date.valueOf(obj.getDate_Chien())));
        ps.setString(3, obj.getSex_Chien());
        ps.setString(4, obj.getRace_Chien());
        ps.setBoolean(5, (obj.isSteril_Chien()));
        ps.setDate(6, (Date.valueOf(obj.getDate_Entre_Chien())));
        ps.setInt(7, obj.getID_Proprio_Chien());
        ps.setInt(8, obj.getID_Refuge_Chien());
        try {
            ps.executeUpdate();
        } catch (SQLException sQLException) {
            sQLException.printStackTrace();
        }
        rs = ps.getGeneratedKeys();
        rs.next();
        pk = rs.getInt(1);

        JOptionPane.showMessageDialog(null,
                "Chien à été créé avec succès\n  ID_Chien : " + pk + obj);
        return FindByID(pk);
    }
////////////////////////////////////////    
////////         UPDATE       //////////
////////////////////////////////////////  

    @Override
    public Chien Update(Chien obj) throws SQLException {
        String strSQL = "UPDATE CHIEN "
                + "SET Nom_Chien = ?,"
                + "Date_Chien = ?,"
                + "Sex_Chien = ?,"
                + "Race_Chien = ?,"
                + "Steril_Chien = ?,"
                + "Date_Entre_Chien = ?,"
                + "Date_Sortie_Chien = ?,"
                + "ID_Proprio_Chien = ?,"
                + "ID_Refuge_Chien = ? "
                + "WHERE ID_Chien = ? ;";

        PreparedStatement ps = null;

        ps = conn.prepareStatement(strSQL);

        ps.setString(1, obj.getNom_Chien());
        ps.setDate(2, (Date.valueOf(obj.getDate_Chien())));
        ps.setString(3, obj.getSex_Chien());
        ps.setString(4, obj.getRace_Chien());
        ps.setBoolean(5, (obj.isSteril_Chien()));
        ps.setObject(6, (obj.getDate_Entre_Chien()));
        ps.setObject(7, (obj.getDate_Sortie_Chien()));
        ps.setInt(8, obj.getID_Proprio_Chien());
        ps.setInt(9, obj.getID_Refuge_Chien());
        ps.setInt(10, obj.getID_Chien());

        try {
            ps.executeUpdate();
        } catch (SQLException sQLException) {
            sQLException.getMessage();
            sQLException.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, "Le Chien à été mis à jour avec succès \n  " + obj);
        return FindByID(obj.getID_Chien());
    }

    @Override
    public Chien UpdateSANSdateSortie(Chien obj) throws SQLException {
        String strSQL = "UPDATE CHIEN "
                + "SET Nom_Chien = ?,"
                + "Date_Chien = ?,"
                + "Sex_Chien = ?,"
                + "Race_Chien = ?,"
                + "Steril_Chien = ?,"
                + "Date_Entre_Chien = ?,"
                + "ID_Proprio_Chien = ?,"
                + "ID_Refuge_Chien = ? "
                + "WHERE ID_Chien = ? ;";

        PreparedStatement ps = null;

        ps = conn.prepareStatement(strSQL);

        ps.setString(1, obj.getNom_Chien());
        ps.setDate(2, (Date.valueOf(obj.getDate_Chien())));
        ps.setString(3, obj.getSex_Chien());
        ps.setString(4, obj.getRace_Chien());
        ps.setBoolean(5, (obj.isSteril_Chien()));
        ps.setDate(6, (Date.valueOf(obj.getDate_Entre_Chien())));
        ps.setInt(7, obj.getID_Proprio_Chien());
        ps.setInt(8, obj.getID_Refuge_Chien());
        ps.setInt(9, obj.getID_Chien());

        try {
            ps.executeUpdate();
        } catch (SQLException sQLException) {
            sQLException.getMessage();
            sQLException.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, "Chien mis à jour \n " + obj + "\nLe Chien à été mis à jour avec succès");
        return FindByID(obj.getID_Chien());
    }
////////////////////////////////////////    
////////      FIND BY ID      //////////
////////////////////////////////////////  

    @Override
    public Chien FindByID(Integer id) throws SQLException {
        String req = "SELECT * FROM chien WHERE ID_Chien = ?;";
        ResultSet rs;

        PreparedStatement ps = conn.prepareStatement(req);
        ps.setInt(1, id);

        rs = ps.executeQuery();
        rs.next();
        return RsToObj(rs);
    }

    @Override
    public Chien FindByName(String Name) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
////////////////////////////////////////    
////////      FIND ALL      //////////
//////////////////////////////////////// 

    @Override
    public Chien[] FindALL() throws SQLException {
        String strSQL = "SELECT * FROM CHIEN ;";
        ResultSet rs = null;
        ArrayList<Chien> listeChien = new ArrayList<>();

        PreparedStatement ps = conn.prepareStatement(strSQL);
        rs = ps.executeQuery();
        while (rs.next()) {
            listeChien.add(RsToObj(rs));
        }

        return listeChien.toArray(Chien[]::new);
    }

////////////////////////////////////////    
////////      FIND ALL RS     //////////
////////////////////////////////////////
    @Override
    public ResultSet FindAllRs() throws SQLException {
        String strSQL = "SELECT * FROM CHIEN ;";
        ResultSet rs = null;
        PreparedStatement ps = null;

        ps = conn.prepareStatement(strSQL);
        rs = ps.executeQuery();

        return rs;
    }

    @Override
    public Chien RsToObj(ResultSet rs) throws SQLException {

        Chien ch = new Chien(rs.getInt(1),
                rs.getString(2),
                rs.getDate(3).toLocalDate(),
                rs.getString(4),
                rs.getString(5),
                rs.getBoolean(6),
                rs.getDate(7).toLocalDate(),
                null, //rs.getDate(8).toLocalDate(),
                rs.getInt(9),
                rs.getInt(10));

        Date dateSortie = rs.getDate(8);
        if (dateSortie != null) {
            ch.setDate_Sortie_Chien(dateSortie.toLocalDate());
        }
        return ch;
    }
////////////////////////////////////////    
////////      INNER JOIN      //////////
////////////////////////////////////////  

    @Override
    public ResultSet InnerJoin() throws SQLException {
        String strSQL = "SELECT chien.Nom_Chien ,refuge.Nom_Refuge,chien.Date_Chien, proprio.nom_proprio, chien.Date_Sortie_chien FROM Chien INNER JOIN Refuge ON Chien.ID_Refuge_chien = refuge.ID_Refuge INNER JOIN Proprio ON Chien.ID_Proprio_chien = proprio.ID_proprio;";
        ResultSet rs = null;
        PreparedStatement ps = null;

        ps = conn.prepareStatement(strSQL);
        rs = ps.executeQuery();
        return rs;
    }
////////////////////////////////////////    
////////      CHERCHE NAME      //////////
//////////////////////////////////////// 

    @Override
    public List<Chien> findByName(String name) throws SQLException {
        List<Chien> chiens = new ArrayList<>();
        String sql = "SELECT * FROM CHIEN WHERE Nom_Chien like ?;";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, "%" + name + "%");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            LocalDate dateDeNaissance = rs.getDate(3) != null ? rs.getDate(3).toLocalDate() : null;
            LocalDate dateSortie = rs.getDate(8) != null ? rs.getDate(8).toLocalDate() : null;

            Chien chien = new Chien(rs.getInt(1),
                    rs.getString(2),
                    dateDeNaissance,
                    rs.getString(4),
                    rs.getString(5),
                    rs.getBoolean(6),
                    rs.getDate(7) != null ? rs.getDate(7).toLocalDate() : null,
                    dateSortie,
                    rs.getInt(9),
                    rs.getInt(10));

            chiens.add(chien);

        }
        return chiens;

    }
////////////////////////////////////////    
////////      RECHERCHE RACE      //////////
//////////////////////////////////////// 

    @Override
    public List<Chien> findByRace(String Race) throws SQLException {
        List<Chien> chiens = new ArrayList<>();
        String sql = "SELECT * FROM CHIEN WHERE Race_Chien like ?;";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, "%" + Race + "%");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            LocalDate dateDeNaissance = rs.getDate(3) != null ? rs.getDate(3).toLocalDate() : null;
            LocalDate dateSortie = rs.getDate(8) != null ? rs.getDate(8).toLocalDate() : null;

            Chien chien = new Chien(rs.getInt(1),
                    rs.getString(2),
                    dateDeNaissance,
                    rs.getString(4),
                    rs.getString(5),
                    rs.getBoolean(6),
                    rs.getDate(7) != null ? rs.getDate(7).toLocalDate() : null,
                    dateSortie,
                    rs.getInt(9),
                    rs.getInt(10));

            chiens.add(chien);

        }
        return chiens;
    }

    @Override
    public ResultSet InnerJoin2() throws SQLException {
        String strSQL = "SELECT Id_Chien, Nom_Chien, Date_Chien, Sex_Chien, Race_Chien, Steril_Chien, Date_Entre_Chien, Date_Sortie_Chien, refuge.Nom_Refuge, proprio.nom_proprio "
                + "      FROM Chien "
                + "      INNER JOIN Refuge ON Chien.ID_Refuge_chien = refuge.ID_Refuge "
                + "      INNER JOIN Proprio ON Chien.ID_Proprio_chien = proprio.ID_proprio;";
        ResultSet rs = null;
        PreparedStatement ps = null;

        ps = conn.prepareStatement(strSQL);
        rs = ps.executeQuery();
        return rs;
    }

/////////////////////////////////////////////////////////////    
/////////////////////////////////////////////////////////////  
/////////             NOT USE            //////////////////// 
/////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////     
    @Override
    public Chien[] Find_Refuge_Name() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Chien[] Find_Proprio_Name() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Chien PROPRIO_Name(ResultSet Name2) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Chien Refuge_Name(ResultSet Name) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Chien> findByName_Refuge(String name) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Chien> findByName_Proprio(String name) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Chien> findByAdresse_Refuge(String adresse) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Chien> findByAdresse_Proprio(String adresse) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
