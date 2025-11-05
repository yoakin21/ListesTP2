package cartes;

public class JeuDeCartes {

	private Configuration[] configurations = new Configuration[19];

	public JeuDeCartes() {
		configurations[0] = new Configuration(new Borne(25), 10);
		configurations[1] = new Configuration(new Borne(50), 10);
		configurations[2] = new Configuration(new Borne(75), 10);
		configurations[3] = new Configuration(new Borne(100), 12);
		configurations[4] = new Configuration(new Borne(200), 4);

		configurations[5] = new Configuration(new Attaque(Type.FEU), 5);
		configurations[6] = new Configuration(new Attaque(Type.ESSENCE), 3);
		configurations[7] = new Configuration(new Attaque(Type.CREVAISON), 3);
		configurations[8] = new Configuration(new Attaque(Type.ACCIDENT), 3);

		configurations[9] = new Configuration(new Parade(Type.FEU), 14);
		configurations[10] = new Configuration(new Parade(Type.ESSENCE), 6);
		configurations[11] = new Configuration(new Parade(Type.CREVAISON), 6);
		configurations[12] = new Configuration(new Parade(Type.ACCIDENT), 6);

		configurations[13] = new Configuration(new Botte(Type.FEU), 1);
		configurations[14] = new Configuration(new Botte(Type.ESSENCE), 1);
		configurations[15] = new Configuration(new Botte(Type.CREVAISON), 1);
		configurations[16] = new Configuration(new Botte(Type.ACCIDENT), 1);

		configurations[17] = new Configuration(new DebutLimite(), 4);
		configurations[18] = new Configuration(new FinLimite(), 6);
	}

	public String affichageJeuDeCartes() {
		StringBuilder chaine = new StringBuilder();
		for (Configuration configuration : configurations) {
			if (configuration != null)
				chaine.append(configuration.getNbExemplaire() + " " + configuration.getCarte().toString() + "\n");
		}
		return chaine.toString();
	}

	public Carte[] donnerCartes() {
		int nbCartes = 0;
		for (Configuration configuration : configurations) {
			nbCartes += configuration.getNbExemplaire();
		}
		Carte[] cartes = new Carte[nbCartes];

		for (int indice = 0, j = 0; j < (configurations.length); j++) {
			Configuration configuration = configurations[j];
			for (int i = 0; i < configuration.getNbExemplaire(); i++, indice++) {
				cartes[indice] = configuration.getCarte();
			}
		}
		return cartes;
	}

	public boolean checkCount() {
		Carte[] cartes = donnerCartes();
		for (Configuration configuration : configurations) {
			int compteur = 0;
			for (Carte carte : cartes) {
				if (carte.equals(configuration.getCarte())) {
					compteur++;
				}
			}

			int nbExemplaire = configuration.getNbExemplaire();
			if (compteur != nbExemplaire)
				return false;

		}
		return true;
	}
}
