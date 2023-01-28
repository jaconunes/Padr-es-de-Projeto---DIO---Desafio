package io.jaconunes.walletcontrolapi.servive;

import io.jaconunes.walletcontrolapi.entities.Conta;
import io.jaconunes.walletcontrolapi.entities.Despesa;
import io.jaconunes.walletcontrolapi.entities.Receita;
import io.jaconunes.walletcontrolapi.entities.Usuario;

import java.util.Set;

public interface UsuarioService {

    Iterable<Usuario> buscarTodos();

    Usuario buscarPorId(Long id);

    void inserir(Usuario cliente);

    void atualizar(Long id, Usuario usuario);

    void deletar(Long id);

    Set<Despesa> buscarDespesas(Long userId);

    Set<Receita> buscarReceitas(Long userId);

    Set<Conta> buscarContas(Long userId);
}
