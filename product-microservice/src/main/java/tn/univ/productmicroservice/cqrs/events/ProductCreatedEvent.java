package tn.univ.productmicroservice.cqrs.events;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductCreatedEvent {
    private final String id;
    private final String name;
    private final String description;
    private final double price;
}
