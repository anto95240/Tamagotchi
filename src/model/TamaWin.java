package model;

public class TamaWin extends Tamagotchi {
	
	int NbDeVictoire;
	int NbDeTour;

	public TamaWin(String nom, int energy, int force, int joie, int faim, int fatigue, int proprete, int malusForce,
			int nbDeVictoire, int nbDeTour) {
		super(nom, energy, force, joie, faim, fatigue, proprete, malusForce);
		NbDeVictoire = nbDeVictoire;
		NbDeTour = nbDeTour;
	}

	public int getNbDeTour() {
		return NbDeTour;
	}

	public void setNbDeTour(int nbDeTour) {
		NbDeTour = nbDeTour;
	}

	public int getNnbDeVictoire() {
		return NbDeVictoire;
	}

	public void setNbDeVictoire(int nbDeVictoire) {
		NbDeVictoire = nbDeVictoire;
	}
	@Override
	public String toString() {
		return "Nom: " + Nom + "\nEnergy: " + Energy + "\nForce: " + Force + "\nJoie: " + Joie + "\nFaim: " + Faim + "\nFatigue: " + Fatigue + "\nProprete: " + Proprete + "\nMalusForce: " + MalusForce;
	}
}
