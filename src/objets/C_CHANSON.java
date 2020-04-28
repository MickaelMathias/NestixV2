package objets;

import java.sql.SQLException;
import java.util.*;

import bdd.C_requetes;

public class C_CHANSON extends C_MEDIA {

    String chanson_album;

    ArrayList <C_ARTISTE> chanson_interpretes = new ArrayList<>(); 
    ArrayList <C_CARACTERISTIQUES> chanson_groupe = new ArrayList<>(); 
    ArrayList <C_CARACTERISTIQUES> chanson_genres = new ArrayList<>(); 
    ArrayList <C_CARACTERISTIQUES> chanson_tags = new ArrayList<>(); 
    ArrayList <C_CARACTERISTIQUES> chanson_ceremonies = new ArrayList<>();
    ArrayList <C_CARACTERISTIQUES> chanson_award = new ArrayList<>();
    ArrayList <String> chanson_annees_recompenses = new ArrayList<>();
    ArrayList <C_CARACTERISTIQUES> chanson_studio_production = new ArrayList<>();

    @Override
    public String toString() {
        return ""+super.toString()+" C_CHANSON{" + "album=" + chanson_album + ", chanson_interpretes=" + chanson_interpretes + ", chanson_groupe=" + chanson_groupe + ", chanson_genres=" + chanson_genres + ", chanson_tags=" + chanson_tags + ", chanson_ceremonies=" + chanson_ceremonies + ", chanson_award=" + chanson_award + ", chanson_annees_recompenses=" + chanson_annees_recompenses + ", chanson_studio_production=" + chanson_studio_production + '}';
    }

    public String getChansonAlbum() {
        return chanson_album;
    }

    public void setChansonAlbum(String album) {
        this.chanson_album = album;
    }

    public ArrayList<C_ARTISTE> getChanson_interpretes() {
        return chanson_interpretes;
    }

    public void setChanson_interpretes(ArrayList<C_ARTISTE> chanson_interpretes) {
        this.chanson_interpretes = chanson_interpretes;
    }

    public ArrayList<C_CARACTERISTIQUES> getChanson_groupe() {
        return chanson_groupe;
    }

    public void setChanson_groupe(ArrayList<C_CARACTERISTIQUES> chanson_groupe) {
        this.chanson_groupe = chanson_groupe;
    }

    public ArrayList<C_CARACTERISTIQUES> getChanson_genres() {
        return chanson_genres;
    }

    public void setChanson_genres(ArrayList<C_CARACTERISTIQUES> chanson_genres) {
        this.chanson_genres = chanson_genres;
    }

    public ArrayList<C_CARACTERISTIQUES> getChanson_tags() {
        return chanson_tags;
    }

    public void setChanson_tags(ArrayList<C_CARACTERISTIQUES> chanson_tags) {
        this.chanson_tags = chanson_tags;
    }

    public ArrayList<C_CARACTERISTIQUES> getChanson_ceremonies() {
        return chanson_ceremonies;
    }

    public void setChanson_ceremonies(ArrayList<C_CARACTERISTIQUES> chanson_ceremonies) {
        this.chanson_ceremonies = chanson_ceremonies;
    }

    public ArrayList<C_CARACTERISTIQUES> getChanson_award() {
        return chanson_award;
    }

    public void setChanson_award(ArrayList<C_CARACTERISTIQUES> chanson_award) {
        this.chanson_award = chanson_award;
    }

    public ArrayList<String> getChanson_annees_recompenses() {
        return chanson_annees_recompenses;
    }

    public void setChanson_annees_recompenses(ArrayList<String> chanson_annees_recompenses) {
        this.chanson_annees_recompenses = chanson_annees_recompenses;
    }

    public ArrayList<C_CARACTERISTIQUES> getChanson_studio_production() {
        return chanson_studio_production;
    }

    public void setChanson_studio_production(ArrayList<C_CARACTERISTIQUES> chanson_studio_production) {
        this.chanson_studio_production = chanson_studio_production;
    }
    
    
    public C_CHANSON creerChansonAvecId(int id){
        C_CHANSON ma_chanson_cree_avec_id = new C_CHANSON();
        ma_chanson_cree_avec_id.setMedia_id(id);
        String [][] mes_donnes_medias = bdd.C_requetes.rechercheMedia("SELECT * FROM media WHERE media_id = "+ma_chanson_cree_avec_id.media_id+"");
        ma_chanson_cree_avec_id.setMedia_titre(mes_donnes_medias[0][1]);
        ma_chanson_cree_avec_id.setMedia_type(mes_donnes_medias[0][2]);
        ma_chanson_cree_avec_id.setMedia_annee(mes_donnes_medias[0][3]);
        ma_chanson_cree_avec_id.setMedia_cover(mes_donnes_medias[0][4]);
        ma_chanson_cree_avec_id.setMedia_lien(mes_donnes_medias[0][5]);

        String [][] mes_donnes_chanson = bdd.C_requetes.rechercheChanson("SELECT * FROM song WHERE song_id = "+ma_chanson_cree_avec_id.media_id+"");
        if (mes_donnes_chanson.length > 0){
        ma_chanson_cree_avec_id.setChansonAlbum(mes_donnes_chanson[0][0]);}
        
        int [] mes_id_studio_production = bdd.C_requetes.rechercheIdsCaracteristique("pc","produced_by",ma_chanson_cree_avec_id.media_id);
        ma_chanson_cree_avec_id.setChanson_studio_production(creerTableauCaracteristiques(mes_id_studio_production, "pc"));

        int [] mes_id_groupe = bdd.C_requetes.rechercheIdsGroupe(ma_chanson_cree_avec_id.media_id);
        ma_chanson_cree_avec_id.setChanson_groupe(creerTableauCaracteristiques(mes_id_groupe, "band"));

        int [] mes_id_interpretes = bdd.C_requetes.rechercheIdsArtiste("SELECT human.human_id FROM human JOIN take_part_in ON human.human_id=take_part_in.human_id WHERE take_part_in.media_id="+ma_chanson_cree_avec_id.media_id+" AND take_part_in.work_id = 2");
        ma_chanson_cree_avec_id.setChanson_interpretes(creerTableauArtistes(mes_id_interpretes));
        int [] mes_id_tags = bdd.C_requetes.rechercheIdsCaracteristique("tag","is_associated_with",ma_chanson_cree_avec_id.media_id);
        ma_chanson_cree_avec_id.setChanson_tags(creerTableauCaracteristiques(mes_id_tags, "tag"));
        int [] mes_id_genres = bdd.C_requetes.rechercheIdsCaracteristique("genre","categorized_by",ma_chanson_cree_avec_id.media_id);
        ma_chanson_cree_avec_id.setChanson_genres(creerTableauCaracteristiques(mes_id_genres, "genre"));
        int [] mes_id_ceremonies = bdd.C_requetes.rechercheIdsCaracteristique("ceremony","competed_in",ma_chanson_cree_avec_id.media_id);
        ma_chanson_cree_avec_id.setChanson_ceremonies(creerTableauCaracteristiques(mes_id_ceremonies, "ceremony"));
        int [] mes_id_award = bdd.C_requetes.rechercheIdsCaracteristique("award","competed_in",ma_chanson_cree_avec_id.media_id);
        ma_chanson_cree_avec_id.setChanson_award(creerTableauCaracteristiques(mes_id_award, "award"));
        ma_chanson_cree_avec_id.setChanson_annees_recompenses(bdd.C_requetes.rechercheAnneesRecompenses("SELECT year FROM award join competed_in ON competed_in.award_id=award.award_id WHERE media_id IN ( SELECT competed_in.media_id from competed_in JOIN media ON media.media_id=competed_in.media_id WHERE media.media_id="+ma_chanson_cree_avec_id.media_id+")"));

        System.out.println("Ma chanson cree avec id : "+ma_chanson_cree_avec_id.toString());
        return ma_chanson_cree_avec_id;
    }

    public void creationChansonBdd(){
        bdd.C_connexion.ex_Update("INSERT INTO song (song_id, song_album) VALUES ("+this.media_id+","+VDE(this.chanson_album)+")");
    }
    public void creationGroupeChansonBDD(){
        if(this.getChanson_groupe().size() > 0)
        bdd.C_connexion.ex_Update("INSERT INTO song (song_id, band_id) VALUES ("+this.media_id+","+this.getChanson_groupe().get(0).getCaracteristiquesId()+")");
    }
    
}