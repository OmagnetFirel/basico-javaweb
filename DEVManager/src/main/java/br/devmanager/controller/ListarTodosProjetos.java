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

import br.devmanager.dao.ProjetoDao;
import br.devmanager.model.Projeto;


@WebServlet("/ListarTodosProjetos")
public class ListarTodosProjetos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListarTodosProjetos() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProjetoDao pjDAO = new ProjetoDao();
		List<Projeto> projetos = null;
		try {
			projetos = pjDAO.buscarTodos();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String np = request.getParameter("np");
		request.setAttribute("projetos", projetos);
		RequestDispatcher rd = request.getRequestDispatcher(np);
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
