package br.ufc.quixada.eda.trabalho_final.testes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import br.ufc.quixada.eda.trabalho_final.arvores.Avl;
import br.ufc.quixada.eda.trabalho_final.arvores.RubroNegra;
import br.ufc.quixada.eda.trabalho_final.arvores.Splay;
import br.ufc.quixada.eda.trabalho_final.model.Empresa;
import br.ufc.quixada.eda.trabalho_final.util.Constants;
import br.ufc.quixada.eda.trabalho_final.util.Util;

public class Teste {
	protected static Avl<Empresa, Empresa> avl;
	protected static RubroNegra<Empresa, Empresa> rn;
	protected static Splay<Empresa, Empresa> splay;
	
	protected static List<Empresa> empresas;
	protected static List<Empresa> busca;

	public static void main(String[] args) {
		iniciarObjetos();  System.out.println("Objetos Iniciados");
	
		System.out.println("Inicio Teste AVL");
		testeAvl();
		System.out.println("Inicio Teste RN");
		testeRN();
		System.out.println("Inicio Teste Splay");
		testeSplay();
		
		
	}
	
	protected static void iniciarObjetos() {
		avl = new Avl<Empresa, Empresa>();
		rn = new RubroNegra<Empresa, Empresa>();
		splay = new Splay<Empresa, Empresa>();
		
		String arquivoOperacao = "empresasC";
    	String path = Constants.caminhoPasta + arquivoOperacao + ".txt" ;
		empresas = Util.getempresas(path);
		busca = new ArrayList<Empresa>();
		
		int tam = empresas.size();
		Random rand = new Random();
		int i = 0;
		while (i < tam * 0.5) {				
			Empresa e = empresas.get(rand.nextInt(tam));
			busca.add(e);
			i++;
		}

	}
	
	protected static void testeAvl(){ 
    	try {
			
			//INSERIR 
			long tempoInicial = System.currentTimeMillis();				
			for (Empresa empresa : empresas) {
				avl.inserir(empresa);
			}
			long tempo = System.currentTimeMillis() - tempoInicial;			  
			System.out.println("Tempo de insercao: " + tempo);

			//BUSCAR
			
			int tam = empresas.size();
			tempoInicial = System.currentTimeMillis();
			for (int i = 0; i < tam * 0.5; i++) {				
				avl.busca(busca.get(i));
			}
			tempo = System.currentTimeMillis() - tempoInicial;			  
			System.out.println("Tempo de busca: " + tempo);
			
			//REMOVER
			tempoInicial = System.currentTimeMillis();
			for (Empresa empresa : busca) {
				avl.remover(empresa);
			}
			tempo = System.currentTimeMillis() - tempoInicial;			  
			System.out.println("Tempo de remorcao: " + tempo);
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	protected static void testeSplay(){ 
    	try {
			
			//INSERIR 
			long tempoInicial = System.currentTimeMillis();				
			for (Empresa empresa : empresas) {
				splay.inserir(empresa);
			}
			long tempo = System.currentTimeMillis() - tempoInicial;			  
			System.out.println("Tempo de insercao: " + tempo);

			//BUSCAR
			
			int tam = empresas.size();
			tempoInicial = System.currentTimeMillis();
			for (int i = 0; i < tam * 0.5; i++) {				
				splay.busca(busca.get(i));
			}
			tempo = System.currentTimeMillis() - tempoInicial;			  
			System.out.println("Tempo de busca: " + tempo);
			
			//REMOVER
			tempoInicial = System.currentTimeMillis();
			for (Empresa empresa : busca) {
				splay.remover(empresa);
			}
			tempo = System.currentTimeMillis() - tempoInicial;			  
			System.out.println("Tempo de remorcao: " + tempo);
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected static void testeRN(){ 
    	try {
			
			//INSERIR 
			long tempoInicial = System.currentTimeMillis();				
			for (Empresa empresa : empresas) {
				rn.inserir(empresa,empresa);
			}
			long tempo = System.currentTimeMillis() - tempoInicial;			  
			System.out.println("Tempo de insercao: " + tempo);

			//BUSCAR
			
			int tam = empresas.size();
			tempoInicial = System.currentTimeMillis();
			for (int i = 0; i < tam * 0.5; i++) {				
				rn.busca(busca.get(i));
			}
			tempo = System.currentTimeMillis() - tempoInicial;			  
			System.out.println("Tempo de busca: " + tempo);
			
			//REMOVER
			tempoInicial = System.currentTimeMillis();
			for (Empresa empresa : busca) {
				rn.remover(empresa);
			}
			tempo = System.currentTimeMillis() - tempoInicial;			  
			System.out.println("Tempo de remorcao: " + tempo);
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

}
