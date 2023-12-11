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

    public List<Categorie> getListeCategories() {
        return categories;
    }

    public Categorie VerifCat(Categorie categorieExistante, char nomCategorie){
        for (Categorie categorie : getListeCategories()) {
            if (categorie.getIdCat() == nomCategorie) {
                categorieExistante = categorie;
                break;
            }
        }
        if (categorieExistante == null) {
            categorieExistante = new Categorie(nomCategorie);
            ajouterCategorie(categorieExistante);
        }
        return categorieExistante;
    }

    public Volume VerifVol(Volume volumeExistant, Categorie categorieExistante, int nomVolume){
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

        return volumeExistant;
    }

    public void ajouterProduit(Entrepot entrepot, char nomCategorie, int nomVolume, String nomProduitA2) {
        Categorie categorieExistante = null;

        VerifCat(categorieExistante, nomCategorie);

        Volume volumeExistant = null;
        VerifVol(volumeExistant, categorieExistante, nomVolume);


        Produit produitA2 = new Produit(nomProduitA2);
        volumeExistant.ajouterProduit(produitA2);

        System.out.println("Produit A2 ajouté avec succès au volume " + nomVolume + " de la catégorie " + nomCategorie);
    }

}
