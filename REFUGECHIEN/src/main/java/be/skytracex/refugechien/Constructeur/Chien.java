/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.skytracex.refugechien.Constructeur;

import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author Pc
 */
public class Chien {

/**
 * CREATE TABLE CHIEN(
 * 
	ID_Chien int UNSIGNED NOT NULL PRIMARY KEY,
      //Photo_Chien BLOB,
	Nom_Chien varchar(30) NOT NULL,
	Date_Chien date NOT NULL,
	Sex_Chien char NOT NULL,
	Race_Chien varchar(30) NOT NULL,
	Steril_Chien boolean NOT NULL,
	Date_Entre_Chien date NOT NULL,
	Date_Sortie_Chien date DEFAULT NULL,
	ID_Proprio_Chien int UNSIGNED DEFAULT NULL,
	ID_Refuge_Chien int UNSIGNED NOT NULL
 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
*
* 
**/
    
    // ATTRIB
    private int ID_Chien ;
    private String Nom_Chien;
    private LocalDate Date_Chien;
    private String Sex_Chien;
    private String Race_Chien;
    private boolean Steril_Chien;
    private LocalDate Date_Entre_Chien;
    private LocalDate Date_Sortie_Chien;
    private int ID_Proprio_Chien;
    private int ID_Refuge_Chien;
    //CONSTRUCTEUR
                    // CONSTRUCTEUR COMPLET
    public Chien(int ID_Chien, String Nom_Chien, LocalDate Date_Chien, String Sex_Chien, String Race_Chien, Boolean Steril_Chien, LocalDate Date_Entre_Chien, LocalDate Date_Sortie_Chien, int ID_Proprio_Chien, int ID_Refuge_Chien) throws SQLException{
        this.ID_Chien = ID_Chien;
        this.Nom_Chien = Nom_Chien;
        this.Date_Chien = Date_Chien;
        this.Sex_Chien = Sex_Chien;
        this.Race_Chien = Race_Chien;
        this.Steril_Chien = Steril_Chien;
        this.Date_Entre_Chien = Date_Entre_Chien;
        this.Date_Sortie_Chien = Date_Sortie_Chien;
        this.ID_Proprio_Chien = ID_Proprio_Chien;
        this.ID_Refuge_Chien = ID_Refuge_Chien;
    }
                    // CONSTRUCTEUR - ID_CHIEN
    public Chien(String Nom_Chien, LocalDate Date_Chien, String Sex_Chien, String Race_Chien, Boolean Steril_Chien, LocalDate Date_Entre_Chien, LocalDate Date_Sortie_Chien, int ID_Proprio_Chien, int ID_Refuge_Chien) {

        this.Nom_Chien = Nom_Chien;
        this.Date_Chien = Date_Chien;
        this.Sex_Chien = Sex_Chien;
        this.Race_Chien = Race_Chien;
        this.Steril_Chien = Steril_Chien;
        this.Date_Entre_Chien = Date_Entre_Chien;
        this.Date_Sortie_Chien = Date_Sortie_Chien;
        this.ID_Proprio_Chien = ID_Proprio_Chien;
        this.ID_Refuge_Chien = ID_Refuge_Chien;
    }
                    // CONSTRUCTEUR - ID_CHIEN - DATE_SORTIE
    public Chien(String Nom_Chien, LocalDate Date_Chien, String Sex_Chien, String Race_Chien, Boolean Steril_Chien, LocalDate Date_Entre_Chien, int ID_Proprio_Chien, int ID_Refuge_Chien) {
        this.Nom_Chien = Nom_Chien;
        this.Date_Chien = Date_Chien;
        this.Sex_Chien = Sex_Chien;
        this.Race_Chien = Race_Chien;
        this.Steril_Chien = Steril_Chien;
        this.Date_Entre_Chien = Date_Entre_Chien;
        this.ID_Proprio_Chien = ID_Proprio_Chien;
        this.ID_Refuge_Chien = ID_Refuge_Chien;
    }    
                    // CONSTRUCTEUR - DATE_SORTIE
    public Chien(int ID_Chien, String Nom_Chien, LocalDate Date_Chien, String Sex_Chien, String Race_Chien, Boolean Steril_Chien, LocalDate Date_Entre_Chien, int ID_Proprio_Chien, int ID_Refuge_Chien) {
        this.ID_Chien = ID_Chien;
        this.Nom_Chien = Nom_Chien;
        this.Date_Chien = Date_Chien;
        this.Sex_Chien = Sex_Chien;
        this.Race_Chien = Race_Chien;
        this.Steril_Chien = Steril_Chien;
        this.Date_Entre_Chien = Date_Entre_Chien;
        this.ID_Proprio_Chien = ID_Proprio_Chien;
        this.ID_Refuge_Chien = ID_Refuge_Chien;
    }

    public Chien(String Nom_Chien) {
        this.Nom_Chien = Nom_Chien;
    }
    
    public Chien() {

    }
    //GETSET

    public int getID_Chien() {
        return ID_Chien;
    }

    public String getNom_Chien() {
        return Nom_Chien;
    }

    public void setNom_Chien(String Nom_Chien) {
        this.Nom_Chien = Nom_Chien;
    }

    public LocalDate getDate_Chien() {
        return Date_Chien;
    }

    public void setDate_Chien(LocalDate Date_Chien) {
        this.Date_Chien = Date_Chien;
    }

    public String getSex_Chien() {
        return Sex_Chien;
    }

    public void setSex_Chien(String Sex_Chien) {
        this.Sex_Chien = Sex_Chien;
    }

    public String getRace_Chien() {
        return Race_Chien;
    }

    public void setRace_Chien(String Race_Chien) {
        this.Race_Chien = Race_Chien;
    }

    public boolean isSteril_Chien() {
        return Steril_Chien;
    }

    public void setSteril_Chien(boolean Steril_Chien) {
        this.Steril_Chien = Steril_Chien;
    }


    public LocalDate getDate_Entre_Chien() {
        return Date_Entre_Chien;
    }

    public void setDate_Entre_Chien(LocalDate Date_Entre_Chien) {
        this.Date_Entre_Chien = Date_Entre_Chien;
    }

    public LocalDate getDate_Sortie_Chien() {
        return Date_Sortie_Chien;
    }

    public void setDate_Sortie_Chien(LocalDate Date_Sortie_Chien) {
        this.Date_Sortie_Chien = Date_Sortie_Chien;
    }

    public int getID_Proprio_Chien() {
        return ID_Proprio_Chien;
    }

    public void setID_Proprio_Chien(int ID_Proprio_Chien) {
        this.ID_Proprio_Chien = ID_Proprio_Chien;
    }

    public int getID_Refuge_Chien() {
        return ID_Refuge_Chien;
    }

    public void setID_Refuge_Chien(int ID_Refuge_Chien) {
        this.ID_Refuge_Chien = ID_Refuge_Chien;
    }

    /*    public BufferedImage getPhoto_Chien() {
    return Photo_Chien;
    }*/
    
    
    
    //TOSTRING + OVERRIDE

    @Override
    public String toString() {
        return  

                "\n  Nom : " + Nom_Chien +
                "\n  Date de naissance : " + Date_Chien +
                "\n  Sexe : " + Sex_Chien +
                "\n  Race : " + Race_Chien +
                "\n  Stérilisé : " + Steril_Chien +
                "\n  Date d'Entré : " + Date_Entre_Chien +
                "\n  Date de Sortie : " + Date_Sortie_Chien +
                "\n  ID_Refuge : " + ID_Refuge_Chien +
                "\n  ID_Proprio : " + ID_Proprio_Chien ;
    }
    
}
