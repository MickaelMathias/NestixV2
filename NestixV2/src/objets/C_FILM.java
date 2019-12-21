package objets;

import java.util.*;

public class C_FILM extends C_MEDIA {

    String film_visa, film_duree, film_trailer, film_synop, film_budget, film_saga, annee_recompense;

    ArrayList <C_ARTISTE> film_acteurs = new ArrayList<>(); 
    ArrayList <C_ARTISTE> film_scenaristes = new ArrayList<>(); 
    ArrayList <C_ARTISTE> film_realisateurs = new ArrayList<>(); 
    ArrayList <C_GENRE> film_genres = new ArrayList<>(); 
    ArrayList <C_TAG> film_tags = new ArrayList<>(); 
    ArrayList <C_CEREMONIE> artiste_ceremonies = new ArrayList<>();
    ArrayList <C_AWARD> artiste_award = new ArrayList<>();
    C_PRODC film_studio_production;


    @Override
    public String toString() {
        return "C_FILM{" + "film_visa=" + film_visa + ", film_duree=" + film_duree + ", film_trailer=" + film_trailer + ", film_synop=" + film_synop + ", film_budget=" + film_budget + ", film_saga=" + film_saga + ", annee_recompense=" + annee_recompense + ", film_acteurs=" + film_acteurs + ", film_scenaristes=" + film_scenaristes + ", film_realisateurs=" + film_realisateurs + ", film_genres=" + film_genres + ", film_tags=" + film_tags + ", artiste_ceremonies=" + artiste_ceremonies + ", artiste_award=" + artiste_award + ", film_studio_production=" + film_studio_production + '}';
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

    public String getAnnee_recompense() {
        return annee_recompense;
    }

    public void setAnnee_recompense(String annee_recompense) {
        this.annee_recompense = annee_recompense;
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

    public C_PRODC getfilm_studio_production() {
        return film_studio_production;
    }

    public void setfilm_studio_production(C_PRODC film_studio_production) {
        this.film_studio_production = film_studio_production;
    }
}