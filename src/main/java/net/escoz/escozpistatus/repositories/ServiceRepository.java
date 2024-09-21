package net.escoz.escozpistatus.repositories;

import net.escoz.escozpistatus.entities.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Long> {
}
