package graphiques;

import javax.swing.*;
import java.awt.*;

public class G_panel_container_modification extends JPanel {
    private static final long serialVersionUID = 1L;

    G_panel_choix_creation mon_panel_choix_modification= new G_panel_choix_creation();
    G_panel_modification_film mon_panel_modification_film = new G_panel_modification_film();
    G_panel_modification_chanson mon_panel_modification_chanson = new G_panel_modification_chanson();
    G_panel_modification_livre mon_panel_modification_livre = new G_panel_modification_livre();
    G_panel_modification_artiste mon_panel_modification_artiste = new G_panel_modification_artiste();

    public G_panel_container_modification() {
        this.setLayout(null);
        this.setBounds(10,65,1200,700);
        this.setBackground(Color.DARK_GRAY);
        mon_panel_choix_modification.setVisible(true);
        mon_panel_modification_film.setVisible(false);
        mon_panel_modification_chanson.setVisible(false);
        mon_panel_modification_livre.setVisible(false);
        mon_panel_modification_artiste.setVisible(false);
        this.add(mon_panel_choix_modification);
        this.add(mon_panel_modification_film);
        this.add(mon_panel_modification_livre);
        this.add(mon_panel_modification_chanson);
        this.add(mon_panel_modification_artiste);
    }

    public JPanel get_panel_choix_modification(){
        return this.mon_panel_choix_modification;
    }
    public JPanel get_panel_modification_film(){
        return this.mon_panel_modification_film;
    }
    public JPanel get_panel_modification_livre(){
        return this.mon_panel_modification_livre;
    }
    public JPanel get_panel_modification_chanson(){
        return this.mon_panel_modification_chanson;
    }
    public JPanel get_panel_modification_artiste(){
        return this.mon_panel_modification_artiste;
    }

}