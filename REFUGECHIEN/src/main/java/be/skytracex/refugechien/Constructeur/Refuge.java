/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.skytracex.refugechien.Constructeur;

/**
 *
 * @author Pc
 */
public class Refuge {

    private int ID;
    private String Nom;
    private String Adresse;
    private String NumTel;

    public Refuge(int ID, String Nom, String Adresse, String NumTel) {
        this.ID = ID;
        this.Nom = Nom;
        this.Adresse = Adresse;
        this.NumTel = NumTel;
    }

    public Refuge(String Nom, String Adresse, String NumTel) {
        this.Nom = Nom;
        this.Adresse = Adresse;
        this.NumTel = NumTel;
    }

    public Refuge(String Nom) {
        this.Nom = Nom;

    }

    public int getId() {
        return ID;
    }

    public String getNom() {
        return Nom;
    }

    public String getAdresse() {
        return Adresse;
    }

    public String getNumTel() {
        return NumTel;
    }

    public void setId(int ID) {
        this.ID = ID;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    public void setNumTel(String NumTel) {
        this.NumTel = NumTel;
    }


    @Override
    public String toString() {
        return 
                  "\n Nom : " + Nom
                + "\n Adresse : " + Adresse
                + "\n NumTel : " + NumTel;
    }

}
