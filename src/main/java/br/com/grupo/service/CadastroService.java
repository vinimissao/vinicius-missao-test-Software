package br.com.grupo.service;

import br.com.grupo.model.Cliente;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

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

            String nomeArquivo = c.getNome() + ".json";
            Path arquivo = pasta.resolve(nomeArquivo);

            mapper.writerWithDefaultPrettyPrinter().writeValue(arquivo.toFile(), c);
            System.out.println("Cliente salvo em: " + arquivo.toAbsolutePath());
        } catch (IOException e) {
            System.err.println("Erro ao salvar cliente: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
