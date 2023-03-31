/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.skytracex.refugechien.Constructeur;

/**
 *
 * @author Pc
 */
public class Proprio {
    private int IDProprio;
    private String NomProprio;
    private String AdresseProprio;
    
    public Proprio(int IDProprio, String NomProprio, String AdresseProprio) {
        this.IDProprio = IDProprio;
        this.NomProprio = NomProprio;
        this.AdresseProprio = AdresseProprio;
    }
    
    public Proprio(String NomProprio, String AdresseProprio) {
        this.NomProprio = NomProprio;
        this.AdresseProprio = AdresseProprio;
    }

    public Proprio(String NomProprio) {
        this.NomProprio = NomProprio;
    }
    
    public int getIdProprio() {
        return IDProprio;
    }
    
    public String getNomProprio() {
        return NomProprio;
    }
    
    public String getAdresseProprio() {
        return AdresseProprio;
    }
    
    public void setNomProprio(String NomProprio) {
        this.NomProprio = NomProprio;
    }
    
    public void setAdresseProprio(String AdresseProprio) {
        this.AdresseProprio = AdresseProprio;
    }

    @Override
    public String toString() {
        
        return  "\n  Nom : " + NomProprio +
                "\n  Adresse : " + AdresseProprio;
    }
    
    
   
}
