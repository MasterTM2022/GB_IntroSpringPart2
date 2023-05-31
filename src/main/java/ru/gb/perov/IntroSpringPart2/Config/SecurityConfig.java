package ru.gb.perov.IntroSpringPart2.Config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import ru.gb.perov.IntroSpringPart2.Repository.UserRepository;
import ru.gb.perov.IntroSpringPart2.Security.JwtFilter;
import ru.gb.perov.IntroSpringPart2.Security.StandardAuthenticationProvider;


@EnableWebSecurity
@Configuration
@Data
public class SecurityConfig {

    @Autowired
    UserRepository userRepository;

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return webSecurity -> webSecurity.ignoring().requestMatchers(
                "/start.html",
                "/auth/token**",
                "/index.js",
                "/**");
    }

    @Bean
    public SecurityFilterChain securityFilterChain(JwtFilter filter, HttpSecurity security) throws Exception {
        return security.csrf().disable().
                authorizeHttpRequests()
                .requestMatchers("/api/**")
                .authenticated()
                .and()
                .headers().frameOptions().disable()
                .and()
                .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.builder()
                .username(request.getUserName())
                .password("password")
                .authorities("ADMIN", "MANAGER")
                .build();
        return new InMemoryUserDetailsManager(user);
//        return new JdbcUserDetailsManager(user);
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationProvider... providers) {
        return new ProviderManager(providers);
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        return new StandardAuthenticationProvider();
    }

//    @Bean
//    public JwtFilter jwtFilter() {
//        return new JwtFilter();
//    }

}
