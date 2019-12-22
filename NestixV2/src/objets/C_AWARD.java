package objets;

import java.util.*;

public class C_AWARD extends C_CARACTERISTIQUES{

    public C_AWARD(){}
    public C_AWARD(int id){
        this.id = id;
    }

    @Override
    public String toString() {
        return "C_AWARD{" + "award_id=" + id + ", award_nom=" + nom + '}';
    }

    
}