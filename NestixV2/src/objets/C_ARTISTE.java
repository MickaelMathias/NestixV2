package objets;

import java.util.*;

public class C_ARTISTE extends C_HUMAN{
    String artiste_dod, artiste_nickname, artiste_asv;

    ArrayList <C_GROUPE> artiste_groupes = new ArrayList<>();
    ArrayList <C_METIER> artiste_metiers = new ArrayList<>();
    ArrayList <C_CEREMONIE> artiste_ceremonies = new ArrayList<>();
    ArrayList <C_AWARD> artiste_award = new ArrayList<>();

    @Override
    public String toString() {
        return "C_ARTISTE{" + "artiste_dod=" + artiste_dod + ", artiste_nickname=" + artiste_nickname + ", artiste_asv=" + artiste_asv + ", artiste_groupes=" + artiste_groupes + ", artiste_metiers=" + artiste_metiers + ", artiste_ceremonies=" + artiste_ceremonies + ", artiste_award=" + artiste_award + '}';
    }

    public String getArtiste_dod() {
        return artiste_dod;
    }

    public void setArtiste_dod(String artiste_dod) {
        this.artiste_dod = artiste_dod;
    }

    public String getArtiste_nickname() {
        return artiste_nickname;
    }

    public void setArtiste_nickname(String artiste_nickname) {
        this.artiste_nickname = artiste_nickname;
    }

    public String getArtiste_asv() {
        return artiste_asv;
    }

    public void setArtiste_asv(String artiste_asv) {
        this.artiste_asv = artiste_asv;
    }

    public ArrayList<C_GROUPE> getArtiste_groupes() {
        return artiste_groupes;
    }

    public void setArtiste_groupes(ArrayList<C_GROUPE> artiste_groupes) {
        this.artiste_groupes = artiste_groupes;
    }

    public ArrayList<C_METIER> getArtiste_metiers() {
        return artiste_metiers;
    }

    public void setArtiste_metiers(ArrayList<C_METIER> artiste_metiers) {
        this.artiste_metiers = artiste_metiers;
    }

    public ArrayList<C_CEREMONIE> getArtiste_ceremonies() {
        return artiste_ceremonies;
    }

    public void setArtiste_ceremonies(ArrayList<C_CEREMONIE> artiste_ceremonies) {
        this.artiste_ceremonies = artiste_ceremonies;
    }

    public ArrayList<C_AWARD> getArtiste_award() {
        return artiste_award;
    }

    public void setArtiste_award(ArrayList<C_AWARD> artiste_award) {
        this.artiste_award = artiste_award;
    }

    public int recupererIdParNom(){
        String ma_requete_id = "SELECT artist_id FROM artist WHERE artist_name = \""+this.artiste_nickname+"\"";
        int id = bdd.C_requetes.rechercheId(ma_requete_id);
        return id;
    }

    public String recupererNomParId(C_CARACTERISTIQUES objet, String champ, int id){
        String ma_requete_nom = "SELECT artist_name FROM artist WHERE artist_id = \""+this.human_id+"\"";
        String nom = bdd.C_requetes.rechercheNom(ma_requete_nom);
        return nom;
    }
    
}