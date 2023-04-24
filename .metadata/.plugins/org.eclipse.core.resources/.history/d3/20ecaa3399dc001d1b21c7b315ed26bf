package br.devmanager.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.devmanager.dao.EquipeDao;
import br.devmanager.model.Equipe;


@WebServlet("/ListarTodasEquipes")
public class ListarTodasEquipes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ListarTodasEquipes() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EquipeDao equipeDao = new EquipeDao();
		
		List<Equipe> equipes = null;
		try {
			equipes = equipeDao.buscarTodos();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String np = request.getParameter("np");
		request.setAttribute("equipes", equipes);
		RequestDispatcher rd = request.getRequestDispatcher(np);
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
