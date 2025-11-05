package jeu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cartes.Carte;
import cartes.JeuDeCartes;
import utils.GestionCartes;

public class Jeu {
	JeuDeCartes jeuDeCartes = new JeuDeCartes();
	Sabot sabot;
	
	public static void main(String[] args) {
		Carte[] cartes= jeuDeCartes.donnerCartes();
		List<Carte> listeCartes = new ArrayList<>();
        Collections.addAll(listeCartes, cartes);
        listeCartes = GestionCartes.melanger(listeCartes);
		
        cartes = listeCartes.toArray(new Carte[listeCartes.size()]);
		sabot = new Sabot(cartes);
		sabot.estVide();
	}
}
/*
public class Jeu {
	JeuDeCartes jeuDeCartes = new JeuDeCartes();
	Sabot sabot;
	
	//TODO ajouter le jeu de cartes dans jeuDeCartes, puis mélanger et remplir le sabot
	//pas besoin de main
	
	public static void main(String[] args) {
		Carte[] cartes= jeuDeCartes.donnerCartes();
		List<Carte> listeCartes = new ArrayList<>();
        Collections.addAll(listeCartes, cartes);
        listeCartes = GestionCartes.melanger(listeCartes);
		
        cartes = listeCartes.toArray(new Carte[listeCartes.size()]);
		sabot = new Sabot(cartes);
		sabot.estVide();
	}
}
*/
