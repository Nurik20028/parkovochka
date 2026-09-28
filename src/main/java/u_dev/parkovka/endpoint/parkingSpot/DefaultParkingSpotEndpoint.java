package u_dev.parkovka.endpoint.parkingSpot;

import org.springframework.stereotype.Service;
import u_dev.parkovka.domain.parkingSpot.ParkingSpot;
import u_dev.parkovka.dto.request.parkingSpot.CreateParkingSpotRequest;
import u_dev.parkovka.dto.request.parkingSpot.UpdateParkingSpotRequest;
import u_dev.parkovka.dto.response.parkingSpot.CreateParkingSpotResponse;
import u_dev.parkovka.mapper.parkingSpot.ParkingSpotMapper;
import u_dev.parkovka.service.parking_spot.ParkingSpotService;

@Service
public class DefaultParkingSpotEndpoint implements ParkingSpotEndpoint{
    private ParkingSpotService service;
    private ParkingSpotMapper mapper;

    public DefaultParkingSpotEndpoint(ParkingSpotService service, ParkingSpotMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    public CreateParkingSpotResponse create(CreateParkingSpotRequest request){
        ParkingSpot parkingSpot = service.create(request);
        return mapper.toResponse(parkingSpot);
    }

    public CreateParkingSpotResponse find(Integer id){
        ParkingSpot parkingSpot = service.find(id);
        return mapper.toResponse(parkingSpot);
    }

    public CreateParkingSpotResponse update(UpdateParkingSpotRequest request, Integer id){
        ParkingSpot parkingSpot = service.update(request, id);

        return mapper.toResponse(parkingSpot);
    }

    public void delete(Integer id){
        service.delete(id);
    }
}
