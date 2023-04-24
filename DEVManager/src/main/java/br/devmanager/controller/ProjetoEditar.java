package br.devmanager.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.devmanager.dao.EquipeDao;
import br.devmanager.dao.ProjetoDao;
import br.devmanager.model.Projeto;


@WebServlet("/ProjetoEditar")
public class ProjetoEditar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ProjetoEditar() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String data_inicio = request.getParameter("data_inicio");
		String data_fim = request.getParameter("data_fim");
		int equipeId = Integer.parseInt(request.getParameter("idEquipe"));
		int projetoId = Integer.parseInt(request.getParameter("id"));
		EquipeDao equipe = new EquipeDao();
		
        DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date data_inicio_convertida = null;
        try {
        	data_inicio_convertida = formato.parse(data_inicio);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date data_fim_convertida = null;
        try {
        	data_fim_convertida = formato.parse(data_fim);
        } catch (ParseException e) {
            e.printStackTrace();
        }

		ProjetoDao projetoDao = new ProjetoDao();

		try {
			Projeto projeto = new Projeto(
					projetoId,
					nome,
					data_inicio_convertida,
					data_fim_convertida,
					equipe.buscarUm(equipeId)
					);
			try {
				projetoDao.atualizarDados(projeto);
			}catch(SQLException e) {
				e.printStackTrace();
			}
			response.sendRedirect("index.html");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
