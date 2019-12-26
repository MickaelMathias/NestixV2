package graphiques;

import java.awt.*;
import java.sql.SQLException;

import javax.swing.*;


public class G_panel_recherche_artiste extends A_panel_recherche {

	bdd.C_requetes mes_requetes_recherche_artiste_combobox = new bdd.C_requetes();
	
    JPanel p_recherche_artiste_criteres = new JPanel();
    JPanel p_recherche_artiste_resultats = new JPanel();
    JPanel p_recherche_artiste_boutons = new JPanel();

    JButton b_recherche_artiste_rechercher= new JButton("Recherche");
    JButton b_recherche_artiste_modifier= new JButton("Modifier artiste");
    JButton b_recherche_artiste_bloquer = new JButton("Bloquer");
    JButton b_recherche_artiste_supprimer = new JButton("Supprimer");

    JComboBox cb_recherche_artiste_sexe = new JComboBox<>();
    JComboBox cb_recherche_artiste_nom = new JComboBox<>();
    JComboBox cb_recherche_artiste_prenom = new JComboBox<>();
    JComboBox cb_recherche_artiste_surnom = new JComboBox<>();
    JComboBox cb_recherche_artiste_pays = new JComboBox<>();


    JLabel l_recherche_artiste_sexe = new JLabel("Sexe");
    JLabel l_recherche_artiste_nom = new JLabel("Nom");
    JLabel l_recherche_artiste_prenom = new JLabel("Prenom");
    JLabel l_recherche_artiste_surnom = new JLabel("Surnom");
    JLabel l_recherche_artiste_pays = new JLabel("Pays");


    JScrollPane sp_recherche_artiste_tab_resultats = new JScrollPane();
    JTable tab_recherche_artiste_tab_resultats = new JTable();

    public G_panel_recherche_artiste() {

        this.setLayout(null);
        this.setBackground(Color.GRAY);
        this.setBounds(10,50,1180,630);

        // INFORMATIONS BASES
        p_recherche_artiste_criteres.setBounds(10,10,1160,120);
        p_recherche_artiste_criteres.setLayout(null);
        p_recherche_artiste_criteres.setBackground(Color.DARK_GRAY);
        this.add(p_recherche_artiste_criteres);

        l_recherche_artiste_sexe.setBounds(215,5,75,30);
        l_recherche_artiste_nom.setBounds(365,5,75,30);
        l_recherche_artiste_prenom.setBounds(550,5,75,30);
        l_recherche_artiste_surnom.setBounds(725,5,75,30);
        l_recherche_artiste_pays.setBounds(895,5,75,30);

        cb_recherche_artiste_sexe.setModel(new DefaultComboBoxModel<>(new String[] {"Sexe"}));
        cb_recherche_artiste_sexe.setBounds(160,40,150,30);
        cb_recherche_artiste_nom.setModel(new DefaultComboBoxModel<>(new String[] { "Nom"}));
        cb_recherche_artiste_nom.setBounds(330,40,150,30);
        cb_recherche_artiste_prenom.setModel(new DefaultComboBoxModel<>(new String[] {"Prenom"}));
        cb_recherche_artiste_prenom.setBounds(500,40,150,30);
        cb_recherche_artiste_surnom.setModel(new DefaultComboBoxModel<>(new String[] {"Surnom"}));
        cb_recherche_artiste_surnom.setBounds(670,40,150,30);
        cb_recherche_artiste_pays.setModel(new DefaultComboBoxModel<>(new String[] {"Pays"}));
        cb_recherche_artiste_pays.setBounds(840,40,150,30);

        b_recherche_artiste_rechercher.setBounds(500,80,150,30);

        p_recherche_artiste_criteres.add(l_recherche_artiste_sexe);
        p_recherche_artiste_criteres.add(l_recherche_artiste_nom);
        p_recherche_artiste_criteres.add(l_recherche_artiste_prenom);
        p_recherche_artiste_criteres.add(l_recherche_artiste_surnom);
        p_recherche_artiste_criteres.add(l_recherche_artiste_pays);
        p_recherche_artiste_criteres.add(cb_recherche_artiste_sexe);
        p_recherche_artiste_criteres.add(cb_recherche_artiste_nom);
        p_recherche_artiste_criteres.add(cb_recherche_artiste_prenom);
        p_recherche_artiste_criteres.add(cb_recherche_artiste_surnom);
        p_recherche_artiste_criteres.add(cb_recherche_artiste_pays);
        p_recherche_artiste_criteres.add(b_recherche_artiste_rechercher);

        // TABELEAU RESULTATS

        p_recherche_artiste_resultats.setBounds(10,140,1160,420);
        p_recherche_artiste_resultats.setLayout(null);
        p_recherche_artiste_resultats.setBackground(Color.DARK_GRAY); 
        this.add(p_recherche_artiste_resultats);

        tab_recherche_artiste_tab_resultats.setModel(new javax.swing.table.DefaultTableModel(
            null,new String [] {"ID", "Nom", "Prenom", "Surnom", "Pays"}));
        sp_recherche_artiste_tab_resultats.setBounds(5,5,1150,410);
        sp_recherche_artiste_tab_resultats.setViewportView(tab_recherche_artiste_tab_resultats);
        p_recherche_artiste_resultats.add(sp_recherche_artiste_tab_resultats);

        // BOUTONS VALIDATION

        p_recherche_artiste_boutons.setBounds(360,570,470,50);
        p_recherche_artiste_boutons.setLayout(null);
        p_recherche_artiste_boutons.setBackground(Color.DARK_GRAY);
        this.add(p_recherche_artiste_boutons);

        b_recherche_artiste_modifier.setBounds(5,5,150,40);
        p_recherche_artiste_boutons.add(b_recherche_artiste_modifier);
        b_recherche_artiste_bloquer.setBounds(160,5,150,40);
        p_recherche_artiste_boutons.add(b_recherche_artiste_bloquer);
        b_recherche_artiste_supprimer.setBounds(315,5,150,40);
        p_recherche_artiste_boutons.add(b_recherche_artiste_supprimer);

        // AFFICHAGE TABLEAU RECHERCHE DE BASE

        this.AfficheInfosArtisteTableau(tab_recherche_artiste_tab_resultats);

    }

    public void affichageComboBoxRechercheArtiste() throws SQLException {
        mes_requetes_recherche_artiste_combobox.rechercheValeursComboBox("SELECT DISTINCT human_sex FROM human", "human_sex", cb_recherche_artiste_sexe);
        mes_requetes_recherche_artiste_combobox.rechercheValeursComboBox("SELECT human_lastname FROM human WHERE human_id IN (SELECT human_id FROM artist)", "human_lastname", cb_recherche_artiste_nom);
        mes_requetes_recherche_artiste_combobox.rechercheValeursComboBox("SELECT human_firstname FROM human WHERE human_id IN (SELECT human_id FROM artist)", "human_firstname", cb_recherche_artiste_prenom);
        mes_requetes_recherche_artiste_combobox.rechercheValeursComboBox("SELECT artist_nickname FROM artist", "artist_nickname", cb_recherche_artiste_surnom);
        mes_requetes_recherche_artiste_combobox.rechercheValeursComboBox("SELECT country_name FROM country", "country_name", cb_recherche_artiste_pays);
    }
}
