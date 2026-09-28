package u_dev.parkovka.controller.vehicle;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import u_dev.parkovka.config.controllers.Paths;
import u_dev.parkovka.dto.request.vehicle.CreateVehicleRequest;
import u_dev.parkovka.dto.request.vehicle.UpdateVehicleRequest;
import u_dev.parkovka.dto.response.vehicle.CreateVehicleResponse;
import u_dev.parkovka.endpoint.vehicle.VehicleEndpoint;


@RestController
@RequestMapping(Paths.VEHICLE)
@Tag(name = "Nuris millioner")
public class VehicleController {
    private VehicleEndpoint endpoint;

    public VehicleController(VehicleEndpoint endpoint) {
        this.endpoint = endpoint;
    }
    @Operation(summary = "Nuris got")
    @PostMapping("/create")
    public CreateVehicleResponse create(@Valid @RequestBody CreateVehicleRequest request){
        return endpoint.create(request);
    }

    @GetMapping("/{id}")
    public CreateVehicleResponse find(@PathVariable Integer id) {
        return endpoint.find(id);
    }

    @PutMapping("/{id}")
    public CreateVehicleResponse update(@RequestBody UpdateVehicleRequest request, @PathVariable Integer id){
        return endpoint.update(request, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        endpoint.delete(id);
    }
}
