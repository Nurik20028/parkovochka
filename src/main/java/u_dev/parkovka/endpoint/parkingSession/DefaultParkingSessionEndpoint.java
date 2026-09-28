package u_dev.parkovka.endpoint.parkingSession;

import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import u_dev.parkovka.config.exeptions.sessions.SessionHasBeenCompleted;
import u_dev.parkovka.config.exeptions.sessions.SpotAlreadyOccupiedException;
import u_dev.parkovka.config.exeptions.sessions.VehicleTypeMismatchException;
import u_dev.parkovka.domain.parkingSession.ParkingSession;
import u_dev.parkovka.domain.parkingSpot.ParkingSpot;
import u_dev.parkovka.domain.vehicle.Vehicle;
import u_dev.parkovka.dto.request.parkingSession.ParkRequest;
import u_dev.parkovka.dto.request.vehicle.UpdateVehicleRequest;
import u_dev.parkovka.dto.response.session.AbsolvePlaceResponse;
import u_dev.parkovka.dto.response.session.DesignatedParkingResponse;
import u_dev.parkovka.mapper.parkingSession.ParkingSessionMapper;
import u_dev.parkovka.service.parkingSession.ParkingSessionService;
import u_dev.parkovka.service.parking_spot.ParkingSpotService;
import u_dev.parkovka.service.vehicle.VehicleService;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

@Service
public class DefaultParkingSessionEndpoint implements ParkingSessionEndpoint{
    private VehicleService vehicleService;
    private ParkingSpotService parkingSpotService;
    private ParkingSessionService service;
    private ParkingSessionMapper mapper;

    public DefaultParkingSessionEndpoint(
            VehicleService vehicleService, ParkingSpotService parkingSpotService,
            ParkingSessionService service, ParkingSessionMapper mapper) {
        this.vehicleService = vehicleService;
        this.parkingSpotService = parkingSpotService;
        this.service = service;
        this.mapper = mapper;
    }

    @Transactional
    synchronized public DesignatedParkingResponse park(ParkRequest request){
        Vehicle vehicle = vehicleService.find(request.getCarId());
        ParkingSpot parkingSpot = parkingSpotService.find(request.getParkPlaceId());

        if(!vehicle.getType().name().equals(parkingSpot.getParkingSpotType().name())){
            throw new VehicleTypeMismatchException(
                    vehicle.getType().name(),
                    parkingSpot.getParkingSpotType().name());
        }

        if(parkingSpot.getFree()){
            ParkingSession parkingSession = new ParkingSession();
            parkingSession.setVehicle(vehicle);
            parkingSession.setParkingSpot(parkingSpot);
            parkingSession.setBookingStart(LocalDateTime.now());

            parkingSpot.setFree(false);
            vehicle.setParked(true);

            return mapper.toResponse(service.create(parkingSession));
        }else{
            throw new SpotAlreadyOccupiedException(parkingSpot.getId());
        }
    }

    @Transactional
    public AbsolvePlaceResponse absolvePlace(Integer placeId){
        ParkingSession parkingSession = service.find(placeId);

        if(Objects.nonNull(parkingSession.getBookingEnd())){
            throw new SessionHasBeenCompleted(placeId.toString(), parkingSession.getBookingEnd().toString());
        }

        Vehicle vehicle = parkingSession.getVehicle();
        vehicle.setParked(false);

        parkingSession.setBookingEnd(LocalDateTime.now());
        parkingSession.setPrice(costCalculation(vehicle, parkingSession));

        UpdateVehicleRequest updateVehicle = new UpdateVehicleRequest();
        updateVehicle.setType(vehicle.getType());
        updateVehicle.setNumber(vehicle.getNumber());
        updateVehicle.setBrand(vehicle.getBrand());

        service.update(parkingSession);
        vehicleService.update(updateVehicle, vehicle.getId());

        AbsolvePlaceResponse response = new AbsolvePlaceResponse();
        response.setMessage("Машина: "+vehicle.getBrand() + " "+ vehicle.getNumber()+" убрана с парковки, цена обслуживания:" + parkingSession.getPrice());

        return response;
    }

    public BigDecimal costCalculation(Vehicle vehicle, ParkingSession parkingSession){
        Long duration = Duration.between(parkingSession.getBookingStart(), parkingSession.getBookingEnd()).toMinutes();
        BigDecimal price = vehicle.getType().getPrice().multiply(BigDecimal.valueOf(duration));
        return price;
    }
}
