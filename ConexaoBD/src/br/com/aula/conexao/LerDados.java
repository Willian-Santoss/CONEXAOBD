package br.com.aula.conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LerDados {
    public static void main(String[] args) {
        Connection conexao = ConexaoBD.conectar(); // método para conectar com o SQL do servidor Wamp
        if (conexao != null) { // verifica se a conexão é diferente de nulo
            String sql = "SELECT * FROM alunos"; // código que vai no sql para selecionar a tabela alunos
            try {
                PreparedStatement stmt = conexao.prepareStatement(sql); // método para executar informações do sql
                ResultSet rs = stmt.executeQuery(); // método consultar e para armazenar os resultados do sql no objeti ResultSet
                
                // método para declarar as informações consultadas no sql aos parametros id, nome e idade
                System.out.println("Registros da tabela 'alunos':");
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nome = rs.getString("nome");
                    int idade = rs.getInt("idade");
                    
                    System.out.println("ID: " + id + ", Nome: " + nome + ", Idade: " + idade); // estrutura que vai ser apresentado as informações para o usuário
                }
            } catch (SQLException e) {
                System.err.println("Erro ao ler dados: " + e.getMessage()); // caso a leitura falhe exibe essa mensagem
            } finally { // bloco para garantir que sempre sexa executado o fechamento da conexão
                try {
                    if (conexao != null) conexao.close(); 
                } catch (SQLException e) {
                    System.err.println("Erro ao fechar conexão: " + e.getMessage());
                }
            }
        }
    }
}
