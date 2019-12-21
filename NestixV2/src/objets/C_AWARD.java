package objets;

import java.util.*;

public class C_AWARD extends C_CARACTERISTIQUES{
    int award_id;
    String award_nom;

    @Override
    public String toString() {
        return "C_AWARD{" + "award_id=" + award_id + ", award_nom=" + award_nom + '}';
    }

    public int getAward_id() {
        return award_id;
    }

    public void setAward_id(int award_id) {
        this.award_id = award_id;
    }

    public String getAward_nom() {
        return award_nom;
    }

    public void setAward_nom(String award_nom) {
        this.award_nom = award_nom;
    }

    
}