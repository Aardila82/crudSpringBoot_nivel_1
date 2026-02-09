package com.lta.cursoapis.controllers;

import com.lta.cursoapis.domain.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@RestController
@RequestMapping("/clientes")
public class CustomerController {

    private List<Customer> customers = new ArrayList<>(Arrays.asList(
            new Customer(123, "Gerardo Lopez", "gerardol", "contrasena123"),
            new Customer(456, "Alejandra Garcia", "alejagarcia", "clave456"),
            new Customer(789, "Carlos Martinez", "carlosm", "clave789"),
            new Customer(234, "Laura Sanchez", "lauras", "clave234")
    ));

    @GetMapping
    public ResponseEntity<List<?>>  getCustomers(){

        return ResponseEntity.ok(customers);
    }

    @GetMapping("/{username}")
    public ResponseEntity<?>  getCliente(@PathVariable String username){
        for(Customer c: customers){
            if(c.getUsername().equals(username)){

                return ResponseEntity.ok(c);
                //return c;
            }

        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado: " + username);
    }

    @PostMapping
    public ResponseEntity<?>  postCliente(@RequestBody Customer customer){
        customers.add(customer);

        URI location = ServletUriComponentsBuilder   //Consumir recursos de forma eficiente creando URI
                .fromCurrentRequest()
                .path("/{username}")
                .buildAndExpand(customer.getUsername())
                .toUri();

        return ResponseEntity.created(location).body(customer);

       // return ResponseEntity.created(location).build();

        //return ResponseEntity.status(HttpStatus.CREATED).body("Cliente creado Exitosamente " + customer.getUsername());
        //return customer;
    }

    @PutMapping
    public ResponseEntity<?>  putCliente(@RequestBody Customer customer){
        for(Customer c:customers){
            if(c.getId() == customer.getId()){
                c.setName(customer.getName());
                c.setUsername(customer.getUsername());
                c.setPassword(customer.getPassword());

                return ResponseEntity.noContent().build(); //Simplificar códigos de respuesta
               // return c;
            }
        }
        return ResponseEntity.notFound().build();// Simplificar código de respuesta
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>  deleteCliente(@PathVariable int id){
        for(Customer c: customers){
            if(c.getId() == id){
                customers.remove(c);

                return ResponseEntity.noContent().build();
                //return c;
            }
        }
        return ResponseEntity.notFound().build();
    }

    @PatchMapping
    public ResponseEntity<?>  patchCliente(@RequestBody Customer customer){
        for (Customer c: customers){
            if(c.getId() == customer.getId()){
                if(customer.getName() != null){
                    c.setName(customer.getName());
                }
                if(customer.getUsername() != null){
                    c.setUsername(customer.getUsername());
                }
                if(customer.getPassword() != null){
                    c.setPassword(customer.getPassword());
                }
                return ResponseEntity.ok("Cliente modificado satisfactoriamente " + customer.getId());
                //return c;
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado "+ customer.getId());
    }


}
