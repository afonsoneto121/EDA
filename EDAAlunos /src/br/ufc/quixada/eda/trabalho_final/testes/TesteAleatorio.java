package br.ufc.quixada.eda.trabalho_final.testes;

import java.util.Random;

import br.ufc.quixada.eda.trabalho_final.model.Empresa;

public class TesteAleatorio extends Teste{
	
	public static void main(String[] args) {
		iniciarObjetos();  System.out.println("Objetos Iniciados");
		
		System.out.println("Inicio Teste AVL");
		testeAleatorioAvl(0.5, 0.3, "Mais Busca");
		testeAleatorioAvl(0.3, 0.5, "Mais Remoção");
		System.out.println("Inicio Teste RN");
		testeAleatorioRN(0.5, 0.3, "Mais Busca");
		testeAleatorioRN(0.3, 0.5, "Mais Remoção");
		System.out.println("Inicio Teste Splay");
		testeAleatorioSplay(0.5, 0.3, "Mais Busca");
		testeAleatorioSplay(0.3, 0.5, "Mais Remoção");
		
	}
	private static void testeAleatorioAvl(double taxaDeBusca,double taxaDeRemocao, String msg) {
		int tam = (int) empresas.size();
		int tamanhoDeBusca = (int) (empresas.size() * taxaDeBusca);
		int tamanhoDeRemocao = (int) (empresas.size() * taxaDeRemocao);
		Random rand = new Random();
		long tempoInicial = System.currentTimeMillis();
		for (Empresa empresa : empresas) {
			avl.inserir(empresa);
		}
		for (int i = 0; i < tamanhoDeBusca; i++) {				
			avl.busca(empresas.get(rand.nextInt(tam)));
		}
		for (int i = 0; i < tamanhoDeRemocao; i++) {
			avl.remover(empresas.get(rand.nextInt(tam)));
		}
		
		long tempo = System.currentTimeMillis() - tempoInicial;			  
		System.out.println(msg + " " + tempo);
	}
	private static void testeAleatorioRN(double d,double e, String msg) {
		int tam = (int) empresas.size();
		int tamanhoDeBusca = (int) (empresas.size() * d);
		int tamanhoDeRemocao = (int) (empresas.size() * e);
		Random rand = new Random();
		long tempoInicial = System.currentTimeMillis();
		for (Empresa empresa : empresas) {
			rn.inserir(empresa,empresa);
		}
		for (int i = 0; i < tamanhoDeBusca; i++) {				
			rn.busca(empresas.get(rand.nextInt(tam)));
		}
		for (int i = 0; i < tamanhoDeRemocao; i++) {
			rn.remover(empresas.get(rand.nextInt(tam)));
		}
		
		long tempo = System.currentTimeMillis() - tempoInicial;			  
		System.out.println(msg + " " + tempo);
	}
	
	private static void testeAleatorioSplay(double d,double e, String msg) {
		int tam = (int) empresas.size();
		int tamanhoDeBusca = (int) (empresas.size() * d);
		int tamanhoDeRemocao = (int) (empresas.size() * e);
		Random rand = new Random();
		long tempoInicial = System.currentTimeMillis();
		for (Empresa empresa : empresas) {
			splay.inserir(empresa);
		}
		for (int i = 0; i < tamanhoDeBusca; i++) {				
			splay.busca(empresas.get(rand.nextInt(tam)));
		}
		for (int i = 0; i < tamanhoDeRemocao; i++) {
			splay.remover(empresas.get(rand.nextInt(tam)));
		}
		
		long tempo = System.currentTimeMillis() - tempoInicial;			  
		System.out.println(msg + " " + tempo);
	}
}
