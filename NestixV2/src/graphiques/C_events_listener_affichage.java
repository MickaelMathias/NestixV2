package graphiques;

import java.sql.SQLException;
import java.awt.*;

public class C_events_listener_affichage{

    G_panel_menu mon_panel_menu = new G_panel_menu();
    G_panel_container_creation mon_panel_container_creation = new G_panel_container_creation();
    G_panel_container_modification mon_panel_container_modification = new G_panel_container_modification();
    G_panel_container_recherche mon_panel_container_recherche = new G_panel_container_recherche();

    public C_events_listener_affichage(){
    }

    public void initEventListenerAffichage(){

        /** Affichage lors des clics sur MENU **/
        mon_panel_menu.get_btn_creation().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mon_panel_container_creation.setVisible(true);
                mon_panel_container_recherche.setVisible(false);
                mon_panel_container_modification.setVisible(false);
            }
        });
        mon_panel_menu.get_btn_recherche().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mon_panel_container_creation.setVisible(false);
                mon_panel_container_recherche.setVisible(true);
                mon_panel_container_modification.setVisible(false);
            }
        });
        mon_panel_menu.get_btn_modification().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mon_panel_container_creation.setVisible(false);
                mon_panel_container_recherche.setVisible(false);
                mon_panel_container_modification.setVisible(true);
            }
        });

        /** Affichage lors des clics sur RB pour la création **/
        mon_panel_container_creation.mon_panel_choix_creation.get_rb_choix_film().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt){
                mon_panel_container_creation.get_panel_creation_film().setVisible(true);
                mon_panel_container_creation.get_panel_creation_livre().setVisible(false);
                mon_panel_container_creation.get_panel_creation_chanson().setVisible(false);
                mon_panel_container_creation.get_panel_creation_artiste().setVisible(false);
                try{
                mon_panel_container_creation.mon_panel_creation_film.affichageComboBoxCreationFilm();}
                catch (SQLException e){
                    e.printStackTrace();
                    }
                }
        });
        mon_panel_container_creation.mon_panel_choix_creation.get_rb_choix_chanson().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mon_panel_container_creation.get_panel_creation_film().setVisible(false);
                mon_panel_container_creation.get_panel_creation_livre().setVisible(false);
                mon_panel_container_creation.get_panel_creation_chanson().setVisible(true);
                mon_panel_container_creation.get_panel_creation_artiste().setVisible(false);
                try{
                    mon_panel_container_creation.mon_panel_creation_chanson.affichageComboBoxCreationChanson();}
                    catch (SQLException e){
                        e.printStackTrace();
                    }
                }
        });
        mon_panel_container_creation.mon_panel_choix_creation.get_rb_choix_livre().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mon_panel_container_creation.get_panel_creation_film().setVisible(false);
                mon_panel_container_creation.get_panel_creation_livre().setVisible(true);
                mon_panel_container_creation.get_panel_creation_chanson().setVisible(false);
                mon_panel_container_creation.get_panel_creation_artiste().setVisible(false);
                try{
                    mon_panel_container_creation.mon_panel_creation_livre.affichageComboBoxCreationLivre();}
                    catch (SQLException e){
                        e.printStackTrace();
                    }
                }
        });
        mon_panel_container_creation.mon_panel_choix_creation.get_rb_choix_artiste().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mon_panel_container_creation.get_panel_creation_film().setVisible(false);
                mon_panel_container_creation.get_panel_creation_livre().setVisible(false);
                mon_panel_container_creation.get_panel_creation_chanson().setVisible(false);
                mon_panel_container_creation.get_panel_creation_artiste().setVisible(true);                
                try{
                    mon_panel_container_creation.mon_panel_creation_artiste.affichageComboBoxCreationArtiste();}
                    catch (SQLException e){
                        e.printStackTrace();
                    }
                }
        
        });

        /** Affichage lors des clics sur RB pour la modification **/
        mon_panel_container_modification.mon_panel_choix_modification.get_rb_choix_film().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mon_panel_container_modification.get_panel_modification_film().setVisible(true);
                mon_panel_container_modification.get_panel_modification_livre().setVisible(false);
                mon_panel_container_modification.get_panel_modification_chanson().setVisible(false);
                mon_panel_container_modification.get_panel_modification_artiste().setVisible(false);
                try{
                    mon_panel_container_modification.mon_panel_modification_film.affichageComboBoxModificationFilm();}
                    catch (SQLException e){
                        e.printStackTrace();
                    }
                }
        });
        mon_panel_container_modification.mon_panel_choix_modification.get_rb_choix_chanson().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mon_panel_container_modification.get_panel_modification_film().setVisible(false);
                mon_panel_container_modification.get_panel_modification_livre().setVisible(false);
                mon_panel_container_modification.get_panel_modification_chanson().setVisible(true);
                mon_panel_container_modification.get_panel_modification_artiste().setVisible(false);
                try{
                    mon_panel_container_modification.mon_panel_modification_chanson.affichageComboBoxModificationChanson();}
                    catch (SQLException e){
                        e.printStackTrace();
                    }
                }
        });
        mon_panel_container_modification.mon_panel_choix_modification.get_rb_choix_livre().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mon_panel_container_modification.get_panel_modification_film().setVisible(false);
                mon_panel_container_modification.get_panel_modification_livre().setVisible(true);
                mon_panel_container_modification.get_panel_modification_chanson().setVisible(false);
                mon_panel_container_modification.get_panel_modification_artiste().setVisible(false);
                try{
                    mon_panel_container_modification.mon_panel_modification_livre.affichageComboBoxModificationLivre();}
                    catch (SQLException e){
                        e.printStackTrace();
                    }
                }
        });
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

        /** Affichage lors des clics sur RB pour la recherche **/

        mon_panel_container_recherche.mon_panel_choix_recherche.get_rb_choix_film().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mon_panel_container_recherche.get_panel_recherche_film().setVisible(true);
                mon_panel_container_recherche.get_panel_recherche_livre().setVisible(false);
                mon_panel_container_recherche.get_panel_recherche_chanson().setVisible(false);
                mon_panel_container_recherche.get_panel_recherche_artiste().setVisible(false);    
                try{
                    mon_panel_container_recherche.mon_panel_recherche_film.affichageComboBoxRechercheFilm();}
                    catch (SQLException e){
                        e.printStackTrace();
                    }
                }
        });

        mon_panel_container_recherche.mon_panel_choix_recherche.get_rb_choix_chanson().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mon_panel_container_recherche.get_panel_recherche_film().setVisible(false);
                mon_panel_container_recherche.get_panel_recherche_livre().setVisible(false);
                mon_panel_container_recherche.get_panel_recherche_chanson().setVisible(true);
                mon_panel_container_recherche.get_panel_recherche_artiste().setVisible(false);    
           try{
                   mon_panel_container_recherche.mon_panel_recherche_chanson.affichageComboBoxRechercheChanson();}
                    catch (SQLException e){
                        e.printStackTrace();
                    }
                }
        });

        mon_panel_container_recherche.mon_panel_choix_recherche.get_rb_choix_livre().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mon_panel_container_recherche.get_panel_recherche_film().setVisible(false);
                mon_panel_container_recherche.get_panel_recherche_livre().setVisible(true);
                mon_panel_container_recherche.get_panel_recherche_chanson().setVisible(false);
                mon_panel_container_recherche.get_panel_recherche_artiste().setVisible(false);    
                try{
                    mon_panel_container_recherche.mon_panel_recherche_livre.affichageComboBoxRechercheLivre();}
                    catch (SQLException e){
                        e.printStackTrace();
                    }
                }
        });

        mon_panel_container_recherche.mon_panel_choix_recherche.get_rb_choix_artiste().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mon_panel_container_recherche.get_panel_recherche_film().setVisible(false);
                mon_panel_container_recherche.get_panel_recherche_livre().setVisible(false);
                mon_panel_container_recherche.get_panel_recherche_chanson().setVisible(false);
                mon_panel_container_recherche.get_panel_recherche_artiste().setVisible(true);    
                try{
                    mon_panel_container_recherche.mon_panel_recherche_artiste.affichageComboBoxRechercheArtiste();}
                    catch (SQLException e){
                        e.printStackTrace();
                    }
                }
        });

        // Boutons lors de la création film 

        // Ajout élément aux listes
        mon_panel_container_creation.mon_panel_creation_film.b_creation_film_valider_creation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt){
                // Verif si année et titre vides
                if (mon_panel_container_creation.mon_panel_creation_film.tf_creation_film_titre.getText().equals("") || mon_panel_container_creation.mon_panel_creation_film.tf_creation_film_annee.getText().equals("")){
                    javax.swing.JOptionPane.showMessageDialog(mon_panel_container_creation.mon_panel_creation_film, "Titre et année obligatoires.");  
                    mon_panel_container_creation.mon_panel_creation_film.tf_creation_film_titre.setBackground(Color.RED);
                    mon_panel_container_creation.mon_panel_creation_film.tf_creation_film_annee.setBackground(Color.RED);
                }
                else{
                    System.out.println("Création d'un film");
                    mon_panel_container_creation.mon_panel_creation_film.tf_creation_film_titre.setBackground(Color.WHITE);
                    mon_panel_container_creation.mon_panel_creation_film.tf_creation_film_annee.setBackground(Color.WHITE);
                    mon_panel_container_creation.mon_panel_creation_film.creerFilmAvecDonnees();}
            }         
        });
        mon_panel_container_creation.mon_panel_creation_film.b_creation_film_ajouter_acteur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt){
                if (!mon_panel_container_creation.mon_panel_creation_film.verifierPresenceStringDansList(mon_panel_container_creation.mon_panel_creation_film.li_creation_film_liste_acteurs, mon_panel_container_creation.mon_panel_creation_film.cb_creation_film_artiste)){
                System.out.println("Ajout d'un acteur");
                mon_panel_container_creation.mon_panel_creation_film.ajouterElementList(mon_panel_container_creation.mon_panel_creation_film.li_creation_film_liste_acteurs, mon_panel_container_creation.mon_panel_creation_film.cb_creation_film_artiste.getSelectedItem().toString());}
                else{
                    javax.swing.JOptionPane.showMessageDialog(mon_panel_container_creation, "Erreur : Impossible d'ajouter 2 acteurs identiques.");}
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

        // Suppression d'un élément des listes

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

}