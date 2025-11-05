package testsfonctionnels;

import cartes.*;

public class TestMethodsEquals {
	
	

	public static void main(String args[]) {
		
		Carte carte1 = new Borne(25);
		Carte carte2 = new Borne(25);
		
		System.out.println("Deux cartes de 25km sont identiques ? " + carte1.equals(carte2));
		

		Carte carte3 = new Attaque(Type.FEU);
		Carte carte4 = new Attaque(Type.FEU);
		Carte carte5 = new Parade(Type.FEU);
		
		System.out.println("Deux cartes de feux rouge sont identiques ? " + carte3.equals(carte4));
		System.out.println("La carte feu rouge et la carte feu vert sont identiques ? " + carte3.equals(carte5));
	}
}
