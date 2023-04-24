package br.devmanager.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import br.devmanager.dao.ProjetoDao;
import br.devmanager.model.Projeto;

@WebServlet("/PrepararEditarProjeto")
public class PrepararEditarProjeto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public PrepararEditarProjeto() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int projetoId = Integer.parseInt(request.getParameter("id"));
		Projeto projeto = null;
		ProjetoDao proDao = new ProjetoDao();
		
		try {
			projeto = proDao.buscarUm(projetoId);
		} catch (Exception e) {
			System.out.println("Não foi possivel achar uma categoria com esse id");
		}
		
		request.setAttribute("projeto", projeto);
		RequestDispatcher rd = request.getRequestDispatcher("/update/updateProjeto.jsp");
		rd.forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
