package br.ufc.quixada.eda.trabalho_final.arvores;

public class Avl<T extends Comparable<T>,Info>{
private NoAvl<T, Info> raiz;
	
	public void inserir(T value){
		raiz = inserir(raiz, value);
	}
	
	public Avl(){
		raiz = null;
	}
	
	private NoAvl<T, Info> inserir(NoAvl<T, Info> no, T value){
		if(no == null){
			NoAvl<T, Info> aux = new NoAvl<T, Info>(value);
			return aux;
		}
		int comp = value.compareTo(no.getValor());
		if(comp < 0){
			no.setEsquerdo(inserir(no.getEsquerdo(), value));
			if((altura(no.getEsquerdo()) - altura(no.getDireito())) == 2){
				if(altura(no.getEsquerdo().getEsquerdo()) > altura(no.getEsquerdo().getDireito())){
					no = rotacaosimplesDireita(no);
				}else{
					no = rotacaoduplaDireita(no);
				}
			}
		}else if(comp > 1){
			no.setDireito(inserir(no.getDireito(), value));
			if((altura(no.getDireito()) - altura(no.getEsquerdo())) == 2){
				if(altura(no.getDireito().getDireito()) > altura(no.getDireito().getEsquerdo())){
					no = rotacaosimplesEsquerda(no);
				}else{
					no = rotacaoduplaEsquerda(no);
				}
			}
		}
		no.setAltura(((altura(no.getDireito()) > altura(no.getEsquerdo())) ? altura(no.getDireito()) : (altura(no.getEsquerdo()))) + 1);
		return no;
	}
	
	private int altura(NoAvl<T, Info> no){
		return (no != null ? no.getAltura() : 0);
	}
	
	private NoAvl<T, Info> rotacaosimplesDireita(NoAvl<T, Info> no){
		NoAvl<T, Info> aux = no.getEsquerdo();
		no.setEsquerdo(no.getEsquerdo().getDireito());
		aux.setDireito(no);
		no.setAltura((altura(no.getDireito()) > altura(no.getDireito()) ? altura(no.getDireito()) : (altura(no.getEsquerdo())) + 1));
		aux.setAltura((altura(aux.getDireito()) > altura(aux.getDireito()) ? altura(aux.getDireito()) : (altura(aux.getEsquerdo())) + 1));
		return aux;
	}
	
	private NoAvl<T, Info> rotacaosimplesEsquerda(NoAvl<T, Info> no){
		NoAvl<T, Info> aux = no.getDireito();
		no.setDireito(no.getDireito().getEsquerdo());
		aux.setEsquerdo(no);
		no.setAltura((altura(no.getDireito()) > altura(no.getDireito()) ? altura(no.getDireito()) : (altura(no.getEsquerdo())) + 1));
		aux.setAltura((altura(aux.getDireito()) > altura(aux.getDireito()) ? altura(aux.getDireito()) : (altura(aux.getEsquerdo())) + 1));
		return aux;
	}
	
	private NoAvl<T, Info> rotacaoduplaDireita(NoAvl<T, Info> no){
		no.setEsquerdo(rotacaosimplesEsquerda(no.getEsquerdo()));
		no = rotacaosimplesDireita(no);
		return no;
	}
	
	private NoAvl<T, Info> rotacaoduplaEsquerda(NoAvl<T, Info> no){
		no.setDireito(rotacaosimplesDireita(no.getDireito()));
		no = rotacaosimplesEsquerda(no);
		return no;
	}
	
	private NoAvl<T, Info> busca(NoAvl<T, Info> no, T value){
		if(no == null) return null;
		int cmp = value.compareTo(no.getValor());
		if(cmp > 0){
			return busca(no.getDireito(), value);
		}else if(cmp < 0){
			return busca(no.getEsquerdo(), value);
		}
		return no;
	}
	
	public NoAvl<T, Info> busca(T value){
		return busca(raiz, value);
	}
	
	public void remover(T value){
		raiz = remover_recursivo(raiz, value);
	}
	
	private NoAvl<T, Info> remover_recursivo(NoAvl<T, Info> no, T value){
		if(no == null)
			return null;
		int cmp = value.compareTo(no.getValor());
		if(cmp == 1){
			no.setDireito(remover_recursivo(no.getDireito(), value));
			if((altura(no.getEsquerdo()) - altura(no.getDireito())) == 2){
				if(altura(no.getEsquerdo().getEsquerdo()) > altura(no.getEsquerdo().getDireito())){
					no = rotacaosimplesDireita(no);
				}else{
					no = rotacaoduplaDireita(no);
				}
			}
		}else if(cmp == -1){
			no.setEsquerdo(remover_recursivo(no.getEsquerdo(), value));
			if((altura(no.getDireito()) - altura(no.getEsquerdo())) == 2){
				if(altura(no.getDireito().getDireito()) > altura(no.getDireito().getEsquerdo())){
					no = rotacaosimplesEsquerda(no);
				}else{
					no = rotacaoduplaEsquerda(no);
				}
			}
		}else{
			if(no.getDireito() == null || no.getEsquerdo() == null){
				if(no.getDireito() == null && no.getDireito() == null)
					return null;
				if(no.getDireito() == null){
					no = no.getEsquerdo();
				}else{
					no = no.getDireito();
				}
			}else{
				NoAvl<T, Info> aux = menor(no.getDireito());
				no.setValor(aux.getValor());
				no.setDireito(remover_recursivo(no.getDireito(), aux.getValor()));
			}
		}
		no.setAltura(((altura(no.getDireito()) > altura(no.getEsquerdo())) ? altura(no.getDireito()) : (altura(no.getEsquerdo()))) + 1);
		return no;
	}
	
	private NoAvl<T, Info> menor(NoAvl<T, Info> no){
		NoAvl<T, Info> aux = no;
		while(aux.getEsquerdo() != null)
			aux = aux.getEsquerdo();
		return aux;
	}

 
	private class NoAvl<T,Info>{
		private T valor;
		private Integer altura;
		private NoAvl<T, Info> direito,esquerdo;
		private Info infor;
		
		public NoAvl(T valor) {
			this.valor = valor;
			this.setAltura(1);
		}
	
		public T getValor() {
			return valor;
		}
	
		public void setValor(T valor) {
			this.valor = valor;
		}
	
		public int getAltura() {
			return altura;
		}
	
		public void setAltura(int altura) {
			this.altura = altura;
		}
	
		public NoAvl<T, Info> getDireito() {
			return direito;
		}
	
		public void setDireito(NoAvl<T, Info> direito) {
			this.direito = direito;
		}
	
		public NoAvl<T, Info> getEsquerdo() {
			return esquerdo;
		}
	
		public void setEsquerdo(NoAvl<T, Info> esquerdo) {
			this.esquerdo = esquerdo;
		}
	
		public Info getInfor() {
			return infor;
		}
	
		public void setInfor(Info infor) {
			this.infor = infor;
		}
			
	}

}