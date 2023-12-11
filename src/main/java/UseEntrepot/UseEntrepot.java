package UseEntrepot;

import Classes.Categorie;
import Classes.Entrepot;
import Classes.Produit;
import Classes.Volume;

public class UseEntrepot {
    // Méthode pour ajouter un produit A2 et créer les objets nécessaires s'ils n'existent pas
    public static void ajouterA2SiAbsent(Entrepot entrepot, char nomCategorie, int nomVolume, String nomProduitA2) {
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
}
