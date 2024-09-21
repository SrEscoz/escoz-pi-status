package net.escoz.escozpistatus.repositories;

import net.escoz.escozpistatus.entities.PiService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PiServiceRepository extends JpaRepository<PiService, Long> {
}
