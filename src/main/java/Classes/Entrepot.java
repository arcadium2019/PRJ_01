package Classes;

import java.util.ArrayList;
import java.util.List;

public class Entrepot {

    private List<Categorie> categories;

    public Entrepot() {
        categories = new ArrayList<>();
    }

    // méthode permettant d’ajouter une Catégorie dans la liste
    public void ajouterCategorie(Categorie categorie) {
        categories.add(categorie);
    }

    // méthode permettant de supprimer une Catégorie vide (sans Volume)
    public void supprimerCategorie(Categorie categorie) {
        categories.remove(categorie);
    }

    //
    public void AjouterProduit(String chaineDeProduits){

        // Séparation de chaque produit

            // Ajout de chaque produits 1 par 1
    }

    public List<Categorie> getListeCategories() {
        return categories;
    }

}
