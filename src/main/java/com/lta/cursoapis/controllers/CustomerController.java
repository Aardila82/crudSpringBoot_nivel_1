package com.lta.cursoapis.controllers;

import com.lta.cursoapis.domain.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@RestController
public class CustomerController {

    private List<Customer> customers = new ArrayList<>(Arrays.asList(
            new Customer(123, "Gerardo Lopez", "gerardol", "contrasena123"),
            new Customer(456, "Alejandra Garcia", "alejagarcia", "clave456"),
            new Customer(789, "Carlos Martinez", "carlosm", "clave789"),
            new Customer(234, "Laura Sanchez", "lauras", "clave234")
    ));

    @GetMapping("/clientes")
    public List<Customer> getCustomers(){
        return customers;
    }

    @GetMapping("/clientes/{username}")
    public Customer getCliente(@PathVariable String username){
        for(Customer c: customers){
            if(c.getUsername().equals(username)){
                return c;
            }

        }
        return null;
    }

    @PostMapping("/clientes")
    public Customer postCliente(@RequestBody Customer customer){
        customers.add(customer);
        return customer;
    }

    @PutMapping("/clientes")
    public Customer putCliente(@RequestBody Customer customer){
        for(Customer c:customers){
            if(c.getID() == customer.getID()){
                c.setName(customer.getName());
                c.setUsername(customer.getUsername());
                c.setPassword(customer.getPassword());

                return c;
            }
        }
        return null;
    }

    @DeleteMapping("/clientes/{id}")
    public Customer deleteCliente(@PathVariable int id){
        for(Customer c: customers){
            if(c.getID() == id){
                customers.remove(c);

                return c;
            }
        }
        return null;
    }


}
