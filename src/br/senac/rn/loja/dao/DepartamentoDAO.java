package br.senac.rn.loja.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.senac.rn.conexaodb.ConexaoDB;

import br.senac.rn.loja.model.Departamento;

public class DepartamentoDAO {
	
	ConexaoDB conexaodb = new ConexaoDB();
	
	public void inserir(Departamento dep) {
		String sql = "INSERT INTO tb_departamentos (dep_nome, dep_sigla, dep_desconto) values (?,?,?)";
		try {
			PreparedStatement statement = conexaodb.getConexao().prepareStatement(sql);
			statement.setString(1, dep.getNome());
			statement.setString(2, dep.getSigla());
			statement.setFloat(3, dep.getDesconto());
			statement.executeUpdate();
		}catch(SQLException exception) {
			System.out.println("ERRO: " + exception.getMessage());
		}
	}
	
	public void remover(Departamento dep) {
		String sql = "DELETE FROM tb_departamento WHERE dep_id = ?";
		try {
			PreparedStatement statement = conexaodb.getConexao().prepareStatement(sql);
			statement.setInt(1, dep.getId());
			statement.executeUpdate();
		}catch(SQLException exception) {
			System.out.println("ERRO: " + exception.getMessage());
		}
	}
	
	public void editar(Departamento dep) {
		String sql = "UPDATE tb_departamentos SET dep_nome = ?, dep_sigla = ?, dep_desconto = ? WHERE dep_id = ?";
		try {
			PreparedStatement statement = conexaodb.getConexao().prepareStatement(sql);
			statement.setString(1, dep.getNome());
			statement.setString(2, dep.getSigla());
			statement.setFloat(3, dep.getDesconto());
			statement.setInt(4, dep.getId());
			statement.executeUpdate();
		}catch(SQLException exception) {
			System.out.println("ERRO: " + exception.getMessage());
		}
	}
	
	public List<Departamento> buscaTodos() {
		List<Departamento> deps = new ArrayList<Departamento>();
		String sql = "SELECT * FROM tb_departamentos";
		try {
			PreparedStatement statement = conexaodb.getConexao().prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while(result.next()){
				Departamento dep = new Departamento();
				dep.setId(result.getInt("dep_id"));
				dep.setNome(result.getString("dep_nome"));
				dep.setSigla(result.getString("dep_sigla"));
				dep.setDesconto(result.getFloat("dep_desconto"));	
				deps.add(dep);
			}
			return deps;
		}catch(SQLException exception) {
			System.out.println("ERRO: " + exception.getMessage());
		}
		return null;
	}
	
	public Departamento buscaPorId(Integer id) {
		Departamento dep = new Departamento();
		String sql = "SELECT * FROM tb_departamento WHERE dep_id = ?";
		try {
			PreparedStatement statement = conexaodb.getConexao().prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			if(result.next()) {
				dep.setId(result.getInt("dep_id"));
				dep.setNome(result.getString("dep_nome"));
				dep.setSigla(result.getString("dep_sigla"));
				dep.setDesconto(result.getFloat("dep_desconto"));
			}
			return dep;
		}catch(SQLException exception) {
			System.out.println("ERRO: " + exception.getMessage());
		}
		return null;
	}	
}
	