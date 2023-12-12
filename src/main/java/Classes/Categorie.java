package Classes;

import java.util.ArrayList;
import java.util.List;

public class Categorie {

    private List<Volume> volumes;
    private char idCat;

    public Categorie(char idCat) {
        volumes = new ArrayList<>();
        this.idCat = idCat;
    }

    // méthode permettant d’ajouter un Volume dans la liste
    public void ajouterVolume(Volume volume) {
        volumes.add(volumes.size() ,volume);
    }

    // méthode permettant de supprimer un Volume vide (sans Produit)
    public Volume supprimerPremierProduit() {
        if (!volumes.isEmpty()) {
            return volumes.remove(0);
        } else {
            return null; // Si la liste est vide, retourne null
        }
    }

    public List<Volume> getListeVolumes() {
        return volumes;
    }


    public char getIdCat() {
        return idCat;
    }
}
