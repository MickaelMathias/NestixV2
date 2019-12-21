package objets;

import java.util.*;

public class C_HUMAN{

    int human_id;
    String human_nom, human_prenom, human_sexe, human_doc, human_cover;

    public C_HUMAN(){
        this.human_cover = "NULL";
    }

    @Override
    public String toString() {
        return "C_HUMAN{" + "human_id=" + human_id + ", human_nom=" + human_nom + ", human_prenom=" + human_prenom + ", human_sexe=" + human_sexe + ", human_doc=" + human_doc + ", human_cover=" + human_cover + '}';
    }

    public int getHuman_id() {
        return human_id;
    }
    public void setHuman_id(int human_id) {
        this.human_id = human_id;
    }

    public String getHuman_nom() {
        return human_nom;
    }
    public void setHuman_nom(String human_nom) {
        this.human_nom = human_nom;
    }

    public String getHuman_prenom() {
        return human_prenom;
    }
    public void setHuman_prenom(String human_prenom) {
        this.human_prenom = human_prenom;
    }

    public String getHuman_sexe() {
        return human_sexe;
    }
    public void setHuman_sexe(String human_sexe) {
        this.human_sexe = human_sexe;
    }

    public String getHuman_doc() {
        return human_doc;
    }
    public void setHuman_doc(String human_doc) {
        this.human_doc = human_doc;
    }

    public String getHuman_cover() {
        return human_cover;
    }
    public void setHuman_cover(String human_cover) {
        this.human_cover = human_cover;
    }    
}