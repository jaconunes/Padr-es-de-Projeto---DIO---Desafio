package io.jaconunes.walletcontrolapi.controller;

import io.jaconunes.walletcontrolapi.entities.Conta;
import io.jaconunes.walletcontrolapi.entities.Receita;
import io.jaconunes.walletcontrolapi.servive.ReceitaService;
import io.jaconunes.walletcontrolapi.servive.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("receita")
public class ReceitaController {

    @Autowired
    private ReceitaService receitaService;

    @GetMapping
    public ResponseEntity<Iterable<Receita>> buscarTodasReceitas(){
        return ResponseEntity.ok(receitaService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Receita> buscarReceitaPorId(@PathVariable("id") Long id){
        return ResponseEntity.ok(receitaService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Receita> inserir(@RequestBody Receita receita){
        receitaService.inserir(receita);
        return ResponseEntity.ok(receita);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Receita> atualizar(@PathVariable("id") Long id, @RequestBody Receita receita){
        receitaService.atualizar(id, receita);
        return ResponseEntity.ok(receita);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Receita> deletar(@PathVariable("id") Long id){
        receitaService.deletar(id);
        return ResponseEntity.ok().build();
    }
}
