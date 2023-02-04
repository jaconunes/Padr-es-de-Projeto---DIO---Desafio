package io.jaconunes.walletcontrolapi.servive.impl;

import io.jaconunes.walletcontrolapi.entities.Conta;
import io.jaconunes.walletcontrolapi.entities.Despesa;
import io.jaconunes.walletcontrolapi.entities.Receita;
import io.jaconunes.walletcontrolapi.entities.Usuario;
import io.jaconunes.walletcontrolapi.handler.BusinessException;
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
        if(usuarioRepository.findAll().isEmpty()){
            throw new BusinessException("Não há itens para serem listados!");
        }
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario buscarPorId(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if(usuario.isEmpty()){
            throw new BusinessException("O usuário informado não foi encontrado!");
        }
        return usuario.get();
    }

    @Override
    public void inserir(Usuario usuario) {
        if(usuario.getNome() == null || usuario.getUsername() == null)
            throw new BusinessException("Os campos nome e usuário são obrigatórios!");
        usuarioRepository.save(usuario);
    }

    @Override
    public void atualizar(Long id, Usuario usuario) {
        Optional<Usuario> usuarioBd = usuarioRepository.findById(id);
        if (usuarioBd.isPresent()){
            usuarioRepository.save(usuario);
        } else {
            throw new BusinessException("O usuário informado não foi encontrado!");
        }
    }

    @Override
    public void deletar(Long id) {
        usuarioRepository.deleteById(id);
    }
}
