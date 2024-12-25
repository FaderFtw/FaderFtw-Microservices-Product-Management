package tn.univ.productmicroservice.cqrs.projections;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tn.univ.productmicroservice.entities.Product;
import tn.univ.productmicroservice.repositories.ProductRepository;
import tn.univ.productmicroservice.cqrs.queries.GetProductByIdQuery;

@Component
public class ProductProjection {

    @Autowired
    private ProductRepository productRepository;

    @QueryHandler
    public Product handle(GetProductByIdQuery query) {
        return productRepository.findById(query.getId()).orElse(null);
    }
}
