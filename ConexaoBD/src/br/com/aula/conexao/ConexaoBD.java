package br.com.aula.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
	
	private static final String URL = "jdbc:MySQL://localhost:3306/aula_java_db"; // verifica o URL do wampserver com o local rost e nome do projeto sql
	private static final String USUARIO = "root"; // usario do Admin
	private static final String SENHA = ""; // senha do Admin
	
	
	public static Connection conectar() { 
		Connection conexao = null; // se a conexão for diferente de nula ela executa o método try
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // registra o driver jdbc para conectar o código java com o sql
			conexao = DriverManager.getConnection(URL, USUARIO, SENHA); // método para efetuar a conexão que tem que ter o URL, USUARIO e SENHA 
			System.out.println("Conexão realizada com sucesso."); // mensagem caso a conexção seja bem sucedida
		} catch (ClassNotFoundException e) {
			System.out.println("Driver não encontrado: " + e.getMessage()); // mensagem caso o driver não seja encontrado
		} catch (SQLException e) {
			System.out.println("Erro ao conectar: " + e.getMessage()); // mensagem caso ocorra algum erro na conexão
		}
		return conexao;
	}

	
	public static void main(String[] args) {
		conectar(); // método para executar a conexão
	}
}
