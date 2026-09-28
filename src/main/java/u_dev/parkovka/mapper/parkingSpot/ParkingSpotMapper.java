package u_dev.parkovka.mapper.parkingSpot;

import u_dev.parkovka.domain.parkingSpot.ParkingSpot;
import u_dev.parkovka.dto.response.parkingSpot.CreateParkingSpotResponse;

public interface ParkingSpotMapper {
    CreateParkingSpotResponse toResponse(ParkingSpot spot);
}
