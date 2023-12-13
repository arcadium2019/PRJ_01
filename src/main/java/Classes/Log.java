package Classes;

import java.util.logging.Logger;

public class Log {

    private static final Logger logger = Logger.getLogger( Colis.class.getPackage().getName() );

    private Alarme alarmes[];

    public Log() {
        alarmes = new Alarme[3];
    }

    // méthode permettant de traiter et de supprimer toutes les alarmes de la plus ancienne à la plus récente.
    public void GestionAlarme(){
        for (Alarme alarme : alarmes) {
            alarme.PrintAlerte();
        }
        alarmes = new Alarme[3];
    }

    // méthode permettant d’ajouter une alerte en fin de tableau
    public void AjoutAlarme(Alarme nouvelleAlarme) {
        logger.info("Attention, il y a moins de 3 produit '"+nouvelleAlarme.getId()+"' dans votre entrepot");

        for (int i = 0; i < 3; i++) {
            if (alarmes[i] == null) {
                alarmes[i] = nouvelleAlarme;
                return;
            }
        }
    
        GestionAlarme();
        alarmes[0] = nouvelleAlarme;
    }

    public Alarme[] getListeAlarmes() {
        return alarmes;
    }
}
