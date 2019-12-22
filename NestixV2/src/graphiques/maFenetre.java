package graphiques;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class maFenetre extends JPanel{
    public static void main(String[] args) throws UnsupportedLookAndFeelException {

        UIManager.setLookAndFeel(new NimbusLookAndFeel()); 
        
        G_fenetre ma_fenetre = new G_fenetre();
        JPanel mon_panel_general = new JPanel(null);
        G_panel_menu mon_panel_menu = new G_panel_menu();
        G_panel_container_creation mon_panel_container_creation = new G_panel_container_creation();
        G_panel_container_recherche mon_panel_container_recherche = new G_panel_container_recherche();
        G_panel_container_modification mon_panel_container_modification = new G_panel_container_modification();
        bdd.C_connexion ma_connexion = new bdd.C_connexion();
        ma_connexion.getConnexion();

        C_events_listener_affichage mes_events_listener_affichage = new C_events_listener_affichage();
        mes_events_listener_affichage.mon_panel_menu = mon_panel_menu;
        mes_events_listener_affichage.mon_panel_container_creation = mon_panel_container_creation;
        mes_events_listener_affichage.mon_panel_container_recherche = mon_panel_container_recherche;
        mes_events_listener_affichage.mon_panel_container_modification = mon_panel_container_modification;
        mes_events_listener_affichage.initEventListenerAffichage();

        mon_panel_general.add(mon_panel_menu);
            mon_panel_container_creation.setVisible(false);
            mon_panel_container_recherche.setVisible(false);
            mon_panel_container_modification.setVisible(false);
            mon_panel_general.add(mon_panel_container_creation);
            mon_panel_general.add(mon_panel_container_recherche);
            mon_panel_general.add(mon_panel_container_modification);
        ma_fenetre.add(mon_panel_general);
               
    }

}