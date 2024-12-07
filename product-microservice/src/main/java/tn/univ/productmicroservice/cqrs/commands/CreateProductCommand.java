package tn.univ.productmicroservice.cqrs.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateProductCommand {
    @TargetAggregateIdentifier
    private final String id;
    private final String name;
    private final double price;
    private final String description;
}
