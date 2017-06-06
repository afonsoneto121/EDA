package br.ufc.quixada.eda.avl;

public class ArvoreAVL {
	private NoAVL raiz;

	public ArvoreAVL() {
		raiz = null;
	}
	
	public void inserir(Integer chave) {
		raiz = inserir(raiz, chave);
	}
	
	private NoAVL inserir(NoAVL raiz, Integer chave) {
		if(raiz == null) {
			raiz = new NoAVL(chave);
			return raiz;
		}
		else if(raiz.getChave() > chave){
			raiz.setEsq(inserir(raiz.getEsq(), chave));
			if(altura(raiz.getEsq()) - altura(raiz.getDir()) == 2) {
				
			}
		}
		
		return null;
	}
	
	private Integer altura(NoAVL raiz){
		return (raiz != null ? 1 : 0);
	}
}
