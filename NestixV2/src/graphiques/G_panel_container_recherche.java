package graphiques;

import javax.swing.*;
import java.awt.*;

public class G_panel_container_recherche extends JPanel {
    private static final long serialVersionUID = 1L;

    G_panel_choix_creation mon_panel_choix_recherche = new G_panel_choix_creation();
    G_panel_recherche_film mon_panel_recherche_film = new G_panel_recherche_film();
    G_panel_recherche_chanson mon_panel_recherche_chanson= new G_panel_recherche_chanson();
    G_panel_recherche_livre mon_panel_recherche_livre = new G_panel_recherche_livre();
    G_panel_recherche_artiste mon_panel_recherche_artiste = new G_panel_recherche_artiste();

    public G_panel_container_recherche() {
        this.setLayout(null);
        this.setBounds(10,65,1200,700);
        this.setBackground(Color.DARK_GRAY);
        mon_panel_choix_recherche.setVisible(true);
        mon_panel_recherche_film.setVisible(false);
        mon_panel_recherche_chanson.setVisible(false);
        mon_panel_recherche_livre.setVisible(false);
        mon_panel_recherche_artiste.setVisible(false);

        this.add(mon_panel_choix_recherche);
        this.add(mon_panel_recherche_film);
        this.add(mon_panel_recherche_chanson);
        this.add(mon_panel_recherche_livre);
        this.add(mon_panel_recherche_artiste);
    }

    public JPanel get_panel_choix_recherche(){
        return this.mon_panel_choix_recherche;
    }
    public JPanel get_panel_recherche_film(){
        return this.mon_panel_recherche_film;
    }
    public JPanel get_panel_recherche_chanson(){
        return this.mon_panel_recherche_chanson;
    }
    public JPanel get_panel_recherche_livre(){
        return this.mon_panel_recherche_livre;
    }
    public JPanel get_panel_recherche_artiste(){
        return this.mon_panel_recherche_artiste;
    }

}