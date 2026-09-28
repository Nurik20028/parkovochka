package u_dev.parkovka.controller.parkingSession;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import u_dev.parkovka.config.controllers.Paths;
import u_dev.parkovka.dto.request.parkingSession.ParkRequest;
import u_dev.parkovka.endpoint.parkingSession.ParkingSessionEndpoint;

@RestController
@RequestMapping(Paths.PARKING_SESSION)
public class ParkingSessionController {
    private ParkingSessionEndpoint endpoint;

    public ParkingSessionController(ParkingSessionEndpoint endpoint) {
        this.endpoint = endpoint;
    }

    @PostMapping("/park")
    public ResponseEntity designatedParking(@Valid @RequestBody ParkRequest request){
        return ResponseEntity.ok(endpoint.park(request));
    }

    @PostMapping("/absolve_place/{placeId}")
    public ResponseEntity absolvePlace(@PathVariable Integer placeId){
        return ResponseEntity.ok(endpoint.absolvePlace(placeId));
    }
}
