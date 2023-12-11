package UseEntrepot;

import Classes.Categorie;
import Classes.Entrepot;
import Classes.Produit;
import Classes.Volume;

import java.util.List;

public class UseEntrepot {
    // Méthode pour ajouter un produit A2 et créer les objets nécessaires s'ils n'existent pas
    public static void ajouterProduit(Entrepot entrepot, char nomCategorie, int nomVolume, String nomProduitA2) {
        Categorie categorieExistante = null;
        for (Categorie categorie : entrepot.getListeCategories()) {
            if (categorie.getIdCat() == nomCategorie) {
                categorieExistante = categorie;
                break;
            }
        }

        if (categorieExistante == null) {
            categorieExistante = new Categorie(nomCategorie);
            entrepot.ajouterCategorie(categorieExistante);
        }


        Volume volumeExistant = null;
        for (Volume volume : categorieExistante.getListeVolumes()) {
            if (volume.getIdVol() == nomVolume) {
                volumeExistant = volume;
                break;
            }
        }

        if (volumeExistant == null) {
            volumeExistant = new Volume(nomVolume);
            categorieExistante.ajouterVolume(volumeExistant);
        }

        Produit produitA2 = new Produit(nomProduitA2);
        volumeExistant.ajouterProduit(produitA2);

        System.out.println("Produit A2 ajouté avec succès au volume " + nomVolume + " de la catégorie " + nomCategorie);
    }

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
