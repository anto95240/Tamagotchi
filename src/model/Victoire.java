package model;

public class Victoire extends Tamagotchi {
	
	int NnbDeVictoire;

	public Victoire(String nom, int energy, int force, int joie, int faim, int fatigue, int proprete, int malusForce,
			int nnbDeVictoire) {
		super(nom, energy, force, joie, faim, fatigue, proprete, malusForce);
		NnbDeVictoire = nnbDeVictoire;
	}

	public int getNnbDeVictoire() {
		return NnbDeVictoire;
	}

	public void setNnbDeVictoire(int nnbDeVictoire) {
		NnbDeVictoire = nnbDeVictoire;
	}

}
