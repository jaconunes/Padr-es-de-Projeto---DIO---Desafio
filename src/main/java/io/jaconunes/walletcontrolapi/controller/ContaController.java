package io.jaconunes.walletcontrolapi.controller;

import io.jaconunes.walletcontrolapi.dto.Transferencia;
import io.jaconunes.walletcontrolapi.entities.Conta;
import io.jaconunes.walletcontrolapi.servive.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("conta")
public class ContaController {
    @Autowired
    private ContaService contaService;

    @GetMapping
    public ResponseEntity<Iterable<Conta>> buscarTodasContas(){
        return ResponseEntity.ok(contaService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conta> buscarContaPorId(@PathVariable("id") Long id){
        return ResponseEntity.ok(contaService.buscarPorId(id));
    }

    @GetMapping("/{id}/{moeda}")
    public ResponseEntity<Conta> consultarSaldoContaEmOutraMoeda(@PathVariable("id") Long id, @PathVariable("moeda") String moeda){
        return ResponseEntity.ok(contaService.cotacaoSaldo(id, moeda));
    }

    @PostMapping
    public ResponseEntity<Conta> inserir(@RequestBody Conta conta){
        contaService.inserir(conta);
        return ResponseEntity.ok(conta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Conta> atualizar(@PathVariable("id") Long id, @RequestBody Conta conta){
        contaService.atualizar(id, conta);
        return ResponseEntity.ok(conta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Conta> deletar(@PathVariable("id") Long id){
        contaService.deletar(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/transferencia")
    public ResponseEntity<Transferencia> transferir(@RequestBody Transferencia transferencia){
        contaService.transferir(transferencia);
        return ResponseEntity.ok().build();
    }
}
