package objets;

import java.util.*;

public class C_GROUPE extends C_CARACTERISTIQUES{


    public C_GROUPE(){}
    public C_GROUPE(int id){
        this.id = id;
    }

    @Override
    public String toString() {
        return "C_GROUPE{" + "groupe_id=" + id + ", groupe_nom=" + nom + '}';
    }

    
}