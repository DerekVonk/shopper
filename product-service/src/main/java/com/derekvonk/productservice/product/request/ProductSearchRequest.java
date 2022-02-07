package com.derekvonk.productservice.product.request;

import com.derekvonk.productservice.product.model.Product;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductSearchRequest {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;

    public Product toProduct() {
        Product product = new Product();

        product.setName(this.name);
        product.setDescription(this.description);
        product.setPrice(this.price);

        if(this.id != null) {
            product.setId(this.id);
        }

        return product;
    }

}
