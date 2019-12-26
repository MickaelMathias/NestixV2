package graphiques;

import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import bdd.C_requetes;
import objets.C_CARACTERISTIQUES;
import objets.C_CEREMONIE;
import objets.C_GENRE;

abstract class A_panel_recherche extends JPanel{

    bdd.C_requetes mes_requetes = new bdd.C_requetes();

    public void AfficheInfosMediaTableau(String type, JTable mon_tableau){
    	Object mesInfosMedia[][] = mes_requetes.rechercheMediaPourAffichage("SELECT * FROM media WHERE media_type = '"+type+"' AND media_title IN (SELECT media_title FROM media WHERE media_type = '"+type+"')");
    	String enteteColonnes[] = {"Id","Titre","Année"};
    	mon_tableau.setModel(new DefaultTableModel(mesInfosMedia, enteteColonnes));
    }

    public void AfficheInfosArtisteTableau(JTable mon_tableau){
    	Object mesInfosHuman[][] = mes_requetes.rechercheHumanPourAffichage("SELECT * FROM human");
    	String enteteColonnes[] = {"Id","Nom","Prenom","Date de naissance"};
    	mon_tableau.setModel(new DefaultTableModel(mesInfosHuman, enteteColonnes));
    }

}