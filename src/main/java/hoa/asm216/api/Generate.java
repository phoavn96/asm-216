package hoa.asm216.api;

import hoa.asm216.entity.Account;
import hoa.asm216.entity.Product;
import hoa.asm216.repository.AccountRepository;
import hoa.asm216.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class Generate {


    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private ProductRepository productRepository;
    public PasswordEncoder bCryptPasswordEncoder(){return new BCryptPasswordEncoder();
    }
    @GetMapping
    public String generateData() {
        Account account1 = new Account();
        account1.setFullName("hoa");
        account1.setRole(1);
        account1.setStatus(1);
        account1.setUsername("hoaadmin");
        account1.setPasswordHash(bCryptPasswordEncoder().encode("12345bien"));
        accountRepository.save(account1);
        Account account2 = new Account();
        account2.setFullName("hoa");
        account2.setRole(2);
        account2.setStatus(0);
        account2.setUsername("hoauser");
        account2.setPasswordHash(bCryptPasswordEncoder().encode("123456"));
        accountRepository.save(account2);

        Product product1 = new Product();
        product1.setPrice(100000);
        product1.setName("product1");
        productRepository.save(product1);

        Product product2 = new Product();
        product2.setPrice(200000);
        product2.setName("product2");
        productRepository.save(product2);

        Product product3 = new Product();
        product3.setPrice(100000);
        product3.setName("product3");
        productRepository.save(product3);

        Product product4 = new Product();
        product4.setPrice(100000);
        product4.setName("product4");
        productRepository.save(product4);

        Product product5 = new Product();
        product5.setPrice(100000);
        product5.setName("product5");
        productRepository.save(product5);

        Product product6 = new Product();
        product6.setPrice(100000);
        product6.setName("product6");
        productRepository.save(product6);

        Product product7 = new Product();
        product7.setPrice(100000);
        product7.setName("product7");
        productRepository.save(product7);

        Product product8 = new Product();
        product8.setPrice(100000);
        product8.setName("product8");
        productRepository.save(product8);

        Product product9 = new Product();
        product9.setPrice(100000);
        product9.setName("product9");
        productRepository.save(product9);

        Product product10 = new Product();
        product10.setPrice(100000);
        product10.setName("product10");
        productRepository.save(product10);

        return "generate oki";

    }
}
