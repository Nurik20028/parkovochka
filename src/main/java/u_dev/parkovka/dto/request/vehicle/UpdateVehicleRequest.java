package u_dev.parkovka.dto.request.vehicle;

import u_dev.parkovka.domain.vehicle.VehicleType;

public class UpdateVehicleRequest {
    private VehicleType type;
    private String number;
    private String brand;

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
