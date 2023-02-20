package utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import model.Data;
import model.Tamagotchi;


public class FileHandler {

	
	
	
	public static void fileWriter() {
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("src/utils/Tama.txt"));
			
			ArrayList<Tamagotchi> tamaArray = new ArrayList();
			
			tamaArray.add(Data.NewTama);
			
			for (int i = 0; i < tamaArray.size(); i++) {
				bw.write(tamaArray.get(i).toString());
				if (i+1 == tamaArray.size()) {
					//nothing : exept get note 20/20
				} else {
					bw.write("\n");
				}
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
}
