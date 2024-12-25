package tn.univ.productmicroservice.cqrs.handlers;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tn.univ.productmicroservice.cqrs.events.ProductCreatedEvent;
import tn.univ.productmicroservice.entities.Product;
import tn.univ.productmicroservice.repositories.ProductRepository;

@Component
public class ProductEventHandler {

    private final ProductRepository productRepository;

    @Autowired
    public ProductEventHandler(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @EventHandler
    public void on(ProductCreatedEvent event) {
        Product product = new Product(
                event.getId(),
                event.getName(),
                event.getPrice(),
                event.getDescription()
        );
        productRepository.save(product);
        System.out.println("Product created and saved to DB: " + product.getId());
    }
}
