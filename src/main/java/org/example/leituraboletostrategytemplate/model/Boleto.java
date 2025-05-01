package org.example.leituraboletostrategytemplate.model;

import org.example.leituraboletostrategytemplate.utils.ProcessadorBoletos;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Classe que representa os dados de um boleto bancário.
 */
public class Boleto {
    // Identificador único do boleto
    private int id;
    // Código do banco emissor
    private String codBanco;
    // Data de vencimento do boleto
    private LocalDate dataVencimento;
    // Data e hora do pagamento
    private LocalDateTime dataPagamento;
    // CPF do cliente que pagou o boleto
    private String cpfCliente;
    // Valor original do boleto
    private double valor;
    // Valor da multa por atraso
    private double multa;
    // Valor dos juros
    private double juros;
    // Agência bancária
    private String agencia;
    // Conta bancária
    private String contaBancaria;

    // Getters e setters (autoexplicativos)
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getCodBanco() { return codBanco; }
    public void setCodBanco(String codBanco) { this.codBanco = codBanco; }

    public LocalDate getDataVencimento() { return dataVencimento; }
    public void setDataVencimento(LocalDate dataVencimento) { this.dataVencimento = dataVencimento; }

    public LocalDateTime getDataPagamento() { return dataPagamento; }
    public void setDataPagamento(LocalDateTime dataPagamento) { this.dataPagamento = dataPagamento; }

    public String getCpfCliente() { return cpfCliente; }
    public void setCpfCliente(String cpfCliente) { this.cpfCliente = cpfCliente; }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

    public double getMulta() { return multa; }
    public void setMulta(double multa) { this.multa = multa; }

    public double getJuros() { return juros; }
    public void setJuros(double juros) { this.juros = juros; }

    public String getAgencia() { return agencia; }
    public void setAgencia(String agencia) { this.agencia = agencia; }

    public String getContaBancaria() { return contaBancaria; }
    public void setContaBancaria(String contaBancaria) { this.contaBancaria = contaBancaria; }

    // Representa os dados do boleto como uma String formatada
    @Override
    public String toString() {
        String str = String.format("Id: %10d Banco: %3s", id, codBanco);
        String ag = "";
        if (agencia != null && !agencia.isEmpty() && contaBancaria != null && !contaBancaria.isEmpty()) {
            ag = String.format(" Ag: %6s CC: %10s", agencia, contaBancaria);
        }
        str += ag + String.format(
                " Venc: %s Pag: %s Valor: %10.2f",
                ProcessadorBoletos.FORMATO_DATA.format(dataVencimento),
                ProcessadorBoletos.FORMATO_DATA_HORA.format(dataPagamento), valor);
        if (multa > 0) {
            str += String.format(" Multa: %10.2f", multa);
        }
        if (juros > 0) {
            str += String.format(" Juros: %10.2f", juros);
        }
        return str;
    }
}
