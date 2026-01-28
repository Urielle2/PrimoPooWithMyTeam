package fr.esic.view;

import fr.esic.controller.CompteController;
import fr.esic.controller.PersonneController;
import fr.esic.controller.ProduitController;
import fr.esic.library.MyInOutPut;

public class Menu {

    // Menu principal
    public static void menuPrincipal() {
        String msg = "=== Menu Principal ===\n" + "1. Gérer les produits\n" + "2. Gérer les personnes\n"
                + "3. Gestion de la Banque\n\n" + "0. Quitter\n" + "Veuillez choisir une option";

        boolean quitter = false;

        while (!quitter) {
            int choix = MyInOutPut.saisirEntier(msg);

            switch (choix) {
                case 1:
                    // MenuProduit.menuProduit();
                    menuProduit();
                    break;
                case 2:
                    // MenuPersonne.menuPersonne();
                    menuPersonne();
                    break;

                case 3:
                    menuBanque();

                    break;
                case 0:
                    quitter = true;
                    MyInOutPut.afficher("Au revoir !");
                    break;
                default:
                    MyInOutPut.afficher("Option invalide. Veuillez réessayer.");
            }

        }

    }

    public static void menuProduit() {
        String msg = "=== Menu Produit ===\n" + "1. Ajouter un produit\n" + "2. Afficher les produits\n"
                + "3. Rechercher un produit\n" + "4. Mettre à jour un produit\n" + "5. Supprimer un produit\n\n"
                + "0. Retour au menu principal\n" + "100. Quitter le programme\n " + "Veuillez choisir une option";

        boolean retour = false;

        while (!retour) {
            int choix = MyInOutPut.saisirEntier(msg);

            switch (choix) {
                case 1:
                    ProduitController.createProduit();
                    break;
                case 2:
                    ProduitController.allProduit();
                    break;
                case 3:
                    // ProduitController.searchProduitByName();
                    ProduitController.searchByNameContains();
                    break;
                case 4:
                    ProduitController.updateProduct();
                    break;
                case 5:
                	ProduitController.removeProduct();
                    break;
                case 0:
                    retour = true;
                    break;
                case 100:
                    // System.exit est utilisé pour quitter le programme immédiatement, exit(0) veut
                    // dire que le programme se termine sans erreur
                    System.exit(0);
                    break;
                default:
                    MyInOutPut.afficher("Option invalide. Veuillez réessayer.");

            }
        }
    }

    // Menu Personne
    public static void menuPersonne() {
        String msg = "=== Menu Personne ===\n" + "1. Ajouter une personne\n" + "2. Afficher les personnes\n"
                + "3. Rechercher une personne\n" + "4. Mettre à jour une personne\n" + "5. Supprimer une personne\n\n"
                + "0. Retour au menu principal\n" + "100. Quitter le programme\n " + "Veuillez choisir une option";

        boolean retour = false;

        while (!retour) {
            int choix = MyInOutPut.saisirEntier(msg);

            switch (choix) {
                case 1:
                    PersonneController.createPerson();
                    break;
                case 2:
                    PersonneController.allPerson();
                    break;
                case 3:
                    // PersonController.searchPersonByName();
                    PersonneController.searchByNameContains();
                    break;
                case 4:
                    PersonneController.updatePerson();
                    break;
                case 5:
                    PersonneController.deletePersonParNom();
                    break;
                case 0:
                    retour = true;
                    break;
                case 100:
                    // System.exit est utilisé pour quitter le programme immédiatement, exit(0) veut
                    // dire que le programme se termine sans erreur
                    System.exit(0);
                    break;
                default:
                    MyInOutPut.afficher("Option invalide. Veuillez réessayer.");

            }
        }
    }

    // MenuCompte
    public static void menuBanque() {
        String msg = "=== Menu Banque ===\n" + "1. Création de compte\n" + "2. Afficher les comptes\n"
                + "3. Rechercher un compte\n" + "4. Dépôt\n" + "5. Retrait\n" + "6. Virement\n"
                + "0. Retour au menu principal\n" + "100. Quitter le programme\n " + "Veuillez choisir une option";

        boolean retour = false;

        while (!retour) {
            int choix = MyInOutPut.saisirEntier(msg);

            switch (choix) {
                case 1:

                    menuCreationCompte();
                    break;
                case 2:
                    CompteController.afficherCompte();
                    break;
                case 3:
                    CompteController.findByNumeroCompte();
                    break;
                case 4:
                	CompteController.depot();
  
                    break;
                case 5:
                	CompteController.retrait();

                case 6:
                    CompteController.operationVirement();

                    break;
                case 0:
                    retour = true;
                    break;
                case 100:
                    // System.exit est utilisé pour quitter le programme immédiatement, exit(0) veut
                    // dire que le programme se termine sans erreur
                    System.exit(0);
                    break;
                default:
                    MyInOutPut.afficher("Option invalide. Veuillez réessayer.");

            }
        }
    }

    public static void menuCreationCompte() {
        String msg = "1. Personne éxistante\n" + "2. Nouvelle Personne";
        int choix = MyInOutPut.saisirEntier(msg);

        switch (choix) {
            case 1:
                CompteController.createCompte();
                break;
            case 2:
                CompteController.createCompteNewUser();
                break;
        }
    }
}