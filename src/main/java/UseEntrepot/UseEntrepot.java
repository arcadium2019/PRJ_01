package UseEntrepot;

import Classes.Categorie;
import Classes.Entrepot;
import Classes.Produit;
import Classes.Volume;

import java.util.List;

public class UseEntrepot {

    // Méthode pour afficher le contenu de l'entrepôt
    public static void afficherContenuEntrepot(Entrepot entrepot) {
        List<Categorie> categories = entrepot.getListeCategories();

        if (categories.isEmpty()) {
            System.out.println("L'entrepôt est vide.");
            return;
        }

        System.out.println("Contenu de l'entrepôt :");
        for (Categorie categorie : categories) {
            System.out.println("Catégorie : " + categorie.getIdCat());

            List<Volume> volumes = categorie.getListeVolumes();
            if (volumes.isEmpty()) {
                System.out.println("\tAucun volume dans cette catégorie");
            } else {
                for (Volume volume : volumes) {
                    System.out.println("\tVolume : " + volume.getIdVol());
                    List<Produit> produits = volume.getListeProduits();
                    if (produits.isEmpty()) {
                        System.out.println("\t\tAucun produit dans ce volume");
                    } else {
                        System.out.println("\t\tProduits :");
                        for (Produit produit : produits) {
                            System.out.println("\t\t\t- " + produit.getNom());
                        }
                    }
                }
            }
        }
    }

}
