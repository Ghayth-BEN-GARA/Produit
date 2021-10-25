package tn.XXX.gestionmagasin;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProduitAlimentaire {
	private int identifiantProduit = 0;
	private String libelleProduit = "Aucun";
	private String marqueProduit = "Aucun";
	private Double prixProduit = 0.0;
	private String dateExpirationProduit = null;
	
	private static int nbrProduitVide = 0;
	private static int nbrProduitNonVide = 0;
	private static int nbrProduitLait = 0;
	private static int nbrProduitCompleter = 0;
	private static int nbrDatesAffecterProduits = 0;
	
	public ProduitAlimentaire() {
		super();
		nbrProduitVide++;
	}

	public ProduitAlimentaire(int identifiantProduit, String libelleProduit, String marqueProduit, Double prixProduit,
			String dateExpirationProduit) {
		this.identifiantProduit = identifiantProduit;
		this.libelleProduit = libelleProduit;
		this.marqueProduit = marqueProduit;
		
		if(prixProduit >= 0) {
			this.prixProduit = prixProduit;
		}
		
		this.dateExpirationProduit = dateExpirationProduit;
		nbrProduitNonVide++;
	}
	
	
	public int getIdentifiantProduit() {
		return identifiantProduit;
	}

	public void setIdentifiantProduit(int identifiantProduit) {
		this.identifiantProduit = identifiantProduit;
	}

	public String getLibelleProduit() {
		return libelleProduit;
	}

	public void setLibelleProduit(String libelleProduit) {
		this.libelleProduit = libelleProduit;
	}

	public String getMarqueProduit() {
		return marqueProduit;
	}

	public void setMarqueProduit(String marqueProduit) {
		this.marqueProduit = marqueProduit;
	}

	public Double getPrixProduit() {
		return prixProduit;
	}

	public void setPrixProduit(Double prixProduit) {
		this.prixProduit = prixProduit;
	}

	public String getDateExpirationProduit() {
		return dateExpirationProduit;
	}

	public void setDateExpirationProduit(String dateExpirationProduit) {
		this.dateExpirationProduit = dateExpirationProduit;
	}

	public void afficher() {
		System.out.println("Identifiant de produit : " + identifiantProduit + ", Libellé de produit : " + libelleProduit + ", Marque de produit : " + marqueProduit + ", Prix de produit : " + prixProduit + ", Date d'expiration de produit : " + dateExpirationProduit + "\n");
	}
	
	public void attribuerPrixLait() {
		if(libelleProduit.equals("Lait")) {
			setPrixProduit(0.700);
			nbrProduitLait++;
		}
	}
	
	public void completerInformationManquante() {
		if((identifiantProduit != 0 ) && (prixProduit == 0.0)) {
			setPrixProduit(7520.0);
			nbrProduitCompleter++;
		}
	}
	
	@Override
	public String toString() {
		return "\n" + "Identifiant de produit : " + identifiantProduit + ", Libellé de produit : " + libelleProduit + ", Marque de produit : " + marqueProduit + ", Prix de produit : " + prixProduit + ", Date d'expiration de produit : " + dateExpirationProduit + "\n";
	}
	
	public void affecterDatesAuxProduits() {
		DateFormat df = new SimpleDateFormat("dd-MM-yy");
		Date dateobj = new Date();
		setDateExpirationProduit(df.format(dateobj));
		nbrDatesAffecterProduits++;
	}
	
	public static int getNombreProduitVide() {
		return nbrProduitVide;
	}
	
	public static int getNombreProduitNonVide() {
		return nbrProduitNonVide;
	}
	
	public static int getNombreProduitLait() {
		return nbrProduitLait;
	}
	
	public static void setNombreProduitLait(int nbr) {
		nbrProduitLait = nbr;
	}
	
	public static int getNombreProduitCompleter() {
		return nbrProduitCompleter;
	}
	
	public static int getNombreDatesAffecter() {
		return nbrDatesAffecterProduits;
	}
	
	public static void setNombreDatesAffecter(int nbr) {
		nbrDatesAffecterProduits = nbr;
	}
}
