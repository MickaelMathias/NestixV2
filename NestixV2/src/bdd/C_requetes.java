package bdd;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

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

	public static String[][] rechercheMedia(String requete){
		String[][] tabObj = null;
        ResultSet resultat = ex_Query(requete);
        try{ 
        ResultSetMetaData rsmd = resultat.getMetaData();
        resultat.last();
        tabObj = new String[resultat.getRow()][rsmd.getColumnCount()];
        resultat.beforeFirst();
        int i = 0;
        while(resultat.next())
            {
                tabObj[i][0] = resultat.getString("media_id");
                tabObj[i][1] = resultat.getString("media_title");
                tabObj[i][2] = resultat.getString("media_year");
                tabObj[i][3] = resultat.getString("media_cover");
                tabObj[i][4] = resultat.getString("media_link");
                i++;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("Problème requete rechercheMedia");
        }
        return tabObj;
    }

    public static String[][] rechercheFilm(String requete){
		String[][] tabObj = null;
        ResultSet resultat = ex_Query(requete);
        try{ 
        ResultSetMetaData rsmd = resultat.getMetaData();
        resultat.last();
        tabObj = new String[resultat.getRow()][rsmd.getColumnCount()];
        resultat.beforeFirst();
        int i = 0;
        while(resultat.next())
            {
                tabObj[i][0] = resultat.getString("visa");
                tabObj[i][1] = resultat.getString("movie_runtime");
                tabObj[i][2] = resultat.getString("movie_trailer");
                tabObj[i][3] = resultat.getString("movie_synop");
                tabObj[i][4] = resultat.getString("movie_budget");
                tabObj[i][5] = resultat.getString("movie_saga");
                i++;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("Problème requete rechercheFilm");
        }
        return tabObj;
    }

    public static String[][] rechercheMediaPourAffichage(String requete){
		String[][] tabObj = null;
        ResultSet resultat = ex_Query(requete);
        try{ 
        ResultSetMetaData rsmd = resultat.getMetaData();
        resultat.last();
        tabObj = new String[resultat.getRow()][rsmd.getColumnCount()+1];
        resultat.beforeFirst();
        int i = 0;
        while(resultat.next())
            {
                tabObj[i][0] = resultat.getString("media_id");
                tabObj[i][1] = resultat.getString("media_title");
                tabObj[i][2] = resultat.getString("media_year");
                tabObj[i][3] = resultat.getString("media_cover");
                tabObj[i][4] = resultat.getString("media_link");
                i++;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("Probleme requete rechercheMediaPourAffichage");
        }
        return tabObj;
    }

    public static int[] rechercheIdsArtiste(String requete){
		int[] tabObj = null;
        ResultSet resultat = ex_Query(requete);
        try{ 
        resultat.last();
        tabObj = new int[resultat.getRow()];
        resultat.beforeFirst();
        int i = 0;
        while(resultat.next())
            {
                tabObj[i] = resultat.getInt("human_id");
                i++;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("Probleme requete rechercheIdsArtiste");
        }
        return tabObj;
    }

    public static int[] rechercheIdsCaracteristique(String champ, String table, int media_id){
        int[] tabObj = null;
        String requete = "SELECT "+champ+"."+champ+"_id FROM "+champ+" join "+table+" ON "+champ+"."+champ+"_id="+table+"."+champ+"_id "+
        "WHERE media_id IN ( SELECT "+table+".media_id from "+table+" JOIN media ON media.media_id="+table+".media_id WHERE media.media_id="+media_id+")";
        ResultSet resultat = ex_Query(requete);
        try{ 
        resultat.last();
        tabObj = new int[resultat.getRow()];
        resultat.beforeFirst();
        int i = 0;
        while(resultat.next())
            {
                tabObj[i] = resultat.getInt(1);
                i++;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("Probleme requete rechercheIdsCaracteristique");
        }
        return tabObj;
    }

    public static ArrayList<String> rechercheAnneesRecompenses(String requete){
        ArrayList<String> tabObj = null;
        ResultSet resultat = ex_Query(requete);
        try{ 
        resultat.last();
        tabObj = new ArrayList<>();
        resultat.beforeFirst();
        int i = 0;
        while(resultat.next())
            {
                if (resultat.getString("year") == null){
                    tabObj.add("");
                }
                else{
                    tabObj.add(resultat.getString("year"));}
                i++;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("Probleme requete rechercheIdsArtiste");
        }
        return tabObj;
    }



    
}