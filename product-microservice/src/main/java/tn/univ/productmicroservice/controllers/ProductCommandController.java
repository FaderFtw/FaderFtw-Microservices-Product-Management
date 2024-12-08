package tn.univ.productmicroservice.controllers;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.univ.productmicroservice.cqrs.commands.CreateProductCommand;
import tn.univ.productmicroservice.entities.Product;

import java.util.UUID;

@RestController
@RequestMapping("/api/products")
public class ProductCommandController {

    @Autowired
    private CommandGateway commandGateway;

    @PostMapping
    public String createProduct(@RequestBody Product product) {
        String id = UUID.randomUUID().toString();
        CreateProductCommand command = new CreateProductCommand(
                id, product.getName(), product.getPrice(), product.getDescription());
        commandGateway.sendAndWait(command);
        return id;
    }
}
