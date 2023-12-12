package Classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Entrepot {

    private List<Categorie> categories;

    public Entrepot() {
        categories = new ArrayList<>();
    }

    // méthode permettant d’ajouter une Catégorie dans la liste
    private void ajouterCategorie(Categorie categorie) {
        categories.add(categories.size() ,categorie);
    }

    // méthode permettant de supprimer une Catégorie vide (sans Volume)
    public Categorie supprimerCategorie() {
        if (!categories.isEmpty()) {
            return categories.remove(0);
        } else {
            return null; // Si la liste est vide, retourne null
        }
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

        System.out.println("Produit ajouté avec succès au volume " + nomVolume + " de la catégorie " + nomCategorie);
    }

    public void ajouterProduitsEnLot() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Combien de produits souhaitez-vous ajouter ?");
        int nombreProduits = scanner.nextInt();

        scanner.nextLine(); // Pour consommer le saut de ligne

        for (int i = 0; i < nombreProduits; i++) {
            System.out.println("Entrez le nom du produit :");
            String nomProduit = scanner.nextLine();

            if (nomProduit.length() >= 2) {
                char nomCategorie = nomProduit.charAt(0);
                int nomVolume = Character.getNumericValue(nomProduit.charAt(1));

                // Appel de la méthode pour ajouter le produit avec les informations déduites
                ajouterProduit(nomCategorie, nomVolume, nomProduit);
            } else {
                System.out.println("Le nom du produit doit avoir au moins deux caractères pour déduire le nom de la catégorie et du volume.");
            }
        }
    }


}
