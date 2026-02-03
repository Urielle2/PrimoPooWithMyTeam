package fr.esic.controller;

import java.util.ArrayList;
import java.util.List;

import fr.esic.library.MyInOutPut;
import fr.esic.model.Produit;

public class ProduitController {

 // Simuler une base de données avec une liste
 // Une liste d'un objet permet de stocker plusieurs objets de ce type
 // Les données de la liste seront en mémoire tant que le programme tourne
 // PS : les données seront perdues à la fermeture du programme
 //// car elles ne sont pas persistées dans un fichier ou une base de données
 // static pour que la liste soit accessible sans instancier la classe
 public static List<Produit> produits = new ArrayList<>();

 public static void createProduit() {
  String nom = MyInOutPut.saisirTexte("Entrez le nom du produit : ");
  String description = MyInOutPut.saisirTexte("Entrez la description du produit : ");
  double prix = MyInOutPut.saisirDouble("Entrez le prix du produit : ");
  int quantite = MyInOutPut.saisirEntier("Entrez la quantité du produit : ");

  // Logique pour créer et sauvegarder le produit
  Produit produit = new Produit(nom, description, prix, quantite);
  produits.add(produit);
 }

 public static void allProduit() {
  String data = "";
  if (produits.isEmpty()) {
   MyInOutPut.afficher("Aucun produit disponible.");
  } else {
   for (Produit produit : produits) {
    data += produit.infoProduit() + "\n";
   }
   MyInOutPut.afficher(data);

  }
 }

 public static List<Produit> findByName(String nom) {
  List<Produit> result = new ArrayList<>(); // nouvelle liste 
  for (Produit produit : produits) {
   if (produit.getNom().equalsIgnoreCase(nom)) {
    result.add(produit);
   }
  }
  return result;
 }

 public static void searchProduitByName() {
  List<Produit> result = findByName(MyInOutPut.saisirTexte("Entrez le nom du produit à rechercher : "));
  String data = "";
  if (result.isEmpty()) {
   MyInOutPut.afficher("Aucun produit trouvé avec ce nom.");
  } else {
   for (Produit produit : result) {
    data += produit.infoProduit() + "\n";
   }
   MyInOutPut.afficher(data);
  }
 }

 // recherche produit par nom si nom saisie contient des élements du nom du
 // produit
 public static List<Produit> findByNameContains(String nom) {
  List<Produit> result = new ArrayList<>();
  for (Produit produit : produits) {
   if (produit.getNom().toLowerCase().contains(nom.toLowerCase())) {
    result.add(produit);
   }
  }
  return result;
 }

 public static void searchByNameContains() {
  List<Produit> result = findByNameContains(
    MyInOutPut.saisirTexte("Entrez le nom (ou partie du nom) du produit à rechercher : "));
  String data = "";
  if (result.isEmpty()) {
   MyInOutPut.afficher("Aucun produit trouvé avec ce nom.");
  } else {
   for (Produit produit : result) {
    data += produit.infoProduit() + "\n";
   }
   MyInOutPut.afficher(data);
  }
 }

 // permet de choisir un produit à mettre à jour parmi une liste de produits
 public static Produit getProductToUpdate(List<Produit> result) {
  if (result.isEmpty()) {
   MyInOutPut.afficher("Aucun produit trouvé avec ce nom.");
   return null;
   // Si un seul produit trouvé, le retourner directement
  } else if (result.size() == 1) {
   return result.get(0);
   // Si plusieurs produits trouvés, afficher la liste et demander à l'utilisateur
   // de choisir
  } else {
   String data = "Plusieurs produits trouvés :\n";
   // Cette boucle permet d'afficher les produits avec un numéro
   // i+1 pour commencer à 1 au lieu de 0 car l'index d'une liste commence à 0 par
   // défaut
   for (int i = 0; i < result.size(); i++) {
    data += (i + 1) + ". " + result.get(i).infoProduit() + "\n";
   }
   // Demander à l'utilisateur de choisir un produit (data contient la liste des
   // produits)
   int choix = MyInOutPut.saisirEntier(data + "\n\nEntrez le numéro du produit à mettre à jour : ");
   // Vérifier que le choix est valide
   if (choix < 1 || choix > result.size()) {
    MyInOutPut.afficher("Choix invalide.");
    return null;
   } else {
    // Retourner le produit choisi (choix-1 pour correspondre à l'index de la liste)
    return result.get(choix - 1);
   }
  }
 }

 public static void updateProduct() {
  Produit produit = getProductToUpdate(
    findByNameContains(MyInOutPut.saisirTexte("Entrez le nom du produit à mettre à jour : ")));

  if (produit != null) {
   Produit p = new Produit();
   p = produit;
   String oldInfo = produit.infoProduit();
   String newNom = MyInOutPut  
     .saisirTexte("Entrez le nouveau nom du produit (laisser vide pour ne pas changer) : ");
  
   if (!newNom.isEmpty()) {
    produit.setNom(newNom);
   }
   String newDescription = MyInOutPut
     .saisirTexte("Entrez la nouvelle description du produit (laisser vide pour ne pas changer) : ");
   if (!newDescription.isEmpty()) {
    produit.setDescription(newDescription);
   }
   String prixInput = MyInOutPut
     .saisirTexte("Entrez le nouveau prix du produit (laisser vide pour ne pas changer) : ");
   if (!prixInput.isEmpty()) {
    double newPrix = Double.parseDouble(prixInput);
    produit.setPrix(newPrix);
    System.out.println(prixInput);
    System.out.println(newPrix);
   }
   String quantiteInput = MyInOutPut
     .saisirTexte("Entrez la nouvelle quantité du produit (laisser vide pour ne pas changer) : ");
   if (!quantiteInput.isEmpty()) {
    int newQuantite = Integer.parseInt(quantiteInput);
    produit.setStock(newQuantite);
   }
   MyInOutPut.afficher("Produit mis à jour avec succès. \n" + "Ancienne info produit : " + oldInfo
     + "\n" + "New info produit : " + produit.infoProduit());
  } else {
   MyInOutPut.afficher("Mise à jour annulée car aucun produit sélectionné.");
  }
 }
 
 public static void removeProduct() {

		Produit produit = getProductToUpdate(
				findByNameContains(MyInOutPut.saisirTexte("Entrez le nom du produit à supprimer : ")));

		if (produit != null) {

			String valider = MyInOutPut
					.saisirTexte("Saisissez OUI pour supprimer ce produit ou NON pour le conserver : ");
			if (valider.equalsIgnoreCase("oui")) {
				produits.remove(produit);
				MyInOutPut.afficher("Produit supprimé avec succès");
			} else if (valider.equalsIgnoreCase("non")) {
				MyInOutPut.afficher("Produit conservé dans le catalogue");
			} else {
				MyInOutPut.afficher("Commande invalide");
			}
		}

	}
 
 
 //Appliquer une promotion sur un produit entre 2 et 100. PS : pour la saisie entier utiliser la methode MyInOutPut.saisirEntier
	public static void applyPromotion() {
		Produit produit = getProductToUpdate(
				findByNameContains(MyInOutPut.saisirTexte("Entrez le nom du produit pour appliquer une promotion : ")));

		if (produit != null) {
			int promotion = MyInOutPut
					.saisirEntier("Entrez le pourcentage de promotion à appliquer (entre 2 et 100) : ");
			if (promotion >= 2 && promotion <= 100) {
				produit.setPromotion(promotion);
				MyInOutPut.afficher("Promotion de " + promotion + "% appliquée au produit : " + produit.getNom());
			} else {
				MyInOutPut.afficher("Pourcentage de promotion invalide. Veuillez entrer une valeur entre 2 et 100.");
			}
		} else {
			MyInOutPut.afficher("Aucun produit sélectionné pour appliquer une promotion.");
		}
	}
	

}
 