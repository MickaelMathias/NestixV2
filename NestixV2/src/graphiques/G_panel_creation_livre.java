package graphiques;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class G_panel_creation_livre extends A_panel_creation_modification {

    bdd.C_requetes mes_requetes_creation_livre_combobox = new bdd.C_requetes();

    JPanel p_creation_livre_infos_base = new JPanel();
    JPanel p_creation_livre_infos_artistes = new JPanel();
    JPanel p_creation_livre_infos_genres = new JPanel();
    JPanel p_creation_livre_infos_tags = new JPanel();
    JPanel p_creation_livre_infos_ceremonie = new JPanel();
    JPanel p_creation_livre_boutons_validation = new JPanel();
    
    JButton b_creation_livre_creer_artiste = new JButton("Creer un artiste ?");
    JButton b_creation_livre_ajouter_ecrivain = new JButton("Ajout ecrivain");
    JButton b_creation_livre_suppr_ecrivain = new JButton("Suppr ecrivain");
    JButton b_creation_livre_creer_genre = new JButton("Creer un genre ?");
    JButton b_creation_livre_ajouter_genre = new JButton("Ajout genre");
    JButton b_creation_livre_suppr_genre = new JButton("Suppr genre");
    JButton b_creation_livre_creer_tag = new JButton("Creer un tag ?");
    JButton b_creation_livre_ajouter_tag = new JButton("Ajout tag");
    JButton b_creation_livre_suppr_tag = new JButton("Suppr tag");
    JButton b_creation_livre_creer_ceremonie = new JButton("Creer cérémonie ?");
    JButton b_creation_livre_creer_award = new JButton("Creer award ?");
    JButton b_creation_livre_ajouter_recompense = new JButton("Ajout récompense");
    JButton b_creation_livre_suppr_recompense = new JButton("Suppr récompense");
    JButton b_creation_livre_valider_creation = new JButton("Créer livre");
    JButton b_creation_livre_valider_brouillon = new JButton("Brouillon");
    JButton b_creation_livre_creer_studio_production = new JButton("Créer éditeur ?");

    JComboBox cb_creation_livre_artiste = new JComboBox<>();
    JComboBox cb_creation_livre_genres = new JComboBox<>();
    JComboBox cb_creation_livre_tags = new JComboBox<>();
    JComboBox cb_creation_livre_ceremonie = new JComboBox<>();
    JComboBox cb_creation_livre_award = new JComboBox<>();
    JComboBox cb_creation_livre_annee_award = new JComboBox<>();
    JComboBox cb_creation_livre_studio_production = new JComboBox<>();

    JLabel l_creation_livre_ISBN= new JLabel("ISBN : ");
    JLabel l_creation_livre_titre = new JLabel("Titre : ");
    JLabel l_creation_livre_tome = new JLabel("Tome : ");
    JLabel l_creation_livre_saga = new JLabel("Saga : ");
    JLabel l_creation_livre_annee = new JLabel("Année : ");
    JLabel l_creation_livre_lien = new JLabel("Lien : ");
    JLabel l_creation_livre_synop = new JLabel("Synopsis : ");
    JLabel l_creation_livre_studio_production = new JLabel("Editeur : ");

    JTextField tf_creation_livre_ISBN = new JTextField();
    JTextField tf_creation_livre_titre = new JTextField();
    JTextField tf_creation_livre_tome = new JTextField();
    JTextField tf_creation_livre_saga = new JTextField();
    JTextField tf_creation_livre_annee = new JTextField();
    JTextField tf_creation_livre_lien = new JTextField();
    
    JScrollPane sp_creation_livre_synop = new JScrollPane();
    JTextArea ta_creation_livre_synop = new JTextArea();
    JScrollPane sp_creation_livre_liste_ecrivains = new JScrollPane();
    JList li_creation_livre_liste_ecrivains = new JList<String>();
    JScrollPane sp_creation_livre_liste_genres = new JScrollPane();
    JList li_creation_livre_liste_genres = new JList<String>();
    JScrollPane sp_creation_livre_liste_tags = new JScrollPane();
    JList li_creation_livre_liste_tags = new JList<String>();

    JScrollPane sp_creation_livre_tab_recompenses = new JScrollPane();
    JTable tab_creation_livre_tab_recompenses = new JTable();

    public G_panel_creation_livre() {

        this.setLayout(null);
        this.setBackground(Color.GRAY);
        this.setBounds(10,50,1180,630);

        // INFORMATIONS BASES
        p_creation_livre_infos_base.setBounds(10,10,1160,150);
        p_creation_livre_infos_base.setLayout(null);
        p_creation_livre_infos_base.setBackground(Color.DARK_GRAY);
        this.add(p_creation_livre_infos_base);

        l_creation_livre_ISBN.setBounds(5,5,75,30);
        tf_creation_livre_ISBN.setBounds(80,5,150,30);
        l_creation_livre_titre.setBounds(5,40,75,30);
        tf_creation_livre_titre.setBounds(80,40,150,30);
        l_creation_livre_tome.setBounds(5,75,75,30);
        tf_creation_livre_tome.setBounds(80,75,150,30);
        l_creation_livre_annee.setBounds(5,110,75,30);
        tf_creation_livre_annee.setBounds(80,110,150,30);

        l_creation_livre_saga.setBounds(5,110,75,30);
        tf_creation_livre_saga.setBounds(80,110,150,30);
        p_creation_livre_infos_base.add(l_creation_livre_ISBN);
        p_creation_livre_infos_base.add(tf_creation_livre_ISBN);
        p_creation_livre_infos_base.add(l_creation_livre_titre);
        p_creation_livre_infos_base.add(tf_creation_livre_titre);
        p_creation_livre_infos_base.add(l_creation_livre_tome);
        p_creation_livre_infos_base.add(tf_creation_livre_tome);
        p_creation_livre_infos_base.add(l_creation_livre_saga);
        p_creation_livre_infos_base.add(tf_creation_livre_saga);

        l_creation_livre_lien.setBounds(300,5,75,30);
        tf_creation_livre_lien.setBounds(380,5,150,30);
        l_creation_livre_saga.setBounds(300,40,75,30);
        tf_creation_livre_saga.setBounds(380,40,150,30);
        p_creation_livre_infos_base.add(l_creation_livre_annee);
        p_creation_livre_infos_base.add(tf_creation_livre_annee);
        p_creation_livre_infos_base.add(l_creation_livre_lien);
        p_creation_livre_infos_base.add(tf_creation_livre_lien);
        l_creation_livre_synop.setBounds(710,5,150,20);
        sp_creation_livre_synop.setBounds(635,30,200,100);
        sp_creation_livre_synop.setViewportView(ta_creation_livre_synop);
        p_creation_livre_infos_base.add(l_creation_livre_synop);
        p_creation_livre_infos_base.add(sp_creation_livre_synop);

        l_creation_livre_studio_production.setBounds(990,5,150,20);
        cb_creation_livre_studio_production.setModel(new DefaultComboBoxModel<>(new String[] { "Editeur"}));
        cb_creation_livre_studio_production.setBounds(950,35,150,30);
        b_creation_livre_creer_studio_production.setBounds(950,65,150,30);

        p_creation_livre_infos_base.add(l_creation_livre_studio_production);
        p_creation_livre_infos_base.add(cb_creation_livre_studio_production);
        p_creation_livre_infos_base.add(b_creation_livre_creer_studio_production);

        // INFORMATIONS ARTISTES

        p_creation_livre_infos_artistes.setBounds(10,180,480,380);
        p_creation_livre_infos_artistes.setLayout(null);
        p_creation_livre_infos_artistes.setBackground(Color.DARK_GRAY); 
        this.add(p_creation_livre_infos_artistes);

        cb_creation_livre_artiste.setModel(new DefaultComboBoxModel<>(new String[] { "Artistes"}));
        cb_creation_livre_artiste.setBounds(165,10,150,30);
        p_creation_livre_infos_artistes.add(cb_creation_livre_artiste);
        b_creation_livre_creer_artiste.setBounds(165,45,150,30);
        p_creation_livre_infos_artistes.add(b_creation_livre_creer_artiste);
        b_creation_livre_ajouter_ecrivain.setBounds(175,85,130,30);
        p_creation_livre_infos_artistes.add(b_creation_livre_ajouter_ecrivain);
        b_creation_livre_suppr_ecrivain.setBounds(175,345,130,30);
        p_creation_livre_infos_artistes.add(b_creation_livre_suppr_ecrivain);

        // INFORMATIONS GENRES

        p_creation_livre_infos_genres.setBounds(495,180,170,380);
        p_creation_livre_infos_genres.setLayout(null);
        p_creation_livre_infos_genres.setBackground(Color.DARK_GRAY);
        this.add(p_creation_livre_infos_genres);

        cb_creation_livre_genres.setModel(new DefaultComboBoxModel<>(new String[] { "Genres"}));
        cb_creation_livre_genres.setBounds(10,10,150,30);
        p_creation_livre_infos_genres.add(cb_creation_livre_genres); 
        b_creation_livre_creer_genre.setBounds(10,45,150,30);
        p_creation_livre_infos_genres.add(b_creation_livre_creer_genre); 
        b_creation_livre_ajouter_genre.setBounds(20,85,130,30);
        p_creation_livre_infos_genres.add(b_creation_livre_ajouter_genre);
        b_creation_livre_suppr_genre.setBounds(20,345,130,30);
        p_creation_livre_infos_genres.add(b_creation_livre_suppr_genre);
        
        // INFORMATIONS TAGS 

        p_creation_livre_infos_tags.setBounds(670,180,170,380);
        p_creation_livre_infos_tags.setLayout(null);
        p_creation_livre_infos_tags.setBackground(Color.DARK_GRAY);
        this.add(p_creation_livre_infos_tags);

        cb_creation_livre_tags.setModel(new DefaultComboBoxModel<>(new String[] { "Tags"}));
        cb_creation_livre_tags.setBounds(10,10,150,30);
        p_creation_livre_infos_tags.add(cb_creation_livre_tags);
        b_creation_livre_creer_tag.setBounds(10,45,150,30);
        p_creation_livre_infos_tags.add(b_creation_livre_creer_tag);
        b_creation_livre_ajouter_tag.setBounds(20,85,130,30);
        p_creation_livre_infos_tags.add(b_creation_livre_ajouter_tag);
        b_creation_livre_suppr_tag.setBounds(20,345,130,30);
        p_creation_livre_infos_tags.add(b_creation_livre_suppr_tag);

        // INFORMATIONS CEREMONIE

        p_creation_livre_infos_ceremonie.setBounds(845,180,325,380);
        p_creation_livre_infos_ceremonie.setLayout(null);
        p_creation_livre_infos_ceremonie.setBackground(Color.DARK_GRAY);
        this.add(p_creation_livre_infos_ceremonie);

        cb_creation_livre_ceremonie.setModel(new DefaultComboBoxModel<>(new String[] { "Ceremonie"}));
        cb_creation_livre_award.setModel(new DefaultComboBoxModel<>(new String[] { "Award"}));
        cb_creation_livre_annee_award.setModel(new DefaultComboBoxModel<>(new String[] { "Année"}));
        cb_creation_livre_ceremonie.setBounds(10,10,150,30);
        p_creation_livre_infos_ceremonie.add(cb_creation_livre_ceremonie); 
        cb_creation_livre_award.setBounds(10,45,150,30);
        p_creation_livre_infos_ceremonie.add(cb_creation_livre_award); 
        cb_creation_livre_annee_award.setBounds(10,80,150,30);
        p_creation_livre_infos_ceremonie.add(cb_creation_livre_annee_award); 
        b_creation_livre_creer_ceremonie.setBounds(170,10,150,30);
        p_creation_livre_infos_ceremonie.add(b_creation_livre_creer_ceremonie); 
        b_creation_livre_creer_award.setBounds(170,45,150,30);
        p_creation_livre_infos_ceremonie.add(b_creation_livre_creer_award); 
        b_creation_livre_ajouter_recompense.setBounds(90,115,150,30);
        p_creation_livre_infos_ceremonie.add(b_creation_livre_ajouter_recompense); 
        b_creation_livre_suppr_recompense.setBounds(90,345,150,30);
        p_creation_livre_infos_ceremonie.add(b_creation_livre_suppr_recompense); 

        // BOUTONS VALIDATION

        p_creation_livre_boutons_validation.setBounds(435,570,315,50);
        p_creation_livre_boutons_validation.setLayout(null);
        p_creation_livre_boutons_validation.setBackground(Color.DARK_GRAY);
        this.add(p_creation_livre_boutons_validation);

        b_creation_livre_valider_creation.setBounds(5,5,150,40);
        p_creation_livre_boutons_validation.add(b_creation_livre_valider_creation);
        b_creation_livre_valider_brouillon.setBounds(160,5,150,40);
        p_creation_livre_boutons_validation.add(b_creation_livre_valider_brouillon);

        // LISTE ecrivainS
        sp_creation_livre_liste_ecrivains.setBounds(165,120,150,220);
        sp_creation_livre_liste_ecrivains.setViewportView(li_creation_livre_liste_ecrivains);
        p_creation_livre_infos_artistes.add(sp_creation_livre_liste_ecrivains);
        
        // LISTE GENRE
        sp_creation_livre_liste_genres.setBounds(5,120,160,220);
        sp_creation_livre_liste_genres.setViewportView(li_creation_livre_liste_genres);
        p_creation_livre_infos_genres.add(sp_creation_livre_liste_genres);

        // LISTE TAG  
        sp_creation_livre_liste_tags.setBounds(5,120,160,220);
        sp_creation_livre_liste_tags.setViewportView(li_creation_livre_liste_tags);
        p_creation_livre_infos_tags.add(sp_creation_livre_liste_tags);

        // LISTE CEREMONIE
        tab_creation_livre_tab_recompenses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {{null, null, null}},new String [] {"Cérémonie", "Récompense", "Année"}));
        sp_creation_livre_tab_recompenses.setBounds(5,150,315,190);
        sp_creation_livre_tab_recompenses.setViewportView(tab_creation_livre_tab_recompenses);
        p_creation_livre_infos_ceremonie.add(sp_creation_livre_tab_recompenses);
    }

    public void affichageComboBoxCreationLivre() throws SQLException {
        mes_requetes_creation_livre_combobox.rechercheValeursComboBox("SELECT pc_name FROM pc", "pc_name", cb_creation_livre_studio_production);
        mes_requetes_creation_livre_combobox.rechercheValeursComboBox("SELECT artist_nickname FROM artist", "artist_nickname", cb_creation_livre_artiste);
        mes_requetes_creation_livre_combobox.rechercheValeursComboBox("SELECT genre_name FROM genre", "genre_name", cb_creation_livre_genres);
        mes_requetes_creation_livre_combobox.rechercheValeursComboBox("SELECT tag_name FROM tag", "tag_name", cb_creation_livre_tags);
        mes_requetes_creation_livre_combobox.rechercheValeursComboBox("SELECT ceremony_name FROM ceremony", "ceremony_name", cb_creation_livre_ceremonie);
        mes_requetes_creation_livre_combobox.rechercheValeursComboBox("SELECT award_name FROM award", "award_name", cb_creation_livre_award);
        
    }
}