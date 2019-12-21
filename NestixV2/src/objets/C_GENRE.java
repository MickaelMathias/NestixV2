package objets;

import java.util.*;

public class C_GENRE extends C_CARACTERISTIQUES{
    int genre_id;
    String genre_nom;

    @Override
    public String toString() {
        return "C_GENRE{" + "genre_id=" + genre_id + ", genre_nom=" + genre_nom + '}';
    }

    public int getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(int genre_id) {
        this.genre_id = genre_id;
    }

    public String getGenre_nom() {
        return genre_nom;
    }

    public void setGenre_nom(String genre_nom) {
        this.genre_nom = genre_nom;
    }

    
}