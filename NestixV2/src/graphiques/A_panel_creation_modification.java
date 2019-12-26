package graphiques;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import objets.C_ARTISTE;
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

    protected ArrayList <String> recupererTousNomsArtiste(ArrayList<C_ARTISTE> mes_artistes){
        ArrayList <String> mes_noms = new ArrayList<>();
        for (int i=0; i < mes_artistes.size(); i++){
            mes_noms.add(mes_artistes.get(i).getArtiste_nickname());
        }
        return mes_noms;
    }

    protected ArrayList <String> recupererTousNomsCaracteristique(ArrayList<C_CARACTERISTIQUES> mes_caracteristiques){
        ArrayList <String> mes_noms = new ArrayList<>();
        for (int i=0; i < mes_caracteristiques.size(); i++){
            mes_noms.add(mes_caracteristiques.get(i).getCaracteristiquesNom());
        }
        return mes_noms;
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
            mon_artiste.setHuman_id(mon_artiste.recupererIdParNom());
            mes_valeurs.add(mon_artiste);
        }
        return mes_valeurs;
    }

    protected ArrayList<objets.C_CARACTERISTIQUES> recupererTousGenreDeList(JList ma_list){
        ArrayList<objets.C_CARACTERISTIQUES> mes_valeurs = new ArrayList<>();
        for (int i = 0; i < ma_list.getModel().getSize() ;i++){
            objets.C_CARACTERISTIQUES mon_genre = new objets.C_CARACTERISTIQUES();
            mon_genre.setCaracteristiquesNom(ma_list.getModel().getElementAt(i).toString());
            mon_genre.setCaracteristiquesId(mon_genre.recupererIdParNom("genre", mon_genre.getCaracteristiquesNom()));
            mes_valeurs.add(mon_genre);
        }
        return mes_valeurs;
    }

    protected ArrayList<objets.C_CARACTERISTIQUES> recupererTousGroupeDeList(JList ma_list){
        ArrayList<objets.C_CARACTERISTIQUES> mes_valeurs = new ArrayList<>();
        for (int i = 0; i < ma_list.getModel().getSize() ;i++){
            objets.C_CARACTERISTIQUES mon_genre = new objets.C_CARACTERISTIQUES();
            mon_genre.setCaracteristiquesNom(ma_list.getModel().getElementAt(i).toString());
            mon_genre.setCaracteristiquesId(mon_genre.recupererIdParNom("band", mon_genre.getCaracteristiquesNom()));
            mes_valeurs.add(mon_genre);
        }
        return mes_valeurs;
    }

    protected ArrayList<objets.C_CARACTERISTIQUES> recupererStudioProductionDeComboBox(JComboBox ma_cb){
        ArrayList<objets.C_CARACTERISTIQUES> mes_valeurs = new ArrayList<>();
        objets.C_CARACTERISTIQUES mon_sp = new objets.C_CARACTERISTIQUES();
        mon_sp.setCaracteristiquesNom(ma_cb.getSelectedItem().toString());
        mon_sp.setCaracteristiquesId(mon_sp.recupererIdParNom("pc", mon_sp.getCaracteristiquesNom()));
        mes_valeurs.add(mon_sp);
        return mes_valeurs;
    }

    protected ArrayList<objets.C_CARACTERISTIQUES> recupererGroupeDeComboBox(JComboBox ma_cb){
        ArrayList<objets.C_CARACTERISTIQUES> mes_valeurs = new ArrayList<>();
        objets.C_CARACTERISTIQUES mon_sp = new objets.C_CARACTERISTIQUES();
        mon_sp.setCaracteristiquesNom(ma_cb.getSelectedItem().toString());
        mon_sp.setCaracteristiquesId(mon_sp.recupererIdParNom("band", mon_sp.getCaracteristiquesNom()));
        mes_valeurs.add(mon_sp);
        return mes_valeurs;
    }

    protected ArrayList<objets.C_CARACTERISTIQUES> recupererPaysDeComboBox(JComboBox ma_cb){
        ArrayList<objets.C_CARACTERISTIQUES> mes_valeurs = new ArrayList<>();
        objets.C_CARACTERISTIQUES mon_sp = new objets.C_CARACTERISTIQUES();
        mon_sp.setCaracteristiquesNom(ma_cb.getSelectedItem().toString());
        mon_sp.setCaracteristiquesId(mon_sp.recupererIdParNom("country", mon_sp.getCaracteristiquesNom()));
        mes_valeurs.add(mon_sp);
        return mes_valeurs;
    }

    protected ArrayList<objets.C_CARACTERISTIQUES> recupererTousCeremonieDeArrayList(ArrayList <String> liste_ceremonie){
        ArrayList<objets.C_CARACTERISTIQUES> mes_valeurs = new ArrayList<>();
        for (int i = 0; i < liste_ceremonie.size() ;i++){
            objets.C_CARACTERISTIQUES ma_ceremonie = new objets.C_CARACTERISTIQUES();
            ma_ceremonie.setCaracteristiquesNom(liste_ceremonie.get(i));
            ma_ceremonie.setCaracteristiquesId(ma_ceremonie.recupererIdParNom("ceremony", ma_ceremonie.getCaracteristiquesNom()));
            mes_valeurs.add(ma_ceremonie);
        }
        return mes_valeurs;
    }

    protected ArrayList<objets.C_CARACTERISTIQUES> recupererTousAwardDeArrayList(ArrayList <String> liste_award){
        ArrayList<objets.C_CARACTERISTIQUES> mes_valeurs = new ArrayList<>();
        for (int i = 0; i < liste_award.size() ;i++){
            objets.C_AWARD mon_award = new objets.C_AWARD();
            mon_award.setCaracteristiquesNom(liste_award.get(i));
            mon_award.setCaracteristiquesId(mon_award.recupererIdParNom("award", mon_award.getCaracteristiquesNom()));
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

    protected ArrayList<objets.C_CARACTERISTIQUES> recupererTousTagDeList(JList ma_list){
        ArrayList<objets.C_CARACTERISTIQUES> mes_valeurs = new ArrayList<>();
        for (int i = 0; i < ma_list.getModel().getSize() ;i++){
            objets.C_CARACTERISTIQUES mon_tag = new objets.C_CARACTERISTIQUES();
            mon_tag.setCaracteristiquesNom(ma_list.getModel().getElementAt(i).toString());
            mon_tag.setCaracteristiquesId(mon_tag.recupererIdParNom("tag", mon_tag.getCaracteristiquesNom()));
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

    protected Object [][] creerDonnesCeremonies(ArrayList<C_CARACTERISTIQUES> mes_ceremonies, ArrayList <C_CARACTERISTIQUES> mes_awards, ArrayList<String> mes_annees){
        Object[][] mes_recompenses = new Object[mes_ceremonies.size()][3];

        for (int i = 0; i < mes_ceremonies.size() ; i++){
            mes_recompenses[i][0] = mes_ceremonies.get(i).getCaracteristiquesNom();
            mes_recompenses[i][1] = mes_awards.get(i).getCaracteristiquesNom();
            mes_recompenses[i][2] = mes_annees.get(i);
        }
        return mes_recompenses;

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

    public static String verifDate(JTextField tf) {
        String retour = tf.getText();
        if (tf.getText().equals("NULL") || !tf.getText().matches("\\d{4}-[01]\\d-[0-3]\\d"))
            retour = "NULL";
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        df.setLenient(false);
        if(!tf.getText().equals("NULL")){
        try {
                df.parse(tf.getText());
        } catch (ParseException ex) {
            javax.swing.JOptionPane.showMessageDialog(new JPanel(), "Problème de format de date");
        }}
        return retour;
    }  
}