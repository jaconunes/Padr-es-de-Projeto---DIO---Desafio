package io.jaconunes.walletcontrolapi.servive.impl;

import io.jaconunes.walletcontrolapi.entities.Conta;
import io.jaconunes.walletcontrolapi.entities.Despesa;
import io.jaconunes.walletcontrolapi.entities.Receita;
import io.jaconunes.walletcontrolapi.entities.Usuario;
import io.jaconunes.walletcontrolapi.repository.ContaRepository;
import io.jaconunes.walletcontrolapi.repository.DespesaRepository;
import io.jaconunes.walletcontrolapi.repository.ReceitaRepository;
import io.jaconunes.walletcontrolapi.repository.UsuarioRepository;
import io.jaconunes.walletcontrolapi.servive.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private DespesaRepository despesaRepository;
    @Autowired
    private ReceitaRepository receitaRepository;
    @Autowired
    private ContaRepository contaRepository;

    @Override
    public Iterable<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario buscarPorId(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.get();
    }

    @Override
    public void inserir(Usuario cliente) {
        usuarioRepository.save(cliente);
    }

    @Override
    public void atualizar(Long id, Usuario usuario) {
        Optional<Usuario> usuarioBd = usuarioRepository.findById(id);
        if (usuarioBd.isPresent()){
            usuarioRepository.save(usuario);
        }

    }

    @Override
    public void deletar(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public Set<Despesa> buscarDespesas(Long userId) {
        return despesaRepository.findDespesaByUserId(userId);
    }

    @Override
    public Set<Receita> buscarReceitas(Long userId) {
        return receitaRepository.findReceitaByUserId(userId);
    }

    @Override
    public Set<Conta> buscarContas(Long userId) {
        return contaRepository.findContaByUserId(userId);
    }
}
