package u_dev.parkovka.service.parkingSession;

import u_dev.parkovka.domain.parkingSession.ParkingSession;

public interface ParkingSessionService {
    ParkingSession create(ParkingSession parkingSession);
    void delete(ParkingSession parkingSession);
    ParkingSession find(Integer id);
    ParkingSession update(ParkingSession session);
}
