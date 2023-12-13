package Classes;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Logger;

public class Entrepot {

    private static final Logger logger = Logger.getLogger( Colis.class.getPackage().getName() );
    private List<Categorie> categories;
    private Log log;

    public Entrepot() {
        categories = new ArrayList<>();
        log = new Log();
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

    private String saisieNomPoduit(Scanner scanner){
        System.out.println("Entrez le nom du produit :");
        String nomProduit = scanner.nextLine();

        return nomProduit;
    }

    public void ajouterProduitsEnChaine(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mettez la liste des produits que vous souhaitez ajouter ?");
        String chaineProduits = scanner.nextLine();

        String[] tableauProduits = chaineProduits.replaceAll("\\s", "").split(",");
        
        for(String nomProduit : tableauProduits){
            if(nomProduit.length() >= 2){
                char nomCategorie = nomProduit.charAt(0);
                int nomVolume = Character.getNumericValue(nomProduit.charAt(1));

                // Appel de la méthode pour ajouter le produit avec les informations déduites
                ajouterProduit(nomCategorie, nomVolume, nomProduit);
            } else {
                logger.info("Le produit "+nomProduit+" est invalide, doit avoir au moins deux caractères pour déduire le nom de la catégorie et du volume.");
            }
        }

    }

    public void ajouterProduitsEnLot() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Combien de produits souhaitez-vous ajouter ?");
        int nombreProduits = scanner.nextInt();

        scanner.nextLine(); // Pour consommer le saut de ligne

        for (int i = 0; i < nombreProduits; i++) {
            String nomProduit = saisieNomPoduit(scanner);

            if (nomProduit.length() >= 2) {
                char nomCategorie = nomProduit.charAt(0);
                int nomVolume = Character.getNumericValue(nomProduit.charAt(1));

                // Appel de la méthode pour ajouter le produit avec les informations déduites
                ajouterProduit(nomCategorie, nomVolume, nomProduit);
            } else {
                logger.info("Le nom du produit doit avoir au moins deux caractères pour déduire le nom de la catégorie et du volume.");
            }
        }
    }

    public Produit recupererProduit(String nomProduit) {
        for (Categorie categorie : categories) {
            for (Volume volume : categorie.getListeVolumes()) {
                for (Produit produit : volume.getListeProduits()) {

                    if (produit.getNom().equals(nomProduit)) {
                        if(volume.getListeProduits().size() < 3){
                            log.AjoutAlarme(new Alarme(nomProduit));
                        }
                        volume.supprimerProduit(produit); // Supprime le produit du volume

                        // Vérifie si c'était le dernier produit dans le volume
                        if (volume.getListeProduits().isEmpty()) {
                            categorie.supprimerVolume(volume); // Supprime le volume de la catégorie

                            // Vérifie si c'était le dernier volume dans la catégorie
                            if (categorie.getListeVolumes().isEmpty()) {
                                categories.remove(categorie); // Supprime la catégorie de la liste d'entrepôt
                            }
                        }

                        return produit; // Retourne le produit trouvé
                    }
                }
            }
        }
        log.AjoutAlarme(new Alarme(nomProduit));
        return null; // Si le produit n'est pas trouvé, retourne null
    }

    public void afficherContenuEntrepot() {

        if (categories.isEmpty()) {
            logger.info("L'entrepôt est vide.");
            return;
        }

        System.out.println("Contenu de l'entrepôt :");
        for (Categorie categorie : categories) {
            logger.info("Catégorie : " + categorie.getIdCat());

            List<Volume> volumes = categorie.getListeVolumes();
            if (volumes.isEmpty()) {
                System.out.println("\tAucun volume dans cette catégorie");
            } else {
                for (Volume volume : volumes) {
                    logger.info("\tVolume : " + volume.getIdVol());
                    List<Produit> produits = volume.getListeProduits();
                    if (produits.isEmpty()) {
                        logger.info("\t\tAucun produit dans ce volume");
                    } else {
                        logger.info("\t\tProduits :");
                        for (Produit produit : produits) {
                            logger.info("\t\t\t- " + produit.getNom());
                        }
                    }
                }
            }
        }
    }

    public void remplirEntrepotAleatoirement(int nombreProduits) {
        SecureRandom random = new SecureRandom();
        char[] lettres = {'A', 'B', 'C', 'D', 'E', 'F'};

        for (int i = 0; i < nombreProduits; i++) {
            char nomLettre = lettres[random.nextInt(lettres.length)];
            int nomChiffre = random.nextInt(5) + 1;
            String nomProduit = String.valueOf(nomLettre) + nomChiffre;

            // Ajouter le produit dans l'entrepôt
            // Assumer que vous avez une méthode pour ajouter un produit à l'entrepôt
            this.ajouterProduit(nomLettre, nomChiffre, nomProduit); // Changer les valeurs si besoin selon la logique de votre application
        }
    }

}
