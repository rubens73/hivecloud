package br.com.hivecloud.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CriarArquivo {
	
	public void criarArquivoTxt(String pNome, String pTexto) {
		FileWriter arquivo;
		try {
			String path = "./src/main/resources/";
	        	File file = new File(path+"/prato_"+pNome+".txt");
			
			arquivo = new FileWriter(file);
			arquivo.write(pTexto);
			arquivo.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

