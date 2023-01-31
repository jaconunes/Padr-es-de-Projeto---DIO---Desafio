package io.jaconunes.walletcontrolapi.servive.impl;

import io.jaconunes.walletcontrolapi.dto.Transferencia;
import io.jaconunes.walletcontrolapi.entities.Conta;
import io.jaconunes.walletcontrolapi.entities.Moeda;
import io.jaconunes.walletcontrolapi.repository.ContaRepository;
import io.jaconunes.walletcontrolapi.servive.ContaService;
import io.jaconunes.walletcontrolapi.servive.ConversorMoedaService;
import io.jaconunes.walletcontrolapi.servive.Moedas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Override
    public void transferir(Transferencia transferencia) {
        Optional<Conta> contaDestino = contaRepository.findById(transferencia.getIdContaDestino());
        Optional<Conta> contaOrigem = contaRepository.findById(transferencia.getIdContaOrigem());

        contaOrigem.get().setSaldo(contaOrigem.get().getSaldo() - transferencia.getSaldoATransferir());
        contaRepository.save(contaOrigem.get());
        contaDestino.get().setSaldo(contaDestino.get().getSaldo() + transferencia.getSaldoATransferir());
        contaRepository.save(contaDestino.get());
    }

    @Override
    public Conta cotacaoSaldo(Long id, String moeda) {
        Optional<Conta> contaBd = contaRepository.findById(id);
        ArrayList<Moeda> moedas = conversorMoedaService.consultarMoeda(moeda);
        Double saldo = null;
        if(contaBd.isPresent()){
            saldo = contaBd.get().getSaldo() * Double.parseDouble(moedas.get(0).getHigh());
        }
        contaBd.get().setSaldo(saldo);
        return contaBd.get();
    }
}
