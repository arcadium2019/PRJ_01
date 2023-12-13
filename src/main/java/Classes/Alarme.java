package Classes;

import java.util.logging.Logger;

public class Alarme {

    private static final Logger logger = Logger.getLogger( Colis.class.getPackage().getName() );
    private String id;

    public Alarme(String id) {
        this.id = id;
    }
    
    // Traite l’alerte en l’affichant
    public void PrintAlerte() {
        logger.info("Il faut faire une commande de re-stock pour le produits : " + id);
    }

    public String getId() {
        return id;
    }
    
}
