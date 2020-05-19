package objets;

import java.util.*;

public class C_HUMAN{

    int human_id;
    String human_nom, human_prenom, human_sexe, human_dob, human_cover;

    public C_HUMAN(){
        this.human_cover = "NULL";
    }

    @Override
    public String toString() {
        return "C_HUMAN{" + "human_id=" + human_id + ", human_nom=" + human_nom + ", human_prenom=" + human_prenom + ", human_sexe=" + human_sexe + ", human_dob=" + human_dob + ", human_cover=" + human_cover + '}';
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

    public String getHuman_dob() {
        return human_dob;
    }
    public void setHuman_dob(String human_dob) {
        this.human_dob = human_dob;
    }

    public String getHuman_cover() {
        return human_cover;
    }
    public void setHuman_cover(String human_cover) {
        this.human_cover = human_cover;
    }    

    protected ArrayList <C_CARACTERISTIQUES> creerTableauCaracteristiques(int [] mes_id, String champ){
        ArrayList <C_CARACTERISTIQUES> mes_caracteristiques = new ArrayList<>();
        for (int i = 0; i < mes_id.length; i++){
            C_CARACTERISTIQUES ma_carac = new C_CARACTERISTIQUES(mes_id[i]);
            ma_carac.setCaracteristiquesNom(ma_carac.recupererNomParId(champ, ma_carac.getCaracteristiquesId()));
            mes_caracteristiques.add(ma_carac);
        }
        return mes_caracteristiques;
    }

    public String VDE(String value){
        // verificationDonneesEntrees
        if (!value.equals("NULL")){
            value="'"+value+"'";
        }
        else{
            value = "NULL";
        }
        return value;
    }
    public int creationHumanBdd(){
        int i = bdd.C_connexion.ex_Update("INSERT INTO human (human_lastname, human_firstname, human_sex, human_dob, human_pic) VALUES ("+VDE(this.human_nom)+","+VDE(this.human_prenom)+","+VDE(this.human_sexe)+","+VDE(this.human_dob)+", NULL)");
        this.human_id = bdd.C_requetes.rechercheId("SELECT human_id FROM human ORDER BY human_id DESC LIMIT 1");
        return i;
    }

    public int modificationHumanBdd(){
        int i = bdd.C_connexion.ex_Update("INSERT INTO human (human_id, human_lastname, human_firstname, human_sex, human_dob, human_pic) VALUES ("+this.human_id+","+VDE(this.human_nom)+","+VDE(this.human_prenom)+","+VDE(this.human_sexe)+","+VDE(this.human_dob)+", NULL)");
        return i;
    }


    public void creationRecompensesBdd(ArrayList<C_CARACTERISTIQUES> mes_ceremonies, ArrayList<C_CARACTERISTIQUES> mes_award, ArrayList<String> mes_annees){
        for (int i = 0; i < mes_ceremonies.size(); i++ ){
            bdd.C_connexion.ex_Update("INSERT INTO awarded (human_id, award_id, ceremony_id, year) VALUES ("+this.human_id+","+mes_award.get(i).getCaracteristiquesId()+","+mes_ceremonies.get(i).getCaracteristiquesId()+","+mes_annees.get(i)+")");
        }
    }

    public int suppressionHumanBdd(int mon_id){
        String relations[] = {"composed_by", "come_from", "appreciation", "awarded", "collection", "take_part_in", "users"};
        for (int i=0; i<relations.length; i++) {
            bdd.C_connexion.ex_Update("DELETE FROM `"+relations[i]+"` WHERE `"+relations[i]+"`.`human_id` ="+mon_id);
        }
        bdd.C_connexion.ex_Update("DELETE FROM `status_artist` WHERE `status_artist`.`artist_id` ="+mon_id);
        bdd.C_connexion.ex_Update("DELETE FROM `artist` WHERE `artist`.`human_id` ="+mon_id);
        int i = bdd.C_connexion.ex_Update("DELETE FROM `human` WHERE `human`.`human_id` ="+mon_id);
        return i;
    }

    public int blocageHumanBdd(int mon_id) {
    	String requete_blocage="UPDATE `status_artist` SET `asv_id` = '3', `asv_date_modif` = CURRENT_TIME() WHERE `status_artist`.`artist_id`="+mon_id;
        int i = bdd.C_connexion.ex_Update(requete_blocage);
        return i;
    }
}