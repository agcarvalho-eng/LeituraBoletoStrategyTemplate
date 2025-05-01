package org.example.leituraboletostrategytemplate.utils;

import org.example.leituraboletostrategytemplate.model.Boleto;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Implementação do processador de boletos do Bradesco.
 * Assume que o formato da linha inclui agência e conta.
 */
public class LeituraRetornoBradesco extends ProcessadorBoletos {

    @Override
    protected Boleto processarLinhaArquivo(String[] vetorLinhaArq) {
        Boleto boleto = new Boleto();
        boleto.setId(Integer.parseInt(vetorLinhaArq[0]));
        boleto.setCodBanco(vetorLinhaArq[1]);
        boleto.setAgencia(vetorLinhaArq[2]);
        boleto.setContaBancaria(vetorLinhaArq[3]);
        // Converte a string da data de vencimento para LocalDate usando o formato de data definido na interface
        boleto.setDataVencimento(LocalDate.parse(vetorLinhaArq[4], FORMATO_DATA));
        // Converte a string da data de pagamento para LocalDateTime usando o formato de data e hora
        boleto.setDataPagamento(LocalDateTime.parse(vetorLinhaArq[5], FORMATO_DATA_HORA));
        boleto.setCpfCliente(vetorLinhaArq[6]); // CPF do cliente
        boleto.setValor(Double.parseDouble(vetorLinhaArq[7]));
        boleto.setMulta(Double.parseDouble(vetorLinhaArq[8]));
        boleto.setJuros(Double.parseDouble(vetorLinhaArq[9]));
        return boleto;
    }
}

