package u_dev.parkovka.mapper.parkingSession;

import u_dev.parkovka.domain.parkingSession.ParkingSession;
import u_dev.parkovka.dto.response.session.DesignatedParkingResponse;

public interface ParkingSessionMapper {
    DesignatedParkingResponse toResponse(ParkingSession parkingSession);
}
