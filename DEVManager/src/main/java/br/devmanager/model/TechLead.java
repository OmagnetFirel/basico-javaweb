package br.devmanager.model;

public class TechLead {
	private int id;
	private float nota;
	private Funcionario funcionario = new Funcionario();

	
	public TechLead(){}
	
	public TechLead(int id, float nota){
		this.id = id;
		this.nota = nota;
	}
	

	public TechLead(int id, float nota, Funcionario func){
		this.id = id;
		this.nota = nota;
		this.funcionario = func;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getNota() {
		return nota;
	}
	public void setNota(float nota) {
		this.nota = nota;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
}
