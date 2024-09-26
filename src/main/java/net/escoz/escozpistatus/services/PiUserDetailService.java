package net.escoz.escozpistatus.services;

import lombok.AllArgsConstructor;
import net.escoz.escozpistatus.entities.PiUser;
import net.escoz.escozpistatus.repositories.PiUserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PiUserDetailService implements UserDetailsService {

	private PiUserRepository piUserRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		PiUser piUser = piUserRepository
				.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException(username));

		return User.builder()
				.username(piUser.getUsername())
				.password(piUser.getPassword())
				.roles(piUser.getRole())
				.build();
	}
}
