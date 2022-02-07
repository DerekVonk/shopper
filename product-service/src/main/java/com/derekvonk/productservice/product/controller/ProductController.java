package com.derekvonk.productservice.product.controller;

import com.derekvonk.productservice.product.model.Product;
import com.derekvonk.productservice.product.request.ProductSearchRequest;
import com.derekvonk.productservice.product.response.ProductResponse;
import com.derekvonk.productservice.product.service.ProductService;
import com.derekvonk.productservice.product.specification.ProductSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public Iterable<Product> getAllProducts() {
        return productService.findAll();
    }

    @PostMapping("/searchBy")
    public ResponseEntity searchProducts(ProductSearchRequest request) {
        ProductSpecification spec = new ProductSpecification(request.toProduct());

        List products = Collections.singletonList(StreamSupport
                .stream(this.productService.searchProductsBy(spec).spliterator(), false)
                .map(p -> new ProductResponse((Product) p))
                .collect(Collectors.toList()));

        return new ResponseEntity(products, HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    public Product findProductById(@PathVariable Long productId) {
        return productService.findById(productId);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @DeleteMapping("/{productId}")
    public void deleteRating(@PathVariable Long productId) {
        productService.deleteProduct(productId);
    }

    @PutMapping("/{productId}")
    public Product updateRating(@RequestBody Product product, @PathVariable Long productId) {
        return productService.updateProduct(product, productId);
    }

}