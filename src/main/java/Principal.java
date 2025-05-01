import org.example.leituraboletostrategytemplate.utils.LeituraRetornoBradesco;
import org.example.leituraboletostrategytemplate.utils.ProcessadorBoletos;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Classe principal que executa a leitura do arquivo de boletos.
 */
public class Principal {
    public static void main(String[] args) throws URISyntaxException {
        // Altere aqui para BancoBrasil ou Bradesco conforme o arquivo
        ProcessadorBoletos processador = new LeituraRetornoBradesco(); // ou LeituraRetornoBancoBrasil

        // Nome do arquivo a ser lido (deve estar em resources ou mesmo diretório do projeto)
        URI nomeArquivo = Principal.class.getResource("bradesco-1.csv").toURI(); // ou banco-brasil-1.csv
        processador.processar(nomeArquivo);
    }
}

