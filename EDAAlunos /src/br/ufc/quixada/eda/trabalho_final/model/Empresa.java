package br.ufc.quixada.eda.trabalho_final.model;

import java.util.Date;

public class Empresa implements Comparable<Empresa>{

	private String nome;
	private String cnpj;
	private String inscricaoEst;
	private Date dataAbertura;
	private String site;
	private String email;
	private String cep;
	private String rua;
	private String numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String telefone;
	private String celular;
	private Date chave;

	
	public Empresa() {}
	public Empresa(String nome, String cnpj, String inscricaoEst,
			Date dataAbertura, String site, String email, String cep,
			String rua, String numero, String bairro, String cidade,
			String estado, String telefone, String celular) {
		this.nome = nome;
		this.cnpj = cnpj;
		this.inscricaoEst = inscricaoEst;
		this.dataAbertura = dataAbertura;
		this.site = site;
		this.email = email;
		this.cep = cep;
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.telefone = telefone;
		this.celular = celular;
		this.chave = dataAbertura;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getInscricaoEst() {
		return inscricaoEst;
	}
	public void setInscricaoEst(String inscricaoEst) {
		this.inscricaoEst = inscricaoEst;
	}
	public Date getDataAbertura() {
		return dataAbertura;
	}
	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public Date getChave() {
		return chave;
	}
	public void setChave(Date chave) {
		this.chave = chave;
	}
	@Override
	public int compareTo(Empresa o) {
		if(this.chave.after(o.getChave())) return 1;
		else return -1;
	}
	
	
}
