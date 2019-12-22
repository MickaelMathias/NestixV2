package objets;

import java.util.*;

public class C_GENRE extends C_CARACTERISTIQUES{

    public C_GENRE(){}
    public C_GENRE(int id){
        this.id = id;
    }
    @Override
    public String toString() {
        return "C_GENRE{" + "genre_id=" + id + ", genre_nom=" + nom + '}';
    }


    
}