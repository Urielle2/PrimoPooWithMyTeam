package fr.esic.model;

public class Compte {

	private String numeroCompte;
	private Person titulaire;
	private double solde;

	public Compte() {

	}

	public Compte(String numeroCompte, Person titulaire, double solde) {
		this.numeroCompte = numeroCompte;
		this.titulaire = titulaire;
		this.solde = solde;

	}

	public String getNumeroCompte() {
		return numeroCompte;
	}

	public void setNumeroCompte(String numeroCompte) {
		this.numeroCompte = numeroCompte;
	}

	public Person getTitulaire() {
		return titulaire;
	}

	public void setTitulaire(Person titulaire) {
		this.titulaire = titulaire;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public String infoCompte() {
		return "Numéro de Compte " + numeroCompte + ", Titulaire " + titulaire.infoPerson() + ", solde " + solde + "€";
	}

	public boolean retrait(double montant) {
		if (montant <= this.solde) {
			// this.solde = this.solde - montant; => même chose que la ligne suivante
			this.solde -= montant;
			return true;
		} else {
			return false;
		}
	}

	public void depot(double montant) {
		this.solde += montant;
	}

}
