package u_dev.parkovka.repository.vehicle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import u_dev.parkovka.domain.vehicle.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Integer> {
}
