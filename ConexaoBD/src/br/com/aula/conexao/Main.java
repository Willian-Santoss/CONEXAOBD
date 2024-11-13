package br.com.aula.conexao;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Connection conexao = ConexaoBD.conectar(); // método para conectar com o SQL do servidor Wamp
        Scanner scanner = new Scanner(System.in); // Cria um objeto Scanner para ler entradas do usuário.
        int escolherOpcao;
       
        do {
        	// estrutura do menu de opções
        	System.out.println("");
        	System.out.println("=== Menu Principal ===");
            System.out.println("1. Inserir Aluno");
            System.out.println("2. Atualizar Aluno");
            System.out.println("3. Deletar Aluno");
            System.out.println("4. Ler registro de Alunos");
            System.out.println("0. Sair");

            escolherOpcao = scanner.nextInt();
            scanner.nextLine(); // Consumir quebra de linha

            switch (escolherOpcao) {
                case 1:
                    InserirDados.main(null); // chama o método de inserção
                    break;
                case 2:
                    AtualizarDados.main(null); // chama o método de atualização
                    break;
                case 3:
                    DeletarDados.main(null); // chama o método de exclusão
                    break;
                case 4:
                    LerDados.main(null); // chama o método de leitura
                    break;
                case 0: // método para sair do sistema
                    System.out.println("Saindo do sistema..."); 
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente."); // mensagem caso a opção seja invalida
            }
        } while (escolherOpcao != 0);

        scanner.close();
    }
}
