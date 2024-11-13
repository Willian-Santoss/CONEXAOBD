package br.com.aula.conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
public class InserirDados {
	public static void main(String[] args) {
		Connection conexao = ConexaoBD.conectar(); // método para conectar com o SQL do servidor Wamp
		Scanner scanner = new Scanner(System.in); // cria um objeto Scanner para ler entradas do usuário
		if (conexao != null) {
			String sql = "INSERT INTO alunos (nome, idade) VALUES (?, ?)";
			try {
				// métodos para inserir nome e idade do aluno
				System.out.print("Digite o nome do aluno: ");
                String nome = scanner.nextLine();

                System.out.print("Digite a idade do aluno: ");
                int idade = scanner.nextInt();
                
				PreparedStatement stmt = conexao.prepareStatement(sql); // consulta o código sql para ser executado
				stmt.setString(1, nome); // coloca no primeiro ponto de interrogação o nome
				stmt.setInt(2, idade); // colocar no segundo ponto de interrogação a idade
				stmt.executeUpdate(); // executa o banco de dados com os novos
				
				System.out.println("Dados inseridos com sucesso."); // mensagem se a ação for executada sem nenhum erro
			} catch (SQLException e) {
				System.err.println("Erro ao inserir dados: " + e.getMessage()); // mensagem caso a execução apresente algum erro
			} finally {
				try {
					if(conexao != null) conexao.close(); // tenta fechar a conexão com o banco de dados se a informação for nula
				} catch (SQLException e) {
					System.err.println("Erro ao fechar conexao: " + e.getMessage()); // mensagem caso de algum erro na hora de fechar a conexão
				}
			}
		}
	}
}