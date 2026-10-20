package com.ism.view;

import java.util.Scanner;

public class View {
    private Scanner scanner;
    private static View instance = null;

    protected View(Scanner scanner) {
        this.scanner = scanner;
    }

    public static View getInstance(Scanner scanner){
        if (instance == null) {
            instance = new View(scanner);
        }
        return instance;
    }

    public String lireTexte(String message) {
        System.out.print(message);
        return scanner.hasNextLine() ? scanner.nextLine().trim() : null;
    }

    public Integer lireEntier(String message) {
        String saisie = lireTexte(message);
        if (saisie == null) return null;
        try {
            return Integer.parseInt(saisie);
        } catch (NumberFormatException e) {
            System.out.println("Veuillez saisir un nombre entier valide.");
            return null;
        }
    }

    public double lireDecimal(String message) {
        String saisie = lireTexte(message);
        return Double.parseDouble(saisie);
    }
}
