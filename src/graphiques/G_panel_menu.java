package graphiques;

import javax.swing.*;
import java.awt.*;

public class G_panel_menu extends JPanel {

    private static final long serialVersionUID = 1961485946574358100L;
    private JButton btn_creation = new JButton();
    private JButton btn_recherche = new JButton();
    private JButton btn_modification = new JButton();
    private JButton btn_gestion_bdd = new JButton();
    private JButton btn_gestion_users = new JButton();
    private JButton btn_gestion_suggestions = new JButton();
    private JButton btn_gestion_statuts = new JButton();


    public G_panel_menu() {
        this.setBounds(10,10,1200,50);
        this.setBackground(Color.BLACK);
        this.setLayout(new GridLayout(1,6));
        btn_creation.setText("Création");
        btn_recherche.setText("Recherche");
        btn_modification.setText("Modification");
        btn_gestion_bdd.setText("Gestion BDD");
        btn_gestion_users.setText("Gestion Users");
        btn_gestion_suggestions.setText("Gestion Suggestions");
        btn_gestion_statuts.setText("Gestion Statuts");
        this.add(btn_creation);
        this.add(btn_recherche);
        this.add(btn_modification);
        this.add(btn_gestion_bdd);
        this.add(btn_gestion_users);
        this.add(btn_gestion_suggestions);
        this.add(btn_gestion_statuts);
        this.setVisible(true);
    }

    public JButton get_btn_creation(){
        return this.btn_creation;
    }
    public JButton get_btn_recherche(){
        return this.btn_recherche;
    }
    public JButton get_btn_modification(){
        return this.btn_modification;
    }

}