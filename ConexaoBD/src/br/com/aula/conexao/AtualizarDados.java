package br.com.aula.conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AtualizarDados { //Classe principal
    public static void main(String[] args) {
        Connection conexao = ConexaoBD.conectar(); // método para conectar com o SQL do servidor Wamp
        Scanner scanner = new Scanner(System.in); // cria um objeto Scanner para ler entradas do usuário
        if (conexao != null) { 
            String sql = "UPDATE alunos SET nome = ?, idade = ? WHERE id = ?"; // campos que as informações serão inseridas no sql
            try {
            	//métodos para solicitar o id da lista de alunos que o usuário deseja atualizar, digitar o novo nome do aluno e a nova idade do aluno
                System.out.print("Digite o ID do aluno que deseja atualizar: ");
                int id = scanner.nextInt();
                scanner.nextLine(); // Consumir quebra de linha
                
                System.out.print("Digite o novo nome do aluno: ");
                String nome = scanner.nextLine();
                
                System.out.print("Digite a nova idade do aluno: ");
                int idade = scanner.nextInt();
                
                PreparedStatement stmt = conexao.prepareStatement(sql);
                stmt.setString(1, nome); //coloca o novo nome no primeiro ponto de interrogação na linha 'String sql'
                stmt.setInt(2, idade); //coloca a nova idade no segundo ponto de interrogação na linha 'String sql'
                stmt.setInt(3, id); //coloca o id no terceiro ponto de interrogação na linha 'String sql'
                
                int rowsUpdated = stmt.executeUpdate(); // consulta a atualização no código sql para executar
                
                if (rowsUpdated > 0) { // método que verifica se a linha que houve a atualização de dados é maior que 0
                    System.out.println("Registro atualizado com sucesso!"); // mensagem se o registro for atualizado sem nenhuma falha
                } else {
                    System.out.println("Nenhum registro encontrado com o ID especificado."); // mensagem caso o ID não esteja cadastrado no banco de dados
                }
            } catch (SQLException e) {
                System.err.println("Erro ao atualizar dados: " + e.getMessage()); // mensagem caso aconteça algum erro quando for atualizar os dados
            } finally {
                try {
                    if (conexao != null) conexao.close();
                } catch (SQLException e) {
                    System.err.println("Erro ao fechar conexão: " + e.getMessage()); 
                }
                
            }
        }
    }
}
