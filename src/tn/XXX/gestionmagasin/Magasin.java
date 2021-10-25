package tn.XXX.gestionmagasin;

import java.util.List;

public class Magasin {
	private int identifiantMagasin = 0;
	private String adresseMagasin = "Aucun";
	private int capaciteMagasin = 0;
	private List<ProduitAlimentaire> ensembleDesProduits = null;
	
	private static int nbrMagasinNonVide = 0;
	
	public Magasin() {
		super();
	}

	public Magasin(int identifiantMagasin, String adresseMagasin, int capaciteMagasin,
			List<ProduitAlimentaire> ensembleDesProduits) {
		this.identifiantMagasin = identifiantMagasin;
		this.adresseMagasin = adresseMagasin;
		this.capaciteMagasin = capaciteMagasin;
		this.ensembleDesProduits = ensembleDesProduits;
		nbrMagasinNonVide++;
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

	public List<ProduitAlimentaire> getEnsembleDesProduits() {
		return ensembleDesProduits;
	}

	public void setEnsembleDesProduits(List<ProduitAlimentaire> ensembleDesProduits) {
		this.ensembleDesProduits = ensembleDesProduits;
	}

	@Override
	public String toString() {
		return "\n" + "Identifiant de magasin : " + identifiantMagasin + ", Adresse de magasin : " + adresseMagasin
				+ ", Capacité de magasin : " + capaciteMagasin + ", Liste des produits : " + ensembleDesProduits + "\n";
	}
	
	public boolean comparerProduitMethode1(ProduitAlimentaire p) {
		boolean identique = false;
		
		for(ProduitAlimentaire listePr : ensembleDesProduits) {
			if(listePr.getIdentifiantProduit() == p.getIdentifiantProduit() && listePr.getLibelleProduit().equals(p.getLibelleProduit()) && listePr.getPrixProduit().equals(p.getPrixProduit())){
				identique = true;
				break;
			}
			
			else {
				identique = false;
			}
		}
		return identique;
	}
	
	public static boolean comparerProduitMethode2(ProduitAlimentaire p1 , ProduitAlimentaire p2) {
		boolean identique = false;
		
		if(p1.getIdentifiantProduit() == p2.getIdentifiantProduit() && p1.getLibelleProduit().equals(p2.getLibelleProduit()) && p1.getPrixProduit().equals(p2.getPrixProduit())){
			identique = true;
		}
		
		else {
			identique = false;
		}
		return identique;
	}
	
	public boolean chercherProduitDansMagasin(int identifiantProduit) {
		boolean trouve = false;
		
		for(ProduitAlimentaire listePr : ensembleDesProduits) {
			if(listePr.getIdentifiantProduit() == identifiantProduit) {
				trouve = true;
				break;
			}
			
			else {
				trouve = false;
			}
		}
		return trouve;
	}
	
	public void supprimerProduit(int identifiantProduit) {
		for(int i = 0; i < ensembleDesProduits.size(); i++) {
			if(ensembleDesProduits.get(i).getIdentifiantProduit() == identifiantProduit) {
				ensembleDesProduits.remove(i);
			}
		}
	}
	
	public static String comparerDeuxMagasins(Magasin m1, Magasin m2) {
		String resultat = "";
		
		if(m1.getCapaciteMagasin() > m2.getCapaciteMagasin()) {
			resultat = "La magasin qui posséde l'identifiant " + m1.getIdentifiantMagasin() + " a un grand nombre des produits.";
		}
		
		else if(m2.getCapaciteMagasin() > m1.getCapaciteMagasin()) {
			resultat = "La magasin qui posséde l'identifiant " + m2.getIdentifiantMagasin() + " a un grand nombre des produits.";
		}
		
		else if(m1.getCapaciteMagasin() == m2.getCapaciteMagasin()) {
			resultat = "Les deux magasins ayant le méme nombre des produits.";
		}
		return resultat;
	}
	
	public static int getNombreMagasinNonVideCreer() {
		return nbrMagasinNonVide;
	}
	
}
