package ru.gb.perov.IntroSpringPart2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.gb.perov.IntroSpringPart2.Data.Product;

@Repository
public interface ProductRepositiry extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
    @Query("select min(p.price) from Product p")
    Double findMinPrice();

    @Query("select max(p.price) from Product p")
    Double findMaxPrice();
}
