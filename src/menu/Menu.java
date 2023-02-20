package menu;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import model.Data;
import model.Tamagotchi;
import utils.Utilitaires;

public class Menu {

	public static void menuLancement() { 

		System.out.println("Bonjour \n");


		boolean laucherOn = true;
		
		do {
			
			System.out.println("1 [ Créer un nouveau Tamagotchi ]"); 
			System.out.println("2 * Charger un Tamagotchi *");
			System.out.println("3 Sortir"); 
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

			
			int i = Utilitaires.saisieInt();

			switch (i) {
			case 1:
				creeTama(); 
				break;
			case 2:
				chargeTama(); 
				System.out.println("Tamagotchi " + Data.NewTama.getNom()+ " **Chargé avec succès!**");
				menuTama();
				break;
			case 3:
				laucherOn = false; 
				break;
			default:
				break;
			}
		}
		while (laucherOn);
	}
	
	public static void creeTama() {
		
		System.out.println("Donnez un nom à cette adorable petite bête: ");

		
		Data.NewTama.setNom(Utilitaires.saisieString());
		
		System.out.println("Votre Tamagotchi "+ Data.NewTama.getNom() + " a bien été crée!");
		
		menuTama();
		
	}
	
	
	public static void menuTama() {
		
		boolean TamaOn = true;
		
		do {
		
			System.out.println("\nTamagotchi " +Data.NewTama.getNom() );
			System.out.println("Que voulez-vous faire ? \n");
			
			System.out.println("1 ** Gérer un Tamagotchi **");
			System.out.println("2 % Afficher les stats de votre Tamagotchi %");
			System.out.println("3 // Combattre contre un Tamagotchi //");
			System.out.println("4 ++ Sauvegarder la partie en cours ++");
			System.out.println("5 -- Quitter sans sauvegarder --");
			
			int j = Utilitaires.saisieInt();
			
			switch (j) {
			case 1:
				gererTama();
				break;
			case 2:
				showStats();
				break;
			case 3:
				fightTama();
				break;
			case 4:
				System.out.println("Sauvegarde du Tamagotchi : " +Data.NewTama.getNom() + " effectuée!" );
				utils.FileHandler.fileWriter();
				break;
			case 5:
				TamaOn = false;
				break;
			default:
				break;
			}
	
		}
		while (TamaOn);
	}
	
		public static void showStats() {
		
		System.out.println();
		System.out.println("Tours joués : " + Data.NewTama.getNbDeTour());
		System.out.println("+.+.+.+ Ici les statistiques de " + Data.NewTama.getNom() + " +.+.+.+");
		System.out.println("Energy : "+ Data.NewTama.getEnergy() );
		System.out.println("Force : "+ Data.NewTama.getForce() );
		System.out.println("Joie : "+Data.NewTama.getJoie());
		System.out.println("Faim : "+Data.NewTama.getFaim());
		System.out.println("Fatigue : "+Data.NewTama.getFatigue());
		System.out.println("Proprete : "+Data.NewTama.getProprete());
		System.out.println("Malus de Force : "+Data.NewTama.getMalusForce());
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

		}
		
		
		
		public static void gererTama() {
			
			boolean gererOn = true;
			
			do {
				
				showStats();
				
				int temporalTour = Data.NewTama.getNbDeTour();
				Data.NewTama.setNbDeTour(temporalTour+1);
				
				System.out.println("Age (en tours): " + Data.NewTama.getNbDeTour());
				System.out.println("Selectionner l'action à effectuer:");
				
				System.out.println("1 [Nourir] : Faim = 0 et Malusforce Diminue de 1");
				System.out.println("2 [Sortir] : Joie = 10 et Fatigue augmente de 1");
				System.out.println("3 [Laver] : Propreté = 10");
				System.out.println("4 [Caresser] : Energy = force + joie - faim - fatigue et fatigue = 0 ");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
				
				
				int k = Utilitaires.saisieInt();
				
				switch (k) {
				case 1:
					Data.NewTama.setFaim(0);
					
					System.out.println("** La faim de votre Tamagotchi est remise a zero! **"  );
					System.out.println("** Le MalusForce de votre Tamagotchi diminue! **"  );
					System.out.println("-- Avant: "+ Data.NewTama.getMalusForce());
					
					int x = Data.NewTama.getMalusForce();
					if (x != 0 ) {
					Data.NewTama.setMalusForce(x-1);
						}
					System.out.println("++ Après: "+ Data.NewTama.getMalusForce());
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
					
					AutoAction();
					break;
					
				case 2:
					Data.NewTama.setJoie(10);
					
					System.out.println("** La Joie de votre Tamagotchi est augmenter au max! **");
					System.out.println("** La Fatigue de votre Tamagotchi augmente! **");
					System.out.println("-- Avant: "+ Data.NewTama.getFatigue() );
					
					int y = Data.NewTama.getFatigue();
					if (y != 10 ) {
					Data.NewTama.setFatigue(y+1);
						}
					System.out.println("++ Après: "+ Data.NewTama.getFatigue());
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
					
					AutoAction();
					break;
					
				case 3:
					Data.NewTama.setProprete(10);
					
					System.out.println("** Tout beau tout nouveau! La Propreté de votre Tamagotchi est augmenter au max! **"  );
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
					
					AutoAction();
					break;
					
				case 4:

					int temporalForce = Data.NewTama.getForce();
					int temporalJjoie = Data.NewTama.getJoie();
					int temporalFaim = Data.NewTama.getFaim();
					int temporalFatigue = Data.NewTama.getFatigue();

					int nj = ((temporalForce + temporalJjoie) - temporalFaim) - temporalFatigue;
					if (nj < 0 ) {
						nj = 0;
					} else if (nj > 10) {
						nj = 10;
					}
					
					System.out.println("** La Fatigue de votre tamagotchi disparait! **");
					System.out.println("-- L'ancienne valeur d'Energie de votre Tamagotchi est de : " + Data.NewTama.getEnergy());
					
					Data.NewTama.setEnergy(nj);
					Data.NewTama.setFatigue(0);
					
					System.out.println("++ la nouvelle valeur d'Energie de votre tama est de : " + Data.NewTama.getEnergy());
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
					
					AutoAction();
					break;
					
				default:
				break;
				}

			}
			while (gererOn);
		}
		
		
		public static void AutoAction() {
			
			System.out.println("§§ Le temps qui passe impacte votre Tamagotchi! §§");
			System.out.println("~~ La faim et fatigue de votre Tamagotchi augmente, 1a propreté diminue! ~~"  );
			System.out.println("-- Avant, Faim :" + Data.NewTama.getFaim() + " Fatigue : " + Data.NewTama.getFatigue() + " Propreté : " + Data.NewTama.getProprete() );
			
			int temporalFaim = Data.NewTama.getFaim();
			int temporalFatigue = Data.NewTama.getFatigue();
			int temporalProprete = Data.NewTama.getProprete();
			
			if (temporalFaim != 10) {
				Data.NewTama.setFaim(temporalFaim+1);
			}
			if (temporalFatigue != 10) {
				Data.NewTama.setFatigue(temporalFatigue+1);
			}
			if (temporalProprete != 0) {
				Data.NewTama.setProprete(temporalProprete-1);
			}
			
			
			System.out.println("++ Après, Faim :" + Data.NewTama.getFaim() + " Fatigue : " + Data.NewTama.getFatigue() + " Propreté : " + Data.NewTama.getProprete() );
			
			System.out.println();
			randAction();
			System.out.println();
			contrainteTama();
			System.out.println();
			menuTama();
			System.out.println();
		
		}
		

		
		
		public static void randAction() {
			
			boolean randOn = true;
			
			do {
			
				int temporalFaim = Data.NewTama.getFaim();
				int temporalFatigue = Data.NewTama.getFatigue();
				int temporalProprete = Data.NewTama.getProprete();
				int w = Utilitaires.randomInt(1,3);
				
				switch (w) { 
				case 1 :
					
					System.out.println("*- L'action aléatoire de ce tour est une augmentation de la faim! *");
					System.out.println("-- Avant: "+ Data.NewTama.getFaim());
					
					if (temporalFaim != 10) {
						Data.NewTama.setFaim(temporalFaim+1);
					}
					
					System.out.println("++Après: "+ Data.NewTama.getFaim());
					
					randOn = false;
					break;
					
				case 2 :
					
					System.out.println("*- L'action aléatoire de ce tour est une augmentation de la fatigue! -*");
					System.out.println("-- Avant: "+ Data.NewTama.getFatigue());
					
					if (temporalFatigue != 10) {
						Data.NewTama.setFatigue(temporalFatigue+1);
					}
					
					System.out.println("++ Après: "+ Data.NewTama.getFatigue());
					
					randOn = false;
					break;
					
				case 3 :
					
					System.out.println("*- L'action aléatoire de ce tour est une diminution de la propreté! -*");
					System.out.println("-- Avant: "+ Data.NewTama.getProprete());
					
					if (temporalProprete != 0) {
						Data.NewTama.setProprete(temporalProprete-1);
					}
					
					System.out.println("++ Après: "+ Data.NewTama.getProprete());
					
					randOn = false;
					break;
					
				default :
				break;
				}
			
			}
			while (randOn);
	}

		
		public static void contrainteTama() {
			
			System.out.println("|| Les stats de " + Data.NewTama.getNom() + " evoluent entre elle! ||");
			
			int temporalFaim = Data.NewTama.getFaim();
			int temporalFatigue = Data.NewTama.getFatigue();
			int temporalProprete = Data.NewTama.getProprete();
			int temporalJoie = Data.NewTama.getJoie();
			int temporalEnergy = Data.NewTama.getEnergy();
			int temporalForce = Data.NewTama.getForce();
			int temporalMalusForce = Data.NewTama.getMalusForce();
			
			
			System.out.println("|| La force de votre tamagotchi change! ||");
			System.out.println("-- Avant : " + Data.NewTama.getForce());
			
			int nbrT = Data.NewTama.getNbDeTour();
			int setF = ((nbrT / 10)	- temporalMalusForce);
			if ( setF > 10) {
				Data.NewTama.setForce(10);
			} else if (setF < 0) {
				Data.NewTama.setForce(0);
			} else {
				
			}
			System.out.println("++ Après : " + Data.NewTama.getForce());
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			
			
			
			if (temporalFaim > 7) {
				
				System.out.println("[[[ " + Data.NewTama.getNom() +" a trop faim! Sa fatigue augmente, sa joie et son energie diminue! ]]]");
				System.out.println("-- Avant \n Joie :" + Data.NewTama.getJoie() + " Fatigue : " + Data.NewTama.getFatigue() + " Energie : " + Data.NewTama.getEnergy() );
				
				if (temporalJoie != 0) {
					Data.NewTama.setJoie(temporalJoie-1);
				}
				if (temporalFatigue != 10) {
					Data.NewTama.setFatigue(temporalFatigue+1);
				}
				if (temporalEnergy != 0) {
					Data.NewTama.setEnergy(temporalEnergy-1);
				}
				
				System.out.println("++ Après \n Joie :" + Data.NewTama.getJoie() + " Fatigue : " + Data.NewTama.getFatigue() + " Energie : " + Data.NewTama.getEnergy() );
				
				
				
			}
			if (temporalFatigue> 7) {
				
				System.out.println("[[[ " + Data.NewTama.getNom() + " est trop fatigué! Son malusForce augmente et son energie diminue! ]]]");
				System.out.println("-- Avant \n MalusForce :" + Data.NewTama.getMalusForce() + " Energie : " + Data.NewTama.getEnergy() );
				
				if (temporalMalusForce != 10) {
					Data.NewTama.setMalusForce(temporalMalusForce+1);
				}
				if (temporalEnergy != 0) {
					Data.NewTama.setEnergy(temporalEnergy-1);
				}
				
				System.out.println("++ Après \n MalusForce :" + Data.NewTama.getMalusForce() + " Energie : " + Data.NewTama.getEnergy() );
				
			}
			if (temporalProprete< 3) {
				
				System.out.println("[[[ " + Data.NewTama.getNom() + " est trop sale! Sa joie, sa force et son energie diminue! ]]]");
				System.out.println("-- Avant \n Joie :" + Data.NewTama.getJoie() + " Force : " + Data.NewTama.getForce() + " Energie : " + Data.NewTama.getEnergy() );
				
				if (temporalJoie != 0) {
					Data.NewTama.setJoie(temporalJoie-1);
				}
				if (temporalForce != 0) {{
					Data.NewTama.setForce(temporalForce-1);
				}
				if (temporalEnergy != 0) {
					Data.NewTama.setEnergy(temporalEnergy-1);
				}
				
				System.out.println("++ Après \n Joie :" + Data.NewTama.getJoie() + " Force : " + Data.NewTama.getForce() + " Energie : " + Data.NewTama.getEnergy() );
				
			}
			if (temporalJoie< 3) {
				
				System.out.println("[[[ " + Data.NewTama.getNom() + " est triste! Sa fatigue augmente et sa force ainsi que son energie diminue! ]]]");
				System.out.println("-- Avant \n Fatigue :" + Data.NewTama.getFatigue() + " Force : " + Data.NewTama.getForce() + " Energie : " + Data.NewTama.getEnergy() );
				
				if (temporalFatigue != 10) {
					Data.NewTama.setFatigue(temporalFatigue+1);
				}
				if (temporalForce != 0) { 
					Data.NewTama.setForce(temporalForce-1);
				}
				if (temporalEnergy != 0) {
					Data.NewTama.setEnergy(temporalEnergy-1);
				}
				
				
				System.out.println("++ Après \n Fatigue :" + Data.NewTama.getFatigue() + " Force : " + Data.NewTama.getForce() + " Energie : " + Data.NewTama.getEnergy() );
			}
		}
			

		}
	
		public static void fightTama() {
			
			System.out.println("----------------------------------------------------------");
			System.out.println("Ici vous mettez " + Data.NewTama.getNom() + "à l'epreuve! :!:!:!:!:!:!:!:!:!:!:!:!");
			System.out.println("----------------------------------------------------------\n");


			boolean FightOn = true;
			
			do {
				
				System.out.println("1 [ Combattre un Tamagotchi Aléatoire! ]");
				System.out.println("2 | Combattre un Tamagotchi Importer! |");
				System.out.println("3 [ Retour ]");
				System.out.println("\n**-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-**\n");
				
				int z = Utilitaires.saisieInt();

				switch (z) {
				case 1:

				int temporalDoubleVar = Utilitaires.randomInt(0,5);
				int ResultForce = ((Data.NewTama.getNbDeTour())/10)- temporalDoubleVar;
				if (ResultForce < 0) {
					ResultForce = 0;
				}
				
				Tamagotchi tamaBot1 = new Tamagotchi("Lee-Brave", Utilitaires.randomInt(5,15), ResultForce , Utilitaires.randomInt(5,10), Utilitaires.randomInt(0,5), Utilitaires.randomInt(0,5), Utilitaires.randomInt(5,10), temporalDoubleVar);
				Tamagotchi tamaBot2 = new Tamagotchi("ThiestBo", Utilitaires.randomInt(5,15), ResultForce , Utilitaires.randomInt(5,10), Utilitaires.randomInt(0,5), Utilitaires.randomInt(0,5), Utilitaires.randomInt(5,10), temporalDoubleVar);
				Tamagotchi tamaBot3= new Tamagotchi("Ant-One", Utilitaires.randomInt(5,15), ResultForce , Utilitaires.randomInt(5,10), Utilitaires.randomInt(0,5), Utilitaires.randomInt(0,5), Utilitaires.randomInt(5,10), temporalDoubleVar);
				Tamagotchi tamaBot4 = new Tamagotchi("Even-liMal", Utilitaires.randomInt(5,15), ResultForce , Utilitaires.randomInt(5,10), Utilitaires.randomInt(0,5), Utilitaires.randomInt(0,5), Utilitaires.randomInt(5,10), temporalDoubleVar);
				Tamagotchi tamaBot5 = new Tamagotchi("TamalAuxYeux", Utilitaires.randomInt(5,15), ResultForce , Utilitaires.randomInt(5,10), Utilitaires.randomInt(0,5), Utilitaires.randomInt(0,5), Utilitaires.randomInt(5,10), temporalDoubleVar);
				
					
					
					Data.tamaArray.add(tamaBot1);
					Data.tamaArray.add(tamaBot2);
					Data.tamaArray.add(tamaBot3);
					Data.tamaArray.add(tamaBot4);
					Data.tamaArray.add(tamaBot5);
					
					int w = Utilitaires.randomInt(0,4);
					
					System.out.println("Votre adversaire : ");
					System.out.println(Data.tamaArray.get(w) + "\n");
					
					
					System.out.println("{{ Debut du combat ]} \n \n");


					
					int myScore = Data.NewTama.getForce() + Utilitaires.randomInt(1, 10);
					int enemyScore = Data.tamaArray.get(w).getForce() + Utilitaires.randomInt(1, 10);
					int temporalWin = Data.NewTama.getNnbDeVictoire();
					
					System.out.println("Votre score est de : "+ myScore);
					System.out.println("Le score de l'adversaire est de : "+ enemyScore);
					System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n");

					if (myScore>enemyScore) {
						System.out.println("{[{[ Vous avez gagné ]}]} \n");
						Data.NewTama.setNbDeVictoire(temporalWin+1);
						System.out.println("Votre nombre de victoire est desormais de : "+ Data.NewTama.getNnbDeVictoire());
					} else if (enemyScore > myScore){
						System.out.println("§§§ Quel Echec. Vous avez perdu... Revoyez vos Kata §§§ \n" );
					} else {
						System.out.println("Egalité! Pas de défaite. Pas de victoire. Un peu fade...\n");
					}

					
					
					break;
					
				case 2:

					
					int i = 0;
					Scanner sc = new Scanner(System.in);
					
					BufferedReader bf;
					try {
						bf = new BufferedReader(new FileReader("src/utils/ImportTama.txt"));
						String s = bf.readLine();
						while(s!=null) {
							
							if (i==0) {
								String[] oneL = s.split(" ");
								Data.ImportTama.setNom(oneL[1]);
							
							} else if (i==1) {
								String[] oneL = s.split(" ");
								Data.ImportTama.setEnergy(Integer.parseInt(oneL[1]));
								
							} else if (i==2) {
								String[] oneL = s.split(" ");
								Data.ImportTama.setForce(Integer.parseInt(oneL[1]));
								
							} else if (i==3) {
								String[] oneL = s.split(" ");
								Data.ImportTama.setJoie(Integer.parseInt(oneL[1]));
								
							} else if (i==4) {
								String[] oneL = s.split(" ");
								Data.ImportTama.setFaim(Integer.parseInt(oneL[1]));
								
							} else if (i==5) {
								String[] oneL = s.split(" ");
								Data.ImportTama.setFatigue(Integer.parseInt(oneL[1]));
								
							} else if (i==6) {
								String[] oneL = s.split(" ");
								Data.ImportTama.setProprete(Integer.parseInt(oneL[1]));
								
							} else if (i==7) {
								String[] oneL = s.split(" ");
								Data.ImportTama.setMalusForce(Integer.parseInt(oneL[1]));
							}
					
							i++;
							s = bf.readLine();
							
						}
							
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}

					
					System.out.println("Vous affrontez : ");
					System.out.println(Data.ImportTama + "\n");
					
					
					System.out.println("Debut du duel d'arts martiaux !\n" + Data.NewTama.getNom() + " lui assène un violent coup de pied retourné ! \n");
					
					
					int myScoreSecond = Data.NewTama.getForce() + Utilitaires.randomInt(1, 10);
					int enemyScoreSecond = Data.ImportTama.getForce() + Utilitaires.randomInt(1, 10);
					int temporalWinSecond = Data.NewTama.getNnbDeVictoire();
					
					System.out.println("Votre score est de : "+ myScoreSecond);
					System.out.println("Le score de l'adversaire est de : "+ enemyScoreSecond);
					System.out.println();

					if (myScoreSecond>enemyScoreSecond) {
						System.out.println("Victoire par KO! Vous lui avez montré la veritable puissance !!!\n");
						Data.NewTama.setNbDeVictoire(temporalWinSecond+1);
						System.out.println("Votre nombre de victoire est desormais de : "+ Data.NewTama.getNnbDeVictoire());
					} else if (enemyScoreSecond > myScoreSecond){
						System.out.println("Perdu! Sa technique est juste meilleure. Entrainez vous d'avantage!\n");
					} else {
						System.out.println("Egalité! Je vous en prie. Battez vous serieusement !\n");
					}
					
					break;
				case 3:
					FightOn = false;
					break;
				default:
					break;
				}
			}
			while (FightOn);
		}
			
		public static void chargeTama() {
			
			int i = 0;
			Scanner sc = new Scanner(System.in);
			
			BufferedReader bf;
			try {
				bf = new BufferedReader(new FileReader("src/utils/Tama.txt"));
				String s = bf.readLine();
				while(s!=null) {
					
					if (i==0) {
						String[] oneL = s.split(" ");
						Data.NewTama.setNom(oneL[1]);
					
					} else if (i==1) {
						String[] oneL = s.split(" ");
						Data.NewTama.setEnergy(Integer.parseInt(oneL[1]));
						
					} else if (i==2) {
						String[] oneL = s.split(" ");
						Data.NewTama.setForce(Integer.parseInt(oneL[1]));
						
					} else if (i==3) {
						String[] oneL = s.split(" ");
						Data.NewTama.setJoie(Integer.parseInt(oneL[1]));
						
					} else if (i==4) {
						String[] oneL = s.split(" ");
						Data.NewTama.setFaim(Integer.parseInt(oneL[1]));
						
					} else if (i==5) {
						String[] oneL = s.split(" ");
						Data.NewTama.setFatigue(Integer.parseInt(oneL[1]));
						
					} else if (i==6) {
						String[] oneL = s.split(" ");
						Data.NewTama.setProprete(Integer.parseInt(oneL[1]));
						
					} else if (i==7) {
						String[] oneL = s.split(" ");
						Data.NewTama.setMalusForce(Integer.parseInt(oneL[1]));
					}
			
					i++;
					s = bf.readLine();
					
				}
					
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
			
	}

		

		
		
		
		
		
		
		
		
		
		
		
		
		
