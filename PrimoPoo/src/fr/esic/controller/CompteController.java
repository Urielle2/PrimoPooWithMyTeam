package fr.esic.controller;

import fr.esic.library.MyInOutPut;
import fr.esic.model.Compte;
import fr.esic.model.Person;
import java.util.ArrayList;
import java.util.List;

public class CompteController {

	public static List<Compte> comptes = new ArrayList<>();

	public static void createCompteIfUserExist() {
		Person person = PersonneController.getPersonToUpdate(PersonneController
				.findByNameContains(MyInOutPut.saisirTexte("Entrez le nom de la personne à mettre à jour : ")));
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
				MyInOutPut.afficher("La personne " + person.infoPerson() + " possède déjà un compte.");
			}
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
		Compte c = findByNumeroCompte();
		if (c == null) {
			MyInOutPut.afficher("Compte non trouvé.");

		} else {
			double montant = MyInOutPut.saisirDouble("Entrez la somme que vous allez deposer ");
			c.depot(montant);
			MyInOutPut.afficher("Dépôt effectué. Mantant avant dépôt: " + (c.getSolde() - montant)
					+ ", Montant actuel: " + c.getSolde());
		}
	}

	public static void retrait() {

		Compte c = findByNumeroCompte();

		if (c != null) {
			double montant = MyInOutPut.saisirDouble("Entrez la somme que vous allez retirer ");
			if (montant <= 0) {
				MyInOutPut.afficher("On ne peut pas retirer un montant négatif ou nul.");
			} else {
				if (c.retrait(montant)) {
					c.setSolde(c.getSolde() - montant);
					MyInOutPut.afficher("Retrait effectué. Montant actuel: " + c.getSolde());
				} else {
					MyInOutPut.afficher("Retrait impossible. Montant actuel: " + c.getSolde());
				}
			}
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
	
	// une methode qui renvoit des feux d'artifice en String
	public static String feuArtifice() {
		String feu = "";
		feu += "        *        \n";
		feu += "       ***       \n";
		feu += "      *******      \n";
		feu += "     *********     \n";
		feu += "    ***********    \n";
		feu += "   *************   \n";
		feu += "  ***************  \n";
		feu += " ***************** \n";
		feu += "*******************\n";
		feu += "        |        \n";
		feu += "        |        \n";
		feu += "       / \\       \n";
		return feu;
	}

	public static void operationVirement() {
		Compte compteExp = findByNumeroCompte("Entrez le numéro du compte expéditeur : ");
		Compte compteDes = findByNumeroCompte("Entrez le numéro du compte destinataire : ");
		Double montant = MyInOutPut.saisirDouble("Montant du virement:");
		String beforeData = "Before \n" + compteExp.infoCompte() + "\n" + compteDes.infoCompte() + "\n\n";
		if (virement(compteExp, compteDes, montant)) {
			String afterData = "After \n" + compteExp.infoCompte() + "\n" + compteDes.infoCompte() + "\n";
			

			MyInOutPut.afficher(beforeData + "********************* Success " + feuArtifice() +  "*********************\n" + afterData );
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

	public static Compte findByNumeroCompte(String msg) {
		String numerodeCompte = MyInOutPut.saisirTexte(msg);
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
