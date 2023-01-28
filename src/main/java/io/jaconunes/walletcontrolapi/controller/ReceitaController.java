package io.jaconunes.walletcontrolapi.controller;

import io.jaconunes.walletcontrolapi.entities.Receita;
import io.jaconunes.walletcontrolapi.servive.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("receita")
public class ReceitaController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{id}")
    public ResponseEntity<Iterable<Receita>> buscarTodasReceitas(@PathVariable("id") Long id){
        return ResponseEntity.ok(usuarioService.buscarReceitas(id));
    }
}
