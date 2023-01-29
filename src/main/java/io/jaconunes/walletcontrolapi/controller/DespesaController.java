package io.jaconunes.walletcontrolapi.controller;

import io.jaconunes.walletcontrolapi.entities.Despesa;
import io.jaconunes.walletcontrolapi.servive.DespesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("despesa")
public class DespesaController {
    @Autowired
    private DespesaService despesaService;

    @GetMapping
    public ResponseEntity<Iterable<Despesa>> buscarTodasDespesas(){
        return ResponseEntity.ok(despesaService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Despesa> buscarDespesaPorId(@PathVariable("id") Long id){
        return ResponseEntity.ok(despesaService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Despesa> inserir(@RequestBody Despesa despesa){
        despesaService.inserir(despesa);
        return ResponseEntity.ok(despesa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Despesa> atualizar(@PathVariable("id") Long id, @RequestBody Despesa despesa){
        despesaService.atualizar(id, despesa);
        return ResponseEntity.ok(despesa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Despesa> deletar(@PathVariable("id") Long id){
        despesaService.deletar(id);
        return ResponseEntity.ok().build();
    }
}
