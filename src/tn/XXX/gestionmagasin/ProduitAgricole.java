package tn.XXX.gestionmagasin;

public class ProduitAgricole {
	private int identifiantProduit = 0;
	private String typeProduit = "Aucun";
	private String libelleProduit = "Aucun";
	private double quantiteProduit = 0.0;
	private String saisonProduit = "Aucun";
	
	public ProduitAgricole(int identifiantProduit, String typeProduit, String libelleProduit, double quantiteProduit,
			String saisonProduit) {
		this.identifiantProduit = identifiantProduit;
		this.typeProduit = typeProduit;
		this.libelleProduit = libelleProduit;
		this.quantiteProduit = quantiteProduit;
		this.saisonProduit = saisonProduit;
		
		if(typeProduit.equals("Fruit")) {
			new ProduitFruit(identifiantProduit, typeProduit, libelleProduit, quantiteProduit, saisonProduit);
		}
		
		else {
			new ProduitLegume(identifiantProduit, typeProduit, libelleProduit, quantiteProduit, saisonProduit);
		}
	}

	public int getIdentifiantProduit() {
		return identifiantProduit;
	}

	public void setIdentifiantProduit(int identifiantProduit) {
		this.identifiantProduit = identifiantProduit;
	}
	
	public String getTypeProduit() {
		return typeProduit;
	}

	public void setTypeProduit(String typeProduit) {
		this.typeProduit = typeProduit;
	}

	public String getLibelleProduit() {
		return libelleProduit;
	}

	public void setLibelleProduit(String libelleProduit) {
		this.libelleProduit = libelleProduit;
	}

	public double getQuantiteProduit() {
		return quantiteProduit;
	}

	public void setQuantiteProduit(double quantiteProduit) {
		this.quantiteProduit = quantiteProduit;
	}

	public String getSaisonProduit() {
		return saisonProduit;
	}

	public void setSaisonProduit(String saisonProduit) {
		this.saisonProduit = saisonProduit;
	}

	@Override
	public String toString() {
		return "\n" + "Identifiant de produit : " + identifiantProduit + ", Type de produit : " + typeProduit + "\n";
	}
}
