package br.devmanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.devmanager.model.Funcionario;
import br.devmanager.model.TechLead;




public class Desenvolvedor {
	private Connection con = null;

	public Desenvolvedor() {
		con = ConnectionFactory.getConnection();
	}
	
	public void adicionar(Funcionario dev) throws SQLException {
		
		String sql = "insert into desenvolvedor"
				+ "(idade,nome,genero,email,salario,nivel,superiorId, equipeId) "
				+ "values (?,?,?,?,?,?,?,?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		
		
		stmt.setInt(1, dev.getIdade());
		stmt.setString(2, dev.getNome());
		stmt.setString(3, dev.getGenero());
		stmt.setString(4, dev.getEmail());
		stmt.setFloat(5, dev.getSalario());
		stmt.setString(6, dev.getNivel());
		stmt.setInt(7, dev.getGestor().getId());
		stmt.setInt(8, dev.getEquipe().getId());
		stmt.execute();
		stmt.close();
		con.close();
		
	}

	public List<Funcionario> buscarTodos() throws SQLException {
		
		String sql = "select idFuncionario, nome,idade,genero,email,salario,nivel,superiorId,equipeId from desenvolvedor";
		PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		List<Funcionario> desenvolvedores = new ArrayList<Funcionario>();
		while (rs.next()) {
			TechLeadDao leadDao = new TechLeadDao();
			EquipeDao equipeDao = new EquipeDao();
			
			Funcionario func = new Funcionario(
					rs.getInt("idFuncionario"),
					rs.getInt("idade"),
					rs.getString("nome"),
					rs.getString("genero"),
					rs.getString("email"),
					rs.getString("nivel"),
					rs.getFloat("salario")
			);
			
			try {
				func.setGestor(leadDao.buscarUm(rs.getInt("superiorId")));
			} catch (Exception e) {
				// TODO: handle exception
			}
			try {
				func.setEquipe(equipeDao.buscarUm(rs.getInt("equipeId")));
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			desenvolvedores.add(func);
		}
		stmt.close();
		con.close();
		return desenvolvedores;
		
	}
	
	public List<Funcionario> buscarSomentDevs() throws SQLException {

		String sql = "select idFuncionario, nome,idade,genero,email,salario,nivel,superiorId,equipeId from desenvolvedor";
		PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		List<Funcionario> desenvolvedores = new ArrayList<Funcionario>();
		TechLeadDao liderDao = new TechLeadDao();
		List<TechLead> lideres = liderDao.buscarTodos();
		
		while (rs.next()) {
			TechLeadDao leadDao = new TechLeadDao();
			EquipeDao equipeDao = new EquipeDao();
			Funcionario func = new Funcionario(
					rs.getInt("idFuncionario"),
					rs.getInt("idade"),
					rs.getString("nome"),
					rs.getString("genero"),
					rs.getString("email"),
					rs.getString("nivel"),
					rs.getFloat("salario")
			);
			
			try {
				func.setGestor(leadDao.buscarUm(rs.getInt("superiorId")));
			} catch (Exception e) {
				// TODO: handle exception
			}
			try {
				func.setEquipe(equipeDao.buscarUm(rs.getInt("equipeId")));
			} catch (Exception e) {
				// TODO: handle exception
			}
			boolean ehLider = false;
			
			for(TechLead lider: lideres) {
				if(lider.getFuncionario().getId() == func.getId()) {
					ehLider = true;
				} 
			}
			
			if(ehLider == false) {
				desenvolvedores.add(func);
			}
		}
		stmt.close();
		con.close();
		return desenvolvedores;
		
	}
	
	public Funcionario buscarUm(int id) throws SQLException {
		
		String sql = "select "
				+ "idFuncionario,nome,idade,genero,email,salario,nivel,superiorId"
				+ " from desenvolvedor "
				+ "where idFuncionario = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1,id);
		ResultSet rs = stmt.executeQuery();
		Funcionario func = null;
		if (rs.next()) {
			func = new Funcionario(
					rs.getInt("idFuncionario"),
					rs.getInt("idade"),
					rs.getString("nome"),
					rs.getString("genero"),
					rs.getString("email"),
					rs.getString("nivel"),
					rs.getFloat("salario")
			);
		}
		stmt.close();
		con.close();
		return func;
		
	}
	
	public void editarFuncionario(Funcionario funcionario) throws SQLException {
		String sql = "UPDATE desenvolvedor "
				+ "SET nome = ?, idade = ?, genero=?, email=?, salario=?, nivel=?, superiorId=?, equipeId=? "
				+ "where idFuncionario = ?";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		
		stmt.setString(1, funcionario.getNome());
		stmt.setInt(2, funcionario.getIdade());
		stmt.setString(3, funcionario.getGenero());
		stmt.setString(4, funcionario.getEmail());
		stmt.setFloat(5, funcionario.getSalario());
		stmt.setString(6, funcionario.getNivel());
		stmt.setInt(7, funcionario.getGestor().getId());
		stmt.setInt(8, funcionario.getEquipe().getId());
		
		stmt.setInt(9, funcionario.getId());

		stmt.execute();
		stmt.close();
		con.close();
	}
	
	public void deletarUm(int id) throws SQLException{
		String sql = "DELETE from desenvolvedor where id = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, id);
		
		stmt.execute();
		stmt.close();
		con.close();
	}
	
	public List<Funcionario> buscarMembrosEquipe(int id) throws SQLException{
		String sql = "Select idFuncionario, nome, nivel,idade,genero,email,salario from desenvolvedor where equipeId = ? ";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, id);
		
		ResultSet rs = stmt.executeQuery();
		List<Funcionario> desenvolvedores = new ArrayList<Funcionario>();

		while (rs.next()) {
			System.out.println(rs.getString("nome"));
	
			Funcionario func = new Funcionario(
					rs.getInt("idFuncionario"),
					rs.getInt("idade"),
					rs.getString("nome"),
					rs.getString("genero"),
					rs.getString("email"),
					rs.getString("nivel"),
					rs.getFloat("salario")
			);
			
			desenvolvedores.add(func);
		}
		
		return desenvolvedores;
	}

}
