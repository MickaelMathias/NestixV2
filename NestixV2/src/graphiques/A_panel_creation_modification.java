package graphiques;

import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

abstract class A_panel_creation_modification extends JPanel{
    private static final long serialVersionUID = -2313359782920101526L;

    protected void ajouterElementList(JList list, String valeur) {
        DefaultListModel<String> mon_model = new DefaultListModel<>();
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

    protected String [] recupererToutesValeursList(JList ma_list){
        String [] mes_valeurs = new String[ma_list.getModel().getSize()];
        for (int i = 0; i < ma_list.getModel().getSize() ;i++){
            mes_valeurs[i] = ma_list.getModel().getElementAt(i).toString();

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
        // Si l'utilisateur choisit autre chose que "Choisissez"
        if(!cb.getSelectedItem().equals("Choisissez")){
            valeur_retour = cb.getSelectedItem().toString();
        }
        return valeur_retour;
    }
    
}