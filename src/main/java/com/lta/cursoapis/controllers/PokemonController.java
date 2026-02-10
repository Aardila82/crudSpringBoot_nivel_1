package com.lta.cursoapis.controllers;

import com.lta.cursoapis.domain.Pokemon;
import com.lta.cursoapis.service.PokemonService;
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
    public List<Pokemon> getPokemon(){
        return service.findAll();
    }

    @PostMapping
    public Pokemon createPokemon(@RequestBody Pokemon pokemon) {
        return service.create(pokemon);
    }

    @PutMapping("/{id}")
    public Pokemon updatePokemon(
            @PathVariable Integer id,
            @RequestBody Pokemon pokemon) {

        return service.update(id, pokemon);
    }

    @DeleteMapping("/{id}")
    public void deletePokemon(@PathVariable Integer id) {
        service.delete(id);
    }

}
