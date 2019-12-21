package graphiques;

import java.awt.Color;
import javax.swing.*;

import objets.C_ARTISTE;

import java.sql.*;
import java.util.*;


public class G_panel_creation_artiste extends A_panel_creation_modification {
    
    bdd.C_requetes mes_requetes_creation_artiste_combobox = new bdd.C_requetes();

	JPanel p_creation_artiste_infos_base = new JPanel();
    JPanel p_creation_artiste_infos_groupe = new JPanel();
    JPanel p_creation_artiste_infos_ceremonie = new JPanel();
    JPanel p_creation_artiste_boutons_validation = new JPanel();
    
    JButton b_creation_artiste_creer_groupe = new JButton("Creer un groupe ?");
    JButton b_creation_artiste_ajouter_groupe = new JButton("Ajout groupe");
    JButton b_creation_artiste_suppr_groupe = new JButton("Suppr groupe");
    JButton b_creation_artiste_creer_ceremonie = new JButton("Creer cérémonie ?");
    JButton b_creation_artiste_creer_award = new JButton("Creer award ?");
    JButton b_creation_artiste_ajouter_recompense = new JButton("Ajout récompense");
    JButton b_creation_artiste_suppr_recompense = new JButton("Suppr récompense");
    JButton b_creation_artiste_valider_creation = new JButton("Créer artiste");
    JButton b_creation_artiste_valider_brouillon = new JButton("Brouillon");
    JButton b_creation_artiste_creer_pays = new JButton("Cr�er pays");

    JComboBox cb_creation_artiste_groupe = new JComboBox<>();
    JComboBox cb_creation_artiste_ceremonie = new JComboBox<>();
    JComboBox cb_creation_artiste_award = new JComboBox<>();
    JComboBox cb_creation_artiste_annee_award = new JComboBox<>();
    JComboBox cb_creation_artiste_sexe = new JComboBox<>(new String[]{"Homme", "Femme","Non Binaire"});
    JComboBox cb_creation_artiste_pays = new JComboBox<>();

    JLabel l_creation_artiste_nom = new JLabel("Nom : ");
    JLabel l_creation_artiste_prenom = new JLabel("Pr�nom : ");
    JLabel l_creation_artiste_surnom = new JLabel("Surnom : ");
    JLabel l_creation_artiste_naissance = new JLabel("N� en : ");
    JLabel l_creation_artiste_mort = new JLabel("Mort en : ");
    JLabel l_creation_artiste_sexe = new JLabel("Sexe : ");
    JLabel l_creation_artiste_pays = new JLabel("Pays : ");

    JTextField tf_creation_artiste_nom = new JTextField();
    JTextField tf_creation_artiste_prenom = new JTextField();
    JTextField tf_creation_artiste_surnom = new JTextField();
    JTextField tf_creation_artiste_naissance = new JTextField();
    JTextField tf_creation_artiste_mort = new JTextField();

    JScrollPane sp_creation_artiste_liste_groupes = new JScrollPane();
    JList li_creation_artiste_liste_groupes = new JList<String>();

    JScrollPane sp_creation_artiste_tab_recompenses = new JScrollPane();
    JTable tab_creation_artiste_tab_recompenses = new JTable();

    public G_panel_creation_artiste() {
        
        this.setLayout(null);
        this.setBackground(Color.GRAY);
        this.setBounds(10,50,1180,630);
        // INFORMATIONS BASES
        p_creation_artiste_infos_base.setBounds(10,10,1160,150);
        p_creation_artiste_infos_base.setLayout(null);
        p_creation_artiste_infos_base.setBackground(Color.DARK_GRAY);
        this.add(p_creation_artiste_infos_base);

        l_creation_artiste_nom.setBounds(5,40,75,30);//320,40,150,30  5,40,75,30
        tf_creation_artiste_nom.setBounds(80,40,150,30);//395,40,150,30 80,40,150,30
        l_creation_artiste_prenom.setBounds(320,5,75,30);
        tf_creation_artiste_prenom.setBounds(395,5,150,30);
        l_creation_artiste_surnom.setBounds(320,40,75,30);
        tf_creation_artiste_surnom.setBounds(395,40,150,30);
        l_creation_artiste_naissance.setBounds(5,75,75,30);
        tf_creation_artiste_naissance.setBounds(80,75,150,30);
        l_creation_artiste_mort.setBounds(5,110,75,30);
        tf_creation_artiste_mort.setBounds(80,110,150,30);
        p_creation_artiste_infos_base.add(l_creation_artiste_nom);
        p_creation_artiste_infos_base.add(tf_creation_artiste_nom);
        p_creation_artiste_infos_base.add(l_creation_artiste_prenom);
        p_creation_artiste_infos_base.add(tf_creation_artiste_prenom);
        p_creation_artiste_infos_base.add(l_creation_artiste_surnom);
        p_creation_artiste_infos_base.add(tf_creation_artiste_surnom);
        p_creation_artiste_infos_base.add(l_creation_artiste_naissance);
        p_creation_artiste_infos_base.add(tf_creation_artiste_naissance);
        p_creation_artiste_infos_base.add(l_creation_artiste_mort);
        p_creation_artiste_infos_base.add(tf_creation_artiste_mort);
        l_creation_artiste_sexe.setBounds(5,5,75,30);
        cb_creation_artiste_sexe.setBounds(80,5,150,30);
        l_creation_artiste_pays.setBounds(320,75,150,30);
        cb_creation_artiste_pays.setBounds(395,75,150,30);
        p_creation_artiste_infos_base.add(l_creation_artiste_sexe);
        p_creation_artiste_infos_base.add(cb_creation_artiste_sexe);
        p_creation_artiste_infos_base.add(l_creation_artiste_pays);
        p_creation_artiste_infos_base.add(cb_creation_artiste_pays);
        b_creation_artiste_creer_pays.setBounds(395,110,150,30);
        p_creation_artiste_infos_base.add(b_creation_artiste_creer_pays);

        // INFORMATIONS ARTISTES

        p_creation_artiste_infos_groupe.setBounds(330,180,160,380);
        p_creation_artiste_infos_groupe.setLayout(null);
        p_creation_artiste_infos_groupe.setBackground(Color.DARK_GRAY); 
        this.add(p_creation_artiste_infos_groupe);

        cb_creation_artiste_groupe.setModel(new DefaultComboBoxModel<>(new String[] { "Groupe"}));
        cb_creation_artiste_groupe.setBounds(5,10,150,30);
        p_creation_artiste_infos_groupe.add(cb_creation_artiste_groupe);
        b_creation_artiste_creer_groupe.setBounds(5,45,150,30);
        p_creation_artiste_infos_groupe.add(b_creation_artiste_creer_groupe);
        b_creation_artiste_ajouter_groupe.setBounds(15,85,130,30);
        p_creation_artiste_infos_groupe.add(b_creation_artiste_ajouter_groupe);
        b_creation_artiste_suppr_groupe.setBounds(15,345,130,30);
        p_creation_artiste_infos_groupe.add(b_creation_artiste_suppr_groupe);

        // INFORMATIONS CEREMONIE

        p_creation_artiste_infos_ceremonie.setBounds(500,180,325,380);
        p_creation_artiste_infos_ceremonie.setLayout(null);
        p_creation_artiste_infos_ceremonie.setBackground(Color.DARK_GRAY);
        this.add(p_creation_artiste_infos_ceremonie);

        cb_creation_artiste_ceremonie.setModel(new DefaultComboBoxModel<>(new String[] { "Ceremonie"}));
        cb_creation_artiste_award.setModel(new DefaultComboBoxModel<>(new String[] { "Award"}));
        cb_creation_artiste_annee_award.setModel(new DefaultComboBoxModel<>(new String[] { "Année"}));
        cb_creation_artiste_ceremonie.setBounds(10,10,150,30);
        p_creation_artiste_infos_ceremonie.add(cb_creation_artiste_ceremonie); 
        cb_creation_artiste_award.setBounds(10,45,150,30);
        p_creation_artiste_infos_ceremonie.add(cb_creation_artiste_award); 
        cb_creation_artiste_annee_award.setBounds(10,80,150,30);
        p_creation_artiste_infos_ceremonie.add(cb_creation_artiste_annee_award); 
        b_creation_artiste_creer_ceremonie.setBounds(170,10,150,30);
        p_creation_artiste_infos_ceremonie.add(b_creation_artiste_creer_ceremonie); 
        b_creation_artiste_creer_award.setBounds(170,45,150,30);
        p_creation_artiste_infos_ceremonie.add(b_creation_artiste_creer_award); 
        b_creation_artiste_ajouter_recompense.setBounds(90,115,150,30);
        p_creation_artiste_infos_ceremonie.add(b_creation_artiste_ajouter_recompense); 
        b_creation_artiste_suppr_recompense.setBounds(90,345,150,30);
        p_creation_artiste_infos_ceremonie.add(b_creation_artiste_suppr_recompense); 

        // BOUTONS VALIDATION

        p_creation_artiste_boutons_validation.setBounds(435,570,315,50);
        p_creation_artiste_boutons_validation.setLayout(null);
        p_creation_artiste_boutons_validation.setBackground(Color.DARK_GRAY);
        this.add(p_creation_artiste_boutons_validation);

        b_creation_artiste_valider_creation.setBounds(5,5,150,40);
        p_creation_artiste_boutons_validation.add(b_creation_artiste_valider_creation);
        b_creation_artiste_valider_brouillon.setBounds(160,5,150,40);
        p_creation_artiste_boutons_validation.add(b_creation_artiste_valider_brouillon);

        // LISTE GROUPES

        sp_creation_artiste_liste_groupes.setBounds(5,120,150,220);
        sp_creation_artiste_liste_groupes.setViewportView(li_creation_artiste_liste_groupes);
        p_creation_artiste_infos_groupe.add(sp_creation_artiste_liste_groupes);

        // LISTE CEREMONIE
        tab_creation_artiste_tab_recompenses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {{null, null, null}},new String [] {"Cérémonie", "Récompense", "Année"}));
        sp_creation_artiste_tab_recompenses.setBounds(5,150,315,190);
        sp_creation_artiste_tab_recompenses.setViewportView(tab_creation_artiste_tab_recompenses);
        p_creation_artiste_infos_ceremonie.add(sp_creation_artiste_tab_recompenses);
     
    }

    public void affichageComboBoxCreationArtiste() throws SQLException {

        mes_requetes_creation_artiste_combobox.rechercheValeursComboBox("SELECT band_name FROM band", "band_name", cb_creation_artiste_groupe);
        mes_requetes_creation_artiste_combobox.rechercheValeursComboBox("SELECT country_name FROM country", "country_name", cb_creation_artiste_pays);
        mes_requetes_creation_artiste_combobox.rechercheValeursComboBox("SELECT ceremony_name FROM ceremony", "ceremony_name", cb_creation_artiste_ceremonie);
        mes_requetes_creation_artiste_combobox.rechercheValeursComboBox("SELECT award_name FROM award", "award_name", cb_creation_artiste_award);
        mes_requetes_creation_artiste_combobox.rechercheValeursComboBox("SELECT annee FROM annee", "annee", cb_creation_artiste_annee_award);
    }

}
