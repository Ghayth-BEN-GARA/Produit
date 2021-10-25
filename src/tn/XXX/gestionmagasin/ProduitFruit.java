package tn.XXX.gestionmagasin;

public class ProduitFruit implements Critiere{
	private int identifiantProduit = 0;
	private String typeProduit = "Aucun";
	private String libelleProduit = "Aucun";
	private double quantiteProduit = 0.0;
	private String saisonProduit = "Aucun";
	
	private static int nbrProduitFruit = 0;

	public ProduitFruit() {
		super();
	}

	public ProduitFruit(int identifiantProduit, String typeProduit, String libelleProduit, double quantiteProduit,
			String saisonProduit) {
		this.identifiantProduit = identifiantProduit;
		this.typeProduit = typeProduit;
		this.libelleProduit = libelleProduit;
		this.quantiteProduit = quantiteProduit;
		this.saisonProduit = saisonProduit;
		nbrProduitFruit++;
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

	public static int getNombreProduitFruit() {
		return nbrProduitFruit;
	}

	@Override
	public boolean estFrais(String saisonProduit, String saisonPasser) {
		boolean frais = false;
		
		if(saisonProduit.equals(saisonPasser)) {
			frais = true;
		}
		
		else {
			frais = false;
		}
		
		return frais;
	}
}
