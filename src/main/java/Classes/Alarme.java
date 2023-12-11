package Classes;

public class Alarme {

    private String id;

    public Alarme(String id) {
        this.id = id;
    }
    
    // Traite l’alerte en l’affichant
    public void PrintAlerte() {
        System.out.println("Il faut faire une commande de re-stock pour le produits : " + id);
    }
    
}
