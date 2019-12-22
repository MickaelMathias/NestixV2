package objets;

public class C_PRODC extends C_CARACTERISTIQUES{

    public C_PRODC(){}
    public C_PRODC(int id){
        this.id = id;
    }
    
    public C_PRODC(String nom){
        this.nom = nom;
        this.id = recupererIdParNom("pc", this.nom);
    }

    @Override
    public String toString() {
        return "C_PRODC{" + "prodc_id=" + id + ", prodc_nom=" + nom + '}';
    }



    
}