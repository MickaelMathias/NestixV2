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
            System.out.println("Probl�me dans la recherche de l'ID");
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
            System.out.println("Probl�me dans la recherche du nom");
        }
        return ma_variable_retour;
    }

    public static String[][] rechercheHuman(String requete){
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
                tabObj[i][0] = resultat.getString("human_lastname");
                tabObj[i][1] = resultat.getString("human_firstname");
                tabObj[i][2] = resultat.getString("human_sex");
                tabObj[i][3] = resultat.getString("human_dob");
                i++;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("Probl�me requete rechercheMedia");
        }
        return tabObj;
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
                tabObj[i][2] = resultat.getString("media_type");
                tabObj[i][3] = resultat.getString("media_year");
                tabObj[i][4] = resultat.getString("media_cover");
                tabObj[i][5] = resultat.getString("media_link");
                i++;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("Probl�me requete rechercheMedia");
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
            System.out.println("Probl�me requete rechercheFilm");
        }
        return tabObj;
    }

    public static String[][] rechercheChanson(String requete){
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
                tabObj[i][0] = resultat.getString("song_album");
                i++;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("Probl�me requete rechercheChanson");
        }
        return tabObj;
    }

    public static String[][] rechercheLivre(String requete){
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
                tabObj[i][0] = resultat.getString("ISBN");
                tabObj[i][1] = resultat.getString("book_synop");
                tabObj[i][2] = resultat.getString("book_tome");
                tabObj[i][3] = resultat.getString("book_saga");
                i++;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("Probl�me requete rechercheLivre");
        }
        return tabObj;
    }
    public static String[][] rechercheArtiste(String requete){
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
                tabObj[i][0] = resultat.getString("artist_dod");
                tabObj[i][1] = resultat.getString("artist_nickname");
                i++;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("Probl�me requete rechercheLivre");
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
        while(resultat.next())
        {
            tabObj[i][0] = resultat.getString("media_id");
            tabObj[i][1] = resultat.getString("media_title");
            tabObj[i][2] = resultat.getString("media_year");
            
            if(resultat.getString("media_type").equals("Film"))
                tabObj[i][3] = getFirstRealisateur(resultat.getInt("media_id"));
            
            tabObj[i][4] = "" + getAsvMedia(resultat.getInt("media_id"));
            i++;
        }
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("Probleme requete rechercheMediaPourAffichage");
        }
        return tabObj;
    }

    public static String[][] rechercheHumanPourAffichage(String requete){
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
                tabObj[i][0] = resultat.getString("human_id");
                tabObj[i][1] = resultat.getString("human_lastname");
                tabObj[i][2] = resultat.getString("human_firstname");
                tabObj[i][3] = resultat.getString("human_dob");
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

    public static int[] rechercheIdsCaracteristiqueArtiste(String champ, String table, int human_id){
        int[] tabObj = null;
        String requete = "SELECT "+champ+"."+champ+"_id FROM "+champ+" join "+table+" ON "+champ+"."+champ+"_id="+table+"."+champ+"_id "+
        "WHERE human_id IN ( SELECT "+table+".human_id from "+table+" JOIN human ON human.human_id="+table+".human_id WHERE human.human_id="+human_id+")";
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

    public static int[] rechercheIdsGroupe(int media_id){
        int[] tabObj = null;
        String requete = "SELECT play.band_id FROM play join song ON play.song_id=song.song_id WHERE song.song_id IN ( SELECT media.media_id from media JOIN song ON media.media_id=song.song_id WHERE media.media_id="+media_id+")";
        
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

    public static int[] rechercheIdsGroupeArtiste(int human_id){
        int[] tabObj = null;
        
        String requete = "SELECT composed_by.band_id FROM composed_by join human ON composed_by.human_id=human.human_id WHERE composed_by.human_id IN ( SELECT human.human_id from human JOIN composed_by ON human.human_id = composed_by.human_id WHERE human.human_id="+human_id+")";
        
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

    public static int getAsvMedia(int idMedia){
        ResultSet resultat = ex_Query("SELECT asv_id FROM status WHERE media_id=" + idMedia);
        int asvId = 0;
        try{ 
        while(resultat.next())
            {
        		asvId = resultat.getInt("asv_id");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("Probleme requete getAsvMedia");
        }
        return asvId;
    }
    
    public static String getFirstRealisateur(int idMedia){
        ResultSet resultat = ex_Query("SELECT artist_nickname FROM artist WHERE human_id IN (SELECT human_id FROM take_part_in WHERE work_id=4 AND media_id=" + idMedia + ")");
        String realisateur = "";
        try{ 
        	resultat.next();
            realisateur = resultat.getString("artist_nickname");
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("Probleme requete getFirstRealisateur");
        }
        System.out.println(realisateur);
        return realisateur;
    }


    
}