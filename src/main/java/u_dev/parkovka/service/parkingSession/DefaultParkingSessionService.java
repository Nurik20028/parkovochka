package u_dev.parkovka.service.parkingSession;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import u_dev.parkovka.domain.parkingSession.ParkingSession;
import u_dev.parkovka.repository.parkingSession.ParkingSessionRepository;

@Service
public class DefaultParkingSessionService implements ParkingSessionService{
    private ParkingSessionRepository repository;

    public DefaultParkingSessionService(ParkingSessionRepository repository) {
        this.repository = repository;
    }

    public ParkingSession create(ParkingSession parkingSession){
        return repository.save(parkingSession);
    };

    public void delete(ParkingSession parkingSession){
        repository.delete(parkingSession);
    };

    public ParkingSession find(Integer id){
        return repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("такой сессии с id " + id + " нет"));
    };

    public ParkingSession update(ParkingSession session){
        ParkingSession parkingSession = find(session.getId());
        parkingSession.setPrice(session.getPrice());
        parkingSession.setBookingEnd(session.getBookingEnd());

        return repository.save(session);
    }
}
