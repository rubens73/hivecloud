package br.com.hivecloud.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CriarArquivo {
	
	public void criarArquivoTxt(String pTexto) {
		FileWriter arquivo;
		try {
			
			String fileName = "config/sample.txt";
	        ClassLoader classLoader = new CriarArquivo().getClass().getClassLoader();
	 
	        File file = new File(classLoader.getResource(fileName).getFile());
			System.out.println(file.toString());
			//String path = "C:/ws_spring/hivecloud/src/main/resources/";
			
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

