package br.devmanager.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.devmanager.dao.TechLeadDao;


@WebServlet("/CadastrarTechLead")
public class CadastrarTechLead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CadastrarTechLead() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("idFuncionario"));
		
		TechLeadDao leadDao = new TechLeadDao();
		try {
			leadDao.adicionar(id);
			response.sendRedirect("index.html");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
