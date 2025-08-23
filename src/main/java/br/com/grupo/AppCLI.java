package br.com.grupo;

import br.com.grupo.model.Cliente;
import br.com.grupo.service.CadastroService;

import java.nio.file.Path;
import java.util.Scanner;

public class AppCLI {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        CadastroService svc = new CadastroService(Path.of("data"));

        while (true) {
            System.out.println("\n== MENU ==");
            System.out.println("1) Cadastrar");
            System.out.println("0) Sair");
            String op = sc.nextLine();

            switch (op) {
                case "1" -> cadastrar(svc);
                case "0" -> {
                    System.out.println("Tchau!");
                    return;
                }
                default -> System.out.println("Opção inválida");
            }
        }
    }

    private static void cadastrar(CadastroService svc) {
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Telefone: ");
        String tel = sc.nextLine();
        System.out.print("Senha: ");
        String senha = sc.nextLine();

        // Cria cliente sem ID
        Cliente c = new Cliente(nome, email, tel, senha);
        svc.cadastrar(c);

        System.out.println("Cadastro realizado com sucesso!");
    }
}
