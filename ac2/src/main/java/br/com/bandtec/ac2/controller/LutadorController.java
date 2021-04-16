package br.com.bandtec.ac2.controller;

import br.com.bandtec.ac2.domain.Lutador;
import br.com.bandtec.ac2.repository.LutadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lutadores")
public class LutadorController {

    @Autowired
    private LutadorRepository repository;

    @PostMapping
    public ResponseEntity postLutador(@RequestBody @Valid Lutador novoLutador){
        repository.save(novoLutador);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/lutadores")
    public ResponseEntity getLutadores(){
        return ResponseEntity.status(200).body(repository.findAllByOrderByForcaGolpeDesc());
    }

    @GetMapping("lutadores/contagem-vivos")
    public ResponseEntity getLutadoresVivos(){
        return ResponseEntity.status(200).body(repository.countAllByVivoIsTrue());
    }

    @PostMapping("lutadores/{id}/concentrar")
    public ResponseEntity postConcentrar(@PathVariable Integer id){
        if (!repository.existsById(id))
            return ResponseEntity.status(404).build();

        Lutador lutador = repository.getOne(id);
        if (!lutador.concentrar()){
            return ResponseEntity.status(400).body("Lutador já se concentrou 3 vezes!");
        }else
            return  ResponseEntity.status(200).build();
    }


    @GetMapping("lutadores/contagem-mortos")
    public ResponseEntity getLutadoresMortos(){
        return ResponseEntity.status(200).body(repository.countAllByVivoIsFalse());
    }




}
