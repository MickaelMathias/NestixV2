package graphiques;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;

public class G_panel_modification_chanson extends A_panel_creation_modification {

    bdd.C_requetes mes_requetes_modification_chanson_combobox = new bdd.C_requetes();

    JPanel p_modification_chanson_infos_base = new JPanel();
    JPanel p_modification_chanson_infos_artistes = new JPanel();
    JPanel p_modification_chanson_infos_genres = new JPanel();
    JPanel p_modification_chanson_infos_tags = new JPanel();
    JPanel p_modification_chanson_infos_ceremonie = new JPanel();
    JPanel p_modification_chanson_boutons_validation = new JPanel();
    
    JButton b_modification_chanson_creer_artiste = new JButton("Creer un artiste ?");
    JButton b_modification_chanson_creer_groupe = new JButton("Creer un groupe ?");
    JButton b_modification_chanson_ajouter_groupe = new JButton("Ajout groupe");
    JButton b_modification_chanson_ajouter_interprete = new JButton("Ajout inteprète");
    JButton b_modification_chanson_suppr_groupe = new JButton("Suppr groupe");
    JButton b_modification_chanson_suppr_interprete = new JButton("Suppr interprete");
    JButton b_modification_chanson_creer_genre = new JButton("Creer un genre ?");
    JButton b_modification_chanson_ajouter_genre = new JButton("Ajout genre");
    JButton b_modification_chanson_suppr_genre = new JButton("Suppr genre");
    JButton b_modification_chanson_creer_tag = new JButton("Creer un tag ?");
    JButton b_modification_chanson_ajouter_tag = new JButton("Ajout tag");
    JButton b_modification_chanson_suppr_tag = new JButton("Suppr tag");
    JButton b_modification_chanson_creer_ceremonie = new JButton("Creer cérémonie ?");
    JButton b_modification_chanson_creer_award = new JButton("Creer award ?");
    JButton b_modification_chanson_ajouter_recompense = new JButton("Ajout récompense");
    JButton b_modification_chanson_suppr_recompense = new JButton("Suppr récompense");
    JButton b_modification_chanson_valider_modification = new JButton("Mettre à jour chanson");
    JButton b_modification_chanson_valider_brouillon = new JButton("Brouillon");
    JButton b_modification_chanson_creer_studio_production = new JButton("Créer producteur ?");


    JComboBox cb_modification_chanson_artiste = new JComboBox<>();
    JComboBox cb_modification_chanson_groupe = new JComboBox<>();
    JComboBox cb_modification_chanson_genres = new JComboBox<>();
    JComboBox cb_modification_chanson_tags = new JComboBox<>();
    JComboBox cb_modification_chanson_ceremonie = new JComboBox<>();
    JComboBox cb_modification_chanson_award = new JComboBox<>();
    JComboBox cb_modification_chanson_annee_award = new JComboBox<>();
    JComboBox cb_modification_chanson_studio_production = new JComboBox<>();

    JLabel l_modification_chanson_titre = new JLabel("Titre : ");
    JLabel l_modification_chanson_annee = new JLabel("Année : ");
    JLabel l_modification_chanson_album = new JLabel("Album : ");
    JLabel l_modification_chanson_lien = new JLabel("Lien : ");
    JLabel l_modification_chanson_studio_production = new JLabel("Label : ");
    JLabel l_modification_chanson_groupe = new JLabel("Groupe : ");

    JTextField tf_modification_chanson_titre = new JTextField();
    JTextField tf_modification_chanson_annee = new JTextField();
    JTextField tf_modification_chanson_album = new JTextField();
    JTextField tf_modification_chanson_lien = new JTextField();

    JScrollPane sp_modification_chanson_liste_groupes = new JScrollPane();
    JList li_modification_chanson_liste_groupes = new JList<String>(new DefaultListModel<>());
    JScrollPane sp_modification_chanson_liste_interpretes = new JScrollPane();
    JList li_modification_chanson_liste_interpretes = new JList<String>(new DefaultListModel<>());
    JScrollPane sp_modification_chanson_liste_genres = new JScrollPane();
    JList li_modification_chanson_liste_genres = new JList<String>(new DefaultListModel<>());
    JScrollPane sp_modification_chanson_liste_tags = new JScrollPane();
    JList li_modification_chanson_liste_tags = new JList<String>(new DefaultListModel<>());

    JScrollPane sp_modification_chanson_tab_recompenses = new JScrollPane();
    JTable tab_modification_chanson_tab_recompenses = new JTable();

    public G_panel_modification_chanson() {

        this.setLayout(null);
        this.setBackground(Color.GRAY);
        this.setBounds(10,50,1180,630);
        // INFORMATIONS BASES
        p_modification_chanson_infos_base.setBounds(10,10,1160,150);
        p_modification_chanson_infos_base.setLayout(null);
        p_modification_chanson_infos_base.setBackground(Color.DARK_GRAY);
        this.add(p_modification_chanson_infos_base);

        l_modification_chanson_titre.setBounds(5,5,75,30);
        tf_modification_chanson_titre.setBounds(80,5,150,30);
        l_modification_chanson_annee.setBounds(5,40,75,30);
        tf_modification_chanson_annee.setBounds(80,40,150,30);
        l_modification_chanson_album.setBounds(5,75,75,30);
        tf_modification_chanson_album.setBounds(80,75,150,30);
        l_modification_chanson_lien.setBounds(5,110,75,30);
        tf_modification_chanson_lien.setBounds(80,110,150,30);
        p_modification_chanson_infos_base.add(l_modification_chanson_titre);
        p_modification_chanson_infos_base.add(tf_modification_chanson_titre);
        p_modification_chanson_infos_base.add(l_modification_chanson_annee);
        p_modification_chanson_infos_base.add(tf_modification_chanson_annee);
        p_modification_chanson_infos_base.add(l_modification_chanson_album);
        p_modification_chanson_infos_base.add(tf_modification_chanson_album);
        p_modification_chanson_infos_base.add(l_modification_chanson_lien);
        p_modification_chanson_infos_base.add(tf_modification_chanson_lien);
        l_modification_chanson_studio_production.setBounds(370,5,150,20);
        cb_modification_chanson_studio_production.setModel(new DefaultComboBoxModel<>(new String[] {"Label"}));
        cb_modification_chanson_studio_production.setBounds(320,35,150,30);
        b_modification_chanson_creer_studio_production.setBounds(320,65,150,30);
        p_modification_chanson_infos_base.add(l_modification_chanson_studio_production);
        p_modification_chanson_infos_base.add(cb_modification_chanson_studio_production);
        p_modification_chanson_infos_base.add(b_modification_chanson_creer_studio_production);

        l_modification_chanson_groupe.setBounds(550,5,150,20);
        cb_modification_chanson_groupe.setModel(new DefaultComboBoxModel<>(new String[] {"Groupe"}));
        cb_modification_chanson_groupe.setBounds(500,35,150,30);
        b_modification_chanson_creer_groupe.setBounds(500,65,150,30);
        p_modification_chanson_infos_base.add(l_modification_chanson_groupe);
        p_modification_chanson_infos_base.add(b_modification_chanson_creer_groupe);
        p_modification_chanson_infos_base.add(cb_modification_chanson_groupe);

        // INFORMATIONS ARTISTES

        p_modification_chanson_infos_artistes.setBounds(10,180,320,380);
        p_modification_chanson_infos_artistes.setLayout(null);
        p_modification_chanson_infos_artistes.setBackground(Color.DARK_GRAY); 
        this.add(p_modification_chanson_infos_artistes);
        cb_modification_chanson_artiste.setModel(new DefaultComboBoxModel<>(new String[] { "Artistes"}));
        cb_modification_chanson_artiste.setBounds(85,10,150,30);
        p_modification_chanson_infos_artistes.add(cb_modification_chanson_artiste);
        b_modification_chanson_creer_artiste.setBounds(85,45,150,30);
        p_modification_chanson_infos_artistes.add(b_modification_chanson_creer_artiste);
        b_modification_chanson_ajouter_interprete.setBounds(95,85,130,30);
        p_modification_chanson_infos_artistes.add(b_modification_chanson_ajouter_interprete);
        b_modification_chanson_suppr_interprete.setBounds(95,345,130,30);
        p_modification_chanson_infos_artistes.add(b_modification_chanson_suppr_interprete);

        // INFORMATIONS GENRES

        p_modification_chanson_infos_genres.setBounds(420,180,170,380);
        p_modification_chanson_infos_genres.setLayout(null);
        p_modification_chanson_infos_genres.setBackground(Color.DARK_GRAY);
        this.add(p_modification_chanson_infos_genres);

        cb_modification_chanson_genres.setModel(new DefaultComboBoxModel<>(new String[] { "Genres"}));
        cb_modification_chanson_genres.setBounds(10,10,150,30);
        p_modification_chanson_infos_genres.add(cb_modification_chanson_genres); 
        b_modification_chanson_creer_genre.setBounds(10,45,150,30);
        p_modification_chanson_infos_genres.add(b_modification_chanson_creer_genre); 
        b_modification_chanson_ajouter_genre.setBounds(20,85,130,30);
        p_modification_chanson_infos_genres.add(b_modification_chanson_ajouter_genre);
        b_modification_chanson_suppr_genre.setBounds(20,345,130,30);
        p_modification_chanson_infos_genres.add(b_modification_chanson_suppr_genre);
        
        // INFORMATIONS TAGS 

        p_modification_chanson_infos_tags.setBounds(590,180,170,380);
        p_modification_chanson_infos_tags.setLayout(null);
        p_modification_chanson_infos_tags.setBackground(Color.DARK_GRAY);
        this.add(p_modification_chanson_infos_tags);

        cb_modification_chanson_tags.setModel(new DefaultComboBoxModel<>(new String[] { "Tags"}));
        cb_modification_chanson_tags.setBounds(10,10,150,30);
        p_modification_chanson_infos_tags.add(cb_modification_chanson_tags);
        b_modification_chanson_creer_tag.setBounds(10,45,150,30);
        p_modification_chanson_infos_tags.add(b_modification_chanson_creer_tag);
        b_modification_chanson_ajouter_tag.setBounds(20,85,130,30);
        p_modification_chanson_infos_tags.add(b_modification_chanson_ajouter_tag);
        b_modification_chanson_suppr_tag.setBounds(20,345,130,30);
        p_modification_chanson_infos_tags.add(b_modification_chanson_suppr_tag);

        // INFORMATIONS CEREMONIE

        p_modification_chanson_infos_ceremonie.setBounds(845,180,325,380);
        p_modification_chanson_infos_ceremonie.setLayout(null);
        p_modification_chanson_infos_ceremonie.setBackground(Color.DARK_GRAY);
        this.add(p_modification_chanson_infos_ceremonie);

        cb_modification_chanson_ceremonie.setModel(new DefaultComboBoxModel<>(new String[] { "Ceremonie"}));
        cb_modification_chanson_award.setModel(new DefaultComboBoxModel<>(new String[] { "Award"}));
        cb_modification_chanson_annee_award.setModel(new DefaultComboBoxModel<>(new String[] { "Année"}));
        cb_modification_chanson_ceremonie.setBounds(10,10,150,30);
        p_modification_chanson_infos_ceremonie.add(cb_modification_chanson_ceremonie); 
        cb_modification_chanson_award.setBounds(10,45,150,30);
        p_modification_chanson_infos_ceremonie.add(cb_modification_chanson_award); 
        cb_modification_chanson_annee_award.setBounds(10,80,150,30);
        p_modification_chanson_infos_ceremonie.add(cb_modification_chanson_annee_award); 
        b_modification_chanson_creer_ceremonie.setBounds(170,10,150,30);
        p_modification_chanson_infos_ceremonie.add(b_modification_chanson_creer_ceremonie); 
        b_modification_chanson_creer_award.setBounds(170,45,150,30);
        p_modification_chanson_infos_ceremonie.add(b_modification_chanson_creer_award); 
        b_modification_chanson_ajouter_recompense.setBounds(90,115,150,30);
        p_modification_chanson_infos_ceremonie.add(b_modification_chanson_ajouter_recompense); 
        b_modification_chanson_suppr_recompense.setBounds(90,345,150,30);
        p_modification_chanson_infos_ceremonie.add(b_modification_chanson_suppr_recompense); 

        // BOUTONS VALIDATION

        p_modification_chanson_boutons_validation.setBounds(435,570,315,50);
        p_modification_chanson_boutons_validation.setLayout(null);
        p_modification_chanson_boutons_validation.setBackground(Color.DARK_GRAY);
        this.add(p_modification_chanson_boutons_validation);

        b_modification_chanson_valider_modification.setBounds(5,5,150,40);
        p_modification_chanson_boutons_validation.add(b_modification_chanson_valider_modification);
        b_modification_chanson_valider_brouillon.setBounds(160,5,150,40);
        p_modification_chanson_boutons_validation.add(b_modification_chanson_valider_brouillon);


        // LISTE interpretes
        sp_modification_chanson_liste_interpretes.setBounds(10,120,300,220);
        sp_modification_chanson_liste_interpretes.setViewportView(li_modification_chanson_liste_interpretes);
        p_modification_chanson_infos_artistes.add(sp_modification_chanson_liste_interpretes);
        
        // LISTE GENRE
        sp_modification_chanson_liste_genres.setBounds(5,120,160,220);
        sp_modification_chanson_liste_genres.setViewportView(li_modification_chanson_liste_genres);
        p_modification_chanson_infos_genres.add(sp_modification_chanson_liste_genres);

        // LISTE TAG  
        sp_modification_chanson_liste_tags.setBounds(5,120,160,220);
        sp_modification_chanson_liste_tags.setViewportView(li_modification_chanson_liste_tags);
        p_modification_chanson_infos_tags.add(sp_modification_chanson_liste_tags);

        // LISTE CEREMONIE
        tab_modification_chanson_tab_recompenses.setModel(new javax.swing.table.DefaultTableModel(
            null,new String [] {"Cérémonie", "Récompense", "Année"}));
        sp_modification_chanson_tab_recompenses.setBounds(5,150,315,190);
        sp_modification_chanson_tab_recompenses.setViewportView(tab_modification_chanson_tab_recompenses);
        p_modification_chanson_infos_ceremonie.add(sp_modification_chanson_tab_recompenses);
    }

    public void affichageComboBoxModificationChanson() throws SQLException {
        if(cb_modification_chanson_studio_production.getSelectedItem().equals("Label")){
        mes_requetes_modification_chanson_combobox.rechercheValeursComboBox("SELECT pc_name FROM pc", "pc_name", cb_modification_chanson_studio_production);}
        if(cb_modification_chanson_groupe.getSelectedItem().equals("Groupe")){
        mes_requetes_modification_chanson_combobox.rechercheValeursComboBox("SELECT band_name FROM band", "band_name", cb_modification_chanson_groupe);}
        mes_requetes_modification_chanson_combobox.rechercheValeursComboBox("SELECT artist_nickname FROM artist", "artist_nickname", cb_modification_chanson_artiste);
        mes_requetes_modification_chanson_combobox.rechercheValeursComboBox("SELECT genre_name FROM genre", "genre_name", cb_modification_chanson_genres);
        mes_requetes_modification_chanson_combobox.rechercheValeursComboBox("SELECT tag_name FROM tag", "tag_name", cb_modification_chanson_tags);
        mes_requetes_modification_chanson_combobox.rechercheValeursComboBox("SELECT ceremony_name FROM ceremony", "ceremony_name", cb_modification_chanson_ceremonie);
        mes_requetes_modification_chanson_combobox.rechercheValeursComboBox("SELECT award_name FROM award", "award_name", cb_modification_chanson_award);
        mes_requetes_modification_chanson_combobox.rechercheValeursComboBox("SELECT annee FROM annee", "annee", cb_modification_chanson_annee_award);
    }

    public void affichageChansonAModifier(objets.C_CHANSON ma_chanson_a_afficher){
        // Rempli les composants avec les infos d'une chanson
 
        tf_modification_chanson_titre.setText(ma_chanson_a_afficher.getMedia_titre());
        tf_modification_chanson_annee.setText(ma_chanson_a_afficher.getMedia_annee());
        tf_modification_chanson_lien.setText(ma_chanson_a_afficher.getMedia_lien());
        tf_modification_chanson_album.setText(ma_chanson_a_afficher.getChansonAlbum());

        if (ma_chanson_a_afficher.getChanson_studio_production().size() > 0){
            mes_requetes_modification_chanson_combobox.rechercheValeursComboBox("SELECT pc_name FROM pc", "pc_name", cb_modification_chanson_studio_production);
            cb_modification_chanson_studio_production.setSelectedItem(ma_chanson_a_afficher.getChanson_studio_production().get(0).getCaracteristiquesNom());}
        if (ma_chanson_a_afficher.getChanson_groupe().size() > 0){
            mes_requetes_modification_chanson_combobox.rechercheValeursComboBox("SELECT band_name FROM band", "band_name", cb_modification_chanson_groupe);
            cb_modification_chanson_groupe.setSelectedItem(ma_chanson_a_afficher.getChanson_groupe().get(0).getCaracteristiquesNom());}
        if (ma_chanson_a_afficher.getChanson_interpretes().size()>0){
            this.afficherTabDansList(li_modification_chanson_liste_interpretes,recupererTousNomsArtiste(ma_chanson_a_afficher.getChanson_interpretes()));}
        if (ma_chanson_a_afficher.getChanson_genres().size()>0){
            this.afficherTabDansList(li_modification_chanson_liste_genres,recupererTousNomsCaracteristique(ma_chanson_a_afficher.getChanson_genres()));}
        if (ma_chanson_a_afficher.getChanson_tags().size()>0){
            this.afficherTabDansList(li_modification_chanson_liste_tags,recupererTousNomsCaracteristique(ma_chanson_a_afficher.getChanson_tags()));}
        if (ma_chanson_a_afficher.getChanson_ceremonies().size()>0){
        Object [][] mes_recompenses = this.creerDonnesCeremonies(ma_chanson_a_afficher.getChanson_ceremonies(), ma_chanson_a_afficher.getChanson_award(), ma_chanson_a_afficher.getChanson_annees_recompenses());
        this.ajouterDonneesDansTabRecompenses(mes_recompenses, tab_modification_chanson_tab_recompenses);}
    }

    public objets.C_CHANSON creerChansonAvecDonneesModification(int id){
        // Crée un objet chanson et le rempli avec les informations du panel.
        objets.C_CHANSON ma_chanson_modifiee = new objets.C_CHANSON();
        ma_chanson_modifiee.setMedia_type("Chanson");
        ma_chanson_modifiee.setChansonAlbum(recupererValeurTF(tf_modification_chanson_album));
        ma_chanson_modifiee.setMedia_titre(recupererValeurTF(tf_modification_chanson_titre));
        ma_chanson_modifiee.setMedia_annee(recupererValeurTF(tf_modification_chanson_annee));
        ma_chanson_modifiee.setMedia_lien(recupererValeurTF(tf_modification_chanson_lien));
        if(!isCBVide(cb_modification_chanson_studio_production)){
            ma_chanson_modifiee.setChanson_studio_production(recupererStudioProductionDeComboBox(cb_modification_chanson_studio_production));}
        if(!isCBVide(cb_modification_chanson_groupe)){
            ma_chanson_modifiee.setChanson_groupe(recupererGroupeDeComboBox(cb_modification_chanson_groupe));}
        if(li_modification_chanson_liste_interpretes.getModel().getSize() > 0){
            ma_chanson_modifiee.setChanson_interpretes(recupererTousArtistDeList(li_modification_chanson_liste_interpretes));}
        if(li_modification_chanson_liste_genres.getModel().getSize() > 0){
            ma_chanson_modifiee.setChanson_genres(recupererTousGenreDeList(li_modification_chanson_liste_genres));}
        if(li_modification_chanson_liste_tags.getModel().getSize() > 0){
            ma_chanson_modifiee.setChanson_tags(recupererTousTagDeList(li_modification_chanson_liste_tags));}
        ArrayList <String>  chanson_ceremonie = recupererValeursColonneTableau(tab_modification_chanson_tab_recompenses, 0);
        ArrayList <String>  chanson_award = recupererValeursColonneTableau(tab_modification_chanson_tab_recompenses, 1);
        ArrayList <String>  chanson_annee_award = recupererValeursColonneTableau(tab_modification_chanson_tab_recompenses, 2);
        if(chanson_ceremonie.size() > 0){
            ma_chanson_modifiee.setChanson_ceremonies(recupererTousCeremonieDeArrayList(chanson_ceremonie));}
        if(chanson_award.size() > 0){
            ma_chanson_modifiee.setChanson_award(recupererTousAwardDeArrayList(chanson_award));}  
        if(chanson_annee_award.size() > 0){
            ma_chanson_modifiee.setChanson_annees_recompenses(recupererTousAnneeAwardDeArrayList(chanson_annee_award));}
        System.out.println("Chanson modifiee cree avec données" +ma_chanson_modifiee.toString());
        return ma_chanson_modifiee;
    }
}
