package org.example;

import Classes.Entrepot;
import UseEntrepot.UseEntrepot;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");

        Entrepot entrepot1 = new Entrepot();

        UseEntrepot.ajouterProduit(entrepot1, 'A', 2, "A2");
    }

}