package io.jaconunes.walletcontrolapi.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Despesa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JoinColumn(name = "id_despesa")
    private Long id;
    @JoinColumn(name = "valor_despesa")
    private Double valor;
    private LocalDate dataPagamento;
    private LocalDate getDataPagamentoEsperado;
    private String tipoDespesa;
    @ManyToOne
    @JoinColumn(name = "conta_id")
    private Conta conta;

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public LocalDate getGetDataPagamentoEsperado() {
        return getDataPagamentoEsperado;
    }

    public void setGetDataPagamentoEsperado(LocalDate getDataPagamentoEsperado) {
        this.getDataPagamentoEsperado = getDataPagamentoEsperado;
    }

    public String getTipoDespesa() {
        return tipoDespesa;
    }

    public void setTipoDespesa(String tipoDespesa) {
        this.tipoDespesa = tipoDespesa;
    }
}
