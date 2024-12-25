package tn.univ.productmicroservice.controllers;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.univ.productmicroservice.cqrs.commands.CreateProductCommand;
import tn.univ.productmicroservice.cqrs.queries.GetProductByIdQuery;
import tn.univ.productmicroservice.entities.Product;

import java.util.UUID;

@RestController
@RequestMapping("/api/products/cqrs")
public class ProductCommandController {

    @Autowired
    private CommandGateway commandGateway;

    @Autowired
    private QueryGateway queryGateway;

    @PostMapping
    public String createProduct(@RequestBody Product product) {
        String id = UUID.randomUUID().toString();
        CreateProductCommand command = new CreateProductCommand(
                id, product.getName(), product.getPrice(), product.getDescription());
        commandGateway.sendAndWait(command);
        return id;
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable String id) {
        GetProductByIdQuery query = new GetProductByIdQuery(id);
        return queryGateway.query(query, Product.class).join();
    }
}
