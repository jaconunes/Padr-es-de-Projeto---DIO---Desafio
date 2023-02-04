package io.jaconunes.walletcontrolapi.servive;

import io.jaconunes.walletcontrolapi.dto.Transferencia;
import io.jaconunes.walletcontrolapi.entities.Conta;


public interface ContaService {

    Iterable<Conta> buscarTodos();

    Conta buscarPorId(Long id);

    void inserir(Conta conta);

    void atualizar(Long id, Conta conta);

    void deletar(Long id);

    void transferir(Transferencia transferencia);

    Conta cotacaoSaldo(Long id, String moeda);
}
