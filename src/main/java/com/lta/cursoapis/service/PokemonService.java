package com.lta.cursoapis.service;

import com.lta.cursoapis.domain.Pokemon;
import com.lta.cursoapis.repository.PokemonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonService {

    private final PokemonRepository repository;

    public PokemonService(PokemonRepository repository) {
        this.repository = repository;
    }

    public List<Pokemon> findAll(){
        return repository.findAll();
    }

    public Pokemon create(Pokemon pokemon) {
        return repository.save(pokemon);
    }

    public Pokemon update(Integer id, Pokemon pokemon) {
        Pokemon existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pokemon no encontrado"));

        existing.setAtaque(pokemon.getAtaque());
        existing.setDefensa(pokemon.getDefensa());
        existing.setNombre(pokemon.getNombre());
        existing.setTipo(pokemon.getTipo());

        return repository.save(existing);
    }

    public void delete(Integer id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Pokemon no encontrado");
        }
        repository.deleteById(id);
    }
}
