package br.devmanager.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.devmanager.model.ChefeDeTecnologia;

import br.devmanager.dao.ChefeDeTecnologiaDAO;

@WebServlet("/CadastrarCTO")
public class CadastrarCTO extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CadastrarCTO() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		ChefeDeTecnologia cto = new ChefeDeTecnologia();
		cto.setNome(nome);
		
		ChefeDeTecnologiaDAO ctoDao = new ChefeDeTecnologiaDAO();
		
		try {
			ctoDao.adicionar(cto);
			response.sendRedirect("index.html");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
