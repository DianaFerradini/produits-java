package com.ism;

import java.util.Scanner;

import com.ism.factory.DatabaseFactory;
import com.ism.repository.ProduitRepository;
import com.ism.repository.ProduitRepositoryImpl;
import com.ism.service.ProduitService;
import com.ism.service.ProduitServiceImpl;
import com.ism.view.ProduitView;
import com.ism.view.View;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ProduitRepository repository = new ProduitRepositoryImpl(DatabaseFactory.createDatabase());
        ProduitService service = new ProduitServiceImpl(repository);
        ProduitView view = ProduitView.getInstanceProduit(scanner, service);
        boolean continuer = true;
        System.out.println("Bienvenue dans la gestion de produits !");
        while (continuer) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Ajouter un produit");
            System.out.println("2. Afficher les produits");
            System.out.println("3. Rechercher un produit par identifiant");
            System.out.println("4. Modifier la quantité d'un produit");
            System.out.println("5. Supprimer un produit");
            System.out.println("6. Calculer un prix avec remise");
            System.out.println("0. Quitter");
            String choix = View.getInstance(scanner).lireTexte("Votre choix : ");
            if (choix == null) break;
            switch (choix) {
                case "1": view.ajouterProduit(); break;
                case "2": view.afficherProduits(); break;
                // case "3": rechercherProduit(); break;
                // case "4": modifierQuantite(); break;
                // case "5": supprimerProduit(); break;
                // case "6": calculerRemise(); break;
                case "0": continuer = false; break;
                default: System.out.println("Choix invalide.");
            }
        }
        scanner.close();
        System.out.println("Au revoir ! Les données en mémoire ne sont pas conservées.");
    }
}