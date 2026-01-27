package fr.esic.controller;

import fr.esic.library.MyInOutPut;
import fr.esic.model.Compte;
import fr.esic.model.Person;
import fr.esic.controller.PersonneController;
import java.util.ArrayList;
import java.util.List;


public class CompteController {

	

    public static List<Compte> comptes = new ArrayList<>();

    public static void createCompte() {
        Person person = PersonneController.getPersonToUpdate(
        		PersonneController.findByNameContains(MyInOutPut.saisirTexte("Entrez le nom de la personne à mettre à jour : ")));
        double solde = MyInOutPut.saisirDouble("Entrez votre solde: ");
        String numeroCompte = MyInOutPut.saisirTexte("Entrez votre numéro de Compte : ");
        Compte compte = new Compte(numeroCompte, person, solde);
        comptes.add(compte);

    }

    public static void createCompteNewUser() {
        String numeroCompte = MyInOutPut.saisirTexte("Entrez votre numéro de Compte : ");
        Person titulaire = PersonneController.createPersonne();
        double solde = MyInOutPut.saisirDouble("Entrez votre solde: ");

        Compte compte = new Compte(numeroCompte, titulaire, solde);
        comptes.add(compte);

    }

    public static void afficherCompte() {
        String data = "";
        if (comptes.isEmpty()) {
            MyInOutPut.afficher("Liste vide.");
        } else {
            for (Compte person : comptes) {
                data += person.infoCompte() + "\n";
            }
            MyInOutPut.afficher(data);

        }
    }
    
    public static void depot() {
    	String numeroCompte = MyInOutPut.saisirTexte("Entrez votre numéro de Compte : ");
    	double montant =  MyInOutPut.saisirDouble("Entrez la somme que vous allez deposer ");
    	
    }
    
    /*  methode non correct
    public static void retrait() {
    	String numeroCompte = MyInOutPut.saisirTexte("Entrez votre numéro de Compte : ");
    	double montant =  MyInOutPut.saisirDouble("Entrez la somme à retirer"  );
    	if(montant > 0) {
    		if (montant < Compte.getSolde()) {
    			MyInOutPut.afficher("Retrait effectué"  );
    		}else { 
    			MyInOutPut.afficher("Retrait impossible" );
    		}
    	}else{ 
    		MyInOutPut.afficher("Retrait impossible" );
    	}
    			
    	
    }
    */

}
