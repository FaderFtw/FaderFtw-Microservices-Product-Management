package tn.univ.productmicroservice.cqrs.queries;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetProductByIdQuery {
    private final String id;
}
