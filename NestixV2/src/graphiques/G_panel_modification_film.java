package graphiques;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.*;

public class G_panel_modification_film extends A_panel_creation_modification{

    bdd.C_requetes mes_requetes_modification_film_combobox = new bdd.C_requetes();
    objets.C_FILM mon_film_a_modifier = new objets.C_FILM();

	JPanel p_modification_film_infos_base = new JPanel();
    JPanel p_modification_film_infos_artistes = new JPanel();
    JPanel p_modification_film_infos_genres = new JPanel();
    JPanel p_modification_film_infos_tags = new JPanel();
    JPanel p_modification_film_infos_ceremonie = new JPanel();
    JPanel p_modification_film_boutons_validation = new JPanel();
    
    JButton b_modification_film_creer_artiste = new JButton("Creer un artiste ?");
    JButton b_modification_film_ajouter_acteur = new JButton("Ajout acteur");
    JButton b_modification_film_ajouter_realisateur = new JButton("Ajout realisateur");
    JButton b_modification_film_ajouter_scenariste = new JButton("Ajout scenariste");
    JButton b_modification_film_suppr_acteur = new JButton("Suppr acteur");
    JButton b_modification_film_suppr_realisateur = new JButton("Suppr realisateur");
    JButton b_modification_film_suppr_scenariste = new JButton("Suppr scenariste");
    JButton b_modification_film_creer_genre = new JButton("Creer un genre ?");
    JButton b_modification_film_ajouter_genre = new JButton("Ajout genre");
    JButton b_modification_film_suppr_genre = new JButton("Suppr genre");
    JButton b_modification_film_creer_tag = new JButton("Creer un tag ?");
    JButton b_modification_film_ajouter_tag = new JButton("Ajout tag");
    JButton b_modification_film_suppr_tag = new JButton("Suppr tag");
    JButton b_modification_film_creer_ceremonie = new JButton("Creer cérémonie ?");
    JButton b_modification_film_creer_award = new JButton("Creer award ?");
    JButton b_modification_film_ajouter_recompense = new JButton("Ajout récompense");
    JButton b_modification_film_suppr_recompense = new JButton("Suppr récompense");
    JButton b_modification_film_valider_modification = new JButton("Mettre à jour film");
    JButton b_modification_film_valider_brouillon = new JButton("Brouillon");
    JButton b_modification_film_creer_studio_production = new JButton("Créer producteur ?");

    JComboBox cb_modification_film_artiste = new JComboBox<>();
    JComboBox cb_modification_film_genres = new JComboBox<>();
    JComboBox cb_modification_film_tags = new JComboBox<>();
    JComboBox cb_modification_film_ceremonie = new JComboBox<>();
    JComboBox cb_modification_film_award = new JComboBox<>();
    JComboBox cb_modification_film_annee_award = new JComboBox<>();
    JComboBox cb_modification_film_studio_production = new JComboBox<>();

    JLabel l_modification_film_visa = new JLabel("Visa : ");
    JLabel l_modification_film_titre = new JLabel("Titre : ");
    JLabel l_modification_film_annee = new JLabel("Année : ");
    JLabel l_modification_film_duree = new JLabel("Durée : ");
    JLabel l_modification_film_trailer = new JLabel("Trailer : ");
    JLabel l_modification_film_budget = new JLabel("Budget : ");
    JLabel l_modification_film_lien = new JLabel("Lien : ");
    JLabel l_modification_film_saga = new JLabel("Saga : ");
    JLabel l_modification_film_synop = new JLabel("Synopsis : ");
    JLabel l_modification_film_studio_production = new JLabel("Producteur : ");

    JTextField tf_modification_film_visa = new JTextField();
    JTextField tf_modification_film_titre = new JTextField();
    JTextField tf_modification_film_annee = new JTextField();
    JTextField tf_modification_film_duree = new JTextField();
    JTextField tf_modification_film_trailer = new JTextField();
    JTextField tf_modification_film_budget = new JTextField();
    JTextField tf_modification_film_lien = new JTextField();
    JTextField tf_modification_film_saga = new JTextField();
    
    JScrollPane sp_modification_film_synop = new JScrollPane();
    JTextArea ta_modification_film_synop = new JTextArea();
    JScrollPane sp_modification_film_liste_acteurs = new JScrollPane();
    JList li_modification_film_liste_acteurs = new JList<String>();
    JScrollPane sp_modification_film_liste_realisateurs = new JScrollPane();
    JList li_modification_film_liste_realisateurs = new JList<String>();
    JScrollPane sp_modification_film_liste_scenaristes = new JScrollPane();
    JList li_modification_film_liste_scenaristes = new JList<String>();
    JScrollPane sp_modification_film_liste_genres = new JScrollPane();
    JList li_modification_film_liste_genres = new JList<String>();
    JScrollPane sp_modification_film_liste_tags = new JScrollPane();
    JList li_modification_film_liste_tags = new JList<String>();

    JScrollPane sp_modification_film_tab_recompenses = new JScrollPane();
    JTable tab_modification_film_tab_recompenses = new JTable();

    public G_panel_modification_film() {

        this.setLayout(null);
        this.setBackground(Color.GRAY);
        this.setBounds(10,50,1180,630);
        // INFORMATIONS BASES
        
        p_modification_film_infos_base.setBounds(10,10,1160,150);
        p_modification_film_infos_base.setLayout(null);
        p_modification_film_infos_base.setBackground(Color.DARK_GRAY);
        this.add(p_modification_film_infos_base);

        l_modification_film_visa.setBounds(5,5,75,30);
        tf_modification_film_visa.setBounds(80,5,150,30);
        l_modification_film_titre.setBounds(5,40,75,30);
        tf_modification_film_titre.setBounds(80,40,150,30);
        l_modification_film_annee.setBounds(5,75,75,30);
        tf_modification_film_annee.setBounds(80,75,150,30);
        l_modification_film_duree.setBounds(5,110,75,30);
        tf_modification_film_duree.setBounds(80,110,150,30);
        p_modification_film_infos_base.add(l_modification_film_visa);
        p_modification_film_infos_base.add(tf_modification_film_visa);
        p_modification_film_infos_base.add(l_modification_film_titre);
        p_modification_film_infos_base.add(tf_modification_film_titre);
        p_modification_film_infos_base.add(l_modification_film_annee);
        p_modification_film_infos_base.add(tf_modification_film_annee);
        p_modification_film_infos_base.add(l_modification_film_duree);
        p_modification_film_infos_base.add(tf_modification_film_duree);
        l_modification_film_trailer.setBounds(300,5,75,30);
        tf_modification_film_trailer.setBounds(380,5,150,30);
        l_modification_film_lien.setBounds(300,40,75,30);
        tf_modification_film_lien.setBounds(380,40,150,30);
        l_modification_film_budget.setBounds(300,75,75,30);
        tf_modification_film_budget.setBounds(380,75,150,30);
        l_modification_film_saga.setBounds(300,110,75,30);
        tf_modification_film_saga.setBounds(380,110,150,30);
        p_modification_film_infos_base.add(l_modification_film_trailer);
        p_modification_film_infos_base.add(tf_modification_film_trailer);
        p_modification_film_infos_base.add(l_modification_film_lien);
        p_modification_film_infos_base.add(tf_modification_film_lien);
        p_modification_film_infos_base.add(l_modification_film_budget);
        p_modification_film_infos_base.add(tf_modification_film_budget);
        p_modification_film_infos_base.add(l_modification_film_saga);
        p_modification_film_infos_base.add(tf_modification_film_saga);
        l_modification_film_synop.setBounds(710,5,150,20);
        sp_modification_film_synop.setBounds(635,30,200,100);
        sp_modification_film_synop.setViewportView(ta_modification_film_synop);
        p_modification_film_infos_base.add(l_modification_film_synop);
        p_modification_film_infos_base.add(sp_modification_film_synop);

        l_modification_film_studio_production.setBounds(990,5,150,20);
        cb_modification_film_studio_production.setModel(new DefaultComboBoxModel<>(new String[] { "Production"}));
        cb_modification_film_studio_production.setBounds(950,35,150,20);
        b_modification_film_creer_studio_production.setBounds(950,65,150,20);

        p_modification_film_infos_base.add(l_modification_film_studio_production);
        p_modification_film_infos_base.add(cb_modification_film_studio_production);
        p_modification_film_infos_base.add(b_modification_film_creer_studio_production);

        // INFORMATIONS ARTISTES

        p_modification_film_infos_artistes.setBounds(10,180,480,380);
        p_modification_film_infos_artistes.setLayout(null);
        p_modification_film_infos_artistes.setBackground(Color.DARK_GRAY); 
        this.add(p_modification_film_infos_artistes);

        cb_modification_film_artiste.setModel(new DefaultComboBoxModel<>(new String[] { "Artistes"}));
        cb_modification_film_artiste.setBounds(165,10,150,30);
        p_modification_film_infos_artistes.add(cb_modification_film_artiste);
        b_modification_film_creer_artiste.setBounds(165,45,150,30);
        p_modification_film_infos_artistes.add(b_modification_film_creer_artiste);
        b_modification_film_ajouter_acteur.setBounds(15,85,130,30);
        p_modification_film_infos_artistes.add(b_modification_film_ajouter_acteur);
        b_modification_film_ajouter_realisateur.setBounds(175,85,130,30);
        p_modification_film_infos_artistes.add(b_modification_film_ajouter_realisateur);
        b_modification_film_ajouter_scenariste.setBounds(330,85,130,30);
        p_modification_film_infos_artistes.add(b_modification_film_ajouter_scenariste);
        b_modification_film_suppr_acteur.setBounds(15,345,130,30);
        p_modification_film_infos_artistes.add(b_modification_film_suppr_acteur);
        b_modification_film_suppr_realisateur.setBounds(175,345,130,30);
        p_modification_film_infos_artistes.add(b_modification_film_suppr_realisateur);
        b_modification_film_suppr_scenariste.setBounds(330,345,130,30);
        p_modification_film_infos_artistes.add(b_modification_film_suppr_scenariste);


        // INFORMATIONS GENRES

        p_modification_film_infos_genres.setBounds(495,180,170,380);
        p_modification_film_infos_genres.setLayout(null);
        p_modification_film_infos_genres.setBackground(Color.DARK_GRAY);
        this.add(p_modification_film_infos_genres);

        cb_modification_film_genres.setModel(new DefaultComboBoxModel<>(new String[] { "Genres"}));
        cb_modification_film_genres.setBounds(10,10,150,30);
        p_modification_film_infos_genres.add(cb_modification_film_genres); 
        b_modification_film_creer_genre.setBounds(10,45,150,30);
        p_modification_film_infos_genres.add(b_modification_film_creer_genre); 
        b_modification_film_ajouter_genre.setBounds(20,85,130,30);
        p_modification_film_infos_genres.add(b_modification_film_ajouter_genre);
        b_modification_film_suppr_genre.setBounds(20,345,130,30);
        p_modification_film_infos_genres.add(b_modification_film_suppr_genre);
        
        // INFORMATIONS TAGS 

        p_modification_film_infos_tags.setBounds(670,180,170,380);
        p_modification_film_infos_tags.setLayout(null);
        p_modification_film_infos_tags.setBackground(Color.DARK_GRAY);
        this.add(p_modification_film_infos_tags);

        cb_modification_film_tags.setModel(new DefaultComboBoxModel<>(new String[] { "Tags"}));
        cb_modification_film_tags.setBounds(10,10,150,30);
        p_modification_film_infos_tags.add(cb_modification_film_tags);
        b_modification_film_creer_tag.setBounds(10,45,150,30);
        p_modification_film_infos_tags.add(b_modification_film_creer_tag);
        b_modification_film_ajouter_tag.setBounds(20,85,130,30);
        p_modification_film_infos_tags.add(b_modification_film_ajouter_tag);
        b_modification_film_suppr_tag.setBounds(20,345,130,30);
        p_modification_film_infos_tags.add(b_modification_film_suppr_tag);

        // INFORMATIONS CEREMONIE

        p_modification_film_infos_ceremonie.setBounds(845,180,325,380);
        p_modification_film_infos_ceremonie.setLayout(null);
        p_modification_film_infos_ceremonie.setBackground(Color.DARK_GRAY);
        this.add(p_modification_film_infos_ceremonie);

        cb_modification_film_ceremonie.setModel(new DefaultComboBoxModel<>(new String[] { "Ceremonie"}));
        cb_modification_film_award.setModel(new DefaultComboBoxModel<>(new String[] { "Award"}));
        cb_modification_film_annee_award.setModel(new DefaultComboBoxModel<>(new String[] { "Année"}));
        cb_modification_film_ceremonie.setBounds(10,10,150,30);
        p_modification_film_infos_ceremonie.add(cb_modification_film_ceremonie); 
        cb_modification_film_award.setBounds(10,45,150,30);
        p_modification_film_infos_ceremonie.add(cb_modification_film_award); 
        cb_modification_film_annee_award.setBounds(10,80,150,30);
        p_modification_film_infos_ceremonie.add(cb_modification_film_annee_award); 
        b_modification_film_creer_ceremonie.setBounds(170,10,150,30);
        p_modification_film_infos_ceremonie.add(b_modification_film_creer_ceremonie); 
        b_modification_film_creer_award.setBounds(170,45,150,30);
        p_modification_film_infos_ceremonie.add(b_modification_film_creer_award); 
        b_modification_film_ajouter_recompense.setBounds(90,115,150,30);
        p_modification_film_infos_ceremonie.add(b_modification_film_ajouter_recompense); 
        b_modification_film_suppr_recompense.setBounds(90,345,150,30);
        p_modification_film_infos_ceremonie.add(b_modification_film_suppr_recompense); 

        // BOUTONS VALIDATION

        p_modification_film_boutons_validation.setBounds(435,570,315,50);
        p_modification_film_boutons_validation.setLayout(null);
        p_modification_film_boutons_validation.setBackground(Color.DARK_GRAY);
        this.add(p_modification_film_boutons_validation);

        b_modification_film_valider_modification.setBounds(5,5,150,40);
        p_modification_film_boutons_validation.add(b_modification_film_valider_modification);
        b_modification_film_valider_brouillon.setBounds(160,5,150,40);
        p_modification_film_boutons_validation.add(b_modification_film_valider_brouillon);

        // LISTE ACTEURS
        sp_modification_film_liste_acteurs.setBounds(5,120,150,220);
        sp_modification_film_liste_acteurs.setViewportView(li_modification_film_liste_acteurs);
        p_modification_film_infos_artistes.add(sp_modification_film_liste_acteurs);

        // LISTE REALISATEURS
        sp_modification_film_liste_realisateurs.setBounds(165,120,150,220);
        sp_modification_film_liste_realisateurs.setViewportView(li_modification_film_liste_realisateurs);
        p_modification_film_infos_artistes.add(sp_modification_film_liste_realisateurs);
        
        // LISTE SCENARISTE
        sp_modification_film_liste_scenaristes.setBounds(325,120,150,220);
        sp_modification_film_liste_scenaristes.setViewportView(li_modification_film_liste_scenaristes);
        p_modification_film_infos_artistes.add(sp_modification_film_liste_scenaristes);

        // LISTE GENRE
        sp_modification_film_liste_genres.setBounds(5,120,160,220);
        sp_modification_film_liste_genres.setViewportView(li_modification_film_liste_genres);
        p_modification_film_infos_genres.add(sp_modification_film_liste_genres);

        // LISTE TAG  
        sp_modification_film_liste_tags.setBounds(5,120,160,220);
        sp_modification_film_liste_tags.setViewportView(li_modification_film_liste_tags);
        p_modification_film_infos_tags.add(sp_modification_film_liste_tags);

        // LISTE CEREMONIE
        tab_modification_film_tab_recompenses.setModel(new javax.swing.table.DefaultTableModel(
            null,new String [] {"Cérémonie", "Récompense", "Année"}));
        sp_modification_film_tab_recompenses.setBounds(5,150,315,190);
        sp_modification_film_tab_recompenses.setViewportView(tab_modification_film_tab_recompenses);
        p_modification_film_infos_ceremonie.add(sp_modification_film_tab_recompenses);
/*
        mon_film_a_modifier = mon_film_a_modifier.creerFilmAvecId(18);
        this.affichageFilmAModifier(mon_film_a_modifier);*/
    }

    public void affichageComboBoxModificationFilm() throws SQLException {
        mes_requetes_modification_film_combobox.rechercheValeursComboBox("SELECT pc_name FROM pc", "pc_name", cb_modification_film_studio_production);
        mes_requetes_modification_film_combobox.rechercheValeursComboBox("SELECT artist_nickname FROM artist", "artist_nickname", cb_modification_film_artiste);
        mes_requetes_modification_film_combobox.rechercheValeursComboBox("SELECT genre_name FROM genre", "genre_name", cb_modification_film_genres);
        mes_requetes_modification_film_combobox.rechercheValeursComboBox("SELECT tag_name FROM tag", "tag_name", cb_modification_film_tags);
        mes_requetes_modification_film_combobox.rechercheValeursComboBox("SELECT ceremony_name FROM ceremony", "ceremony_name", cb_modification_film_ceremonie);
        mes_requetes_modification_film_combobox.rechercheValeursComboBox("SELECT award_name FROM award", "award_name", cb_modification_film_award);
    }

    public void affichageFilmAModifier(objets.C_FILM mon_film_a_afficher){
        // Rempli les composants avec les infos d'un film
        tf_modification_film_visa.setText(mon_film_a_afficher.getFilm_visa());
        tf_modification_film_titre.setText(mon_film_a_afficher.getMedia_titre());
        tf_modification_film_annee.setText(mon_film_a_afficher.getMedia_annee());
        tf_modification_film_duree.setText(mon_film_a_afficher.getFilm_duree());
        tf_modification_film_trailer.setText(mon_film_a_afficher.getFilm_trailer());
        tf_modification_film_lien.setText(mon_film_a_afficher.getMedia_lien());
        tf_modification_film_budget.setText(mon_film_a_afficher.getFilm_budget());
        tf_modification_film_saga.setText(mon_film_a_afficher.getFilm_saga());
        ta_modification_film_synop.setText(mon_film_a_afficher.getFilm_synop());
        if (mon_film_a_afficher.getfilm_studio_production().size() > 0){
            cb_modification_film_studio_production.setSelectedItem(mon_film_a_afficher.getfilm_studio_production().get(0).getCaracteristiquesNom());}
        if (mon_film_a_afficher.getFilm_acteurs().size()>0){
            this.afficherTabDansList(li_modification_film_liste_acteurs,recupererTousNomsArtiste(mon_film_a_afficher.getFilm_acteurs()));}
        if (mon_film_a_afficher.getFilm_realisateurs().size()>0){
            this.afficherTabDansList(li_modification_film_liste_realisateurs,recupererTousNomsArtiste(mon_film_a_afficher.getFilm_realisateurs()));}
        if (mon_film_a_afficher.getFilm_scenaristes().size()>0){
            this.afficherTabDansList(li_modification_film_liste_scenaristes,recupererTousNomsArtiste(mon_film_a_afficher.getFilm_scenaristes()));}
        if (mon_film_a_afficher.getFilm_genres().size()>0){
            this.afficherTabDansList(li_modification_film_liste_genres,recupererTousNomsCaracteristique(mon_film_a_afficher.getFilm_genres()));}
        if (mon_film_a_afficher.getFilm_tags().size()>0){
            this.afficherTabDansList(li_modification_film_liste_tags,recupererTousNomsCaracteristique(mon_film_a_afficher.getFilm_tags()));}
        if (mon_film_a_afficher.getFilm_ceremonies().size()>0){
        Object [][] mes_recompenses = this.creerDonnesCeremonies(mon_film_a_afficher.getFilm_ceremonies(), mon_film_a_afficher.getFilm_award(), mon_film_a_afficher.getFilm_annee_recompense());
        this.ajouterDonneesDansTabRecompenses(mes_recompenses, tab_modification_film_tab_recompenses);}
    }

    public objets.C_FILM creerFilmAvecDonneesModification(int id){
        // Crée un objet film et le rempli avec les informations du panel.
        objets.C_FILM mon_film_cree_pour_maj = new objets.C_FILM();

        mon_film_cree_pour_maj.setMedia_id(id);
        mon_film_cree_pour_maj.setFilm_visa(recupererValeurTF(tf_modification_film_visa));
        mon_film_cree_pour_maj.setMedia_titre(recupererValeurTF(tf_modification_film_titre));
        mon_film_cree_pour_maj.setMedia_annee(recupererValeurTF(tf_modification_film_annee));
        mon_film_cree_pour_maj.setFilm_duree(recupererValeurTF(tf_modification_film_duree));
        mon_film_cree_pour_maj.setFilm_trailer(recupererValeurTF(tf_modification_film_trailer));
        mon_film_cree_pour_maj.setMedia_lien(recupererValeurTF(tf_modification_film_lien));
        mon_film_cree_pour_maj.setFilm_budget(recupererValeurTF(tf_modification_film_budget));
        mon_film_cree_pour_maj.setFilm_saga(recupererValeurTF(tf_modification_film_saga));
        mon_film_cree_pour_maj.setFilm_synop(recupererValeurTA(ta_modification_film_synop));
        if(!isCBVide(cb_modification_film_studio_production)){
            mon_film_cree_pour_maj.setfilm_studio_production(recupererStudioProductionDeComboBox(cb_modification_film_studio_production));}
        if(li_modification_film_liste_acteurs.getModel().getSize() > 0){
            mon_film_cree_pour_maj.setFilm_acteurs(recupererTousArtistDeList(li_modification_film_liste_acteurs));}
        if(li_modification_film_liste_realisateurs.getModel().getSize() > 0){
            mon_film_cree_pour_maj.setFilm_realisateurs(recupererTousArtistDeList(li_modification_film_liste_realisateurs));}
        if(li_modification_film_liste_scenaristes.getModel().getSize() > 0){
            mon_film_cree_pour_maj.setFilm_scenaristes(recupererTousArtistDeList(li_modification_film_liste_scenaristes));}
        if(li_modification_film_liste_genres.getModel().getSize() > 0){
            mon_film_cree_pour_maj.setFilm_genres(recupererTousGenreDeList(li_modification_film_liste_genres));}
        if(li_modification_film_liste_tags.getModel().getSize() > 0){
            mon_film_cree_pour_maj.setFilm_tags(recupererTousTagDeList(li_modification_film_liste_tags));}
        ArrayList <String>  film_ceremonie = recupererValeursColonneTableau(tab_modification_film_tab_recompenses, 0);
        ArrayList <String>  film_award = recupererValeursColonneTableau(tab_modification_film_tab_recompenses, 1);
        ArrayList <String>  film_annee_award = recupererValeursColonneTableau(tab_modification_film_tab_recompenses, 2);
        if(film_ceremonie.size() > 0){
            mon_film_cree_pour_maj.setFilm_ceremonies(recupererTousCeremonieDeArrayList(film_ceremonie));}
        if(film_award.size() > 0){
            mon_film_cree_pour_maj.setFilm_award(recupererTousAwardDeArrayList(film_award));}  
        if(film_annee_award.size() > 0){
            mon_film_cree_pour_maj.setFilm_annee_recompense(recupererTousAnneeAwardDeArrayList(film_annee_award));}

        System.out.println("Film cree avec données pour maj " +mon_film_cree_pour_maj.toString());
        return mon_film_cree_pour_maj;
    }

}
