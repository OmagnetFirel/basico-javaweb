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

import br.devmanager.dao.Desenvolvedor;
import br.devmanager.model.Funcionario;

/**
 * Servlet implementation class ListarTodosDesenvolvedores
 */
@WebServlet("/ListarTodosDesenvolvedores")
public class ListarTodosDesenvolvedores extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarTodosDesenvolvedores() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Desenvolvedor devDao = new Desenvolvedor();
		String np = request.getParameter("np");
		String urlToValidate = "/create/frmCadastrarTechLead.jsp";

		
		List<Funcionario> desenvolvedores = null;
		try {
			if(np.equals(urlToValidate)) {
				desenvolvedores = devDao.buscarSomentDevs();
			} else {
				desenvolvedores = devDao.buscarTodos();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("desenvolvedores", desenvolvedores);
		RequestDispatcher rd = request.getRequestDispatcher(np);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
