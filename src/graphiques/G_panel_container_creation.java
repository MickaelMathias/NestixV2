package graphiques;

import javax.swing.*;
import java.awt.*;

public class G_panel_container_creation extends JPanel {
    private static final long serialVersionUID = 1L;

    G_panel_choix_creation mon_panel_choix_creation = new G_panel_choix_creation();
    G_panel_creation_film mon_panel_creation_film = new G_panel_creation_film();
    G_panel_creation_chanson mon_panel_creation_chanson = new G_panel_creation_chanson();
    G_panel_creation_livre mon_panel_creation_livre = new G_panel_creation_livre();
    G_panel_creation_artiste mon_panel_creation_artiste = new G_panel_creation_artiste();

    public G_panel_container_creation() {
        this.setLayout(null);
        this.setBounds(10,65,1200,700);
        this.setBackground(Color.DARK_GRAY);
        mon_panel_creation_film.setVisible(false);
        mon_panel_creation_chanson.setVisible(false);
        mon_panel_creation_livre.setVisible(false);
        mon_panel_creation_artiste.setVisible(false);
        this.add(mon_panel_choix_creation);
        this.add(mon_panel_creation_film);
        this.add(mon_panel_creation_livre);
        this.add(mon_panel_creation_chanson);
        this.add(mon_panel_creation_artiste);
    }

    public JPanel get_panel_choix_creation(){
        return this.mon_panel_choix_creation;
    }
    public JPanel get_panel_creation_film(){
        return this.mon_panel_creation_film;
    }
    public JPanel get_panel_creation_livre(){
        return this.mon_panel_creation_livre;
    }
    public JPanel get_panel_creation_chanson(){
        return this.mon_panel_creation_chanson;
    }
    public JPanel get_panel_creation_artiste(){
        return this.mon_panel_creation_artiste;
    }

}