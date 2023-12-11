package Classes;

import java.util.ArrayList;
import java.util.List;

public class Volume {

    private List<Produit> produits;
    private int idVol;

    public Volume(int idVol) {
        produits = new ArrayList<>();
        this.idVol = idVol;
    }

    public void ajouterProduit(Produit produit) {
        produits.add(produit);
    }

    public void supprimerProduit(Produit produit) {
        produits.remove(produit);
    }

    public List<Produit> getListeProduits() {
        return produits;
    }

    public int getIdVol() {
        return idVol;
    }
}
