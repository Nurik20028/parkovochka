package u_dev.parkovka.dto.request.parkingSpot;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import u_dev.parkovka.domain.parkingSpot.ParkingSpotType;

public class CreateParkingSpotRequest {
    @NotNull(message = "Тип парковочного места обязательна")
    private ParkingSpotType type;
    private Boolean free = true;

    public ParkingSpotType getType() {
        return type;
    }

    public void setType(ParkingSpotType type) {
        this.type = type;
    }

    public Boolean getFree() {
        return free;
    }

    public void setFree(Boolean free) {
        this.free = free;
    }
}
