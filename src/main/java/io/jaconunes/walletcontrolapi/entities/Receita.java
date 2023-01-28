package io.jaconunes.walletcontrolapi.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_receita")
public class Receita {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "receita_id")
    private Long id;
    @Column(name = "valor_receita")
    private Double valor;

    @Column(name = "data_recebimento")
    private LocalDate dataRecebimento;

    @Column(name = "data_recebimento_esperado")
    private LocalDate dataRecebimentoEsperado;

    @Column(name = "descricao")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "conta_id")
    private Conta conta;

    @Column(name = "tipo_receita")
    private String tipoReceita;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Receita() {
    }

    public Receita(Usuario usuario) {
        this.usuario = usuario;
    }

    public Conta getConta() {
        return conta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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

    public LocalDate getDataRecebimento() {
        return dataRecebimento;
    }

    public void setDataRecebimento(LocalDate dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    public LocalDate getDataRecebimentoEsperado() {
        return dataRecebimentoEsperado;
    }

    public void setDataRecebimentoEsperado(LocalDate dataRecebimentoEsperado) {
        this.dataRecebimentoEsperado = dataRecebimentoEsperado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipoReceita() {
        return tipoReceita;
    }

    public void setTipoReceita(String tipoReceita) {
        this.tipoReceita = tipoReceita;
    }
}
