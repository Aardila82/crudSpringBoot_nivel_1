package com.lta.cursoapis.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
/*
* Controlador para verifcar palíndromos
*/
@RestController
public class PalindromoController {

    /**
     * Endpoint para verificar si una palabra e un palíndromo
     * @param word la palabra a verificar
     * @return Un mensaje si es palíndromo o no
     */
    @GetMapping("/validar-palindromo/{word}")
    public String Palindrome(@PathVariable String word){
        if(isPalidrome(word)){
            return "La palabra " + word + " es un palindromo";
        }else {
            return "La palabra " + word + " NO es un palindromo";
        }
    }

    private boolean isPalidrome(String word){
        int length = word.length();
        for(int i = 0;i<length/2;i++){
            if(word.charAt(i) != word.charAt(length -i - 1)){
                return false;
            }

        }
        return true;
    }
}
