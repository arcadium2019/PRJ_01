package org.example;

import Classes.Entrepot;
import Classes.Colis;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");

        Entrepot entrepot1 = new Entrepot();

        entrepot1.remplirEntrepotAleatoirement(50);
        entrepot1.afficherContenuEntrepot();

        entrepot1.ajouterProduitsEnLot();
        entrepot1.afficherContenuEntrepot();

        Colis monColis = new Colis();

        monColis.Assambler(entrepot1);

        monColis.afficherContenuColis();
        
        entrepot1.afficherContenuEntrepot();
    }

}