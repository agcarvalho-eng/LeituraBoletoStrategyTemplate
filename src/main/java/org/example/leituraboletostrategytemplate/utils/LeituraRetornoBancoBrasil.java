package org.example.leituraboletostrategytemplate.utils;

import org.example.leituraboletostrategytemplate.model.Boleto;

import java.time.LocalDate;

/**
 * Implementação do processador de boletos do Banco do Brasil.
 */
public class LeituraRetornoBancoBrasil extends ProcessadorBoletos {

    @Override
    protected Boleto processarLinhaArquivo(String[] vetorLinhaArq) {
        Boleto boleto = new Boleto();
        boleto.setId(Integer.parseInt(vetorLinhaArq[0]));
        boleto.setCodBanco(vetorLinhaArq[1]);
        boleto.setDataVencimento(LocalDate.parse(vetorLinhaArq[2], FORMATO_DATA));
        boleto.setDataPagamento(LocalDate.parse(vetorLinhaArq[3], FORMATO_DATA).atTime(0, 0, 0));
        boleto.setCpfCliente(vetorLinhaArq[4]);
        boleto.setValor(Double.parseDouble(vetorLinhaArq[5]));
        boleto.setMulta(Double.parseDouble(vetorLinhaArq[6]));
        boleto.setJuros(Double.parseDouble(vetorLinhaArq[7]));
        return boleto;
    }
}

