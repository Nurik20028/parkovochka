package u_dev.parkovka.dto.response.session;

import java.time.LocalDateTime;

public class DesignatedParkingResponse {
    private String message;
    private Integer parkingPlaceId;
    private Integer carId;
    private LocalDateTime parkedAt;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getParkingPlaceId() {
        return parkingPlaceId;
    }

    public void setParkingPlaceId(Integer parkingPlaceId) {
        this.parkingPlaceId = parkingPlaceId;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public LocalDateTime getParkedAt() {
        return parkedAt;
    }

    public void setParkedAt(LocalDateTime parkedAt) {
        this.parkedAt = parkedAt;
    }
}
