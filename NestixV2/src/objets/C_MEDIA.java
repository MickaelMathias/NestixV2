package objets;

public class C_MEDIA{

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

    
}