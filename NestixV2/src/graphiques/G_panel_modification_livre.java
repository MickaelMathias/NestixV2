package graphiques;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;

public class G_panel_modification_livre extends A_panel_creation_modification {
    
    bdd.C_requetes mes_requetes_modification_livre_combobox = new bdd.C_requetes();

    JPanel p_modification_livre_infos_base = new JPanel();
    JPanel p_modification_livre_infos_artistes = new JPanel();
    JPanel p_modification_livre_infos_genres = new JPanel();
    JPanel p_modification_livre_infos_tags = new JPanel();
    JPanel p_modification_livre_infos_ceremonie = new JPanel();
    JPanel p_modification_livre_boutons_validation = new JPanel();
    
    JButton b_modification_livre_creer_artiste = new JButton("Creer un artiste ?");
    JButton b_modification_livre_ajouter_ecrivain = new JButton("Ajout ecrivain");
    JButton b_modification_livre_suppr_ecrivain = new JButton("Suppr ecrivain");
    JButton b_modification_livre_creer_genre = new JButton("Creer un genre ?");
    JButton b_modification_livre_ajouter_genre = new JButton("Ajout genre");
    JButton b_modification_livre_suppr_genre = new JButton("Suppr genre");
    JButton b_modification_livre_creer_tag = new JButton("Creer un tag ?");
    JButton b_modification_livre_ajouter_tag = new JButton("Ajout tag");
    JButton b_modification_livre_suppr_tag = new JButton("Suppr tag");
    JButton b_modification_livre_creer_ceremonie = new JButton("Creer cérémonie ?");
    JButton b_modification_livre_creer_award = new JButton("Creer award ?");
    JButton b_modification_livre_ajouter_recompense = new JButton("Ajout récompense");
    JButton b_modification_livre_suppr_recompense = new JButton("Suppr récompense");
    JButton b_modification_livre_valider_modification = new JButton("Mettre à jour livre");
    JButton b_modification_livre_valider_brouillon = new JButton("Brouillon");
    JButton b_modification_livre_creer_studio_production = new JButton("Créer éditeur ?");

    JComboBox cb_modification_livre_artiste = new JComboBox<>();
    JComboBox cb_modification_livre_genres = new JComboBox<>();
    JComboBox cb_modification_livre_tags = new JComboBox<>();
    JComboBox cb_modification_livre_ceremonie = new JComboBox<>();
    JComboBox cb_modification_livre_award = new JComboBox<>();
    JComboBox cb_modification_livre_annee_award = new JComboBox<>();
    JComboBox cb_modification_livre_studio_production = new JComboBox<>();

    JLabel l_modification_livre_ISBN= new JLabel("ISBN : ");
    JLabel l_modification_livre_titre = new JLabel("Titre : ");
    JLabel l_modification_livre_tome = new JLabel("Tome : ");
    JLabel l_modification_livre_saga = new JLabel("Saga : ");
    JLabel l_modification_livre_annee = new JLabel("Année : ");
    JLabel l_modification_livre_lien = new JLabel("Lien : ");
    JLabel l_modification_livre_synop = new JLabel("Synopsis : ");
    JLabel l_modification_livre_studio_production = new JLabel("Editeur : ");

    JTextField tf_modification_livre_ISBN = new JTextField();
    JTextField tf_modification_livre_titre = new JTextField();
    JTextField tf_modification_livre_tome = new JTextField();
    JTextField tf_modification_livre_saga = new JTextField();
    JTextField tf_modification_livre_annee = new JTextField();
    JTextField tf_modification_livre_lien = new JTextField();
    
    JScrollPane sp_modification_livre_synop = new JScrollPane();
    JTextArea ta_modification_livre_synop = new JTextArea();
    JScrollPane sp_modification_livre_liste_ecrivains = new JScrollPane();
    JList li_modification_livre_liste_ecrivains = new JList<String>(new DefaultListModel<>());
    JScrollPane sp_modification_livre_liste_genres = new JScrollPane();
    JList li_modification_livre_liste_genres = new JList<String>(new DefaultListModel<>());
    JScrollPane sp_modification_livre_liste_tags = new JScrollPane();
    JList li_modification_livre_liste_tags = new JList<String>(new DefaultListModel<>());

    JScrollPane sp_modification_livre_tab_recompenses = new JScrollPane();
    JTable tab_modification_livre_tab_recompenses = new JTable();

    public G_panel_modification_livre() {

        this.setLayout(null);
        this.setBackground(Color.GRAY);
        this.setBounds(10,50,1180,630);

        // INFORMATIONS BASES
        p_modification_livre_infos_base.setBounds(10,10,1160,150);
        p_modification_livre_infos_base.setLayout(null);
        p_modification_livre_infos_base.setBackground(Color.DARK_GRAY);
        this.add(p_modification_livre_infos_base);

        l_modification_livre_ISBN.setBounds(5,5,75,30);
        tf_modification_livre_ISBN.setBounds(80,5,150,30);
        l_modification_livre_titre.setBounds(5,40,75,30);
        tf_modification_livre_titre.setBounds(80,40,150,30);
        l_modification_livre_tome.setBounds(5,75,75,30);
        tf_modification_livre_tome.setBounds(80,75,150,30);
        l_modification_livre_annee.setBounds(5,110,75,30);
        tf_modification_livre_annee.setBounds(80,110,150,30);

        l_modification_livre_saga.setBounds(5,110,75,30);
        tf_modification_livre_saga.setBounds(80,110,150,30);
        p_modification_livre_infos_base.add(l_modification_livre_ISBN);
        p_modification_livre_infos_base.add(tf_modification_livre_ISBN);
        p_modification_livre_infos_base.add(l_modification_livre_titre);
        p_modification_livre_infos_base.add(tf_modification_livre_titre);
        p_modification_livre_infos_base.add(l_modification_livre_tome);
        p_modification_livre_infos_base.add(tf_modification_livre_tome);
        p_modification_livre_infos_base.add(l_modification_livre_saga);
        p_modification_livre_infos_base.add(tf_modification_livre_saga);

        l_modification_livre_lien.setBounds(300,5,75,30);
        tf_modification_livre_lien.setBounds(380,5,150,30);
        l_modification_livre_saga.setBounds(300,40,75,30);
        tf_modification_livre_saga.setBounds(380,40,150,30);
        p_modification_livre_infos_base.add(l_modification_livre_annee);
        p_modification_livre_infos_base.add(tf_modification_livre_annee);
        p_modification_livre_infos_base.add(l_modification_livre_lien);
        p_modification_livre_infos_base.add(tf_modification_livre_lien);
        l_modification_livre_synop.setBounds(710,5,150,20);
        sp_modification_livre_synop.setBounds(635,30,200,100);
        sp_modification_livre_synop.setViewportView(ta_modification_livre_synop);
        p_modification_livre_infos_base.add(l_modification_livre_synop);
        p_modification_livre_infos_base.add(sp_modification_livre_synop);

        l_modification_livre_studio_production.setBounds(990,5,150,20);
        cb_modification_livre_studio_production.setModel(new DefaultComboBoxModel<>(new String[] { "Editeur"}));
        cb_modification_livre_studio_production.setBounds(950,35,150,20);
        b_modification_livre_creer_studio_production.setBounds(950,65,150,20);

        p_modification_livre_infos_base.add(l_modification_livre_studio_production);
        p_modification_livre_infos_base.add(cb_modification_livre_studio_production);
        p_modification_livre_infos_base.add(b_modification_livre_creer_studio_production);

        // INFORMATIONS ARTISTES

        p_modification_livre_infos_artistes.setBounds(10,180,480,380);
        p_modification_livre_infos_artistes.setLayout(null);
        p_modification_livre_infos_artistes.setBackground(Color.DARK_GRAY); 
        this.add(p_modification_livre_infos_artistes);

        cb_modification_livre_artiste.setModel(new DefaultComboBoxModel<>(new String[] { "Artistes"}));
        cb_modification_livre_artiste.setBounds(165,10,150,30);
        p_modification_livre_infos_artistes.add(cb_modification_livre_artiste);
        b_modification_livre_creer_artiste.setBounds(165,45,150,30);
        p_modification_livre_infos_artistes.add(b_modification_livre_creer_artiste);
        b_modification_livre_ajouter_ecrivain.setBounds(175,85,130,30);
        p_modification_livre_infos_artistes.add(b_modification_livre_ajouter_ecrivain);
        b_modification_livre_suppr_ecrivain.setBounds(175,345,130,30);
        p_modification_livre_infos_artistes.add(b_modification_livre_suppr_ecrivain);

        // INFORMATIONS GENRES

        p_modification_livre_infos_genres.setBounds(495,180,170,380);
        p_modification_livre_infos_genres.setLayout(null);
        p_modification_livre_infos_genres.setBackground(Color.DARK_GRAY);
        this.add(p_modification_livre_infos_genres);

        cb_modification_livre_genres.setModel(new DefaultComboBoxModel<>(new String[] { "Genres"}));
        cb_modification_livre_genres.setBounds(10,10,150,30);
        p_modification_livre_infos_genres.add(cb_modification_livre_genres); 
        b_modification_livre_creer_genre.setBounds(10,45,150,30);
        p_modification_livre_infos_genres.add(b_modification_livre_creer_genre); 
        b_modification_livre_ajouter_genre.setBounds(20,85,130,30);
        p_modification_livre_infos_genres.add(b_modification_livre_ajouter_genre);
        b_modification_livre_suppr_genre.setBounds(20,345,130,30);
        p_modification_livre_infos_genres.add(b_modification_livre_suppr_genre);
        
        // INFORMATIONS TAGS 

        p_modification_livre_infos_tags.setBounds(670,180,170,380);
        p_modification_livre_infos_tags.setLayout(null);
        p_modification_livre_infos_tags.setBackground(Color.DARK_GRAY);
        this.add(p_modification_livre_infos_tags);

        cb_modification_livre_tags.setModel(new DefaultComboBoxModel<>(new String[] { "Tags"}));
        cb_modification_livre_tags.setBounds(10,10,150,30);
        p_modification_livre_infos_tags.add(cb_modification_livre_tags);
        b_modification_livre_creer_tag.setBounds(10,45,150,30);
        p_modification_livre_infos_tags.add(b_modification_livre_creer_tag);
        b_modification_livre_ajouter_tag.setBounds(20,85,130,30);
        p_modification_livre_infos_tags.add(b_modification_livre_ajouter_tag);
        b_modification_livre_suppr_tag.setBounds(20,345,130,30);
        p_modification_livre_infos_tags.add(b_modification_livre_suppr_tag);

        // INFORMATIONS CEREMONIE

        p_modification_livre_infos_ceremonie.setBounds(845,180,325,380);
        p_modification_livre_infos_ceremonie.setLayout(null);
        p_modification_livre_infos_ceremonie.setBackground(Color.DARK_GRAY);
        this.add(p_modification_livre_infos_ceremonie);

        cb_modification_livre_ceremonie.setModel(new DefaultComboBoxModel<>(new String[] { "Ceremonie"}));
        cb_modification_livre_award.setModel(new DefaultComboBoxModel<>(new String[] { "Award"}));
        cb_modification_livre_annee_award.setModel(new DefaultComboBoxModel<>(new String[] { "Année"}));
        cb_modification_livre_ceremonie.setBounds(10,10,150,30);
        p_modification_livre_infos_ceremonie.add(cb_modification_livre_ceremonie); 
        cb_modification_livre_award.setBounds(10,45,150,30);
        p_modification_livre_infos_ceremonie.add(cb_modification_livre_award); 
        cb_modification_livre_annee_award.setBounds(10,80,150,30);
        p_modification_livre_infos_ceremonie.add(cb_modification_livre_annee_award); 
        b_modification_livre_creer_ceremonie.setBounds(170,10,150,30);
        p_modification_livre_infos_ceremonie.add(b_modification_livre_creer_ceremonie); 
        b_modification_livre_creer_award.setBounds(170,45,150,30);
        p_modification_livre_infos_ceremonie.add(b_modification_livre_creer_award); 
        b_modification_livre_ajouter_recompense.setBounds(90,115,150,30);
        p_modification_livre_infos_ceremonie.add(b_modification_livre_ajouter_recompense); 
        b_modification_livre_suppr_recompense.setBounds(90,345,150,30);
        p_modification_livre_infos_ceremonie.add(b_modification_livre_suppr_recompense); 

        // BOUTONS VALIDATION

        p_modification_livre_boutons_validation.setBounds(435,570,315,50);
        p_modification_livre_boutons_validation.setLayout(null);
        p_modification_livre_boutons_validation.setBackground(Color.DARK_GRAY);
        this.add(p_modification_livre_boutons_validation);

        b_modification_livre_valider_modification.setBounds(5,5,150,40);
        p_modification_livre_boutons_validation.add(b_modification_livre_valider_modification);
        b_modification_livre_valider_brouillon.setBounds(160,5,150,40);
        p_modification_livre_boutons_validation.add(b_modification_livre_valider_brouillon);

        // LISTE ECRIVAINS
        sp_modification_livre_liste_ecrivains.setBounds(165,120,150,220);
        sp_modification_livre_liste_ecrivains.setViewportView(li_modification_livre_liste_ecrivains);
        p_modification_livre_infos_artistes.add(sp_modification_livre_liste_ecrivains);
        
        // LISTE GENRE
        sp_modification_livre_liste_genres.setBounds(5,120,160,220);
        sp_modification_livre_liste_genres.setViewportView(li_modification_livre_liste_genres);
        p_modification_livre_infos_genres.add(sp_modification_livre_liste_genres);

        // LISTE TAG  
        sp_modification_livre_liste_tags.setBounds(5,120,160,220);
        sp_modification_livre_liste_tags.setViewportView(li_modification_livre_liste_tags);
        p_modification_livre_infos_tags.add(sp_modification_livre_liste_tags);

        // LISTE CEREMONIE
        tab_modification_livre_tab_recompenses.setModel(new javax.swing.table.DefaultTableModel(
            null,new String [] {"Cérémonie", "Récompense", "Année"}));
        sp_modification_livre_tab_recompenses.setBounds(5,150,315,190);
        sp_modification_livre_tab_recompenses.setViewportView(tab_modification_livre_tab_recompenses);
        p_modification_livre_infos_ceremonie.add(sp_modification_livre_tab_recompenses);
    }

    public void affichageComboBoxModificationLivre() throws SQLException {
        if(cb_modification_livre_studio_production.getSelectedItem().equals("Editeur")){
        mes_requetes_modification_livre_combobox.rechercheValeursComboBox("SELECT pc_name FROM pc", "pc_name", cb_modification_livre_studio_production);}
        mes_requetes_modification_livre_combobox.rechercheValeursComboBox("SELECT artist_nickname FROM artist", "artist_nickname", cb_modification_livre_artiste);
        mes_requetes_modification_livre_combobox.rechercheValeursComboBox("SELECT genre_name FROM genre", "genre_name", cb_modification_livre_genres);
        mes_requetes_modification_livre_combobox.rechercheValeursComboBox("SELECT tag_name FROM tag", "tag_name", cb_modification_livre_tags);
        mes_requetes_modification_livre_combobox.rechercheValeursComboBox("SELECT ceremony_name FROM ceremony", "ceremony_name", cb_modification_livre_ceremonie);
        mes_requetes_modification_livre_combobox.rechercheValeursComboBox("SELECT award_name FROM award", "award_name", cb_modification_livre_award);
        mes_requetes_modification_livre_combobox.rechercheValeursComboBox("SELECT annee FROM annee", "annee", cb_modification_livre_annee_award);
    }

    public void affichageLivreAModifier(objets.C_LIVRE mon_livre_a_afficher){
        // Rempli les composants avec les infos d'une chanson

        tf_modification_livre_ISBN.setText(mon_livre_a_afficher.getLivre_isbn());
        tf_modification_livre_titre.setText(mon_livre_a_afficher.getMedia_titre());
        tf_modification_livre_tome.setText(mon_livre_a_afficher.getLivre_tome());
        tf_modification_livre_annee.setText(mon_livre_a_afficher.getMedia_annee());
        tf_modification_livre_lien.setText(mon_livre_a_afficher.getMedia_lien());
        tf_modification_livre_saga.setText(mon_livre_a_afficher.getLivre_saga());
        ta_modification_livre_synop.setText(mon_livre_a_afficher.getLivre_synop());


        if (mon_livre_a_afficher.getLivre_studio_production().size() > 0){
            mes_requetes_modification_livre_combobox.rechercheValeursComboBox("SELECT pc_name FROM pc", "pc_name", cb_modification_livre_studio_production);
            cb_modification_livre_studio_production.setSelectedItem(mon_livre_a_afficher.getLivre_studio_production().get(0).getCaracteristiquesNom());}
        if (mon_livre_a_afficher.getLivre_ecrivains().size()>0){
            this.afficherTabDansList(li_modification_livre_liste_ecrivains,recupererTousNomsArtiste(mon_livre_a_afficher.getLivre_ecrivains()));}
        if (mon_livre_a_afficher.getLivre_genres().size()>0){
            this.afficherTabDansList(li_modification_livre_liste_genres,recupererTousNomsCaracteristique(mon_livre_a_afficher.getLivre_genres()));}
        if (mon_livre_a_afficher.getLivre_tags().size()>0){
            this.afficherTabDansList(li_modification_livre_liste_tags,recupererTousNomsCaracteristique(mon_livre_a_afficher.getLivre_tags()));}
        if (mon_livre_a_afficher.getLivre_ceremonies().size()>0){
        Object [][] mes_recompenses = this.creerDonnesCeremonies(mon_livre_a_afficher.getLivre_ceremonies(), mon_livre_a_afficher.getLivre_award(), mon_livre_a_afficher.getLivre_annees_recompenses());
        this.ajouterDonneesDansTabRecompenses(mes_recompenses, tab_modification_livre_tab_recompenses);}
    }

    public objets.C_LIVRE creerLivreAvecDonneesModification(int id){
        // Crée un objet livre et le rempli avec les informations du panel.
        objets.C_LIVRE mon_livre_modifiee = new objets.C_LIVRE();
  
        mon_livre_modifiee.setMedia_id(id);
        mon_livre_modifiee.setMedia_type("Livre");
        mon_livre_modifiee.setLivre_isbn(recupererValeurTF(tf_modification_livre_ISBN));
        mon_livre_modifiee.setMedia_titre(recupererValeurTF(tf_modification_livre_titre));
        mon_livre_modifiee.setLivre_tome(recupererValeurTF(tf_modification_livre_tome));
        mon_livre_modifiee.setMedia_annee(recupererValeurTF(tf_modification_livre_annee));
        mon_livre_modifiee.setMedia_lien(recupererValeurTF(tf_modification_livre_lien));
        mon_livre_modifiee.setLivre_saga(recupererValeurTF(tf_modification_livre_saga));
        mon_livre_modifiee.setLivre_synop(recupererValeurTA(ta_modification_livre_synop));

        if(!isCBVide(cb_modification_livre_studio_production)){
            mon_livre_modifiee.setLivre_studio_production(recupererStudioProductionDeComboBox(cb_modification_livre_studio_production));}
        if(li_modification_livre_liste_ecrivains.getModel().getSize() > 0){
            mon_livre_modifiee.setLivre_ecrivains(recupererTousArtistDeList(li_modification_livre_liste_ecrivains));}
        if(li_modification_livre_liste_genres.getModel().getSize() > 0){
            mon_livre_modifiee.setLivre_genres(recupererTousGenreDeList(li_modification_livre_liste_genres));}
        if(li_modification_livre_liste_tags.getModel().getSize() > 0){
            mon_livre_modifiee.setLivre_tags(recupererTousTagDeList(li_modification_livre_liste_tags));}
        ArrayList <String>  livre_ceremonie = recupererValeursColonneTableau(tab_modification_livre_tab_recompenses, 0);
        ArrayList <String>  livre_award = recupererValeursColonneTableau(tab_modification_livre_tab_recompenses, 1);
        ArrayList <String>  livre_annee_award = recupererValeursColonneTableau(tab_modification_livre_tab_recompenses, 2);
        if(livre_ceremonie.size() > 0){
            mon_livre_modifiee.setLivre_ceremonies(recupererTousCeremonieDeArrayList(livre_ceremonie));}
        if(livre_award.size() > 0){
            mon_livre_modifiee.setLivre_award(recupererTousAwardDeArrayList(livre_award));}  
        if(livre_annee_award.size() > 0){
            mon_livre_modifiee.setLivre_annees_recompenses(recupererTousAnneeAwardDeArrayList(livre_annee_award));}
        System.out.println("livre modifie cree avec données" +mon_livre_modifiee.toString());
        return mon_livre_modifiee;
    }

}
