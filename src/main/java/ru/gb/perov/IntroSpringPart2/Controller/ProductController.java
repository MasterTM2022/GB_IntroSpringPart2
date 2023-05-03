package ru.gb.perov.IntroSpringPart2.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.perov.IntroSpringPart2.Data.Product;
import ru.gb.perov.IntroSpringPart2.Service.ProductService;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")

public class ProductController {
    private final ProductService productService;

    @GetMapping("")
    public Page<Product> findAll(
            @RequestParam(name = "id", required = false) Long id,
            @RequestParam(name = "minPrice", required = false) Double minPrice,
            @RequestParam(name = "maxPrice", required = false) Double maxPrice,
            @RequestParam(name = "partTitle", required = false) String partTitle,
            @RequestParam(name = "page", required = false) Integer page) {
        if (page == null || page < 1) {
            page = 1;
        }
        return productService.findAll(id, minPrice, maxPrice, partTitle, page);
    }

//    @GetMapping("/{id}")
//    public List<ProductDTO> findById(@PathVariable Long id) {
//        return productService.findProductById(id).stream().filter(Optional::isPresent).map(p -> new ProductDTO(p.get())).collect(Collectors.toList());
//
//    }
//
//    @PostMapping("")
//    public void addProduct(@RequestParam String title, @RequestParam Double price) {
//        productService.addProduct(title, price);
//    }

    @GetMapping("/min-max")
    public List<Double> findFullIntervalPrice() {
        return productService.findFullIntervalPrice();
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<HttpStatus> deleteProductById(@PathVariable("id") Long id) {
//        if (productService.findProductById(id).size() == 0) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        } else {
//            productService.deleteById(id);
//
//            if (productService.findProductById(id).size() != 0) {
//                return new ResponseEntity<>(HttpStatus.CONFLICT);
//            } else {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//        }
//    }
//
//    @GetMapping("/{id}/add_to_cart")
//    public void addProductToCart(@PathVariable("id") Long id) {
//        productService.addProductToCart(id);
//    }

}