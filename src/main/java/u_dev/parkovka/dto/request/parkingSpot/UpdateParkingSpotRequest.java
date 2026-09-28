package u_dev.parkovka.dto.request.parkingSpot;

import u_dev.parkovka.domain.parkingSpot.ParkingSpotType;

public class UpdateParkingSpotRequest {
    private ParkingSpotType type;
    private Boolean free;

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
