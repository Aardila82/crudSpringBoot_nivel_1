package com.lta.cursoapis.controllers;

import com.lta.cursoapis.domain.Product;
import com.lta.cursoapis.service.ProductService;
import com.lta.cursoapis.service.ProductsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductController {

    //Instancia de clase
    //ProductService productsService = new ProductsServiceImpl();
    @Autowired
    private ProductService productsService;

    @GetMapping
    public ResponseEntity<?> getProducts(){
        List<Product> products = productsService.getProducts();

        return ResponseEntity.ok(products);

    }

}
