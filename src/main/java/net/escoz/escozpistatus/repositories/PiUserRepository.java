package net.escoz.escozpistatus.repositories;

import net.escoz.escozpistatus.entities.PiUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PiUserRepository extends JpaRepository<PiUser, Long> {

	Optional<PiUser> findByUsername(String username);
}
