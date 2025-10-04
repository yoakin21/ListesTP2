package cartes;

public class Configuration {
	
	int nbExemplaire;
	Carte carte;
	
	public Configuration(Carte carte, int nbExemplaire) {
		this.nbExemplaire = nbExemplaire;
		this.carte = carte;
	}

	public int getNbExemplaire() {
		return nbExemplaire;
	}

	public Carte getCarte() {
		return carte;
	}
	
	
}
