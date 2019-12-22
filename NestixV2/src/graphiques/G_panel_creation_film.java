package graphiques;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import objets.C_CEREMONIE;

import java.awt.*;
import java.sql.SQLException;
import java.util.*;

public class G_panel_creation_film extends A_panel_creation_modification {

    bdd.C_requetes mes_requetes_creation_film_combobox = new bdd.C_requetes();

    JPanel p_creation_film_infos_base = new JPanel();
    JPanel p_creation_film_infos_artistes = new JPanel();
    JPanel p_creation_film_infos_genres = new JPanel();
    JPanel p_creation_film_infos_tags = new JPanel();
    JPanel p_creation_film_infos_ceremonie = new JPanel();
    JPanel p_creation_film_boutons_validation = new JPanel();
    
    JButton b_creation_film_creer_artiste = new JButton("Creer un artiste ?");
    JButton b_creation_film_ajouter_acteur = new JButton("Ajout acteur");
    JButton b_creation_film_ajouter_realisateur = new JButton("Ajout realisateur");
    JButton b_creation_film_ajouter_scenariste = new JButton("Ajout scenariste");
    JButton b_creation_film_suppr_acteur = new JButton("Suppr acteur");
    JButton b_creation_film_suppr_realisateur = new JButton("Suppr realisateur");
    JButton b_creation_film_suppr_scenariste = new JButton("Suppr scenariste");
    JButton b_creation_film_creer_genre = new JButton("Creer un genre ?");
    JButton b_creation_film_ajouter_genre = new JButton("Ajout genre");
    JButton b_creation_film_suppr_genre = new JButton("Suppr genre");
    JButton b_creation_film_creer_tag = new JButton("Creer un tag ?");
    JButton b_creation_film_ajouter_tag = new JButton("Ajout tag");
    JButton b_creation_film_suppr_tag = new JButton("Suppr tag");
    JButton b_creation_film_creer_ceremonie = new JButton("Creer cérémonie ?");
    JButton b_creation_film_creer_award = new JButton("Creer award ?");
    JButton b_creation_film_ajouter_recompense = new JButton("Ajout récompense");
    JButton b_creation_film_suppr_recompense = new JButton("Suppr récompense");
    JButton b_creation_film_valider_creation = new JButton("Créer film");
    JButton b_creation_film_valider_brouillon = new JButton("Brouillon");
    JButton b_creation_film_creer_studio_production = new JButton("Créer producteur ?");

    JComboBox cb_creation_film_artiste = new JComboBox<>();
    JComboBox cb_creation_film_genres = new JComboBox<>();
    JComboBox cb_creation_film_tags = new JComboBox<>();
    JComboBox cb_creation_film_ceremonie = new JComboBox<>();
    JComboBox cb_creation_film_award = new JComboBox<>();
    JComboBox cb_creation_film_annee_award = new JComboBox<>();
    JComboBox cb_creation_film_studio_production = new JComboBox<>();

    JLabel l_creation_film_visa = new JLabel("Visa : ");
    JLabel l_creation_film_titre = new JLabel("Titre : ");
    JLabel l_creation_film_annee = new JLabel("Année : ");
    JLabel l_creation_film_duree = new JLabel("Durée : ");
    JLabel l_creation_film_trailer = new JLabel("Trailer : ");
    JLabel l_creation_film_budget = new JLabel("Budget : ");
    JLabel l_creation_film_lien = new JLabel("Lien : ");
    JLabel l_creation_film_saga = new JLabel("Saga : ");
    JLabel l_creation_film_synop = new JLabel("Synopsis : ");
    JLabel l_creation_film_studio_production = new JLabel("Producteur : ");

    JTextField tf_creation_film_visa = new JTextField();
    JTextField tf_creation_film_titre = new JTextField();
    JTextField tf_creation_film_annee = new JTextField();
    JTextField tf_creation_film_duree = new JTextField();
    JTextField tf_creation_film_trailer = new JTextField();
    JTextField tf_creation_film_budget = new JTextField();
    JTextField tf_creation_film_lien = new JTextField();
    JTextField tf_creation_film_saga = new JTextField();
    
    JScrollPane sp_creation_film_synop = new JScrollPane();
    JTextArea ta_creation_film_synop = new JTextArea();
    JScrollPane sp_creation_film_liste_acteurs = new JScrollPane();
    JList li_creation_film_liste_acteurs = new JList<String>(new DefaultListModel<>());
    JScrollPane sp_creation_film_liste_realisateurs = new JScrollPane();
    JList li_creation_film_liste_realisateurs = new JList<String>(new DefaultListModel<>());
    JScrollPane sp_creation_film_liste_scenaristes = new JScrollPane();
    JList li_creation_film_liste_scenaristes = new JList<String>(new DefaultListModel<>());
    JScrollPane sp_creation_film_liste_genres = new JScrollPane();
    JList li_creation_film_liste_genres = new JList<String>(new DefaultListModel<>());

    JScrollPane sp_creation_film_liste_tags = new JScrollPane();
    JList li_creation_film_liste_tags = new JList<String>(new DefaultListModel<>());
    JScrollPane sp_creation_film_tab_recompenses = new JScrollPane();
    Object[][] o_creation_film_donnees_recompenses = {{null,null,null}};
    
    JTable tab_creation_film_tab_recompenses = new JTable();

    public G_panel_creation_film() {

        this.setLayout(null);
        this.setBackground(Color.GRAY);
        this.setBounds(10,50,1180,630);
        // INFORMATIONS BASES
        
        p_creation_film_infos_base.setBounds(10,10,1160,150);
        p_creation_film_infos_base.setLayout(null);
        p_creation_film_infos_base.setBackground(Color.DARK_GRAY);
        this.add(p_creation_film_infos_base);

        l_creation_film_visa.setBounds(5,5,75,30);
        tf_creation_film_visa.setBounds(80,5,150,30);
        l_creation_film_titre.setBounds(5,40,75,30);
        tf_creation_film_titre.setBounds(80,40,150,30);
        l_creation_film_annee.setBounds(5,75,75,30);
        tf_creation_film_annee.setDocument(new C_verif_format_int(4));
        tf_creation_film_annee.setBounds(80,75,150,30);
        l_creation_film_duree.setBounds(5,110,75,30);
        tf_creation_film_duree.setBounds(80,110,150,30);
        tf_creation_film_duree.setDocument(new C_verif_format_int(3));
        p_creation_film_infos_base.add(l_creation_film_visa);
        p_creation_film_infos_base.add(tf_creation_film_visa);
        p_creation_film_infos_base.add(l_creation_film_titre);
        p_creation_film_infos_base.add(tf_creation_film_titre);
        p_creation_film_infos_base.add(l_creation_film_annee);
        p_creation_film_infos_base.add(tf_creation_film_annee);
        p_creation_film_infos_base.add(l_creation_film_duree);
        p_creation_film_infos_base.add(tf_creation_film_duree);
        l_creation_film_trailer.setBounds(300,5,75,30);
        tf_creation_film_trailer.setBounds(380,5,150,30);
        l_creation_film_lien.setBounds(300,40,75,30);
        tf_creation_film_lien.setBounds(380,40,150,30);
        l_creation_film_budget.setBounds(300,75,75,30);
        tf_creation_film_budget.setBounds(380,75,150,30);
        l_creation_film_saga.setBounds(300,110,75,30);
        tf_creation_film_saga.setBounds(380,110,150,30);
        p_creation_film_infos_base.add(l_creation_film_trailer);
        p_creation_film_infos_base.add(tf_creation_film_trailer);
        p_creation_film_infos_base.add(l_creation_film_lien);
        p_creation_film_infos_base.add(tf_creation_film_lien);
        p_creation_film_infos_base.add(l_creation_film_budget);
        p_creation_film_infos_base.add(tf_creation_film_budget);
        p_creation_film_infos_base.add(l_creation_film_saga);
        p_creation_film_infos_base.add(tf_creation_film_saga);
        l_creation_film_synop.setBounds(710,5,150,20);
        sp_creation_film_synop.setBounds(635,30,200,100);
        sp_creation_film_synop.setViewportView(ta_creation_film_synop);
        p_creation_film_infos_base.add(l_creation_film_synop);
        p_creation_film_infos_base.add(sp_creation_film_synop);

        l_creation_film_studio_production.setBounds(990,5,150,20);
        cb_creation_film_studio_production.setModel(new DefaultComboBoxModel<>(new String[] { "Production"}));
        cb_creation_film_studio_production.setBounds(950,35,150,20);
        b_creation_film_creer_studio_production.setBounds(950,65,150,20);

        p_creation_film_infos_base.add(l_creation_film_studio_production);
        p_creation_film_infos_base.add(cb_creation_film_studio_production);
        p_creation_film_infos_base.add(b_creation_film_creer_studio_production);

        // INFORMATIONS ARTISTES

        p_creation_film_infos_artistes.setBounds(10,180,480,380);
        p_creation_film_infos_artistes.setLayout(null);
        p_creation_film_infos_artistes.setBackground(Color.DARK_GRAY); 
        this.add(p_creation_film_infos_artistes);

        cb_creation_film_artiste.setModel(new DefaultComboBoxModel<>(new String[] { "Artistes"}));
        cb_creation_film_artiste.setBounds(165,10,150,30);
        p_creation_film_infos_artistes.add(cb_creation_film_artiste);
        b_creation_film_creer_artiste.setBounds(165,45,150,30);
        p_creation_film_infos_artistes.add(b_creation_film_creer_artiste);
        b_creation_film_ajouter_acteur.setBounds(15,85,130,30);
        p_creation_film_infos_artistes.add(b_creation_film_ajouter_acteur);
        b_creation_film_ajouter_realisateur.setBounds(175,85,130,30);
        p_creation_film_infos_artistes.add(b_creation_film_ajouter_realisateur);
        b_creation_film_ajouter_scenariste.setBounds(330,85,130,30);
        p_creation_film_infos_artistes.add(b_creation_film_ajouter_scenariste);
        b_creation_film_suppr_acteur.setBounds(15,345,130,30);
        p_creation_film_infos_artistes.add(b_creation_film_suppr_acteur);
        b_creation_film_suppr_realisateur.setBounds(175,345,130,30);
        p_creation_film_infos_artistes.add(b_creation_film_suppr_realisateur);
        b_creation_film_suppr_scenariste.setBounds(330,345,130,30);
        p_creation_film_infos_artistes.add(b_creation_film_suppr_scenariste);


        // INFORMATIONS GENRES

        p_creation_film_infos_genres.setBounds(495,180,170,380);
        p_creation_film_infos_genres.setLayout(null);
        p_creation_film_infos_genres.setBackground(Color.DARK_GRAY);
        this.add(p_creation_film_infos_genres);

        cb_creation_film_genres.setModel(new DefaultComboBoxModel<>(new String[] { "Genres"}));
        cb_creation_film_genres.setBounds(10,10,150,30);
        p_creation_film_infos_genres.add(cb_creation_film_genres); 
        b_creation_film_creer_genre.setBounds(10,45,150,30);
        p_creation_film_infos_genres.add(b_creation_film_creer_genre); 
        b_creation_film_ajouter_genre.setBounds(20,85,130,30);
        p_creation_film_infos_genres.add(b_creation_film_ajouter_genre);
        b_creation_film_suppr_genre.setBounds(20,345,130,30);
        p_creation_film_infos_genres.add(b_creation_film_suppr_genre);
        
        // INFORMATIONS TAGS 

        p_creation_film_infos_tags.setBounds(670,180,170,380);
        p_creation_film_infos_tags.setLayout(null);
        p_creation_film_infos_tags.setBackground(Color.DARK_GRAY);
        this.add(p_creation_film_infos_tags);

        cb_creation_film_tags.setModel(new DefaultComboBoxModel<>(new String[] { "Tags"}));
        cb_creation_film_tags.setBounds(10,10,150,30);
        p_creation_film_infos_tags.add(cb_creation_film_tags);
        b_creation_film_creer_tag.setBounds(10,45,150,30);
        p_creation_film_infos_tags.add(b_creation_film_creer_tag);
        b_creation_film_ajouter_tag.setBounds(20,85,130,30);
        p_creation_film_infos_tags.add(b_creation_film_ajouter_tag);
        b_creation_film_suppr_tag.setBounds(20,345,130,30);
        p_creation_film_infos_tags.add(b_creation_film_suppr_tag);

        // INFORMATIONS CEREMONIE

        p_creation_film_infos_ceremonie.setBounds(845,180,325,380);
        p_creation_film_infos_ceremonie.setLayout(null);
        p_creation_film_infos_ceremonie.setBackground(Color.DARK_GRAY);
        this.add(p_creation_film_infos_ceremonie);

        cb_creation_film_ceremonie.setModel(new DefaultComboBoxModel<>(new String[] { "Ceremonie"}));
        cb_creation_film_award.setModel(new DefaultComboBoxModel<>(new String[] { "Award"}));
        cb_creation_film_annee_award.setModel(new DefaultComboBoxModel<>(new String[] { "Année"}));
        cb_creation_film_ceremonie.setBounds(10,10,150,30);
        p_creation_film_infos_ceremonie.add(cb_creation_film_ceremonie); 
        cb_creation_film_award.setBounds(10,45,150,30);
        p_creation_film_infos_ceremonie.add(cb_creation_film_award); 
        cb_creation_film_annee_award.setBounds(10,80,150,30);
        p_creation_film_infos_ceremonie.add(cb_creation_film_annee_award); 
        b_creation_film_creer_ceremonie.setBounds(170,10,150,30);
        p_creation_film_infos_ceremonie.add(b_creation_film_creer_ceremonie); 
        b_creation_film_creer_award.setBounds(170,45,150,30);
        p_creation_film_infos_ceremonie.add(b_creation_film_creer_award); 
        b_creation_film_ajouter_recompense.setBounds(90,115,150,30);
        p_creation_film_infos_ceremonie.add(b_creation_film_ajouter_recompense); 
        b_creation_film_suppr_recompense.setBounds(90,345,150,30);
        p_creation_film_infos_ceremonie.add(b_creation_film_suppr_recompense); 

        // BOUTONS VALIDATION

        p_creation_film_boutons_validation.setBounds(435,570,315,50);
        p_creation_film_boutons_validation.setLayout(null);
        p_creation_film_boutons_validation.setBackground(Color.DARK_GRAY);
        this.add(p_creation_film_boutons_validation);

        b_creation_film_valider_creation.setBounds(5,5,150,40);
        p_creation_film_boutons_validation.add(b_creation_film_valider_creation);
        b_creation_film_valider_brouillon.setBounds(160,5,150,40);
        p_creation_film_boutons_validation.add(b_creation_film_valider_brouillon);

        // LISTE ACTEURS
        sp_creation_film_liste_acteurs.setBounds(5,120,150,220);
        sp_creation_film_liste_acteurs.setViewportView(li_creation_film_liste_acteurs);
        p_creation_film_infos_artistes.add(sp_creation_film_liste_acteurs);

        // LISTE REALISATEURS
        sp_creation_film_liste_realisateurs.setBounds(165,120,150,220);
        sp_creation_film_liste_realisateurs.setViewportView(li_creation_film_liste_realisateurs);
        p_creation_film_infos_artistes.add(sp_creation_film_liste_realisateurs);
        
        // LISTE SCENARISTE
        sp_creation_film_liste_scenaristes.setBounds(325,120,150,220);
        sp_creation_film_liste_scenaristes.setViewportView(li_creation_film_liste_scenaristes);
        p_creation_film_infos_artistes.add(sp_creation_film_liste_scenaristes);

        // LISTE GENRE
        sp_creation_film_liste_genres.setBounds(5,120,160,220);
        sp_creation_film_liste_genres.setViewportView(li_creation_film_liste_genres);
        p_creation_film_infos_genres.add(sp_creation_film_liste_genres);

        // LISTE TAG  
        sp_creation_film_liste_tags.setBounds(5,120,160,220);
        sp_creation_film_liste_tags.setViewportView(li_creation_film_liste_tags);
        p_creation_film_infos_tags.add(sp_creation_film_liste_tags);

        // LISTE CEREMONIE
        tab_creation_film_tab_recompenses.setModel(new DefaultTableModel(
            o_creation_film_donnees_recompenses,
            new String [] {"Cérémonie", "Récompense", "Année"}));
        sp_creation_film_tab_recompenses.setBounds(5,150,315,190);
        
        sp_creation_film_tab_recompenses.setViewportView(tab_creation_film_tab_recompenses);
        p_creation_film_infos_ceremonie.add(sp_creation_film_tab_recompenses);
    }

    public void affichageComboBoxCreationFilm() throws SQLException {
        mes_requetes_creation_film_combobox.rechercheValeursComboBox("SELECT pc_name FROM pc", "pc_name", cb_creation_film_studio_production);
        mes_requetes_creation_film_combobox.rechercheValeursComboBox("SELECT artist_nickname FROM artist", "artist_nickname", cb_creation_film_artiste);
        mes_requetes_creation_film_combobox.rechercheValeursComboBox("SELECT genre_name FROM genre", "genre_name", cb_creation_film_genres);
        mes_requetes_creation_film_combobox.rechercheValeursComboBox("SELECT tag_name FROM tag", "tag_name", cb_creation_film_tags);
        mes_requetes_creation_film_combobox.rechercheValeursComboBox("SELECT ceremony_name FROM ceremony", "ceremony_name", cb_creation_film_ceremonie);
        mes_requetes_creation_film_combobox.rechercheValeursComboBox("SELECT award_name FROM award", "award_name", cb_creation_film_award);
        mes_requetes_creation_film_combobox.rechercheValeursComboBox("SELECT annee FROM annee", "annee", cb_creation_film_annee_award);
    }

    public objets.C_FILM creerFilmAvecDonnees(){
        // Crée un objet film et le rempli avec les informations du panel.
        objets.C_FILM mon_film_cree = new objets.C_FILM();

        mon_film_cree.setFilm_visa(recupererValeurTF(tf_creation_film_visa));
        mon_film_cree.setMedia_titre(recupererValeurTF(tf_creation_film_titre));
        mon_film_cree.setMedia_annee(recupererValeurTF(tf_creation_film_annee));
        mon_film_cree.setFilm_duree(recupererValeurTF(tf_creation_film_duree));
        mon_film_cree.setFilm_trailer(recupererValeurTF(tf_creation_film_trailer));
        mon_film_cree.setMedia_lien(recupererValeurTF(tf_creation_film_lien));
        mon_film_cree.setFilm_budget(recupererValeurTF(tf_creation_film_budget));
        mon_film_cree.setFilm_saga(recupererValeurTF(tf_creation_film_saga));
        mon_film_cree.setFilm_synop(recupererValeurTA(ta_creation_film_synop));
        if(!isCBVide(cb_creation_film_studio_production)){
            mon_film_cree.setfilm_studio_production(new objets.C_PRODC(cb_creation_film_studio_production.getSelectedItem().toString()));}
        if(li_creation_film_liste_acteurs.getModel().getSize() > 0){
            mon_film_cree.setFilm_acteurs(recupererTousArtistDeList(li_creation_film_liste_acteurs));
        }
        if(li_creation_film_liste_realisateurs.getModel().getSize() > 0){
            mon_film_cree.setFilm_realisateurs(recupererTousArtistDeList(li_creation_film_liste_realisateurs));
        }
        if(li_creation_film_liste_scenaristes.getModel().getSize() > 0){
            mon_film_cree.setFilm_scenaristes(recupererTousArtistDeList(li_creation_film_liste_scenaristes));
        }
        if(li_creation_film_liste_genres.getModel().getSize() > 0){
            mon_film_cree.setFilm_genres(recupererTousGenreDeList(li_creation_film_liste_genres));
        }
        if(li_creation_film_liste_tags.getModel().getSize() > 0){
            mon_film_cree.setFilm_tags(recupererTousTagDeList(li_creation_film_liste_tags));
        }
        ArrayList <String>  film_ceremonie = recupererValeursColonneTableau(tab_creation_film_tab_recompenses, 0);
        ArrayList <String>  film_award = recupererValeursColonneTableau(tab_creation_film_tab_recompenses, 1);
        ArrayList <String>  film_annee_award = recupererValeursColonneTableau(tab_creation_film_tab_recompenses, 2);

        if(film_ceremonie.size() >= 1){ // 
            mon_film_cree.setFilm_ceremonies(recupererTousCeremonieDeArrayList(film_ceremonie));
        }
        if(film_award.size() >= 1){ // 
            mon_film_cree.setFilm_award(recupererTousAwardDeArrayList(film_award));
        }  
        if(film_annee_award.size() >= 1){ // 
            mon_film_cree.setFilm_annee_recompense(recupererTousAnneeAwardDeArrayList(film_annee_award));
        }

        System.out.println(mon_film_cree.toString());

        return mon_film_cree;
    }
}