package com.derekvonk.productservice.product;

import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    Product findById(Long productId);

    Product createProduct(Product product);

    void deleteProduct(Long productId);

    Product updateProduct(Product product, Long productId);

}
