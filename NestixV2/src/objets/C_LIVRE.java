package objets;

import java.sql.SQLException;
import java.util.*;

import bdd.C_requetes;

public class C_LIVRE extends C_MEDIA {

    String livre_isbn, livre_synop, livre_tome, livre_saga;

    ArrayList <C_ARTISTE> livre_ecrivains = new ArrayList<>(); 
    ArrayList <C_CARACTERISTIQUES> livre_studio_production = new ArrayList<>();
    ArrayList <C_CARACTERISTIQUES> livre_genres = new ArrayList<>(); 
    ArrayList <C_CARACTERISTIQUES> livre_tags = new ArrayList<>(); 
    ArrayList <C_CARACTERISTIQUES> livre_ceremonies = new ArrayList<>();
    ArrayList <C_CARACTERISTIQUES> livre_award = new ArrayList<>();
    ArrayList <String> livre_annees_recompenses = new ArrayList<>();

    @Override
    public String toString() {
        return ""+super.toString()+"C_LIVRE{" + "livre_isbn=" + livre_isbn + ", livre_synop=" + livre_synop + ", livre_tome=" + livre_tome + ", livre_saga=" + livre_saga + ", livre_ecrivains=" + livre_ecrivains + ", livre_studio_production=" + livre_studio_production + ", livre_genres=" + livre_genres + ", livre_tags=" + livre_tags + ", livre_ceremonies=" + livre_ceremonies + ", livre_award=" + livre_award + ", livre_annees_recompenses=" + livre_annees_recompenses + '}';
    }

    public String getLivre_isbn() {
        return livre_isbn;
    }

    public void setLivre_isbn(String livre_isbn) {
        this.livre_isbn = livre_isbn;
    }

    public String getLivre_synop() {
        return livre_synop;
    }

    public void setLivre_synop(String livre_synop) {
        this.livre_synop = livre_synop;
    }

    public String getLivre_tome() {
        return livre_tome;
    }

    public void setLivre_tome(String livre_tome) {
        this.livre_tome = livre_tome;
    }

    public String getLivre_saga() {
        return livre_saga;
    }

    public void setLivre_saga(String livre_saga) {
        this.livre_saga = livre_saga;
    }

    public ArrayList<C_ARTISTE> getLivre_ecrivains() {
        return livre_ecrivains;
    }

    public void setLivre_ecrivains(ArrayList<C_ARTISTE> livre_ecrivains) {
        this.livre_ecrivains = livre_ecrivains;
    }

    public ArrayList<C_CARACTERISTIQUES> getLivre_studio_production() {
        return livre_studio_production;
    }

    public void setLivre_studio_production(ArrayList<C_CARACTERISTIQUES> livre_studio_production) {
        this.livre_studio_production = livre_studio_production;
    }

    public ArrayList<C_CARACTERISTIQUES> getLivre_genres() {
        return livre_genres;
    }

    public void setLivre_genres(ArrayList<C_CARACTERISTIQUES> livre_genres) {
        this.livre_genres = livre_genres;
    }

    public ArrayList<C_CARACTERISTIQUES> getLivre_tags() {
        return livre_tags;
    }

    public void setLivre_tags(ArrayList<C_CARACTERISTIQUES> livre_tags) {
        this.livre_tags = livre_tags;
    }

    public ArrayList<C_CARACTERISTIQUES> getLivre_ceremonies() {
        return livre_ceremonies;
    }

    public void setLivre_ceremonies(ArrayList<C_CARACTERISTIQUES> livre_ceremonies) {
        this.livre_ceremonies = livre_ceremonies;
    }

    public ArrayList<C_CARACTERISTIQUES> getLivre_award() {
        return livre_award;
    }

    public void setLivre_award(ArrayList<C_CARACTERISTIQUES> livre_award) {
        this.livre_award = livre_award;
    }

    public ArrayList<String> getLivre_annees_recompenses() {
        return livre_annees_recompenses;
    }

    public void setLivre_annees_recompenses(ArrayList<String> livre_annees_recompenses) {
        this.livre_annees_recompenses = livre_annees_recompenses;
    }

    public C_LIVRE creerLivreAvecId(int id){

        C_LIVRE mon_livre_cree_avec_id = new C_LIVRE();
        mon_livre_cree_avec_id.setMedia_id(id);
        String [][] mes_donnes_medias = bdd.C_requetes.rechercheMedia("SELECT * FROM media WHERE media_id = "+mon_livre_cree_avec_id.media_id+"");

        mon_livre_cree_avec_id.setMedia_titre(mes_donnes_medias[0][1]);
        mon_livre_cree_avec_id.setMedia_type(mes_donnes_medias[0][2]);
        mon_livre_cree_avec_id.setMedia_annee(mes_donnes_medias[0][3]);
        mon_livre_cree_avec_id.setMedia_cover(mes_donnes_medias[0][4]);
        mon_livre_cree_avec_id.setMedia_lien(mes_donnes_medias[0][5]);

        String [][] mes_donnes_livre = bdd.C_requetes.rechercheLivre("SELECT * FROM book WHERE book_id = "+mon_livre_cree_avec_id.media_id+"");
        if (mes_donnes_livre.length > 0){
        mon_livre_cree_avec_id.setLivre_isbn(mes_donnes_livre[0][0]);
        mon_livre_cree_avec_id.setLivre_synop(mes_donnes_livre[0][1]);
        mon_livre_cree_avec_id.setLivre_tome(mes_donnes_livre[0][2]);
        mon_livre_cree_avec_id.setLivre_saga(mes_donnes_livre[0][3]);}


        int [] mes_id_studio_production = bdd.C_requetes.rechercheIdsCaracteristique("pc","produced_by",mon_livre_cree_avec_id.media_id);
        mon_livre_cree_avec_id.setLivre_studio_production(creerTableauCaracteristiques(mes_id_studio_production, "pc"));
        int [] mes_id_ecrivains = bdd.C_requetes.rechercheIdsArtiste("SELECT human.human_id FROM human JOIN take_part_in ON human.human_id=take_part_in.human_id WHERE take_part_in.media_id="+mon_livre_cree_avec_id.media_id+" AND take_part_in.work_id = 3");
        mon_livre_cree_avec_id.setLivre_ecrivains(creerTableauArtistes(mes_id_ecrivains));

        int [] mes_id_tags = bdd.C_requetes.rechercheIdsCaracteristique("tag","is_associated_with",mon_livre_cree_avec_id.media_id);
        mon_livre_cree_avec_id.setLivre_tags(creerTableauCaracteristiques(mes_id_tags, "tag"));
        int [] mes_id_genres = bdd.C_requetes.rechercheIdsCaracteristique("genre","categorized_by",mon_livre_cree_avec_id.media_id);
        mon_livre_cree_avec_id.setLivre_genres(creerTableauCaracteristiques(mes_id_genres, "genre"));
        int [] mes_id_ceremonies = bdd.C_requetes.rechercheIdsCaracteristique("ceremony","competed_in",mon_livre_cree_avec_id.media_id);
        mon_livre_cree_avec_id.setLivre_ceremonies(creerTableauCaracteristiques(mes_id_ceremonies, "ceremony"));
        int [] mes_id_award = bdd.C_requetes.rechercheIdsCaracteristique("award","competed_in",mon_livre_cree_avec_id.media_id);
        mon_livre_cree_avec_id.setLivre_award(creerTableauCaracteristiques(mes_id_award, "award"));
        mon_livre_cree_avec_id.setLivre_annees_recompenses(bdd.C_requetes.rechercheAnneesRecompenses("SELECT year FROM award join competed_in ON competed_in.award_id=award.award_id WHERE media_id IN ( SELECT competed_in.media_id from competed_in JOIN media ON media.media_id=competed_in.media_id WHERE media.media_id="+mon_livre_cree_avec_id.media_id+")"));

        System.out.println(mon_livre_cree_avec_id.toString());
        return mon_livre_cree_avec_id;

    }
    public void creationLivreBdd(){
        
        bdd.C_connexion.ex_Update("INSERT INTO book (book_id, ISBN, book_synop, book_tome, book_saga) VALUES ("
        +this.media_id+","+VDE(this.livre_isbn)+","+VDE(this.livre_synop)+","+VDE(this.livre_tome)+","+VDE(this.livre_saga)+")");
    }
}