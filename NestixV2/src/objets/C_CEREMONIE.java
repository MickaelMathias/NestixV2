package objets;

import java.util.*;

public class C_CEREMONIE extends C_CARACTERISTIQUES{


    public C_CEREMONIE(){}
    public C_CEREMONIE(int id){
        this.id = id;
    }
    
    @Override
    public String toString() {
        return "C_CEREMONIE{" + "ceremonie_id=" + id + ", ceremonie_nom=" + nom + '}';
    }


    
}