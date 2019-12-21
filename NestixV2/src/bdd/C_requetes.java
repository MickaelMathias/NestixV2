package bdd;

import javax.swing.*;
import java.sql.*;

public class C_requetes extends C_connexion{

    public void rechercheValeursComboBox(String requete, String ligne, JComboBox comboBox){
          
        try{
        ResultSet resultat = ex_Query(requete);  
        resultat.last();      
        String [] mes_valeurs = new String[resultat.getRow()+1];
        resultat.beforeFirst();
        mes_valeurs[0] = "Choisissez";
        int i = 1;
        while(resultat.next()){
            mes_valeurs[i] = resultat.getString(ligne);
            i+=1;}
            comboBox.setModel(new DefaultComboBoxModel<>(mes_valeurs));
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static int rechercheId(String requete){

        String ma_requete = requete;
        int ma_variable_retour = 0;
        try {
        ResultSet resultat_requete = ex_Query(ma_requete); 
        resultat_requete.next();
            ma_variable_retour = resultat_requete.getInt(1);
        }
        catch (SQLException e){
            ma_variable_retour = -1;
            System.out.println("Problème dans la recherche de l'ID");
        }
        return ma_variable_retour;
    }

    public static String rechercheNom(String requete){

        String ma_requete = requete;
        String ma_variable_retour = "";
        try {
        ResultSet resultat_requete = ex_Query(ma_requete); 
        resultat_requete.next();
            ma_variable_retour = resultat_requete.getString(1);
        }
        catch (SQLException e){
            System.out.println("Problème dans la recherche du nom");
        }
        return ma_variable_retour;
    }

    
}