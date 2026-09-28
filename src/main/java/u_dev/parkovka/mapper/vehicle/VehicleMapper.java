package u_dev.parkovka.mapper.vehicle;

import u_dev.parkovka.domain.vehicle.Vehicle;
import u_dev.parkovka.dto.response.vehicle.CreateVehicleResponse;

public interface VehicleMapper {
    CreateVehicleResponse toResponse(Vehicle vehicle);
}
