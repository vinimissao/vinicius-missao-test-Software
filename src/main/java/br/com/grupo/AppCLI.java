package br.com.grupo;

import br.com.grupo.model.Cliente;
import br.com.grupo.service.CadastroService;

import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class AppCLI {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        CadastroService svc = new CadastroService(Path.of("data"));

        while (true) {
            System.out.println("\n== MENU ==");
            System.out.println("1) Cadastrar");
            System.out.println("2) Listar");
            System.out.println("3) Editar");
            System.out.println("4) Excluir");
            System.out.println("0) Sair");
            System.out.print("Escolha uma opção: ");
            String op = sc.nextLine();

            switch (op) {
                case "1" -> cadastrar(svc);
                case "2" -> listar(svc);
                case "3" -> editar(svc);
                case "4" -> excluir(svc);
                case "0" -> {
                    System.out.println("Tchau!");
                    return;
                }
                default -> System.out.println("Opção inválida");
            }
        }
    }

    private static void cadastrar(CadastroService svc) {
        Cliente c = lerDadosCliente();
        svc.cadastrar(c);
        System.out.println("Cadastro realizado com sucesso!");
    }

    private static void listar(CadastroService svc) {
        List<Cliente> clientes = svc.listar();
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            System.out.println("\n== Lista de Clientes ==");
            for (Cliente c : clientes) {
                System.out.println("- Nome: " + c.getNome()
                        + " | Email: " + c.getEmail()
                        + " | Telefone: " + c.getTelefone());
            }
        }
    }

    private static void editar(CadastroService svc) {
        System.out.print("Digite o nome do cliente a editar: ");
        String nome = sc.nextLine();

        System.out.println("Informe os novos dados:");
        Cliente c = lerDadosCliente();
        c.setNome(nome);

        svc.editar(c);
    }

    private static void excluir(CadastroService svc) {
        System.out.print("Digite o nome do cliente a excluir: ");
        String nome = sc.nextLine();
        svc.excluir(nome);
    }

    private static Cliente lerDadosCliente() {
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Telefone: ");
        String tel = sc.nextLine();
        System.out.print("Senha: ");
        String senha = sc.nextLine();

        return new Cliente(nome, email, tel, senha);
    }
}
