package org.example.leituraboletostrategytemplate.utils;

import org.example.leituraboletostrategytemplate.model.Boleto;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe abstrata que define o Template Method para processamento de arquivos de boletos.
 */
public abstract class ProcessadorBoletos {
    // Formato para datas como "15/04/2024"
    public static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    // Formato para data e hora como "15/04/2024 14:30:00"
    public static final DateTimeFormatter FORMATO_DATA_HORA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    /**
     * Template Method: Lê um arquivo linha a linha, processa cada linha e imprime os boletos.
     */
    public final List<Boleto> processar(URI nomeArquivo) {
        try {
            var listaLinhas = Files.readAllLines(Paths.get(nomeArquivo));
            var boletos = new ArrayList<Boleto>();
            for (String linha : listaLinhas) {
                String[] vetor = linha.split(",");
                var boleto = processarLinhaArquivo(vetor); // chamada ao método abstrato (hook)
                boletos.add(boleto);
                System.out.println(boleto); // imprime os dados formatados
            }
            return boletos;
        } catch (IOException ex) {
            throw new UncheckedIOException(ex);
        }
    }

    /**
     * Método abstrato que as subclasses devem implementar.
     * Define como processar uma única linha do arquivo.
     */
    protected abstract Boleto processarLinhaArquivo(String[] vetorLinhaArq);
}

