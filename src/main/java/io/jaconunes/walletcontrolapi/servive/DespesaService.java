package io.jaconunes.walletcontrolapi.servive;

import io.jaconunes.walletcontrolapi.entities.Despesa;


public interface DespesaService {

    Iterable<Despesa> buscarTodos();

    Despesa buscarPorId(Long id);

    void inserir(Despesa despesa);

    void atualizar(Long id, Despesa despesa);

    void deletar(Long id);
}
