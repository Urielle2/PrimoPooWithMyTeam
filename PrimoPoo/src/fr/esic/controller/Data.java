package fr.esic.controller;

import fr.esic.model.Compte;
import fr.esic.model.Person;
import fr.esic.model.Produit;


public class Data {
	public static void init() {
		Produit pdt1 = new Produit("Ordinateur Portable", "PC portable haute performance", 1200.00, 10);
		Produit pdt2 = new Produit("Smartphone", "Téléphone intélligent ", 800.00, 12);
		Produit pdt3 = new Produit("Casque audio", "Casque sans fil avec réduction de bruit", 150.00, 14);
		Produit pdt4 = new Produit("Tablette", "Tablette légère pour la navigation et le multimédia", 400.00, 23);
		Produit pdt5 = new Produit("Tablette IOS", "Tablette portable haute performance", 600.00, 10);
		Produit pdt6 = new Produit("Tablette Android", "Tablette légère pour la navigation et le multimédia", 300.00, 25);
		Produit pdt7 = new Produit("Ordinateur de Bureau", "PC de bureau puissant pour le gaming", 1500.00, 18);
		
		Produit pdt8 = new Produit("Smartwatch", "Montre connectée avec suivi de la santé", 250.00, 30, 15);
		Produit pdt9 = new Produit("Enceinte Bluetooth", "Enceinte portable avec son de haute qualité", 100.00, 40, 10);	
		
		Person per1 = new Person("Tchikambou Anastase", "Steve Mouniaka", "Steve@gmail.com", "azerty");
		Person per2 = new Person("Mbathie", "Ousmane ", "ous@gmail.com", "qwerty");
		Person per3 = new Person("Doe", "John", "jo@gmail.com", "1234");
		
		
		ProduitController.produits.add(pdt1);
		ProduitController.produits.add(pdt2);
		ProduitController.produits.add(pdt3);
		ProduitController.produits.add(pdt4);
		ProduitController.produits.add(pdt5);
		ProduitController.produits.add(pdt6);
		ProduitController.produits.add(pdt7);
		ProduitController.produits.add(pdt8);
		ProduitController.produits.add(pdt9);
		
		
		
		PersonneController.personnes.add(per1);
		PersonneController.personnes.add(per2);
		PersonneController.personnes.add(per3);

		Compte C1 = new Compte("1", per1, 5000.00);
		Compte C2 = new Compte("2", per2, 3000.00);
		Compte C3 = new Compte("3", per3, 7000.00);

		CompteController.comptes.add(C1);
		CompteController.comptes.add(C2);
		CompteController.comptes.add(C3);

	}
}
