package fr.esic.model;

public class Produit {
	private String nom;
	private String description;
	private double prix;
	private int stock;

	public Produit() {

	}

	public Produit(String nom, String description, double prix, int stock) {
		this.nom = nom;
		this.description = description;
		this.prix = prix;
		this.stock = stock;

	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getprix() {
		return prix;
	}

	public void setEmail(double prix) {
		this.prix = prix;
	}

	public int getStock() {
		return stock;
	}

	public void setPassword(int stock) {
		this.stock = stock;
	}

	public String infoProduit() {
		return "Nom: " + nom + ", Description " + description + ", Prix: " + prix + "Stock:" + stock;
	}

	public void setPrix(double newPrix) {
		// TODO Auto-generated method stub

	}

	public void setQuantite(int newQuantite) {
		// TODO Auto-generated method stub

	}

}
