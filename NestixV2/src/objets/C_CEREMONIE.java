package objets;

import java.util.*;

public class C_CEREMONIE extends C_CARACTERISTIQUES{
    int ceremonie_id;
    String ceremonie_nom;

    @Override
    public String toString() {
        return "C_CEREMONIE{" + "ceremonie_id=" + ceremonie_id + ", ceremonie_nom=" + ceremonie_nom + '}';
    }

    public int getCeremonie_id() {
        return ceremonie_id;
    }

    public void setCeremonie_id(int ceremonie_id) {
        this.ceremonie_id = ceremonie_id;
    }

    public String getCeremonie_nom() {
        return ceremonie_nom;
    }

    public void setCeremonie_nom(String ceremonie_nom) {
        this.ceremonie_nom = ceremonie_nom;
    }

    
}