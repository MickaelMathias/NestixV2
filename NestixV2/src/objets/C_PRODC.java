package objets;

public class C_PRODC extends C_CARACTERISTIQUES{
    int prodc_id;
    String prodc_nom;

    public C_PRODC(){}
    
    
    public C_PRODC(String nom){
        this.prodc_nom = nom;
        this.prodc_id = recupererIdParNom("pc", this.prodc_nom);
    }

    @Override
    public String toString() {
        return "C_PRODC{" + "prodc_id=" + prodc_id + ", prodc_nom=" + prodc_nom + '}';
    }

    public int getProdc_id() {
        return prodc_id;
    }

    public void setProdc_id(int prodc_id) {
        this.prodc_id = prodc_id;
    }

    public String getProdc_nom() {
        return prodc_nom;
    }

    public void setProdc_nom(String prodc_nom) {
        this.prodc_nom = prodc_nom;
    }

    
}