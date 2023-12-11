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
        volumes.add(volume);
    }

    // méthode permettant de supprimer un Volume vide (sans Produit)
    public void supprimerVolume(Volume volume) {
        volumes.remove(volume);
    }

    public List<Volume> getListeVolumes() {
        return volumes;
    }


    public char getIdCat() {
        return idCat;
    }
}
