package objets;

import java.util.*;

public class C_PAYS extends C_CARACTERISTIQUES{

    public C_PAYS(){}
    public C_PAYS(int id){
        this.id = id;
    }

    @Override
    public String toString() {
        return "C_PAYS{" + "pays_id=" + id + ", pays_nom=" + nom + '}';
    }

}