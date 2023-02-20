package model;

import java.util.ArrayList;

import utils.Utilitaires;

public class Data {
	

	public static TamaWin NewTama = new TamaWin(null, Utilitaires.randomInt(0,10), Utilitaires.randomInt(0,10), Utilitaires.randomInt(0,10), Utilitaires.randomInt(0,10), Utilitaires.randomInt(0,10), Utilitaires.randomInt(0,10), 0,0,0);
	
	public static Tamagotchi ImportTama = new Tamagotchi(null, 0,0,0,0,0,0,0);
	
	public static ArrayList<Tamagotchi> tamaArray = new ArrayList();
	

	}
