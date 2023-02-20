package model;

public class Tamagotchi {

	String Nom;
	int Energy;
	int Force;
	int Joie;
	int Faim;
	int Fatigue;
	int Proprete;
	int MalusForce;
	
	
	public Tamagotchi(String nom, int energy, int force, int joie, int faim, int fatigue, int proprete,
			int malusForce) {
		super();
		Nom = nom;
		Energy = energy;
		Force = force;
		Joie = joie;
		Faim = faim;
		Fatigue = fatigue;
		Proprete = proprete;
		MalusForce = malusForce;
	}


	public String getNom() {
		return Nom;
	}


	public void setNom(String nom) {
		Nom = nom;
	}


	public int getEnergy() {
		return Energy;
	}


	public void setEnergy(int energy) {
		Energy = energy;
	}


	public int getForce() {
		return Force;
	}


	public void setForce(int force) {
		Force = force;
	}


	public int getJoie() {
		return Joie;
	}


	public void setJoie(int joie) {
		Joie = joie;
	}


	public int getFaim() {
		return Faim;
	}


	public void setFaim(int faim) {
		Faim = faim;
	}


	public int getFatigue() {
		return Fatigue;
	}


	public void setFatigue(int fatigue) {
		Fatigue = fatigue;
	}


	public int getProprete() {
		return Proprete;
	}


	public void setProprete(int proprete) {
		Proprete = proprete;
	}


	public int getMalusForce() {
		return MalusForce;
	}


	public void setMalusForce(int malusForce) {
		MalusForce = malusForce;
	}

	@Override
	public String toString() {
		return "Nom: " + Nom + "\nEnergy: " + Energy + "\nForce: " + Force + "\nJoie: " + Joie + "\nFaim: " + Faim + "\nFatigue: " + Fatigue + "\nProprete: " + Proprete + "\nMalusForce: " + MalusForce;
	}
}
