package fr.esic.controller;

import fr.esic.library.MyInOutPut;
import fr.esic.model.Compte;
import fr.esic.model.Person;
import java.util.ArrayList;
import java.util.List;

public class CompteController {

    public static List<Compte> comptes = new ArrayList<>();

    public static void createCompte() {
        Person person = PersonneController.getPersonToUpdate(
                PersonneController.findByNameContains(MyInOutPut.saisirTexte("Entrez le nom de la personne à mettre à jour : "))
        );
        if (person != null) {
            Boolean existe = false;
            for (Compte compte : comptes) {
                if (person.equals(compte.getTitulaire())) {
                    existe = true;
                }
            }
            if (!existe) {
                double solde = MyInOutPut.saisirDouble("Entrez votre solde: ");
                String numeroCompte = MyInOutPut.saisirTexte("Entrez votre numéro de Compte : ");
                Compte compte = new Compte(numeroCompte, person, solde);
                comptes.add(compte);
            } else {
                MyInOutPut.afficher("Compte déja existant pour cette personne");
            }
        } else {
            MyInOutPut.afficher("Personne trouvé.");
        }

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
        double montant = MyInOutPut.saisirDouble("Entrez la somme que vous allez deposer ");
        Compte c = findByNumeroCompte();
        c.depot(montant);
        MyInOutPut.afficher("Montant actuel" + c.getSolde());
    }

    public static void retrait() {
        double montant = MyInOutPut.saisirDouble("Entrez la somme que vous allez retirer ");
        Compte c = findByNumeroCompte();
        if (c.retrait(montant)) {
            c.setSolde(c.getSolde() - montant);
            MyInOutPut.afficher("Retrait effectué. Montant actuel: " + c.getSolde());
        } else {
            MyInOutPut.afficher("Retrait impossible. Montant actuel: " + c.getSolde());
        }
    }

    public static boolean virement(Compte compteExp, Compte compteDes, Double montant) {
        if (compteExp.retrait(montant)) {
            compteDes.depot(montant);
            return true;
        } else {
            return false;
        }

    }

    public static void operationVirement() {
        Compte compteExp = findByNumeroCompte();
        Compte compteDes = findByNumeroCompte();
        Double montant = MyInOutPut.saisirDouble("Montant du virement:");
        if (virement(compteExp, compteDes, montant)) {
            MyInOutPut.afficher("Succes");
        } else {
            MyInOutPut.afficher("Echec");
        }

    }

    public static Compte findByNumeroCompte() {
        String numerodeCompte = MyInOutPut.saisirTexte("Entrez votre numéro de Compte : ");
        Compte c = null;
        for (Compte compte : comptes) {
            if (compte.getNumeroCompte().equals(numerodeCompte)) {
                c = compte;
            }

        }
        return c;

    }

    /*
	 * methode non correct public static void retrait() { String numeroCompte =
	 * MyInOutPut.saisirTexte("Entrez votre numéro de Compte : "); double montant =
	 * MyInOutPut.saisirDouble("Entrez la somme à retirer" ); if(montant > 0) { if
	 * (montant < Compte.getSolde()) { MyInOutPut.afficher("Retrait effectué" );
	 * }else { MyInOutPut.afficher("Retrait impossible" ); } }else{
	 * MyInOutPut.afficher("Retrait impossible" ); }
	 *
	 *
	 * }
     */
}
