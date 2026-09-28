package u_dev.parkovka.endpoint.parkingSpot;

import u_dev.parkovka.dto.request.parkingSpot.CreateParkingSpotRequest;
import u_dev.parkovka.dto.request.parkingSpot.UpdateParkingSpotRequest;
import u_dev.parkovka.dto.response.parkingSpot.CreateParkingSpotResponse;

public interface ParkingSpotEndpoint {
    CreateParkingSpotResponse create(CreateParkingSpotRequest request);
    CreateParkingSpotResponse find(Integer id);
    CreateParkingSpotResponse update(UpdateParkingSpotRequest request, Integer id);
    void delete(Integer id);
}
