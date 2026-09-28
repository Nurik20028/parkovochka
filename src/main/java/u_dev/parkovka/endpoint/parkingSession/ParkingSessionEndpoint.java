package u_dev.parkovka.endpoint.parkingSession;

import u_dev.parkovka.dto.request.parkingSession.ParkRequest;
import u_dev.parkovka.dto.response.session.AbsolvePlaceResponse;
import u_dev.parkovka.dto.response.session.DesignatedParkingResponse;

public interface ParkingSessionEndpoint {
    DesignatedParkingResponse park(ParkRequest request);
    AbsolvePlaceResponse absolvePlace(Integer placeId);
}
