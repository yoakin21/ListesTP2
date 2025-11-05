package jeu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cartes.Carte;
import cartes.JeuDeCartes;
import utils.GestionCartes;

public class Jeu {
	JeuDeCartes jeuDeCartes;
	
	public static void main(String[] args) {
		Carte[] cartes= (new JeuDeCartes()).donnerCartes();
		List<Carte> listeCartes = new ArrayList<>();
        Collections.addAll(listeCartes, cartes);
        listeCartes = GestionCartes.melanger(listeCartes);
		
        cartes = listeCartes.toArray(new Carte[listeCartes.size()]);
		Sabot sabot = new Sabot(cartes);
		sabot.estVide();
	}
}
