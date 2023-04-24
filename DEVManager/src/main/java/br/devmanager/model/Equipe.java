package br.devmanager.model;

public class Equipe {
	private int id;
	private String nome;
	
	public Equipe(int int1, String nome) {
		this.id = int1;
		this.nome = nome;
	}

	public Equipe() {
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}
}
