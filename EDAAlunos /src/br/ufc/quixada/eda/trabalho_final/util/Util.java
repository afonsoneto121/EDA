package br.ufc.quixada.eda.trabalho_final.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import br.ufc.quixada.eda.trabalho_final.model.Empresa;


public class Util {
	public static List<Empresa> getempresas(String path){
    	DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    	List<Empresa> empresas = new ArrayList<Empresa>();
        Scanner scanner = null;
		try {
			scanner = new Scanner(new FileReader(path)).useDelimiter(", |\r\n");
		
        while (scanner.hasNext()){
        	Empresa e = new Empresa(scanner.next().substring(5), scanner.next().substring(5), scanner.next().substring(13), 
					formatter.parse(scanner.next().substring(13)), scanner.next().substring(5), scanner.next().substring(6),
					scanner.next().substring(4), scanner.next().substring(4), scanner.next().substring(7), scanner.next().substring(7),
					scanner.next().substring(7),scanner.next().substring(7), scanner.next().substring(9), scanner.next().substring(8));
        	empresas.add(e);        	
        }
		} catch (Exception e1) {
			e1.printStackTrace();
		}	                
        				
		scanner.close();
        return empresas;
    }
    /*
    public static void main(String[] args) {
		String arquivoOperacao = "empresasC";
    	String path = Constats.PATH + arquivoOperacao + ".txt";
		try {
			List<Empresa> empresas = getempresas(path);
			System.out.println(empresas.get(1).getDataAbertura()+ "\n"+ empresas.get(2).getDataAbertura());
			System.out.println(empresas.get(2).compareTo(empresas.get(1)));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
     */ 
}
