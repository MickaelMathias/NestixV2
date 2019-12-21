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
        DefaultListModel<String> mon_model = new DefaultListModel<>();
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

    protected void ajouterDonneesDansTabRecompenses(Object[][] mes_donnees, JTable mon_tableau){
        String [] nom_colonnes = {"Ceremonie", "Award", "Année"};
        mon_tableau.setModel(new DefaultTableModel(mes_donnees, nom_colonnes));
    }

    protected String verificationTFVide(JTextField tf){
        String valeur = tf.getText();
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
    
}