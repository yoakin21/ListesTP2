package testsfonctionnels;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import cartes.Carte;
import cartes.JeuDeCartes;
import utils.GestionCartes;

public class TestGestionCartes {

    public static void main(String[] args) {
		JeuDeCartes jeu = new JeuDeCartes();
		List<Carte> listeCarteNonMelangee = new LinkedList<>();
		
		for (Carte carte : jeu.donnerCartes()) {
			listeCarteNonMelangee.add(carte);
		}
		List<Carte> listeCartes = new ArrayList<>(listeCarteNonMelangee);
		System.out.println(listeCartes);
		
		listeCartes = GestionCartes.melanger(listeCartes);
		System.out.println(listeCartes);
		System.out.println(
				"liste mélangée sans erreur ? " + GestionCartes.verifierMelange(listeCarteNonMelangee, listeCartes));
		listeCartes = GestionCartes.rassembler(listeCartes);
		System.out.println(listeCartes);
		System.out.println("liste rassemblée sans erreur ? " + GestionCartes.verifierRassemblement(listeCartes));

    }
}

/*  private static void testRassemblerListes() {
        List<List<Integer>> listes = List.of(
                List.of(),
                Arrays.asList(1, 1, 2, 1, 3),
                Arrays.asList(1, 4, 3, 2),
                Arrays.asList(1, 1, 2, 3, 1));

        for (List<Integer> liste : listes) {
            List<Integer> copie = new ArrayList<>(liste);
            List<Integer> rassemble = GestionCartes.rassembler(copie);
            System.out.println(liste + " -> rassemblement correct ? " + GestionCartes.verifierRassemblement(rassemble));
        }
    }
    
    
*/
