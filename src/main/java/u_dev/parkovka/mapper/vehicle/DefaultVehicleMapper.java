package u_dev.parkovka.mapper.vehicle;

import org.springframework.stereotype.Service;
import u_dev.parkovka.domain.vehicle.Vehicle;
import u_dev.parkovka.dto.response.vehicle.CreateVehicleResponse;

@Service
public class DefaultVehicleMapper implements VehicleMapper{

    public CreateVehicleResponse toResponse(Vehicle vehicle){
        CreateVehicleResponse response = new CreateVehicleResponse();
        response.setBrand(vehicle.getBrand());
        response.setNumber(vehicle.getNumber());
        response.setId(vehicle.getId());
        response.setType(vehicle.getBrand());

        return response;
    }
}
