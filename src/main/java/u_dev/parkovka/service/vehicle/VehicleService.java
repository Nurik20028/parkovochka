package u_dev.parkovka.service.vehicle;

import u_dev.parkovka.domain.vehicle.Vehicle;
import u_dev.parkovka.dto.request.vehicle.CreateVehicleRequest;
import u_dev.parkovka.dto.request.vehicle.UpdateVehicleRequest;

public interface VehicleService {
    Vehicle create(CreateVehicleRequest request);
    Vehicle find(Integer id);
    Vehicle update(UpdateVehicleRequest request, Integer id);
    void delete(Integer id);
}
