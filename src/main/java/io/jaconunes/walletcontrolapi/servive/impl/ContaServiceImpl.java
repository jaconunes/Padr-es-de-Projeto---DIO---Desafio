package io.jaconunes.walletcontrolapi.servive.impl;

import io.jaconunes.walletcontrolapi.entities.Conta;
import io.jaconunes.walletcontrolapi.entities.Moeda;
import io.jaconunes.walletcontrolapi.repository.ContaRepository;
import io.jaconunes.walletcontrolapi.servive.ContaService;
import io.jaconunes.walletcontrolapi.servive.ConversorMoedaService;
import io.jaconunes.walletcontrolapi.servive.Moedas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContaServiceImpl implements ContaService {

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private ConversorMoedaService conversorMoedaService;

    public ContaServiceImpl() {
    }

    @Override
    public Iterable<Conta> buscarTodos() {
        return contaRepository.findAll();
    }

    @Override
    public Conta buscarPorId(Long id) {
        Optional<Conta> conta = contaRepository.findById(id);
        return conta.get();
    }

    @Override
    public void inserir(Conta conta) {
        contaRepository.save(conta);
    }

    @Override
    public void atualizar(Long id, Conta conta) {
        Optional<Conta> contaBd = contaRepository.findById(id);
        if (contaBd.isPresent()){
            contaRepository.save(conta);
        }

    }

    @Override
    public void deletar(Long id) {
        contaRepository.deleteById(id);
    }
//
//    @Override
//    public Conta cotacaoSaldo(Long id, String moeda) {
//        Optional<Conta> contaBd = contaRepository.findById(id);
//        Moeda cotacao = conversorMoedaService.consultarMoeda(moeda);
//        Double saldo = null;
//        if(contaBd.isPresent()){
//            saldo = contaBd.get().getSaldo() * Double.parseDouble(cotacao.getHigh());
//
//        }
//        return contaBd.get().;
//    }
}
