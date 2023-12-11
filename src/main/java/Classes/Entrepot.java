package Classes;

import java.util.ArrayList;
import java.util.List;

public class Entrepot {

    private List<Categorie> categories;

    public Entrepot() {
        categories = new ArrayList<>();
    }

    // méthode permettant d’ajouter une Catégorie dans la liste
    private void ajouterCategorie(Categorie categorie) {
        categories.add(categorie);
    }

    // méthode permettant de supprimer une Catégorie vide (sans Volume)
    public void supprimerCategorie(Categorie categorie) {
        categories.remove(categorie);
    }

    public List<Categorie> getListeCategories() {
        return categories;
    }

    private Categorie VerifCat(Categorie categorieExistante, char nomCategorie){
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

    private Volume VerifVol(Volume volumeExistant, Categorie categorieExistante, int nomVolume){
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

    public void ajouterProduit(char nomCategorie, int nomVolume, String nomProduit) {
        Categorie categorieExistante = null;
        categorieExistante = VerifCat(categorieExistante, nomCategorie);

        Volume volumeExistant = null;
        volumeExistant = VerifVol(volumeExistant, categorieExistante, nomVolume);

        Produit produit = new Produit(nomProduit);
        volumeExistant.ajouterProduit(produit);

        System.out.println("Produit " +nomProduit.toString()+ " ajouté avec succès au volume " + nomVolume + " de la catégorie " + nomCategorie);
    }

}
