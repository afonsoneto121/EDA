package br.ufc.quixada.eda.trabalho_final.arvores;

public class Splay <T extends Comparable<T>, Info>{
	private NoSplay<T, Info> raiz = null;
	
	private NoSplay<T, Info> splay(NoSplay<T, Info> raiz, T chave){
		if(raiz == null) return null;
		int cmp = chave.compareTo(raiz.getChave());
		if(cmp == 0) return raiz;
		else if(cmp == 1){
			if(raiz.getEsq() != null){
				raiz.setEsq(splay(raiz.getEsq(), chave));
				raiz = rotacaosimplesDireita(raiz);
			}
			return raiz;
		}else{
			if(raiz.getDir() != null){
				raiz.setDir(splay(raiz.getDir(), chave));
				raiz = rotacaosimplesEsquerda(raiz);
			}
			return raiz;
		}
	}
	
	public NoSplay<T, Info> busca(T chave){
		this.raiz = splay(this.raiz, chave);
		if(this.raiz != null && this.raiz.getChave() == chave) return this.raiz;
		return null;
	}

	public void inserir(T chave){
		raiz = splay(raiz, chave);
		if(raiz != null && chave.compareTo(raiz.getChave()) == 0) return;
		if(raiz == null){
			raiz = new NoSplay<T, Info>(chave);
		}else{
			int cmp = chave.compareTo(raiz.getChave());
			if(cmp > 0){
				NoSplay<T, Info> aux = new NoSplay<T, Info>(chave);
				aux.setDir(raiz);
				aux.getDir().setEsq(null);
				aux.setEsq(raiz.getEsq());
				raiz = aux;
			}else{
				NoSplay<T, Info> aux = new NoSplay<T, Info>(chave);
				aux.setEsq(raiz);
				aux.getEsq().setDir(null);
				aux.setDir(raiz.getDir());
				raiz = aux;
			}
		}
	}
	
	private NoSplay<T, Info> inserir(NoSplay<T, Info> NoSplay, T chave){
		if(NoSplay == null)
			return new NoSplay<T, Info>(chave);
		int cmp = chave.compareTo(NoSplay.getChave());
		if(cmp == 1){
			NoSplay.setDir(inserir(NoSplay.getDir(), chave));
		}else if(cmp == -1){
			NoSplay.setEsq(inserir(NoSplay.getEsq(), chave));
		}
		return NoSplay;
	}
	
	public void remover(T chave){
		this.raiz = splay(this.raiz, chave);
		if(this.raiz == null || this.raiz.getChave() != chave) return;
		NoSplay<T, Info> aux = splay(this.raiz.getEsq(), chave);
		if(raiz.getDir() != null && aux != null) aux.setDir(raiz.getDir());
		raiz = aux;
	}
	
	private NoSplay<T, Info> rotacaosimplesDireita(NoSplay<T, Info> NoSplay){
		NoSplay<T, Info> aux = NoSplay.getEsq();
		NoSplay.setEsq(NoSplay.getEsq().getDir());
		aux.setDir(NoSplay);
		return aux;
	}
	
	private NoSplay<T, Info> rotacaosimplesEsquerda(NoSplay<T, Info> NoSplay){
		NoSplay<T, Info> aux = NoSplay.getDir();
		NoSplay.setDir(NoSplay.getDir().getEsq());
		aux.setEsq(NoSplay);
		return aux;
	}
		
	private class NoSplay <T, Info> {
		
		private T chave;
		private NoSplay<T, Info> esq;
		private NoSplay<T, Info> dir;
		private Info info;
		
		public NoSplay(T chave){
			this.chave = chave;
			this.esq = null;
			this.dir = null;
		}
	
		public T getChave() {
			return chave;
		}
	
		public void setChave(T chave) {
			this.chave = chave;
		}
	
		public NoSplay<T, Info> getEsq() {
			return esq;
		}
	
		public void setEsq(NoSplay<T, Info> esq) {
			this.esq = esq;
		}
	
		public NoSplay<T, Info> getDir() {
			return dir;
		}
	
		public void setDir(NoSplay<T, Info> dir) {
			this.dir = dir;
		}
	
		public Info getInfo() {
			return info;
		}
	
		public void setInfo(Info info) {
			this.info = info;
		}
	}
}