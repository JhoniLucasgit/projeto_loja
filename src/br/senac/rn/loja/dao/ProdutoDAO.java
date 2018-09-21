package br.senac.rn.loja.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import br.senac.rn.loja.model.Produto;

public class ProdutoDAO {
	public void inserir(Produto produto) {
		ConexaoDB db = new ConexaoDB();
		String sql = "INSERT INTO tb_produtos (pro_nome, pro_preco, dep_pro_id) VALUES (?, ?, ?)";
		try {
			PreparedStatement ps = db.getConexao().prepareStatement(sql);
			ps.setString(1, produto.getNome());
			ps.setFloat(2, produto.getPreco());
			ps.setInt(3, produto.getDepartamento().getId());
		}catch(SQLException exception){
			System.out.println("ERRO: " + exception.getMessage());
		}
		db.fecharConexao();
	}
	public void remover(Produto produto) {
		ConexaoDB db = new ConexaoDB();
		String sql = "DELETE FROM tb_produtos WHERE pro_id = ? ";
		try {
			PreparedStatement ps = db.getConexao().prepareStatement(sql);
			ps.setInt(1, produto.getId());
			ps.executeUpdate();
		}catch(SQLException exception){
			System.out.println("ERRO: " + exception.getMessage());
		}
		db.fecharConexao();
	}
	public void editar(Produto produto) {
		ConexaoDB db = new ConexaoDB();
		String sql = "UPDATE FROM tb_produtos SET pro_nome = ?, pro_preco = ?, pro_desconto = ?";
		try {
			PreparedStatement ps = db.getConexao().prepareStatement(sql);
		}catch(SQLException exception){
			System.out.println("ERRO: " + exception.getMessage());
		}
	}
	public List<Produto> buscarTodos() {
		return null;
	}
	public List<Produto> buscarPorId() {
		return null;
	}
}
