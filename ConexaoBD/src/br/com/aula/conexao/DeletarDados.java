package br.com.aula.conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeletarDados {
    public static void main(String[] args) {
        Connection conexao = ConexaoBD.conectar(); // método para conectar com o SQL do servidor Wamp
        Scanner scanner = new Scanner(System.in); // cria um objeto Scanner para ler entradas do usuário
        if (conexao != null) {
            String sql = "DELETE FROM Alunos WHERE id = ?"; // método que vai ser utilizado no sql para deletar a linha que desejar
            System.out.print("Digite o ID do aluno que deseja deletar: ");
            int id = scanner.nextInt(); // método para o usuário digitar o id que deseja deletar
            try {
                PreparedStatement stmt = conexao.prepareStatement(sql); // consulta o código sql para ser executado
                stmt.setInt(1, id); // aplica o id ao ponto de interrogação na linha 'String sql'
                int rowsDeleted = stmt.executeUpdate(); // consulta a atualização no código sql para executar
                if (rowsDeleted > 0) { // método que verifica se a linha que houve a atualização de dados é maior que 0
                    System.out.println("Registro deletado com sucesso!"); // mensagem caso o registro seja deletado sem nenhum erro
                } else {
                    System.out.println("Nenhum registro encontrado com o ID especificado."); // mensagem caso o id selecionado não esteja registrado no banco de dados
                }
            } catch (SQLException e) {
                System.err.println("Erro ao deletar dados: " + e.getMessage()); // mensagem caso ocorra erro ao deletar os dados
            } finally {
                try {
                    if (conexao != null) conexao.close(); 
                } catch (SQLException c) {
                    System.err.println("Erro ao fechar conexão: " + c.getMessage());
                }
            }
        }
    }
}

