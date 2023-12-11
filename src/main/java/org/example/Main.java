package org.example;

import Classes.Entrepot;
import UseEntrepot.UseEntrepot;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");

        Entrepot entrepot1 = new Entrepot();

        entrepot1.ajouterProduitsEnLot();

        UseEntrepot.afficherContenuEntrepot(entrepot1);
    }

}