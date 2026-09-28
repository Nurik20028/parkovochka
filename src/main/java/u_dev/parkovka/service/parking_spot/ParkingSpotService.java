package u_dev.parkovka.service.parking_spot;

import u_dev.parkovka.domain.parkingSpot.ParkingSpot;
import u_dev.parkovka.dto.request.parkingSpot.CreateParkingSpotRequest;
import u_dev.parkovka.dto.request.parkingSpot.UpdateParkingSpotRequest;

public interface ParkingSpotService {
    ParkingSpot create(CreateParkingSpotRequest request);
    ParkingSpot find(Integer id);
    ParkingSpot update(UpdateParkingSpotRequest request, Integer id);
    void delete(Integer id);
}
