package graphiques;

import javax.swing.*;
import java.awt.*;

public class G_panel_recherche_film extends JPanel {

    JPanel p_recherche_film_criteres = new JPanel();
    JPanel p_recherche_film_resultats = new JPanel();
    JPanel p_recherche_film_boutons = new JPanel();

    JButton b_recherche_film_rechercher= new JButton("Recherche");
    JButton b_recherche_film_modifier= new JButton("Modifier film");
    JButton b_recherche_film_bloquer = new JButton("Bloquer");
    JButton b_recherche_film_supprimer = new JButton("Supprimer");

    JComboBox cb_recherche_film_titre = new JComboBox<>();
    JComboBox cb_recherche_film_surnom_realisateur = new JComboBox<>();
    JComboBox cb_recherche_film_surnom_acteur = new JComboBox<>();
    JComboBox cb_recherche_film_genre = new JComboBox<>();
    JComboBox cb_recherche_film_tag = new JComboBox<>();
    JComboBox cb_recherche_film_annee = new JComboBox<>();


    JLabel l_recherche_film_titre = new JLabel("Titre");
    JLabel l_recherche_film_realisateur = new JLabel("Réalisateur");
    JLabel l_recherche_film_acteur = new JLabel("Acteur");
    JLabel l_recherche_film_genre = new JLabel("Genre");
    JLabel l_recherche_film_tag = new JLabel("Tag");
    JLabel l_recherche_film_annee = new JLabel("Annee");


    JScrollPane sp_recherche_film_tab_resultats = new JScrollPane();
    JTable tab_recherche_film_tab_resultats = new JTable();

    public G_panel_recherche_film() {

        this.setLayout(null);
        this.setBackground(Color.GRAY);
        this.setBounds(10,50,1180,630);

        // INFORMATIONS BASES
        p_recherche_film_criteres.setBounds(10,10,1160,120);
        p_recherche_film_criteres.setLayout(null);
        p_recherche_film_criteres.setBackground(Color.DARK_GRAY);
        this.add(p_recherche_film_criteres);

        l_recherche_film_titre.setBounds(130,5,75,30);
        l_recherche_film_realisateur.setBounds(280,5,75,30);
        l_recherche_film_acteur.setBounds(470,5,75,30);
        l_recherche_film_genre.setBounds(640,5,75,30);
        l_recherche_film_tag.setBounds(810,5,75,30);
        l_recherche_film_annee.setBounds(970,5,75,30);

        cb_recherche_film_titre.setModel(new DefaultComboBoxModel<>(new String[] { "Titre"}));
        cb_recherche_film_titre.setBounds(75,40,150,30);
        cb_recherche_film_surnom_realisateur.setModel(new DefaultComboBoxModel<>(new String[] { "Realisateur"}));
        cb_recherche_film_surnom_realisateur.setBounds(245,40,150,30);
        cb_recherche_film_surnom_acteur.setModel(new DefaultComboBoxModel<>(new String[] { "Acteur"}));
        cb_recherche_film_surnom_acteur.setBounds(415,40,150,30);
        cb_recherche_film_genre.setModel(new DefaultComboBoxModel<>(new String[] { "Genre"}));
        cb_recherche_film_genre.setBounds(585,40,150,30);
        cb_recherche_film_tag.setModel(new DefaultComboBoxModel<>(new String[] { "Tag"}));
        cb_recherche_film_tag.setBounds(755,40,150,30);
        cb_recherche_film_annee.setModel(new DefaultComboBoxModel<>(new String[] { "Année"}));
        cb_recherche_film_annee.setBounds(915,40,150,30);

        b_recherche_film_rechercher.setBounds(500,80,150,30);

        p_recherche_film_criteres.add(l_recherche_film_titre);
        p_recherche_film_criteres.add(l_recherche_film_realisateur);
        p_recherche_film_criteres.add(l_recherche_film_acteur);
        p_recherche_film_criteres.add(l_recherche_film_genre);
        p_recherche_film_criteres.add(l_recherche_film_tag);
        p_recherche_film_criteres.add(l_recherche_film_annee);
        p_recherche_film_criteres.add(cb_recherche_film_titre);
        p_recherche_film_criteres.add(cb_recherche_film_surnom_realisateur);
        p_recherche_film_criteres.add(cb_recherche_film_surnom_acteur);
        p_recherche_film_criteres.add(cb_recherche_film_genre);
        p_recherche_film_criteres.add(cb_recherche_film_tag);
        p_recherche_film_criteres.add(cb_recherche_film_annee);
        p_recherche_film_criteres.add(b_recherche_film_rechercher);

        // TABELEAU RESULTATS

        p_recherche_film_resultats.setBounds(10,140,1160,420);
        p_recherche_film_resultats.setLayout(null);
        p_recherche_film_resultats.setBackground(Color.DARK_GRAY); 
        this.add(p_recherche_film_resultats);

        tab_recherche_film_tab_resultats.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {{null, null, null, null, null}},new String [] {"ID", "Titre", "Realisateur", "Annee", "Saga"}));
        sp_recherche_film_tab_resultats.setBounds(5,5,1150,410);
        sp_recherche_film_tab_resultats.setViewportView(tab_recherche_film_tab_resultats);
        p_recherche_film_resultats.add(sp_recherche_film_tab_resultats);

        // BOUTONS VALIDATION

        p_recherche_film_boutons.setBounds(360,570,470,50);
        p_recherche_film_boutons.setLayout(null);
        p_recherche_film_boutons.setBackground(Color.DARK_GRAY);
        this.add(p_recherche_film_boutons);

        b_recherche_film_modifier.setBounds(5,5,150,40);
        p_recherche_film_boutons.add(b_recherche_film_modifier);
        b_recherche_film_bloquer.setBounds(160,5,150,40);
        p_recherche_film_boutons.add(b_recherche_film_bloquer);
        b_recherche_film_supprimer.setBounds(315,5,150,40);
        p_recherche_film_boutons.add(b_recherche_film_supprimer);
    }
/*
    public void affichageComboBoxModificationFilm() throws SQLException {
        mes_requetes_modification_film_combobox.rechercheValeursComboBox("SELECT pc_name FROM production_company", "pc_name", cb_modification_film_studio_production);
        mes_requetes_modification_film_combobox.rechercheValeursComboBox("SELECT artist_nickname FROM artist", "artist_nickname", cb_modification_film_artiste);
        mes_requetes_modification_film_combobox.rechercheValeursComboBox("SELECT genre_name FROM genre", "genre_name", cb_modification_film_genres);
        mes_requetes_modification_film_combobox.rechercheValeursComboBox("SELECT tag_name FROM tag", "tag_name", cb_modification_film_tags);
        mes_requetes_modification_film_combobox.rechercheValeursComboBox("SELECT ceremony_name FROM ceremony", "ceremony_name", cb_modification_film_ceremonie);
        mes_requetes_modification_film_combobox.rechercheValeursComboBox("SELECT award_name FROM award", "award_name", cb_modification_film_award);
    }*/
}