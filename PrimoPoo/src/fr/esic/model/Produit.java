package fr.esic.model;
 
public class Produit {
	private String nom;
	private String description;
	private double prix;
	private int stock;
	// pourcentage de reduction, entre 2 et 100
	private int promotion;
 
	public Produit() {
 
	}
 
	public Produit(String nom, String description, double prix, int stock) {
		this.nom = nom;
		this.description = description;
		this.prix = prix;
		this.stock = stock;
	}
	
	public Produit(String nom, String description, double prix, int stock, int promotion) {
		this.nom = nom;
		this.description = description;
		this.prix = prix;
		this.stock = stock;
		this.promotion = promotion;
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
 
	public double getPrix() {
		return prix;
	}
 
	public void setPrix(double prix) {
		this.prix = prix;
	}
 
	public int getStock() {
		return stock;
	}
 
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public int getPromotion() {
		return promotion;
	}
	
	public void setPromotion(int promotion) {
		this.promotion = promotion;
	}
 
	public String infoProduit() {
		if (promotion > 1) {
			return infoProduitWithPromotion();
		}else {
			return "Nom: " + nom + ", Description " + description + ", Prix: " + prix + "Stock:" + stock;
		}
	}
	
	// Affichage des informations du produit avec la promotion (prix normal et prix après réduction)
	public String infoProduitWithPromotion() {
		double prixAvecReduction = prix - (prix * promotion / 100);
		return "Nom: " + nom + ", Description: " + description + ", Prix normal: " + prix + ", Prix après réduction: "
				+ prixAvecReduction + ", Stock: " + stock + ", Promotion: " + promotion + "%";
	}
 
}
 
 