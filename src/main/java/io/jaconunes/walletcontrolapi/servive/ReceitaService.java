package io.jaconunes.walletcontrolapi.servive;

import io.jaconunes.walletcontrolapi.entities.Receita;


public interface ReceitaService {

    Iterable<Receita> buscarTodos();

    Receita buscarPorId(Long id);

    void inserir(Receita receita);

    void atualizar(Long id, Receita receita);

    void deletar(Long id);
}
