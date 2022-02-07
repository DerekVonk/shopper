package com.derekvonk.productservice.product.specification;

import com.derekvonk.productservice.product.model.Product;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ProductSpecification<T> implements Specification<T> {

    private final Product product;

    public ProductSpecification(Product product) {
        this.product = product;
    }

    @Override
    public Predicate toPredicate(@NotNull Root<T> root, @NotNull CriteriaQuery<?> query, @NotNull CriteriaBuilder criteriaBuilder) {
        // It's also possible to chain the ".equal" methods with ".and" or ".notNull"
        return criteriaBuilder.or(
                criteriaBuilder.like(root.get("name"), "%" + this.product.getName() + "%"),
                criteriaBuilder.like(root.get("description"), "%" + this.product.getDescription() + "%"),
                criteriaBuilder.equal(root.get("price"), this.product.getPrice())
        );
    }

}
