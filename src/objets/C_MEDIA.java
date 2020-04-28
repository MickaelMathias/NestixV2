package objets;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.*;

import javax.swing.JPanel;

public class C_MEDIA {

    int media_id;
    String media_titre, media_type, media_annee, media_cover, media_lien, media_asv;

    public C_MEDIA(){
        this.media_cover = "NULL";
    }

    @Override
    public String toString() {
        return "C_MEDIA{" + "media_id=" + media_id + ", media_titre=" + media_titre + ", media_type=" + media_type + ", media_annee=" + media_annee + ", media_cover=" + media_cover + ", media_lien=" + media_lien + ", media_asv=" + media_asv + '}';
    }

    public int getMedia_id() {
        return media_id;
    }
    public void setMedia_id(int media_id) {
        this.media_id = media_id;
    }

    public String getMedia_titre() {
        return media_titre;
    }
    public void setMedia_titre(String media_titre) {
        this.media_titre = media_titre;
    }

    public String getMedia_type() {
        return media_type;
    }
    public void setMedia_type(String media_type) {
        this.media_type = media_type;
    }

    public String getMedia_annee() {
        return media_annee;
    }
    public void setMedia_annee(String media_annee) {
        this.media_annee = media_annee;
    }

    public String getMedia_cover() {
        return media_cover;
    }
    public void setMedia_cover(String media_cover) {
        this.media_cover = media_cover;
    }

    public String getMedia_lien() {
        return media_lien;
    }
    public void setMedia_lien(String media_lien) {
        this.media_lien = media_lien;
    }

    public String getMedia_asv() {
        return media_asv;
    }
    public void setMedia_asv(String media_asv) {
        this.media_asv = media_asv;
    }

    public ArrayList <C_ARTISTE> creerTableauArtistes(int [] mes_id){
        ArrayList <C_ARTISTE> mes_artistes = new ArrayList<>();
        for (int i = 0; i < mes_id.length; i++){
            C_ARTISTE mon_artiste = new C_ARTISTE(mes_id[i]);
            mon_artiste.setArtiste_nickname(mon_artiste.recupererNomParId());
            mes_artistes.add(mon_artiste);
        }
        return mes_artistes;
    }

    public ArrayList <C_CARACTERISTIQUES> creerTableauCaracteristiques(int [] mes_id, String champ){
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
    public int verifExistenceMedia() {
    	int count;
    	count=bdd.C_requetes.rechercheId("SELECT media_id FROM media WHERE media_year="+this.media_annee+" AND media_title='"+this.media_titre+"'");
    	return count;
    }
    public int creationMediaBdd(int statut){
        int i = bdd.C_connexion.ex_Update("INSERT INTO media (media_title, media_type, media_year, media_cover, media_link) "
        		+ "VALUES ("+VDE(this.media_titre)+","+VDE(this.media_type)+","+VDE(this.media_annee)+", NULL,"+VDE(this.media_lien)+")");
        this.media_id = bdd.C_requetes.rechercheId("SELECT media_id FROM media ORDER BY media_id DESC LIMIT 1");
        bdd.C_connexion.ex_Update("INSERT INTO status (media_id, asv_id, asv_date_creat, asv_date_modif) VALUES ("+this.media_id+","+statut+",CURRENT_DATE(),CURRENT_DATE())");	
        
        return i;
    }

    public void modificationMediaBdd(int statut){
        bdd.C_connexion.ex_Update("INSERT INTO media (media_id, media_title, media_type, media_year, media_cover, media_link) VALUES ("+this.media_id+","+VDE(this.media_titre)+","+VDE(this.media_type)+","+VDE(this.media_annee)+", NULL,"+VDE(this.media_lien)+")");
        bdd.C_connexion.ex_Update("INSERT INTO status (media_id, asv_id, asv_date_creat, asv_date_modif) VALUES ("+this.media_id+","+statut+",CURRENT_DATE(),CURRENT_DATE())");
    }

    public void creationArtisteBdd(int metier, ArrayList <C_ARTISTE> mes_artistes){
        for (int i=0; i < mes_artistes.size(); i++){
            bdd.C_connexion.ex_Update("INSERT INTO take_part_in (media_id, work_id, human_id) VALUES ("+this.media_id+","+metier+","+ mes_artistes.get(i).getHuman_id()+")");
        }
    }

    public void creationCaracteristiquesBdd(ArrayList<C_CARACTERISTIQUES> mes_caracteristiques, String champ, String table){
        for (int i = 0; i < mes_caracteristiques.size(); i++ ){
            bdd.C_connexion.ex_Update("INSERT INTO "+table+" (media_id, "+champ+"_id) VALUES ("+this.media_id+","+mes_caracteristiques.get(i).getCaracteristiquesId()+")");
        }
    }
    public void creationRecompensesBdd(ArrayList<C_CARACTERISTIQUES> mes_ceremonies, ArrayList<C_CARACTERISTIQUES> mes_award, ArrayList<String> mes_annees){
        for (int i = 0; i < mes_ceremonies.size(); i++ ){
            bdd.C_connexion.ex_Update("INSERT INTO competed_in (media_id, award_id, ceremony_id, year) VALUES ("+this.media_id+","+mes_award.get(i).getCaracteristiquesId()+","+mes_ceremonies.get(i).getCaracteristiquesId()+","+mes_annees.get(i)+")");
        }
    }

    public int suppressionMediaBdd(int mon_id){
        String relations[] = {"produced_by", "competed_in", "is_associated_with", "categorized_by", "status", "appreciation", "contains", "take_part_in", "associated_with"};
        for (int i=0; i<relations.length; i++) {
            bdd.C_connexion.ex_Update("DELETE FROM `"+relations[i]+"` WHERE `"+relations[i]+"`.`media_id` ="+mon_id);
        }
        String types_de_media[] = {"movie", "book", "song"};
        for (int i=0; i<types_de_media.length; i++) {
            bdd.C_connexion.ex_Update("DELETE FROM `"+types_de_media[i]+"` WHERE `"+types_de_media[i]+"`.`"+types_de_media[i]+"_id` ="+mon_id);
        }
        int i = bdd.C_connexion.ex_Update("DELETE FROM `media` WHERE `media`.`media_id` ="+mon_id);
    
        return i;
    }

    public void blocageMediaBdd(int mon_id) {
    	String requete_blocage="UPDATE `status` SET `asv_id` = '3', `asv_date_modif` = CURRENT_TIME() WHERE `status`.`media_id`="+mon_id;
    	bdd.C_connexion.ex_Update(requete_blocage);
    }
}