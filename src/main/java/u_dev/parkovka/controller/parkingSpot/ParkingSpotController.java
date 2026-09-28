package u_dev.parkovka.controller.parkingSpot;

import org.springframework.web.bind.annotation.*;
import u_dev.parkovka.config.controllers.Paths;
import u_dev.parkovka.dto.request.parkingSpot.CreateParkingSpotRequest;
import u_dev.parkovka.dto.request.parkingSpot.UpdateParkingSpotRequest;
import u_dev.parkovka.dto.response.parkingSpot.CreateParkingSpotResponse;
import u_dev.parkovka.endpoint.parkingSpot.ParkingSpotEndpoint;

@RestController
@RequestMapping(Paths.PARKING_SPOT)
public class ParkingSpotController {
    private ParkingSpotEndpoint endpoint;

    public ParkingSpotController(ParkingSpotEndpoint endpoint) {
        this.endpoint = endpoint;
    }

    @PostMapping("/create")
    public CreateParkingSpotResponse create(@RequestBody CreateParkingSpotRequest request){
        return endpoint.create(request);
    }

    @GetMapping("/{id}")
    public CreateParkingSpotResponse find(@PathVariable Integer id){
        return endpoint.find(id);
    }

    @PutMapping("/{id}")
    public CreateParkingSpotResponse update(@RequestBody UpdateParkingSpotRequest request, @PathVariable Integer id){
        return endpoint.update(request, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        endpoint.delete(id);
    }
}
