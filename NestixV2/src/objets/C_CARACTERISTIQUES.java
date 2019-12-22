package objets;

import java.util.*;

public class C_CARACTERISTIQUES{


    public int recupererIdParNom(String champ, String nom){
        String ma_requete_id = "SELECT "+champ+"_id FROM "+champ+" WHERE "+champ+"_name = \""+nom+"\"";
        int id = bdd.C_requetes.rechercheId(ma_requete_id);
        return id;
    }

    public String recupererNomParId(String champ, int id){
        String ma_requete_nom = "SELECT "+champ+"_name FROM "+champ+" WHERE "+champ+"_id = \""+id+"\"";
        String nom = bdd.C_requetes.rechercheNom(ma_requete_nom);
        return nom;
    }

    public ArrayList<Integer> recupererTousLesId(ArrayList<C_CARACTERISTIQUES> mon_tab, String champ, String nom){
        ArrayList<Integer> tab_id = new ArrayList<>();
        for (int i = 0; i < mon_tab.size(); i++){
           tab_id.add(mon_tab.get(i).recupererIdParNom(champ, nom));
        }
        return tab_id;
    }
    public ArrayList<String> recupererTousLesNom(ArrayList<C_CARACTERISTIQUES> mon_tab, String champ, int id){
        ArrayList<String>  tab_nom = new ArrayList<>();
        for (int i = 0; i < mon_tab.size(); i++){
            tab_nom.add(mon_tab.get(i).recupererNomParId(champ, id));
        }
        return tab_nom;
    }

}