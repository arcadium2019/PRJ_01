package Classes;

public class Produit {

    private String nom;

    public Produit(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "nom='" + nom + '\'' +
                '}';
    }
}
