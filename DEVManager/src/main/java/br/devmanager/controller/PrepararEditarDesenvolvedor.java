package br.devmanager.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.devmanager.dao.Desenvolvedor;
import br.devmanager.model.Funcionario;

@WebServlet("/PrepararEditarDesenvolvedor")
public class PrepararEditarDesenvolvedor extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public PrepararEditarDesenvolvedor() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int devId = Integer.parseInt(request.getParameter("id"));
		Funcionario func = null;
		Desenvolvedor funcDao = new Desenvolvedor();
		
		try {
			func = funcDao.buscarUm(devId);
		} catch (Exception e) {
			System.out.println("Erro ao buscar um desenvolvedor com esse id: " + e);
		}
		
		request.setAttribute("desenvolvedor", func);
		RequestDispatcher rd = request.getRequestDispatcher("/update/updateDesenvolvedor.jsp");
		rd.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
