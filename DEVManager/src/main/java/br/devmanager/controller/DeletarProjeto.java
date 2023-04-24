package br.devmanager.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.devmanager.dao.ProjetoDao;

@WebServlet("/DeletarProjeto")
public class DeletarProjeto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DeletarProjeto() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int projetoId = Integer.parseInt(request.getParameter("id"));
		ProjetoDao prodao = new ProjetoDao();
		
		try {
			prodao.deletarUm(projetoId);
			response.sendRedirect("index.html");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
