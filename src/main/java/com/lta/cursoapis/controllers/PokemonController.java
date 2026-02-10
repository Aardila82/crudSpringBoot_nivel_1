package com.lta.cursoapis.controllers;

import com.lta.cursoapis.domain.Pokemon;
import com.lta.cursoapis.service.PokemonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    private final PokemonService service;

    public PokemonController(PokemonService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Pokemon>>  getPokemon(){
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<Pokemon> createPokemon(@RequestBody Pokemon pokemon) {
        Pokemon created = service.create(pokemon);
        return ResponseEntity.status(201).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pokemon> updatePokemon(
            @PathVariable Integer id,
            @RequestBody Pokemon pokemon) {

        Pokemon updated = service.update(id, pokemon);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePokemon(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
