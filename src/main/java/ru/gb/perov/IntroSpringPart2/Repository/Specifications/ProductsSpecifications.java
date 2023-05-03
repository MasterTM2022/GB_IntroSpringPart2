package ru.gb.perov.IntroSpringPart2.Repository.Specifications;

import org.springframework.data.jpa.domain.Specification;
import ru.gb.perov.IntroSpringPart2.Data.Product;

public class ProductsSpecifications {
    public static Specification<Product> idEquals(Long id) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("id"), id);
    }

        public static Specification<Product> priceGreaterOrEqualsThan(Double minPrice) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice);
    }

    public static Specification<Product> priceLesserOrEqualsThan(Double maxPrice) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice);
    }

    public static Specification<Product> titleLike(String titlePart) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.like(root.get("title"), String.format("%%%s%%", titlePart));
    }
}
