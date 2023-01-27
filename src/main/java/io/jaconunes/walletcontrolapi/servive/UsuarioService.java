package io.jaconunes.walletcontrolapi.servive;

import io.jaconunes.walletcontrolapi.entities.Usuario;

public interface UsuarioService {

    Iterable<Usuario> buscarTodos();

    Usuario buscarPorId(Long id);

    void inserir(Usuario cliente);

    void atualizar(Long id, Usuario usuario);

    void deletar(Long id);

}
