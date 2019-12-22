package objets;

import java.util.*;

public class C_METIER extends C_CARACTERISTIQUES{


    public C_METIER(){}
    public C_METIER(int id){
        this.id = id;
    }

    @Override
    public String toString() {
        return "C_METIER{" + "metier_id=" + id + ", metier_nom=" + nom + '}';
    }

    
}