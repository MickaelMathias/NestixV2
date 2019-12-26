package graphiques;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;

public class G_panel_modification_artiste extends A_panel_creation_modification {

    bdd.C_requetes mes_requetes_modification_artiste_combobox = new bdd.C_requetes();

	JPanel p_modification_artiste_infos_base = new JPanel();
    JPanel p_modification_artiste_infos_groupe = new JPanel();
    JPanel p_modification_artiste_infos_ceremonie = new JPanel();
    JPanel p_modification_artiste_boutons_validation = new JPanel();

    
    JButton b_modification_artiste_creer_groupe = new JButton("Creer un groupe ?");
    JButton b_modification_artiste_ajouter_groupe = new JButton("Ajout groupe");
    JButton b_modification_artiste_suppr_groupe = new JButton("Suppr groupe");
    JButton b_modification_artiste_creer_ceremonie = new JButton("Creer cérémonie ?");
    JButton b_modification_artiste_creer_award = new JButton("Creer award ?");
    JButton b_modification_artiste_ajouter_recompense = new JButton("Ajout récompense");
    JButton b_modification_artiste_suppr_recompense = new JButton("Suppr récompense");
    JButton b_modification_artiste_valider_modification = new JButton("Mettre à jour artiste");
    JButton b_modification_artiste_valider_brouillon = new JButton("Brouillon");
    JButton b_modification_artiste_creer_pays = new JButton("Creer pays");

    JComboBox cb_modification_artiste_groupe = new JComboBox<>();
    JComboBox cb_modification_artiste_ceremonie = new JComboBox<>();
    JComboBox cb_modification_artiste_award = new JComboBox<>();
    JComboBox cb_modification_artiste_annee_award = new JComboBox<>();
    JComboBox cb_modification_artiste_sexe = new JComboBox<>();
    JComboBox cb_modification_artiste_pays = new JComboBox<>();

    JLabel l_modification_artiste_nom = new JLabel("Nom : ");
    JLabel l_modification_artiste_prenom = new JLabel("Prenom : ");
    JLabel l_modification_artiste_surnom = new JLabel("Surnom : ");
    JLabel l_modification_artiste_naissance = new JLabel("Ne en : ");
    JLabel l_modification_artiste_mort = new JLabel("Mort en : ");
    JLabel l_modification_artiste_sexe = new JLabel("Sexe : ");
    JLabel l_modification_artiste_pays = new JLabel("Pays : ");

    JTextField tf_modification_artiste_nom = new JTextField();
    JTextField tf_modification_artiste_prenom = new JTextField();
    JTextField tf_modification_artiste_surnom = new JTextField();
    JTextField tf_modification_artiste_naissance = new JTextField();
    JTextField tf_modification_artiste_mort = new JTextField();

    JScrollPane sp_modification_artiste_liste_groupes = new JScrollPane();
    JList li_modification_artiste_liste_groupes = new JList<String>(new DefaultListModel<>());
    
    JScrollPane sp_modification_artiste_tab_recompenses = new JScrollPane();
    JTable tab_modification_artiste_tab_recompenses = new JTable();

    public G_panel_modification_artiste() {

        this.setLayout(null);
        this.setBackground(Color.GRAY);
        this.setBounds(10,50,1180,630);
        // INFORMATIONS BASES
        p_modification_artiste_infos_base.setBounds(10,10,1160,150);
        p_modification_artiste_infos_base.setLayout(null);
        p_modification_artiste_infos_base.setBackground(Color.DARK_GRAY);
        this.add(p_modification_artiste_infos_base);

        l_modification_artiste_nom.setBounds(5,40,75,30);//320,40,150,30  5,40,75,30
        tf_modification_artiste_nom.setBounds(80,40,150,30);//395,40,150,30 80,40,150,30
        l_modification_artiste_prenom.setBounds(320,5,75,30);
        tf_modification_artiste_prenom.setBounds(395,5,150,30);
        l_modification_artiste_surnom.setBounds(320,40,75,30);
        tf_modification_artiste_surnom.setBounds(395,40,150,30);
        l_modification_artiste_naissance.setBounds(5,75,75,30);
        tf_modification_artiste_naissance.setBounds(80,75,150,30);
        l_modification_artiste_mort.setBounds(5,110,75,30);
        tf_modification_artiste_mort.setBounds(80,110,150,30);
        l_modification_artiste_sexe.setBounds(5,5,75,30);
        cb_modification_artiste_sexe.setBounds(80,5,150,30);
        l_modification_artiste_pays.setBounds(320,75,150,30);
        cb_modification_artiste_pays.setBounds(395,75,150,30);
        b_modification_artiste_creer_pays.setBounds(395,110,150,30);
        p_modification_artiste_infos_base.add(l_modification_artiste_nom);
        p_modification_artiste_infos_base.add(tf_modification_artiste_nom);
        p_modification_artiste_infos_base.add(l_modification_artiste_prenom);
        p_modification_artiste_infos_base.add(tf_modification_artiste_prenom);
        p_modification_artiste_infos_base.add(l_modification_artiste_surnom);
        p_modification_artiste_infos_base.add(tf_modification_artiste_surnom);
        p_modification_artiste_infos_base.add(l_modification_artiste_naissance);
        p_modification_artiste_infos_base.add(tf_modification_artiste_naissance);
        p_modification_artiste_infos_base.add(l_modification_artiste_mort);
        p_modification_artiste_infos_base.add(tf_modification_artiste_mort);
        cb_modification_artiste_sexe.setModel(new DefaultComboBoxModel<>(new String[] { "Sexe"}));
        cb_modification_artiste_pays.setModel(new DefaultComboBoxModel<>(new String[] { "Pays"}));
        p_modification_artiste_infos_base.add(l_modification_artiste_sexe);
        p_modification_artiste_infos_base.add(cb_modification_artiste_sexe);
        p_modification_artiste_infos_base.add(l_modification_artiste_pays);
        p_modification_artiste_infos_base.add(cb_modification_artiste_pays);
        
        p_modification_artiste_infos_base.add(b_modification_artiste_creer_pays);

        // INFORMATIONS ARTISTES

        p_modification_artiste_infos_groupe.setBounds(330,180,160,380);
        p_modification_artiste_infos_groupe.setLayout(null);
        p_modification_artiste_infos_groupe.setBackground(Color.DARK_GRAY); 
        this.add(p_modification_artiste_infos_groupe);

        cb_modification_artiste_groupe.setModel(new DefaultComboBoxModel<>(new String[] { "Groupe"}));
        cb_modification_artiste_groupe.setBounds(5,10,150,30);
        p_modification_artiste_infos_groupe.add(cb_modification_artiste_groupe);
        b_modification_artiste_creer_groupe.setBounds(5,45,150,30);
        p_modification_artiste_infos_groupe.add(b_modification_artiste_creer_groupe);
        b_modification_artiste_ajouter_groupe.setBounds(15,85,130,30);
        p_modification_artiste_infos_groupe.add(b_modification_artiste_ajouter_groupe);
        b_modification_artiste_suppr_groupe.setBounds(15,345,130,30);
        p_modification_artiste_infos_groupe.add(b_modification_artiste_suppr_groupe);


        // INFORMATIONS CEREMONIE

        p_modification_artiste_infos_ceremonie.setBounds(500,180,325,380);
        p_modification_artiste_infos_ceremonie.setLayout(null);
        p_modification_artiste_infos_ceremonie.setBackground(Color.DARK_GRAY);
        this.add(p_modification_artiste_infos_ceremonie);

        cb_modification_artiste_ceremonie.setModel(new DefaultComboBoxModel<>(new String[] { "Ceremonie"}));
        cb_modification_artiste_award.setModel(new DefaultComboBoxModel<>(new String[] { "Award"}));
        cb_modification_artiste_annee_award.setModel(new DefaultComboBoxModel<>(new String[] { "Annee"}));
        cb_modification_artiste_ceremonie.setBounds(10,10,150,30);
        p_modification_artiste_infos_ceremonie.add(cb_modification_artiste_ceremonie); 
        cb_modification_artiste_award.setBounds(10,45,150,30);
        p_modification_artiste_infos_ceremonie.add(cb_modification_artiste_award); 
        cb_modification_artiste_annee_award.setBounds(10,80,150,30);
        p_modification_artiste_infos_ceremonie.add(cb_modification_artiste_annee_award); 
        b_modification_artiste_creer_ceremonie.setBounds(170,10,150,30);
        p_modification_artiste_infos_ceremonie.add(b_modification_artiste_creer_ceremonie); 
        b_modification_artiste_creer_award.setBounds(170,45,150,30);
        p_modification_artiste_infos_ceremonie.add(b_modification_artiste_creer_award); 
        b_modification_artiste_ajouter_recompense.setBounds(90,115,150,30);
        p_modification_artiste_infos_ceremonie.add(b_modification_artiste_ajouter_recompense); 
        b_modification_artiste_suppr_recompense.setBounds(90,345,150,30);
        p_modification_artiste_infos_ceremonie.add(b_modification_artiste_suppr_recompense); 

        // BOUTONS VALIDATION

        p_modification_artiste_boutons_validation.setBounds(435,570,315,50);
        p_modification_artiste_boutons_validation.setLayout(null);
        p_modification_artiste_boutons_validation.setBackground(Color.DARK_GRAY);
        this.add(p_modification_artiste_boutons_validation);

        b_modification_artiste_valider_modification.setBounds(5,5,150,40);
        p_modification_artiste_boutons_validation.add(b_modification_artiste_valider_modification);
        b_modification_artiste_valider_brouillon.setBounds(160,5,150,40);
        p_modification_artiste_boutons_validation.add(b_modification_artiste_valider_brouillon);

        // LISTE groupeS
        sp_modification_artiste_liste_groupes.setBounds(5,120,150,220);
        sp_modification_artiste_liste_groupes.setViewportView(li_modification_artiste_liste_groupes);
        p_modification_artiste_infos_groupe.add(sp_modification_artiste_liste_groupes);

    
        // LISTE CEREMONIE
        tab_modification_artiste_tab_recompenses.setModel(new javax.swing.table.DefaultTableModel(
        null,new String [] {"Cérémonie", "Récompense", "Année"}));
        sp_modification_artiste_tab_recompenses.setBounds(5,150,315,190);
        sp_modification_artiste_tab_recompenses.setViewportView(tab_modification_artiste_tab_recompenses);
        p_modification_artiste_infos_ceremonie.add(sp_modification_artiste_tab_recompenses);
    }

    public void affichageComboBoxModificationArtiste() throws SQLException {
        mes_requetes_modification_artiste_combobox.rechercheValeursComboBox("SELECT band_name FROM band", "band_name", cb_modification_artiste_groupe);
        if(cb_modification_artiste_pays.getSelectedItem().equals("Pays")){
        mes_requetes_modification_artiste_combobox.rechercheValeursComboBox("SELECT country_name FROM country", "country_name", cb_modification_artiste_pays);}
        mes_requetes_modification_artiste_combobox.rechercheValeursComboBox("SELECT ceremony_name FROM ceremony", "ceremony_name", cb_modification_artiste_ceremonie);
        mes_requetes_modification_artiste_combobox.rechercheValeursComboBox("SELECT award_name FROM award", "award_name", cb_modification_artiste_award);
        mes_requetes_modification_artiste_combobox.rechercheValeursComboBox("SELECT annee FROM annee", "annee", cb_modification_artiste_annee_award);
    }

    public String verifSurnomArtisteModification(){
        String valeur_retour = "";
        if (this.tf_modification_artiste_surnom.getText().equals("")){
            if (this.tf_modification_artiste_nom.getText().equals("")){
                valeur_retour = this.tf_modification_artiste_prenom.getText();}
            else if(this.tf_modification_artiste_prenom.getText().equals("")){
                valeur_retour = this.tf_modification_artiste_nom.getText();}
            else{
                valeur_retour = this.tf_modification_artiste_prenom.getText()+" "+this.tf_modification_artiste_nom.getText();
            }
        }
        else {
            valeur_retour = this.tf_modification_artiste_surnom.getText();
        }
        return valeur_retour;
    }

    public void affichageArtisteAModifier(objets.C_ARTISTE mon_artiste_a_afficher){
        // Rempli les composants avec les infos d'un artiste
        cb_modification_artiste_sexe.setSelectedItem(mon_artiste_a_afficher.getHuman_sexe());
        tf_modification_artiste_nom.setText(mon_artiste_a_afficher.getHuman_nom());
        tf_modification_artiste_prenom.setText(mon_artiste_a_afficher.getHuman_prenom());
        tf_modification_artiste_naissance.setText(mon_artiste_a_afficher.getHuman_dob());
        tf_modification_artiste_mort.setText(mon_artiste_a_afficher.getArtiste_dod());
        tf_modification_artiste_surnom.setText(mon_artiste_a_afficher.getArtiste_nickname());
        if(mon_artiste_a_afficher.getArtiste_pays().size()>0){
        cb_modification_artiste_pays.setSelectedItem(mon_artiste_a_afficher.getArtiste_pays().get(0).getCaracteristiquesNom());}

        if (mon_artiste_a_afficher.getArtiste_pays().size() > 0){
            mes_requetes_modification_artiste_combobox.rechercheValeursComboBox("SELECT country_name FROM country", "country_name", cb_modification_artiste_pays);
            cb_modification_artiste_pays.setSelectedItem(mon_artiste_a_afficher.getArtiste_pays().get(0).getCaracteristiquesNom());}
        if (mon_artiste_a_afficher.getArtiste_groupes().size()>0){
            this.afficherTabDansList(li_modification_artiste_liste_groupes,recupererTousNomsCaracteristique(mon_artiste_a_afficher.getArtiste_groupes()));}
        if (mon_artiste_a_afficher.getArtiste_ceremonies().size()>0){
        Object [][] mes_recompenses = this.creerDonnesCeremonies(mon_artiste_a_afficher.getArtiste_ceremonies(), mon_artiste_a_afficher.getArtiste_award(), mon_artiste_a_afficher.getArtiste_annee_recompense());
        this.ajouterDonneesDansTabRecompenses(mes_recompenses, tab_modification_artiste_tab_recompenses);}
    }

    public objets.C_ARTISTE creerArtisteAvecDonneesModification(int id){
        // Crée un objet artiste et le rempli avec les informations du panel.
        objets.C_ARTISTE mon_artiste_modifie = new objets.C_ARTISTE();

        mon_artiste_modifie.setHuman_sexe(cb_modification_artiste_sexe.getSelectedItem().toString());
        mon_artiste_modifie.setHuman_nom(recupererValeurTF(tf_modification_artiste_nom));
        mon_artiste_modifie.setHuman_prenom(recupererValeurTF(tf_modification_artiste_prenom));
        mon_artiste_modifie.setHuman_dob(recupererValeurTF(tf_modification_artiste_naissance));
        mon_artiste_modifie.setArtiste_dod(recupererValeurTF(tf_modification_artiste_mort));
        mon_artiste_modifie.setArtiste_nickname(verifSurnomArtisteModification());

        if(!isCBVide(cb_modification_artiste_pays)){
            mon_artiste_modifie.setArtiste_pays(recupererPaysDeComboBox(cb_modification_artiste_pays));}
        if(li_modification_artiste_liste_groupes.getModel().getSize() > 0){
            mon_artiste_modifie.setArtiste_groupes(recupererTousGroupeDeList(li_modification_artiste_liste_groupes));}

        ArrayList <String>  artiste_ceremonie = recupererValeursColonneTableau(tab_modification_artiste_tab_recompenses, 0);
        ArrayList <String>  artiste_award = recupererValeursColonneTableau(tab_modification_artiste_tab_recompenses, 1);
        ArrayList <String>  artiste_annee_award = recupererValeursColonneTableau(tab_modification_artiste_tab_recompenses, 2);
        if(artiste_ceremonie.size() > 0){
            mon_artiste_modifie.setArtiste_ceremonies(recupererTousCeremonieDeArrayList(artiste_ceremonie));}
        if(artiste_award.size() > 0){
            mon_artiste_modifie.setArtiste_award(recupererTousAwardDeArrayList(artiste_award));}  
        if(artiste_annee_award.size() > 0){
            mon_artiste_modifie.setArtiste_annee_recompense(recupererTousAnneeAwardDeArrayList(artiste_annee_award));}
        System.out.println("Artiste modifie cree avec données" +mon_artiste_modifie.toString());
        return mon_artiste_modifie;

    }

}
