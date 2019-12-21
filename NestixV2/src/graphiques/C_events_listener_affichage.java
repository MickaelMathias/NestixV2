package graphiques;

import java.sql.SQLException;

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
                mon_panel_container_recherche.get_panel_recherche_artiste().setVisible(false);    }
            /*    try{
                    mon_panel_container_recherche.mon_panel_recherche_film.affichageComboBoxRechercheFilm();}
                    catch (SQLException e){
                        e.printStackTrace();
                    }
                }*/
        });

        mon_panel_container_recherche.mon_panel_choix_recherche.get_rb_choix_chanson().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mon_panel_container_recherche.get_panel_recherche_film().setVisible(false);
                mon_panel_container_recherche.get_panel_recherche_livre().setVisible(false);
                mon_panel_container_recherche.get_panel_recherche_chanson().setVisible(true);
                mon_panel_container_recherche.get_panel_recherche_artiste().setVisible(false);    }
     /*           try{
                   mon_panel_container_recherche.mon_panel_recherche_chanson.affichageComboBoxRechercheChanson();}
                    catch (SQLException e){
                        e.printStackTrace();
                    }
                }*/
        });

        mon_panel_container_recherche.mon_panel_choix_recherche.get_rb_choix_livre().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mon_panel_container_recherche.get_panel_recherche_film().setVisible(false);
                mon_panel_container_recherche.get_panel_recherche_livre().setVisible(true);
                mon_panel_container_recherche.get_panel_recherche_chanson().setVisible(false);
                mon_panel_container_recherche.get_panel_recherche_artiste().setVisible(false);    }
              /*  try{
                    mon_panel_container_recherche.mon_panel_recherche_livre.affichageComboBoxRechercheLivre();}
                    catch (SQLException e){
                        e.printStackTrace();
                    }
                }*/
        });

        mon_panel_container_recherche.mon_panel_choix_recherche.get_rb_choix_artiste().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mon_panel_container_recherche.get_panel_recherche_film().setVisible(false);
                mon_panel_container_recherche.get_panel_recherche_livre().setVisible(false);
                mon_panel_container_recherche.get_panel_recherche_chanson().setVisible(false);
                mon_panel_container_recherche.get_panel_recherche_artiste().setVisible(true);    }
          /*      try{
                    mon_panel_container_recherche.mon_panel_recherche_artiste.affichageComboBoxRechercheArtiste();}
                    catch (SQLException e){
                        e.printStackTrace();
                    }
                }*/
        });
    }

}