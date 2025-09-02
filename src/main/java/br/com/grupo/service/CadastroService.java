package br.com.grupo.service;

import br.com.grupo.model.Cliente;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CadastroService {

    private final ObjectMapper mapper = new ObjectMapper();
    private final Path pasta;

    public CadastroService(Path pasta) {
        this.pasta = pasta;

        try {
            Files.createDirectories(pasta);
        } catch (IOException e) {
            System.err.println("Erro ao criar pasta: " + e.getMessage());
        }
    }


    public void cadastrar(Cliente c) {
        try {

            String nomeArquivo = c.getNome()
                    .trim()
                    .replaceAll("\\s+", "_")
                    .replaceAll("[^a-zA-Z0-9_]", "")
                    .toLowerCase() + ".json";

            Path arquivo = pasta.resolve(nomeArquivo);

            mapper.writerWithDefaultPrettyPrinter().writeValue(arquivo.toFile(), c);
            System.out.println("Cliente salvo em: " + arquivo.toAbsolutePath());
        } catch (IOException e) {
            System.err.println("Erro ao salvar cliente: " + e.getMessage());
            e.printStackTrace();
        }
    }


    public List<Cliente> listar() {
        List<Cliente> clientes = new ArrayList<>();
        try {
            Files.list(pasta)
                    .filter(path -> path.toString().endsWith(".json"))
                    .forEach(path -> {
                        try {
                            Cliente c = mapper.readValue(path.toFile(), Cliente.class);
                            clientes.add(c);
                        } catch (IOException e) {
                            // Apenas loga uma vez, sem stacktrace
                            System.err.println("⚠ Arquivo ignorado: " + path.getFileName());
                        }
                    });
        } catch (IOException e) {
            System.err.println("Erro ao listar clientes: " + e.getMessage());
        }
        return clientes;
    }



    public boolean excluir(String nome) {
        try {
            Path arquivo = pasta.resolve(nome + ".json");
            if (Files.exists(arquivo)) {
                Files.delete(arquivo);
                System.out.println("Cliente " + nome + " excluído com sucesso.");
                return true;
            } else {
                System.err.println("Cliente " + nome + " não encontrado.");
            }
        } catch (IOException e) {
            System.err.println("Erro ao excluir cliente: " + e.getMessage());
        }
        return false;
    }

    public void editar(Cliente c) {
        try {
            String nomeArquivo = c.getNome() + ".json";
            Path arquivo = pasta.resolve(nomeArquivo);

            if (Files.exists(arquivo)) {
                mapper.writerWithDefaultPrettyPrinter().writeValue(arquivo.toFile(), c);
                System.out.println("Cliente atualizado em: " + arquivo.toAbsolutePath());
            } else {
                System.err.println("Cliente não encontrado para edição: " + nomeArquivo);
            }
        } catch (IOException e) {
            System.err.println("Erro ao editar cliente: " + e.getMessage());
        }
    }
}
