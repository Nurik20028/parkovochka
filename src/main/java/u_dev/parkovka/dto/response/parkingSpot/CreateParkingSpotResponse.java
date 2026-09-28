package u_dev.parkovka.dto.response.parkingSpot;

import u_dev.parkovka.domain.parkingSpot.ParkingSpotType;

public class CreateParkingSpotResponse {
    private Integer id;
    private ParkingSpotType type;
    private Boolean free;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
