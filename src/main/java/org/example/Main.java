package org.example;

import Classes.Entrepot;
import UseEntrepot.UseEntrepot;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");

        Entrepot entrepot1 = new Entrepot();

        entrepot1.ajouterProduit('A', 2, "A2");
        entrepot1.ajouterProduit('A', 2, "A2");
        entrepot1.ajouterProduit('B', 3, "B3");
        entrepot1.ajouterProduit('C', 4, "C4");

        UseEntrepot.afficherContenuEntrepot(entrepot1);
    }

}