package org.example;

import Classes.Entrepot;
import Classes.Colis;
import UseEntrepot.UseEntrepot;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");

        Entrepot entrepot1 = new Entrepot();

        entrepot1.ajouterProduitsEnLot();

        UseEntrepot.afficherContenuEntrepot(entrepot1);

        Colis monColis = new Colis();

        monColis.Assambler(entrepot1);

        System.out.println(monColis.toString());
    }

}