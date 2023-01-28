package io.jaconunes.walletcontrolapi.entities;


import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "tb_usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "usuario_id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "username")
    private String username;

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

}
