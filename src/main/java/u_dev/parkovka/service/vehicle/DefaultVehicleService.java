package u_dev.parkovka.service.vehicle;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import u_dev.parkovka.domain.vehicle.Vehicle;
import u_dev.parkovka.dto.request.vehicle.CreateVehicleRequest;
import u_dev.parkovka.dto.request.vehicle.UpdateVehicleRequest;
import u_dev.parkovka.repository.vehicle.VehicleRepository;

import java.util.Objects;

@Service
public class DefaultVehicleService implements VehicleService{

    private VehicleRepository repository;

    public DefaultVehicleService(VehicleRepository repository) {
        this.repository = repository;
    }

    @Override
    public Vehicle create(CreateVehicleRequest request){
        Vehicle vehicle = new Vehicle();
        vehicle.setBrand(request.getBrand());
        vehicle.setNumber(request.getNumber());
        vehicle.setType(request.getType());

        return repository.save(vehicle);
    }

    @Override
    public Vehicle find(Integer id){
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Объект по id - " + id + " не найден"));
    }

    @Override
    public Vehicle update(UpdateVehicleRequest request, Integer id){
        Vehicle vehicle = find(id);
        if(request.getBrand() != null && !Objects.equals(request.getBrand(), "")){
            vehicle.setBrand(request.getBrand());
        }
        if(request.getNumber() != null && !Objects.equals(request.getNumber(), "")){
            vehicle.setNumber(request.getNumber());
        }
        if(request.getNumber() != null){
            vehicle.setType(request.getType());
        }

        return repository.save(vehicle);
    }

    @Override
    public void delete(Integer id){
        Vehicle vehicle = find(id);

        repository.delete(vehicle);
    }


}
