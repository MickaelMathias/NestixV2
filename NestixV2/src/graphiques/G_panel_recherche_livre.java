package graphiques;

import java.awt.*;
import java.sql.SQLException;

import javax.swing.*;

public class G_panel_recherche_livre extends JPanel {

	bdd.C_requetes mes_requetes_recherche_livre_combobox = new bdd.C_requetes();
	
    JPanel p_recherche_livre_criteres = new JPanel();
    JPanel p_recherche_livre_resultats = new JPanel();
    JPanel p_recherche_livre_boutons = new JPanel();

    JButton b_recherche_livre_rechercher= new JButton("Recherche");
    JButton b_recherche_livre_modifier= new JButton("Modifier livre");
    JButton b_recherche_livre_bloquer = new JButton("Bloquer");
    JButton b_recherche_livre_supprimer = new JButton("Supprimer");

    JComboBox cb_recherche_livre_titre = new JComboBox<>();
    JComboBox cb_recherche_livre_surnom_ecrivain = new JComboBox<>();
    JComboBox cb_recherche_livre_isbn = new JComboBox<>();
    JComboBox cb_recherche_livre_genre = new JComboBox<>();
    JComboBox cb_recherche_livre_tag = new JComboBox<>();
    JComboBox cb_recherche_livre_annee = new JComboBox<>();


    JLabel l_recherche_livre_titre = new JLabel("Titre");
    JLabel l_recherche_livre_ecrivain = new JLabel("Ecrivain");
    JLabel l_recherche_livre_isbn = new JLabel("ISBN");
    JLabel l_recherche_livre_genre = new JLabel("Genre");
    JLabel l_recherche_livre_tag = new JLabel("Tag");
    JLabel l_recherche_livre_annee = new JLabel("Annee");


    JScrollPane sp_recherche_livre_tab_resultats = new JScrollPane();
    JTable tab_recherche_livre_tab_resultats = new JTable();

    public G_panel_recherche_livre() {

        this.setLayout(null);
        this.setBackground(Color.GRAY);
        this.setBounds(10,50,1180,630);

        // INFORMATIONS BASES
        p_recherche_livre_criteres.setBounds(10,10,1160,120);
        p_recherche_livre_criteres.setLayout(null);
        p_recherche_livre_criteres.setBackground(Color.DARK_GRAY);
        this.add(p_recherche_livre_criteres);

        l_recherche_livre_titre.setBounds(130,5,75,30);
        l_recherche_livre_ecrivain.setBounds(280,5,75,30);
        l_recherche_livre_isbn.setBounds(470,5,75,30);
        l_recherche_livre_genre.setBounds(640,5,75,30);
        l_recherche_livre_tag.setBounds(810,5,75,30);
        l_recherche_livre_annee.setBounds(970,5,75,30);

        cb_recherche_livre_titre.setModel(new DefaultComboBoxModel<>(new String[] {"Titre"}));
        cb_recherche_livre_titre.setBounds(75,40,150,30);
        cb_recherche_livre_surnom_ecrivain.setModel(new DefaultComboBoxModel<>(new String[] {"Ecrivain"}));
        cb_recherche_livre_surnom_ecrivain.setBounds(245,40,150,30);
        cb_recherche_livre_isbn.setModel(new DefaultComboBoxModel<>(new String[] {"ISBN"}));
        cb_recherche_livre_isbn.setBounds(415,40,150,30);
        cb_recherche_livre_genre.setModel(new DefaultComboBoxModel<>(new String[] {"Genre"}));
        cb_recherche_livre_genre.setBounds(585,40,150,30);
        cb_recherche_livre_tag.setModel(new DefaultComboBoxModel<>(new String[] {"Tag"}));
        cb_recherche_livre_tag.setBounds(755,40,150,30);
        cb_recherche_livre_annee.setModel(new DefaultComboBoxModel<>(new String[] {"Année"}));
        cb_recherche_livre_annee.setBounds(915,40,150,30);

        b_recherche_livre_rechercher.setBounds(500,80,150,30);

        p_recherche_livre_criteres.add(l_recherche_livre_titre);
        p_recherche_livre_criteres.add(l_recherche_livre_ecrivain);
        p_recherche_livre_criteres.add(l_recherche_livre_isbn);
        p_recherche_livre_criteres.add(l_recherche_livre_genre);
        p_recherche_livre_criteres.add(l_recherche_livre_tag);
        p_recherche_livre_criteres.add(l_recherche_livre_annee);
        p_recherche_livre_criteres.add(cb_recherche_livre_titre);
        p_recherche_livre_criteres.add(cb_recherche_livre_surnom_ecrivain);
        p_recherche_livre_criteres.add(cb_recherche_livre_isbn);
        p_recherche_livre_criteres.add(cb_recherche_livre_genre);
        p_recherche_livre_criteres.add(cb_recherche_livre_tag);
        p_recherche_livre_criteres.add(cb_recherche_livre_annee);
        p_recherche_livre_criteres.add(b_recherche_livre_rechercher);

        // TABELEAU RESULTATS

        p_recherche_livre_resultats.setBounds(10,140,1160,420);
        p_recherche_livre_resultats.setLayout(null);
        p_recherche_livre_resultats.setBackground(Color.DARK_GRAY); 
        this.add(p_recherche_livre_resultats);

        tab_recherche_livre_tab_resultats.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {{null, null, null, null, null}},new String [] {"ID", "Titre", "Ecrivain", "Annee", "ISBN"}));
        sp_recherche_livre_tab_resultats.setBounds(5,5,1150,410);
        sp_recherche_livre_tab_resultats.setViewportView(tab_recherche_livre_tab_resultats);
        p_recherche_livre_resultats.add(sp_recherche_livre_tab_resultats);

        // BOUTONS VALIDATION

        p_recherche_livre_boutons.setBounds(360,570,470,50);
        p_recherche_livre_boutons.setLayout(null);
        p_recherche_livre_boutons.setBackground(Color.DARK_GRAY);
        this.add(p_recherche_livre_boutons);

        b_recherche_livre_modifier.setBounds(5,5,150,40);
        p_recherche_livre_boutons.add(b_recherche_livre_modifier);
        b_recherche_livre_bloquer.setBounds(160,5,150,40);
        p_recherche_livre_boutons.add(b_recherche_livre_bloquer);
        b_recherche_livre_supprimer.setBounds(315,5,150,40);
        p_recherche_livre_boutons.add(b_recherche_livre_supprimer);
    }

    public void affichageComboBoxRechercheLivre() throws SQLException {
        mes_requetes_recherche_livre_combobox.rechercheValeursComboBox("(SELECT * FROM media WHERE media_type = 'livre' AND media_title IN (SELECT media_title FROM media WHERE media_type = 'livre' ))", "media_title", cb_recherche_livre_titre);
        mes_requetes_recherche_livre_combobox.rechercheValeursComboBox("SELECT DISTINCT artist_nickname FROM artist JOIN take_part_in ON artist.human_id=take_part_in.human_id WHERE work_id=3", "artist_nickname", cb_recherche_livre_surnom_ecrivain);
        mes_requetes_recherche_livre_combobox.rechercheValeursComboBox("SELECT ISBN FROM book", "ISBN", cb_recherche_livre_isbn);
        mes_requetes_recherche_livre_combobox.rechercheValeursComboBox("SELECT genre_name FROM genre", "genre_name", cb_recherche_livre_genre);
        mes_requetes_recherche_livre_combobox.rechercheValeursComboBox("SELECT tag_name FROM tag", "tag_name", cb_recherche_livre_tag);
        mes_requetes_recherche_livre_combobox.rechercheValeursComboBox("SELECT annee FROM annee", "annee", cb_recherche_livre_annee);
    }
}
