package objets;

import java.util.*;

public class C_GROUPE extends C_CARACTERISTIQUES{
    int groupe_id;
    String groupe_nom;

    @Override
    public String toString() {
        return "C_GROUPE{" + "groupe_id=" + groupe_id + ", groupe_nom=" + groupe_nom + '}';
    }

    public int getGroupe_id() {
        return groupe_id;
    }

    public void setGroupe_id(int groupe_id) {
        this.groupe_id = groupe_id;
    }

    public String getGroupe_nom() {
        return groupe_nom;
    }

    public void setGroupe_nom(String groupe_nom) {
        this.groupe_nom = groupe_nom;
    }
    
}