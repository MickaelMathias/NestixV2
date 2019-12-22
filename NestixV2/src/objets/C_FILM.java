package objets;

import java.sql.SQLException;
import java.util.*;

import bdd.C_requetes;

public class C_FILM extends C_MEDIA {

    String film_visa, film_duree, film_trailer, film_synop, film_budget, film_saga;

    ArrayList <C_ARTISTE> film_acteurs = new ArrayList<>(); 
    ArrayList <C_ARTISTE> film_scenaristes = new ArrayList<>(); 
    ArrayList <C_ARTISTE> film_realisateurs = new ArrayList<>(); 
    ArrayList <C_GENRE> film_genres = new ArrayList<>(); 
    ArrayList <C_TAG> film_tags = new ArrayList<>(); 
    ArrayList <C_CEREMONIE> film_ceremonies = new ArrayList<>();
    ArrayList <C_AWARD> film_award = new ArrayList<>();
    ArrayList <String> film_annees_recompenses = new ArrayList<>();
    C_PRODC film_studio_production;


    @Override
    public String toString() {
        return "C_FILM{"+ super.toString() + "film_visa=" + film_visa + ", film_duree=" + film_duree + ", film_trailer=" + film_trailer + ", film_synop=" + film_synop + ", film_budget=" + film_budget + ", film_saga=" + film_saga + ", film_annee_recompense=" + film_annees_recompenses + ", film_acteurs=" + film_acteurs + ", film_scenaristes=" + film_scenaristes + ", film_realisateurs=" + film_realisateurs + ", film_genres=" + film_genres + ", film_tags=" + film_tags + ", film_ceremonies=" + film_ceremonies + ", film_award=" + film_award + ", film_studio_production=" + film_studio_production + '}';
    }

    public String getFilm_visa() {
        return film_visa;
    }

    public void setFilm_visa(String film_visa) {
        this.film_visa = film_visa;
    }

    public String getFilm_duree() {
        return film_duree;
    }

    public void setFilm_duree(String film_duree) {
        this.film_duree = film_duree;
    }

    public String getFilm_trailer() {
        return film_trailer;
    }

    public void setFilm_trailer(String film_trailer) {
        this.film_trailer = film_trailer;
    }

    public String getFilm_synop() {
        return film_synop;
    }

    public void setFilm_synop(String film_synop) {
        this.film_synop = film_synop;
    }

    public String getFilm_budget() {
        return film_budget;
    }

    public void setFilm_budget(String film_budget) {
        this.film_budget = film_budget;
    }

    public String getFilm_saga() {
        return film_saga;
    }

    public void setFilm_saga(String film_saga) {
        this.film_saga = film_saga;
    }

    public ArrayList<String> getFilm_annee_recompense() {
        return film_annees_recompenses;
    }

    public void setFilm_annee_recompense(ArrayList<String> film_annees_recompenses) {
        this.film_annees_recompenses = film_annees_recompenses;
    }

    public ArrayList<C_ARTISTE> getFilm_acteurs() {
        return film_acteurs;
    }

    public void setFilm_acteurs(ArrayList<C_ARTISTE> film_acteurs) {
        this.film_acteurs = film_acteurs;
    }

    public ArrayList<C_ARTISTE> getFilm_scenaristes() {
        return film_scenaristes;
    }

    public void setFilm_scenaristes(ArrayList<C_ARTISTE> film_scenaristes) {
        this.film_scenaristes = film_scenaristes;
    }

    public ArrayList<C_ARTISTE> getFilm_realisateurs() {
        return film_realisateurs;
    }

    public void setFilm_realisateurs(ArrayList<C_ARTISTE> film_realisateurs) {
        this.film_realisateurs = film_realisateurs;
    }

    public ArrayList<C_GENRE> getFilm_genres() {
        return film_genres;
    }

    public void setFilm_genres(ArrayList<C_GENRE> film_genres) {
        this.film_genres = film_genres;
    }

    public ArrayList<C_TAG> getFilm_tags() {
        return film_tags;
    }

    public void setFilm_tags(ArrayList<C_TAG> film_tags) {
        this.film_tags = film_tags;
    }

    public ArrayList<C_CEREMONIE> getFilm_ceremonies() {
        return film_ceremonies;
    }

    public void setFilm_ceremonies(ArrayList<C_CEREMONIE> film_ceremonies) {
        this.film_ceremonies = film_ceremonies;
    }

    public ArrayList<C_AWARD> getFilm_award() {
        return film_award;
    }

    public void setFilm_award(ArrayList<C_AWARD> film_award) {
        this.film_award = film_award;
    }

    public C_PRODC getfilm_studio_production() {
        return film_studio_production;
    }

    public void setfilm_studio_production(C_PRODC film_studio_production) {
        this.film_studio_production = film_studio_production;
    }

    public C_FILM creerFilmAvecId(int id){
        C_FILM mon_film_cree_avec_id = new C_FILM();
        mon_film_cree_avec_id.setMedia_id(id);
        String [][] mes_donnes_medias = bdd.C_requetes.rechercheMedia("SELECT * FROM media WHERE media_id = "+mon_film_cree_avec_id.media_id+"");

        mon_film_cree_avec_id.setMedia_titre(mes_donnes_medias[0][0]);
        mon_film_cree_avec_id.setMedia_type(mes_donnes_medias[0][1]);
        mon_film_cree_avec_id.setMedia_annee(mes_donnes_medias[0][2]);
        mon_film_cree_avec_id.setMedia_cover(mes_donnes_medias[0][3]);
        mon_film_cree_avec_id.setMedia_lien(mes_donnes_medias[0][4]);

        String [][] mes_donnes_film = bdd.C_requetes.rechercheFilm("SELECT * FROM movie WHERE movie_id = "+mon_film_cree_avec_id.media_id+"");
 
        mon_film_cree_avec_id.setFilm_visa(mes_donnes_film[0][0]);
        mon_film_cree_avec_id.setFilm_duree(mes_donnes_film[0][1]);
        mon_film_cree_avec_id.setFilm_trailer(mes_donnes_film[0][2]);
        mon_film_cree_avec_id.setFilm_synop(mes_donnes_film[0][3]);
        mon_film_cree_avec_id.setFilm_budget(mes_donnes_film[0][4]);
        mon_film_cree_avec_id.setFilm_saga(mes_donnes_film[0][5]);

        System.out.println(mon_film_cree_avec_id.toString());
        return mon_film_cree_avec_id;

    }
}