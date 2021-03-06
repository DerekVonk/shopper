package com.derekvonk.productservice.product.service;

import com.derekvonk.productservice.product.persistence.ProductRepository;
import com.derekvonk.productservice.product.exceptions.ProductNotFoundException;
import com.derekvonk.productservice.product.model.Product;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository repository;

    @Override
    public Iterable<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Product> searchProductsBy(Specification<Product> specification) {
        return repository.findAll(specification);
    }

    @Override
    public Product findById(Long productId) {
        Optional<Product> byId = repository.findById(productId);
        return Optional.of(byId.get())
                .orElseThrow(() -> new ProductNotFoundException("Product not found. ID: " + productId));
    }

    @Override
    public Product createProduct(Product product) {
        return repository.save(product);
    }

    @Override
    public void deleteProduct(Long productId) {
        repository.deleteById(productId);
    }

    @Override
    public Product updateProduct(Product product, Long productId) {
        Preconditions.checkNotNull(product);
        Preconditions.checkState(product.getId() == productId);
        Preconditions.checkNotNull(repository.findById(productId).get());
        return repository.save(product);
    }
}
