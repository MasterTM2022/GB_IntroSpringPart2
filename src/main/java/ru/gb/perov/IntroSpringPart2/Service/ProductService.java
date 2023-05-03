package ru.gb.perov.IntroSpringPart2.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.gb.perov.IntroSpringPart2.Data.Product;
import ru.gb.perov.IntroSpringPart2.Repository.ProductRepositiry;

import java.util.ArrayList;
import java.util.List;

import static ru.gb.perov.IntroSpringPart2.Repository.Specifications.ProductsSpecifications.*;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepositiry productRepositiry;

    public Page<Product> findAll(Long id, Double minPrice, Double maxPrice, String partTitle, Integer page){
        Specification<Product> spec = Specification.where(null);
        if (id != null) {
            spec= spec.and(idEquals(id));
        }
        if (minPrice != null) {
            spec = spec.and(priceGreaterOrEqualsThan(minPrice));
        }
        if (maxPrice != null) {
            spec = spec.and(priceLesserOrEqualsThan(maxPrice));
        }
        if (partTitle != null) {
            spec = spec.and(titleLike(partTitle));
        }
        return productRepositiry.findAll(spec, PageRequest.of(page - 1, 25));
    }

    public List<Double> findFullIntervalPrice() {
        ArrayList<Double> interval = new ArrayList<>();
        interval.add(0, productRepositiry.findMinPrice());
        interval.add(1, productRepositiry.findMaxPrice());
        return interval;
    }
}
