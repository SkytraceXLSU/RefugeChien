/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.skytracex.refugechien;

import be.skytracex.refugechien.Constructeur.Chien;
import be.skytracex.refugechien.Constructeur.Proprio;
import be.skytracex.refugechien.Constructeur.Refuge;
import be.skytracex.refugechien.DAO.DAO;
import be.skytracex.refugechien.DAO.DAO_CHIEN;
import be.skytracex.refugechien.DAO.DAO_PROPRIO;
import be.skytracex.refugechien.DAO.DAO_REFUGE;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pc
 */
public class Controller {

    protected DAO<Chien, Integer> daoChien = new DAO_CHIEN();
    //private final DAO<Chien , String> daoChien_String = new DAO_CHIEN_STRING();
    protected final DAO<Refuge, Integer> daoRefuge = new DAO_REFUGE();
    protected final DAO<Proprio, Integer> daoProprio = new DAO_PROPRIO();

    //CHIEN
    public Chien AddChien(Chien c) throws SQLException {
        try {
            return daoChien.Create(c);

        } catch (SQLException sQLException) {
        }
        return null;
    }

    public Chien MajChien(Chien c) throws SQLException {
        try {
            return daoChien.Update(c);

        } catch (SQLException sQLException) {
        }
        return null;
    }

    public Chien MajChien2(Chien c) throws SQLException {
        try {
            return daoChien.UpdateSANSdateSortie(c);

        } catch (SQLException sQLException) {
        }
        return null;

    }

    public ResultSet GetAllChien() {
        try {
            return daoChien.FindAllRs();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Chien GetChien(Integer id) {
        try {
            return daoChien.FindByID(id);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Chien getChien(String name) {
        try {
            List<Chien> chiens = daoChien.findByName(name);
            if (!chiens.isEmpty()) {
                return chiens.get(0);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Chien> getChiensByName(String name) {
        try {
            return daoChien.findByName(name);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Chien> getChiensByRace(String race) {
        try {
            return daoChien.findByRace(race);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    // REFUGE
    public Refuge MajRefuge(Refuge r) throws SQLException {
        try {
            return daoRefuge.Update(r);

        } catch (SQLException sQLException) {
        }
        return null;
    }

    public Refuge AddRefuge(Refuge r) {

        try {
            return daoRefuge.Create(r);

        } catch (SQLException sQLException) {
        }
        return null;
    }

    public Refuge GetRefuge(Integer id) {
        try {
            return daoRefuge.FindByID(id);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    List<Refuge> getRefugeByName(String name) throws SQLException {
        return daoRefuge.findByName_Refuge(name);
    }
    
    List<Refuge> getRefugeByAdresse(String adresse) throws SQLException {
        return daoRefuge.findByAdresse_Refuge(adresse);
        }
    //PROPRIO
    public Proprio AddProprio(Proprio p) {

        try {
            return daoProprio.Create(p);

        } catch (SQLException sQLException) {
        }
        return null;
    }

    public Proprio MajProprio(Proprio p) {
        try {
            return daoProprio.Update(p);

        } catch (SQLException sQLException) {
        }
        return null;
    }

    public Proprio GetProprio(Integer id) {
        try {
            return daoProprio.FindByID(id);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    List<Proprio> getProprioByName(String name) throws SQLException {
        return daoProprio.findByName_Proprio(name);
    }

    List<Proprio> getProprioByAdresse(String adresse) throws SQLException {
        return daoProprio.findByAdresse_Proprio(adresse);
    }





}
