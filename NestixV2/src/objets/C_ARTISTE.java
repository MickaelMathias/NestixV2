package objets;

import java.util.*;

public class C_ARTISTE extends C_HUMAN{
    String artiste_dod, artiste_nickname;

    ArrayList <C_CARACTERISTIQUES> artiste_groupes = new ArrayList<>();
    ArrayList <C_CARACTERISTIQUES> artiste_metiers = new ArrayList<>();
    ArrayList <C_CARACTERISTIQUES> artiste_ceremonies = new ArrayList<>();
    ArrayList <C_CARACTERISTIQUES> artiste_award = new ArrayList<>();
    ArrayList <C_CARACTERISTIQUES> artiste_pays = new ArrayList<>();
    ArrayList <String> artiste_annees_recompenses = new ArrayList<>();

    public C_ARTISTE(){}

    public C_ARTISTE(int id){
        this.human_id = id;
    }
    @Override
    public String toString() {
        return ""+super.toString()+" C_ARTISTE{" + "artiste_dod=" + artiste_dod + ", artiste_nickname=" + artiste_nickname + ", artiste_groupes=" + artiste_groupes + ", artiste_metiers=" + artiste_metiers + ", artiste_ceremonies=" + artiste_ceremonies + ", artiste_award=" + artiste_award +", artiste_pays="+artiste_pays+ '}';
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
/*
    public String getArtiste_asv() {
        return artiste_asv;
    }

    public void setArtiste_asv(String artiste_asv) {
        this.artiste_asv = artiste_asv;
    }*/

    public ArrayList<C_CARACTERISTIQUES> getArtiste_groupes() {
        return artiste_groupes;
    }

    public void setArtiste_groupes(ArrayList<C_CARACTERISTIQUES> artiste_groupes) {
        this.artiste_groupes = artiste_groupes;
    }

    public ArrayList<C_CARACTERISTIQUES> getArtiste_metiers() {
        return artiste_metiers;
    }

    public void setArtiste_metiers(ArrayList<C_CARACTERISTIQUES> artiste_metiers) {
        this.artiste_metiers = artiste_metiers;
    }

    public ArrayList<C_CARACTERISTIQUES> getArtiste_ceremonies() {
        return artiste_ceremonies;
    }

    public void setArtiste_ceremonies(ArrayList<C_CARACTERISTIQUES> artiste_ceremonies) {
        this.artiste_ceremonies = artiste_ceremonies;
    }

    public ArrayList<C_CARACTERISTIQUES> getArtiste_award() {
        return artiste_award;
    }

    public void setArtiste_award(ArrayList<C_CARACTERISTIQUES> artiste_award) {
        this.artiste_award = artiste_award;
    }

    public ArrayList<C_CARACTERISTIQUES> getArtiste_pays() {
        return artiste_pays;
    }

    public void setArtiste_pays(ArrayList<C_CARACTERISTIQUES> artiste_pays) {
        this.artiste_pays = artiste_pays;
    }

    public ArrayList<String> getArtiste_annee_recompense() {
        return artiste_annees_recompenses;
    }

    public void setArtiste_annee_recompense(ArrayList<String> artiste_annees_recompenses) {
        this.artiste_annees_recompenses = artiste_annees_recompenses;
    } 

    public int recupererIdParNom(){
        String ma_requete_id = "SELECT human_id FROM artist WHERE artist_nickname = \""+this.artiste_nickname+"\"";
        int id = bdd.C_requetes.rechercheId(ma_requete_id);
        return id;
    }

    public String recupererNomParId(){
        String ma_requete_nom = "SELECT artist_nickname FROM artist WHERE human_id = \""+this.human_id+"\"";
        String nom = bdd.C_requetes.rechercheNom(ma_requete_nom);
        return nom;
    }

    public C_ARTISTE creerArtisteAvecId(int id){
        C_ARTISTE mon_artiste_cree_avec_id = new C_ARTISTE();
        mon_artiste_cree_avec_id.setHuman_id(id);
        String [][] mes_donnes_medias = bdd.C_requetes.rechercheHuman("SELECT * FROM human WHERE human_id = "+mon_artiste_cree_avec_id.human_id+"");
        mon_artiste_cree_avec_id.setHuman_nom(mes_donnes_medias[0][0]);
        mon_artiste_cree_avec_id.setHuman_prenom(mes_donnes_medias[0][1]);
        mon_artiste_cree_avec_id.setHuman_sexe(mes_donnes_medias[0][2]);
        mon_artiste_cree_avec_id.setHuman_dob(mes_donnes_medias[0][3]);

        String [][] mes_donnes_artiste = bdd.C_requetes.rechercheArtiste("SELECT * FROM artist WHERE human_id = "+mon_artiste_cree_avec_id.human_id+"");
        mon_artiste_cree_avec_id.setArtiste_dod(mes_donnes_artiste[0][0]);
        mon_artiste_cree_avec_id.setArtiste_nickname(mes_donnes_artiste[0][1]);

        int [] mes_id_groupe = bdd.C_requetes.rechercheIdsGroupeArtiste(mon_artiste_cree_avec_id.human_id);
        mon_artiste_cree_avec_id.setArtiste_groupes(creerTableauCaracteristiques(mes_id_groupe, "band"));
        
        int [] mes_id_pays = bdd.C_requetes.rechercheIdsCaracteristiqueArtiste("country","come_from",mon_artiste_cree_avec_id.human_id);
        mon_artiste_cree_avec_id.setArtiste_pays(creerTableauCaracteristiques(mes_id_pays, "country"));

        int [] mes_id_ceremonies = bdd.C_requetes.rechercheIdsCaracteristiqueArtiste("ceremony","awarded",mon_artiste_cree_avec_id.human_id);
        mon_artiste_cree_avec_id.setArtiste_ceremonies(creerTableauCaracteristiques(mes_id_ceremonies, "ceremony"));
        int [] mes_id_award = bdd.C_requetes.rechercheIdsCaracteristiqueArtiste("award","awarded",mon_artiste_cree_avec_id.human_id);
        mon_artiste_cree_avec_id.setArtiste_award(creerTableauCaracteristiques(mes_id_award, "award"));
        mon_artiste_cree_avec_id.setArtiste_annee_recompense(bdd.C_requetes.rechercheAnneesRecompenses("SELECT year FROM award join awarded ON awarded.award_id=award.award_id WHERE human_id IN ( SELECT awarded.human_id from awarded JOIN human ON human.human_id=awarded.human_id WHERE human.human_id="+mon_artiste_cree_avec_id.human_id+")"));

        System.out.println("Ma artiste cree avec id : "+mon_artiste_cree_avec_id.toString());
        return mon_artiste_cree_avec_id;
    }

    public void creationArtisteBdd(int statut){
        bdd.C_connexion.ex_Update("INSERT INTO artist (human_id, artist_dod, artist_nickname, asv_id) VALUES ("+this.human_id+","+VDE(this.artiste_dod)+","+VDE(this.artiste_nickname)+","+statut+")");
    }

    public void creationGroupeArtisteBDD(){
        if(this.getArtiste_groupes().size() > 0)
        for (int i = 0; i < this.getArtiste_groupes().size(); i++){
        bdd.C_connexion.ex_Update("INSERT INTO composed_by (human_id, band_id) VALUES ("+this.human_id+","+this.getArtiste_groupes().get(i).getCaracteristiquesId()+")");}
    }
    
}