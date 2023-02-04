package io.jaconunes.walletcontrolapi.servive.impl;

import io.jaconunes.walletcontrolapi.entities.Conta;
import io.jaconunes.walletcontrolapi.entities.Receita;
import io.jaconunes.walletcontrolapi.handler.BusinessException;
import io.jaconunes.walletcontrolapi.repository.ContaRepository;
import io.jaconunes.walletcontrolapi.repository.ReceitaRepository;
import io.jaconunes.walletcontrolapi.servive.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReceitaServiceImpl implements ReceitaService {

    @Autowired
    private ReceitaRepository receitaRepository;
    @Autowired
    private ContaRepository contaRepository;

    @Override
    public Iterable<Receita> buscarTodos() {
        if(receitaRepository.findAll().isEmpty()){
            throw new BusinessException("Não há itens para serem listados!");
        }
        return receitaRepository.findAll();
    }

    @Override
    public Receita buscarPorId(Long id) {
        Optional<Receita> receita = receitaRepository.findById(id);
        if(receita.isEmpty()){
            throw new BusinessException("A receita informada não foi encontrada!");
        }
        return receita.get();
    }

    @Override
    public void inserir(Receita receita) {
        Optional<Conta> contaBd = contaRepository.findById(receita.getConta().getId());
        if(contaBd.isEmpty()){
            throw new BusinessException("A conta informada não foi encontrada!");
        }
        contaBd.get().setSaldo(receita.getValor() + contaBd.get().getSaldo());
        contaRepository.save(contaBd.get());
        receitaRepository.save(receita);
    }

    @Override
    public void atualizar(Long id, Receita receita) {
        Optional<Receita> receitaBd = receitaRepository.findById(id);
        if (receitaBd.isPresent()){
            receitaRepository.save(receita);
        } else {
            throw new BusinessException("A receita informada não foi encontrada!");
        }

    }

    @Override
    public void deletar(Long id) {
        receitaRepository.deleteById(id);
    }
}
