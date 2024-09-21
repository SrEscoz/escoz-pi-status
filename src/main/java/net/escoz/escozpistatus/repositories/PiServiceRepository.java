package net.escoz.escozpistatus.repositories;

import net.escoz.escozpistatus.entities.PiService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PiServiceRepository extends JpaRepository<PiService, Long> {

	Optional<PiService> findByUrl(String url);

}
