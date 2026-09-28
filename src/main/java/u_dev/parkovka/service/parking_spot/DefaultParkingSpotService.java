package u_dev.parkovka.service.parking_spot;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import u_dev.parkovka.domain.parkingSpot.ParkingSpot;
import u_dev.parkovka.dto.request.parkingSpot.CreateParkingSpotRequest;
import u_dev.parkovka.dto.request.parkingSpot.UpdateParkingSpotRequest;
import u_dev.parkovka.repository.parkingSpot.ParkingSpotRepository;

@Service
public class DefaultParkingSpotService implements ParkingSpotService{

    private ParkingSpotRepository repository;

    public DefaultParkingSpotService(ParkingSpotRepository repository) {
        this.repository = repository;
    }

    public ParkingSpot create(CreateParkingSpotRequest request){
        ParkingSpot parkingSpot = new ParkingSpot();
        parkingSpot.setParkingSpotType(request.getType());
        parkingSpot.setFree(request.getFree());

        return repository.save(parkingSpot);
    }

    public ParkingSpot find(Integer id){
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("ебанушнка ?"));
    }

    public ParkingSpot update(UpdateParkingSpotRequest request, Integer id){
        ParkingSpot parkingSpot = find(id);
        if(request.getType() != null){
            parkingSpot.setParkingSpotType(request.getType());
        }
        parkingSpot.setFree(request.getFree());
        return repository.save(parkingSpot);
    }

    public void delete(Integer id){
        repository.delete(find(id));
    }
}
