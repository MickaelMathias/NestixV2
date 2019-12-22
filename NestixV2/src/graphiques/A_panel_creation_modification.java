package graphiques;

import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import objets.C_CARACTERISTIQUES;
import objets.C_CEREMONIE;
import objets.C_GENRE;

abstract class A_panel_creation_modification extends JPanel{
    private static final long serialVersionUID = -2313359782920101526L;

    protected void ajouterElementList(JList list, String valeur) {
        DefaultListModel mon_model = (DefaultListModel)list.getModel();
        mon_model.addElement(valeur);
        list.setModel(mon_model);
    }

    protected void retirerElementList(JList list, int index){
        DefaultListModel<String> mon_model = (DefaultListModel)list.getModel();
        mon_model.remove(index);
        list.setModel(mon_model);
    }

    protected void afficherTabDansList(JList list, ArrayList<String> tab){
        DefaultListModel<String> mon_model = new DefaultListModel<>();
        for (int i = 0 ; i < tab.size() ; i++){
            mon_model.addElement(tab.get(i));
        }
        list.setModel(mon_model);
    }
    
    protected void reinitialiserList(JList list){
        DefaultListModel<String> mon_model = new DefaultListModel<>();
        for (int i = 0 ; i < list.getModel().getSize() ; i++){
            mon_model.remove(i);
        }
        list.setModel(mon_model);
    }

    protected void reinitialiserToutesList(ArrayList <JList> mes_list){
        for (int i = 0 ; i < mes_list.size() ; i++){
            reinitialiserList(mes_list.get(i));
        }
    }

    protected boolean verifierPresenceStringDansList(JList ma_list, JComboBox cb ){
        boolean flag = false;
        for (int i =0; i < ma_list.getModel().getSize(); i++){
            if (cb.getSelectedItem().toString().equals(ma_list.getModel().getElementAt(i).toString())){
                flag = true;
            }
        }
        return flag;
    }

    protected ArrayList<objets.C_ARTISTE> recupererTousArtistDeList(JList ma_list){
        ArrayList<objets.C_ARTISTE> mes_valeurs = new ArrayList<>();
        for (int i = 0; i < ma_list.getModel().getSize() ;i++){
            objets.C_ARTISTE mon_artiste = new objets.C_ARTISTE();
            mon_artiste.setArtiste_nickname(ma_list.getModel().getElementAt(i).toString());
            mon_artiste.recupererIdParNom();
            mes_valeurs.add(mon_artiste);
        }
        return mes_valeurs;
    }

    protected ArrayList<objets.C_GENRE> recupererTousGenreDeList(JList ma_list){
        ArrayList<objets.C_GENRE> mes_valeurs = new ArrayList<>();
        for (int i = 0; i < ma_list.getModel().getSize() ;i++){
            objets.C_GENRE mon_genre = new objets.C_GENRE();
            mon_genre.setGenre_nom(ma_list.getModel().getElementAt(i).toString());
            mon_genre.setGenre_id(mon_genre.recupererIdParNom("genre", mon_genre.getGenre_nom()));
            mes_valeurs.add(mon_genre);
        }
        return mes_valeurs;
    }

    protected ArrayList<objets.C_CEREMONIE> recupererTousCeremonieDeArrayList(ArrayList <String> liste_ceremonie){
        ArrayList<objets.C_CEREMONIE> mes_valeurs = new ArrayList<>();
        for (int i = 0; i < liste_ceremonie.size() ;i++){
            objets.C_CEREMONIE ma_ceremonie = new objets.C_CEREMONIE();
            ma_ceremonie.setCeremonie_nom(liste_ceremonie.get(i));
            ma_ceremonie.setCeremonie_id(ma_ceremonie.recupererIdParNom("ceremony", ma_ceremonie.getCeremonie_nom()));
            mes_valeurs.add(ma_ceremonie);
        }
        return mes_valeurs;
    }

    protected ArrayList<objets.C_AWARD> recupererTousAwardDeArrayList(ArrayList <String> liste_award){
        ArrayList<objets.C_AWARD> mes_valeurs = new ArrayList<>();
        for (int i = 0; i < liste_award.size() ;i++){
            objets.C_AWARD mon_award = new objets.C_AWARD();
            mon_award.setAward_nom(liste_award.get(i));
            mon_award.setAward_id(mon_award.recupererIdParNom("award", mon_award.getAward_nom()));
            mes_valeurs.add(mon_award);
        }
        return mes_valeurs;
    }

    protected ArrayList<String> recupererTousAnneeAwardDeArrayList(ArrayList <String> liste_annee_award){
        ArrayList<String> mes_valeurs = new ArrayList<>();
        for (int i = 0; i < liste_annee_award.size() ;i++){
            if (liste_annee_award.get(i).equals("")){
                mes_valeurs.add("NULL");
            }
            else{
                mes_valeurs.add(liste_annee_award.get(i));
            }
        }
        return mes_valeurs;
    }

    protected ArrayList<objets.C_TAG> recupererTousTagDeList(JList ma_list){
        ArrayList<objets.C_TAG> mes_valeurs = new ArrayList<>();
        for (int i = 0; i < ma_list.getModel().getSize() ;i++){
            objets.C_TAG mon_tag = new objets.C_TAG();
            mon_tag.setTag_nom(ma_list.getModel().getElementAt(i).toString());
            mon_tag.setTag_id(mon_tag.recupererIdParNom("tag", mon_tag.getTag_nom()));
            mes_valeurs.add(mon_tag);
        }
        return mes_valeurs;
    }

    protected Object[][] recupererToutesValeursTableau(JTable mon_tableau){
        Object[][] mes_donnees_de_base = new Object[mon_tableau.getRowCount()][mon_tableau.getColumnCount()];
        for (int i = 0; i < mon_tableau.getRowCount(); i++){
            for (int j = 0; j < mon_tableau.getColumnCount(); j++){
                mes_donnees_de_base[i][j] = mon_tableau.getValueAt(i,j);
            }
        }
        return mes_donnees_de_base;
    }

    protected ArrayList<String> recupererValeursColonneTableau(JTable mon_tableau, int colonne){
        System.out.println(mon_tableau.getRowCount());
        ArrayList<String> mes_donnees_de_base = new ArrayList<>();
        for (int i = 0; i < mon_tableau.getRowCount(); i++){
                if (mon_tableau.getValueAt(i,colonne).equals("")){
                    mes_donnees_de_base.add("NULL");
                }
                else{
                    mes_donnees_de_base.add(mon_tableau.getValueAt(i,colonne).toString());
                }
            }
        return mes_donnees_de_base;
    }

    protected void retirerElementDansTabRecompenses(JTable mon_tableau){
        ((DefaultTableModel)mon_tableau.getModel()).removeRow(mon_tableau.getSelectedRow());
    }

    protected void ajouterDonneesDansTabRecompenses(Object[][] mes_donnees, JTable mon_tableau){
        int nombre_ligne_mon_tableau = mon_tableau.getRowCount();
        Object[][] mes_donnees_de_base = recupererToutesValeursTableau(mon_tableau);
        Object[][] mes_donnees_a_ajouter = new Object[(nombre_ligne_mon_tableau+mes_donnees.length)][mon_tableau.getColumnCount()];
        for (int i = 0; i < nombre_ligne_mon_tableau + mes_donnees.length; i++){
            for (int j = 0 ; j < mon_tableau.getColumnCount(); j++){
                if (i < nombre_ligne_mon_tableau){
                    mes_donnees_a_ajouter[i][j] = mes_donnees_de_base[i][j];}
                else{
                    if (mes_donnees[i-nombre_ligne_mon_tableau][j].equals("NULL")){
                        mes_donnees_a_ajouter[i][j] = "";}
                    else{
                    mes_donnees_a_ajouter[i][j] = mes_donnees[i-nombre_ligne_mon_tableau][j];}
                }
            }
        }
        String [] nom_colonnes = {"Ceremonie", "Award", "Année"};
        mon_tableau.setModel(new DefaultTableModel(mes_donnees_a_ajouter, nom_colonnes));
    }
/*
    protected void ajouterDonneesDansTabRecompenses(Object[] mes_donnees, JTable mon_tableau){
        DefaultTableModel mon_model = (DefaultTableModel)mon_tableau.getModel();
        System.out.println(mes_donnees[1]);
        for (int i = 0 ; i < mes_donnees.length ; i++){
            mon_model.addRow(mes_donnees);
        }

        mon_tableau.setModel(mon_model);
    }*/

    protected String recupererValeurTF(JTextField tf){
        String valeur = tf.getText();
        // Si rien n'est rentré dans le TextField
        if (valeur.equals("")){
            valeur = "NULL"; 
        }
        return valeur;
    }

    protected String recupererValeurTA(JTextArea ta){
        String valeur = ta.getText();
        // Si rien n'est rentré dans le TextArea
        if (valeur.equals("")){
            valeur = "NULL"; 
        }
        return valeur;
    }

    protected boolean isTFVide(JTextField tf){
        String valeur = tf.getText();
        boolean flag = false;
        if (valeur.equals("")){
            flag = true;
        }
        return flag;
    }

    protected boolean isCBVide(JComboBox cb){
        String valeur = cb.getSelectedItem().toString();
        boolean flag = false;
        if (valeur.equals("Choisissez")){
            flag = true;
        }
        return flag;
    }

    protected String recupererValeurCB(JComboBox cb){
        String valeur_retour = "NULL";
        // Si l'utilisateur choisit autre chose  que "Choisissez"
        if(!cb.getSelectedItem().equals("Choisissez")){
            valeur_retour = cb.getSelectedItem().toString();
        }
        return valeur_retour;
    }
    
}