package fr.esic.controller;

import java.util.ArrayList;
import java.util.List;

import fr.esic.library.MyInOutPut;
import fr.esic.model.Person;
import fr.esic.model.Compte;

public class CompteController {
	
	public static List<Compte> comptes = new ArrayList<>();
	
	public static void createCompte() {
		  String numeroCompte = MyInOutPut.saisirTexte("Entrez votre numéro de compte : ");
		  Person titulaire = PersonneController.createPersonne();
		  double solde = MyInOutPut.saisirDouble("Entrez votre solde: ");
		  
		  Compte compte = new Compte(numeroCompte, titulaire, solde);
		  comptes.add(compte);

		  
	}


}
