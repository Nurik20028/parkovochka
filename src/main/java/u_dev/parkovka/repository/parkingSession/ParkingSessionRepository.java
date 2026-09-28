package u_dev.parkovka.repository.parkingSession;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import u_dev.parkovka.domain.parkingSession.ParkingSession;

@Repository
public interface ParkingSessionRepository extends JpaRepository<ParkingSession, Integer> {
}
