package tn.univ.productmicroservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.univ.productmicroservice.entities.Product;

public interface ProductRepository extends JpaRepository<Product, String> {
}
