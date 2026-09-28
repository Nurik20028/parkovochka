package u_dev.parkovka.endpoint.vehicle;

import u_dev.parkovka.domain.vehicle.Vehicle;
import u_dev.parkovka.dto.request.vehicle.CreateVehicleRequest;
import u_dev.parkovka.dto.request.vehicle.UpdateVehicleRequest;
import u_dev.parkovka.dto.response.vehicle.CreateVehicleResponse;

public interface VehicleEndpoint {
    CreateVehicleResponse create(CreateVehicleRequest request);
    CreateVehicleResponse find(Integer id);
    CreateVehicleResponse update(UpdateVehicleRequest request, Integer id);
    void delete(Integer id);
}
