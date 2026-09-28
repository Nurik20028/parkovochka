package u_dev.parkovka.dto.request.parkingSession;

import jakarta.validation.constraints.NotNull;

public class ParkRequest {
    @NotNull
    private Integer carId;
    @NotNull
    private Integer parkPlaceId;

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public Integer getParkPlaceId() {
        return parkPlaceId;
    }

    public void setParkPlaceId(Integer parkPlaceId) {
        this.parkPlaceId = parkPlaceId;
    }
}
