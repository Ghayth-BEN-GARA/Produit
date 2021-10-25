package tn.XXX.gestionmagasin;

import java.util.List;

public class MagasinProduitAgricole {
	private int identifiantMagasin = 0;
	private String adresseMagasin = "Aucun";
	private int capaciteMagasin = 0;
	private List<ProduitAgricole> ensembleDesProduitsAgricole = null;
	
	private static int nbrMagasinProduitAgricoleNonVide = 0;

	public MagasinProduitAgricole(int identifiantMagasin, String adresseMagasin, int capaciteMagasin,
			List<ProduitAgricole> ensembleDesProduitsAgricole) {
		super();
		this.identifiantMagasin = identifiantMagasin;
		this.adresseMagasin = adresseMagasin;
		this.capaciteMagasin = capaciteMagasin;
		this.ensembleDesProduitsAgricole = ensembleDesProduitsAgricole;
		nbrMagasinProduitAgricoleNonVide++;
	}

	public int getIdentifiantMagasin() {
		return identifiantMagasin;
	}

	public void setIdentifiantMagasin(int identifiantMagasin) {
		this.identifiantMagasin = identifiantMagasin;
	}

	public String getAdresseMagasin() {
		return adresseMagasin;
	}

	public void setAdresseMagasin(String adresseMagasin) {
		this.adresseMagasin = adresseMagasin;
	}

	public int getCapaciteMagasin() {
		return capaciteMagasin;
	}

	public void setCapaciteMagasin(int capaciteMagasin) {
		this.capaciteMagasin = capaciteMagasin;
	}

	public List<ProduitAgricole> getEnsembleDesProduitsAgricole() {
		return ensembleDesProduitsAgricole;
	}

	public void setEnsembleDesProduitsAgricole(List<ProduitAgricole> ensembleDesProduitsAgricole) {
		this.ensembleDesProduitsAgricole = ensembleDesProduitsAgricole;
	}
	
	@Override
	public String toString() {
		return "\n" + "Identifiant de magasin : " + identifiantMagasin + ", Adresse de magasin : " + adresseMagasin
				+ ", Capacité de magasin : " + capaciteMagasin + ", Liste des magasin : "
				+ ensembleDesProduitsAgricole + "\n";
	}
	
	public float calculStock() {
		float quantiteStock = 0;
		for(ProduitAgricole listePrA : ensembleDesProduitsAgricole) {
			if(listePrA.getTypeProduit().equals("Fruit")) {
				quantiteStock = (float) (quantiteStock + listePrA.getQuantiteProduit());
			}
		}
		return quantiteStock;
	}

	public static int getNombreMagasin() {
		return nbrMagasinProduitAgricoleNonVide;
	}
}
