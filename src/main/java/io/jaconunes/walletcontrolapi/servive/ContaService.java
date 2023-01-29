package io.jaconunes.walletcontrolapi.servive;

import io.jaconunes.walletcontrolapi.entities.Conta;
import io.jaconunes.walletcontrolapi.entities.Usuario;


public interface ContaService {

    Iterable<Conta> buscarTodos();

    Conta buscarPorId(Long id);

    void inserir(Conta conta);

    void atualizar(Long id, Conta conta);

    void deletar(Long id);

    Conta cotacaoSaldo(Long id, String moeda);
}
