package org.example;

import Classes.Entrepot;
import UseEntrepot.UseEntrepot;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");

        Entrepot entrepot1 = new Entrepot();

        Entrepot.ajouterProduit(entrepot1, 'A', 2, "A2");
        Entrepot.ajouterProduit(entrepot1, 'A', 2, "A2");
        Entrepot.ajouterProduit(entrepot1, 'B', 3, "B3");
        Entrepot.ajouterProduit(entrepot1, 'C', 4, "C4");

        UseEntrepot.afficherContenuEntrepot(entrepot1);
    }

}