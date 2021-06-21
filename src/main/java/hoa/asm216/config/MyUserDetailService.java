package hoa.asm216.config;


import hoa.asm216.entity.Account;
import hoa.asm216.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class MyUserDetailService implements UserDetailsService {
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //lay user
        //mapping
//        UserDetails userDetails = User.builder().
//                username()
//                .password()
//                .roles()
//                .build();
//        return userDetails;

        @Autowired
        private AccountRepository accountRepository;

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            Optional<Account> optionalAccount = accountRepository.findByUsername(username);
            if(optionalAccount.isPresent()){
                Account account = optionalAccount.get();
                UserDetails userDetails =
                        User.builder()
                                .username(account.getUsername())
                                .password(account.getPasswordHash())
                                .roles(String.valueOf(account.getRole()))
                                .build();
                return userDetails;
            }
            return null;
        }
    }

