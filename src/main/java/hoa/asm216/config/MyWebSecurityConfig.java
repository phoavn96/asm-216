package hoa.asm216.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {

    public PasswordEncoder bCryptPasswordEncoder(){return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsServiceBean() throws Exception {
//        User.UserBuilder users = User.withDefaultPasswordEncoder();
//        InMemoryUserDetailsManager manager= new InMemoryUserDetailsManager();
//        manager.createUser(users.username("user").password("12345bien").roles("USER").build());
//        manager.createUser(users.username("admin").password("12345bien").roles("USER","ADMIN").build());
//        return manager;

        return new MyUserDetailService();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http

        .authorizeRequests()
        .antMatchers("/").permitAll()

                .antMatchers("/user").hasAnyRole("1","2")
        .antMatchers("/products").hasAnyRole("1")
        .anyRequest().authenticated()
         .and()
//        .addFilterBefore(new CaptchaCaptureFilter(), UsernamePasswordAuthenticationFilter.class)
        .formLogin()
//         .usernameParameter("username")
//         .passwordParameter("password")
          .loginPage("/login")
//          .loginProcessingUrl("/login").permitAll()
//                .defaultSuccessUrl("/successful-login")
//          .and()
//           .csrf().disable()


        ;
    }
}
