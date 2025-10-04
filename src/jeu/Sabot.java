package jeu;
import cartes.Carte;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Sabot implements Iterable<Carte>{
	private int nbCartes;
	private Carte[] cartes;
	int NbOperation = 0;
	
	
	public Sabot(Carte[] cartes) {
		this.nbCartes = cartes.length;
		this.cartes = cartes;
	}
	
	public boolean estVide() {
		return nbCartes==0;
	}
	
	public void ajouterCarte(Carte carte) {
		if (cartes.length<=nbCartes) {
			throw new IllegalStateException();
		} else {
			cartes[nbCartes] = carte;
			nbCartes++;
			NbOperation++;
		}
	}
	
	@Override
	public Iterator<Carte> iterator() {
		return new SabotIterateur();
	}

	public Carte piocher() {
		if (estVide()) {
			throw new NoSuchElementException();
		}
		
		Iterator<Carte> iter = iterator();
		Carte carte = iter.next();
		iter.remove();
		return carte;
	}
	
	private class SabotIterateur implements Iterator<Carte> {
		private int indiceIterateur = 0;
		private boolean nextEffectue = false;
		private int NbOperationReference = NbOperation;
		
		@Override
		public boolean hasNext() {
			return indiceIterateur < nbCartes;
		}
		
		@Override
		public Carte next() {
			verificationConcurrence();
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			Carte carte = cartes[indiceIterateur];
			indiceIterateur++;
			nextEffectue = true;
			NbOperationReference++;NbOperation++;
			return carte;
		}
		
		@Override
		public void remove() {
			verificationConcurrence();
			if (!nextEffectue) {
				throw new IllegalStateException();
			}
			
			for (int i = indiceIterateur - 1; i < nbCartes - 1; i++) {
				cartes[i] = cartes[i + 1];
			}
			nextEffectue = false;
			indiceIterateur--;
			nbCartes--;
			NbOperationReference++;NbOperation++;
		}
		
		private void verificationConcurrence() {
			if (NbOperation!=NbOperationReference) {
				throw new ConcurrentModificationException();
			}
		}
		
		
	}
}