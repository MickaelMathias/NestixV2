package objets;

import java.util.*;

public class C_METIER extends C_CARACTERISTIQUES{
    int metier_id;
    String metier_nom;

    @Override
    public String toString() {
        return "C_METIER{" + "metier_id=" + metier_id + ", metier_nom=" + metier_nom + '}';
    }

    public int getMetier_id() {
        return metier_id;
    }

    public void setMetier_id(int metier_id) {
        this.metier_id = metier_id;
    }

    public String getMetier_nom() {
        return metier_nom;
    }

    public void setMetier_nom(String metier_nom) {
        this.metier_nom = metier_nom;
    }
    
}