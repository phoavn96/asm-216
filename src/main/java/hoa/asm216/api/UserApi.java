package hoa.asm216.api;

import hoa.asm216.entity.Account;
import hoa.asm216.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/user")
public class UserApi {
    @Autowired
    private AccountRepository accountRepository;
    @GetMapping
    public Optional<Account> infor(@RequestParam() int id){
        return  accountRepository.findById(id);

    }
}
