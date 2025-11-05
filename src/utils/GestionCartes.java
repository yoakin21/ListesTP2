package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class GestionCartes {

	public static final Random random = new Random();

	public static <E> E extraire(List<E> liste) {
		int valeurRandom = random.nextInt(liste.size());
		return liste.remove(valeurRandom);
	}

	public static <E> E extraireAvecIterateur(List<E> liste) {
		if (liste.isEmpty())
			return null;
		int valeurRandom = random.nextInt(liste.size());
		ListIterator<E> listeItr = liste.listIterator();
		for (int i = 0; i < valeurRandom; i++) {
			listeItr.next();
		}

		E element = listeItr.next();
		listeItr.remove();
		return element;
	}

	public static <E> List<E> melanger(List<E> liste) {
		List<E> newListe = new ArrayList<>();
		while (!liste.isEmpty()) {
			newListe.add(extraireAvecIterateur(liste));
		}
		return newListe;
	}

	public static <E> boolean verifierMelange(List<E> liste1, List<E> liste2) {
		if (liste1.size() != liste2.size())
			return false;
		for (E element1 : liste1) {
			if (Collections.frequency(liste1, element1) != Collections.frequency(liste2, element1)) {
				return false;
			}
		}
		for (E element2 : liste2) {
			if (Collections.frequency(liste1, element2) != Collections.frequency(liste2, element2)) {
				return false;
			}
		}

		return true;
	}

	public static <E> List<E> rassembler(List<E> liste) {
		List<E> newListe = new ArrayList<>();
		for (ListIterator<E> it = liste.listIterator(); it.hasNext();) {
			E element = it.next();
			int indice = newListe.indexOf(element);
			if (indice == -1)
				newListe.add(newListe.size(), element);
			else
				newListe.add(indice, element);
			it.remove();
		}
		return newListe;
	}

	
	public static <E> boolean verifierRassemblement(List<E> liste) {
		  if (liste == null || liste.size() <= 1)
		   return true;

		  ListIterator<E> iter1 = liste.listIterator();
		  E precedent = iter1.next();

		  while (iter1.hasNext()) {
		   E courant = iter1.next();
		   if (!courant.equals(precedent)) {
		    ListIterator<E> iter2 = liste.listIterator(iter1.nextIndex());
		    while (iter2.hasNext()) {
		     if (precedent.equals(iter2.next())) {
		      return false;
		     }
		    }
		    precedent = courant;
		   }
		  }
		  return true;
		 }
}
