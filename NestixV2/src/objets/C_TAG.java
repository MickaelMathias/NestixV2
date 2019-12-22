package objets;

import java.util.*;

public class C_TAG extends C_CARACTERISTIQUES{

    public C_TAG(){}
    public C_TAG(int id){
        this.id = id;
    }
    @Override
    public String toString() {
        return "C_TAG{" + "tag_id=" + id + ", tag_nom=" + nom + '}';
    }
    
}