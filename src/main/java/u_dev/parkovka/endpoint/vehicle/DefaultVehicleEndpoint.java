package u_dev.parkovka.endpoint.vehicle;

import org.springframework.stereotype.Service;
import u_dev.parkovka.domain.vehicle.Vehicle;
import u_dev.parkovka.dto.request.vehicle.CreateVehicleRequest;
import u_dev.parkovka.dto.request.vehicle.UpdateVehicleRequest;
import u_dev.parkovka.dto.response.vehicle.CreateVehicleResponse;
import u_dev.parkovka.mapper.vehicle.VehicleMapper;
import u_dev.parkovka.service.vehicle.VehicleService;

@Service
public class DefaultVehicleEndpoint implements VehicleEndpoint{
    private VehicleService service;
    private VehicleMapper mapper;

    public DefaultVehicleEndpoint(VehicleService service,VehicleMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    public CreateVehicleResponse create(CreateVehicleRequest request){
        Vehicle vehicle = service.create(request);
        CreateVehicleResponse response = mapper.toResponse(vehicle);

        return response;
    }

    @Override
    public CreateVehicleResponse find(Integer id){
        Vehicle vehicle = service.find(id);
        CreateVehicleResponse response = mapper.toResponse(vehicle);

        return response;
    }

    @Override
    public CreateVehicleResponse update(UpdateVehicleRequest request, Integer id){
        Vehicle vehicle = service.update(request, id);

        return  mapper.toResponse(vehicle);
    }

    @Override
    public void delete(Integer id){
        service.delete(id);
    }

}
