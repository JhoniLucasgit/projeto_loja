package br.senac.rn.conexaodb;

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
	
	public Connection getConexao() {
		try{
			Class.forName(DRIVE);
			Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA);
			return connection;
		}catch(ClassNotFoundException exception) {
			System.out.println("DRIVER NÃO ENCONTRADO!!!");
		}catch(SQLException exception) {
			System.out.println("PROBLEMAS COM A CONEXÃO!!!");
		}
		return null;
	}
}
