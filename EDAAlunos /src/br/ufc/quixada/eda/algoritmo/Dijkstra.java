package br.ufc.quixada.eda.algoritmo;

import br.ufc.quixada.eda.grafo.Aresta;
import br.ufc.quixada.eda.grafo.Grafo;
import br.ufc.quixada.eda.grafo.ListaAdjacencia;
import br.ufc.quixada.eda.listaprioridades.HeapMinimo;

public class Dijkstra {
	private int origem;
	private int ant[] = null;
	
	public void executar(Grafo g){
		//Inicializao Integer.MAX_VALUE
		
		HeapMinimo Q = new HeapMinimo(g.getQtdVertice());
		Q.contruir(null);
		
		while(!Q.vazia()){
			int u = Q.remove();
			ListaAdjacencia adj = g.getAdj()[u];
			adj.inicializarIterator();
			while(adj.hasNext()){
				Aresta a = adj.next();
				int v = (a.getU() == u ? a.getV() : a.getU());
				
				//Relaxamento(u, v)
			}
		}
	}
}



