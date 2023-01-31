package io.jaconunes.walletcontrolapi.servive.impl;

import io.jaconunes.walletcontrolapi.entities.Conta;
import io.jaconunes.walletcontrolapi.entities.Despesa;
import io.jaconunes.walletcontrolapi.repository.ContaRepository;
import io.jaconunes.walletcontrolapi.repository.DespesaRepository;
import io.jaconunes.walletcontrolapi.servive.DespesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DespesaServiceImpl implements DespesaService {

    @Autowired
    private DespesaRepository despesaRepository;
    @Autowired
    private ContaRepository contaRepository;

    @Override
    public Iterable<Despesa> buscarTodos() {
        return despesaRepository.findAll();
    }

    @Override
    public Despesa buscarPorId(Long id) {
        Optional<Despesa> despesa = despesaRepository.findById(id);
        return despesa.get();
    }

    @Override
    public void inserir(Despesa despesa) {
        Optional<Conta> contaBd = contaRepository.findById(despesa.getConta().getId());
        contaBd.get().setSaldo(contaBd.get().getSaldo() - despesa.getValor());
        contaRepository.save(contaBd.get());
        despesaRepository.save(despesa);
    }

    @Override
    public void atualizar(Long id, Despesa despesa) {
        Optional<Despesa> despesaBd = despesaRepository.findById(id);
        if (despesaBd.isPresent()){
            despesaRepository.save(despesa);
        }

    }

    @Override
    public void deletar(Long id) {
        despesaRepository.deleteById(id);
    }
}
