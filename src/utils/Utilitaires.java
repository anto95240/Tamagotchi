package utils;

import java.util.Scanner;


public class Utilitaires {

	public static int saisieInt() {
		try {
			Scanner sc = new Scanner(System.in);
			return sc.nextInt();
		} catch (Exception e) { // catpture de l'erreur
			System.out.println("Attention, erreur de saisi!!!");
		}
		return 0;
	}

	public static String saisieString() {
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}
	
	public static int randomInt(int min, int max) {
		return (int)(Math.random() * ((max - min) + 1)) + min;
	}


	
	

}
