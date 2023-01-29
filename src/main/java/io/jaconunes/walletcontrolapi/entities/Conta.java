package io.jaconunes.walletcontrolapi.entities;

import io.jaconunes.walletcontrolapi.servive.ContaService;
import io.jaconunes.walletcontrolapi.servive.Moedas;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_conta")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "conta_id")
    private Long id;
    @Column(name = "saldo_conta")
    private Double saldo;
    @Column(name = "tipo_conta")
    private String tipo;
    @Column(name = "instituicao_financeira")
    private String instituicaoFinanceira;

    @Column(name = "tipo_moeda")
    private String tipoMoeda = String.valueOf(Moedas.BRL);

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Conta() {
    }

    public Conta(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getTipoMoeda() {
        return tipoMoeda;
    }

    public void setTipoMoeda(String tipoMoeda) {
        this.tipoMoeda = tipoMoeda;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getInstituicaoFinanceira() {
        return instituicaoFinanceira;
    }

    public void setInstituicaoFinanceira(String instituicaoFinanceira) {
        this.instituicaoFinanceira = instituicaoFinanceira;
    }
}
