package Classes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Colis {

    private List<Produit> produits;

    public Colis() {
        produits = new ArrayList<>();
    }

    public void Empiler(int tailleVolume, Produit produit){

        produits.add(produit);
        //produits.sort(Comparator.comparingInt(produit -> Character.getNumericValue(produit.getNom().charAt(1))));

    }

    // méthode permettant de ranger du plus grand volume au plus petit tous les Produits dans le Colis
    public void Assambler(Entrepot entrepot){
        Scanner scanner = new Scanner(System.in);
        String chaineProduits = scanner.nextLine();

        String[] tableauProduits = chaineProduits.replaceAll("\\s", "").split(",");

        for(String nomProduit : tableauProduits){
            int tailleVolume = Character.getNumericValue(nomProduit.charAt(1));
            Produit produit = entrepot.recupererProduit(nomProduit);

            Empiler(tailleVolume, produit);
        }
    }

    public List<Produit> getContenuColis() {
        return produits;
    }
}
