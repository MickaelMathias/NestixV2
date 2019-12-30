package graphiques;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;

public class C_events_listener_affichage{

    bdd.C_requetes mes_requetes_events_listener = new bdd.C_requetes();

    G_panel_menu mon_panel_menu = new G_panel_menu();
    G_panel_container_creation mon_panel_container_creation = new G_panel_container_creation();
    G_panel_container_modification mon_panel_container_modification = new G_panel_container_modification();
    G_panel_container_recherche mon_panel_container_recherche = new G_panel_container_recherche();

    objets.C_FILM mon_film_a_modifier = new objets.C_FILM();
    objets.C_CHANSON ma_chanson_a_modifier = new objets.C_CHANSON();
    objets.C_LIVRE mon_livre_a_modifier = new objets.C_LIVRE();
    objets.C_ARTISTE mon_artiste_a_modifier = new objets.C_ARTISTE();

    int sr_film_a_modifier = 0;
    int mon_id_film_a_modifier = 0;
    int sr_chanson_a_modifier = 0;
    int mon_id_chanson_a_modifier = 0;
    int sr_livre_a_modifier = 0;
    int mon_id_livre_a_modifier = 0;
    int sr_artiste_a_modifier = 0;
    int mon_id_artiste_a_modifier = 0;

    public C_events_listener_affichage(){}

    // Initie toutes les fonctions de gestions des évènements. 
    public void initGeneral(){
        this.gestionAffichagePanels();
        this.gestionAffichageRBCreation();
        this.gestionAffichageRBModification();
        this.gestionAffichageRBRecherche();
        this.gestionClicBoutonsCreationFilm();
        this.gestionClicBoutonsCreationLivre();
        this.gestionClicBoutonsCreationChanson();
        this.gestionClicBoutonsCreationArtiste();
        this.gestionClicBoutonsModificationFilm();
        this.gestionClicBoutonsModificationLivre();
        this.gestionClicBoutonsModificationChanson();
        this.gestionClicBoutonsModificationArtiste();
        this.gestionClicBoutonsRechercheFilm();
        this.gestionClicBoutonsRechercheLivre();
        this.gestionClicBoutonsRechercheChanson();
        this.gestionClicBoutonsRechercheArtiste();
}

public void gestionAffichagePanels(){
    /**** Gère l'afffichage des panels en fonction du choix sur les menus ****/
    /** Clic sur le menu Création **/
    mon_panel_menu.get_btn_creation().addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            mon_panel_container_creation.setVisible(true);
            mon_panel_container_recherche.setVisible(false);
            mon_panel_container_modification.setVisible(false);}
    });
    /** Clic sur le menu Recherche **/
    mon_panel_menu.get_btn_recherche().addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            mon_panel_container_creation.setVisible(false);
            mon_panel_container_recherche.setVisible(true);
            mon_panel_container_modification.setVisible(false);}
    });
    /** Clic sur le menu Modification **/
    mon_panel_menu.get_btn_modification().addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            mon_panel_container_creation.setVisible(false);
            mon_panel_container_recherche.setVisible(false);
            mon_panel_container_modification.setVisible(true);}
    });
}
public void gestionAffichageRBCreation(){
    /**** Gère l'afffichage des panels en fonction du choix sur les radioboutons ****/
    /** Clic sur le menu choix Film **/
    mon_panel_container_creation.mon_panel_choix_creation.get_rb_choix_film().addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            mon_panel_container_creation.get_panel_creation_film().setVisible(true);
            mon_panel_container_creation.get_panel_creation_livre().setVisible(false);
            mon_panel_container_creation.get_panel_creation_chanson().setVisible(false);
            mon_panel_container_creation.get_panel_creation_artiste().setVisible(false);
            try{
            mon_panel_container_creation.mon_panel_creation_film.affichageComboBoxCreationFilm();}
            catch (SQLException e){
                e.printStackTrace();}
            }
    });
    /** Clic sur le menu choix Livre **/
    mon_panel_container_creation.mon_panel_choix_creation.get_rb_choix_livre().addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            mon_panel_container_creation.get_panel_creation_film().setVisible(false);
            mon_panel_container_creation.get_panel_creation_livre().setVisible(true);
            mon_panel_container_creation.get_panel_creation_chanson().setVisible(false);
            mon_panel_container_creation.get_panel_creation_artiste().setVisible(false);
            try{
                mon_panel_container_creation.mon_panel_creation_livre.affichageComboBoxCreationLivre();}
                catch (SQLException e){
                    e.printStackTrace();}
            }
    });
    /** Clic sur le menu choix Chanson **/
    mon_panel_container_creation.mon_panel_choix_creation.get_rb_choix_chanson().addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            mon_panel_container_creation.get_panel_creation_film().setVisible(false);
            mon_panel_container_creation.get_panel_creation_livre().setVisible(false);
            mon_panel_container_creation.get_panel_creation_chanson().setVisible(true);
            mon_panel_container_creation.get_panel_creation_artiste().setVisible(false);
            try{
                mon_panel_container_creation.mon_panel_creation_chanson.affichageComboBoxCreationChanson();}
                catch (SQLException e){
                    e.printStackTrace();}      
            }
    });
    /** Clic sur le menu choix Artiste **/
    mon_panel_container_creation.mon_panel_choix_creation.get_rb_choix_artiste().addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            mon_panel_container_creation.get_panel_creation_film().setVisible(false);
            mon_panel_container_creation.get_panel_creation_livre().setVisible(false);
            mon_panel_container_creation.get_panel_creation_chanson().setVisible(false);
            mon_panel_container_creation.get_panel_creation_artiste().setVisible(true);                
            try{
                mon_panel_container_creation.mon_panel_creation_artiste.affichageComboBoxCreationArtiste();}
                catch (SQLException e){
                    e.printStackTrace();}
            }
    });
}
public void gestionAffichageRBModification(){
    /**** Gère l'afffichage des panels en fonction du choix sur les radioboutons ****/
    /** Clic sur le menu choix Film **/
    mon_panel_container_modification.mon_panel_choix_modification.get_rb_choix_film().addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            mon_panel_container_modification.get_panel_modification_film().setVisible(true);
            mon_panel_container_modification.get_panel_modification_livre().setVisible(false);
            mon_panel_container_modification.get_panel_modification_chanson().setVisible(false);
            mon_panel_container_modification.get_panel_modification_artiste().setVisible(false);
            try{
               if(mon_panel_container_modification.mon_panel_modification_film.cb_modification_film_studio_production.getSelectedItem().equals("Production")){
                mon_panel_container_modification.mon_panel_modification_film.affichageComboBoxModificationFilm();}}
                catch (SQLException e){
                    e.printStackTrace();}
            }
    });
    /** Clic sur le menu choix Livre **/
    mon_panel_container_modification.mon_panel_choix_modification.get_rb_choix_livre().addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            mon_panel_container_modification.get_panel_modification_film().setVisible(false);
            mon_panel_container_modification.get_panel_modification_livre().setVisible(true);
            mon_panel_container_modification.get_panel_modification_chanson().setVisible(false);
            mon_panel_container_modification.get_panel_modification_artiste().setVisible(false);
            try{
                if(mon_panel_container_modification.mon_panel_modification_livre.cb_modification_livre_studio_production.getSelectedItem().equals("Editeur")){
                    mon_panel_container_modification.mon_panel_modification_livre.affichageComboBoxModificationLivre();}}
                catch (SQLException e){
                    e.printStackTrace();}
            }
    });
    /** Clic sur le menu choix Chanson **/
    mon_panel_container_modification.mon_panel_choix_modification.get_rb_choix_chanson().addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            mon_panel_container_modification.get_panel_modification_film().setVisible(false);
            mon_panel_container_modification.get_panel_modification_livre().setVisible(false);
            mon_panel_container_modification.get_panel_modification_chanson().setVisible(true);
            mon_panel_container_modification.get_panel_modification_artiste().setVisible(false);
            try{
                if(mon_panel_container_modification.mon_panel_modification_chanson.cb_modification_chanson_studio_production.getSelectedItem().equals("Label")){
                    mon_panel_container_modification.mon_panel_modification_chanson.affichageComboBoxModificationChanson();}}
                catch (SQLException e){
                    e.printStackTrace();}       
        }
    });
    /** Clic sur le menu choix Artiste **/
    mon_panel_container_modification.mon_panel_choix_modification.get_rb_choix_artiste().addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            mon_panel_container_modification.get_panel_modification_film().setVisible(false);
            mon_panel_container_modification.get_panel_modification_livre().setVisible(false);
            mon_panel_container_modification.get_panel_modification_chanson().setVisible(false);
            mon_panel_container_modification.get_panel_modification_artiste().setVisible(true);
            try{
                mon_panel_container_modification.mon_panel_modification_artiste.affichageComboBoxModificationArtiste();}
                catch (SQLException e){
                    e.printStackTrace();
                }
            }
    });
}
public void gestionAffichageRBRecherche(){
    /**** Gère l'afffichage des panels en fonction du choix sur les radioboutons ****/
    /** Clic sur le menu choix Film **/
    mon_panel_container_recherche.mon_panel_choix_recherche.get_rb_choix_film().addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            mon_panel_container_recherche.get_panel_recherche_film().setVisible(true);
            mon_panel_container_recherche.get_panel_recherche_livre().setVisible(false);
            mon_panel_container_recherche.get_panel_recherche_chanson().setVisible(false);
            mon_panel_container_recherche.get_panel_recherche_artiste().setVisible(false);    
            try{
                mon_panel_container_recherche.mon_panel_recherche_film.affichageComboBoxRechercheFilm();}
                catch (SQLException e){
                    e.printStackTrace();}
            }
    });
    /** Clic sur le menu choix Livre **/
    mon_panel_container_recherche.mon_panel_choix_recherche.get_rb_choix_livre().addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            mon_panel_container_recherche.get_panel_recherche_film().setVisible(false);
            mon_panel_container_recherche.get_panel_recherche_livre().setVisible(true);
            mon_panel_container_recherche.get_panel_recherche_chanson().setVisible(false);
            mon_panel_container_recherche.get_panel_recherche_artiste().setVisible(false);    
            try{
                mon_panel_container_recherche.mon_panel_recherche_livre.affichageComboBoxRechercheLivre();}
                catch (SQLException e){
                    e.printStackTrace();}
            }
    });
    /** Clic sur le menu choix Chanson **/
    mon_panel_container_recherche.mon_panel_choix_recherche.get_rb_choix_chanson().addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            mon_panel_container_recherche.get_panel_recherche_film().setVisible(false);
            mon_panel_container_recherche.get_panel_recherche_livre().setVisible(false);
            mon_panel_container_recherche.get_panel_recherche_chanson().setVisible(true);
            mon_panel_container_recherche.get_panel_recherche_artiste().setVisible(false);    
            try{
                mon_panel_container_recherche.mon_panel_recherche_chanson.affichageComboBoxRechercheChanson();}
                catch (SQLException e){
                    e.printStackTrace();}
            }
    });
    /** Clic sur le menu choix Artiste **/
    mon_panel_container_recherche.mon_panel_choix_recherche.get_rb_choix_artiste().addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            mon_panel_container_recherche.get_panel_recherche_film().setVisible(false);
            mon_panel_container_recherche.get_panel_recherche_livre().setVisible(false);
            mon_panel_container_recherche.get_panel_recherche_chanson().setVisible(false);
            mon_panel_container_recherche.get_panel_recherche_artiste().setVisible(true);    
            try{
                mon_panel_container_recherche.mon_panel_recherche_artiste.affichageComboBoxRechercheArtiste();}
                catch (SQLException e){
                    e.printStackTrace();}
            }
    });
}

public void gestionClicBoutonsCreationFilm(){
    mon_panel_container_creation.mon_panel_creation_film.b_creation_film_valider_creation.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            // Verification si année et titre vides
            if (mon_panel_container_creation.mon_panel_creation_film.tf_creation_film_titre.getText().equals("") || mon_panel_container_creation.mon_panel_creation_film.tf_creation_film_annee.getText().equals("")){
                javax.swing.JOptionPane.showMessageDialog(mon_panel_container_creation.mon_panel_creation_film, "Titre et année obligatoires.");  
                mon_panel_container_creation.mon_panel_creation_film.tf_creation_film_titre.setBackground(Color.RED);
                mon_panel_container_creation.mon_panel_creation_film.tf_creation_film_annee.setBackground(Color.RED);
            }
            else{
                System.out.println("Création d'un film");
                mon_panel_container_creation.mon_panel_creation_film.tf_creation_film_titre.setBackground(Color.WHITE);
                mon_panel_container_creation.mon_panel_creation_film.tf_creation_film_annee.setBackground(Color.WHITE);
                objets.C_FILM mon_film_a_creer = new objets.C_FILM();
                mon_film_a_creer = mon_panel_container_creation.mon_panel_creation_film.creerFilmAvecDonneesCreation();
                mon_film_a_creer.creationMediaBdd(1);
                mon_film_a_creer.creationFilmBdd();
                mon_film_a_creer.creationArtisteBdd(1, mon_film_a_creer.getFilm_acteurs());
                mon_film_a_creer.creationArtisteBdd(4, mon_film_a_creer.getFilm_realisateurs());
                mon_film_a_creer.creationArtisteBdd(5, mon_film_a_creer.getFilm_scenaristes());
                mon_film_a_creer.creationCaracteristiquesBdd(mon_film_a_creer.getFilm_genres(), "genre", "categorized_by");
                mon_film_a_creer.creationCaracteristiquesBdd(mon_film_a_creer.getFilm_tags(), "tag", "is_associated_with");
                mon_film_a_creer.creationCaracteristiquesBdd(mon_film_a_creer.getfilm_studio_production(), "pc", "produced_by");
                mon_film_a_creer.creationRecompensesBdd(mon_film_a_creer.getFilm_ceremonies(),mon_film_a_creer.getFilm_award(), mon_film_a_creer.getFilm_annee_recompense());

                javax.swing.JOptionPane.showMessageDialog(mon_panel_container_creation, "Le film "+mon_film_a_creer.getMedia_titre()+" a bien été ajouté.");
            }
        }         
    });
    mon_panel_container_creation.mon_panel_creation_film.b_creation_film_valider_brouillon.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            // Verif si année et titre vides
            if (mon_panel_container_creation.mon_panel_creation_film.tf_creation_film_titre.getText().equals("") || mon_panel_container_creation.mon_panel_creation_film.tf_creation_film_annee.getText().equals("")){
                javax.swing.JOptionPane.showMessageDialog(mon_panel_container_creation.mon_panel_creation_film, "Titre et année obligatoires.");  
                mon_panel_container_creation.mon_panel_creation_film.tf_creation_film_titre.setBackground(Color.RED);
                mon_panel_container_creation.mon_panel_creation_film.tf_creation_film_annee.setBackground(Color.RED);
            }
            else{
                System.out.println("Création d'un film en brouillon");
                mon_panel_container_creation.mon_panel_creation_film.tf_creation_film_titre.setBackground(Color.WHITE);
                mon_panel_container_creation.mon_panel_creation_film.tf_creation_film_annee.setBackground(Color.WHITE);
                objets.C_FILM mon_film_a_creer = new objets.C_FILM();
                mon_film_a_creer = mon_panel_container_creation.mon_panel_creation_film.creerFilmAvecDonneesCreation();
                mon_film_a_creer.creationMediaBdd(2);
                mon_film_a_creer.creationFilmBdd();
                mon_film_a_creer.creationArtisteBdd(1, mon_film_a_creer.getFilm_acteurs());
                mon_film_a_creer.creationArtisteBdd(4, mon_film_a_creer.getFilm_realisateurs());
                mon_film_a_creer.creationArtisteBdd(5, mon_film_a_creer.getFilm_scenaristes());
                mon_film_a_creer.creationCaracteristiquesBdd(mon_film_a_creer.getFilm_genres(), "genre", "categorized_by");
                mon_film_a_creer.creationCaracteristiquesBdd(mon_film_a_creer.getFilm_tags(), "tag", "is_associated_with");
                mon_film_a_creer.creationCaracteristiquesBdd(mon_film_a_creer.getfilm_studio_production(), "pc", "produced_by");
                mon_film_a_creer.creationRecompensesBdd(mon_film_a_creer.getFilm_ceremonies(),mon_film_a_creer.getFilm_award(), mon_film_a_creer.getFilm_annee_recompense());

                javax.swing.JOptionPane.showMessageDialog(mon_panel_container_creation, "Le film "+mon_film_a_creer.getMedia_titre()+" a bien été ajouté aux brouillons.");
            }
        }         
    });
    mon_panel_container_creation.mon_panel_creation_film.b_creation_film_creer_studio_production.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            String nom_pc = JOptionPane.showInputDialog(mon_panel_container_creation.mon_panel_creation_film, "Donnez un nom au producteur.");
            if (!nom_pc.equals(null)){
            mon_panel_container_creation.mon_panel_creation_film.creerCaracteristiqueVolee("pc",nom_pc);
            mes_requetes_events_listener.rechercheValeursComboBox("SELECT pc_name FROM pc", "pc_name", mon_panel_container_creation.mon_panel_creation_film.cb_creation_film_studio_production);
            javax.swing.JOptionPane.showMessageDialog(mon_panel_container_creation, "Producteur bien ajouté");}
        }
    });
    mon_panel_container_creation.mon_panel_creation_film.b_creation_film_creer_artiste.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            String nickname = JOptionPane.showInputDialog(mon_panel_container_creation.mon_panel_creation_film, "Donnez un surnom à l'artiste.");
            System.out.println(nickname);
            if (!nickname.equals(null)){
            mon_panel_container_creation.mon_panel_creation_film.creerArtisteVolee(nickname);
            mes_requetes_events_listener.rechercheValeursComboBox("SELECT artist_nickname FROM artist", "artist_nickname", mon_panel_container_creation.mon_panel_creation_film.cb_creation_film_artiste);
            javax.swing.JOptionPane.showMessageDialog(mon_panel_container_creation, "Artiste bien ajouté aux brouillons");}
        }
    });
    mon_panel_container_creation.mon_panel_creation_film.b_creation_film_creer_genre.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            String nom_genre = JOptionPane.showInputDialog(mon_panel_container_creation.mon_panel_creation_film, "Donnez un nom au genre.");
            if (!nom_genre.equals(null)){
            mon_panel_container_creation.mon_panel_creation_film.creerCaracteristiqueVolee("genre",nom_genre);
            mes_requetes_events_listener.rechercheValeursComboBox("SELECT genre_name FROM genre", "genre_name", mon_panel_container_creation.mon_panel_creation_film.cb_creation_film_genres);
            javax.swing.JOptionPane.showMessageDialog(mon_panel_container_creation, "Genre bien ajouté");}
        }
    });
    mon_panel_container_creation.mon_panel_creation_film.b_creation_film_creer_tag.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            String nom_tag = JOptionPane.showInputDialog(mon_panel_container_creation.mon_panel_creation_film, "Donnez un nom au tag ?");
            if (!nom_tag.equals(null)){
            mon_panel_container_creation.mon_panel_creation_film.creerCaracteristiqueVolee("tag",nom_tag);
            mes_requetes_events_listener.rechercheValeursComboBox("SELECT tag_name FROM tag", "tag_name", mon_panel_container_creation.mon_panel_creation_film.cb_creation_film_tags);
            javax.swing.JOptionPane.showMessageDialog(mon_panel_container_creation, "Tag bien ajouté");}
        }
    });
    mon_panel_container_creation.mon_panel_creation_film.b_creation_film_creer_ceremonie.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            String nom_ceremonie = JOptionPane.showInputDialog(mon_panel_container_creation.mon_panel_creation_film, "Donnez un nom à la cérémonie ?");
            if (!nom_ceremonie.equals(null)){
            mon_panel_container_creation.mon_panel_creation_film.creerCaracteristiqueVolee("ceremony",nom_ceremonie);
            mes_requetes_events_listener.rechercheValeursComboBox("SELECT ceremony_name FROM ceremony", "ceremony_name", mon_panel_container_creation.mon_panel_creation_film.cb_creation_film_ceremonie);
            javax.swing.JOptionPane.showMessageDialog(mon_panel_container_creation, "Ceremoniée bien ajoutée");}
        }
    });
    mon_panel_container_creation.mon_panel_creation_film.b_creation_film_creer_award.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            String nom_award = JOptionPane.showInputDialog(mon_panel_container_creation.mon_panel_creation_film, "Donnez un nom à la récompense ?");
            if (!nom_award.equals(null)){
            mon_panel_container_creation.mon_panel_creation_film.creerCaracteristiqueVolee("award",nom_award);
            mes_requetes_events_listener.rechercheValeursComboBox("SELECT award_name FROM award", "award_name", mon_panel_container_creation.mon_panel_creation_film.cb_creation_film_award);
            javax.swing.JOptionPane.showMessageDialog(mon_panel_container_creation, "Récompense bien ajoutée");}
        }
    });
    mon_panel_container_creation.mon_panel_creation_film.b_creation_film_ajouter_acteur.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            if (!mon_panel_container_creation.mon_panel_creation_film.cb_creation_film_artiste.getSelectedItem().toString().equals("Choisissez")){
                if (!mon_panel_container_creation.mon_panel_creation_film.verifierPresenceStringDansList(mon_panel_container_creation.mon_panel_creation_film.li_creation_film_liste_acteurs, mon_panel_container_creation.mon_panel_creation_film.cb_creation_film_artiste)){
                System.out.println("Ajout d'un acteur");
                mon_panel_container_creation.mon_panel_creation_film.ajouterElementList(mon_panel_container_creation.mon_panel_creation_film.li_creation_film_liste_acteurs, mon_panel_container_creation.mon_panel_creation_film.cb_creation_film_artiste.getSelectedItem().toString());}
                else{
                    javax.swing.JOptionPane.showMessageDialog(mon_panel_container_creation, "Erreur : Impossible d'ajouter 2 acteurs identiques.");}}
            else{
                JOptionPane.showMessageDialog(mon_panel_container_creation, "Veuillez d'abord selectionner un artiste");
            }
        }                  
    });
    mon_panel_container_creation.mon_panel_creation_film.b_creation_film_ajouter_realisateur.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            if (!mon_panel_container_creation.mon_panel_creation_film.verifierPresenceStringDansList(mon_panel_container_creation.mon_panel_creation_film.li_creation_film_liste_realisateurs, mon_panel_container_creation.mon_panel_creation_film.cb_creation_film_artiste)){
                System.out.println("Ajout d'un realisateur");
                mon_panel_container_creation.mon_panel_creation_film.ajouterElementList(mon_panel_container_creation.mon_panel_creation_film.li_creation_film_liste_realisateurs, mon_panel_container_creation.mon_panel_creation_film.cb_creation_film_artiste.getSelectedItem().toString());}
                else{
                    javax.swing.JOptionPane.showMessageDialog(mon_panel_container_creation, "Erreur : Impossible d'ajouter 2 realisateurs identiques.");}
            }
    });
    mon_panel_container_creation.mon_panel_creation_film.b_creation_film_ajouter_scenariste.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            if (!mon_panel_container_creation.mon_panel_creation_film.verifierPresenceStringDansList(mon_panel_container_creation.mon_panel_creation_film.li_creation_film_liste_scenaristes, mon_panel_container_creation.mon_panel_creation_film.cb_creation_film_artiste)){
                System.out.println("Ajout d'un scenariste");
                mon_panel_container_creation.mon_panel_creation_film.ajouterElementList(mon_panel_container_creation.mon_panel_creation_film.li_creation_film_liste_scenaristes, mon_panel_container_creation.mon_panel_creation_film.cb_creation_film_artiste.getSelectedItem().toString());}
                else{
                    javax.swing.JOptionPane.showMessageDialog(mon_panel_container_creation, "Erreur : Impossible d'ajouter 2 scenaristes identiques.");}
            }    
    });
    mon_panel_container_creation.mon_panel_creation_film.b_creation_film_ajouter_genre.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            if (!mon_panel_container_creation.mon_panel_creation_film.verifierPresenceStringDansList(mon_panel_container_creation.mon_panel_creation_film.li_creation_film_liste_genres, mon_panel_container_creation.mon_panel_creation_film.cb_creation_film_genres)){
                System.out.println("Ajout d'un genre");
                mon_panel_container_creation.mon_panel_creation_film.ajouterElementList(mon_panel_container_creation.mon_panel_creation_film.li_creation_film_liste_genres, mon_panel_container_creation.mon_panel_creation_film.cb_creation_film_genres.getSelectedItem().toString());}
                else{
                    javax.swing.JOptionPane.showMessageDialog(mon_panel_container_creation, "Erreur : Impossible d'ajouter 2 genres identiques.");}
            }    
    });
    mon_panel_container_creation.mon_panel_creation_film.b_creation_film_ajouter_tag.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            if (!mon_panel_container_creation.mon_panel_creation_film.verifierPresenceStringDansList(mon_panel_container_creation.mon_panel_creation_film.li_creation_film_liste_tags, mon_panel_container_creation.mon_panel_creation_film.cb_creation_film_tags)){
                System.out.println("Ajout d'un tag");
                mon_panel_container_creation.mon_panel_creation_film.ajouterElementList(mon_panel_container_creation.mon_panel_creation_film.li_creation_film_liste_tags, mon_panel_container_creation.mon_panel_creation_film.cb_creation_film_tags.getSelectedItem().toString());}
                else{
                    javax.swing.JOptionPane.showMessageDialog(mon_panel_container_creation, "Erreur : Impossible d'ajouter 2 tags identiques.");}
            }     
    });
    mon_panel_container_creation.mon_panel_creation_film.b_creation_film_suppr_acteur.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            System.out.println("Suppresion d'un acteur");
            mon_panel_container_creation.mon_panel_creation_film.retirerElementList(mon_panel_container_creation.mon_panel_creation_film.li_creation_film_liste_acteurs, mon_panel_container_creation.mon_panel_creation_film.li_creation_film_liste_acteurs.getSelectedIndex());
        }         
    });
    mon_panel_container_creation.mon_panel_creation_film.b_creation_film_suppr_realisateur.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            System.out.println("Suppresion d'un realisateur");
            mon_panel_container_creation.mon_panel_creation_film.retirerElementList(mon_panel_container_creation.mon_panel_creation_film.li_creation_film_liste_realisateurs, mon_panel_container_creation.mon_panel_creation_film.li_creation_film_liste_realisateurs.getSelectedIndex());
        }         
    });
    mon_panel_container_creation.mon_panel_creation_film.b_creation_film_suppr_scenariste.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            System.out.println("Suppresion d'un scenariste");
            mon_panel_container_creation.mon_panel_creation_film.retirerElementList(mon_panel_container_creation.mon_panel_creation_film.li_creation_film_liste_scenaristes, mon_panel_container_creation.mon_panel_creation_film.li_creation_film_liste_scenaristes.getSelectedIndex());
        }         
    });
    mon_panel_container_creation.mon_panel_creation_film.b_creation_film_suppr_genre.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            System.out.println("Suppresion d'un genre");
            mon_panel_container_creation.mon_panel_creation_film.retirerElementList(mon_panel_container_creation.mon_panel_creation_film.li_creation_film_liste_genres, mon_panel_container_creation.mon_panel_creation_film.li_creation_film_liste_genres.getSelectedIndex());
        }         
    });
    mon_panel_container_creation.mon_panel_creation_film.b_creation_film_suppr_tag.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            System.out.println("Suppresion d'un tag");
            mon_panel_container_creation.mon_panel_creation_film.retirerElementList(mon_panel_container_creation.mon_panel_creation_film.li_creation_film_liste_tags, mon_panel_container_creation.mon_panel_creation_film.li_creation_film_liste_tags.getSelectedIndex());
        }         
    });
    mon_panel_container_creation.mon_panel_creation_film.b_creation_film_ajouter_recompense.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            System.out.println("Ajout d'un element dans le tableau récompense");
            if (mon_panel_container_creation.mon_panel_creation_film.cb_creation_film_ceremonie.getSelectedItem().toString().equals("Choisissez") || mon_panel_container_creation.mon_panel_creation_film.cb_creation_film_award.getSelectedItem().toString().equals("Choisissez") ){
                javax.swing.JOptionPane.showMessageDialog(mon_panel_container_creation.mon_panel_creation_film, "Erreur : Cérémonie et Award obligatoires");}
            else {
                Object [][] ceremonie_a_ajouter = {{mon_panel_container_creation.mon_panel_creation_film.cb_creation_film_ceremonie.getSelectedItem().toString(), mon_panel_container_creation.mon_panel_creation_film.cb_creation_film_award.getSelectedItem().toString(), mon_panel_container_creation.mon_panel_creation_film.recupererValeurCB(mon_panel_container_creation.mon_panel_creation_film.cb_creation_film_annee_award)}}; 
                mon_panel_container_creation.mon_panel_creation_film.ajouterDonneesDansTabRecompenses(ceremonie_a_ajouter, mon_panel_container_creation.mon_panel_creation_film.tab_creation_film_tab_recompenses);
            }
        }         
    });
    mon_panel_container_creation.mon_panel_creation_film.b_creation_film_suppr_recompense.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            System.out.println("Suppresion d'un element du tableau récompense");
            mon_panel_container_creation.mon_panel_creation_film.retirerElementDansTabRecompenses(mon_panel_container_creation.mon_panel_creation_film.tab_creation_film_tab_recompenses);
        }         
    });
}
public void gestionClicBoutonsCreationLivre(){
    mon_panel_container_creation.mon_panel_creation_livre.b_creation_livre_valider_creation.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            // Verif si année et titre vides
            if (mon_panel_container_creation.mon_panel_creation_livre.tf_creation_livre_titre.getText().equals("") || mon_panel_container_creation.mon_panel_creation_livre.tf_creation_livre_annee.getText().equals("")){
                javax.swing.JOptionPane.showMessageDialog(mon_panel_container_creation.mon_panel_creation_livre, "Titre et année obligatoires.");  
                mon_panel_container_creation.mon_panel_creation_livre.tf_creation_livre_titre.setBackground(Color.RED);
                mon_panel_container_creation.mon_panel_creation_livre.tf_creation_livre_annee.setBackground(Color.RED);
            }
            else{
                System.out.println("Création d'un livre");
                mon_panel_container_creation.mon_panel_creation_livre.tf_creation_livre_titre.setBackground(Color.WHITE);
                mon_panel_container_creation.mon_panel_creation_livre.tf_creation_livre_annee.setBackground(Color.WHITE);
                objets.C_LIVRE mon_livre_a_creer = new objets.C_LIVRE();
                
                mon_livre_a_creer = mon_panel_container_creation.mon_panel_creation_livre.creerLivreAvecDonneesCreation();
                mon_livre_a_creer.creationMediaBdd(1);
                mon_livre_a_creer.creationLivreBdd();
                mon_livre_a_creer.creationArtisteBdd(3, mon_livre_a_creer.getLivre_ecrivains());
                mon_livre_a_creer.creationCaracteristiquesBdd(mon_livre_a_creer.getLivre_genres(), "genre", "categorized_by");
                mon_livre_a_creer.creationCaracteristiquesBdd(mon_livre_a_creer.getLivre_tags(), "tag", "is_associated_with");
                mon_livre_a_creer.creationCaracteristiquesBdd(mon_livre_a_creer.getLivre_studio_production(), "pc", "produced_by");
                mon_livre_a_creer.creationRecompensesBdd(mon_livre_a_creer.getLivre_ceremonies(),mon_livre_a_creer.getLivre_award(), mon_livre_a_creer.getLivre_annees_recompenses());

                javax.swing.JOptionPane.showMessageDialog(mon_panel_container_creation, "Le livre "+mon_livre_a_creer.getMedia_titre()+" a bien été ajouté.");
            }
        }         
    });
    mon_panel_container_creation.mon_panel_creation_livre.b_creation_livre_valider_brouillon.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            // Verif si année et titre vides
            if (mon_panel_container_creation.mon_panel_creation_livre.tf_creation_livre_titre.getText().equals("") || mon_panel_container_creation.mon_panel_creation_livre.tf_creation_livre_annee.getText().equals("")){
                javax.swing.JOptionPane.showMessageDialog(mon_panel_container_creation.mon_panel_creation_livre, "Titre et année obligatoires.");  
                mon_panel_container_creation.mon_panel_creation_livre.tf_creation_livre_titre.setBackground(Color.RED);
                mon_panel_container_creation.mon_panel_creation_livre.tf_creation_livre_annee.setBackground(Color.RED);
            }
            else{
                System.out.println("Création d'un livre en brouillon");
                mon_panel_container_creation.mon_panel_creation_livre.tf_creation_livre_titre.setBackground(Color.WHITE);
                mon_panel_container_creation.mon_panel_creation_livre.tf_creation_livre_annee.setBackground(Color.WHITE);
                objets.C_LIVRE mon_livre_a_creer = new objets.C_LIVRE();
                
                mon_livre_a_creer = mon_panel_container_creation.mon_panel_creation_livre.creerLivreAvecDonneesCreation();
                mon_livre_a_creer.creationMediaBdd(2);
                mon_livre_a_creer.creationLivreBdd();
                mon_livre_a_creer.creationArtisteBdd(3, mon_livre_a_creer.getLivre_ecrivains());
                mon_livre_a_creer.creationCaracteristiquesBdd(mon_livre_a_creer.getLivre_genres(), "genre", "categorized_by");
                mon_livre_a_creer.creationCaracteristiquesBdd(mon_livre_a_creer.getLivre_tags(), "tag", "is_associated_with");
                mon_livre_a_creer.creationCaracteristiquesBdd(mon_livre_a_creer.getLivre_studio_production(), "pc", "produced_by");
                mon_livre_a_creer.creationRecompensesBdd(mon_livre_a_creer.getLivre_ceremonies(),mon_livre_a_creer.getLivre_award(), mon_livre_a_creer.getLivre_annees_recompenses());

                javax.swing.JOptionPane.showMessageDialog(mon_panel_container_creation, "Le livre "+mon_livre_a_creer.getMedia_titre()+" a bien été ajouté aux brouillons.");
            }
        }         
    });
    mon_panel_container_creation.mon_panel_creation_livre.b_creation_livre_ajouter_ecrivain.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            if (!mon_panel_container_creation.mon_panel_creation_livre.verifierPresenceStringDansList(mon_panel_container_creation.mon_panel_creation_livre.li_creation_livre_liste_ecrivains, mon_panel_container_creation.mon_panel_creation_livre.cb_creation_livre_artiste)){
            System.out.println("Ajout d'un ecrivain");
            mon_panel_container_creation.mon_panel_creation_livre.ajouterElementList(mon_panel_container_creation.mon_panel_creation_livre.li_creation_livre_liste_ecrivains, mon_panel_container_creation.mon_panel_creation_livre.cb_creation_livre_artiste.getSelectedItem().toString());}
            else{
                javax.swing.JOptionPane.showMessageDialog(mon_panel_container_creation, "Erreur : Impossible d'ajouter 2 ecrivains identiques.");}
        }                 
    });
    mon_panel_container_creation.mon_panel_creation_livre.b_creation_livre_ajouter_genre.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            if (!mon_panel_container_creation.mon_panel_creation_livre.verifierPresenceStringDansList(mon_panel_container_creation.mon_panel_creation_livre.li_creation_livre_liste_genres, mon_panel_container_creation.mon_panel_creation_livre.cb_creation_livre_genres)){
                System.out.println("Ajout d'un genre");
                mon_panel_container_creation.mon_panel_creation_livre.ajouterElementList(mon_panel_container_creation.mon_panel_creation_livre.li_creation_livre_liste_genres, mon_panel_container_creation.mon_panel_creation_livre.cb_creation_livre_genres.getSelectedItem().toString());}
                else{
                    javax.swing.JOptionPane.showMessageDialog(mon_panel_container_creation, "Erreur : Impossible d'ajouter 2 genres identiques.");}
            }    
    });
    mon_panel_container_creation.mon_panel_creation_livre.b_creation_livre_ajouter_tag.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            if (!mon_panel_container_creation.mon_panel_creation_livre.verifierPresenceStringDansList(mon_panel_container_creation.mon_panel_creation_livre.li_creation_livre_liste_tags, mon_panel_container_creation.mon_panel_creation_livre.cb_creation_livre_tags)){
                System.out.println("Ajout d'un tag");
                mon_panel_container_creation.mon_panel_creation_livre.ajouterElementList(mon_panel_container_creation.mon_panel_creation_livre.li_creation_livre_liste_tags, mon_panel_container_creation.mon_panel_creation_livre.cb_creation_livre_tags.getSelectedItem().toString());}
                else{
                    javax.swing.JOptionPane.showMessageDialog(mon_panel_container_creation, "Erreur : Impossible d'ajouter 2 tags identiques.");}
            }     
    });
    mon_panel_container_creation.mon_panel_creation_livre.b_creation_livre_suppr_ecrivain.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            System.out.println("Suppresion d'un acteur");
            mon_panel_container_creation.mon_panel_creation_livre.retirerElementList(mon_panel_container_creation.mon_panel_creation_livre.li_creation_livre_liste_ecrivains, mon_panel_container_creation.mon_panel_creation_livre.li_creation_livre_liste_ecrivains.getSelectedIndex());
        }         
    });
    mon_panel_container_creation.mon_panel_creation_livre.b_creation_livre_suppr_genre.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            System.out.println("Suppresion d'un genre");
            mon_panel_container_creation.mon_panel_creation_livre.retirerElementList(mon_panel_container_creation.mon_panel_creation_livre.li_creation_livre_liste_genres, mon_panel_container_creation.mon_panel_creation_livre.li_creation_livre_liste_genres.getSelectedIndex());
        }         
    });
    mon_panel_container_creation.mon_panel_creation_livre.b_creation_livre_suppr_tag.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            System.out.println("Suppresion d'un tag");
            mon_panel_container_creation.mon_panel_creation_livre.retirerElementList(mon_panel_container_creation.mon_panel_creation_livre.li_creation_livre_liste_tags, mon_panel_container_creation.mon_panel_creation_livre.li_creation_livre_liste_tags.getSelectedIndex());
        }         
    });

    mon_panel_container_creation.mon_panel_creation_livre.b_creation_livre_ajouter_recompense.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            System.out.println("Ajout d'un element dans le tableau récompense");
            if (mon_panel_container_creation.mon_panel_creation_livre.cb_creation_livre_ceremonie.getSelectedItem().toString().equals("Choisissez") || mon_panel_container_creation.mon_panel_creation_livre.cb_creation_livre_award.getSelectedItem().toString().equals("Choisissez") ){
                javax.swing.JOptionPane.showMessageDialog(mon_panel_container_creation.mon_panel_creation_livre, "Erreur : Cérémonie et Award obligatoires");}
            else {
                Object [][] ceremonie_a_ajouter = {{mon_panel_container_creation.mon_panel_creation_livre.cb_creation_livre_ceremonie.getSelectedItem().toString(), mon_panel_container_creation.mon_panel_creation_livre.cb_creation_livre_award.getSelectedItem().toString(), mon_panel_container_creation.mon_panel_creation_livre.recupererValeurCB(mon_panel_container_creation.mon_panel_creation_livre.cb_creation_livre_annee_award)}}; 
                mon_panel_container_creation.mon_panel_creation_livre.ajouterDonneesDansTabRecompenses(ceremonie_a_ajouter, mon_panel_container_creation.mon_panel_creation_livre.tab_creation_livre_tab_recompenses);
            }
        }         
    });
    mon_panel_container_creation.mon_panel_creation_livre.b_creation_livre_suppr_recompense.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            System.out.println("Suppresion d'un element du tableau récompense");
            mon_panel_container_creation.mon_panel_creation_livre.retirerElementDansTabRecompenses(mon_panel_container_creation.mon_panel_creation_livre.tab_creation_livre_tab_recompenses);
        }         
    });
}
public void gestionClicBoutonsCreationChanson(){
    mon_panel_container_creation.mon_panel_creation_chanson.b_creation_chanson_valider_creation.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            if (mon_panel_container_creation.mon_panel_creation_chanson.tf_creation_chanson_titre.getText().equals("") || mon_panel_container_creation.mon_panel_creation_chanson.tf_creation_chanson_annee.getText().equals("")){
                javax.swing.JOptionPane.showMessageDialog(mon_panel_container_creation.mon_panel_creation_chanson, "Titre obligatoires et année obligatoires.");  
                mon_panel_container_creation.mon_panel_creation_chanson.tf_creation_chanson_titre.setBackground(Color.RED);
                mon_panel_container_creation.mon_panel_creation_chanson.tf_creation_chanson_annee.setBackground(Color.RED);
            }
            else{
                System.out.println("Création d'une chanson");
                mon_panel_container_creation.mon_panel_creation_chanson.tf_creation_chanson_titre.setBackground(Color.WHITE);
                mon_panel_container_creation.mon_panel_creation_chanson.tf_creation_chanson_annee.setBackground(Color.WHITE);
                objets.C_CHANSON ma_chanson_a_creer = new objets.C_CHANSON();
                ma_chanson_a_creer = mon_panel_container_creation.mon_panel_creation_chanson.creerChansonAvecDonneesCreation();
                ma_chanson_a_creer.creationMediaBdd(1);
                ma_chanson_a_creer.creationChansonBdd();
                ma_chanson_a_creer.creationGroupeChansonBDD();            
                ma_chanson_a_creer.creationArtisteBdd(2, ma_chanson_a_creer.getChanson_interpretes());
                ma_chanson_a_creer.creationCaracteristiquesBdd(ma_chanson_a_creer.getChanson_genres(), "genre", "categorized_by");
                ma_chanson_a_creer.creationCaracteristiquesBdd(ma_chanson_a_creer.getChanson_tags(), "tag", "is_associated_with");
                ma_chanson_a_creer.creationCaracteristiquesBdd(ma_chanson_a_creer.getChanson_studio_production(), "pc", "produced_by");
                ma_chanson_a_creer.creationRecompensesBdd(ma_chanson_a_creer.getChanson_ceremonies(),ma_chanson_a_creer.getChanson_award(), ma_chanson_a_creer.getChanson_annees_recompenses());
                javax.swing.JOptionPane.showMessageDialog(mon_panel_container_creation, "La chanson "+ma_chanson_a_creer.getMedia_titre()+" a bien été ajoutée.");
            }
        }         
    });
    mon_panel_container_creation.mon_panel_creation_chanson.b_creation_chanson_valider_brouillon.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            // Verif si année et titre vides
            if (mon_panel_container_creation.mon_panel_creation_chanson.tf_creation_chanson_titre.getText().equals("")){
                javax.swing.JOptionPane.showMessageDialog(mon_panel_container_creation.mon_panel_creation_chanson, "Titre obligatoire.");  
                mon_panel_container_creation.mon_panel_creation_chanson.tf_creation_chanson_titre.setBackground(Color.RED);
            }
            else{
                System.out.println("Création d'une chanson en brouillon");
                mon_panel_container_creation.mon_panel_creation_chanson.tf_creation_chanson_titre.setBackground(Color.WHITE);
                objets.C_CHANSON ma_chanson_a_creer = new objets.C_CHANSON();
                ma_chanson_a_creer = mon_panel_container_creation.mon_panel_creation_chanson.creerChansonAvecDonneesCreation();
                ma_chanson_a_creer.creationMediaBdd(2);
                ma_chanson_a_creer.creationChansonBdd();
                ma_chanson_a_creer.creationGroupeChansonBDD();            
                ma_chanson_a_creer.creationArtisteBdd(2, ma_chanson_a_creer.getChanson_interpretes());
                ma_chanson_a_creer.creationCaracteristiquesBdd(ma_chanson_a_creer.getChanson_genres(), "genre", "categorized_by");
                ma_chanson_a_creer.creationCaracteristiquesBdd(ma_chanson_a_creer.getChanson_tags(), "tag", "is_associated_with");
                ma_chanson_a_creer.creationCaracteristiquesBdd(ma_chanson_a_creer.getChanson_studio_production(), "pc", "produced_by");
                ma_chanson_a_creer.creationRecompensesBdd(ma_chanson_a_creer.getChanson_ceremonies(),ma_chanson_a_creer.getChanson_award(), ma_chanson_a_creer.getChanson_annees_recompenses());

                javax.swing.JOptionPane.showMessageDialog(mon_panel_container_creation, "Le chanson "+ma_chanson_a_creer.getMedia_titre()+" a bien été ajoutée aux brouillons.");
            }
        }         
    });
    mon_panel_container_creation.mon_panel_creation_chanson.b_creation_chanson_ajouter_interprete.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            if (!mon_panel_container_creation.mon_panel_creation_chanson.verifierPresenceStringDansList(mon_panel_container_creation.mon_panel_creation_chanson.li_creation_chanson_liste_interpretes, mon_panel_container_creation.mon_panel_creation_chanson.cb_creation_chanson_artiste)){
                System.out.println("Ajout d'un interprete");
                mon_panel_container_creation.mon_panel_creation_chanson.ajouterElementList(mon_panel_container_creation.mon_panel_creation_chanson.li_creation_chanson_liste_interpretes, mon_panel_container_creation.mon_panel_creation_chanson.cb_creation_chanson_artiste.getSelectedItem().toString());}
                else{
                    javax.swing.JOptionPane.showMessageDialog(mon_panel_container_creation, "Erreur : Impossible d'ajouter 2 interpretes identiques.");}
            }
    });
    mon_panel_container_creation.mon_panel_creation_chanson.b_creation_chanson_ajouter_genre.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            if (!mon_panel_container_creation.mon_panel_creation_chanson.verifierPresenceStringDansList(mon_panel_container_creation.mon_panel_creation_chanson.li_creation_chanson_liste_genres, mon_panel_container_creation.mon_panel_creation_chanson.cb_creation_chanson_genres)){
                System.out.println("Ajout d'un genre");
                mon_panel_container_creation.mon_panel_creation_chanson.ajouterElementList(mon_panel_container_creation.mon_panel_creation_chanson.li_creation_chanson_liste_genres, mon_panel_container_creation.mon_panel_creation_chanson.cb_creation_chanson_genres.getSelectedItem().toString());}
                else{
                    javax.swing.JOptionPane.showMessageDialog(mon_panel_container_creation, "Erreur : Impossible d'ajouter 2 genres identiques.");}
            }    
    });
    mon_panel_container_creation.mon_panel_creation_chanson.b_creation_chanson_ajouter_tag.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            if (!mon_panel_container_creation.mon_panel_creation_chanson.verifierPresenceStringDansList(mon_panel_container_creation.mon_panel_creation_chanson.li_creation_chanson_liste_tags, mon_panel_container_creation.mon_panel_creation_chanson.cb_creation_chanson_tags)){
                System.out.println("Ajout d'un tag");
                mon_panel_container_creation.mon_panel_creation_chanson.ajouterElementList(mon_panel_container_creation.mon_panel_creation_chanson.li_creation_chanson_liste_tags, mon_panel_container_creation.mon_panel_creation_chanson.cb_creation_chanson_tags.getSelectedItem().toString());}
                else{
                    javax.swing.JOptionPane.showMessageDialog(mon_panel_container_creation, "Erreur : Impossible d'ajouter 2 tags identiques.");}
            }     
    });
    mon_panel_container_creation.mon_panel_creation_chanson.b_creation_chanson_suppr_interprete.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            System.out.println("Suppresion d'un acteur");
            mon_panel_container_creation.mon_panel_creation_chanson.retirerElementList(mon_panel_container_creation.mon_panel_creation_chanson.li_creation_chanson_liste_interpretes , mon_panel_container_creation.mon_panel_creation_chanson.li_creation_chanson_liste_interpretes.getSelectedIndex());
        }         
    });
    mon_panel_container_creation.mon_panel_creation_chanson.b_creation_chanson_suppr_genre.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            System.out.println("Suppresion d'un genre");
            mon_panel_container_creation.mon_panel_creation_chanson.retirerElementList(mon_panel_container_creation.mon_panel_creation_chanson.li_creation_chanson_liste_genres, mon_panel_container_creation.mon_panel_creation_chanson.li_creation_chanson_liste_genres.getSelectedIndex());
        }         
    });
    mon_panel_container_creation.mon_panel_creation_chanson.b_creation_chanson_suppr_tag.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            System.out.println("Suppresion d'un tag");
            mon_panel_container_creation.mon_panel_creation_chanson.retirerElementList(mon_panel_container_creation.mon_panel_creation_chanson.li_creation_chanson_liste_tags, mon_panel_container_creation.mon_panel_creation_chanson.li_creation_chanson_liste_tags.getSelectedIndex());
        }         
    });
    mon_panel_container_creation.mon_panel_creation_chanson.b_creation_chanson_ajouter_recompense.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            System.out.println("Ajout d'un element dans le tableau récompense");
            if (mon_panel_container_creation.mon_panel_creation_chanson.cb_creation_chanson_ceremonie.getSelectedItem().toString().equals("Choisissez") || mon_panel_container_creation.mon_panel_creation_chanson.cb_creation_chanson_award.getSelectedItem().toString().equals("Choisissez") ){
                javax.swing.JOptionPane.showMessageDialog(mon_panel_container_creation.mon_panel_creation_chanson, "Erreur : Cérémonie et Award obligatoires");}

            else {
                Object [][] ceremonie_a_ajouter = {{mon_panel_container_creation.mon_panel_creation_chanson.cb_creation_chanson_ceremonie.getSelectedItem().toString(), mon_panel_container_creation.mon_panel_creation_chanson.cb_creation_chanson_award.getSelectedItem().toString(), mon_panel_container_creation.mon_panel_creation_chanson.recupererValeurCB(mon_panel_container_creation.mon_panel_creation_chanson.cb_creation_chanson_annee_award)}}; 
                mon_panel_container_creation.mon_panel_creation_chanson.ajouterDonneesDansTabRecompenses(ceremonie_a_ajouter, mon_panel_container_creation.mon_panel_creation_chanson.tab_creation_chanson_tab_recompenses);
            }
        }         
    });
    mon_panel_container_creation.mon_panel_creation_chanson.b_creation_chanson_suppr_recompense.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            System.out.println("Suppresion d'un element du tableau récompense");
            mon_panel_container_creation.mon_panel_creation_chanson.retirerElementDansTabRecompenses(mon_panel_container_creation.mon_panel_creation_chanson.tab_creation_chanson_tab_recompenses);
        }         
    });
}
public void gestionClicBoutonsCreationArtiste(){
    mon_panel_container_creation.mon_panel_creation_artiste.b_creation_artiste_valider_creation.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            if (mon_panel_container_creation.mon_panel_creation_artiste.tf_creation_artiste_nom.getText().equals("") && mon_panel_container_creation.mon_panel_creation_artiste.tf_creation_artiste_prenom.getText().equals("") && mon_panel_container_creation.mon_panel_creation_artiste.tf_creation_artiste_surnom.getText().equals("")){
                javax.swing.JOptionPane.showMessageDialog(mon_panel_container_creation.mon_panel_creation_artiste, "Nom, prénom ou surnom obligatoire. Si le surnom est laissé vide, il sera initialisé avec le prenom + nom.");  
                mon_panel_container_creation.mon_panel_creation_artiste.tf_creation_artiste_nom.setBackground(Color.RED);
                mon_panel_container_creation.mon_panel_creation_artiste.tf_creation_artiste_prenom.setBackground(Color.RED);
                mon_panel_container_creation.mon_panel_creation_artiste.tf_creation_artiste_surnom.setBackground(Color.RED);
            }
            else{
                if(!mon_panel_container_creation.mon_panel_creation_artiste.tf_creation_artiste_mort.getText().matches("\\d{4}-[01]\\d-[0-3]\\d") && (!mon_panel_container_creation.mon_panel_creation_artiste.tf_creation_artiste_mort.getText().equals(""))){
                    javax.swing.JOptionPane.showMessageDialog(mon_panel_container_creation, "Problème de format de date : yyyy-mm-dd");
                    mon_panel_container_creation.mon_panel_creation_artiste.tf_creation_artiste_mort.setBackground(Color.ORANGE);
                    mon_panel_container_creation.mon_panel_creation_artiste.tf_creation_artiste_naissance.setBackground(Color.WHITE);
                }
                else if(!mon_panel_container_creation.mon_panel_creation_artiste.tf_creation_artiste_naissance.getText().matches("\\d{4}-[01]\\d-[0-3]\\d") && (!mon_panel_container_creation.mon_panel_creation_artiste.tf_creation_artiste_naissance.getText().equals("")) ){
                    javax.swing.JOptionPane.showMessageDialog(mon_panel_container_creation, "Problème de format de date : yyyy-mm-dd");
                    mon_panel_container_creation.mon_panel_creation_artiste.tf_creation_artiste_naissance.setBackground(Color.ORANGE);
                    mon_panel_container_creation.mon_panel_creation_artiste.tf_creation_artiste_mort.setBackground(Color.WHITE);
                }
                else{
                System.out.println("Création d'un artiste");
                mon_panel_container_creation.mon_panel_creation_artiste.tf_creation_artiste_nom.setBackground(Color.WHITE);
                mon_panel_container_creation.mon_panel_creation_artiste.tf_creation_artiste_prenom.setBackground(Color.WHITE);
                mon_panel_container_creation.mon_panel_creation_artiste.tf_creation_artiste_surnom.setBackground(Color.WHITE);
                mon_panel_container_creation.mon_panel_creation_artiste.tf_creation_artiste_mort.setBackground(Color.WHITE);
                mon_panel_container_creation.mon_panel_creation_artiste.tf_creation_artiste_naissance.setBackground(Color.WHITE);
                objets.C_ARTISTE mon_artiste_a_creer = new objets.C_ARTISTE();
                mon_artiste_a_creer = mon_panel_container_creation.mon_panel_creation_artiste.creerArtisteAvecDonneesCreation();
                
                mon_artiste_a_creer.creationHumanBdd();
                mon_artiste_a_creer.creationArtisteBdd(1);
                mon_artiste_a_creer.creationGroupeArtisteBDD();    
                mon_artiste_a_creer.creationRecompensesBdd(mon_artiste_a_creer.getArtiste_ceremonies(),mon_artiste_a_creer.getArtiste_award(), mon_artiste_a_creer.getArtiste_annee_recompense());

                javax.swing.JOptionPane.showMessageDialog(mon_panel_container_creation, "L'artiste "+mon_artiste_a_creer.getArtiste_nickname()+" a bien été ajouté.");}
            }
        }         
    });
    mon_panel_container_creation.mon_panel_creation_artiste.b_creation_artiste_valider_brouillon.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            if (mon_panel_container_creation.mon_panel_creation_artiste.tf_creation_artiste_nom.getText().equals("") && mon_panel_container_creation.mon_panel_creation_artiste.tf_creation_artiste_prenom.getText().equals("") && mon_panel_container_creation.mon_panel_creation_artiste.tf_creation_artiste_surnom.getText().equals("")){
                javax.swing.JOptionPane.showMessageDialog(mon_panel_container_creation.mon_panel_creation_artiste, "Nom, prénom ou surnom obligatoire. Si le surnom est laissé vide, il sera initialisé avec le prenom + nom.");  
                mon_panel_container_creation.mon_panel_creation_artiste.tf_creation_artiste_nom.setBackground(Color.RED);
                mon_panel_container_creation.mon_panel_creation_artiste.tf_creation_artiste_prenom.setBackground(Color.RED);
                mon_panel_container_creation.mon_panel_creation_artiste.tf_creation_artiste_surnom.setBackground(Color.RED);
            }
            else{
                if(!mon_panel_container_creation.mon_panel_creation_artiste.tf_creation_artiste_mort.getText().matches("\\d{4}-[01]\\d-[0-3]\\d") && (!mon_panel_container_creation.mon_panel_creation_artiste.tf_creation_artiste_mort.getText().equals(""))){
                    javax.swing.JOptionPane.showMessageDialog(mon_panel_container_creation, "Problème de format de date : yyyy-mm-dd");
                    mon_panel_container_creation.mon_panel_creation_artiste.tf_creation_artiste_mort.setBackground(Color.ORANGE);
                    mon_panel_container_creation.mon_panel_creation_artiste.tf_creation_artiste_naissance.setBackground(Color.WHITE);
                }
                else if(!mon_panel_container_creation.mon_panel_creation_artiste.tf_creation_artiste_naissance.getText().matches("\\d{4}-[01]\\d-[0-3]\\d") && (!mon_panel_container_creation.mon_panel_creation_artiste.tf_creation_artiste_naissance.getText().equals("")) ){
                    javax.swing.JOptionPane.showMessageDialog(mon_panel_container_creation, "Problème de format de date : yyyy-mm-dd");
                    mon_panel_container_creation.mon_panel_creation_artiste.tf_creation_artiste_naissance.setBackground(Color.ORANGE);
                    mon_panel_container_creation.mon_panel_creation_artiste.tf_creation_artiste_mort.setBackground(Color.WHITE);
                }
                else{
                System.out.println("Création d'une artiste en brouillon");
                mon_panel_container_creation.mon_panel_creation_artiste.tf_creation_artiste_nom.setBackground(Color.WHITE);
                mon_panel_container_creation.mon_panel_creation_artiste.tf_creation_artiste_prenom.setBackground(Color.WHITE);
                mon_panel_container_creation.mon_panel_creation_artiste.tf_creation_artiste_surnom.setBackground(Color.WHITE);
                mon_panel_container_creation.mon_panel_creation_artiste.tf_creation_artiste_mort.setBackground(Color.WHITE);
                mon_panel_container_creation.mon_panel_creation_artiste.tf_creation_artiste_naissance.setBackground(Color.WHITE);
                objets.C_ARTISTE mon_artiste_a_creer = new objets.C_ARTISTE();
                mon_artiste_a_creer = mon_panel_container_creation.mon_panel_creation_artiste.creerArtisteAvecDonneesCreation();
                
                mon_artiste_a_creer.creationHumanBdd();
                mon_artiste_a_creer.creationArtisteBdd(2);
                mon_artiste_a_creer.creationGroupeArtisteBDD();    
                mon_artiste_a_creer.creationRecompensesBdd(mon_artiste_a_creer.getArtiste_ceremonies(),mon_artiste_a_creer.getArtiste_award(), mon_artiste_a_creer.getArtiste_annee_recompense());

                javax.swing.JOptionPane.showMessageDialog(mon_panel_container_creation, "L'artiste "+mon_artiste_a_creer.getArtiste_nickname()+" a bien été ajouté aux brouillons.");}
            }
        }         
    });
    mon_panel_container_creation.mon_panel_creation_artiste.b_creation_artiste_ajouter_groupe.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            if (!mon_panel_container_creation.mon_panel_creation_artiste.verifierPresenceStringDansList(mon_panel_container_creation.mon_panel_creation_artiste.li_creation_artiste_liste_groupes, mon_panel_container_creation.mon_panel_creation_artiste.cb_creation_artiste_groupe)){
                System.out.println("Ajout d'un Groupe");
                mon_panel_container_creation.mon_panel_creation_artiste.ajouterElementList(mon_panel_container_creation.mon_panel_creation_artiste.li_creation_artiste_liste_groupes, mon_panel_container_creation.mon_panel_creation_artiste.cb_creation_artiste_groupe.getSelectedItem().toString());}
                else{
                    javax.swing.JOptionPane.showMessageDialog(mon_panel_container_creation, "Erreur : Impossible d'ajouter 2 groupes identiques.");}
            }
    });
    mon_panel_container_creation.mon_panel_creation_artiste.b_creation_artiste_ajouter_recompense.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            System.out.println("Ajout d'un element dans le tableau récompense");
            if (mon_panel_container_creation.mon_panel_creation_artiste.cb_creation_artiste_ceremonie.getSelectedItem().toString().equals("Choisissez") || mon_panel_container_creation.mon_panel_creation_artiste.cb_creation_artiste_award.getSelectedItem().toString().equals("Choisissez") ){
                javax.swing.JOptionPane.showMessageDialog(mon_panel_container_creation.mon_panel_creation_artiste, "Erreur : Cérémonie et Award obligatoires");}

            else {
                Object [][] ceremonie_a_ajouter = {{mon_panel_container_creation.mon_panel_creation_artiste.cb_creation_artiste_ceremonie.getSelectedItem().toString(), mon_panel_container_creation.mon_panel_creation_artiste.cb_creation_artiste_award.getSelectedItem().toString(), mon_panel_container_creation.mon_panel_creation_artiste.recupererValeurCB(mon_panel_container_creation.mon_panel_creation_artiste.cb_creation_artiste_annee_award)}}; 
                mon_panel_container_creation.mon_panel_creation_artiste.ajouterDonneesDansTabRecompenses(ceremonie_a_ajouter, mon_panel_container_creation.mon_panel_creation_artiste.tab_creation_artiste_tab_recompenses);
            }
        }         
    });
    mon_panel_container_creation.mon_panel_creation_artiste.b_creation_artiste_suppr_recompense.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            System.out.println("Suppresion d'un element du tableau récompense");
            mon_panel_container_creation.mon_panel_creation_artiste.retirerElementDansTabRecompenses(mon_panel_container_creation.mon_panel_creation_artiste.tab_creation_artiste_tab_recompenses);
        }         
    });
}

public void gestionClicBoutonsModificationFilm(){
    mon_panel_container_modification.mon_panel_modification_film.b_modification_film_valider_modification.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            // On supprime le film qu'on veut modifier puis on le recrée avec les nouvelles infos
            if (mon_panel_container_modification.mon_panel_modification_film.tf_modification_film_titre.getText().equals("") || mon_panel_container_modification.mon_panel_modification_film.tf_modification_film_annee.getText().equals("")){
                javax.swing.JOptionPane.showMessageDialog(mon_panel_container_modification.mon_panel_modification_film, "Titre et année obligatoires.");  
                mon_panel_container_modification.mon_panel_modification_film.tf_modification_film_titre.setBackground(Color.RED);
                mon_panel_container_modification.mon_panel_modification_film.tf_modification_film_annee.setBackground(Color.RED);
            }
            else{
                System.out.println("Modification d'un film");
                mon_panel_container_modification.mon_panel_modification_film.tf_modification_film_titre.setBackground(Color.WHITE);
                mon_panel_container_modification.mon_panel_modification_film.tf_modification_film_annee.setBackground(Color.WHITE);
                mon_film_a_modifier.suppressionMediaBdd(mon_film_a_modifier.getMedia_id());
                mon_film_a_modifier = mon_panel_container_modification.mon_panel_modification_film.creerFilmAvecDonneesModification(mon_id_film_a_modifier);
                mon_film_a_modifier.setMedia_type("Film");
                mon_film_a_modifier.modificationMediaBdd(1);
                mon_film_a_modifier.creationFilmBdd();
                mon_film_a_modifier.creationArtisteBdd(1, mon_film_a_modifier.getFilm_acteurs());
                mon_film_a_modifier.creationArtisteBdd(4, mon_film_a_modifier.getFilm_realisateurs());
                mon_film_a_modifier.creationArtisteBdd(5, mon_film_a_modifier.getFilm_scenaristes());
                mon_film_a_modifier.creationCaracteristiquesBdd(mon_film_a_modifier.getFilm_genres(), "genre", "categorized_by");
                mon_film_a_modifier.creationCaracteristiquesBdd(mon_film_a_modifier.getFilm_tags(), "tag", "is_associated_with");
                mon_film_a_modifier.creationCaracteristiquesBdd(mon_film_a_modifier.getfilm_studio_production(), "pc", "produced_by");
                mon_film_a_modifier.creationRecompensesBdd(mon_film_a_modifier.getFilm_ceremonies(),mon_film_a_modifier.getFilm_award(), mon_film_a_modifier.getFilm_annee_recompense());

                javax.swing.JOptionPane.showMessageDialog(mon_panel_container_creation, "Le film "+mon_film_a_modifier.getMedia_titre()+" a bien été modifié.");}
        }
    });
    mon_panel_container_modification.mon_panel_modification_film.b_modification_film_valider_brouillon.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            // On supprime le film qu'on veut modifier puis on le recrée avec les nouvelles infos
            if (mon_panel_container_modification.mon_panel_modification_film.tf_modification_film_titre.getText().equals("") || mon_panel_container_modification.mon_panel_modification_film.tf_modification_film_annee.getText().equals("")){
                javax.swing.JOptionPane.showMessageDialog(mon_panel_container_modification.mon_panel_modification_film, "Titre et année obligatoires.");  
                mon_panel_container_modification.mon_panel_modification_film.tf_modification_film_titre.setBackground(Color.RED);
                mon_panel_container_modification.mon_panel_modification_film.tf_modification_film_annee.setBackground(Color.RED);
            }
            else{
                System.out.println("Modification d'un film puis brouillon");
                mon_panel_container_modification.mon_panel_modification_film.tf_modification_film_titre.setBackground(Color.WHITE);
                mon_panel_container_modification.mon_panel_modification_film.tf_modification_film_annee.setBackground(Color.WHITE);
                mon_film_a_modifier.suppressionMediaBdd(mon_film_a_modifier.getMedia_id());
                mon_film_a_modifier = mon_panel_container_modification.mon_panel_modification_film.creerFilmAvecDonneesModification(mon_id_film_a_modifier);
                mon_film_a_modifier.setMedia_type("Film");
                mon_film_a_modifier.modificationMediaBdd(2);
                mon_film_a_modifier.creationFilmBdd();
                mon_film_a_modifier.creationArtisteBdd(1, mon_film_a_modifier.getFilm_acteurs());
                mon_film_a_modifier.creationArtisteBdd(4, mon_film_a_modifier.getFilm_realisateurs());
                mon_film_a_modifier.creationArtisteBdd(5, mon_film_a_modifier.getFilm_scenaristes());
                mon_film_a_modifier.creationCaracteristiquesBdd(mon_film_a_modifier.getFilm_genres(), "genre", "categorized_by");
                mon_film_a_modifier.creationCaracteristiquesBdd(mon_film_a_modifier.getFilm_tags(), "tag", "is_associated_with");
                mon_film_a_modifier.creationCaracteristiquesBdd(mon_film_a_modifier.getfilm_studio_production(), "pc", "produced_by");
                mon_film_a_modifier.creationRecompensesBdd(mon_film_a_modifier.getFilm_ceremonies(),mon_film_a_modifier.getFilm_award(), mon_film_a_modifier.getFilm_annee_recompense());

                javax.swing.JOptionPane.showMessageDialog(mon_panel_container_creation, "Le film "+mon_film_a_modifier.getMedia_titre()+" a bien été modifié et mis au brouillon.");}
        }
    });
    mon_panel_container_modification.mon_panel_modification_film.b_modification_film_ajouter_acteur.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            if (!mon_panel_container_modification.mon_panel_modification_film.verifierPresenceStringDansList(mon_panel_container_modification.mon_panel_modification_film.li_modification_film_liste_acteurs, mon_panel_container_modification.mon_panel_modification_film.cb_modification_film_artiste)){
            System.out.println("Ajout d'un acteur");
            mon_panel_container_modification.mon_panel_modification_film.ajouterElementList(mon_panel_container_modification.mon_panel_modification_film.li_modification_film_liste_acteurs, mon_panel_container_modification.mon_panel_modification_film.cb_modification_film_artiste.getSelectedItem().toString());}
            else{
                javax.swing.JOptionPane.showMessageDialog(mon_panel_container_modification, "Erreur : Impossible d'ajouter 2 acteurs identiques.");}
        }           
    });
    mon_panel_container_modification.mon_panel_modification_film.b_modification_film_ajouter_realisateur.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            if (!mon_panel_container_modification.mon_panel_modification_film.verifierPresenceStringDansList(mon_panel_container_modification.mon_panel_modification_film.li_modification_film_liste_realisateurs, mon_panel_container_modification.mon_panel_modification_film.cb_modification_film_artiste)){
                System.out.println("Ajout d'un realisateur");
                mon_panel_container_modification.mon_panel_modification_film.ajouterElementList(mon_panel_container_modification.mon_panel_modification_film.li_modification_film_liste_realisateurs, mon_panel_container_modification.mon_panel_modification_film.cb_modification_film_artiste.getSelectedItem().toString());}
                else{
                    javax.swing.JOptionPane.showMessageDialog(mon_panel_container_modification, "Erreur : Impossible d'ajouter 2 realisateurs identiques.");}
            }
    });
    mon_panel_container_modification.mon_panel_modification_film.b_modification_film_ajouter_scenariste.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            if (!mon_panel_container_modification.mon_panel_modification_film.verifierPresenceStringDansList(mon_panel_container_modification.mon_panel_modification_film.li_modification_film_liste_scenaristes, mon_panel_container_modification.mon_panel_modification_film.cb_modification_film_artiste)){
                System.out.println("Ajout d'un scenariste");
                mon_panel_container_modification.mon_panel_modification_film.ajouterElementList(mon_panel_container_modification.mon_panel_modification_film.li_modification_film_liste_scenaristes, mon_panel_container_modification.mon_panel_modification_film.cb_modification_film_artiste.getSelectedItem().toString());}
                else{
                    javax.swing.JOptionPane.showMessageDialog(mon_panel_container_modification, "Erreur : Impossible d'ajouter 2 scenaristes identiques.");}
            }    
    });
    mon_panel_container_modification.mon_panel_modification_film.b_modification_film_ajouter_genre.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            if (!mon_panel_container_modification.mon_panel_modification_film.verifierPresenceStringDansList(mon_panel_container_modification.mon_panel_modification_film.li_modification_film_liste_genres, mon_panel_container_modification.mon_panel_modification_film.cb_modification_film_genres)){
                System.out.println("Ajout d'un genre");
                mon_panel_container_modification.mon_panel_modification_film.ajouterElementList(mon_panel_container_modification.mon_panel_modification_film.li_modification_film_liste_genres, mon_panel_container_modification.mon_panel_modification_film.cb_modification_film_genres.getSelectedItem().toString());}
                else{
                    javax.swing.JOptionPane.showMessageDialog(mon_panel_container_modification, "Erreur : Impossible d'ajouter 2 genres identiques.");}
            }    
    });
    mon_panel_container_modification.mon_panel_modification_film.b_modification_film_ajouter_tag.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            if (!mon_panel_container_modification.mon_panel_modification_film.verifierPresenceStringDansList(mon_panel_container_modification.mon_panel_modification_film.li_modification_film_liste_tags, mon_panel_container_modification.mon_panel_modification_film.cb_modification_film_tags)){
                System.out.println("Ajout d'un tag");
                mon_panel_container_modification.mon_panel_modification_film.ajouterElementList(mon_panel_container_modification.mon_panel_modification_film.li_modification_film_liste_tags, mon_panel_container_modification.mon_panel_modification_film.cb_modification_film_tags.getSelectedItem().toString());}
                else{
                    javax.swing.JOptionPane.showMessageDialog(mon_panel_container_modification, "Erreur : Impossible d'ajouter 2 tags identiques.");}
            }     
    });
    mon_panel_container_modification.mon_panel_modification_film.b_modification_film_suppr_acteur.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            System.out.println("Suppresion d'un acteur");
            mon_panel_container_modification.mon_panel_modification_film.retirerElementList(mon_panel_container_modification.mon_panel_modification_film.li_modification_film_liste_acteurs, mon_panel_container_modification.mon_panel_modification_film.li_modification_film_liste_acteurs.getSelectedIndex());
        }         
    });
    mon_panel_container_modification.mon_panel_modification_film.b_modification_film_suppr_realisateur.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            System.out.println("Suppresion d'un realisateur");
            mon_panel_container_modification.mon_panel_modification_film.retirerElementList(mon_panel_container_modification.mon_panel_modification_film.li_modification_film_liste_realisateurs, mon_panel_container_modification.mon_panel_modification_film.li_modification_film_liste_realisateurs.getSelectedIndex());
        }         
    });
    mon_panel_container_modification.mon_panel_modification_film.b_modification_film_suppr_scenariste.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            System.out.println("Suppresion d'un scenariste");
            mon_panel_container_modification.mon_panel_modification_film.retirerElementList(mon_panel_container_modification.mon_panel_modification_film.li_modification_film_liste_scenaristes, mon_panel_container_modification.mon_panel_modification_film.li_modification_film_liste_scenaristes.getSelectedIndex());
        }         
    });
    mon_panel_container_modification.mon_panel_modification_film.b_modification_film_suppr_genre.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            System.out.println("Suppresion d'un genre");
            mon_panel_container_modification.mon_panel_modification_film.retirerElementList(mon_panel_container_modification.mon_panel_modification_film.li_modification_film_liste_genres, mon_panel_container_modification.mon_panel_modification_film.li_modification_film_liste_genres.getSelectedIndex());
        }         
    });
    mon_panel_container_modification.mon_panel_modification_film.b_modification_film_suppr_tag.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            System.out.println("Suppresion d'un tag");
            mon_panel_container_modification.mon_panel_modification_film.retirerElementList(mon_panel_container_modification.mon_panel_modification_film.li_modification_film_liste_tags, mon_panel_container_modification.mon_panel_modification_film.li_modification_film_liste_tags.getSelectedIndex());
        }         
    });
    mon_panel_container_modification.mon_panel_modification_film.b_modification_film_ajouter_recompense.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            System.out.println("Ajout d'un element dans le tableau récompense");
            if (mon_panel_container_modification.mon_panel_modification_film.cb_modification_film_ceremonie.getSelectedItem().toString().equals("Choisissez") || mon_panel_container_modification.mon_panel_modification_film.cb_modification_film_award.getSelectedItem().toString().equals("Choisissez") ){
                javax.swing.JOptionPane.showMessageDialog(mon_panel_container_modification.mon_panel_modification_film, "Erreur : Cérémonie et Award obligatoires");}

            else {
                Object [][] ceremonie_a_ajouter = {{mon_panel_container_modification.mon_panel_modification_film.cb_modification_film_ceremonie.getSelectedItem().toString(), mon_panel_container_modification.mon_panel_modification_film.cb_modification_film_award.getSelectedItem().toString(), mon_panel_container_modification.mon_panel_modification_film.recupererValeurCB(mon_panel_container_modification.mon_panel_modification_film.cb_modification_film_annee_award)}}; 
                mon_panel_container_modification.mon_panel_modification_film.ajouterDonneesDansTabRecompenses(ceremonie_a_ajouter, mon_panel_container_modification.mon_panel_modification_film.tab_modification_film_tab_recompenses);
            }
        }         
    });
    mon_panel_container_modification.mon_panel_modification_film.b_modification_film_suppr_recompense.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            System.out.println("Suppresion d'un element du tableau récompense");
            mon_panel_container_modification.mon_panel_modification_film.retirerElementDansTabRecompenses(mon_panel_container_modification.mon_panel_modification_film.tab_modification_film_tab_recompenses);
        }         
    });
}
public void gestionClicBoutonsModificationLivre(){
    mon_panel_container_modification.mon_panel_modification_livre.b_modification_livre_valider_modification.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            // On supprime le livre qu'on veut modifier puis on le recrée avec les nouvelles infos
            if (mon_panel_container_modification.mon_panel_modification_livre.tf_modification_livre_titre.getText().equals("") || mon_panel_container_modification.mon_panel_modification_livre.tf_modification_livre_annee.getText().equals("")){
                javax.swing.JOptionPane.showMessageDialog(mon_panel_container_modification.mon_panel_modification_livre, "Titre et année obligatoires.");  
                mon_panel_container_modification.mon_panel_modification_livre.tf_modification_livre_titre.setBackground(Color.RED);
                mon_panel_container_modification.mon_panel_modification_livre.tf_modification_livre_annee.setBackground(Color.RED);
            }
            else{
                System.out.println("Modification d'un livre");
                mon_livre_a_modifier.suppressionMediaBdd(mon_livre_a_modifier.getMedia_id());
                mon_livre_a_modifier = mon_panel_container_modification.mon_panel_modification_livre.creerLivreAvecDonneesModification(mon_id_livre_a_modifier);
                mon_livre_a_modifier.setMedia_type("Livre");
                mon_livre_a_modifier.modificationMediaBdd(1);
                mon_livre_a_modifier.creationLivreBdd();
                mon_livre_a_modifier.creationArtisteBdd(3, mon_livre_a_modifier.getLivre_ecrivains());
                mon_livre_a_modifier.creationCaracteristiquesBdd(mon_livre_a_modifier.getLivre_genres(), "genre", "categorized_by");
                mon_livre_a_modifier.creationCaracteristiquesBdd(mon_livre_a_modifier.getLivre_tags(), "tag", "is_associated_with");
                mon_livre_a_modifier.creationCaracteristiquesBdd(mon_livre_a_modifier.getLivre_studio_production(), "pc", "produced_by");
                mon_livre_a_modifier.creationRecompensesBdd(mon_livre_a_modifier.getLivre_ceremonies(),mon_livre_a_modifier.getLivre_award(), mon_livre_a_modifier.getLivre_annees_recompenses());
                javax.swing.JOptionPane.showMessageDialog(mon_panel_container_creation, "Le livre "+mon_livre_a_modifier.getMedia_titre()+" a bien été modifié.");}
        }
    });

    mon_panel_container_modification.mon_panel_modification_livre.b_modification_livre_valider_brouillon.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            // On supprime le livre qu'on veut modifier puis on le recrée avec les nouvelles infos
            if (mon_panel_container_modification.mon_panel_modification_livre.tf_modification_livre_titre.getText().equals("") || mon_panel_container_modification.mon_panel_modification_livre.tf_modification_livre_annee.getText().equals("")){
                javax.swing.JOptionPane.showMessageDialog(mon_panel_container_modification.mon_panel_modification_livre, "Titre et année obligatoires.");  
                mon_panel_container_modification.mon_panel_modification_livre.tf_modification_livre_titre.setBackground(Color.RED);
                mon_panel_container_modification.mon_panel_modification_livre.tf_modification_livre_annee.setBackground(Color.RED);
            }
            else{
                System.out.println("Modification d'un livre");
                mon_panel_container_modification.mon_panel_modification_livre.tf_modification_livre_titre.setBackground(Color.WHITE);
                mon_panel_container_modification.mon_panel_modification_livre.tf_modification_livre_annee.setBackground(Color.WHITE);
                mon_livre_a_modifier.suppressionMediaBdd(mon_livre_a_modifier.getMedia_id());
                mon_livre_a_modifier = mon_panel_container_modification.mon_panel_modification_livre.creerLivreAvecDonneesModification(mon_id_livre_a_modifier);
                mon_livre_a_modifier.setMedia_type("Livre");
                mon_livre_a_modifier.modificationMediaBdd(2);
                mon_livre_a_modifier.creationLivreBdd();
                mon_livre_a_modifier.creationArtisteBdd(3, mon_livre_a_modifier.getLivre_ecrivains());
                mon_livre_a_modifier.creationCaracteristiquesBdd(mon_livre_a_modifier.getLivre_genres(), "genre", "categorized_by");
                mon_livre_a_modifier.creationCaracteristiquesBdd(mon_livre_a_modifier.getLivre_tags(), "tag", "is_associated_with");
                mon_livre_a_modifier.creationCaracteristiquesBdd(mon_livre_a_modifier.getLivre_studio_production(), "pc", "produced_by");
                mon_livre_a_modifier.creationRecompensesBdd(mon_livre_a_modifier.getLivre_ceremonies(),mon_livre_a_modifier.getLivre_award(), mon_livre_a_modifier.getLivre_annees_recompenses());
                javax.swing.JOptionPane.showMessageDialog(mon_panel_container_creation, "Le livre "+mon_livre_a_modifier.getMedia_titre()+" a bien été modifié et mis en brouillon.");}
        }
    });

    mon_panel_container_modification.mon_panel_modification_livre.b_modification_livre_ajouter_ecrivain.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            if (!mon_panel_container_modification.mon_panel_modification_livre.verifierPresenceStringDansList(mon_panel_container_modification.mon_panel_modification_livre.li_modification_livre_liste_ecrivains, mon_panel_container_modification.mon_panel_modification_livre.cb_modification_livre_artiste)){
            System.out.println("Ajout d'un ecrivain");
            mon_panel_container_modification.mon_panel_modification_livre.ajouterElementList(mon_panel_container_modification.mon_panel_modification_livre.li_modification_livre_liste_ecrivains, mon_panel_container_modification.mon_panel_modification_livre.cb_modification_livre_artiste.getSelectedItem().toString());}
            else{
                javax.swing.JOptionPane.showMessageDialog(mon_panel_container_modification, "Erreur : Impossible d'ajouter 2 ecrivains identiques.");}
        }           
    });
    mon_panel_container_modification.mon_panel_modification_livre.b_modification_livre_ajouter_genre.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            if (!mon_panel_container_modification.mon_panel_modification_livre.verifierPresenceStringDansList(mon_panel_container_modification.mon_panel_modification_livre.li_modification_livre_liste_genres, mon_panel_container_modification.mon_panel_modification_livre.cb_modification_livre_genres)){
                System.out.println("Ajout d'un genre");
                mon_panel_container_modification.mon_panel_modification_livre.ajouterElementList(mon_panel_container_modification.mon_panel_modification_livre.li_modification_livre_liste_genres, mon_panel_container_modification.mon_panel_modification_livre.cb_modification_livre_genres.getSelectedItem().toString());}
                else{
                    javax.swing.JOptionPane.showMessageDialog(mon_panel_container_modification, "Erreur : Impossible d'ajouter 2 genres identiques.");}
            }    
    });
    mon_panel_container_modification.mon_panel_modification_livre.b_modification_livre_ajouter_tag.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            if (!mon_panel_container_modification.mon_panel_modification_livre.verifierPresenceStringDansList(mon_panel_container_modification.mon_panel_modification_livre.li_modification_livre_liste_tags, mon_panel_container_modification.mon_panel_modification_livre.cb_modification_livre_tags)){
                System.out.println("Ajout d'un tag");
                mon_panel_container_modification.mon_panel_modification_livre.ajouterElementList(mon_panel_container_modification.mon_panel_modification_livre.li_modification_livre_liste_tags, mon_panel_container_modification.mon_panel_modification_livre.cb_modification_livre_tags.getSelectedItem().toString());}
                else{
                    javax.swing.JOptionPane.showMessageDialog(mon_panel_container_modification, "Erreur : Impossible d'ajouter 2 tags identiques.");}
            }     
    });
    mon_panel_container_modification.mon_panel_modification_livre.b_modification_livre_suppr_ecrivain.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            System.out.println("Suppresion d'un ecrivain");
            mon_panel_container_modification.mon_panel_modification_livre.retirerElementList(mon_panel_container_modification.mon_panel_modification_livre.li_modification_livre_liste_ecrivains, mon_panel_container_modification.mon_panel_modification_livre.li_modification_livre_liste_ecrivains.getSelectedIndex());
        }         
    });
    mon_panel_container_modification.mon_panel_modification_livre.b_modification_livre_suppr_genre.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            System.out.println("Suppresion d'un genre");
            mon_panel_container_modification.mon_panel_modification_livre.retirerElementList(mon_panel_container_modification.mon_panel_modification_livre.li_modification_livre_liste_genres, mon_panel_container_modification.mon_panel_modification_livre.li_modification_livre_liste_genres.getSelectedIndex());
        }         
    });
    mon_panel_container_modification.mon_panel_modification_livre.b_modification_livre_suppr_tag.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            System.out.println("Suppresion d'un tag");
            mon_panel_container_modification.mon_panel_modification_livre.retirerElementList(mon_panel_container_modification.mon_panel_modification_livre.li_modification_livre_liste_tags, mon_panel_container_modification.mon_panel_modification_livre.li_modification_livre_liste_tags.getSelectedIndex());
        }         
    });

    mon_panel_container_modification.mon_panel_modification_livre.b_modification_livre_ajouter_recompense.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            System.out.println("Ajout d'un element dans le tableau récompense");
            if (mon_panel_container_modification.mon_panel_modification_livre.cb_modification_livre_ceremonie.getSelectedItem().toString().equals("Choisissez") || mon_panel_container_modification.mon_panel_modification_livre.cb_modification_livre_award.getSelectedItem().toString().equals("Choisissez") ){
                javax.swing.JOptionPane.showMessageDialog(mon_panel_container_modification.mon_panel_modification_livre, "Erreur : Cérémonie et Award obligatoires");}

            else {
                Object [][] ceremonie_a_ajouter = {{mon_panel_container_modification.mon_panel_modification_livre.cb_modification_livre_ceremonie.getSelectedItem().toString(), mon_panel_container_modification.mon_panel_modification_livre.cb_modification_livre_award.getSelectedItem().toString(), mon_panel_container_modification.mon_panel_modification_livre.recupererValeurCB(mon_panel_container_modification.mon_panel_modification_livre.cb_modification_livre_annee_award)}}; 
                mon_panel_container_modification.mon_panel_modification_livre.ajouterDonneesDansTabRecompenses(ceremonie_a_ajouter, mon_panel_container_modification.mon_panel_modification_livre.tab_modification_livre_tab_recompenses);
            }
        }         
    });
    mon_panel_container_modification.mon_panel_modification_livre.b_modification_livre_suppr_recompense.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            System.out.println("Suppresion d'un element du tableau récompense");
            mon_panel_container_modification.mon_panel_modification_livre.retirerElementDansTabRecompenses(mon_panel_container_modification.mon_panel_modification_livre.tab_modification_livre_tab_recompenses);
        }         
    });
}
public void gestionClicBoutonsModificationChanson(){
    mon_panel_container_modification.mon_panel_modification_chanson.b_modification_chanson_valider_modification.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (mon_panel_container_modification.mon_panel_modification_chanson.tf_modification_chanson_titre.getText().equals("") || mon_panel_container_modification.mon_panel_modification_chanson.tf_modification_chanson_annee.getText().equals("")){
                javax.swing.JOptionPane.showMessageDialog(mon_panel_container_modification.mon_panel_modification_chanson, "Titre et année obligatoires.");  
                mon_panel_container_modification.mon_panel_modification_chanson.tf_modification_chanson_titre.setBackground(Color.RED);
                mon_panel_container_modification.mon_panel_modification_chanson.tf_modification_chanson_annee.setBackground(Color.RED);
            }
            else{
                System.out.println("Modification d'une chanson");
                mon_panel_container_modification.mon_panel_modification_chanson.tf_modification_chanson_titre.setBackground(Color.WHITE);
                mon_panel_container_modification.mon_panel_modification_chanson.tf_modification_chanson_annee.setBackground(Color.WHITE);
                ma_chanson_a_modifier.suppressionMediaBdd(ma_chanson_a_modifier.getMedia_id());
                ma_chanson_a_modifier = mon_panel_container_modification.mon_panel_modification_chanson.creerChansonAvecDonneesModification(mon_id_chanson_a_modifier);
                ma_chanson_a_modifier.setMedia_type("Chanson");
                ma_chanson_a_modifier.modificationMediaBdd(1);
                ma_chanson_a_modifier.creationChansonBdd();
                ma_chanson_a_modifier.creationGroupeChansonBDD();            
                ma_chanson_a_modifier.creationArtisteBdd(2, ma_chanson_a_modifier.getChanson_interpretes());
                ma_chanson_a_modifier.creationCaracteristiquesBdd(ma_chanson_a_modifier.getChanson_genres(), "genre", "categorized_by");
                ma_chanson_a_modifier.creationCaracteristiquesBdd(ma_chanson_a_modifier.getChanson_tags(), "tag", "is_associated_with");
                ma_chanson_a_modifier.creationCaracteristiquesBdd(ma_chanson_a_modifier.getChanson_studio_production(), "pc", "produced_by");
                ma_chanson_a_modifier.creationRecompensesBdd(ma_chanson_a_modifier.getChanson_ceremonies(),ma_chanson_a_modifier.getChanson_award(), ma_chanson_a_modifier.getChanson_annees_recompenses());
                javax.swing.JOptionPane.showMessageDialog(mon_panel_container_modification, "La chanson "+ma_chanson_a_modifier.getMedia_titre()+" a bien été modifiée.");
            }
        }         
    });
    mon_panel_container_modification.mon_panel_modification_chanson.b_modification_chanson_valider_brouillon.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (mon_panel_container_modification.mon_panel_modification_chanson.tf_modification_chanson_titre.getText().equals("") || mon_panel_container_modification.mon_panel_modification_chanson.tf_modification_chanson_annee.getText().equals("")){
                javax.swing.JOptionPane.showMessageDialog(mon_panel_container_modification.mon_panel_modification_chanson, "Titre et année obligatoires.");  
                mon_panel_container_modification.mon_panel_modification_chanson.tf_modification_chanson_titre.setBackground(Color.RED);
                mon_panel_container_modification.mon_panel_modification_chanson.tf_modification_chanson_annee.setBackground(Color.RED);
            }
            else{
                System.out.println("Modification d'une chanson");
                mon_panel_container_modification.mon_panel_modification_chanson.tf_modification_chanson_titre.setBackground(Color.WHITE);
                mon_panel_container_modification.mon_panel_modification_chanson.tf_modification_chanson_annee.setBackground(Color.WHITE);
                ma_chanson_a_modifier.suppressionMediaBdd(ma_chanson_a_modifier.getMedia_id());
                ma_chanson_a_modifier = mon_panel_container_modification.mon_panel_modification_chanson.creerChansonAvecDonneesModification(mon_id_chanson_a_modifier);
                ma_chanson_a_modifier.setMedia_type("Chanson");
                ma_chanson_a_modifier.modificationMediaBdd(2);
                ma_chanson_a_modifier.creationChansonBdd();
                ma_chanson_a_modifier.creationGroupeChansonBDD();            
                ma_chanson_a_modifier.creationArtisteBdd(2, ma_chanson_a_modifier.getChanson_interpretes());
                ma_chanson_a_modifier.creationCaracteristiquesBdd(ma_chanson_a_modifier.getChanson_genres(), "genre", "categorized_by");
                ma_chanson_a_modifier.creationCaracteristiquesBdd(ma_chanson_a_modifier.getChanson_tags(), "tag", "is_associated_with");
                ma_chanson_a_modifier.creationCaracteristiquesBdd(ma_chanson_a_modifier.getChanson_studio_production(), "pc", "produced_by");
                ma_chanson_a_modifier.creationRecompensesBdd(ma_chanson_a_modifier.getChanson_ceremonies(),ma_chanson_a_modifier.getChanson_award(), ma_chanson_a_modifier.getChanson_annees_recompenses());
                javax.swing.JOptionPane.showMessageDialog(mon_panel_container_modification, "La chanson "+ma_chanson_a_modifier.getMedia_titre()+" a bien été modifiée et mise en brouillon.");
            }
        }         
    });
    mon_panel_container_modification.mon_panel_modification_chanson.b_modification_chanson_ajouter_interprete.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            if (!mon_panel_container_modification.mon_panel_modification_chanson.verifierPresenceStringDansList(mon_panel_container_modification.mon_panel_modification_chanson.li_modification_chanson_liste_interpretes, mon_panel_container_modification.mon_panel_modification_chanson.cb_modification_chanson_artiste)){
            System.out.println("Ajout d'un interprete");
            mon_panel_container_modification.mon_panel_modification_chanson.ajouterElementList(mon_panel_container_modification.mon_panel_modification_chanson.li_modification_chanson_liste_interpretes, mon_panel_container_modification.mon_panel_modification_chanson.cb_modification_chanson_artiste.getSelectedItem().toString());}
            else{
                javax.swing.JOptionPane.showMessageDialog(mon_panel_container_modification, "Erreur : Impossible d'ajouter 2 interprètes identiques.");}
        }           
    });
    mon_panel_container_modification.mon_panel_modification_chanson.b_modification_chanson_ajouter_genre.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            if (!mon_panel_container_modification.mon_panel_modification_chanson.verifierPresenceStringDansList(mon_panel_container_modification.mon_panel_modification_chanson.li_modification_chanson_liste_genres, mon_panel_container_modification.mon_panel_modification_chanson.cb_modification_chanson_genres)){
                System.out.println("Ajout d'un genre");
                mon_panel_container_modification.mon_panel_modification_chanson.ajouterElementList(mon_panel_container_modification.mon_panel_modification_chanson.li_modification_chanson_liste_genres, mon_panel_container_modification.mon_panel_modification_chanson.cb_modification_chanson_genres.getSelectedItem().toString());}
                else{
                    javax.swing.JOptionPane.showMessageDialog(mon_panel_container_modification, "Erreur : Impossible d'ajouter 2 genres identiques.");}
            }    
    });
    mon_panel_container_modification.mon_panel_modification_chanson.b_modification_chanson_ajouter_tag.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            if (!mon_panel_container_modification.mon_panel_modification_chanson.verifierPresenceStringDansList(mon_panel_container_modification.mon_panel_modification_chanson.li_modification_chanson_liste_tags, mon_panel_container_modification.mon_panel_modification_chanson.cb_modification_chanson_tags)){
                System.out.println("Ajout d'un tag");
                mon_panel_container_modification.mon_panel_modification_chanson.ajouterElementList(mon_panel_container_modification.mon_panel_modification_chanson.li_modification_chanson_liste_tags, mon_panel_container_modification.mon_panel_modification_chanson.cb_modification_chanson_tags.getSelectedItem().toString());}
                else{
                    javax.swing.JOptionPane.showMessageDialog(mon_panel_container_modification, "Erreur : Impossible d'ajouter 2 tags identiques.");}
            }     
    });
    mon_panel_container_modification.mon_panel_modification_chanson.b_modification_chanson_suppr_interprete.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            System.out.println("Suppresion d'un interprete");
            mon_panel_container_modification.mon_panel_modification_chanson.retirerElementList(mon_panel_container_modification.mon_panel_modification_chanson.li_modification_chanson_liste_interpretes, mon_panel_container_modification.mon_panel_modification_chanson.li_modification_chanson_liste_interpretes.getSelectedIndex());
        }         
    });
    mon_panel_container_modification.mon_panel_modification_chanson.b_modification_chanson_suppr_genre.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            System.out.println("Suppresion d'un genre");
            mon_panel_container_modification.mon_panel_modification_chanson.retirerElementList(mon_panel_container_modification.mon_panel_modification_chanson.li_modification_chanson_liste_genres, mon_panel_container_modification.mon_panel_modification_chanson.li_modification_chanson_liste_genres.getSelectedIndex());
        }         
    });
    mon_panel_container_modification.mon_panel_modification_chanson.b_modification_chanson_suppr_tag.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            System.out.println("Suppresion d'un tag");
            mon_panel_container_modification.mon_panel_modification_chanson.retirerElementList(mon_panel_container_modification.mon_panel_modification_chanson.li_modification_chanson_liste_tags, mon_panel_container_modification.mon_panel_modification_chanson.li_modification_chanson_liste_tags.getSelectedIndex());
        }         
    });
    mon_panel_container_modification.mon_panel_modification_chanson.b_modification_chanson_ajouter_recompense.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            System.out.println("Ajout d'un element dans le tableau récompense");
            if (mon_panel_container_modification.mon_panel_modification_chanson.cb_modification_chanson_ceremonie.getSelectedItem().toString().equals("Choisissez") || mon_panel_container_modification.mon_panel_modification_chanson.cb_modification_chanson_award.getSelectedItem().toString().equals("Choisissez") ){
                javax.swing.JOptionPane.showMessageDialog(mon_panel_container_modification.mon_panel_modification_chanson, "Erreur : Cérémonie et Award obligatoires");}

            else {
                Object [][] ceremonie_a_ajouter = {{mon_panel_container_modification.mon_panel_modification_chanson.cb_modification_chanson_ceremonie.getSelectedItem().toString(), mon_panel_container_modification.mon_panel_modification_chanson.cb_modification_chanson_award.getSelectedItem().toString(), mon_panel_container_modification.mon_panel_modification_chanson.recupererValeurCB(mon_panel_container_modification.mon_panel_modification_chanson.cb_modification_chanson_annee_award)}}; 
                mon_panel_container_modification.mon_panel_modification_chanson.ajouterDonneesDansTabRecompenses(ceremonie_a_ajouter, mon_panel_container_modification.mon_panel_modification_chanson.tab_modification_chanson_tab_recompenses);
            }
        }         
    });

    mon_panel_container_modification.mon_panel_modification_chanson.b_modification_chanson_suppr_recompense.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            System.out.println("Suppresion d'un element du tableau récompense");
            mon_panel_container_modification.mon_panel_modification_chanson.retirerElementDansTabRecompenses(mon_panel_container_modification.mon_panel_modification_chanson.tab_modification_chanson_tab_recompenses);
        }         
    });
}
public void gestionClicBoutonsModificationArtiste(){
    mon_panel_container_modification.mon_panel_modification_artiste.b_modification_artiste_valider_modification.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            if (mon_panel_container_modification.mon_panel_modification_artiste.tf_modification_artiste_nom.getText().equals("") && mon_panel_container_modification.mon_panel_modification_artiste.tf_modification_artiste_prenom.getText().equals("") && mon_panel_container_modification.mon_panel_modification_artiste.tf_modification_artiste_surnom.getText().equals("")){
                javax.swing.JOptionPane.showMessageDialog(mon_panel_container_modification.mon_panel_modification_artiste, "Nom, prénom ou surnom obligatoire. Si le surnom est laissé vide, il sera initialisé avec le prenom + nom.");  
                mon_panel_container_modification.mon_panel_modification_artiste.tf_modification_artiste_nom.setBackground(Color.RED);
                mon_panel_container_modification.mon_panel_modification_artiste.tf_modification_artiste_prenom.setBackground(Color.RED);
                mon_panel_container_modification.mon_panel_modification_artiste.tf_modification_artiste_surnom.setBackground(Color.RED);
            }
            else{
                if(!mon_panel_container_modification.mon_panel_modification_artiste.tf_modification_artiste_mort.getText().matches("\\d{4}-[01]\\d-[0-3]\\d") && (!mon_panel_container_modification.mon_panel_modification_artiste.tf_modification_artiste_mort.getText().equals(""))){
                    javax.swing.JOptionPane.showMessageDialog(mon_panel_container_modification, "Problème de format de date : yyyy-mm-dd");
                    mon_panel_container_modification.mon_panel_modification_artiste.tf_modification_artiste_mort.setBackground(Color.ORANGE);
                    mon_panel_container_modification.mon_panel_modification_artiste.tf_modification_artiste_naissance.setBackground(Color.WHITE);
                }
                else if(!mon_panel_container_modification.mon_panel_modification_artiste.tf_modification_artiste_naissance.getText().matches("\\d{4}-[01]\\d-[0-3]\\d") && (!mon_panel_container_modification.mon_panel_modification_artiste.tf_modification_artiste_naissance.getText().equals("")) ){
                    javax.swing.JOptionPane.showMessageDialog(mon_panel_container_modification, "Problème de format de date : yyyy-mm-dd");
                    mon_panel_container_modification.mon_panel_modification_artiste.tf_modification_artiste_naissance.setBackground(Color.ORANGE);
                    mon_panel_container_modification.mon_panel_modification_artiste.tf_modification_artiste_mort.setBackground(Color.WHITE);
                }
                else{
                System.out.println("Modification d'un artiste");
                mon_panel_container_modification.mon_panel_modification_artiste.tf_modification_artiste_nom.setBackground(Color.WHITE);
                mon_panel_container_modification.mon_panel_modification_artiste.tf_modification_artiste_prenom.setBackground(Color.WHITE);
                mon_panel_container_modification.mon_panel_modification_artiste.tf_modification_artiste_surnom.setBackground(Color.WHITE);
                mon_panel_container_modification.mon_panel_modification_artiste.tf_modification_artiste_mort.setBackground(Color.WHITE);
                mon_panel_container_modification.mon_panel_modification_artiste.tf_modification_artiste_naissance.setBackground(Color.WHITE);
            
                mon_artiste_a_modifier.suppressionHumanBdd(mon_artiste_a_modifier.getHuman_id());
                mon_artiste_a_modifier = mon_panel_container_modification.mon_panel_modification_artiste.creerArtisteAvecDonneesModification(mon_id_artiste_a_modifier);
                mon_artiste_a_modifier.modificationHumanBdd();
                mon_artiste_a_modifier.creationArtisteBdd(1);
                mon_artiste_a_modifier.creationGroupeArtisteBDD();    
                mon_artiste_a_modifier.creationRecompensesBdd(mon_artiste_a_modifier.getArtiste_ceremonies(),mon_artiste_a_modifier.getArtiste_award(), mon_artiste_a_modifier.getArtiste_annee_recompense());

                javax.swing.JOptionPane.showMessageDialog(mon_panel_container_creation, "L'artiste "+mon_artiste_a_modifier.getArtiste_nickname()+" a bien été modifié.");}
            }
        }         
    });

    mon_panel_container_modification.mon_panel_modification_artiste.b_modification_artiste_valider_brouillon.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            if (mon_panel_container_modification.mon_panel_modification_artiste.tf_modification_artiste_nom.getText().equals("") && mon_panel_container_modification.mon_panel_modification_artiste.tf_modification_artiste_prenom.getText().equals("") && mon_panel_container_modification.mon_panel_modification_artiste.tf_modification_artiste_surnom.getText().equals("")){
                javax.swing.JOptionPane.showMessageDialog(mon_panel_container_modification.mon_panel_modification_artiste, "Nom, prénom ou surnom obligatoire. Si le surnom est laissé vide, il sera initialisé avec le prenom + nom.");  
                mon_panel_container_modification.mon_panel_modification_artiste.tf_modification_artiste_nom.setBackground(Color.RED);
                mon_panel_container_modification.mon_panel_modification_artiste.tf_modification_artiste_prenom.setBackground(Color.RED);
                mon_panel_container_modification.mon_panel_modification_artiste.tf_modification_artiste_surnom.setBackground(Color.RED);
            }
            else{
                if(!mon_panel_container_modification.mon_panel_modification_artiste.tf_modification_artiste_mort.getText().matches("\\d{4}-[01]\\d-[0-3]\\d") && (!mon_panel_container_modification.mon_panel_modification_artiste.tf_modification_artiste_mort.getText().equals(""))){
                    javax.swing.JOptionPane.showMessageDialog(mon_panel_container_modification, "Problème de format de date : yyyy-mm-dd");
                    mon_panel_container_modification.mon_panel_modification_artiste.tf_modification_artiste_mort.setBackground(Color.ORANGE);
                    mon_panel_container_modification.mon_panel_modification_artiste.tf_modification_artiste_naissance.setBackground(Color.WHITE);
                }
                else if(!mon_panel_container_modification.mon_panel_modification_artiste.tf_modification_artiste_naissance.getText().matches("\\d{4}-[01]\\d-[0-3]\\d") && (!mon_panel_container_modification.mon_panel_modification_artiste.tf_modification_artiste_naissance.getText().equals("")) ){
                    javax.swing.JOptionPane.showMessageDialog(mon_panel_container_modification, "Problème de format de date : yyyy-mm-dd");
                    mon_panel_container_modification.mon_panel_modification_artiste.tf_modification_artiste_naissance.setBackground(Color.ORANGE);
                    mon_panel_container_modification.mon_panel_modification_artiste.tf_modification_artiste_mort.setBackground(Color.WHITE);
                }
                else{
                System.out.println("Modification d'un artiste");
                mon_panel_container_modification.mon_panel_modification_artiste.tf_modification_artiste_nom.setBackground(Color.WHITE);
                mon_panel_container_modification.mon_panel_modification_artiste.tf_modification_artiste_prenom.setBackground(Color.WHITE);
                mon_panel_container_modification.mon_panel_modification_artiste.tf_modification_artiste_surnom.setBackground(Color.WHITE);
                mon_panel_container_modification.mon_panel_modification_artiste.tf_modification_artiste_mort.setBackground(Color.WHITE);
                mon_panel_container_modification.mon_panel_modification_artiste.tf_modification_artiste_naissance.setBackground(Color.WHITE);
            
                mon_artiste_a_modifier.suppressionHumanBdd(mon_artiste_a_modifier.getHuman_id());
                mon_artiste_a_modifier = mon_panel_container_modification.mon_panel_modification_artiste.creerArtisteAvecDonneesModification(mon_id_artiste_a_modifier);
                mon_artiste_a_modifier.modificationHumanBdd();
                mon_artiste_a_modifier.creationArtisteBdd(2);
                mon_artiste_a_modifier.creationGroupeArtisteBDD();    
                mon_artiste_a_modifier.creationRecompensesBdd(mon_artiste_a_modifier.getArtiste_ceremonies(),mon_artiste_a_modifier.getArtiste_award(), mon_artiste_a_modifier.getArtiste_annee_recompense());

                javax.swing.JOptionPane.showMessageDialog(mon_panel_container_creation, "L'artiste "+mon_artiste_a_modifier.getArtiste_nickname()+" a bien été modifié et mis en brouillon.");}
            }
        }         
    });
    mon_panel_container_modification.mon_panel_modification_artiste.b_modification_artiste_ajouter_groupe.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            if (!mon_panel_container_modification.mon_panel_modification_artiste.verifierPresenceStringDansList(mon_panel_container_modification.mon_panel_modification_artiste.li_modification_artiste_liste_groupes, mon_panel_container_modification.mon_panel_modification_artiste.cb_modification_artiste_groupe)){
            System.out.println("Ajout d'un groupe");
            mon_panel_container_modification.mon_panel_modification_artiste.ajouterElementList(mon_panel_container_modification.mon_panel_modification_artiste.li_modification_artiste_liste_groupes, mon_panel_container_modification.mon_panel_modification_artiste.cb_modification_artiste_groupe.getSelectedItem().toString());}
            else{
                javax.swing.JOptionPane.showMessageDialog(mon_panel_container_modification, "Erreur : Impossible d'ajouter 2 groupes identiques.");}
        }           
    });
    mon_panel_container_modification.mon_panel_modification_artiste.b_modification_artiste_suppr_groupe.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            System.out.println("Suppresion d'un groupe");
            mon_panel_container_modification.mon_panel_modification_artiste.retirerElementList(mon_panel_container_modification.mon_panel_modification_artiste.li_modification_artiste_liste_groupes, mon_panel_container_modification.mon_panel_modification_artiste.li_modification_artiste_liste_groupes.getSelectedIndex());
        }         
    });
    mon_panel_container_modification.mon_panel_modification_artiste.b_modification_artiste_ajouter_recompense.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            System.out.println("Ajout d'un element dans le tableau récompense");
            if (mon_panel_container_modification.mon_panel_modification_artiste.cb_modification_artiste_ceremonie.getSelectedItem().toString().equals("Choisissez") || mon_panel_container_modification.mon_panel_modification_artiste.cb_modification_artiste_award.getSelectedItem().toString().equals("Choisissez") ){
                javax.swing.JOptionPane.showMessageDialog(mon_panel_container_modification.mon_panel_modification_artiste, "Erreur : Cérémonie et Award obligatoires");}

            else {
                Object [][] ceremonie_a_ajouter = {{mon_panel_container_modification.mon_panel_modification_artiste.cb_modification_artiste_ceremonie.getSelectedItem().toString(), mon_panel_container_modification.mon_panel_modification_artiste.cb_modification_artiste_award.getSelectedItem().toString(), mon_panel_container_modification.mon_panel_modification_artiste.recupererValeurCB(mon_panel_container_modification.mon_panel_modification_artiste.cb_modification_artiste_annee_award)}}; 
                mon_panel_container_modification.mon_panel_modification_artiste.ajouterDonneesDansTabRecompenses(ceremonie_a_ajouter, mon_panel_container_modification.mon_panel_modification_artiste.tab_modification_artiste_tab_recompenses);
            }
        }         
    });
    mon_panel_container_modification.mon_panel_modification_artiste.b_modification_artiste_suppr_recompense.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            System.out.println("Suppresion d'un element du tableau récompense");
            mon_panel_container_modification.mon_panel_modification_artiste.retirerElementDansTabRecompenses(mon_panel_container_modification.mon_panel_modification_artiste.tab_modification_artiste_tab_recompenses);
        }         
    });
}

public void gestionClicBoutonsRechercheFilm(){
    mon_panel_container_recherche.mon_panel_recherche_film.b_recherche_film_supprimer.addActionListener(new java.awt.event.ActionListener(){
        public void actionPerformed(java.awt.event.ActionEvent evt) {  
            objets.C_FILM mon_film_a_supprimer = new objets.C_FILM();
            sr_film_a_modifier = mon_panel_container_recherche.mon_panel_recherche_film.tab_recherche_film_tab_resultats.getSelectedRow();
            if (sr_film_a_modifier==-1){
                javax.swing.JOptionPane.showMessageDialog(mon_panel_container_recherche, "Veuillez d'abord selectionner un film");
            }
            mon_id_film_a_modifier = Integer.valueOf((String)mon_panel_container_recherche.mon_panel_recherche_film.tab_recherche_film_tab_resultats.getModel().getValueAt(sr_film_a_modifier, 0));
            mon_film_a_supprimer.suppressionMediaBdd(mon_id_film_a_modifier);
            

            ((DefaultTableModel)mon_panel_container_recherche.mon_panel_recherche_film.tab_recherche_film_tab_resultats.getModel()).removeRow(mon_panel_container_recherche.mon_panel_recherche_film.tab_recherche_film_tab_resultats.getSelectedRow());
            javax.swing.JOptionPane.showMessageDialog(mon_panel_container_recherche, "Le film a bien été supprimé.");
            }
    });
    mon_panel_container_recherche.mon_panel_recherche_film.b_recherche_film_bloquer.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {  
            objets.C_FILM mon_film_a_bloquer = new objets.C_FILM();
            sr_film_a_modifier = mon_panel_container_recherche.mon_panel_recherche_film.tab_recherche_film_tab_resultats.getSelectedRow();
            if (sr_film_a_modifier==-1){
                javax.swing.JOptionPane.showMessageDialog(mon_panel_container_recherche, "Veuillez d'abord selectionner un film");
            }
            mon_id_film_a_modifier = Integer.valueOf((String)mon_panel_container_recherche.mon_panel_recherche_film.tab_recherche_film_tab_resultats.getModel().getValueAt(sr_film_a_modifier, 0));
            mon_film_a_bloquer.blocageMediaBdd(mon_id_film_a_modifier);
            javax.swing.JOptionPane.showMessageDialog(mon_panel_container_recherche, "Le film a bien été bloqué.");
            }
    });
    mon_panel_container_recherche.mon_panel_recherche_film.b_recherche_film_modifier.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            sr_film_a_modifier = mon_panel_container_recherche.mon_panel_recherche_film.tab_recherche_film_tab_resultats.getSelectedRow();
            if (sr_film_a_modifier==-1){
                javax.swing.JOptionPane.showMessageDialog(mon_panel_container_recherche, "Veuillez d'abord selectionner un film");
            }
            mon_id_film_a_modifier = Integer.valueOf((String)mon_panel_container_recherche.mon_panel_recherche_film.tab_recherche_film_tab_resultats.getModel().getValueAt(sr_film_a_modifier, 0));
            mon_film_a_modifier = mon_film_a_modifier.creerFilmAvecId(mon_id_film_a_modifier);
            mon_panel_container_modification.mon_panel_modification_film.affichageFilmAModifier(mon_film_a_modifier);
        }
    });
}
public void gestionClicBoutonsRechercheLivre(){
    mon_panel_container_recherche.mon_panel_recherche_livre.b_recherche_livre_supprimer.addActionListener(new java.awt.event.ActionListener(){
        public void actionPerformed(java.awt.event.ActionEvent evt) {  
            objets.C_LIVRE mon_livre_a_supprimer = new objets.C_LIVRE();
            sr_livre_a_modifier = mon_panel_container_recherche.mon_panel_recherche_livre.tab_recherche_livre_tab_resultats.getSelectedRow();
            if (sr_livre_a_modifier==-1){
                javax.swing.JOptionPane.showMessageDialog(mon_panel_container_recherche, "Veuillez d'abord selectionner un livre");
            }
            mon_id_livre_a_modifier = Integer.valueOf((String)mon_panel_container_recherche.mon_panel_recherche_livre.tab_recherche_livre_tab_resultats.getModel().getValueAt(sr_livre_a_modifier, 0));
            mon_livre_a_supprimer.suppressionMediaBdd(mon_id_livre_a_modifier);
            ((DefaultTableModel)mon_panel_container_recherche.mon_panel_recherche_livre.tab_recherche_livre_tab_resultats.getModel()).removeRow(mon_panel_container_recherche.mon_panel_recherche_livre.tab_recherche_livre_tab_resultats.getSelectedRow());
            javax.swing.JOptionPane.showMessageDialog(mon_panel_container_recherche, "Le livre a bien été supprimé.");
            }
    });
    mon_panel_container_recherche.mon_panel_recherche_livre.b_recherche_livre_bloquer.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {  
            objets.C_LIVRE mon_livre_a_bloquer = new objets.C_LIVRE();
            sr_livre_a_modifier = mon_panel_container_recherche.mon_panel_recherche_livre.tab_recherche_livre_tab_resultats.getSelectedRow();
            if (sr_livre_a_modifier==-1){
                javax.swing.JOptionPane.showMessageDialog(mon_panel_container_recherche, "Veuillez d'abord selectionner un livre");
            }
            mon_id_livre_a_modifier = Integer.valueOf((String)mon_panel_container_recherche.mon_panel_recherche_livre.tab_recherche_livre_tab_resultats.getModel().getValueAt(sr_livre_a_modifier, 0));
            mon_livre_a_bloquer.blocageMediaBdd(mon_id_livre_a_modifier);
            javax.swing.JOptionPane.showMessageDialog(mon_panel_container_recherche, "Le livre a bien été bloqué.");
            }
    });
    mon_panel_container_recherche.mon_panel_recherche_livre.b_recherche_livre_modifier.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            sr_livre_a_modifier = mon_panel_container_recherche.mon_panel_recherche_livre.tab_recherche_livre_tab_resultats.getSelectedRow();
            if (sr_livre_a_modifier==-1){
                javax.swing.JOptionPane.showMessageDialog(mon_panel_container_recherche, "Veuillez d'abord selectionner un livre");
            }
            mon_id_livre_a_modifier = Integer.valueOf((String)mon_panel_container_recherche.mon_panel_recherche_livre.tab_recherche_livre_tab_resultats.getModel().getValueAt(sr_livre_a_modifier, 0));
            mon_livre_a_modifier = mon_livre_a_modifier.creerLivreAvecId(mon_id_livre_a_modifier);
            mon_panel_container_modification.mon_panel_modification_livre.affichageLivreAModifier(mon_livre_a_modifier);
        }
    });
}
public void gestionClicBoutonsRechercheChanson(){

    mon_panel_container_recherche.mon_panel_recherche_chanson.b_recherche_chanson_supprimer.addActionListener(new java.awt.event.ActionListener(){
        public void actionPerformed(java.awt.event.ActionEvent evt) {  
            objets.C_CHANSON mon_chanson_a_supprimer = new objets.C_CHANSON();
            sr_chanson_a_modifier = mon_panel_container_recherche.mon_panel_recherche_chanson.tab_recherche_chanson_tab_resultats.getSelectedRow();
            if (sr_chanson_a_modifier==-1){
                javax.swing.JOptionPane.showMessageDialog(mon_panel_container_recherche, "Veuillez d'abord selectionner une chanson");
            }
            mon_id_chanson_a_modifier = Integer.valueOf((String)mon_panel_container_recherche.mon_panel_recherche_chanson.tab_recherche_chanson_tab_resultats.getModel().getValueAt(sr_chanson_a_modifier, 0));
            mon_chanson_a_supprimer.suppressionMediaBdd(mon_id_chanson_a_modifier);
            ((DefaultTableModel)mon_panel_container_recherche.mon_panel_recherche_chanson.tab_recherche_chanson_tab_resultats.getModel()).removeRow(mon_panel_container_recherche.mon_panel_recherche_chanson.tab_recherche_chanson_tab_resultats.getSelectedRow());
            javax.swing.JOptionPane.showMessageDialog(mon_panel_container_recherche, "Le chanson a bien été supprimée.");
            }
    });
    mon_panel_container_recherche.mon_panel_recherche_chanson.b_recherche_chanson_bloquer.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {  
            objets.C_CHANSON mon_chanson_a_bloquer = new objets.C_CHANSON();
            sr_chanson_a_modifier = mon_panel_container_recherche.mon_panel_recherche_chanson.tab_recherche_chanson_tab_resultats.getSelectedRow();
            if (sr_chanson_a_modifier==-1){
                javax.swing.JOptionPane.showMessageDialog(mon_panel_container_recherche, "Veuillez d'abord selectionner une chanson");
            }
            mon_id_chanson_a_modifier = Integer.valueOf((String)mon_panel_container_recherche.mon_panel_recherche_chanson.tab_recherche_chanson_tab_resultats.getModel().getValueAt(sr_chanson_a_modifier, 0));
            mon_chanson_a_bloquer.blocageMediaBdd(mon_id_chanson_a_modifier);
            javax.swing.JOptionPane.showMessageDialog(mon_panel_container_recherche, "Le chanson a bien été bloquée.");
            }
    });
    mon_panel_container_recherche.mon_panel_recherche_chanson.b_recherche_chanson_modifier.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            sr_chanson_a_modifier = mon_panel_container_recherche.mon_panel_recherche_chanson.tab_recherche_chanson_tab_resultats.getSelectedRow();
            if (sr_chanson_a_modifier==-1){
                javax.swing.JOptionPane.showMessageDialog(mon_panel_container_recherche, "Veuillez d'abord selectionner une chanson");
            }
            mon_id_chanson_a_modifier = Integer.valueOf((String)mon_panel_container_recherche.mon_panel_recherche_chanson.tab_recherche_chanson_tab_resultats.getModel().getValueAt(sr_chanson_a_modifier, 0));
            ma_chanson_a_modifier = ma_chanson_a_modifier.creerChansonAvecId(mon_id_chanson_a_modifier);
            mon_panel_container_modification.mon_panel_modification_chanson.affichageChansonAModifier(ma_chanson_a_modifier);
        }
    });
}
public void gestionClicBoutonsRechercheArtiste(){
    mon_panel_container_recherche.mon_panel_recherche_artiste.b_recherche_artiste_supprimer.addActionListener(new java.awt.event.ActionListener(){
        public void actionPerformed(java.awt.event.ActionEvent evt) {  
            objets.C_ARTISTE mon_artiste_a_supprimer = new objets.C_ARTISTE();
            sr_artiste_a_modifier = mon_panel_container_recherche.mon_panel_recherche_artiste.tab_recherche_artiste_tab_resultats.getSelectedRow();
            if (sr_artiste_a_modifier==-1){
                javax.swing.JOptionPane.showMessageDialog(mon_panel_container_recherche, "Veuillez d'abord selectionner un artiste");
            }
            mon_id_artiste_a_modifier = Integer.valueOf((String)mon_panel_container_recherche.mon_panel_recherche_artiste.tab_recherche_artiste_tab_resultats.getModel().getValueAt(sr_artiste_a_modifier, 0));
            mon_artiste_a_supprimer.suppressionHumanBdd(mon_id_artiste_a_modifier);
            ((DefaultTableModel)mon_panel_container_recherche.mon_panel_recherche_artiste.tab_recherche_artiste_tab_resultats.getModel()).removeRow(mon_panel_container_recherche.mon_panel_recherche_artiste.tab_recherche_artiste_tab_resultats.getSelectedRow());
            javax.swing.JOptionPane.showMessageDialog(mon_panel_container_recherche, "L'artiste a bien été supprimé.");
            }
    });
    mon_panel_container_recherche.mon_panel_recherche_artiste.b_recherche_artiste_bloquer.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {  
            objets.C_ARTISTE mon_artiste_a_bloquer = new objets.C_ARTISTE();
            sr_artiste_a_modifier = mon_panel_container_recherche.mon_panel_recherche_artiste.tab_recherche_artiste_tab_resultats.getSelectedRow();
            if (sr_artiste_a_modifier==-1){
                javax.swing.JOptionPane.showMessageDialog(mon_panel_container_recherche, "Veuillez d'abord selectionner un artiste");
            }
            mon_id_artiste_a_modifier = Integer.valueOf((String)mon_panel_container_recherche.mon_panel_recherche_artiste.tab_recherche_artiste_tab_resultats.getModel().getValueAt(sr_artiste_a_modifier, 0));
            mon_artiste_a_bloquer.blocageHumanBdd(mon_id_artiste_a_modifier);
            javax.swing.JOptionPane.showMessageDialog(mon_panel_container_recherche, "L'artiste a bien été bloqué.");
            }
    });
    mon_panel_container_recherche.mon_panel_recherche_artiste.b_recherche_artiste_modifier.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            sr_artiste_a_modifier = mon_panel_container_recherche.mon_panel_recherche_artiste.tab_recherche_artiste_tab_resultats.getSelectedRow();
            if (sr_artiste_a_modifier==-1){
                javax.swing.JOptionPane.showMessageDialog(mon_panel_container_recherche, "Veuillez d'abord selectionner un artiste");
            }
            mon_id_artiste_a_modifier = Integer.valueOf((String)mon_panel_container_recherche.mon_panel_recherche_artiste.tab_recherche_artiste_tab_resultats.getModel().getValueAt(sr_artiste_a_modifier, 0));
            mon_artiste_a_modifier = mon_artiste_a_modifier.creerArtisteAvecId(mon_id_artiste_a_modifier);
            mon_panel_container_modification.mon_panel_modification_artiste.affichageArtisteAModifier(mon_artiste_a_modifier);
        }
    });
}
}