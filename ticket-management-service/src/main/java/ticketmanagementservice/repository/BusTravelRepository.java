package ticketmanagementservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ticketmanagementservice.model.BusTravel;

@Repository
public interface BusTravelRepository extends JpaRepository<BusTravel, Long> {
}
