package net.escoz.escozpistatus.configurations;

import lombok.AllArgsConstructor;
import net.escoz.escozpistatus.services.PiUserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfiguration {

	private PiUserDetailService piUserDetailService;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http
				.authorizeHttpRequests(registry -> {
					registry.requestMatchers("/css/**", "/images/**").permitAll(); // Permitimos las peticiones a recursos estáticos
					registry.requestMatchers("/", "/login", "/error").permitAll(); // Peticiones públicas
					registry.requestMatchers("/v1/**", "/admin/**").hasRole("ADMIN"); // Peticiones privadas para el admin
				})
				.formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
				.httpBasic(Customizer.withDefaults()) // Añadimos autenticación básica para la API
				.csrf(AbstractHttpConfigurer::disable) // Deshabilitamos el CSRF para poder hacer llamadas POST
				.build();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		return piUserDetailService;
	}

	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());

		return authProvider;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
