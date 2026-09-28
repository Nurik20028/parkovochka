package u_dev.parkovka.mapper.parkingSession;

import org.springframework.stereotype.Service;
import u_dev.parkovka.domain.parkingSession.ParkingSession;
import u_dev.parkovka.dto.response.session.DesignatedParkingResponse;

@Service
public class DefaultParkingSessionMapper implements ParkingSessionMapper{
    public DesignatedParkingResponse toResponse(ParkingSession parkingSession){
        DesignatedParkingResponse response = new DesignatedParkingResponse();
        response.setCarId(parkingSession.getVehicle().getId());
        response.setParkedAt(parkingSession.getBookingStart());
        response.setParkingPlaceId(response.getParkingPlaceId());
        response.setMessage("Все норм, парковка успешна!");

        return response;
    }

}
