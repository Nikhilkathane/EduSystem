package edusystem.util;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers(publicMatchers()).permitAll()
                                .requestMatchers(moderatorMatchers()).hasRole("MODERATOR")
                                .requestMatchers(studentMatchers()).hasRole("STUDENT")
                                .anyRequest().authenticated()
                )
                .formLogin(withDefaults())
                .csrf(csrf -> csrf
                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()));

        return http.build();
    }

    private RequestMatcher publicMatchers() {
        return new OrRequestMatcher(
                new AntPathRequestMatcher("/public/**")
        );
    }

    private RequestMatcher moderatorMatchers() {
        return new OrRequestMatcher(
                new AntPathRequestMatcher("/moderator/**")
        );
    }

    private RequestMatcher studentMatchers() {
        return new OrRequestMatcher(
                new AntPathRequestMatcher("/student/**")
        );
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // Define user details and roles here. Replace with your actual user management logic.
        UserDetails moderator = User.withUsername("moderator")
                .password(passwordEncoder().encode("moderatorpassword"))
                .roles("MODERATOR")
                .build();
        UserDetails student = User.withUsername("student")
                .password(passwordEncoder().encode("studentpassword"))
                .roles("STUDENT")
                .build();

        return new InMemoryUserDetailsManager(moderator, student);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
