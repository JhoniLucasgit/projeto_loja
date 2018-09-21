package br.senac.rn.loja.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {
	//MariaDB -> org.mariadb.jdbc.Driver
	//MySQL -> com.mysql.cj.jdbc.Driver
	//PostgreSQL -> org.postgresql.Driver
	//MSSQL -> com.microsoft.sqlserver.jdbc.SQLServerDriver

	private final String DRIVE = "org.mariadb.jdbc.Driver";
	private final String BANCO = "db_loja_de_esportes_noite";
	private final String URL = "jdbc:mariadb://localhost:3306/" + BANCO;
	private final String USUARIO = "root";
	private final String SENHA = "";

	private Connection connection;
	
	public ConexaoDB() {
		try{
			Class.forName(DRIVE);
			this.connection = DriverManager.getConnection(URL, USUARIO, SENHA);
			System.out.println("Conexão aberta");
		}catch(ClassNotFoundException exception) {
			System.out.println("DRIVER NÃO ENCONTRADO!!!");
			this.connection = null;
		}catch(SQLException exception) {
			System.out.println("PROBLEMAS COM A CONEXÃO!!!");
			this.connection = null;
		}
	}
	
	public Connection getConexao() {
		return this.connection;
	}
	
	public void fecharConexao() {
		try{
			this.connection.close();
			System.out.println("Conexão fechada");
		}catch(SQLException exception) {
			System.out.println("ERRO: " + exception.getMessage());
		}
	}
}
