package Entrepos;

import java.util.ArrayList;
import java.util.List;

public class Entrepot {

    private List<Categorie> categories;

    public Entrepot() {
        categories = new ArrayList<>();
    }

    public void ajouterCategorie(Categorie categorie) {
        categories.add(categorie);
    }

    public void supprimerCategorie(Categorie categorie) {
        categories.remove(categorie);
    }

    public List<Categorie> getListeCategories() {
        return categories;
    }

}
