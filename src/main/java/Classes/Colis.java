package Classes;

import java.util.ArrayList;
import java.util.List;

public class Colis {

    private List<Produit> produits;

    public Colis() {
        produits = new ArrayList<>();
    }

    public List<Produit> getContenuColis() {
        return produits;
    }
}
