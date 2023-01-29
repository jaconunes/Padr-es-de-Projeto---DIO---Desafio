package io.jaconunes.walletcontrolapi.servive.impl;

import io.jaconunes.walletcontrolapi.entities.Receita;
import io.jaconunes.walletcontrolapi.repository.ReceitaRepository;
import io.jaconunes.walletcontrolapi.servive.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReceitaServiceImpl implements ReceitaService {

    @Autowired
    private ReceitaRepository receitaRepository;

    @Override
    public Iterable<Receita> buscarTodos() {
        return receitaRepository.findAll();
    }

    @Override
    public Receita buscarPorId(Long id) {
        Optional<Receita> receita = receitaRepository.findById(id);
        return receita.get();
    }

    @Override
    public void inserir(Receita receita) {
        receitaRepository.save(receita);
    }

    @Override
    public void atualizar(Long id, Receita receita) {
        Optional<Receita> receitaBd = receitaRepository.findById(id);
        if (receitaBd.isPresent()){
            receitaRepository.save(receita);
        }

    }

    @Override
    public void deletar(Long id) {
        receitaRepository.deleteById(id);
    }
}
