package br.devmanager.model;
import java.util.Date;

public class Projeto {
		private int id;
	 	private Date dataInicio;
	    private Date dataFim;
	    private String nome;
	    private Equipe equipe;

	    public Projeto(Date dataInicio, Date dataFim, String nome, Equipe equipe) {
	        this.dataInicio = dataInicio;
	        this.dataFim = dataFim;
	        this.nome = nome;
	        this.equipe = equipe;
	    }

	    public Projeto(int id, String nome, Date dataInicio, Date dataFim, Equipe equipe) {
	        this.dataInicio = dataInicio;
	        this.dataFim = dataFim;
	        this.nome = nome;
	        this.equipe = equipe;
	        this.setId(id);
	    }

	    
	    

	    public Projeto() {
	    }
	    
	    public Date getDataInicio() {
	        return dataInicio;
	    }

	    public void setDataInicio(Date dataInicio) {
	        this.dataInicio = dataInicio;
	    }

	    public Date getDataFim() {
	        return dataFim;
	    }

	    public void setDataFim(Date dataFim) {
	        this.dataFim = dataFim;
	    }

	    public String getNome() {
	        return nome;
	    }

	    public void setNome(String nome) {
	        this.nome = nome;
	    }

	    public Equipe getEquipe() {
	        return equipe;
	    }

	    public void setEquipe(Equipe equipe) {
	        this.equipe = equipe;
	    }

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
}
