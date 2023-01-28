package io.jaconunes.walletcontrolapi.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_despesa")
public class Despesa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "despesa_id")
    private Long id;
    @Column(name = "valor_despesa")
    private Double valor;
    @Column(name = "data_pagamento")
    private LocalDate dataPagamento;

    @Column(name = "data_pagamento_esperado")
    private LocalDate DataPagamentoEsperado;

    @Column(name = "tipo_despesa")
    private String tipoDespesa;
    @ManyToOne
    @JoinColumn(name = "conta_id")
    private Conta conta;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Despesa() {
    }

    public Despesa(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

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

    public String getTipoDespesa() {
        return tipoDespesa;
    }

    public void setTipoDespesa(String tipoDespesa) {
        this.tipoDespesa = tipoDespesa;
    }

    public LocalDate getDataPagamentoEsperado() {
        return DataPagamentoEsperado;
    }

    public void setDataPagamentoEsperado(LocalDate dataPagamentoEsperado) {
        DataPagamentoEsperado = dataPagamentoEsperado;
    }
}
