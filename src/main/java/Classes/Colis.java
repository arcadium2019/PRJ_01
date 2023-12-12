package Classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Colis {

    private List<Produit> produits;

    public Colis() {
        produits = new ArrayList<>();
    }

    private void Empiler(int tailleVolume, Produit produit){

        Comparator<Produit> comparateur = Comparator.comparing(p -> Character.getNumericValue(p.getNom().charAt(1)));

        produits.add(produit);
        
        Collections.sort(produits, comparateur);

    }

    // méthode permettant de ranger du plus grand volume au plus petit tous les Produits dans le Colis
    public void Assambler(Entrepot entrepot){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nDonnez le contenu souhaité de votre Colis : ");
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

    public void afficherContenuColis() {
        System.out.println("Contenu du colis :");

        for (Produit produit : produits) {
            System.out.println(produit);
        }
    }
}
