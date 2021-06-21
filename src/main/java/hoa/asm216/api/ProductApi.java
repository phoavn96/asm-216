package hoa.asm216.api;

import hoa.asm216.entity.Product;
import hoa.asm216.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products")
public class ProductApi {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public Iterable<Product> list(){

        return productRepository.findAll();
    }
}
