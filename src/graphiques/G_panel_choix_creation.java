package graphiques;

import javax.swing.*;
import java.awt.*;

public class G_panel_choix_creation extends JPanel {
        private static final long serialVersionUID = 1L;

        JLabel l_choix_creation_film = new JLabel("Film");
        JLabel l_choix_creation_chanson = new JLabel("Chanson");
        JLabel l_choix_creation_livre = new JLabel("Livre");
        JLabel l_choix_creation_artiste = new JLabel("Artiste");
        JRadioButton rb_choix_creation_film = new JRadioButton();
        JRadioButton rb_choix_creation_chanson = new JRadioButton();
        JRadioButton rb_choix_creation_livre = new JRadioButton();
        JRadioButton rb_choix_creation_artiste = new JRadioButton();
        ButtonGroup choix_group = new ButtonGroup();

        public G_panel_choix_creation() {
                this.setBounds(350,5,500,40);
                this.setBackground(Color.LIGHT_GRAY);
                this.setLayout(null);
                l_choix_creation_film.setBounds(50,3,100,35);
                rb_choix_creation_film.setBounds(80,8,25,25);
                this.add(l_choix_creation_film);
                this.add(rb_choix_creation_film);
                rb_choix_creation_film.setActionCommand("Film");
                l_choix_creation_chanson.setBounds(155,3,100,35);
                rb_choix_creation_chanson.setBounds(210,8,25,25);
                this.add(l_choix_creation_chanson);
                this.add(rb_choix_creation_chanson);
                rb_choix_creation_chanson.setActionCommand("Chanson");
                l_choix_creation_livre.setBounds(280,3,100,35);
                rb_choix_creation_livre.setBounds(310,8,25,25);
                this.add(l_choix_creation_livre);
                this.add(rb_choix_creation_livre);
                rb_choix_creation_livre.setActionCommand("Livre");
                l_choix_creation_artiste.setBounds(380,3,100,35);
                rb_choix_creation_artiste.setBounds(420,8,25,25);
                this.add(l_choix_creation_artiste);
                this.add(rb_choix_creation_artiste);
                rb_choix_creation_artiste.setActionCommand("Artiste");
                this.choix_group.add(rb_choix_creation_film);
                this.choix_group.add(rb_choix_creation_chanson);
                this.choix_group.add(rb_choix_creation_livre);
                this.choix_group.add(rb_choix_creation_artiste);

        }

        public JRadioButton get_rb_choix_film(){
                return this.rb_choix_creation_film;
        }
        public JRadioButton get_rb_choix_chanson(){
                return this.rb_choix_creation_chanson;
        }
        public JRadioButton get_rb_choix_livre(){
                return this.rb_choix_creation_livre;
        }
        public JRadioButton get_rb_choix_artiste(){
                return this.rb_choix_creation_artiste;
        }

}