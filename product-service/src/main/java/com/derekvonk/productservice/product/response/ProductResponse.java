package com.derekvonk.productservice.product.response;

import com.derekvonk.productservice.product.model.Product;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductResponse {

    private final Long id;
    private final String name;
    private final String description;
    private final BigDecimal price;

    public ProductResponse(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
    }
    
}
