package u_dev.parkovka.mapper.parkingSpot;

import org.springframework.stereotype.Service;
import u_dev.parkovka.domain.parkingSpot.ParkingSpot;
import u_dev.parkovka.dto.response.parkingSpot.CreateParkingSpotResponse;

@Service
public class DefaultParkingSpotMapper implements ParkingSpotMapper{

    public CreateParkingSpotResponse toResponse(ParkingSpot spot){
        CreateParkingSpotResponse response = new CreateParkingSpotResponse();
        response.setId(spot.getId());
        response.setFree(spot.getFree());
        response.setType(spot.getParkingSpotType());

        return response;
    }
}
