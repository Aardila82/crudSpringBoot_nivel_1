package com.lta.cursoapis.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_pokemons")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pokemon {



    @Id
    @Column(name = "pokemonid")
    private int pokemonid;

    @Column(name = "ataque")
    private int ataque;

    @Column(name = "defensa")
    private int defensa;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "tipo")
    private String tipo;
}
