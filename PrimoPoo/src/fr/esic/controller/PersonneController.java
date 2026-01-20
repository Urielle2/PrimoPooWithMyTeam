package fr.esic.controller;

import java.util.ArrayList;
import java.util.List;

import fr.esic.library.MyInOutPut;
import fr.esic.model.Person;




public class PersonneController {
	// Simuler une base de données avec une liste
	 // Une liste d'un objet persmet de stocker plusieurs objets de ce type
	 // Les données de la liste seront en mémoire tant que le programme tourne
	 // PS : les données seront perdues à la fermeture du programme
	 //// car elles ne sont pas persistées dans un fichier ou une base de données
	 // static pour que la liste soit accessible sans instancier la classe
	 public static List<Person> personnes = new ArrayList<>();
	 
	 //1- Créer une personne
	 public static void createPerson() {
		  String nom = MyInOutPut.saisirTexte("Entrez le nom de la personne : ");
		  String prenom = MyInOutPut.saisirTexte("Entrez le prénom : ");
		  String email = MyInOutPut.saisirTexte("Entrez l'adresse mail : ");
		  String password = MyInOutPut.saisirTexte("Entrez le mot de passe : ");

		  // Logique pour créer et sauvegarder la personne
		  Person person = new Person(nom, prenom, email, password);
		  personnes.add(person);
		 }
	 
	 //2-Afficher les personnes
	 public static void allPerson() {
		  String data = "";
		  if (personnes.isEmpty()) {
		   MyInOutPut.afficher("Liste vide.");
		  } else {
		   for (Person person : personnes) {
		    data += person.infoPerson() + "\n";
		   }
		   MyInOutPut.afficher(data);

		  }
		 }
		 
		 
	//3-Rechercher une personne
			 
			 
			// recherche personne par nom si nom saisie contient des élements du nom de la
			 // personne
			 public static List<Person> findByNameContains(String nom) {
			  List<Person> result = new ArrayList<>();
			  for (Person person : personnes) {
			   if (person.getNom().toLowerCase().contains(nom.toLowerCase())) {
			    result.add(person);
			   }
			  }
			  return result;
			 }

			 public static void searchByNameContains() {
			  List<Person> result = findByNameContains(
			    MyInOutPut.saisirTexte("Entrez le nom (ou partie du nom) de la personne à rechercher : "));
			  String data = "";
			  if (result.isEmpty()) {
			   MyInOutPut.afficher("Aucune correspondance.");
			  } else {
			   for (Person person : result) {
			    data += person.infoPerson() + "\n";
			   }
			   MyInOutPut.afficher(data);
			  }
			 }
			 
			 
	//4-Mettre à jour une personne
			// permet de choisir un produit à mettre à jour parmi une liste de produits
			 public static Person getPersonToUpdate(List<Person> result) {
			  if (result.isEmpty()) {
			   MyInOutPut.afficher("Aucune correspondanve avec ce nom.");
			   return null;
			   // Si un seul produit trouvé, le retourner directement
			  } else if (result.size() == 1) {
			   return result.get(0);
			   // Si plusieurs produits trouvés, afficher la liste et demander à l'utilisateur
			   // de choisir
			  } else {
			   String data = "Plusieurs personnes trouvés :\n";
			   // Cette boucle permet d'afficher les produits avec un numéro
			   // i+1 pour commencer à 1 au lieu de 0 car l'index d'une liste commence à 0 par
			   // défaut
			   for (int i = 0; i < result.size(); i++) {
			    data += (i + 1) + ". " + result.get(i).infoPerson() + "\n";
			   }
			   // Demander à l'utilisateur de choisir une personne (data contient la liste des
			   // personnes)
			   int choix = MyInOutPut.saisirEntier(data + "\n\nEntrez le numéro de la personne à mettre à jour : ");
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

			 public static void updatePerson() {
			  Person person = getPersonToUpdate(
			    findByNameContains(MyInOutPut.saisirTexte("Entrez le nom de la personne à mettre à jour : ")));

			  if (person != null) {
			   Person p = new Person();
			   p = person;
			   String oldInfo = person.infoPerson();
			   String newNom = MyInOutPut  
			     .saisirTexte("Entrez le nouveau nom (laisser vide pour ne pas changer) : ");
			  
			   if (!newNom.isEmpty()) {
			    person.setNom(newNom);
			   }
			   String newPrenom = MyInOutPut
			     .saisirTexte("Entrez le nouveau prénom (laisser vide pour ne pas changer) : ");
			   if (!newPrenom.isEmpty()) {
			    person.setPrenom(newPrenom);
			   }
			   String newEmail = MyInOutPut
			     .saisirTexte("Entrez le nouveau mail (laisser vide pour ne pas changer) : ");
			   if (!newEmail.isEmpty()) {
			   
			    person.setEmail(newEmail);
			   }
			   String newPassword = MyInOutPut  
					     .saisirTexte("Entrez le nouveau mot de passe (laisser vide pour ne pas changer) : ");
					  
					   if (!newPassword.isEmpty()) {
					    person.setPassword(newPassword);
					   }
			   MyInOutPut.afficher("Personne mise à jour avec succès. \n" + "Ancienne info produit : " + oldInfo
			     + "\n" + "New info produit : " + person.infoPerson());
			  } else {
			   MyInOutPut.afficher("Mise à jour annulée car aucun produit sélectionné.");
			  }
			 }
			 
			 
			 //5-  Supprimer une personne
			 public static void deletePersonParNom() {
				// 1. Recherche par nom
				    List<Person> result = findByNameContains(
				            MyInOutPut.saisirTexte("Entrez le nom de la personne à supprimer : ")
				    );

				    // 2. Sélection de la personne
				    Person person = getPersonToUpdate(result);

				    // 3. Si aucune personne sélectionnée
				    if (person == null) {
				        MyInOutPut.afficher("Suppression annulée.");
				        return;
				    }

				    // 4. Confirmation
				    int confirm = MyInOutPut.saisirEntier(
				            "Voulez-vous vraiment supprimer :\n" +
				            person.infoPerson() +
				            "\n\n1 = Oui\n2 = Non"
				    );

				    if (confirm == 1) {
				        personnes.remove(person);
				        MyInOutPut.afficher("Personne supprimée avec succès.");
				    } else {
				        MyInOutPut.afficher("Suppression annulée.");
				    }
				}

			 
					    
			 }

			
			 


