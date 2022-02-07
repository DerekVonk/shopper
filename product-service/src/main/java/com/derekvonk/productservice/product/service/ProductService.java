package com.derekvonk.productservice.product.service;

import com.derekvonk.productservice.product.model.Product;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface ProductService {

    Iterable<Product> findAll();

    List<Product> searchProductsBy(Specification<Product> specification);

    Product findById(Long productId);

    Product createProduct(Product product);

    void deleteProduct(Long productId);

    Product updateProduct(Product product, Long productId);

}
