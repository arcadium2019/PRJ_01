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

    // méthode permettant d’ajouter un produit en fin de liste
    public void ajouterProduit(Produit produit) {
        produits.add(produit);
    }

    // méthode permettant de sortir le premier élément de la liste pour l’envoyer dans une commande
    // (retourne le dernier élément de la liste)
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
