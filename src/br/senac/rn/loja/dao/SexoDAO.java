package br.senac.rn.loja.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.senac.rn.conexaodb.ConexaoDB;

import br.senac.rn.loja.model.Sexo;

public class SexoDAO {
	
	ConexaoDB conexaodb = new ConexaoDB();
	
	public void inserir(Sexo sexo) {
		String sql = "INSERT INTO tb_sexos (sex_nome, sex_sigla) VALUES (?,?)";
		try {
			PreparedStatement statement = conexaodb.getConexao().prepareStatement(sql);
			statement.setString(1, sexo.getNome()); // so se no sql tiver ?(interroga��o)
			statement.setString(2, sexo.getSigla()); // so se no sql tiver ?(interroga��o)
			statement.executeUpdate();
		}catch(SQLException exception) {
			System.out.println("ERRO: " + exception.getMessage());
		}
	}
	
	public void remover(Sexo sexo) {
		String sql = "DELETE FROM tb_sexos WHERE sex_id = ?";
		try {
			PreparedStatement statement = conexaodb.getConexao().prepareStatement(sql);
			statement.setInt(1, sexo.getId()); // so se no sql tiver ?(interroga��o)
			statement.executeUpdate();
		}catch(SQLException exception) {
			System.out.println("ERRO: " + exception.getMessage());
		}
	}
	
	public void editar(Sexo sexo) {
		String sql = "UPDATE tb_sexos SET sex_nome = ?, sex_sigla = ? WHERE sex_id = ?";
		try {
			PreparedStatement statement = conexaodb.getConexao().prepareStatement(sql);
			statement.setString(1, sexo.getNome()); // so se no sql tiver ?(interroga��o)
			statement.setString(2, sexo.getSigla()); // so se no sql tiver ?(interroga��o)
			statement.setInt(3, sexo.getId()); // so se no sql tiver ?(interroga��o)
			statement.executeUpdate();
		}catch(SQLException exception) {
			System.out.println("ERRO: " + exception.getMessage());
		}
	}
	
	public List<Sexo> buscaTodos() {
		List<Sexo> sexos = new ArrayList<Sexo>();
		String sql = "SELECT * FROM tb_sexos";
		try {
			PreparedStatement statement = conexaodb.getConexao().prepareStatement(sql);
			ResultSet result = statement.executeQuery(); // armazena o resultado da query(pesquisa)
			while(result.next()) { // checa se tem linhas na pesquisa feita, se tiver ele executa, se n�o ele sai
				// convertendo as linha da pesquisa em sexo para colocar na lista
				Sexo sexo = new Sexo();
				sexo.setId(result.getInt("sex_id"));
				sexo.setNome(result.getString("sex_nome"));
				sexo.setSigla(result.getString("sex_sigla"));
				sexos.add(sexo);
			}
			return sexos;
		}catch(SQLException exception) {
			System.out.println("ERRO: " + exception.getMessage());
		}
		return null;
	}
	
	public Sexo buscaPorId(Integer id) {
		Sexo sexo = new Sexo();
		String sql = "SELECT * FROM tb_sexos WHERE sex_id = ?";
		try {
			PreparedStatement statement = conexaodb.getConexao().prepareStatement(sql);
			statement.setInt(1, id); // passando o id como parametro
			ResultSet result = statement.executeQuery(); // armazena o resultado da query(pesquisa)
			if(result.next()) {// convertendo as linha da pesquisa em sexo para colocar na lista
				sexo.setId(result.getInt("sex_id"));
				sexo.setNome(result.getString("sex_nome"));
				sexo.setSigla(result.getString("sex_sigla"));
			}
			return sexo;
		}catch(SQLException exception) {
			System.out.println("ERRO: " + exception.getMessage());
		}
		return null;
	}
	
	
	
}
