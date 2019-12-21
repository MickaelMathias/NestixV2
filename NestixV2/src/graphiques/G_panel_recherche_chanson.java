package graphiques;

import java.awt.*;
import java.sql.SQLException;

import javax.swing.*;

public class G_panel_recherche_chanson extends JPanel {

	bdd.C_requetes mes_requetes_recherche_chanson_combobox = new bdd.C_requetes();
	
    JPanel p_recherche_chanson_criteres = new JPanel();
    JPanel p_recherche_chanson_resultats = new JPanel();
    JPanel p_recherche_chanson_boutons = new JPanel();

    JButton b_recherche_chanson_rechercher= new JButton("Recherche");
    JButton b_recherche_chanson_modifier= new JButton("Modifier chanson");
    JButton b_recherche_chanson_bloquer = new JButton("Bloquer");
    JButton b_recherche_chanson_supprimer = new JButton("Supprimer");

    JComboBox cb_recherche_chanson_titre = new JComboBox<>();
    JComboBox cb_recherche_chanson_surnom_interprete = new JComboBox<>();
    JComboBox cb_recherche_chanson_album = new JComboBox<>();
    JComboBox cb_recherche_chanson_genre = new JComboBox<>();
    JComboBox cb_recherche_chanson_tag = new JComboBox<>();
    JComboBox cb_recherche_chanson_annee = new JComboBox<>();


    JLabel l_recherche_chanson_titre = new JLabel("Titre");
    JLabel l_recherche_chanson_interprete = new JLabel("interprete");
    JLabel l_recherche_chanson_album = new JLabel("Album");
    JLabel l_recherche_chanson_genre = new JLabel("Genre");
    JLabel l_recherche_chanson_tag = new JLabel("Tag");
    JLabel l_recherche_chanson_annee = new JLabel("Annee");


    JScrollPane sp_recherche_chanson_tab_resultats = new JScrollPane();
    JTable tab_recherche_chanson_tab_resultats = new JTable();

    public G_panel_recherche_chanson() {

        this.setLayout(null);
        this.setBackground(Color.GRAY);
        this.setBounds(10,50,1180,630);

        // INFORMATIONS BASES
        p_recherche_chanson_criteres.setBounds(10,10,1160,120);
        p_recherche_chanson_criteres.setLayout(null);
        p_recherche_chanson_criteres.setBackground(Color.DARK_GRAY);
        this.add(p_recherche_chanson_criteres);

        l_recherche_chanson_titre.setBounds(130,5,75,30);
        l_recherche_chanson_interprete.setBounds(280,5,75,30);
        l_recherche_chanson_album.setBounds(470,5,75,30);
        l_recherche_chanson_genre.setBounds(640,5,75,30);
        l_recherche_chanson_tag.setBounds(810,5,75,30);
        l_recherche_chanson_annee.setBounds(970,5,75,30);

        cb_recherche_chanson_titre.setModel(new DefaultComboBoxModel<>(new String[] {"Titre"}));
        cb_recherche_chanson_titre.setBounds(75,40,150,30);
        cb_recherche_chanson_surnom_interprete.setModel(new DefaultComboBoxModel<>(new String[] { "Interprete"}));
        cb_recherche_chanson_surnom_interprete.setBounds(245,40,150,30);
        cb_recherche_chanson_album.setModel(new DefaultComboBoxModel<>(new String[] {"Album"}));
        cb_recherche_chanson_album.setBounds(415,40,150,30);
        cb_recherche_chanson_genre.setModel(new DefaultComboBoxModel<>(new String[] {"Genre"}));
        cb_recherche_chanson_genre.setBounds(585,40,150,30);
        cb_recherche_chanson_tag.setModel(new DefaultComboBoxModel<>(new String[] {"Tag"}));
        cb_recherche_chanson_tag.setBounds(755,40,150,30);
        cb_recherche_chanson_annee.setModel(new DefaultComboBoxModel<>(new String[] {"Année"}));
        cb_recherche_chanson_annee.setBounds(915,40,150,30);

        b_recherche_chanson_rechercher.setBounds(500,80,150,30);

        p_recherche_chanson_criteres.add(l_recherche_chanson_titre);
        p_recherche_chanson_criteres.add(l_recherche_chanson_interprete);
        p_recherche_chanson_criteres.add(l_recherche_chanson_album);
        p_recherche_chanson_criteres.add(l_recherche_chanson_genre);
        p_recherche_chanson_criteres.add(l_recherche_chanson_tag);
        p_recherche_chanson_criteres.add(l_recherche_chanson_annee);
        p_recherche_chanson_criteres.add(cb_recherche_chanson_titre);
        p_recherche_chanson_criteres.add(cb_recherche_chanson_surnom_interprete);
        p_recherche_chanson_criteres.add(cb_recherche_chanson_album);
        p_recherche_chanson_criteres.add(cb_recherche_chanson_genre);
        p_recherche_chanson_criteres.add(cb_recherche_chanson_tag);
        p_recherche_chanson_criteres.add(cb_recherche_chanson_annee);
        p_recherche_chanson_criteres.add(b_recherche_chanson_rechercher);

        // TABELEAU RESULTATS

        p_recherche_chanson_resultats.setBounds(10,140,1160,420);
        p_recherche_chanson_resultats.setLayout(null);
        p_recherche_chanson_resultats.setBackground(Color.DARK_GRAY); 
        this.add(p_recherche_chanson_resultats);

        tab_recherche_chanson_tab_resultats.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {{null, null, null, null, null}},new String [] {"ID", "Titre", "Interprete", "Annee", "Album"}));
        sp_recherche_chanson_tab_resultats.setBounds(5,5,1150,410);
        sp_recherche_chanson_tab_resultats.setViewportView(tab_recherche_chanson_tab_resultats);
        p_recherche_chanson_resultats.add(sp_recherche_chanson_tab_resultats);

        // BOUTONS VALIDATION

        p_recherche_chanson_boutons.setBounds(360,570,470,50);
        p_recherche_chanson_boutons.setLayout(null);
        p_recherche_chanson_boutons.setBackground(Color.DARK_GRAY);
        this.add(p_recherche_chanson_boutons);

        b_recherche_chanson_modifier.setBounds(5,5,150,40);
        p_recherche_chanson_boutons.add(b_recherche_chanson_modifier);
        b_recherche_chanson_bloquer.setBounds(160,5,150,40);
        p_recherche_chanson_boutons.add(b_recherche_chanson_bloquer);
        b_recherche_chanson_supprimer.setBounds(315,5,150,40);
        p_recherche_chanson_boutons.add(b_recherche_chanson_supprimer);
    }

    public void affichageComboBoxRechercheChanson() throws SQLException {
        mes_requetes_recherche_chanson_combobox.rechercheValeursComboBox("(SELECT * FROM media WHERE media_type = 'chanson' AND media_title IN (SELECT media_title FROM media WHERE media_type = 'chanson' ))", "media_title", cb_recherche_chanson_titre);
        mes_requetes_recherche_chanson_combobox.rechercheValeursComboBox("SELECT DISTINCT artist_nickname FROM artist JOIN take_part_in ON artist.human_id=take_part_in.human_id WHERE work_id=2", "artist_nickname", cb_recherche_chanson_surnom_interprete);
        mes_requetes_recherche_chanson_combobox.rechercheValeursComboBox("SELECT band_name FROM band", "band_name", cb_recherche_chanson_album);
        mes_requetes_recherche_chanson_combobox.rechercheValeursComboBox("SELECT genre_name FROM genre", "genre_name", cb_recherche_chanson_genre);
        mes_requetes_recherche_chanson_combobox.rechercheValeursComboBox("SELECT tag_name FROM tag", "tag_name", cb_recherche_chanson_tag);
        mes_requetes_recherche_chanson_combobox.rechercheValeursComboBox("SELECT annee FROM annee", "annee", cb_recherche_chanson_annee);
    }
}
