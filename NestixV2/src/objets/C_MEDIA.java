package objets;

import java.util.*;

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

    protected ArrayList <C_ARTISTE> creerTableauArtistes(int [] mes_id){
        ArrayList <C_ARTISTE> mes_artistes = new ArrayList<>();
        for (int i = 0; i < mes_id.length; i++){
            C_ARTISTE mon_artiste = new C_ARTISTE(mes_id[i]);
            mon_artiste.setArtiste_nickname(mon_artiste.recupererNomParId());
            mes_artistes.add(mon_artiste);
        }
        return mes_artistes;
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
        if (!value.equals("")){
            value="'"+value+"'";
        }
        return value;

    }
    public void creationMediaBdd(int statut){
        String requete_creation_media = "INSERT INTO media (media_title, media_type, media_year, media_cover, media_link) VALUES ("+VDE(this.media_titre)+","+VDE(this.media_type)+","+VDE(this.media_annee)+", NULL,"+VDE(this.media_lien)+")";
        bdd.C_connexion.ex_Update(requete_creation_media);

        String requete_recup_id = "SELECT media_id FROM media ORDER BY media_id DESC LIMIT 1";
        this.media_id = bdd.C_requetes.rechercheId(requete_recup_id);

        String requete_asv = "INSERT INTO status (media_id, asv_id, asv_date_creat, asv_date_modif) VALUES ("+this.media_id+","+statut+",CURRENT_DATE(),CURRENT_DATE())";
        bdd.C_connexion.ex_Update(requete_asv);
    }
  
}