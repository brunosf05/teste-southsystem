package br.com.challange.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileService {

	public BufferedReader readFile(String path, String nameFile) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("." + path + nameFile + ".dat"));
			if (br.ready()) {
				return br;
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		return br;
	}

	public void saveFile(String path, String nameFile, String body) {

		try {
			FileWriter file = new FileWriter("." + path + nameFile + ".dat");
			PrintWriter saveFile = new PrintWriter(file);
			saveFile.printf(body);
			saveFile.close();
			System.out.println("Arquivo Salvo com Sucesso !");
		} catch (IOException e) {
			System.out.println("Falha ao Salvar !");
			e.printStackTrace();
		}
	    
	}
}
