package br.devmanager.controller;
import br.devmanager.model.Funcionario;

import br.devmanager.dao.Desenvolvedor;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.devmanager.dao.TechLeadDao;
import br.devmanager.dao.EquipeDao;

@WebServlet("/CadastrarDesenvolvedor")
public class CadastrarDesenvolvedor extends HttpServlet {
	private static final long serialVersionUID = 1L;
      

    public CadastrarDesenvolvedor() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		int idade = Integer.parseInt(request.getParameter("idade"));
		float salario = Float.parseFloat(request.getParameter("salario"));
		String nivel = request.getParameter("nivel");
		String genero = request.getParameter("genero");
		String email = request.getParameter("email");
		int idGestor = Integer.parseInt(request.getParameter("idGestor"));
		int idEquipe = Integer.parseInt(request.getParameter("idEquipe"));
		
		TechLeadDao gestor= new TechLeadDao();
		EquipeDao equipeDao = new EquipeDao();
		
		Funcionario funcionario = new Funcionario(
				idade, nome, genero,email, nivel, salario
			);
		try {
			funcionario.setGestor(gestor.buscarUm(idGestor));
		} catch (Exception e) {
			System.out.println("Error: "+ e);
		}
		
		try {
			funcionario.setEquipe(equipeDao.buscarUm(idEquipe));
		} catch (Exception e) {
			System.out.println("Error: "+ e);
		}
		
		Desenvolvedor devDao = new Desenvolvedor();
		try{
			devDao.adicionar(funcionario);
			response.sendRedirect("index.html");

		}catch(SQLException e){
			e.printStackTrace();
		}
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
