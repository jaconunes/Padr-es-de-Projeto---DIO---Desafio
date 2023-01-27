package io.jaconunes.walletcontrolapi.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Set;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String username;
    private Set<Conta> contas;
    private Set<Receita> receitas;
    private Set<Despesa> despesas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Conta> getContas() {
        return contas;
    }

    public void setContas(Set<Conta> contas) {
        this.contas = contas;
    }

    public Set<Receita> getReceitas() {
        return receitas;
    }

    public void setReceitas(Set<Receita> receitas) {
        this.receitas = receitas;
    }

    public Set<Despesa> getDespesas() {
        return despesas;
    }

    public void setDespesas(Set<Despesa> despesas) {
        this.despesas = despesas;
    }
}
