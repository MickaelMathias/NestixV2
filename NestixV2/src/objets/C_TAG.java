package objets;

import java.util.*;

public class C_TAG extends C_CARACTERISTIQUES{
    int tag_id;
    String tag_nom;

    @Override
    public String toString() {
        return "C_TAG{" + "tag_id=" + tag_id + ", tag_nom=" + tag_nom + '}';
    }

    public int getTag_id() {
        return tag_id;
    }

    public void setTag_id(int tag_id) {
        this.tag_id = tag_id;
    }

    public String getTag_nom() {
        return tag_nom;
    }

    public void setTag_nom(String tag_nom) {
        this.tag_nom = tag_nom;
    }

    
}